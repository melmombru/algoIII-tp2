package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PuntajeTest {

    @Test
    public void unPuntajeSeCreaConCeroPuntos(){
        Puntaje puntaje = new Puntaje();
        assertEquals(0, puntaje.getPuntos());
    }

    @Test
    public void unPuntajeSeCreaConUnaCantDePuntos(){
        Puntaje puntaje = new Puntaje(8);
        assertEquals(8, puntaje.getPuntos());
    }

    @Test
    public void unPuntajeSeSumaCorrectamenteOtroPuntaje(){
        Puntaje puntaje = new Puntaje();
        Puntaje otroPuntaje = new Puntaje(8);
        puntaje.sumarPuntos(otroPuntaje);
        assertEquals(8, puntaje.getPuntos());
    }

    @Test
    public void unPuntajeSemultiplicaCorrectamente(){
        Puntaje puntaje = new Puntaje(2);
        puntaje.multiplicarPuntos(4);
        assertEquals(8, puntaje.getPuntos());
    }

    @Test
    public void establecerPuntosFuncionaCorrectamente(){
        Puntaje puntaje = new Puntaje(12);
        puntaje.establecerPuntos(5);
        assertEquals(5, puntaje.getPuntos());
    }

    @Test
    public void comparaCorrectamenteCualEsElMenorPuntaje(){
        Puntaje puntaje = new Puntaje(10);
        Puntaje otroPuntaje = new Puntaje(12);
        assertTrue(puntaje.esMenorQue(otroPuntaje));

    }

    @Test
    public void comparaCorrectamenteQueSeanIgualesDosPuntajes(){
        Puntaje puntaje = new Puntaje(4);
        Puntaje otroPuntaje = new Puntaje(4);

        assertTrue(puntaje.esIgualQue(otroPuntaje));
    }

    @Test
    public void comparaCorrectamenteQueNoSeanIgualesDosPuntajes(){
        Puntaje puntaje = new Puntaje(4);
        Puntaje otroPuntaje = new Puntaje(5);

        assertFalse(puntaje.esIgualQue(otroPuntaje));
    }

}
