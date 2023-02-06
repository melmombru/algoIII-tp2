package edu.fiuba.algo3.vista.Layouts;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.ManejadorDeTurnos;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import static edu.fiuba.algo3.vista.Constantes.*;

public class LayoutSiguienteJugador {

    private final VBox layout;

    public LayoutSiguienteJugador(Jugador jugador, ManejadorDeTurnos manejadorDeTurnos, EventHandler<ActionEvent> handlerBotonEnviar){

        HBox cinta = new HBox();
        cinta.setStyle(ESTILO_CINTA);
        cinta.setMinHeight(ALTO_CINTA);

        Label texto = new Label("Es el turno de: " + jugador.getNombre());

        VBox informacion = new VBox(texto);
        informacion.setStyle("-fx-font-size: 1.8em; -fx-font-weight: bold");
        informacion.setAlignment(Pos.CENTER);
        informacion.setBackground(new Background(new BackgroundFill(Color.web(COLOR_CONTENEDOR_CONSIGNA), CornerRadii.EMPTY, Insets.EMPTY)));
        informacion.setMaxSize(ANCHO_CONTENEDOR_CONSIGNA, ALTO_CONTENEDOR_CONSIGNA);
        informacion.setPadding((new Insets(80)));

        HBox contenedorTexto = new HBox(informacion);
        contenedorTexto.setMinHeight(450);
        contenedorTexto.setAlignment(Pos.TOP_CENTER);

        Button enviar = new Button("Siguiente");
        enviar.setOnAction(handlerBotonEnviar);
        enviar.setStyle(ESTILO_BOTONES);
        enviar.setAlignment(Pos.BOTTOM_CENTER);

        HBox contenedorEnviar = new HBox(enviar);
        contenedorEnviar.setMaxWidth(470);
        contenedorEnviar.setAlignment(Pos.CENTER_RIGHT);

        layout = new VBox(cinta, contenedorTexto, contenedorEnviar);
        layout.setBackground(new Background(new BackgroundFill(Color.web(COLOR_FONDO), CornerRadii.EMPTY, Insets.EMPTY)));
        layout.setAlignment(Pos.TOP_CENTER);
        layout.setSpacing(60);
    }

    public VBox getLayout() {return layout;}
}
