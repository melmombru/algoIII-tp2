package edu.fiuba.algo3.modelo.bonus;

import edu.fiuba.algo3.modelo.Puntaje;

public class BonusDePuntaje {

    public static void aplicarbonus(Puntaje puntajeJ1, ListaDeMultiplicadores multiplicadoresJ1, Puntaje puntajeJ2, ListaDeMultiplicadores multiplicadoresJ2, ListaDeExclusividades exclusividades){

        multiplicadoresJ1.aplicarMultiplicadores(puntajeJ1);
        multiplicadoresJ2.aplicarMultiplicadores(puntajeJ2);
        exclusividades.aplicarExclusividades(puntajeJ1, puntajeJ2);
    }
}
