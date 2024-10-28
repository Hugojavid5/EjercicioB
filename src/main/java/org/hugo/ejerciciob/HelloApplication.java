package org.hugo.ejerciciob;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Clase principal de la aplicación JavaFX.
 * Esta clase extiende la clase {@link Application} y maneja la inicialización
 * y configuración de la interfaz gráfica de la aplicación.
 */
public class HelloApplication extends Application {

    /**
     * Inicia la aplicación JavaFX.
     * @param stage La ventana principal de la aplicación.
     * @throws IOException Si no se puede cargar el archivo FXML.
     */
    @Override
    public void start(Stage stage) throws IOException {
        // Carga el archivo FXML para construir la interfaz gráfica
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("EjercicioB.fxml"));

        // Crea una nueva escena con el contenido del archivo FXML
        Scene scene = new Scene(fxmlLoader.load(), 800, 500);

        // Carga el ícono de la aplicación
        Image icon = new Image(getClass().getResourceAsStream("/Imagenes/icono.png"));
        stage.getIcons().add(icon);

        // Establece las dimensiones máximas y mínimas de la ventana
        stage.setMaxWidth(840);
        stage.setMinWidth(565);
        stage.setMinHeight(325);

        // Configura el título de la ventana
        stage.setTitle("Personas");

        // Establece la escena en el escenario y muestra la ventana
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Método principal que lanza la aplicación JavaFX.
     * @param args Argumentos de línea de comandos.
     */
    public static void main(String[] args) {
        launch(); // Lanza la aplicación
    }
}
