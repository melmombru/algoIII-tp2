package edu.fiuba.algo3.modelo.Preguntas;

import com.google.gson.JsonObject;
import edu.fiuba.algo3.modelo.Puntaje;
import edu.fiuba.algo3.modelo.Respuestas.Respuesta;

public abstract class Pregunta {

    protected String consigna;

    public String getConsigna() {
        return  consigna;
    }

    public abstract Puntaje evaluarRespuestaPara(Respuesta respuesta);

    public abstract JsonObject guardar();

    public abstract String getTipoDePregunta();

    public abstract boolean esElMismoTipoDePreguinta(Pregunta unaPregunta);
}