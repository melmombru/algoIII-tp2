package edu.fiuba.algo3.modelo.bonus;

import edu.fiuba.algo3.modelo.Puntaje;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListaDeMultiplicadores {

    private final List<Multiplicador> multiplicadores;

    public ListaDeMultiplicadores() {
        multiplicadores = new ArrayList<>();
    }

    public ListaDeMultiplicadores(Multiplicador multiplicador) {

        multiplicadores = new ArrayList<>();
        multiplicadores.add(multiplicador);
    }

    public ListaDeMultiplicadores(List<Multiplicador> listMultiplicadores) {

        multiplicadores = new ArrayList<>();
        multiplicadores.addAll(listMultiplicadores);
    }

    public void agregarMultiplicador(Multiplicador unMultiplicador){
        multiplicadores.add(unMultiplicador);
    }

    public void aplicarMultiplicadores(Puntaje unPuntaje){

        Iterator<Multiplicador> iterador = multiplicadores.iterator();

        for (int i = 0; i < multiplicadores.size(); i++) {
            Multiplicador multiplicador = iterador.next();
            multiplicador.aplicarMultiplicador(unPuntaje);
        }
    }

    public void limpiarMultiplicadores(){
        multiplicadores.clear();
    }
}
