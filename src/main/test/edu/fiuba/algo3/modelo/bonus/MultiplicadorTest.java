package edu.fiuba.algo3.modelo.bonus;

import edu.fiuba.algo3.modelo.Puntaje;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultiplicadorTest {
    @Test
    public void testSeAplicaUnMultiplicadorPorTresCorrectamenteALPuntajeDeUnJugador(){
        Multiplicador mx3 = new Multiplicador(3);
        Puntaje puntaje = new Puntaje(3);

        mx3.aplicarMultiplicador(puntaje);

        assertEquals(9, puntaje.getPuntos());
    }
}
