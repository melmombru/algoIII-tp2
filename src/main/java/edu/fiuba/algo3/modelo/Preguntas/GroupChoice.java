package edu.fiuba.algo3.modelo.Preguntas;

import com.google.gson.JsonObject;
import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.bonus.Exclusividad;
import edu.fiuba.algo3.modelo.Respuestas.Respuesta;
import edu.fiuba.algo3.modelo.Respuestas.RespuestaDeGrupos;
import edu.fiuba.algo3.modelo.Excepciones.CantidadDeOpcionesInvalidaException;
import edu.fiuba.algo3.modelo.opciones.ListaOpciones;

public class GroupChoice extends Pregunta implements PreguntaSinPenalidad {
    private static final String NOMBRE_DE_PREGUNTA = "Group Choice";
    private final ListaOpciones opcionesGrupoA;
    private final ListaOpciones opcionesGrupoB;
    private final String nombreGrupoA;
    private final String nombreGrupoB;

    public GroupChoice(String unaConsigna, String unNombreGrupoA, ListaOpciones unasOpcionesGrupoA, String unNombreGrupoB, ListaOpciones unasOpcionesGrupoB) {
        super();
        if ((unasOpcionesGrupoA.cantidadDeOpciones() + unasOpcionesGrupoB.cantidadDeOpciones()) < 2 ||
                (unasOpcionesGrupoA.cantidadDeOpciones() + unasOpcionesGrupoB.cantidadDeOpciones()) > 6) {
            throw new CantidadDeOpcionesInvalidaException();
        }
        consigna = unaConsigna;
        nombreGrupoA = unNombreGrupoA;
        opcionesGrupoA = unasOpcionesGrupoA;
        nombreGrupoB = unNombreGrupoB;
        opcionesGrupoB = unasOpcionesGrupoB;
    }

    public static GroupChoice recuperar(JsonObject jsonPregunta) {

        String consigna = jsonPregunta.get("consigna").getAsString();
        String nombreGrupoA = jsonPregunta.get("nombreGrupoA").getAsString();
        String nombreGrupoB = jsonPregunta.get("nombreGrupoB").getAsString();
        ListaOpciones opcionesGrupoA = ListaOpciones.recuperar(jsonPregunta.getAsJsonArray("opcionesGrupoA"));
        ListaOpciones opcionesGrupoB = ListaOpciones.recuperar(jsonPregunta.getAsJsonArray("opcionesGrupoB"));
        return new GroupChoice(consigna, nombreGrupoA, opcionesGrupoA, nombreGrupoB, opcionesGrupoB);
    }

    public static String getNombreDePregunta(){
        return NOMBRE_DE_PREGUNTA;
    }

    @Override
    public Puntaje evaluarRespuestaPara(Respuesta respuesta) {

        RespuestaDeGrupos respuestaDeGrupos = (RespuestaDeGrupos) respuesta;

        Puntaje puntaje = new Puntaje(0);

        if (respuestaDeGrupos.grupoAContieneLoMismo(opcionesGrupoA) && respuestaDeGrupos.grupoBContieneLoMismo(opcionesGrupoB)) {
            puntaje.establecerPuntos(1);
        }
        return puntaje;
    }

    public ListaOpciones getOpcionesGrupoA() {
        return opcionesGrupoA;
    }

    public ListaOpciones getOpcionesGrupoB() {
        return opcionesGrupoB;
    }

    public String getNombreGrupoA() {
        return nombreGrupoA;
    }

    public String getNombreGrupoB() {
        return nombreGrupoB;
    }

    @Override
    public JsonObject guardar() {

        JsonObject jsonGroupChoice = new JsonObject();
        jsonGroupChoice.addProperty("tipoDePregunta", GroupChoice.getNombreDePregunta());
        jsonGroupChoice.addProperty("consigna", consigna);
        jsonGroupChoice.addProperty("nombreGrupoA", nombreGrupoA);
        jsonGroupChoice.addProperty("nombreGrupoB", nombreGrupoB);
        jsonGroupChoice.add("opcionesGrupoA", opcionesGrupoA.guardar());
        jsonGroupChoice.add("opcionesGrupoB", opcionesGrupoB.guardar());
        return jsonGroupChoice;
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
