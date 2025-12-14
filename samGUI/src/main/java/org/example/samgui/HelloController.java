package org.example.samgui;
import javafx.scene.input.MouseEvent;
import org.example.samgui.symulator.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javax.swing.*;
import java.io.IOException;
import javafx.animation.AnimationTimer;
import javafx.scene.input.MouseEvent;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;

public class HelloController {
    public Button startButton;
    public Button upGearButton;
    public TextField biegTextField;
    public TextField nrRejestracjiTextField;
    public TextField modelTextField;
    public TextField nazwaSkrzyniTextField;
    public TextField cenaSkrzyniTextField;
    public TextField wagaSkrzyniTextField;
    public TextField nazwaSilnikaTextField;
    public TextField cenaSilnikaTextField;
    public TextField wagaSilnikaTextField;
    public TextField obrotySilnikaTextField;
    public TextField nazwaSprzeglaTextField;
    public TextField cenaSprzeglaTextField;
    public TextField wagaSprzeglaTextField;
    public TextField stanSprzeglaTextField;
    public Button downGearButton;
    public Button upCluthButton;
    public Button downCluthButton;
    public Button upSpeed;
    public Button downSpeed;
    public TextField wagaSamochoduTextFeld;
    public TextField predkoscTextField;
    @FXML
    private Label welcomeText;
    @FXML
    private ImageView carImageView;

    private double targetX;
    private double targetY;

    private AnimationTimer carTimer;

    @FXML
    private ComboBox<Samochod> carComboBox;
    private ObservableList<Samochod> samochody = FXCollections.observableArrayList();

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public void onStart(ActionEvent actionEvent) {
        System.out.println("lubudubu");
        startButton.setText("Stop");
    }

    Silnik silnik = new Silnik(5000, 0, "FSO", "poldek", 10000, 500, "V8");
    SkrzyniaBiegow skrzynia = new SkrzyniaBiegow("FSO","poldek", 5, 3000, 50, "skrzyneczka");
    Sprzeglo sprzeglo = new Sprzeglo("FSO", "poldek", false, 2000, 15, "sprzegielko");
    Pozycja pozycja = new Pozycja(0, 0);

    Samochod poldek = new Samochod(silnik, skrzynia, sprzeglo, pozycja, "K1 N1GA");
    @FXML


    public void upGear(ActionEvent actionEvent) {
        poldek.zwiekszBieg();
        refresh();
    }
    public void downGear(ActionEvent actionEvent){
        poldek.zmniejszBieg();
        refresh();
    }
    void refresh(){
        // ====================================== sekcja samochod =======================================
        modelTextField.setText(String.valueOf(silnik.getModel()));
        nrRejestracjiTextField.setText(poldek.getNrRejestracji());
        predkoscTextField.setText(String.valueOf(poldek.obliczPredkosc()));
        // ====================================== sekcja skrzynia =======================================
        nazwaSkrzyniTextField.setText(poldek.skrzynia.getNazwa());
        cenaSkrzyniTextField.setText(String.valueOf(poldek.skrzynia.getCena()));
        wagaSkrzyniTextField.setText(String.valueOf(poldek.skrzynia.getWaga()));
        biegTextField.setText(String.valueOf(skrzynia.getAktualnyBieg()));
        // ===================================== sekcja silnik ==========================================
        nazwaSilnikaTextField.setText(poldek.silnik.getNazwa());
        cenaSilnikaTextField.setText(String.valueOf(poldek.silnik.getCena()));
        wagaSilnikaTextField.setText(String.valueOf(poldek.silnik.getWaga()));
        obrotySilnikaTextField.setText(String.valueOf(poldek.silnik.getObroty()));
        // ===================================== sekcja sprzegielko ====================================
        nazwaSprzeglaTextField.setText(poldek.sprzeglo.getNazwa());
        cenaSprzeglaTextField.setText(String.valueOf(poldek.sprzeglo.getCena()));
        wagaSprzeglaTextField.setText(String.valueOf(poldek.sprzeglo.getWaga()));
        stanSprzeglaTextField.setText(String.valueOf(poldek.sprzeglo.getStanSprzeglaString()));
        wagaSamochoduTextFeld.setText(String.valueOf(poldek.getWagaSamochodu()));
    }


    public void upCluth(ActionEvent actionEvent){poldek.sprzeglo.wcisnij(); refresh();}
    public void downCluth(ActionEvent actionEvent){poldek.sprzeglo.zwolnij(); refresh();}

    public void upSpeed(ActionEvent actionEvent){poldek.silnik.zwiekszObroty();refresh();}
    public void downSpeed(ActionEvent actionEvent){poldek.silnik.zmniejszObroty();refresh();}

    @FXML //nie ruszac bo nie wiem co tu sie dzieje wczesniej dzialalo bez tego ale teraz tez dziala moze to okresla wymiary i wogle jak to tne nie wiem :OO
    public void initialize() {
        refresh();
        System.out.println("HelloController initialized");


        Image carImage = new Image(getClass().getResource("/car_icon.jpg").toExternalForm());

        System.out.println("Image width: " + carImage.getWidth() + ", height: " + carImage.getHeight());

        carImageView.setImage(carImage);
        carImageView.setFitWidth(200);
        carImageView.setFitHeight(100);
        carImageView.setTranslateX(0);
        carImageView.setTranslateY(0);

        samochody.add(poldek); // ten startowy
        carComboBox.setItems(samochody);

        carComboBox.setOnAction(e -> {
            Samochod s = carComboBox.getValue();
            if (s != null) {
                poldek = s;
                refresh();
            }
        });
    }


    @FXML
    public void onOpenAddCarForm(ActionEvent event) {
        try {
            HelloApplication app = new HelloApplication();
            app.openAddCarForm();  // Wywołanie metody otwierającej okno
        } catch (IOException e) {
            e.printStackTrace();  // Obsługuje wyjątek IO (np. plik FXML nie zostanie znaleziony)
        }
    }

    private void startDriving() {

        if (carTimer != null) {
            carTimer.stop();
        }

        carTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {

                double x = carImageView.getTranslateX();
                double y = carImageView.getTranslateY();

                double dx = targetX - x;
                double dy = targetY - y;

                double distance = Math.sqrt(dx * dx + dy * dy);

                if (distance < 2) {
                    stop(); // dojechaliśmy
                    System.out.println("Dojechano");
                    return;
                }

                double speed = (poldek.obliczPredkosc()/10);
                System.out.println(speed);
                double stepX = (dx / distance) * speed;
                double stepY = (dy / distance) * speed;

                carImageView.setTranslateX(x + stepX);
                carImageView.setTranslateY(y + stepY);

                // aktualizacja logiki pozycji samochodu
                pozycja.aktualizujPozycje(stepX, stepY);
            }
        };

        carTimer.start();
    }

    @FXML
    public void onMapClick(MouseEvent event) {

        targetX = event.getX();
        targetY = event.getY();

        System.out.println("Kliknięto cel: " + targetX + ", " + targetY);

        startDriving();
    }
}