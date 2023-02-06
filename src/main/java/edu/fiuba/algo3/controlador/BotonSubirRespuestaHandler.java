package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import edu.fiuba.algo3.vista.Escenas.EscenaOrderedChoice;
import edu.fiuba.algo3.vista.EtiquetaTiempo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonSubirRespuestaHandler implements EventHandler<ActionEvent> {

    private int posicion;
    private EscenaOrderedChoice escena;
    private Jugador jugador;
    private ManejadorDeTurnos manejadorDeTurnos;
    private EtiquetaTiempo etiquetaTiempo;

    public BotonSubirRespuestaHandler (int unaPosicion, EscenaOrderedChoice unaEscena, Jugador unJugador, ManejadorDeTurnos unManejadorDeTurnos, EtiquetaTiempo unaEtiquetaTiempo) {

        posicion = unaPosicion;
        escena = unaEscena;
        jugador = unJugador;
        manejadorDeTurnos = unManejadorDeTurnos;
        etiquetaTiempo = unaEtiquetaTiempo;

    }

    @Override
    public void handle(ActionEvent actionEvent) {

        Opcion opcionVaso = new Opcion(escena.getOpcionesMostradas().obtener(posicion).getOpcion());
        escena.getOpcionesMostradas().establecer(posicion, escena.getOpcionesMostradas().obtener(posicion-1));
        escena.getOpcionesMostradas().establecer(posicion-1, opcionVaso);

        escena.actualizar(jugador, manejadorDeTurnos, etiquetaTiempo);
    }
}
