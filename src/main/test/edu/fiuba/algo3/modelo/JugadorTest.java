package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Excepciones.ErrorSinBonusesException;
import edu.fiuba.algo3.modelo.Excepciones.JugadorSinNombreException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class JugadorTest {

    @Test
    public void testCreaUnJugadorCorrectamente() {

        Jugador jugador = new Jugador("Pepito");

        assertEquals(0,jugador.getPuntaje().getPuntos());
        assertEquals("Pepito", jugador.getNombre());
        assertEquals(1, jugador.cantMultiplicadoresX2Restantes());
        assertEquals(1, jugador.cantMultiplicadoresX3Restantes());
        assertEquals(2, jugador.cantExclusividadesRestantes());
    }

    @Test
    public void testNoPuedeCrearUnJugadorSinNombre(){

        assertThrows(JugadorSinNombreException.class, ()-> new Jugador(""));
    }

    @Test
    public void testJugadorAumentaSusPuntosEn5(){

        Jugador jugador = new Jugador("Juan");
        jugador.sumarPuntos(new Puntaje(5));

        assertEquals(5, jugador.getPuntaje().getPuntos());
    }

    @Test
    public void testJugadorSinPuntosDisminuyeSusPuntosEnUnoYTieneUnPuntajeDeMenosUno(){

        Jugador jugador = new Jugador("Juan");
        jugador.sumarPuntos(new Puntaje(-1));

        assertEquals(-1, jugador.getPuntaje().getPuntos());
    }

    @Test
    public void testJugadorConPuntosDisminuyeSusPuntosPorDebajoDeCeroComoResultadoTienePuntajeNegativo(){

        Jugador jugador = new Jugador("Juan");
        jugador.sumarPuntos(new Puntaje(3));
        jugador.sumarPuntos(new Puntaje(-5));

        assertEquals(-2, jugador.getPuntaje().getPuntos());
    }

    @Test
    public void testJugadorConCuatroPuntosDisminuyeSusPuntosEnDos(){

        Jugador jugador = new Jugador("Juan");
        jugador.sumarPuntos(new Puntaje(4));
        jugador.sumarPuntos(new Puntaje(-2));

        assertEquals(2, jugador.getPuntaje().getPuntos());
    }

    @Test
    public void testSinBonusesExceptionSeLanzaCorrectamenteAlUtilizarExclusividad(){

        Jugador jugador = new Jugador("Juan");
        jugador.utilizarExclusividad();
        jugador.utilizarExclusividad();
        assertThrows(ErrorSinBonusesException.class, ()-> jugador.utilizarExclusividad());
    }

    @Test
    public void testSinBonusesExceptionSeLanzaCorrectamenteAlUtilizarMultiplicadorX2(){

        Jugador jugador = new Jugador("Juan");
        jugador.utilizarMultiplicadorX2();
        assertThrows(ErrorSinBonusesException.class, ()-> jugador.utilizarMultiplicadorX2());
    }

    @Test
    public void testSinBonusesExceptionSeLanzaCorrectamenteAlUtilizarMultiplicadorX3(){

        Jugador jugador = new Jugador("Juan");
        jugador.utilizarMultiplicadorX3();
        assertThrows(ErrorSinBonusesException.class, ()-> jugador.utilizarMultiplicadorX3());
    }
}