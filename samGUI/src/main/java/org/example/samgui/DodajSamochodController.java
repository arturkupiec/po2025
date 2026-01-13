package org.example.samgui;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.samgui.symulator.*;
import org.example.samgui.Listener;
import java.sql.SQLOutput;

import static java.util.Collections.copy;

public class DodajSamochodController {

    public Button anulujButton;
    public Button zatwierdzButton;
    public ComboBox wybierzSilnikComboBox;
    public ComboBox wybierzSkrzynieComboBox;
    @FXML
    private TextField modelTextField;
    @FXML
    private TextField nrRejestracjiTextField;
    @FXML
    private TextField wagaTextField;
    @FXML
    private TextField predkoscTextField;
    private ObservableList<Silnik> silniki;
    private ObservableList<SkrzyniaBiegow> skrzynie;
    private ObservableList<Samochod> samochody;
    @FXML

    String model;
    String nrRejestracji;
    int waga;
    int predkosc;


    public void onSubmit(ActionEvent actionEvent) {
        try {
            String model = modelTextField.getText();
            String nrRejestracji = nrRejestracjiTextField.getText();
            int waga = Integer.parseInt(wagaTextField.getText());
            int predkosc = Integer.parseInt(predkoscTextField.getText());
            System.out.println("Model: " + model);
            System.out.println("Nr rejestracyjny: " + nrRejestracji);
            System.out.println("Waga: " + waga);
            System.out.println("Prędkość maksymalna: " + predkosc);

            Sprzeglo sprzeglo = new Sprzeglo("default_producent", "default_model", false, 999999, 999999, "standardowe sprzeglo");
            Pozycja pozycja = new Pozycja(0, 0);
            Silnik wybranySilnik = (Silnik) wybierzSilnikComboBox.getValue();
            Silnik uzywanysilnik = new Silnik(wybranySilnik);

            if (uzywanysilnik == null){
                System.out.println("auto bez silnika ty madry ty jestes?? od nowa rob");
                return;
            }
            SkrzyniaBiegow wybranaSkrzynia = (SkrzyniaBiegow) wybierzSkrzynieComboBox.getValue();
            SkrzyniaBiegow uzywanaSkrzynia = new SkrzyniaBiegow((wybranaSkrzynia));
            if (wybranaSkrzynia == null){
                System.out.println("auto bez skrzyni ty madry ty jestes?? rob od nowa");
                return;
            }
            Samochod nowySamochod = new Samochod(model, predkosc, waga, nrRejestracji, uzywanysilnik, uzywanaSkrzynia, pozycja, sprzeglo);
            Samochod_GUI_Controller.samochody.add(nowySamochod);
            System.out.println(samochody);
            Stage stage = (Stage) zatwierdzButton.getScene().getWindow();
            stage.close();
        }
        catch (NumberFormatException e){
            System.out.println("model i nr rejestracyjny - ciag znakow, waga i predkosc maksymalna - liczba calkowita");
            return;
        }


    }
    public void setSilniki(ObservableList<Silnik> silniki) {
        this.silniki = silniki;
        wybierzSilnikComboBox.setItems(silniki);

    }
    public void setSkrzynie(ObservableList<SkrzyniaBiegow> skrzynie){
        this.skrzynie = skrzynie;
        wybierzSkrzynieComboBox.setItems(skrzynie);
    }




    @FXML
    public void onCancel(ActionEvent actionEvent) {
        System.out.println("Formularz anulowany");
        Stage stage = (Stage) anulujButton.getScene().getWindow();
        stage.close();
        
    }

}