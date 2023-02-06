package edu.fiuba.algo3.vista.Contenedores;

import edu.fiuba.algo3.controlador.BotonEnviarHandler;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.ManejadorDeTurnos;
import edu.fiuba.algo3.modelo.Respuestas.Respuesta;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

import static edu.fiuba.algo3.vista.Constantes.*;

public class ContenedorBotonEnviar {

    private final HBox layout;

    public ContenedorBotonEnviar(Jugador jugador, Respuesta respuesta, ManejadorDeTurnos manejadorDeTurnos, Timeline tiempo) {

        Button enviar = new Button("Enviar");
        enviar.setStyle(ESTILO_BOTONES);

        BotonEnviarHandler botonEnviarHandler = new BotonEnviarHandler(jugador, respuesta, manejadorDeTurnos, tiempo);
        enviar.setOnAction(botonEnviarHandler);

        HBox offset = new HBox();
        offset.setPrefWidth(ANCHO_OPCION);

        layout = new HBox(offset, enviar);
        layout.setPadding(new Insets(40));
        layout.setAlignment(Pos.BOTTOM_CENTER);
    }

    public HBox getLayout() {
        return layout;
    }
}
