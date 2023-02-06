package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.ManejadorDeTurnos;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaConPenalidad;
import edu.fiuba.algo3.vista.Escenas.Escena;
import edu.fiuba.algo3.vista.EtiquetaTiempo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonMultiplicadorx3EventHandler implements EventHandler<ActionEvent> {

    private PreguntaConPenalidad pregunta;
    private Escena escena;
    private Jugador jugador;
    private ManejadorDeTurnos manejadorDeTurnos;
    private  EtiquetaTiempo etiquetaTiempo;

    public BotonMultiplicadorx3EventHandler(PreguntaConPenalidad unaPregunta, Escena unaEscena, Jugador unJugador, ManejadorDeTurnos unManejadorDeTurnos, EtiquetaTiempo unaEtiquetaTiempo){
        pregunta = unaPregunta;
        escena = unaEscena;
        jugador = unJugador;
        manejadorDeTurnos = unManejadorDeTurnos;
        etiquetaTiempo = unaEtiquetaTiempo;
    }
    @Override
    public void handle(ActionEvent actionEvent) {

        manejadorDeTurnos.getKahoot().agregarMultiplicadorX3(pregunta, jugador);

        escena.actualizar(jugador, manejadorDeTurnos, etiquetaTiempo);

    }
}
