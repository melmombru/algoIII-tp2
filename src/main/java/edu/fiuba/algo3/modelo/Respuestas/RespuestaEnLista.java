package edu.fiuba.algo3.modelo.Respuestas;

import edu.fiuba.algo3.modelo.opciones.ListaOpciones;
import edu.fiuba.algo3.modelo.Puntaje;

public class RespuestaEnLista implements Respuesta {

    private ListaOpciones opcionesSeleccionadas;

    public RespuestaEnLista(ListaOpciones unasOpcionesSeleccionadas) {
        opcionesSeleccionadas = unasOpcionesSeleccionadas;
    }

    public Puntaje calcularPuntaje() {
        return opcionesSeleccionadas.calcularPuntaje();
    }

    public boolean contieneLoMismo(ListaOpciones opciones) {
        return opcionesSeleccionadas.contieneLoMismo(opciones);
    }

    public boolean contieneAlguna(ListaOpciones opciones) {
        return opcionesSeleccionadas.contieneAlguna(opciones);
    }

    public boolean esIgual(ListaOpciones listaDeOpciones) {
        return opcionesSeleccionadas.esIgual(listaDeOpciones);
    }

    public ListaOpciones getOpcionesSeleccionadas() {
        return opcionesSeleccionadas;
    }
}
