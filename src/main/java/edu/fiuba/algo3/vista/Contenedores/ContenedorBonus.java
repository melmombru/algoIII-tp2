package edu.fiuba.algo3.vista.Contenedores;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;

public class ContenedorBonus {

    HBox contenedorBonus;

    public ContenedorBonus(Button bonus, int cantidadBonus) {

        Circle circuloBonus = new Circle(6.65, Color.AQUA);

        Label etiquetaCantidadBonus = new Label(String.valueOf(cantidadBonus));
        etiquetaCantidadBonus.setFont(new Font("Cambria", 10));
        etiquetaCantidadBonus.setAlignment(Pos.CENTER);
        etiquetaCantidadBonus.setMaxWidth(Double.MAX_VALUE);

        StackPane contenedorCantidadBonus = new StackPane(circuloBonus, etiquetaCantidadBonus);
        contenedorCantidadBonus.setAlignment(Pos.BOTTOM_RIGHT);

        contenedorBonus = new HBox(bonus, contenedorCantidadBonus);
        contenedorBonus.setSpacing(3);

    }

    public HBox getLayout() {
        return contenedorBonus;
    }
}