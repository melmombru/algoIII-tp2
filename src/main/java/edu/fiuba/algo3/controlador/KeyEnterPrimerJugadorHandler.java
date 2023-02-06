package edu.fiuba.algo3.controlador;

import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class KeyEnterPrimerJugadorHandler implements EventHandler<KeyEvent> {

    TextField textField;

    public KeyEnterPrimerJugadorHandler(TextField textField){
        this.textField = textField;
    }

    @Override
    public void handle(KeyEvent keyEvent) {
        if(keyEvent.getCode() == KeyCode.ENTER){
            textField.requestFocus();
        }
    }
}
