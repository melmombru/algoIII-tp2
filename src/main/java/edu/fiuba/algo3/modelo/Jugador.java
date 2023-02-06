package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Excepciones.ErrorSinBonusesException;
import edu.fiuba.algo3.modelo.Excepciones.JugadorSinNombreException;

public class Jugador {

    private final Puntaje puntaje;
    private String nombre;
    private int multiplicadoresX2Restantes;
    private int multiplicadoresX3Restantes;
    private int exclusividadesRestantes;

    public Jugador(String unNombre) {

        if (unNombre.trim().equals("")) {
            throw new JugadorSinNombreException();
        }
        nombre = unNombre;
        puntaje = new Puntaje();

        multiplicadoresX2Restantes = 1;
        multiplicadoresX3Restantes = 1;
        exclusividadesRestantes = 2;
    }

    public Puntaje getPuntaje() {
        return puntaje;
    }

    public String getNombre() {
        return nombre;
    }

    public void sumarPuntos(Puntaje unPuntaje) {
        puntaje.sumarPuntos(unPuntaje);
    }

    public void setNombre(String unNombre) {

        if (unNombre.trim().equals("")) {
            throw new JugadorSinNombreException();
        }
        nombre = unNombre;
    }

    public int cantMultiplicadoresX2Restantes(){ return multiplicadoresX2Restantes;}

    public int cantMultiplicadoresX3Restantes(){ return multiplicadoresX3Restantes;}

    public int cantExclusividadesRestantes(){ return exclusividadesRestantes;}

    public void utilizarExclusividad() {

        if (exclusividadesRestantes == 0) {
            throw new ErrorSinBonusesException();
        }
        exclusividadesRestantes--;
    }

    public void utilizarMultiplicadorX2 () {

        if (multiplicadoresX2Restantes == 0) {
            throw new ErrorSinBonusesException();
        }
        multiplicadoresX2Restantes--;
    }

    public void utilizarMultiplicadorX3() {

        if (multiplicadoresX3Restantes == 0) {
            throw new ErrorSinBonusesException();
        }
        multiplicadoresX3Restantes--;
    }
}
