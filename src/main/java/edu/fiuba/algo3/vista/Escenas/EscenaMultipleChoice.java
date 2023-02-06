package edu.fiuba.algo3.vista.Escenas;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Preguntas.*;
import edu.fiuba.algo3.modelo.opciones.ListaOpciones;
import edu.fiuba.algo3.vista.BarraDeMenu;
import edu.fiuba.algo3.vista.EtiquetaTiempo;
import edu.fiuba.algo3.vista.Layouts.LayoutMultipleChoice;
import edu.fiuba.algo3.vista.Layouts.LayoutMultipleChoiceConPenalidad;
import edu.fiuba.algo3.vista.Layouts.LayoutMultipleChoiceSinPenalidad;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import static edu.fiuba.algo3.vista.Constantes.COLOR_FONDO;

public class EscenaMultipleChoice implements Escena {

    private LayoutMultipleChoice layoutMultipleChoice;
    private final Pregunta pregunta;
    private final ListaOpciones opcionesMostradas;
    private final BarraDeMenu barraDeMenu;

    public EscenaMultipleChoice(Pregunta unaPregunta, Jugador jugador, ManejadorDeTurnos manejadorDeTurnos) {

        MultipleChoice multipleChoice = (MultipleChoice) unaPregunta;
        pregunta = unaPregunta;
        opcionesMostradas = new ListaOpciones(multipleChoice.getOpcionesCorrectas());
        opcionesMostradas.agregarTodo(multipleChoice.getOpcionesIncorrectas());
        opcionesMostradas.desordenar();
        barraDeMenu = new BarraDeMenu(manejadorDeTurnos.getStage());

        if (pregunta.getTipoDePregunta().equals(MultipleChoiceClasico.getNombreDePregunta())) {
            layoutMultipleChoice = new LayoutMultipleChoiceSinPenalidad(pregunta, this, jugador, manejadorDeTurnos);
        }
        if (pregunta.getTipoDePregunta().equals(MultipleChoiceParcial.getNombreDePregunta())) {
            layoutMultipleChoice = new LayoutMultipleChoiceSinPenalidad(pregunta, this, jugador, manejadorDeTurnos);
        }
        if (pregunta.getTipoDePregunta().equals(MultipleChoiceConPenalidad.getNombreDePregunta())) {
            layoutMultipleChoice = new LayoutMultipleChoiceConPenalidad(pregunta, this, jugador, manejadorDeTurnos);
        }

    }

    @Override
    public Scene getEscena() {
        VBox layout = new VBox(barraDeMenu, layoutMultipleChoice.getLayout());
        layout.setBackground(new Background(new BackgroundFill(Color.web(COLOR_FONDO), CornerRadii.EMPTY, Insets.EMPTY)));
        layout.setAlignment(Pos.TOP_CENTER);
        return (new Scene(layout));
    }

    public ListaOpciones getOpcionesMostradas() {
        return opcionesMostradas;
    }

    @Override
    public void actualizar(Jugador jugador, ManejadorDeTurnos manejadorDeTurnos, EtiquetaTiempo unaEtiquetaTiempo) {

        if (pregunta.getTipoDePregunta().equals(MultipleChoiceClasico.getNombreDePregunta())) {
            Pane layout = (new LayoutMultipleChoiceSinPenalidad(pregunta, this, jugador, manejadorDeTurnos, unaEtiquetaTiempo)).getLayout();
            VBox layoutConBarraDeMenu = new VBox(barraDeMenu, layout);
            layoutConBarraDeMenu.setBackground(new Background(new BackgroundFill(Color.web(COLOR_FONDO), CornerRadii.EMPTY, Insets.EMPTY)));
            layoutConBarraDeMenu.setAlignment(Pos.TOP_CENTER);
            manejadorDeTurnos.getStage().setScene(new Scene(layoutConBarraDeMenu));
        }
        if (pregunta.getTipoDePregunta().equals(MultipleChoiceParcial.getNombreDePregunta())) {
            Pane layout = (new LayoutMultipleChoiceSinPenalidad(pregunta, this, jugador, manejadorDeTurnos, unaEtiquetaTiempo)).getLayout();
            VBox layoutConBarraDeMenu = new VBox(barraDeMenu, layout);
            layoutConBarraDeMenu.setBackground(new Background(new BackgroundFill(Color.web(COLOR_FONDO), CornerRadii.EMPTY, Insets.EMPTY)));
            layoutConBarraDeMenu.setAlignment(Pos.TOP_CENTER);
            manejadorDeTurnos.getStage().setScene(new Scene(layoutConBarraDeMenu));
        }
        if (pregunta.getTipoDePregunta().equals(MultipleChoiceConPenalidad.getNombreDePregunta())) {
            Pane layout = (new LayoutMultipleChoiceConPenalidad(pregunta, this, jugador, manejadorDeTurnos, unaEtiquetaTiempo)).getLayout();
            VBox layoutConBarraDeMenu = new VBox(barraDeMenu, layout);
            layoutConBarraDeMenu.setBackground(new Background(new BackgroundFill(Color.web(COLOR_FONDO), CornerRadii.EMPTY, Insets.EMPTY)));
            layoutConBarraDeMenu.setAlignment(Pos.TOP_CENTER);
            manejadorDeTurnos.getStage().setScene(new Scene(layoutConBarraDeMenu));
        }
    }

    public VBox getContenedorDeOpciones() {
        return layoutMultipleChoice.getContenedorDeOpciones();
    }

    public ListaOpciones getOpcionesSeleccionadas() {
        return layoutMultipleChoice.getOpcionesSeleccionadas();
    }
}
