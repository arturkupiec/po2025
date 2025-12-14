package org.example.samgui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class DodajSamochodController {

    @FXML
    private TextField modelTextField;
    @FXML
    private TextField nrRejestracjiTextField;
    @FXML
    private TextField wagaTextField;
    @FXML
    private TextField predkoscTextField;

    // Metoda wywoływana po kliknięciu przycisku "Zatwierdź"
    @FXML
    public void onSubmit(ActionEvent actionEvent) {
        String model = modelTextField.getText();
        String nrRejestracji = nrRejestracjiTextField.getText();
        String waga = wagaTextField.getText();
        String predkosc = predkoscTextField.getText();

        System.out.println("Model: " + model);
        System.out.println("Nr rejestracyjny: " + nrRejestracji);
        System.out.println("Waga: " + waga);
        System.out.println("Prędkość maksymalna: " + predkosc);

    }


    @FXML
    public void onCancel(ActionEvent actionEvent) {
        System.out.println("Formularz anulowany");
    }
}