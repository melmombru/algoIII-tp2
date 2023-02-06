package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.opciones.ListaOpciones;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import edu.fiuba.algo3.modelo.Preguntas.OrderedChoice;
import edu.fiuba.algo3.modelo.Respuestas.RespuestaEnLista;
import edu.fiuba.algo3.modelo.Excepciones.CantidadDeOpcionesInvalidaException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class OrderedChoiceTest {
    private String consigna;

    private Opcion opcion1ra;
    private Opcion opcion2da;
    private Opcion opcion3ra;

    private ListaOpciones listaDeOpciones;

    @BeforeEach
    public void setup() {
        consigna = "Ordenar los numeros de menor a mayor";

        opcion1ra = new Opcion("1");
        opcion2da = new Opcion("2");
        opcion3ra = new Opcion("3");

        listaDeOpciones = new ListaOpciones(new ArrayList<>(Arrays.asList(opcion1ra, opcion2da, opcion3ra)));
    }

    @Test
    public void testCrearOrderedChoice() {
        OrderedChoice orderedChoice = new OrderedChoice(consigna, listaDeOpciones);

        assertEquals("Ordenar los numeros de menor a mayor", orderedChoice.getConsigna());
        assert (orderedChoice.getOpciones().esIgual(listaDeOpciones));
    }

    @Test
    public void testCalculaPuntajeParaRespuestasOrdenadas() {
        OrderedChoice orderedChoice = new OrderedChoice(consigna, listaDeOpciones);

        ListaOpciones opcionesElegidas = new ListaOpciones(new ArrayList<>(Arrays.asList(opcion1ra, opcion2da, opcion3ra)));

        RespuestaEnLista respuestaEnLista = new RespuestaEnLista(opcionesElegidas);

        assertEquals(1, orderedChoice.calcularPuntajePara(respuestaEnLista).getPuntos());
    }

    @Test
    public void testCalculaPuntajeParaRespuestasDesordenadas() {
        OrderedChoice orderedChoice = new OrderedChoice(consigna, listaDeOpciones);

        ListaOpciones opcionesElegidas = new ListaOpciones(new ArrayList<>(Arrays.asList(opcion1ra, opcion3ra, opcion2da)));

        RespuestaEnLista respuestaEnLista = new RespuestaEnLista(opcionesElegidas);

        assertEquals(0, orderedChoice.calcularPuntajePara(respuestaEnLista).getPuntos());
    }

    @Test
    public void testOrederedChoiceLanzaExcepcionSiSeLeIngresanMenosDeDosOpciones() {
        Opcion opcionUnica = new Opcion("1");

        ListaOpciones listaDeOpcionesInvalida = new ListaOpciones(new ArrayList<>(Arrays.asList(opcionUnica)));

        assertThrows(CantidadDeOpcionesInvalidaException.class, () -> new OrderedChoice(consigna, listaDeOpcionesInvalida));
    }

    @Test
    public void testOrederedChoiceLanzaExcepcionSiSeLeIngresanMasDeCincoOpciones() {
        Opcion opcion1ra = new Opcion("1");
        Opcion opcion2da = new Opcion("2");
        Opcion opcion3ra = new Opcion("3");
        Opcion opcion4ta = new Opcion("4");
        Opcion opcion5ta = new Opcion("5");
        Opcion opcion6ta = new Opcion("6");

        ListaOpciones listaDeOpcionesInvalida = new ListaOpciones(new ArrayList<>(Arrays.asList(opcion1ra, opcion2da, opcion3ra, opcion4ta, opcion5ta, opcion6ta)));

        assertThrows(CantidadDeOpcionesInvalidaException.class, () -> new OrderedChoice(consigna, listaDeOpcionesInvalida));
    }
}