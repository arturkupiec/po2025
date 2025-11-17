module org.example.samgui {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.samgui to javafx.fxml;
    exports org.example.samgui;
}