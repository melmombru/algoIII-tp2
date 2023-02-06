package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.TiempoEventHandler;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.ManejadorDeTurnos;
import edu.fiuba.algo3.modelo.Respuestas.Respuesta;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class EtiquetaTiempo {

    private static final Integer inicialTiempo = 30;
    private Timeline tiempo;
    Label etiquetaDelTiempo = new Label();
    private Integer segundos = inicialTiempo;

    public EtiquetaTiempo(Jugador unJugador, Respuesta unaRespuesta, ManejadorDeTurnos unManejadorDeTurnos){

        etiquetaDelTiempo.setText(segundos.toString());
        etiquetaDelTiempo.setTextFill(Color.BLUE);
        if (tiempo != null) {
            tiempo.stop();
        }
        segundos = inicialTiempo;

        etiquetaDelTiempo.setText(segundos.toString());
        tiempo = new Timeline();
        tiempo.setCycleCount(tiempo.INDEFINITE);
        tiempo.getKeyFrames().add(new KeyFrame(Duration.seconds(1), new TiempoEventHandler(this, unJugador, unaRespuesta, unManejadorDeTurnos)));
        tiempo.playFromStart();
    }

    public Label getLabel(){
        return etiquetaDelTiempo;
    }

    public Integer getSegundos() {
        return segundos;
    }

    public Timeline getTiempo() {
        return tiempo;
    }
}



