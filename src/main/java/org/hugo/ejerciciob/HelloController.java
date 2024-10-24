package org.hugo.ejerciciob;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import Model.Persona;

/**
 * Controlador de la interfaz gráfica que gestiona la lógica de la aplicación.
 * Se encarga de manejar las interacciones del usuario y la actualización de la tabla de personas.
 */
public class HelloController {

    @FXML
    private Button btt_agregar;

    @FXML
    private TableColumn<Persona, String> c_apellidos;

    @FXML
    private TableColumn<Persona, Integer> c_edad;

    @FXML
    private TableColumn<Persona, String> c_nombre;

    @FXML
    private TableView<Persona> personTable;

    @FXML
    private TextField txt_apellidos;

    @FXML
    private TextField txt_edad;

    @FXML
    private TextField txt_nombre;

    // Lista observable que contiene los objetos Persona
    private ObservableList<Persona> personasList = FXCollections.observableArrayList();

    /**
     * Método llamado cuando el usuario hace clic en el botón "Agregar".
     * Verifica que los campos de entrada sean válidos y luego agrega una nueva persona a la tabla.
     * Si hay errores, se muestra un mensaje de error, si no, se agrega la persona y se muestra un mensaje de éxito.
     */
    @FXML
    private void agregar() {
        String nombre = txt_nombre.getText().trim();
        String apellidos = txt_apellidos.getText().trim();
        String edadText = txt_edad.getText().trim();
        StringBuilder errores = new StringBuilder();

        // Validación de campos
        if (nombre.isEmpty()) {
            errores.append("El campo 'Nombre' no puede estar vacío.\n");
        }
        if (apellidos.isEmpty()) {
            errores.append("El campo 'Apellidos' no puede estar vacío.\n");
        }

        // Validación del campo 'edad' que debe ser un número entero positivo
        int edad = -1;
        try {
            edad = Integer.parseInt(edadText);
            if (edad < 0) {
                errores.append("La edad debe ser un número positivo.\n");
            }
        } catch (NumberFormatException e) {
            errores.append("El campo 'Edad' debe ser un número entero válido.\n");
        }

        // Si hay errores, mostrar alerta de error y salir del método
        if (errores.length() > 0) {
            mostrarError(errores.toString());
            return;
        }

        // Crear una nueva instancia de Persona con los datos ingresados
        Persona nuevaPersona = new Persona(nombre, apellidos, edad);

        // Comprobar si la persona ya existe en la lista
        if (personasList.contains(nuevaPersona)) {
            mostrarError("Persona duplicada: Ya existe una persona con los mismos datos.");
            return;
        }

        // Agregar la nueva persona a la lista y mostrar mensaje de éxito
        personasList.add(nuevaPersona);
        mostrarInformacion("Persona agregada con éxito.");
    }

    /**
     * Muestra un mensaje de error en una alerta emergente.
     * Este método se utiliza para alertar al usuario de errores en los datos ingresados.
     * @param mensaje Mensaje de error a mostrar.
     */
    private void mostrarError(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error en los datos");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    /**
     * Muestra un mensaje informativo en una alerta emergente.
     * Este método se utiliza para informar al usuario de una operación exitosa.
     * @param mensaje Mensaje informativo a mostrar.
     */
    private void mostrarInformacion(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Éxito");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
