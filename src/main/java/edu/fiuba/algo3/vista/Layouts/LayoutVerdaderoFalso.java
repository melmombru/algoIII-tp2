package edu.fiuba.algo3.vista.Layouts;

import edu.fiuba.algo3.controlador.BotonEnviarHandler;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.ManejadorDeTurnos;
import edu.fiuba.algo3.modelo.Preguntas.VerdaderoFalso;
import edu.fiuba.algo3.modelo.Respuestas.RespuestaUnica;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import static edu.fiuba.algo3.vista.Constantes.ESTILO_FALSO;
import static edu.fiuba.algo3.vista.Constantes.ESTILO_VERDADERO;

public abstract class LayoutVerdaderoFalso {

    protected VBox layout;

    public VBox getLayout() {return layout;}

    protected HBox obtenerContenedorDeOpcionesVoF(VerdaderoFalso verdaderoFalso, Jugador unJugador, ManejadorDeTurnos manejadorDeTurnos, Timeline tiempo){

        Button botonVerdadero = new Button(verdaderoFalso.getOpcionVerdadera().getOpcion());
        BotonEnviarHandler botonVerdaderoHandler = new BotonEnviarHandler(unJugador, new RespuestaUnica(verdaderoFalso.getOpcionVerdadera()), manejadorDeTurnos, tiempo);
        botonVerdadero.setOnAction(botonVerdaderoHandler);
        botonVerdadero.setMinSize(200, 70);
        botonVerdadero.setStyle(ESTILO_VERDADERO);

        Button botonFalso = new Button(verdaderoFalso.getOpcionFalsa().getOpcion());
        BotonEnviarHandler botonFalsoHandler = new BotonEnviarHandler(unJugador, new RespuestaUnica(verdaderoFalso.getOpcionFalsa()), manejadorDeTurnos, tiempo);
        botonFalso.setOnAction(botonFalsoHandler);
        botonFalso.setMinSize(200, 70);
        botonFalso.setStyle(ESTILO_FALSO);

        HBox contenedorDeOpcionesVoF = new HBox(botonVerdadero, botonFalso);
        contenedorDeOpcionesVoF.setAlignment(Pos.CENTER);
        contenedorDeOpcionesVoF.setStyle("-fx-font-weight: bold");
        contenedorDeOpcionesVoF.setStyle("-fx-font-size: 1.5em;");

        contenedorDeOpcionesVoF.setSpacing(60);
        contenedorDeOpcionesVoF.setPadding(new Insets(140,0,0,0));

        HBox estructuraContenedorOpciones = new HBox (contenedorDeOpcionesVoF);
        estructuraContenedorOpciones.setAlignment(Pos.CENTER);
        estructuraContenedorOpciones.setMinHeight(470);
        estructuraContenedorOpciones.setMaxHeight(470);

        return estructuraContenedorOpciones;
    }
}
