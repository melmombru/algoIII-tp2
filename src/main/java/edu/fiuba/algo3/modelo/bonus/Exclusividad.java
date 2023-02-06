package edu.fiuba.algo3.modelo.bonus;

import edu.fiuba.algo3.modelo.Puntaje;

public class Exclusividad {

    public void aplicarExclusividad(Puntaje puntajeJ1, Puntaje puntajeJ2){
        if(puntajeJ1.esIgualQue(new Puntaje()) || puntajeJ2.esIgualQue(new Puntaje())){
            puntajeJ1.multiplicarPuntos(2);
            puntajeJ2.multiplicarPuntos(2);
        }
        else{
            puntajeJ1.establecerPuntos(0);
            puntajeJ2.establecerPuntos(0);
        }
    }
}
