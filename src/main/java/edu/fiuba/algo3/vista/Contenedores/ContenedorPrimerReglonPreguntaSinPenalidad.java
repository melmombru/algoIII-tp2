package edu.fiuba.algo3.vista.Contenedores;

import edu.fiuba.algo3.controlador.*;
import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaSinPenalidad;
import edu.fiuba.algo3.vista.Escenas.Escena;
import edu.fiuba.algo3.vista.EtiquetaTiempo;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import static edu.fiuba.algo3.vista.Constantes.*;

public class ContenedorPrimerReglonPreguntaSinPenalidad {

    private final HBox layout;
    private final EtiquetaTiempo etiquetaTiempo;
    private Button bonusX2;
    private Button bonusX3;
    private Button exclusividad;

    public ContenedorPrimerReglonPreguntaSinPenalidad(PreguntaSinPenalidad pregunta, Escena escena, Jugador jugador, ManejadorDeTurnos manejadorDeTurnos, EtiquetaTiempo unaEtiquetaTiempo) {

        Label nombreJugador = new Label(jugador.getNombre());
        nombreJugador.setAlignment(Pos.CENTER);
        nombreJugador.setMinWidth(150);

        Label puntos = new Label("Puntos: " +jugador.getPuntaje().getPuntos());
        puntos.setAlignment(Pos.CENTER_LEFT);
        puntos.setMinWidth(110);

        etiquetaTiempo = unaEtiquetaTiempo;
        Circle circuloTimer = new Circle(20, Color.GHOSTWHITE);
        StackPane contenedorTiempo = new StackPane(circuloTimer, etiquetaTiempo.getLabel());
        contenedorTiempo.setAlignment(Pos.CENTER);

        bonusX2 = new Button("X2");
        bonusX2.setDisable(true);
        ContenedorBonus contenedorBonusX2 = new ContenedorBonus(bonusX2, jugador.cantMultiplicadoresX2Restantes());

        bonusX3 = new Button("X3");
        bonusX3.setDisable(true);
        ContenedorBonus contenedorBonusX3 = new ContenedorBonus(bonusX3, jugador.cantMultiplicadoresX3Restantes());

        exclusividad = new Button("Ex");
        BotonExclusividadHandler exclusividadHandler = new BotonExclusividadHandler(pregunta, escena, jugador, manejadorDeTurnos, etiquetaTiempo);
        exclusividad.setOnAction(exclusividadHandler);
        ContenedorBonus contenedorExclusividad = new ContenedorBonus(exclusividad, jugador.cantExclusividadesRestantes());

        HBox contenedorBonus = new HBox(contenedorBonusX2.getLayout(), contenedorBonusX3.getLayout(), contenedorExclusividad.getLayout());
        contenedorBonus.setMinWidth(260);
        contenedorBonus.setSpacing(3);
        contenedorBonus.setAlignment(Pos.CENTER_RIGHT);

        this.habilitarexclusividades(jugador);

        layout = new HBox(nombreJugador, puntos, contenedorTiempo, contenedorBonus);

        layout.setAlignment(Pos.CENTER);
        layout.setStyle(ESTILO_CINTA);
        layout.setPadding(new Insets(10));
        layout.setMinHeight(ALTO_CINTA);
        layout.setMaxHeight(ALTO_CINTA);
    }

    public HBox getLayout() {
        return layout;
    }

    public Timeline getTiempo() {
        return etiquetaTiempo.getTiempo();
    }

    private void habilitarexclusividades(Jugador jugador) {

        if (jugador.cantExclusividadesRestantes() == 0) {
            exclusividad.setDisable(true);
        }
    }
}
