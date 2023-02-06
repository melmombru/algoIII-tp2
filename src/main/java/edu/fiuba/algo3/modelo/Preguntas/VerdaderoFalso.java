package edu.fiuba.algo3.modelo.Preguntas;

import edu.fiuba.algo3.modelo.opciones.Opcion;
import edu.fiuba.algo3.modelo.Puntaje;
import edu.fiuba.algo3.modelo.Respuestas.Respuesta;
import edu.fiuba.algo3.modelo.Respuestas.RespuestaUnica;
import edu.fiuba.algo3.modelo.Excepciones.OpcionNoValidaException;

public abstract class VerdaderoFalso extends Pregunta {

    protected Opcion opcionCorrecta;
    protected Opcion opcionIncorrecta;

    public Opcion getOpcionIncorrecta() {
        return opcionIncorrecta;
    }

    public Opcion getOpcionVerdadera(){

        if(opcionCorrecta.tieneLaMisma("Verdadero"))
            return opcionCorrecta;
        else
            return opcionIncorrecta;
    }

    public Opcion getOpcionFalsa(){

        if(opcionCorrecta.tieneLaMisma("Falso"))
            return opcionCorrecta;
        else
            return opcionIncorrecta;
    }

    @Override
    public Puntaje evaluarRespuestaPara(Respuesta respuesta) {

        RespuestaUnica respuestaUnica = (RespuestaUnica) respuesta;

        if (!respuestaUnica.esIgualA(opcionCorrecta) && !respuestaUnica.esIgualA(opcionIncorrecta) && !respuestaUnica.esIgualA(new Opcion("No contestada")))
            throw new OpcionNoValidaException();

        return respuestaUnica.getPuntaje();
    }
}
