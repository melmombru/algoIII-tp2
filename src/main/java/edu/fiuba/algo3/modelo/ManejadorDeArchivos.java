package edu.fiuba.algo3.modelo;

import com.google.gson.*;
import edu.fiuba.algo3.Mocks.MockAltaDePreguntas;
import edu.fiuba.algo3.modelo.Preguntas.*;
import edu.fiuba.algo3.modelo.Excepciones.ErrorDeEscrituraException;
import edu.fiuba.algo3.modelo.Excepciones.ErrorDeLecturaException;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ManejadorDeArchivos {

    static String FILENAME_RELATIVE_PATH = "preguntas.json";
    private final List<Pregunta> preguntasDelJuego;

    public ManejadorDeArchivos() {
        preguntasDelJuego = new ArrayList<>();
    }

    public void escribirPreguntasDelAltaDePreguntas() {
        this.escribirPreguntas((new MockAltaDePreguntas()).getListaDePreguntas());
    }

    public void escribirPreguntas(List<Pregunta> preguntasAEscribir) {

        try {
            Gson gson = new Gson();

            String json = gson.toJson(this.guardar(preguntasAEscribir));

            FileWriter writer = new FileWriter(FILENAME_RELATIVE_PATH);
            writer.write(json);
            writer.close();
        } catch (IOException ex) {
            throw new ErrorDeEscrituraException();
        }
    }

    private JsonArray guardar(List<Pregunta> preguntasAEscribir) {

        JsonArray jsonArrayPreguntas = new JsonArray();
        for (Pregunta pregunta : preguntasAEscribir) {
            jsonArrayPreguntas.add(pregunta.guardar());
        }
        return jsonArrayPreguntas;
    }

    public Pregunta recuperar(JsonObject jsonPregunta) {
        //Dependiendo del tipo de pregunta lee el json de formas diferentes
        String tipoDePregunta = jsonPregunta.get("tipoDePregunta").getAsString();

        if (VerdaderoFalsoClasico.getNombreDePregunta().equals(tipoDePregunta)) {
            return VerdaderoFalsoClasico.recuperar(jsonPregunta);
        }
        if (VerdaderoFalsoConPenalidad.getNombreDePregunta().equals(tipoDePregunta)) {
            return VerdaderoFalsoConPenalidad.recuperar(jsonPregunta);
        }
        if (MultipleChoiceClasico.getNombreDePregunta().equals(tipoDePregunta)) {
            return MultipleChoiceClasico.recuperar(jsonPregunta);
        }
        if (MultipleChoiceParcial.getNombreDePregunta().equals(tipoDePregunta)) {
            return MultipleChoiceParcial.recuperar(jsonPregunta);
        }
        if (MultipleChoiceConPenalidad.getNombreDePregunta().equals(tipoDePregunta)) {
            return MultipleChoiceConPenalidad.recuperar(jsonPregunta);
        }
        if (OrderedChoice.getNombreDePregunta().equals(tipoDePregunta)) {
            return OrderedChoice.recuperar(jsonPregunta);
        }
        if (GroupChoice.getNombreDePregunta().equals(tipoDePregunta)) {
            return GroupChoice.recuperar(jsonPregunta);
        }
        return null;
    }

    public void leerPreguntas() {

        try {
            String texto = Files.readString(Path.of(FILENAME_RELATIVE_PATH));

            JsonArray arrayPreguntas = JsonParser.parseString(texto).getAsJsonArray();

            for (JsonElement jsonPregunta : arrayPreguntas) {
                Pregunta pregunta = this.recuperar(jsonPregunta.getAsJsonObject());
                preguntasDelJuego.add(pregunta);
            }
        } catch (IOException ex) {
            throw new ErrorDeLecturaException();
        }
    }

    public List<Pregunta> getPreguntas() {
        return preguntasDelJuego;
    }
}
