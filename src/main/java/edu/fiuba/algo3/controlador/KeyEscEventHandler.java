package edu.fiuba.algo3.controlador;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class KeyEscEventHandler implements EventHandler<KeyEvent> {

    private MenuItem opcionSalirDePantallaCompleta;

    public KeyEscEventHandler(MenuItem opcionPantallaCompleta){
        this.opcionSalirDePantallaCompleta = opcionPantallaCompleta;
    }

    @Override
    public void handle(KeyEvent keyEvent) {
        if(keyEvent.getCode() == KeyCode.ESCAPE){
            System.out.println("se presiona enter");
            Event.fireEvent(opcionSalirDePantallaCompleta, new ActionEvent());;
        }
    }
}
