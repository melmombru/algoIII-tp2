package edu.fiuba.algo3.modelo.bonus;

import edu.fiuba.algo3.modelo.Puntaje;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExclusividadTest {

    @Test
    public void testAplicoExclusividadADosPuntajesPositivos(){
        Exclusividad exclusividad = new Exclusividad();
        Puntaje puntaje1 = new Puntaje(1);
        Puntaje puntaje2 = new Puntaje(1);

        exclusividad.aplicarExclusividad(puntaje1, puntaje2);

        assertEquals(0, puntaje1.getPuntos());
        assertEquals(0, puntaje2.getPuntos());
    }

    @Test
    public void testAplicoExclusividadADosPuntajesNulos(){
        Exclusividad exclusividad = new Exclusividad();
        Puntaje puntaje1 = new Puntaje(0);
        Puntaje puntaje2 = new Puntaje(0);

        exclusividad.aplicarExclusividad(puntaje1, puntaje2);

        assertEquals(0, puntaje1.getPuntos());
        assertEquals(0, puntaje2.getPuntos());
    }

    @Test
    public void testAplicoExclusividadAUnUnPuntajePositivoYOtroNulo(){
        Exclusividad exclusividad = new Exclusividad();
        Puntaje puntaje1 = new Puntaje(1);
        Puntaje puntaje2 = new Puntaje(0);

        exclusividad.aplicarExclusividad(puntaje1, puntaje2);

        assertEquals(2, puntaje1.getPuntos());
        assertEquals(0, puntaje2.getPuntos());
    }
}
