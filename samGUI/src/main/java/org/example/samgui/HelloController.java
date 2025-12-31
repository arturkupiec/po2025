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

import java.util.Objects;

import javafx.animation.AnimationTimer;
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
    private ObservableList<Silnik> silniki = FXCollections.observableArrayList();


    public ObservableList<Silnik> getSilniki() {
        return silniki;
    }


    public void onStart(ActionEvent actionEvent) {
        System.out.println("lubudubu");
        poldek.uruchom();
        refresh();
        //startButton.setText("Stop");
    }

    public void onStop(ActionEvent actionEvent) {
        poldek.zatrzymaj();
        refresh();
    }

    Silnik silnik_poldek = new Silnik(5000, 0, "FSO", "poldek", 10000, 500, "V8");
    SkrzyniaBiegow skrzynia = new SkrzyniaBiegow("FSO","poldek", 5, 3000, 50, "skrzyneczka");
    Sprzeglo sprzeglo = new Sprzeglo("FSO", "poldek", false, 2000, 15, "sprzegielko");
    Pozycja pozycja = new Pozycja(0, 0);

    Samochod poldek = new Samochod(silnik_poldek, skrzynia, sprzeglo, pozycja, "K1 N1GA");
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
        modelTextField.setText(String.valueOf(silnik_poldek.getModel()));
        nrRejestracjiTextField.setText(poldek.getNrRejestracji());
        predkoscTextField.setText(String.valueOf(poldek.obliczPredkosc()));
        // ====================================== sekcja skrzynia =======================================
        nazwaSkrzyniTextField.setText(poldek.getNazwaSkrzynia());
        cenaSkrzyniTextField.setText(String.valueOf(poldek.getCenaSkrzynia()));
        wagaSkrzyniTextField.setText(String.valueOf(poldek.getWagaSkrzynia()));
        biegTextField.setText(String.valueOf(poldek.getAktualnyBieg()));
        // ===================================== sekcja silnik ==========================================
        nazwaSilnikaTextField.setText(poldek.getNazwaSilnik());
        cenaSilnikaTextField.setText(String.valueOf(poldek.getCenaSilnik()));
        wagaSilnikaTextField.setText(String.valueOf(poldek.getWagaSilnik()));
        obrotySilnikaTextField.setText(String.valueOf(poldek.getAktualneObroty()));
        // ===================================== sekcja sprzegielko ====================================
        nazwaSprzeglaTextField.setText(poldek.getNazwaSprzeglo());
        cenaSprzeglaTextField.setText(String.valueOf(poldek.getCenaSprzeglo()));
        wagaSprzeglaTextField.setText(String.valueOf(poldek.getWagaSprzeglo()));
        stanSprzeglaTextField.setText(String.valueOf(poldek.getStanSprzeglaString()));
        wagaSamochoduTextFeld.setText(String.valueOf(poldek.getWagaSamochodu()));
    }


    public void upCluth(ActionEvent actionEvent){poldek.wcisnij(); refresh();}
    public void downCluth(ActionEvent actionEvent){poldek.zwolnij(); refresh();}

    public void upSpeed(ActionEvent actionEvent){poldek.zwiekszObroty();refresh();}
    public void downSpeed(ActionEvent actionEvent){poldek.zmniejszObroty();refresh();}

    @FXML //nie ruszac bo nie wiem co tu sie dzieje wczesniej dzialalo bez tego ale teraz tez dziala moze to okresla wymiary i wogle jak to tne nie wiem :OO
    public void initialize() {
        refresh();

        Image carImage = new Image(Objects.requireNonNull(getClass().getResource("/car_icon.jpg")).toExternalForm());

        System.out.println("Image width: " + carImage.getWidth() + ", height: " + carImage.getHeight());

        carImageView.setImage(carImage);
        carImageView.setFitWidth(200);
        carImageView.setFitHeight(100);
        carImageView.setTranslateX(0);
        carImageView.setTranslateY(0);

        samochody.add(poldek); // ten startowy
        carComboBox.setItems(samochody);

        silniki.add(silnik_poldek);



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

        } catch (Exception e) {
            //e.printStackTrace();
            // Obsługuje wyjątek IO (np. plik FXML nie zostanie znaleziony)

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
                    stop();
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

        //startDriving();
    }

}