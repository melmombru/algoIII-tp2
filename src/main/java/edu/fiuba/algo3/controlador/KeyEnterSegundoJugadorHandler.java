package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.vista.Contenedores.ContenedorBotonEmpezar;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class KeyEnterSegundoJugadorHandler implements EventHandler<KeyEvent> {

    private ContenedorBotonEmpezar contenedor;

    public KeyEnterSegundoJugadorHandler(ContenedorBotonEmpezar contenedorBotonEmpezar){
        contenedor = contenedorBotonEmpezar;
    }

    @Override
    public void handle(KeyEvent keyEvent) {
        if(keyEvent.getCode() == KeyCode.ENTER){
            Event.fireEvent(contenedor.getButton(), new ActionEvent());
        }
    }
}
