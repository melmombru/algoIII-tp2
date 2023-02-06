package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Preguntas.*;
import edu.fiuba.algo3.modelo.opciones.ListaOpciones;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ManejadorDeArchivosTest {
    @Test
    public void testSeCreaConUnListaDePreguntasVacia() {
        ManejadorDeArchivos manejadorDeArchivos = new ManejadorDeArchivos();

        List<Pregunta> preguntas = manejadorDeArchivos.getPreguntas();

        assertEquals(0, preguntas.size());
        assert (preguntas.isEmpty());
    }

    @Test
    public void testEscribeYLeeVerdaderoFalsoClasico() {
        ManejadorDeArchivos manejadorDeArchivos = new ManejadorDeArchivos();
        List<Pregunta> preguntasAEscribir = new ArrayList<>();

        VerdaderoFalsoClasico vofClasico = VerdaderoFalsoClasico.crearVerdaderoFalsoCorrectaVerdadero("consigna vof clasico");
        preguntasAEscribir.add(vofClasico);

        assert (manejadorDeArchivos.getPreguntas().isEmpty());

        manejadorDeArchivos.escribirPreguntas(preguntasAEscribir);
        manejadorDeArchivos.leerPreguntas();

        List<Pregunta> preguntas = manejadorDeArchivos.getPreguntas();
        VerdaderoFalsoClasico vofLeido = (VerdaderoFalsoClasico) preguntas.get(0);

        assertEquals(1, preguntas.size());
        assertEquals(vofClasico.getConsigna(), vofLeido.getConsigna());
        assert (vofClasico.getOpcionIncorrecta().esIgualA(vofLeido.getOpcionIncorrecta()));

    }

    @Test
    public void testEscribeYLeeVerdaderoFalsoConPenalidad() {
        ManejadorDeArchivos manejadorDeArchivos = new ManejadorDeArchivos();
        List<Pregunta> preguntasAEscribir = new ArrayList<>();

        VerdaderoFalsoConPenalidad vofConPenalidad = VerdaderoFalsoConPenalidad.crearVerdaderoFalsoCorrectoVerdadero("consigna vof con penalidad");
        preguntasAEscribir.add(vofConPenalidad);

        assert (manejadorDeArchivos.getPreguntas().isEmpty());

        manejadorDeArchivos.escribirPreguntas(preguntasAEscribir);
        manejadorDeArchivos.leerPreguntas();

        List<Pregunta> preguntas = manejadorDeArchivos.getPreguntas();
        VerdaderoFalsoConPenalidad vofLeido = (VerdaderoFalsoConPenalidad) preguntas.get(0);

        assertEquals(1, preguntas.size());
        assertEquals(vofConPenalidad.getConsigna(), vofLeido.getConsigna());
        assert (vofConPenalidad.getOpcionIncorrecta().esIgualA(vofLeido.getOpcionIncorrecta()));

    }

    @Test
    public void testEscribeYLeeMultipleChoiceClasico() {
        ManejadorDeArchivos manejadorDeArchivos = new ManejadorDeArchivos();
        List<Pregunta> preguntasAEscribir = new ArrayList<>();


        Opcion opcionCorrecta1 = new Opcion("opcion correcta 1", new Puntaje(1));
        Opcion opcionCorrecta2 = new Opcion("opcion correcta 2", new Puntaje(1));
        ListaOpciones opcionesCorrectas = new ListaOpciones(Arrays.asList(opcionCorrecta1, opcionCorrecta2));

        Opcion opcionIncorrecta1 = new Opcion("opcion incorrecta 1", new Puntaje(0));
        Opcion opcionIncorrecta2 = new Opcion("opcion incorrecta 2", new Puntaje(0));
        ListaOpciones opcionesIncorrectas = new ListaOpciones(Arrays.asList(opcionIncorrecta1, opcionIncorrecta2));


        MultipleChoiceClasico multipleChoiceClasico = new MultipleChoiceClasico("consigna multiple choice calsico", opcionesCorrectas, opcionesIncorrectas);
        preguntasAEscribir.add(multipleChoiceClasico);

        assert (manejadorDeArchivos.getPreguntas().isEmpty());

        manejadorDeArchivos.escribirPreguntas(preguntasAEscribir);
        manejadorDeArchivos.leerPreguntas();

        List<Pregunta> preguntas = manejadorDeArchivos.getPreguntas();
        MultipleChoiceClasico multipleChoiceLeido = (MultipleChoiceClasico) preguntas.get(0);

        assertEquals(1, preguntas.size());
        assertEquals(multipleChoiceClasico.getConsigna(), multipleChoiceLeido.getConsigna());
        assert (multipleChoiceClasico.getOpcionesCorrectas().esIgual(multipleChoiceLeido.getOpcionesCorrectas()));
        assert (multipleChoiceClasico.getOpcionesIncorrectas().esIgual(multipleChoiceLeido.getOpcionesIncorrectas()));

    }

    @Test
    public void testEscribeYLeeMultipleChoiceConPenalidad() {
        ManejadorDeArchivos manejadorDeArchivos = new ManejadorDeArchivos();
        List<Pregunta> preguntasAEscribir = new ArrayList<>();


        Opcion opcionCorrecta1 = new Opcion("opcion correcta 1", new Puntaje(1));
        Opcion opcionCorrecta2 = new Opcion("opcion correcta 2", new Puntaje(1));
        ListaOpciones opcionesCorrectas = new ListaOpciones(Arrays.asList(opcionCorrecta1, opcionCorrecta2));

        Opcion opcionIncorrecta1 = new Opcion("opcion incorrecta 1", new Puntaje(-1));
        Opcion opcionIncorrecta2 = new Opcion("opcion incorrecta 2", new Puntaje(-1));
        ListaOpciones opcionesIncorrectas = new ListaOpciones(Arrays.asList(opcionIncorrecta1, opcionIncorrecta2));


        MultipleChoiceConPenalidad multipleChoiceConPenalidad = new MultipleChoiceConPenalidad("consigna multiple choice con penalidad", opcionesCorrectas, opcionesIncorrectas);
        preguntasAEscribir.add(multipleChoiceConPenalidad);

        assert (manejadorDeArchivos.getPreguntas().isEmpty());

        manejadorDeArchivos.escribirPreguntas(preguntasAEscribir);
        manejadorDeArchivos.leerPreguntas();

        List<Pregunta> preguntas = manejadorDeArchivos.getPreguntas();
        MultipleChoiceConPenalidad multipleChoiceLeido = (MultipleChoiceConPenalidad) preguntas.get(0);

        assertEquals(1, preguntas.size());
        assertEquals(multipleChoiceConPenalidad.getConsigna(), multipleChoiceLeido.getConsigna());
        assert (multipleChoiceConPenalidad.getOpcionesCorrectas().esIgual(multipleChoiceLeido.getOpcionesCorrectas()));
        assert (multipleChoiceConPenalidad.getOpcionesIncorrectas().esIgual(multipleChoiceLeido.getOpcionesIncorrectas()));

    }

    @Test
    public void testEscribeYLeeMultipleChoiceParcial() {
        ManejadorDeArchivos manejadorDeArchivos = new ManejadorDeArchivos();
        List<Pregunta> preguntasAEscribir = new ArrayList<>();


        Opcion opcionCorrecta1 = new Opcion("opcion correcta 1", new Puntaje(1));
        Opcion opcionCorrecta2 = new Opcion("opcion correcta 2", new Puntaje(1));
        ListaOpciones opcionesCorrectas = new ListaOpciones(Arrays.asList(opcionCorrecta1, opcionCorrecta2));

        Opcion opcionIncorrecta1 = new Opcion("opcion incorrecta 1", new Puntaje(0));
        Opcion opcionIncorrecta2 = new Opcion("opcion incorrecta 2", new Puntaje(0));
        ListaOpciones opcionesIncorrectas = new ListaOpciones(Arrays.asList(opcionIncorrecta1, opcionIncorrecta2));


        MultipleChoiceParcial multipleChoiceParcial = new MultipleChoiceParcial("consigna multiple choice parcial", opcionesCorrectas, opcionesIncorrectas);
        preguntasAEscribir.add(multipleChoiceParcial);

        assert (manejadorDeArchivos.getPreguntas().isEmpty());

        manejadorDeArchivos.escribirPreguntas(preguntasAEscribir);
        manejadorDeArchivos.leerPreguntas();

        List<Pregunta> preguntas = manejadorDeArchivos.getPreguntas();
        MultipleChoiceParcial multipleChoiceLeido = (MultipleChoiceParcial) preguntas.get(0);

        assertEquals(1, preguntas.size());
        assertEquals(multipleChoiceParcial.getConsigna(), multipleChoiceLeido.getConsigna());
        assert (multipleChoiceParcial.getOpcionesCorrectas().esIgual(multipleChoiceLeido.getOpcionesCorrectas()));
        assert (multipleChoiceParcial.getOpcionesIncorrectas().esIgual(multipleChoiceLeido.getOpcionesIncorrectas()));

    }

    @Test
    public void testEscribeYLeeOrderdChoice() {
        ManejadorDeArchivos manejadorDeArchivos = new ManejadorDeArchivos();
        List<Pregunta> preguntasAEscribir = new ArrayList<>();


        Opcion opcion1 = new Opcion("opcion 1", new Puntaje(0));
        Opcion opcion2 = new Opcion("opcion 2", new Puntaje(0));
        Opcion opcion3 = new Opcion("opcion 3", new Puntaje(0));
        Opcion opcion4 = new Opcion("opcion 4", new Puntaje(0));
        ListaOpciones opcionesOrdenadas = new ListaOpciones(Arrays.asList(opcion1, opcion2, opcion3, opcion4));


        OrderedChoice orderedChoice = new OrderedChoice("consigna ordered choice", opcionesOrdenadas);
        preguntasAEscribir.add(orderedChoice);

        assert (manejadorDeArchivos.getPreguntas().isEmpty());

        manejadorDeArchivos.escribirPreguntas(preguntasAEscribir);
        manejadorDeArchivos.leerPreguntas();

        List<Pregunta> preguntas = manejadorDeArchivos.getPreguntas();
        OrderedChoice orderedChoiceLeido = (OrderedChoice) preguntas.get(0);

        assertEquals(1, preguntas.size());
        assertEquals(orderedChoice.getConsigna(), orderedChoiceLeido.getConsigna());
        assert (orderedChoice.getOpciones().esIgual(orderedChoiceLeido.getOpciones()));

    }

    @Test
    public void testEscribeYLeeGroupChoice() {
        ManejadorDeArchivos manejadorDeArchivos = new ManejadorDeArchivos();
        List<Pregunta> preguntasAEscribir = new ArrayList<>();
        String nombreGrupoA = "Grupo A";
        String nombreGrupoB = "Grupo B";

        Opcion opcionGrupoA1 = new Opcion("opcion grupo A 1", new Puntaje(0));
        Opcion opcionGrupoA2 = new Opcion("opcion grupo A 2", new Puntaje(0));
        ListaOpciones opcionesGrupoA = new ListaOpciones(Arrays.asList(opcionGrupoA1, opcionGrupoA2));

        Opcion opcionGrupoB1 = new Opcion("opcion grupo B 1", new Puntaje(0));
        Opcion opcionGrupoB2 = new Opcion("opcion grupo B 2", new Puntaje(0));
        ListaOpciones opcionesGrupoB = new ListaOpciones(Arrays.asList(opcionGrupoB1, opcionGrupoB2));

        GroupChoice groupChoice = new GroupChoice("consigna ordered choice", nombreGrupoA, opcionesGrupoA, nombreGrupoB, opcionesGrupoB);
        preguntasAEscribir.add(groupChoice);

        assert (manejadorDeArchivos.getPreguntas().isEmpty());

        manejadorDeArchivos.escribirPreguntas(preguntasAEscribir);
        manejadorDeArchivos.leerPreguntas();

        List<Pregunta> preguntas = manejadorDeArchivos.getPreguntas();
        GroupChoice groupChoiceLeido = (GroupChoice) preguntas.get(0);

        assertEquals(1, preguntas.size());
        assertEquals(groupChoice.getConsigna(), groupChoiceLeido.getConsigna());
        assertEquals(groupChoice.getNombreGrupoA(), groupChoiceLeido.getNombreGrupoA());
        assertEquals(groupChoice.getNombreGrupoB(), groupChoiceLeido.getNombreGrupoB());
        assert (groupChoice.getOpcionesGrupoA().esIgual(groupChoiceLeido.getOpcionesGrupoA()));
        assert (groupChoice.getOpcionesGrupoB().esIgual(groupChoiceLeido.getOpcionesGrupoB()));

    }
}