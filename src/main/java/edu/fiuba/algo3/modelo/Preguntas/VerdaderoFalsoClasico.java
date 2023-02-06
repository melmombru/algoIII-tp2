package edu.fiuba.algo3.modelo.Preguntas;

import com.google.gson.JsonObject;
import edu.fiuba.algo3.modelo.bonus.Exclusividad;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import edu.fiuba.algo3.modelo.Puntaje;

public class VerdaderoFalsoClasico extends VerdaderoFalso implements PreguntaSinPenalidad {
    private static final String NOMBRE_DE_PREGUNTA = "Verdadero/Falso clásico";

    public static VerdaderoFalsoClasico recuperar(JsonObject jsonPregunta) {

        String consigna = jsonPregunta.get("consigna").getAsString();
        Opcion opcionCorrecta = Opcion.recuperar(jsonPregunta.getAsJsonObject("opcionCorrecta"));
        Opcion opcionIncorrecta = Opcion.recuperar(jsonPregunta.getAsJsonObject("opcionIncorrecta"));
        return new VerdaderoFalsoClasico(consigna, opcionCorrecta, opcionIncorrecta);
    }

    private VerdaderoFalsoClasico(String unaConsigna, Opcion unaOpcionCorrecta, Opcion unaOpcionIncorrecta) {

        consigna = unaConsigna;
        opcionCorrecta = unaOpcionCorrecta;
        opcionIncorrecta = unaOpcionIncorrecta;
    }

    public static VerdaderoFalsoClasico crearVerdaderoFalsoCorrectaVerdadero(String unaConsigna) {

        Opcion opcionVerdadera = new Opcion("Verdadero", new Puntaje(1));
        Opcion opcionFalsa = new Opcion("Falso", new Puntaje(0));
        return new VerdaderoFalsoClasico(unaConsigna, opcionVerdadera, opcionFalsa);
    }

    public static VerdaderoFalsoClasico crearVerdaderoFalsoCorrectoFalso(String unaConsigna) {

        Opcion opcionVerdadera = new Opcion("Verdadero", new Puntaje(0));
        Opcion opcionFalsa = new Opcion("Falso", new Puntaje(1));
        return new VerdaderoFalsoClasico(unaConsigna, opcionFalsa, opcionVerdadera);
    }

    public static String getNombreDePregunta(){
        return NOMBRE_DE_PREGUNTA;
    }

    @Override
    public JsonObject guardar() {

        JsonObject jsonVoFClasico = new JsonObject();
        jsonVoFClasico.addProperty("tipoDePregunta",VerdaderoFalsoClasico.getNombreDePregunta());
        jsonVoFClasico.addProperty("consigna",consigna);
        jsonVoFClasico.add("opcionCorrecta",opcionCorrecta.guardar());
        jsonVoFClasico.add("opcionIncorrecta",opcionIncorrecta.guardar());
        return jsonVoFClasico;
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
