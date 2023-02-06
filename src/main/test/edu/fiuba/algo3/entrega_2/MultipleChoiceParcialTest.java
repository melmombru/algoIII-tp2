package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Preguntas.MultipleChoiceParcial;
import edu.fiuba.algo3.modelo.Respuestas.RespuestaEnLista;
import edu.fiuba.algo3.modelo.opciones.ListaOpciones;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class MultipleChoiceParcialTest {
    @Test
    public void testCrearMultipleChoiceParcial() {

        ListaOpciones opcionesCorrectas = new ListaOpciones();
        ListaOpciones respuestasIncorrectas = new ListaOpciones();
        String consigna = "Indicar cuales de las siguientes opciones son quesos";

        Opcion opcionCorrectaCheddar = new Opcion("Cheddar");
        Opcion opcionCorrectaRoquefort = new Opcion("Roquefort");
        Opcion opcionIncorrectaKetchup = new Opcion("Ketchup");

        opcionesCorrectas.agregar(opcionCorrectaCheddar);
        opcionesCorrectas.agregar(opcionCorrectaRoquefort);

        respuestasIncorrectas.agregar(opcionIncorrectaKetchup);

        MultipleChoiceParcial multipleChoiceParcial = new MultipleChoiceParcial(consigna, opcionesCorrectas, respuestasIncorrectas);

        assertEquals("Indicar cuales de las siguientes opciones son quesos", multipleChoiceParcial.getConsigna());
        assert (multipleChoiceParcial.getOpcionesCorrectas().contieneLoMismo(opcionesCorrectas));
        assert (multipleChoiceParcial.getOpcionesIncorrectas().contieneLoMismo(respuestasIncorrectas));
    }

    @Test
    public void testAplicaPuntajeAUnJugadorDeDosRespuestasCorrectas() {

        String consigna = "Indicar cuales de las siguientes opciones son letras griegas";

        Opcion opcionCorrectaAlpha = new Opcion("Alpha", new Puntaje(1));
        Opcion opcionCorrectaBetta = new Opcion("Betta", new Puntaje(1));
        Opcion opcionIncorrectaJota = new Opcion("Jota", new Puntaje(0));

        ListaOpciones respuestasCorrectas = new ListaOpciones(new ArrayList<>(Arrays.asList(opcionCorrectaAlpha, opcionCorrectaBetta)));
        ListaOpciones respuestasIncorrectas = new ListaOpciones(new ArrayList<>(Arrays.asList(opcionIncorrectaJota)));

        MultipleChoiceParcial multipleChoiceParcial = new MultipleChoiceParcial(consigna, respuestasCorrectas, respuestasIncorrectas);

        Jugador jugador = new Jugador("Pepe");

        ListaOpciones opcionesSeleccionadas = new ListaOpciones(new ArrayList<>(Arrays.asList(opcionCorrectaAlpha, opcionCorrectaBetta)));
        RespuestaEnLista respuestaDelJugador = new RespuestaEnLista(opcionesSeleccionadas);

        assertEquals(2, multipleChoiceParcial.evaluarRespuestaPara(respuestaDelJugador).getPuntos());
    }

    @Test
    public void testAplicaPuntajeDeUnaListaDeRespuestasAdivinandoUno() {
        ListaOpciones respuestasCorrectas = new ListaOpciones();
        ListaOpciones respuestasIncorrectas = new ListaOpciones();
        String consigna = "Indicar cuales de las siguientes opciones son letras griegas";

        Opcion opcionCorrectaAlpha = new Opcion("Alpha", new Puntaje(1));
        Opcion opcionCorrectaBetta = new Opcion("Betta", new Puntaje(1));
        Opcion opcionIncorrectaJota = new Opcion("Jota", new Puntaje(0));

        respuestasCorrectas.agregar(opcionCorrectaAlpha);
        respuestasCorrectas.agregar(opcionCorrectaBetta);
        respuestasIncorrectas.agregar(opcionIncorrectaJota);

        MultipleChoiceParcial multipleChoiceParcial = new MultipleChoiceParcial(consigna, respuestasCorrectas, respuestasIncorrectas);

        Jugador jugador = new Jugador("Pepe");

        ListaOpciones opcionesSeleccionadas = new ListaOpciones(new ArrayList<>(Arrays.asList(opcionCorrectaAlpha)));
        RespuestaEnLista respuestaDelJugador = new RespuestaEnLista(opcionesSeleccionadas);

        assertEquals(1, multipleChoiceParcial.evaluarRespuestaPara(respuestaDelJugador).getPuntos());
    }

    @Test
    public void testAplicaPuntajeDeUnaRespuestaCorrectaYOtraIncorrectaSumandoCeroPuntos() {
        ListaOpciones respuestasCorrectas = new ListaOpciones();
        ListaOpciones respuestasIncorrectas = new ListaOpciones();
        String consigna = "Indicar cuales de las siguientes opciones son letras griegas";

        Opcion opcionCorrectaAlpha = new Opcion("Alpha");
        Opcion opcionCorrectaBetta = new Opcion("Betta");
        Opcion opcionIncorrectaJota = new Opcion("Jota");

        respuestasCorrectas.agregar(opcionCorrectaAlpha);
        respuestasCorrectas.agregar(opcionCorrectaBetta);
        respuestasIncorrectas.agregar(opcionIncorrectaJota);

        MultipleChoiceParcial multipleChoiceParcial = new MultipleChoiceParcial(consigna, respuestasCorrectas, respuestasIncorrectas);

        Jugador jugador = new Jugador("Pepe");

        ListaOpciones opcionesSeleccionadas = new ListaOpciones(new ArrayList<>(Arrays.asList(opcionCorrectaAlpha,opcionIncorrectaJota)));
        RespuestaEnLista respuestaDelJugador = new RespuestaEnLista(opcionesSeleccionadas);

        assertEquals(0, multipleChoiceParcial.evaluarRespuestaPara(respuestaDelJugador).getPuntos());
    }

    @Test
    public void testAplicaElPuntajeDeTodasLasRespuestasIncorrectas() {
        ListaOpciones respuestasCorrectas = new ListaOpciones();
        ListaOpciones respuestasIncorrectas = new ListaOpciones();
        String consigna = "Indicar cuales de las siguientes opciones son letras griegas";

        Opcion opcionCorrectaAlpha = new Opcion("Alpha");
        Opcion opcionInorrectaDobleV = new Opcion("DobleV");
        Opcion opcionIncorrectaJota = new Opcion("Jota");

        respuestasCorrectas.agregar(opcionCorrectaAlpha);
        respuestasIncorrectas.agregar(opcionInorrectaDobleV);
        respuestasIncorrectas.agregar(opcionIncorrectaJota);

        MultipleChoiceParcial multipleChoiceParcial = new MultipleChoiceParcial(consigna, respuestasCorrectas, respuestasIncorrectas);

        Jugador jugador = new Jugador("Pepe");

        ListaOpciones opcionesSeleccionadas = new ListaOpciones(new ArrayList<>(Arrays.asList(opcionInorrectaDobleV,opcionIncorrectaJota)));
        RespuestaEnLista respuestaDelJugador = new RespuestaEnLista(opcionesSeleccionadas);

        assertEquals(0, multipleChoiceParcial.evaluarRespuestaPara(respuestaDelJugador).getPuntos());
    }
}
