package edu.fiuba.algo3.vista.Layouts;

import edu.fiuba.algo3.modelo.opciones.ListaOpciones;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import edu.fiuba.algo3.modelo.Puntaje;
import edu.fiuba.algo3.modelo.Respuestas.RespuestaEnLista;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import static edu.fiuba.algo3.vista.Constantes.*;

public abstract class LayoutMultipleChoice {

    protected VBox layout;
    protected VBox contenedorDeOpciones;
    protected RespuestaEnLista respuesta;
    protected ListaOpciones opcionesSeleccionadas;

    public VBox getLayout() {
        return layout;
    }

    public void crearContenedorDeOpciones(ListaOpciones opcionesMostradas, ListaOpciones listaRespuestas) {

        VBox contenedorOpciones = new VBox(10);
        contenedorOpciones.setMaxWidth(ANCHO_OPCION);
        contenedorOpciones.setAlignment(Pos.CENTER);
        contenedorOpciones.setBackground(new Background(new BackgroundFill(Color.web(COLOR_CONTENEDOR_CONSIGNA), CornerRadii.EMPTY, new Insets(-20))));

        int cantidadDeOpcionesAMostrar = opcionesMostradas.cantidadDeOpciones();

        for (int i = 0; i < cantidadDeOpcionesAMostrar; i++) {

            CheckBox checkBox = new CheckBox(opcionesMostradas.obtener(i).getOpcion());

            checkBox.setBackground(new Background(new BackgroundFill(Color.web(COLOR_OPCIONES), CornerRadii.EMPTY, new Insets(0, -10, 0, -10))));
            checkBox.setMinSize(ANCHO_OPCION - 20, 30);
            checkBox.setMaxSize(ANCHO_OPCION - 20, 30);
            checkBox.setAlignment(Pos.CENTER_LEFT);

            contenedorOpciones.getChildren().add(checkBox);

            checkBox.setIndeterminate(false);
            String opcion = opcionesMostradas.obtener(i).getOpcion();
            Puntaje puntaje = opcionesMostradas.obtener(i).getPuntaje();

            EventHandler<ActionEvent> event = e -> {

                if (checkBox.isSelected())
                    listaRespuestas.agregar(new Opcion(opcion, puntaje));
                else
                    listaRespuestas.eliminar(opcion);
            };

            checkBox.setOnAction(event);
        }

        VBox estructuraContenedorOpciones = new VBox(contenedorOpciones);
        estructuraContenedorOpciones.setAlignment(Pos.CENTER);
        estructuraContenedorOpciones.setMinHeight(260);
        estructuraContenedorOpciones.setMaxHeight(260);

        contenedorDeOpciones = estructuraContenedorOpciones;
    }

    public VBox getContenedorDeOpciones() {
        return contenedorDeOpciones;
    }

    public ListaOpciones getOpcionesSeleccionadas() {
        return opcionesSeleccionadas;
    }
}
