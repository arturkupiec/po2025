module org.example.samgui {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;
    //requires org.example.samgui;


    opens org.example.samgui to javafx.fxml;
    exports org.example.samgui;
}