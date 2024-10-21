package org.hugo.ejerciciob;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("EjercicioB.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        Image icon = new Image(getClass().getResourceAsStream("/Imagenes/icono.png"));
        stage.getIcons().add(icon);
        stage.setTitle("Personas");
        stage.setMinWidth(600);
        stage.setMinHeight(400);
        stage.setScene(scene);
        stage.show();
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}