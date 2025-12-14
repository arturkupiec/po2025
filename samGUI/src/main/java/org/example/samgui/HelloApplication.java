package org.example.samgui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
    public void openAddCarForm() throws IOException {
        // Załaduj formularz z DodajSamochod.fxml
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("/DodajSamochod.fxml"));
        Scene scene = new Scene(loader.load(), 400, 300);  // Ustaw odpowiedni rozmiar okna
        Stage stage = new Stage();
        stage.setTitle("Dodaj Nowy Samochód");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
