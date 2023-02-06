package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.ManejadorDeTurnos;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonPrimeraPreguntaEventHandler implements EventHandler<ActionEvent> {

    private ManejadorDeTurnos manejadorDeTurnos;

    public BotonPrimeraPreguntaEventHandler(ManejadorDeTurnos manejadorDeTurnos){

        this.manejadorDeTurnos = manejadorDeTurnos;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        manejadorDeTurnos.mostrarPrimeraPregunta();
    }
}
