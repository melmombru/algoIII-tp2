package edu.fiuba.algo3.vista.Contenedores;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import static edu.fiuba.algo3.vista.Constantes.COLOR_CINTA;

public class ContenedorBienvenida {

    private final VBox contenedorBienvenida;

    public ContenedorBienvenida(){

        Label bienvenida = new Label("¡¡¡Bienvenidos a Kahoot!!!");
        bienvenida.setStyle("-fx-font-weight: bold; -fx-font-size: 2em;");

        contenedorBienvenida = new VBox(bienvenida);
        contenedorBienvenida.setAlignment(Pos.CENTER);
        contenedorBienvenida.setBackground(new Background(new BackgroundFill(Color.web(COLOR_CINTA), CornerRadii.EMPTY, Insets.EMPTY)));
        contenedorBienvenida.setPadding(new Insets(25));
        contenedorBienvenida.setStyle("-fx-font-size: 1.5em;");
    }

    public VBox getLayout(){
        return contenedorBienvenida;
    }
}
