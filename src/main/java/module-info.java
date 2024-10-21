module org.hugo.ejerciciob {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens org.hugo.ejerciciob to javafx.fxml;
    exports org.hugo.ejerciciob;
}