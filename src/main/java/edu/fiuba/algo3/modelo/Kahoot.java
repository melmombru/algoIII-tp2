package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.bonus.BonusDePuntaje;
import edu.fiuba.algo3.modelo.bonus.ListaDeExclusividades;
import edu.fiuba.algo3.modelo.bonus.ListaDeMultiplicadores;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaConPenalidad;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaSinPenalidad;
import edu.fiuba.algo3.modelo.Respuestas.Respuesta;
import edu.fiuba.algo3.modelo.Excepciones.JugadorNoValidoException;

public class Kahoot{

    private final Jugador jugador1;
    private final Jugador jugador2;
    private Respuesta respuestaJugador1;
    private Respuesta respuestaJugador2;
    private final ListaDeExclusividades exclusividades;
    private final ListaDeMultiplicadores multiplicadoresJ1;
    private final ListaDeMultiplicadores multiplicadoresJ2;

    public Kahoot() {

        jugador1 = new Jugador("Jugador 1");
        jugador2 = new Jugador("Jugador 2");
        exclusividades = new ListaDeExclusividades();
        multiplicadoresJ1 = new ListaDeMultiplicadores();
        multiplicadoresJ2 = new ListaDeMultiplicadores();
    }

    public void setRespuestaJugador(Respuesta unaRespuesta, Jugador jugador) {

        if(jugador == jugador1) {
            respuestaJugador1 = unaRespuesta;
        }
        else if(jugador == jugador2) {
            respuestaJugador2 = unaRespuesta;
        }
        else{
            throw new JugadorNoValidoException();
        }
    }

    public void agregarExclusividad(PreguntaSinPenalidad unaPregunta, Jugador jugador){

        if(jugador == jugador1 || jugador == jugador2) {
            exclusividades.agregarExclusividad(unaPregunta.getExclusividad());
            jugador.utilizarExclusividad();
        }
        else{
            throw new JugadorNoValidoException();
        }
    }

    public void agregarMultiplicadorX2(PreguntaConPenalidad unaPregunta, Jugador jugador){


        if(jugador == jugador1) {
            multiplicadoresJ1.agregarMultiplicador(unaPregunta.getMultiplicadorX2());
            jugador.utilizarMultiplicadorX2();
        }
        else if(jugador == jugador2) {
            multiplicadoresJ2.agregarMultiplicador(unaPregunta.getMultiplicadorX2());
            jugador.utilizarMultiplicadorX2();
        }
        else{
            throw new JugadorNoValidoException();
        }
    }

    public void agregarMultiplicadorX3(PreguntaConPenalidad unaPregunta, Jugador jugador){

        if(jugador == jugador1) {
            multiplicadoresJ1.agregarMultiplicador(unaPregunta.getMultiplicadorX3());
            jugador.utilizarMultiplicadorX3();
        }
        else if(jugador == jugador2) {
            multiplicadoresJ2.agregarMultiplicador(unaPregunta.getMultiplicadorX3());
            jugador.utilizarMultiplicadorX3();
        }
        else{
            throw new JugadorNoValidoException();
        }
    }

    public void evaluarRespuestas(Pregunta unaPregunta) {

        Puntaje puntajeJ1 = new Puntaje();
        Puntaje puntajeJ2 = new Puntaje();

        puntajeJ1.sumarPuntos(unaPregunta.evaluarRespuestaPara(respuestaJugador1));
        puntajeJ2.sumarPuntos(unaPregunta.evaluarRespuestaPara(respuestaJugador2));

        BonusDePuntaje.aplicarbonus(puntajeJ1, multiplicadoresJ1, puntajeJ2, multiplicadoresJ2, exclusividades);

        jugador1.sumarPuntos(puntajeJ1);
        jugador2.sumarPuntos(puntajeJ2);

        exclusividades.limpiarExclusividades();
        multiplicadoresJ1.limpiarMultiplicadores();
        multiplicadoresJ2.limpiarMultiplicadores();

    }


    public Puntaje getPuntajeJugador1() {
        return jugador1.getPuntaje();
    }

    public Puntaje getPuntajeJugador2() {
        return jugador2.getPuntaje();
    }

    public Jugador getJugador1() {return jugador1;}

    public Jugador getJugador2() {return jugador2;}
}
