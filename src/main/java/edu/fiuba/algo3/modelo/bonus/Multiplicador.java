package edu.fiuba.algo3.modelo.bonus;

import edu.fiuba.algo3.modelo.Puntaje;

public class Multiplicador {

    private int factorDeMultiplicacion;

    public Multiplicador (int unFactorDeMultiplicacion) {

        factorDeMultiplicacion = unFactorDeMultiplicacion;
    }

    public void aplicarMultiplicador(Puntaje unPuntaje) {

        unPuntaje.multiplicarPuntos(factorDeMultiplicacion);
    }
}
