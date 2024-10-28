module org.hugo.ejerciciob {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    opens Model to javafx.fxml , javafx.base;
    opens org.hugo.ejerciciob to javafx.base, javafx.fxml;
    exports org.hugo.ejerciciob;
}