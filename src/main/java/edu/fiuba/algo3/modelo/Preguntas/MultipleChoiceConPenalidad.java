package edu.fiuba.algo3.modelo.Preguntas;

import com.google.gson.JsonObject;
import edu.fiuba.algo3.modelo.bonus.Multiplicador;
import edu.fiuba.algo3.modelo.opciones.ListaOpciones;
import edu.fiuba.algo3.modelo.Puntaje;
import edu.fiuba.algo3.modelo.Respuestas.Respuesta;
import edu.fiuba.algo3.modelo.Respuestas.RespuestaEnLista;
import edu.fiuba.algo3.modelo.Excepciones.CantidadDeOpcionesInvalidaException;

public class MultipleChoiceConPenalidad extends MultipleChoice implements PreguntaConPenalidad {
    private static final String NOMBRE_DE_PREGUNTA = "Multiple Choice con Penalidad";

    public MultipleChoiceConPenalidad(String unaConsigna, ListaOpciones unasOpcionesCorrectas, ListaOpciones unasOpcionesIncorrectas) {
        super();
        if ((unasOpcionesCorrectas.cantidadDeOpciones() + unasOpcionesIncorrectas.cantidadDeOpciones()) < 2 ||
                (unasOpcionesCorrectas.cantidadDeOpciones() + unasOpcionesIncorrectas.cantidadDeOpciones()) > 5) {
            throw new CantidadDeOpcionesInvalidaException();
        }
        consigna = unaConsigna;
        opcionesCorrectas = unasOpcionesCorrectas;
        opcionesIncorrectas = unasOpcionesIncorrectas;
    }

    public static MultipleChoiceConPenalidad recuperar(JsonObject jsonPregunta) {

        String consigna = jsonPregunta.get("consigna").getAsString();
        ListaOpciones opcionesCorrectas = ListaOpciones.recuperar(jsonPregunta.getAsJsonArray("opcionesCorrectas"));
        ListaOpciones opcionesIncorrectas = ListaOpciones.recuperar(jsonPregunta.getAsJsonArray("opcionesIncorrectas"));
        return new MultipleChoiceConPenalidad(consigna, opcionesCorrectas, opcionesIncorrectas);
    }

    public static String getNombreDePregunta(){
        return NOMBRE_DE_PREGUNTA;
    }

    @Override
    public Puntaje evaluarRespuestaPara(Respuesta respuesta) {

        RespuestaEnLista respuestaEnLista = (RespuestaEnLista) respuesta;

        return respuestaEnLista.calcularPuntaje();
    }

    @Override
    public JsonObject guardar() {

        JsonObject jsonMultipleChoiceConPenalidad = new JsonObject();
        jsonMultipleChoiceConPenalidad.addProperty("tipoDePregunta",MultipleChoiceConPenalidad.getNombreDePregunta());
        jsonMultipleChoiceConPenalidad.addProperty("consigna", consigna);
        jsonMultipleChoiceConPenalidad.add("opcionesCorrectas", opcionesCorrectas.guardar());
        jsonMultipleChoiceConPenalidad.add("opcionesIncorrectas", opcionesIncorrectas.guardar());
        return jsonMultipleChoiceConPenalidad;
    }

    @Override
    public String getTipoDePregunta() {
        return NOMBRE_DE_PREGUNTA;
    }

    @Override
    public boolean esElMismoTipoDePreguinta(Pregunta unaPregunta) {
        return NOMBRE_DE_PREGUNTA.equals(unaPregunta.getTipoDePregunta());
    }

    @Override
    public Multiplicador getMultiplicadorX2() {
        return new Multiplicador(2);
    }

    @Override
    public Multiplicador getMultiplicadorX3() {
        return new Multiplicador(3);
    }
}

