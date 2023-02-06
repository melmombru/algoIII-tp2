package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaSinPenalidad;
import edu.fiuba.algo3.vista.Escenas.Escena;
import edu.fiuba.algo3.vista.EtiquetaTiempo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonExclusividadHandler implements EventHandler<ActionEvent> {

    private PreguntaSinPenalidad pregunta;
    private Escena escena;
    private Jugador jugador;
    private ManejadorDeTurnos manejadorDeTurnos;
    private EtiquetaTiempo etiquetaTiempo;

    public BotonExclusividadHandler(PreguntaSinPenalidad unaPregunta, Escena unaEscena, Jugador unJugador, ManejadorDeTurnos unManejadorDeTurnos, EtiquetaTiempo unaEtiquetaTiempo) {

        pregunta = unaPregunta;
        escena = unaEscena;
        jugador = unJugador;
        manejadorDeTurnos = unManejadorDeTurnos;
        etiquetaTiempo = unaEtiquetaTiempo;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        manejadorDeTurnos.getKahoot().agregarExclusividad(pregunta, jugador);

        escena.actualizar(jugador, manejadorDeTurnos, etiquetaTiempo);
    }
}