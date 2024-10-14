module org.hugo.ejerciciob {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.hugo.ejerciciob to javafx.fxml;
    exports org.hugo.ejerciciob;
}