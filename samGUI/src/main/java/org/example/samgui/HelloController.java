package org.example.samgui;
import org.example.samgui.symulator.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.w3c.dom.Text;

public class HelloController {
    public Button startButton;
    public Button upGearButton;
    public TextField biegTextField;
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public void onStart(ActionEvent actionEvent) {
        System.out.println("lubudubu");
        startButton.setText("Stop");
    }


    Silnik silnik = new Silnik(5000, 0, "FSO", "poldek");
    SkrzyniaBiegow skrzynia = new SkrzyniaBiegow("FSO","poldek", 5);
    Sprzeglo sprzeglo = new Sprzeglo("FSO", "poldek", false);
    Pozycja pozycja = new Pozycja(0, 0);

    Samochod poldek = new Samochod(silnik, skrzynia, sprzeglo, pozycja);
    public void upGear(ActionEvent actionEvent) {
        poldek.skrzynia.zwiekszBieg();
        refresh();
    }

    public TextField modelTextField;
    void refresh(){
        modelTextField.setText(String.valueOf(silnik.getModel()));
        biegTextField.setText(String.valueOf(skrzynia.getAktualnyBieg()));
    }

}
