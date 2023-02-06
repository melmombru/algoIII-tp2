package edu.fiuba.algo3.controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class OpcionSalirDePantallaCompletaEventHandler implements EventHandler<ActionEvent> {

    Stage stage;
    MenuItem opcionPantallaCompleta;
    Menu menuVer;

    public OpcionSalirDePantallaCompletaEventHandler(Stage stage, MenuItem opcionPantallaCompleta, Menu menuVer) {
        this.stage = stage;
        this.opcionPantallaCompleta = opcionPantallaCompleta;
        this.menuVer = menuVer;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        stage.show();
        stage.setMaximized(false);
        menuVer.getItems().clear();
        menuVer.getItems().addAll(opcionPantallaCompleta);
        stage.show();
    }
}
