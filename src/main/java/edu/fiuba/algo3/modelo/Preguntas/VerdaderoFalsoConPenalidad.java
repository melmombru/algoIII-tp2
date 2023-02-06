package edu.fiuba.algo3.modelo.Preguntas;

import com.google.gson.JsonObject;
import edu.fiuba.algo3.modelo.bonus.Multiplicador;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import edu.fiuba.algo3.modelo.Puntaje;

public class VerdaderoFalsoConPenalidad extends VerdaderoFalso implements PreguntaConPenalidad{
    private static final String NOMBRE_DE_PREGUNTA = "Verdadero/Falso con Penalidad";

    private VerdaderoFalsoConPenalidad(String unaConsigna, Opcion unaOpcionCorrecta, Opcion unaOpcionIncorrecta) {

        consigna = unaConsigna;
        opcionCorrecta = unaOpcionCorrecta;
        opcionIncorrecta = unaOpcionIncorrecta;
    }

    public static VerdaderoFalsoConPenalidad recuperar(JsonObject jsonPregunta) {

        String consigna = jsonPregunta.get("consigna").getAsString();
        Opcion opcionCorrecta = Opcion.recuperar(jsonPregunta.getAsJsonObject("opcionCorrecta"));
        Opcion opcionIncorrecta = Opcion.recuperar(jsonPregunta.getAsJsonObject("opcionIncorrecta"));
        return new VerdaderoFalsoConPenalidad(consigna, opcionCorrecta, opcionIncorrecta);
    }

    public static VerdaderoFalsoConPenalidad crearVerdaderoFalsoCorrectoVerdadero(String unaConsigna) {

        Opcion opcionVerdadera = new Opcion("Verdadero", new Puntaje(1));
        Opcion opcionFalsa = new Opcion("Falso", new Puntaje(-1));
        return new VerdaderoFalsoConPenalidad(unaConsigna, opcionVerdadera, opcionFalsa);
    }

    public static VerdaderoFalsoConPenalidad crearVerdaderoFalsoCorrectoFalso(String unaConsigna) {

        Opcion opcionVerdadera = new Opcion("Verdadero", new Puntaje(-1));
        Opcion opcionFalsa = new Opcion("Falso", new Puntaje(1));
        return new VerdaderoFalsoConPenalidad(unaConsigna, opcionFalsa, opcionVerdadera);
    }

    public static String getNombreDePregunta(){
        return NOMBRE_DE_PREGUNTA;
    }

    @Override
    public JsonObject guardar() {

        JsonObject jsonVoFConPenalidad = new JsonObject();
        jsonVoFConPenalidad.addProperty("tipoDePregunta", VerdaderoFalsoConPenalidad.getNombreDePregunta());
        jsonVoFConPenalidad.addProperty("consigna", consigna);
        jsonVoFConPenalidad.add("opcionCorrecta", opcionCorrecta.guardar());
        jsonVoFConPenalidad.add("opcionIncorrecta", opcionIncorrecta.guardar());
        return jsonVoFConPenalidad;
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
