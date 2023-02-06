package edu.fiuba.algo3.modelo.Respuestas;

import edu.fiuba.algo3.modelo.opciones.Opcion;
import edu.fiuba.algo3.modelo.Puntaje;

public class RespuestaUnica implements Respuesta {

    private Opcion opcionSeleccionada;

    public RespuestaUnica(Opcion unaOpcionSeleccionada) {
        opcionSeleccionada = unaOpcionSeleccionada;
    }

    public Opcion getOpcionSeleccionada(){
        return opcionSeleccionada;
    }

    public boolean esIgualA(Opcion opcion) {
        return opcionSeleccionada.esIgualA(opcion);
    }

    public Puntaje getPuntaje() {
        return opcionSeleccionada.getPuntaje();
    }
}
