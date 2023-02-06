package edu.fiuba.algo3.modelo.bonus;

import edu.fiuba.algo3.modelo.Puntaje;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListaDeExclusividadesTest {

    @Test
    public void AplicarExclusividadesFuncionaCorrectamenteConTresMultiplicadores(){
        Puntaje puntaje1 = new Puntaje(2);
        Puntaje puntaje2 = new Puntaje(0);

        Exclusividad exclusividad = new Exclusividad();

        ListaDeExclusividades listaDeExclusividades = new ListaDeExclusividades(exclusividad);
        listaDeExclusividades.aplicarExclusividades(puntaje1, puntaje2);

        assertEquals(4, puntaje1.getPuntos());
        assertEquals(0, puntaje2.getPuntos());
    }

    @Test
    public void AplicarMultiplicadoresFuncionaCorrectamenteSinMultiplicadores(){
        Puntaje puntaje = new Puntaje(2);

        ListaDeMultiplicadores listaDeMultiplicadores = new ListaDeMultiplicadores();
        listaDeMultiplicadores.aplicarMultiplicadores(puntaje);

        assertEquals(2, puntaje.getPuntos());
    }
}
