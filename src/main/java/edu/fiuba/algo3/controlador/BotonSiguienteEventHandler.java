package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.ManejadorDeTurnos;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonSiguienteEventHandler implements EventHandler<ActionEvent> {

    private ManejadorDeTurnos manejadorDeTurnos;

    public BotonSiguienteEventHandler(ManejadorDeTurnos unManejadorDeTurnos){
        manejadorDeTurnos = unManejadorDeTurnos;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        manejadorDeTurnos.mostrarSiguientePregunta();
    }
}
