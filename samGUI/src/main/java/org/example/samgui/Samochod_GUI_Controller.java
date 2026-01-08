package org.example.samgui;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.example.samgui.symulator.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;

import java.util.Objects;

import javafx.animation.AnimationTimer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Samochod_GUI_Controller implements Listener{
    @Override
    public void update(){
        //refresh();
        Platform.runLater(this::refresh);
    }
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
    public AnchorPane mapa;
    public Button usunSamochod;
        @FXML
    private Label welcomeText;
    @FXML
    private ImageView carImageView;
    private Samochod samochod;
    private double targetX;
    private double targetY;

    private AnimationTimer carTimer;

    @FXML
    private ComboBox<Samochod> carComboBox;
    protected static ObservableList<Samochod> samochody = FXCollections.observableArrayList();
    private ObservableList<Silnik> silniki = FXCollections.observableArrayList();
    private ObservableList<SkrzyniaBiegow> skrzynie = FXCollections.observableArrayList();

    public ObservableList<Silnik> getSilniki() {
        return silniki;
    }
    public ObservableList<SkrzyniaBiegow> getSkrzynia(){return skrzynie;}



    public void onStart(ActionEvent actionEvent) {
        System.out.println("lubudubu");
        samochod.uruchom();
    }

    public void onStop(ActionEvent actionEvent) {
        samochod.zatrzymaj();
    }
    //public SkrzyniaBiegow(String producent, String model, int iloscBiegow, int cena, int waga, String nazwa){
    //==================================tworzenie podstawowego auta============================================
    Silnik silnik_poldek = new Silnik(5000, 0, "FSO", "poldek", 10000, 500, "V8");
    SkrzyniaBiegow skrzynia_poldek = new SkrzyniaBiegow("FSO","polonez", 5, 20, 15, "polderium skrzynia bieguw");
    Sprzeglo sprzeglo_poldek = new Sprzeglo("FSO", "poldek", false, 2000, 15, "sprzegielko");
    Pozycja pozycja = new Pozycja(0, 0);

    Samochod poldek = new Samochod(silnik_poldek, skrzynia_poldek, sprzeglo_poldek, pozycja, "K1 N1GA");


    @FXML
    public void upGear(ActionEvent actionEvent) {
        samochod.zwiekszBieg();
    }
    public void downGear(ActionEvent actionEvent){
        samochod.zmniejszBieg();
    }
    void refresh(){
        // ====================================== sekcja samochod =======================================
        modelTextField.setText(String.valueOf(samochod.toString()));
        nrRejestracjiTextField.setText(samochod.getNrRejestracji());
        predkoscTextField.setText(String.valueOf(samochod.obliczPredkosc()));
        // ====================================== sekcja skrzynia =======================================
        nazwaSkrzyniTextField.setText(samochod.getNazwaSkrzynia());
        cenaSkrzyniTextField.setText(String.valueOf(samochod.getCenaSkrzynia()));
        wagaSkrzyniTextField.setText(String.valueOf(samochod.getWagaSkrzynia()));
        biegTextField.setText(String.valueOf(samochod.getAktualnyBieg()));
        // ===================================== sekcja silnik ==========================================
        nazwaSilnikaTextField.setText(samochod.getNazwaSilnik());
        cenaSilnikaTextField.setText(String.valueOf(samochod.getCenaSilnik()));
        wagaSilnikaTextField.setText(String.valueOf(samochod.getWagaSilnik()));
        obrotySilnikaTextField.setText(String.valueOf(samochod.getAktualneObroty()));
        // ===================================== sekcja sprzegielko ====================================
        nazwaSprzeglaTextField.setText(samochod.getNazwaSprzeglo());
        cenaSprzeglaTextField.setText(String.valueOf(samochod.getCenaSprzeglo()));
        wagaSprzeglaTextField.setText(String.valueOf(samochod.getWagaSprzeglo()));
        stanSprzeglaTextField.setText(String.valueOf(samochod.getStanSprzeglaString()));
        wagaSamochoduTextFeld.setText(String.valueOf(samochod.getWagaSamochodu()));

        Platform.runLater(() -> {
            carImageView.setTranslateX(samochod.getX());
            carImageView.setTranslateY(samochod.getY());
        });

    }


    public void upCluth(ActionEvent actionEvent){samochod.wcisnij();}
    public void downCluth(ActionEvent actionEvent){samochod.zwolnij();}

    public void upSpeed(ActionEvent actionEvent){samochod.zwiekszObroty();}
    public void downSpeed(ActionEvent actionEvent){samochod.zmniejszObroty();}

    @FXML
    public void initialize() {

        samochody.add(poldek);
        samochod = poldek;
        samochod.addListener(this);
        carComboBox.setItems(samochody);
        carComboBox.getSelectionModel().select(poldek);
        refresh();


        carComboBox.setOnAction(e -> {
            samochod = carComboBox.getValue();
            samochod.addListener(this);
            refresh();
        });


        Image carImage = new Image(Objects.requireNonNull(getClass().getResource("/car_icon.jpg")).toExternalForm());

        System.out.println("Image width: " + carImage.getWidth() + ", height: " + carImage.getHeight());

        carImageView.setImage(carImage);
        carImageView.setFitWidth(200);
        carImageView.setFitHeight(100);
        carImageView.setTranslateX(0);
        carImageView.setTranslateY(0);


        carComboBox.setItems(samochody);



        silniki.add(silnik_poldek);
        skrzynie.add(skrzynia_poldek);

        Silnik tdi_1_9 = new Silnik(6000, 0, "Szkoda", "suberp", 5000, 800, "1.9 tdi" );
        silniki.add(tdi_1_9);

        SkrzyniaBiegow ZF_6HP = new SkrzyniaBiegow("WIMIR", "ZF 6HP", 6, 5000, 60, "ZF 6HP");
        skrzynie.add(ZF_6HP);

        mapa.setOnMouseClicked(event -> {
            double x = event.getX();
            double y = event.getY();
            Pozycja nowaPozycja = new Pozycja(x, y);
            samochod.jedzDo(nowaPozycja);



        });


    }


        @FXML
        public void onOpenAddCarForm(ActionEvent event) {
            try {
                FXMLLoader loader = new FXMLLoader(
                        getClass().getResource("/DodajSamochod.fxml")
                );

                Parent root = loader.load();

                DodajSamochodController controller = loader.getController();
                controller.setSilniki(this.silniki);
                controller.setSkrzynie(this.skrzynie);
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        public void onUsunSamochod(ActionEvent actionEvent) {
            samochody.remove(samochod);
            carComboBox.getSelectionModel().selectFirst();
        }

        public void pokazBlad(String wiadomosc) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Błąd");
            alert.setHeaderText(null);
            alert.setContentText(wiadomosc);
            alert.showAndWait();
        }
}