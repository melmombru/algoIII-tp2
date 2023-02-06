package edu.fiuba.algo3.controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class OpcionPantallaCompletaEventHandler implements EventHandler<ActionEvent> {

    Stage stage;
    MenuItem opcionSalirDePantallaCompleta;
    Menu menuVer;

    public OpcionPantallaCompletaEventHandler(Stage stage, MenuItem opcionSalirDePantallaCompleta, Menu menuVer) {
        this.stage = stage;
        this.opcionSalirDePantallaCompleta = opcionSalirDePantallaCompleta;
        this.menuVer = menuVer;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if (!stage.isFullScreen()) {
            stage.hide();
            stage.setMaximized(true);
            menuVer.getItems().clear();
            menuVer.getItems().addAll(opcionSalirDePantallaCompleta);
            stage.show();
        }
    }
}
