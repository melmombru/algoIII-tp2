package edu.fiuba.algo3.controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Region;

public class OpcionAcercaDeEventHandler implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent actionEvent) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Acerca de Kahoot!");
        alert.setHeaderText("Este programa se encuentra bajo la licencia MIT");
        String mensaje = "Creado en Agosto del 2020 para la materia 75.07 Algoritmos y  programación III. \n" +
                "\n" +
                "Desarrollado por: \n" +
                "    Fernández Manoukian, Tomás\n" +
                "    Mombru, Melanie\n" +
                "    Mundani Vegega, Ezequiel\n" +
                "    Tardá, Agustín\n" +
                "    Tardá, Rocío\n";


        alert.setContentText(mensaje);
        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);

        alert.show();
    }
}
