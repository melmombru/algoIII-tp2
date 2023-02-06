package edu.fiuba.algo3.vista.Contenedores;

import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.TextAlignment;

import static edu.fiuba.algo3.vista.Constantes.*;

public class ContenedorConsigna {

    private final Pane layout;

    public ContenedorConsigna(Pregunta unaPregunta) {

        Label tipoPregunta = new Label (unaPregunta.getTipoDePregunta());
        Label pregunta = new Label(unaPregunta.getConsigna());

        tipoPregunta.setMinSize(ANCHO_CONTENEDOR_CONSIGNA-50, 20);
        tipoPregunta.setMaxSize(ANCHO_CONTENEDOR_CONSIGNA-50, 20);
        tipoPregunta.setAlignment(Pos.CENTER);

        pregunta.setStyle("-fx-font-weight: bold");
        pregunta.setMinSize(ANCHO_CONTENEDOR_CONSIGNA-50, ALTO_CONTENEDOR_CONSIGNA-70);
        pregunta.setMaxSize(ANCHO_CONTENEDOR_CONSIGNA-50, ALTO_CONTENEDOR_CONSIGNA-70);
        pregunta.setWrapText(true);
        pregunta.setAlignment(Pos.CENTER);
        pregunta.setTextAlignment(TextAlignment.CENTER);

        VBox consigna = new VBox(tipoPregunta, pregunta);
        pregunta.setMinSize(ANCHO_CONTENEDOR_CONSIGNA-50, ALTO_CONTENEDOR_CONSIGNA-50);
        pregunta.setMaxSize(ANCHO_CONTENEDOR_CONSIGNA-50, ALTO_CONTENEDOR_CONSIGNA-50);
        consigna.setAlignment(Pos.CENTER);

        Rectangle fondoConsigna = new Rectangle(
                ANCHO_CONTENEDOR_CONSIGNA,
                ALTO_CONTENEDOR_CONSIGNA,
                Color.web(COLOR_CONTENEDOR_CONSIGNA));

        StackPane contenedorConsigna = new StackPane(fondoConsigna, consigna);
        contenedorConsigna.setStyle("-fx-font-size: 1.3em;");

        layout = contenedorConsigna;
        //layout.setPadding(new Insets(40, 0, 60,0));
    }

    public Pane getLayout() {
        return layout;
    }
}
