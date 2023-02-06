package edu.fiuba.algo3.modelo.bonus;

import edu.fiuba.algo3.modelo.Puntaje;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListaDeExclusividades {


    private final List<Exclusividad> exclusividades;

    public ListaDeExclusividades() {
        exclusividades = new ArrayList<>();
    }

    public ListaDeExclusividades(Exclusividad exclusividad) {

        exclusividades = new ArrayList<>();
        exclusividades.add(exclusividad);
    }

    public void agregarExclusividad(Exclusividad unaExclusividad){
        exclusividades.add(unaExclusividad);
    }

    public void aplicarExclusividades(Puntaje puntaje1, Puntaje puntaje2){

        Iterator<Exclusividad> iterador = exclusividades.iterator();

        for (int i = 0; i < exclusividades.size(); i++) {
            Exclusividad exclusividad = iterador.next();
            exclusividad.aplicarExclusividad(puntaje1, puntaje2);
        }
    }

    public void limpiarExclusividades(){
        exclusividades.clear();
    }
}
