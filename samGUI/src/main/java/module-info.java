module org.example.samgui {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.example.samgui;


    opens org.example.samgui to javafx.fxml;
    exports org.example.samgui;
}