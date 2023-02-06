package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.Excepciones.CantidadDeOpcionesInvalidaException;
import edu.fiuba.algo3.modelo.Preguntas.MultipleChoiceParcial;
import edu.fiuba.algo3.modelo.Puntaje;
import edu.fiuba.algo3.modelo.Respuestas.RespuestaEnLista;
import edu.fiuba.algo3.modelo.bonus.Exclusividad;
import edu.fiuba.algo3.modelo.opciones.ListaOpciones;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class MultipleChoiceParcialTest {
    @Test
    public void testCrearMultipleChoiceParcial() {

        String consigna = "Indicar cuales de las siguientes opciones son quesos";

        Opcion opcionCorrectaCheddar = new Opcion("Cheddar");
        Opcion opcionCorrectaRoquefort = new Opcion("Roquefort");
        Opcion opcionIncorrectaKetchup = new Opcion("Ketchup");

        ListaOpciones opcionesCorrectas = opcionCorrectaCheddar.con(opcionCorrectaRoquefort);
        ListaOpciones opcionesIncorrectas = new ListaOpciones();
        opcionesIncorrectas.agregar(opcionIncorrectaKetchup);

        MultipleChoiceParcial multipleChoiceParcial = new MultipleChoiceParcial(consigna, opcionesCorrectas, opcionesIncorrectas);

        assertEquals("Indicar cuales de las siguientes opciones son quesos", multipleChoiceParcial.getConsigna());
        assert (multipleChoiceParcial.getOpcionesCorrectas().contieneLoMismo(opcionesCorrectas));
        assert (multipleChoiceParcial.getOpcionesIncorrectas().contieneLoMismo(opcionesIncorrectas));
    }

    @Test
    public void testMultipleChoiceParcialLanzaExcepcionSiSeLeIngresan6Opciones() {

        String consigna = "Indicar cuáles de las siguientes opciones son colores";

        Opcion opcionCorrecta1 = new Opcion("Amarillo");
        Opcion opcionCorrecta2 = new Opcion("Azul");
        Opcion opcionCorrecta3 = new Opcion("Verde");
        Opcion opcionCorrecta4 = new Opcion("Rojo");
        Opcion opcionIncorrecta1 = new Opcion("Tractor");
        Opcion opcionIncorrecta2 = new Opcion("Auto");

        ListaOpciones opcionesCorrectas = opcionCorrecta1.con(opcionCorrecta2).con(opcionCorrecta3).con(opcionCorrecta4);
        ListaOpciones opcionesIncorrectas = opcionIncorrecta1.con(opcionIncorrecta2);

        assertThrows(CantidadDeOpcionesInvalidaException.class, () -> new MultipleChoiceParcial(consigna, opcionesCorrectas, opcionesIncorrectas));
    }

    @Test
    public void testMultipleChoiceParcialLanzaExcepcionSiSeLeIngresa1Opcion() {
        ListaOpciones respuestasCorrectas = new ListaOpciones();
        ListaOpciones respuestasIncorrectas = new ListaOpciones();
        String consigna = "Indicar cuáles de las siguientes opciones son colores";

        Opcion opcionCorrecta1 = new Opcion("Amarillo");

        respuestasCorrectas.agregar(opcionCorrecta1);

        assertThrows(CantidadDeOpcionesInvalidaException.class, () -> new MultipleChoiceParcial(consigna, respuestasCorrectas, respuestasIncorrectas));
    }

    @Test
    public void testAplicaPuntajeAUnJugadorDeDosopcionesCorrectas() {

        String consigna = "Indicar cuales de las siguientes opciones son letras griegas";

        Opcion opcionCorrectaAlpha = new Opcion("Alpha", new Puntaje(1));
        Opcion opcionCorrectaBetta = new Opcion("Betta", new Puntaje(1));
        Opcion opcionIncorrectaJota = new Opcion("Jota", new Puntaje(0));

        ListaOpciones opcionesCorrectas = opcionCorrectaAlpha.con(opcionCorrectaBetta);
        ListaOpciones opcionesIncorrectas = new ListaOpciones();
        opcionesIncorrectas.agregar(opcionIncorrectaJota);

        MultipleChoiceParcial multipleChoiceParcial = new MultipleChoiceParcial(consigna, opcionesCorrectas, opcionesIncorrectas);

        ListaOpciones opcionesElegidas = opcionCorrectaAlpha.con(opcionCorrectaBetta);
        RespuestaEnLista respuestaDelJugador = new RespuestaEnLista(opcionesElegidas);

        assertEquals(2, multipleChoiceParcial.evaluarRespuestaPara(respuestaDelJugador).getPuntos());
    }

    @Test
    public void testAplicaPuntajeDeUnaListaDeopcionesAdivinandoUno() {
        String consigna = "Indicar cuales de las siguientes opciones son letras griegas";

        Opcion opcionCorrectaAlpha = new Opcion("Alpha", new Puntaje(1));
        Opcion opcionCorrectaBetta = new Opcion("Betta", new Puntaje(1));
        Opcion opcionIncorrectaJota = new Opcion("Jota", new Puntaje(0));

        ListaOpciones opcionesCorrectas = opcionCorrectaAlpha.con(opcionCorrectaBetta);
        ListaOpciones opcionesIncorrectas = new ListaOpciones();
        opcionesIncorrectas.agregar(opcionIncorrectaJota);

        MultipleChoiceParcial multipleChoiceParcial = new MultipleChoiceParcial(consigna, opcionesCorrectas, opcionesIncorrectas);

        ListaOpciones opcionesElegidas = new ListaOpciones();
        opcionesElegidas.agregar(opcionCorrectaAlpha);

        RespuestaEnLista respuestaDelJugador = new RespuestaEnLista(opcionesElegidas);

        assertEquals(1, multipleChoiceParcial.evaluarRespuestaPara(respuestaDelJugador).getPuntos());
    }

    @Test
    public void testAplicaPuntajeDeUnaRespuestaCorrectaYOtraIncorrectaSumandoCeroPuntos() {
        String consigna = "Indicar cuales de las siguientes opciones son letras griegas";

        Opcion opcionCorrectaAlpha = new Opcion("Alpha", new Puntaje(1));
        Opcion opcionCorrectaBetta = new Opcion("Betta", new Puntaje(1));
        Opcion opcionIncorrectaJota = new Opcion("Jota", new Puntaje(0));

        ListaOpciones opcionesCorrectas = opcionCorrectaAlpha.con(opcionCorrectaBetta);
        ListaOpciones opcionesIncorrectas = new ListaOpciones();
        opcionesIncorrectas.agregar(opcionIncorrectaJota);

        MultipleChoiceParcial multipleChoiceParcial = new MultipleChoiceParcial(consigna, opcionesCorrectas, opcionesIncorrectas);

        ListaOpciones opcionesElegidas = opcionCorrectaAlpha.con(opcionIncorrectaJota);

        RespuestaEnLista respuestaDelJugador = new RespuestaEnLista(opcionesElegidas);

        assertEquals(0, multipleChoiceParcial.evaluarRespuestaPara(respuestaDelJugador).getPuntos());
    }

    @Test
    public void testAplicaElPuntajeDeTodasLasopcionesIncorrectas() {
        String consigna = "Indicar cuales de las siguientes opciones son letras griegas";

        Opcion opcionCorrectaAlpha = new Opcion("Alpha", new Puntaje(1));
        Opcion opcionInorrectaDobleV = new Opcion("DobleV", new Puntaje(0));
        Opcion opcionIncorrectaJota = new Opcion("Jota", new Puntaje(0));

        ListaOpciones opcionesCorrectas = new ListaOpciones();
        opcionesCorrectas.agregar(opcionCorrectaAlpha);
        ListaOpciones opcionesIncorrectas = opcionIncorrectaJota.con(opcionInorrectaDobleV);

        MultipleChoiceParcial multipleChoiceParcial = new MultipleChoiceParcial(consigna, opcionesCorrectas, opcionesIncorrectas);

        ListaOpciones opcionesElegidas = new ListaOpciones();
        opcionesElegidas.agregar(opcionInorrectaDobleV);
        opcionesElegidas.agregar(opcionIncorrectaJota);

        RespuestaEnLista respuestaDelJugador = new RespuestaEnLista(opcionesElegidas);

        assertEquals(0, multipleChoiceParcial.evaluarRespuestaPara(respuestaDelJugador).getPuntos());
    }

    @Test
    public void testSeVerificaQueSePuedaUtilizarExclusividad() {
        String consigna = "Indicar cuales de las siguientes opciones son letras griegas";

        Opcion opcionCorrectaAlpha = new Opcion("Alpha", new Puntaje(1));
        Opcion opcionInorrectaDobleV = new Opcion("DobleV", new Puntaje(0));
        Opcion opcionIncorrectaJota = new Opcion("Jota", new Puntaje(0));

        ListaOpciones opcionesCorrectas = new ListaOpciones();
        opcionesCorrectas.agregar(opcionCorrectaAlpha);
        ListaOpciones opcionesIncorrectas = opcionIncorrectaJota.con(opcionInorrectaDobleV);


        MultipleChoiceParcial multipleChoiceParcial = new MultipleChoiceParcial(consigna, opcionesCorrectas, opcionesIncorrectas);
        assert (multipleChoiceParcial.getExclusividad().getClass() == Exclusividad.class);
    }
}
