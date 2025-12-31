package org.example.samgui;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.samgui.symulator.Silnik;

public class DodajSamochodController {

    public Button anulujButton;
    public Button zatwierdzButton;
    public ComboBox wybierzSilnikComboBox;
    public ComboBox wybierzSkrznieComboBox;
    @FXML
    private TextField modelTextField;
    @FXML
    private TextField nrRejestracjiTextField;
    @FXML
    private TextField wagaTextField;
    @FXML
    private TextField predkoscTextField;
    private ObservableList<Silnik> silniki;
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
            System.out.println("udalo sie ;D" );
        }
        catch (NumberFormatException e){
            System.out.println("model i nr rejestracyjny - ciag znakow, waga i predkosc maksymalna - liczba calkowita");
            return;
        }
        /*HelloController.samochody.add(model, nrRejestracji, waga, predkosc);
        Stage stage = (Stage) zatwierdzButton.getScene().getWindow();
        stage.close();
        */

    }
    public void setSilniki(ObservableList<Silnik> silniki) {
        this.silniki = silniki;
        wybierzSilnikComboBox.setItems(silniki);
    }

    @FXML   //dlaczego zamykanie okna musi byc takie trudne :O :O
    public void onCancel(ActionEvent actionEvent) {
        System.out.println("Formularz anulowany");
        Stage stage = (Stage) anulujButton.getScene().getWindow();
        stage.close();
        
    }

}