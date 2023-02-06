package edu.fiuba.algo3.modelo;

import com.google.gson.JsonObject;

public class Puntaje {

    private int puntos;

    public Puntaje(){
        puntos = 0;
    }

    public Puntaje(int cantPuntos){
        puntos = cantPuntos;
    }

    public static Puntaje recuperar(JsonObject jsonPuntaje) {

        int puntos = jsonPuntaje.get("puntos").getAsInt();
        return new Puntaje(puntos);
    }

    public int getPuntos(){
        return puntos;
    }

    public void establecerPuntos(int cantPuntos){puntos = cantPuntos;}

    public void sumarPuntos(Puntaje unPuntaje){
        puntos += unPuntaje.getPuntos();
    }

    public void multiplicarPuntos(int factorDeMultiplicacion){
        puntos *= factorDeMultiplicacion;
    }

    public boolean esMenorQue(Puntaje otroPuntaje){
        return puntos < otroPuntaje.getPuntos();
    }

    public boolean esIgualQue(Puntaje otroPuntaje){
        return puntos == otroPuntaje.getPuntos();
    }

    public JsonObject guardar() {

        JsonObject jsonPuntaje = new JsonObject();
        jsonPuntaje.addProperty("puntos", puntos);
        return jsonPuntaje;
    }
}
