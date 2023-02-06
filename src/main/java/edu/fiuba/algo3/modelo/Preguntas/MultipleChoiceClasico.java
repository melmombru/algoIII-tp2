package edu.fiuba.algo3.modelo.Preguntas;

import com.google.gson.JsonObject;
import edu.fiuba.algo3.modelo.bonus.Exclusividad;
import edu.fiuba.algo3.modelo.opciones.ListaOpciones;
import edu.fiuba.algo3.modelo.Puntaje;
import edu.fiuba.algo3.modelo.Respuestas.Respuesta;
import edu.fiuba.algo3.modelo.Respuestas.RespuestaEnLista;
import edu.fiuba.algo3.modelo.Excepciones.CantidadDeOpcionesInvalidaException;

public class MultipleChoiceClasico extends MultipleChoice implements PreguntaSinPenalidad{
    private static final String NOMBRE_DE_PREGUNTA = "Multiple Choice Clásico";

    public MultipleChoiceClasico(String unaConsigna, ListaOpciones unasOpcionesCorrectas, ListaOpciones unasOpcionesIncorrectas) {
        super();
        if ((unasOpcionesCorrectas.cantidadDeOpciones() + unasOpcionesIncorrectas.cantidadDeOpciones()) < 2 ||
                (unasOpcionesCorrectas.cantidadDeOpciones() + unasOpcionesIncorrectas.cantidadDeOpciones()) > 5) {
            throw new CantidadDeOpcionesInvalidaException();
        }
        consigna = unaConsigna;
        opcionesCorrectas = unasOpcionesCorrectas;
        opcionesIncorrectas = unasOpcionesIncorrectas;
    }

    public static MultipleChoiceClasico recuperar(JsonObject jsonPregunta) {

        String consigna = jsonPregunta.get("consigna").getAsString();
        ListaOpciones opcionesCorrectas = ListaOpciones.recuperar(jsonPregunta.getAsJsonArray("opcionesCorrectas"));
        ListaOpciones opcionesIncorrectas = ListaOpciones.recuperar(jsonPregunta.getAsJsonArray("opcionesIncorrectas"));
        return new MultipleChoiceClasico(consigna, opcionesCorrectas, opcionesIncorrectas);
    }

    public String getConsigna() {
        return super.getConsigna();
    }

    public Puntaje calcularPuntajePara(Respuesta respuesta) {

        RespuestaEnLista respuestaEnLista = (RespuestaEnLista) respuesta;
        Puntaje puntaje = new Puntaje(0);

        if (respuestaEnLista.contieneLoMismo(opcionesCorrectas))
            puntaje.establecerPuntos(1);

        return puntaje;
    }

    public static String getNombreDePregunta(){
        return NOMBRE_DE_PREGUNTA;
    }

    @Override
    public Puntaje evaluarRespuestaPara(Respuesta respuesta) {

        return(this.calcularPuntajePara(respuesta));
    }

    @Override
    public JsonObject guardar() {

        JsonObject jsonMultipleChoiceClasico = new JsonObject();
        jsonMultipleChoiceClasico.addProperty("tipoDePregunta", MultipleChoiceClasico.getNombreDePregunta());
        jsonMultipleChoiceClasico.addProperty("consigna", consigna);
        jsonMultipleChoiceClasico.add("opcionesCorrectas", opcionesCorrectas.guardar());
        jsonMultipleChoiceClasico.add("opcionesIncorrectas", opcionesIncorrectas.guardar());
        return jsonMultipleChoiceClasico;
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
    public Exclusividad getExclusividad() {
        return new Exclusividad();
    }
}
