package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.opciones.ListaOpciones;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonAsignarGrupoHandler implements EventHandler<ActionEvent> {

    private Opcion opcion;
    private ListaOpciones origen;
    private ListaOpciones destino;

    public BotonAsignarGrupoHandler (Opcion unaOpcion, ListaOpciones unOrigen, ListaOpciones unDestino) {

        opcion = unaOpcion;
        origen = unOrigen;
        destino = unDestino;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        origen.quitarOpcion(opcion);
        destino.agregar(opcion);
    }
}
