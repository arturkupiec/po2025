package org.example.samgui;
import org.example.samgui.symulator.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.w3c.dom.Text;

import javax.swing.*;

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

    Silnik silnik = new Silnik(5000, 0, "FSO", "poldek", 10000, 500, "V8");
    SkrzyniaBiegow skrzynia = new SkrzyniaBiegow("FSO","poldek", 5, 3000, 50, "skrzyneczka");
    Sprzeglo sprzeglo = new Sprzeglo("FSO", "poldek", false, 2000, 15, "sprzegielko");
    Pozycja pozycja = new Pozycja(0, 0);

    Samochod poldek = new Samochod(silnik, skrzynia, sprzeglo, pozycja, "K1 N1GA");
    @FXML
    public void initialize(){
        refresh();
    }

    public void upGear(ActionEvent actionEvent) {
        poldek.skrzynia.zwiekszBieg();
        refresh();
    }
    public void downGear(ActionEvent actionEvent){
        poldek.skrzynia.zmniejszBieg();
        refresh();
    }
    void refresh(){
        // ====================================== sekcja samochod =======================================
        modelTextField.setText(String.valueOf(silnik.getModel()));
        nrRejestracjiTextField.setText(poldek.getNrRejestracji());
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
    }


    public void upCluth(ActionEvent actionEvent){poldek.sprzeglo.wcisnij(); refresh();}
    public void downCluth(ActionEvent actionEvent){poldek.sprzeglo.zwolnij(); refresh();}

    public void upSpeed(ActionEvent actionEvent){poldek.silnik.zwiekszObroty();refresh();}
    public void downSpeed(ActionEvent actionEvent){poldek.silnik.zmniejszObroty();refresh();}
}
