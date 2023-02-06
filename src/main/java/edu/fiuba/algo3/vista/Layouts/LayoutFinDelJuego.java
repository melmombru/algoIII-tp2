package edu.fiuba.algo3.vista.Layouts;

import edu.fiuba.algo3.modelo.Jugador;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import static edu.fiuba.algo3.vista.Constantes.*;

public class LayoutFinDelJuego {

    private final VBox layout;

    public LayoutFinDelJuego(Jugador unJugador, Jugador otroJugador) {

        HBox cinta = new HBox();
        cinta.setStyle(ESTILO_CINTA);
        cinta.setMinHeight(ALTO_CINTA);

        HBox contenedorResultado = new HBox();

        if(unJugador.getPuntaje().getPuntos() > otroJugador.getPuntaje().getPuntos()){
            contenedorResultado.getChildren().add(crearLayoutGanador(unJugador));
        }
        else if(otroJugador.getPuntaje().getPuntos() > unJugador.getPuntaje().getPuntos()){
            contenedorResultado.getChildren().add(crearLayoutGanador(otroJugador));
        }
        else{
            contenedorResultado.getChildren().add(crearLayoutEmpate());
        }

        contenedorResultado.setAlignment(Pos.BOTTOM_CENTER);
        contenedorResultado.setMinHeight(250);

        HBox contenedorJugadores = new HBox(crearLayoutJugador(unJugador), crearLayoutJugador(otroJugador));
        contenedorJugadores.setAlignment(Pos.CENTER);
        contenedorJugadores.setSpacing(60);
        contenedorJugadores.setPadding(new Insets(40));

        layout = new VBox(cinta, contenedorResultado, contenedorJugadores);
        layout.setAlignment(Pos.TOP_CENTER);
        layout.setBackground(new Background(new BackgroundFill(Color.web(COLOR_FONDO), CornerRadii.EMPTY, Insets.EMPTY)));
        layout.setSpacing(110);
    }

    public VBox getLayout() {return layout;}

    private VBox crearLayoutJugador (Jugador unJugador) {

        Label textoJugador = new Label(unJugador.getNombre());
        textoJugador.setStyle("-fx-font-weight: bold");
        Label puntuacionJugador = new Label(unJugador.getPuntaje().getPuntos() + " puntos");
        puntuacionJugador.setStyle("-fx-font-weight: bold");

        VBox contenedorJugador = new VBox (textoJugador, puntuacionJugador);
        contenedorJugador.setBackground(new Background(new BackgroundFill(Color.web(COLOR_GRUPOS), CornerRadii.EMPTY, Insets.EMPTY)));
        contenedorJugador.setAlignment(Pos.CENTER);
        contenedorJugador.setSpacing(10);
        contenedorJugador.setMinSize(200,90);

        contenedorJugador.setStyle("-fx-font-size: 1.4em;");

        return contenedorJugador;
    }

    private HBox crearLayoutGanador (Jugador jugador) {

        Label textoGanador = new Label("¡¡¡Ganó " + jugador.getNombre() + "!!!");
        textoGanador.setStyle("-fx-font-size: 2em; -fx-font-weight: bold");

        HBox layoutGanador = new HBox (textoGanador);
        layoutGanador.setMinSize(400, 200);
        layoutGanador.setMaxSize(400, 200);
        layoutGanador.setAlignment(Pos.CENTER);
        layoutGanador.setBackground(new Background(new BackgroundFill(Color.web("00FFFF"), CornerRadii.EMPTY, Insets.EMPTY)));

        return layoutGanador;
    }

    private HBox crearLayoutEmpate () {

        Label textoEmpate = new Label("Empate, no hay ganador");
        textoEmpate.setStyle("-fx-font-size: 2em; -fx-font-weight: bold");

        HBox layoutEmpate = new HBox(textoEmpate);
        layoutEmpate.setMinSize(400, 200);
        layoutEmpate.setMaxSize(400, 200);
        layoutEmpate.setAlignment(Pos.CENTER);
        layoutEmpate.setBackground(new Background(new BackgroundFill(Color.web("AAAAAA"), CornerRadii.EMPTY, Insets.EMPTY)));

        return layoutEmpate;
    }
}