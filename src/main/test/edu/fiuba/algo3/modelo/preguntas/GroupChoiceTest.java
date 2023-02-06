package edu.fiuba.algo3.modelo.preguntas;


import edu.fiuba.algo3.modelo.Excepciones.CantidadDeOpcionesInvalidaException;
import edu.fiuba.algo3.modelo.Preguntas.GroupChoice;
import edu.fiuba.algo3.modelo.Respuestas.RespuestaDeGrupos;
import edu.fiuba.algo3.modelo.bonus.Exclusividad;
import edu.fiuba.algo3.modelo.opciones.ListaOpciones;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

        opcionesGrupoA = opcion1DeGrupoA.con(opcion2DeGrupoA);
        opcionesGrupoB = opcion1DeGrupoB.con(opcion2DeGrupoB);
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

        ListaOpciones opcionesGrupoA = opcion1DeGrupoA.con(opcion2DeGrupoA).con(opcion3DeGrupoA).con(opcion4DeGrupoA);
        ListaOpciones opcionesGrupoB = opcion1DeGrupoB.con(opcion2DeGrupoB).con(opcion3DeGrupoB);

        assertThrows(CantidadDeOpcionesInvalidaException.class, () -> new GroupChoice(consigna, nombreGrupoA, opcionesGrupoA, nombreGrupoB, opcionesGrupoB));
    }

    @Test
    public void testGroupChoiceLanzaExcepcionSiSeLeIngresa1Opcion() {
        ListaOpciones opcionesGrupoA = new ListaOpciones();
        opcionesGrupoA.agregar(opcion1DeGrupoA);
        ListaOpciones opcionesGrupoB = new ListaOpciones();

        assertThrows(CantidadDeOpcionesInvalidaException.class, () -> new GroupChoice(consigna, nombreGrupoA, opcionesGrupoA, nombreGrupoB, opcionesGrupoB));
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

        ListaOpciones opcionesDelJugadorGrupoA = opcion1DeGrupoA.con(opcion1DeGrupoB).con(opcion2DeGrupoB);
        ListaOpciones opcionesDelJugadorGrupoB = new ListaOpciones();
        opcionesDelJugadorGrupoB.agregar(opcion2DeGrupoA);

        RespuestaDeGrupos respuestasDelJugador = new RespuestaDeGrupos(opcionesDelJugadorGrupoA, opcionesDelJugadorGrupoB);

        assertEquals(0, preguntaGroupChoice.evaluarRespuestaPara(respuestasDelJugador).getPuntos());
    }

    @Test
    public void testLeAsignaCeroPuntosConUnaRespuestaDeGruposIncorrecta() {
        GroupChoice preguntaGroupChoice = new GroupChoice(consigna, nombreGrupoA, opcionesGrupoA, nombreGrupoB, opcionesGrupoB);

        RespuestaDeGrupos respuestasDelJugador = new RespuestaDeGrupos(opcionesGrupoB, opcionesGrupoA);

        assertEquals(0, preguntaGroupChoice.evaluarRespuestaPara(respuestasDelJugador).getPuntos());
    }


    @Test
    public void testSeVerificaQueSePuedaUtilizarExclusividad() {
        GroupChoice preguntaGroupChoice = new GroupChoice(consigna, nombreGrupoA, opcionesGrupoA, nombreGrupoB, opcionesGrupoB);
        assert (preguntaGroupChoice.getExclusividad().getClass() == Exclusividad.class);
    }
}
