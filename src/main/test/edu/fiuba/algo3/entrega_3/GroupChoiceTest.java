package edu.fiuba.algo3.entrega_3;


import edu.fiuba.algo3.modelo.Preguntas.GroupChoice;
import edu.fiuba.algo3.modelo.opciones.ListaOpciones;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import edu.fiuba.algo3.modelo.Respuestas.RespuestaDeGrupos;
import edu.fiuba.algo3.modelo.Excepciones.CantidadDeOpcionesInvalidaException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GroupChoiceTest {

    private String consigna;
    private String nombreGrupoA;
    private String nombreGrupoB;

    private Opcion opcion1DeGrupoA;
    private Opcion opcion2DeGrupoA;
    private Opcion opcion1DeGrupoB;
    private Opcion opcion2DeGrupoB;

    private ListaOpciones opcionesGrupoA;
    private ListaOpciones opcionesGrupoB;

    @BeforeEach
    public void setup() {
        consigna = "Agrupe en las categorias A y B:";
        nombreGrupoA = "Grupo A";
        nombreGrupoB = "Grupo B";

        opcion1DeGrupoA = new Opcion("respuesta1GrupoA");
        opcion2DeGrupoA = new Opcion("respuesta2GrupoA");
        opcion1DeGrupoB = new Opcion("respuesta1GrupoB");
        opcion2DeGrupoB = new Opcion("respuesta2GrupoB");

        opcionesGrupoA = new ListaOpciones(new ArrayList<>(Arrays.asList(opcion1DeGrupoA, opcion2DeGrupoA)));
        opcionesGrupoB = new ListaOpciones(new ArrayList<>(Arrays.asList(opcion1DeGrupoB, opcion2DeGrupoB)));
    }


    @Test
    public void testCrearGroupChoiceCorrectamente() {
        GroupChoice preguntaGroupChoice = new GroupChoice(consigna, nombreGrupoA, opcionesGrupoA, nombreGrupoB, opcionesGrupoB);

        assertEquals("Agrupe en las categorias A y B:", preguntaGroupChoice.getConsigna());
        assert (preguntaGroupChoice.getOpcionesGrupoA().contieneLoMismo(opcionesGrupoA));
        assert (preguntaGroupChoice.getOpcionesGrupoB().contieneLoMismo(opcionesGrupoB));
    }

    @Test
    public void testGroupChoiceLanzaExcepcionSiSeLeIngresan7Opciones() {
        String consigna = "Agrupe las opciones en dos grupos";

        Opcion opcion1DeGrupoA = new Opcion("respuestaGrupoA1");
        Opcion opcion2DeGrupoA = new Opcion("respuestaGrupoA2");
        Opcion opcion3DeGrupoA = new Opcion("respuestaGrupoA3");
        Opcion opcion4DeGrupoA = new Opcion("respuestaGrupoA4");
        Opcion opcion1DeGrupoB = new Opcion("respuestaGrupoB1");
        Opcion opcion2DeGrupoB = new Opcion("respuestaGrupoB2");
        Opcion opcion3DeGrupoB = new Opcion("respuestaGrupoB3");

        ListaOpciones opcionesGrupoA = new ListaOpciones(new ArrayList<>(Arrays.asList(opcion1DeGrupoA, opcion2DeGrupoA, opcion3DeGrupoA, opcion4DeGrupoA)));
        ListaOpciones opcionesGrupoB = new ListaOpciones(new ArrayList<>(Arrays.asList(opcion1DeGrupoB, opcion2DeGrupoB, opcion3DeGrupoB)));

        assertThrows(CantidadDeOpcionesInvalidaException.class, () -> new GroupChoice(consigna, nombreGrupoA, opcionesGrupoA, nombreGrupoB, opcionesGrupoB));
    }

    @Test
    public void testGroupChoiceLanzaExcepcionSiSeLeIngresa1Opcion() {
        String consigna = "Agrupe las opciones en dos grupos";

        Opcion opcion1DeGrupoA = new Opcion("respuestaGrupoA");

        ListaOpciones opcionesGrupoA = new ListaOpciones(new ArrayList<>(Arrays.asList(opcion1DeGrupoA)));
        ListaOpciones opcionesGrupoB = new ListaOpciones(new ArrayList<>());

        assertThrows(CantidadDeOpcionesInvalidaException.class, () -> new GroupChoice(consigna, nombreGrupoA, opcionesGrupoA, nombreGrupoA, opcionesGrupoB));
    }

    @Test
    public void testLeAsignaUnPuntoDeUnaRespuestaDeGruposCorrecta() {
        GroupChoice preguntaGroupChoice = new GroupChoice(consigna, nombreGrupoA, opcionesGrupoA, nombreGrupoB, opcionesGrupoB);

        RespuestaDeGrupos respuestasDelJugador = new RespuestaDeGrupos(opcionesGrupoA, opcionesGrupoB);

        assertEquals(1, preguntaGroupChoice.evaluarRespuestaPara(respuestasDelJugador).getPuntos());
    }

    @Test
    public void testLeAsignaCeroPuntosConUnaRespuestaDeGruposCorrectaYTresIncorrectas() {
        GroupChoice preguntaGroupChoice = new GroupChoice(consigna, nombreGrupoA, opcionesGrupoA, nombreGrupoB, opcionesGrupoB);

        ListaOpciones opcionesDelJugadorGrupoA = new ListaOpciones(new ArrayList<>(Arrays.asList(opcion1DeGrupoA, opcion1DeGrupoB, opcion2DeGrupoB)));
        ListaOpciones opcionesDelJugadorGrupoB = new ListaOpciones(new ArrayList<>(Arrays.asList(opcion2DeGrupoA)));

        RespuestaDeGrupos respuestasDelJugador = new RespuestaDeGrupos(opcionesDelJugadorGrupoA, opcionesDelJugadorGrupoB);

        assertEquals(0, preguntaGroupChoice.evaluarRespuestaPara(respuestasDelJugador).getPuntos());
    }

    @Test
    public void testLeAsignaCeroPuntosConUnaRespuestaDeGruposIncorrecta() {
        GroupChoice preguntaGroupChoice = new GroupChoice(consigna, nombreGrupoA, opcionesGrupoA, nombreGrupoB, opcionesGrupoB);

        RespuestaDeGrupos respuestasDelJugador = new RespuestaDeGrupos(opcionesGrupoB, opcionesGrupoA);

        assertEquals(0, preguntaGroupChoice.evaluarRespuestaPara(respuestasDelJugador).getPuntos());
    }


}
