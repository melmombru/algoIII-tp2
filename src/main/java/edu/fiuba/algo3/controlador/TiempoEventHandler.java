package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.ManejadorDeTurnos;
import edu.fiuba.algo3.modelo.Respuestas.Respuesta;
import edu.fiuba.algo3.vista.EtiquetaTiempo;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;

public class TiempoEventHandler implements EventHandler<ActionEvent> {

    private Jugador jugador;
    private Respuesta respuesta;
    private ManejadorDeTurnos manejadorDeTurnos;
    private Timeline tiempo;
    Label etiquetaDelTiempo;
    private Integer segundos;

    public TiempoEventHandler(EtiquetaTiempo unaEtiqueta, Jugador unJugador, Respuesta unaRespuesta, ManejadorDeTurnos unManejadorDeTurnos){
        segundos = unaEtiqueta.getSegundos();
        etiquetaDelTiempo = unaEtiqueta.getLabel();
        tiempo = unaEtiqueta.getTiempo();
        jugador = unJugador;
        respuesta = unaRespuesta;
        manejadorDeTurnos = unManejadorDeTurnos;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        segundos--;
        etiquetaDelTiempo.setText(
                segundos.toString());
        if (segundos < 0) {
            tiempo.stop();
            manejadorDeTurnos.getKahoot().setRespuestaJugador(respuesta, jugador);
            manejadorDeTurnos.mostrarLayoutSiguienteJugador();
        }
    }
}
