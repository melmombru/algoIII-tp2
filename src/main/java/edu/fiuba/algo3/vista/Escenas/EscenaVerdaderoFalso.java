package edu.fiuba.algo3.vista.Escenas;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import edu.fiuba.algo3.modelo.Preguntas.VerdaderoFalsoClasico;
import edu.fiuba.algo3.modelo.Preguntas.VerdaderoFalsoConPenalidad;
import edu.fiuba.algo3.vista.BarraDeMenu;
import edu.fiuba.algo3.vista.EtiquetaTiempo;
import edu.fiuba.algo3.vista.Layouts.LayoutVerdaderoFalsoConPenalidad;
import edu.fiuba.algo3.vista.Layouts.LayoutVerdaderoFalsoSinPenalidad;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import static edu.fiuba.algo3.vista.Constantes.COLOR_FONDO;

public class EscenaVerdaderoFalso implements Escena {

    private VBox layout;
    private final Pregunta pregunta;
    private final BarraDeMenu barraDeMenu;

    public EscenaVerdaderoFalso(Pregunta unaPregunta, Jugador unJugador, ManejadorDeTurnos manejadorDeTurnos) {

        pregunta = unaPregunta;
        barraDeMenu = new BarraDeMenu(manejadorDeTurnos.getStage());

        if (pregunta.getTipoDePregunta().equals(VerdaderoFalsoClasico.getNombreDePregunta())) {
            LayoutVerdaderoFalsoSinPenalidad layoutVerdaderoFalso = new LayoutVerdaderoFalsoSinPenalidad(pregunta, this, unJugador, manejadorDeTurnos);
            layout = new VBox(barraDeMenu, layoutVerdaderoFalso.getLayout());
        }
        if (pregunta.getTipoDePregunta().equals(VerdaderoFalsoConPenalidad.getNombreDePregunta())) {
            LayoutVerdaderoFalsoConPenalidad layoutVerdaderoFalso = new LayoutVerdaderoFalsoConPenalidad(pregunta, this, unJugador, manejadorDeTurnos);
            layout = new VBox(barraDeMenu, layoutVerdaderoFalso.getLayout());
        }

        layout.setBackground(new Background(new BackgroundFill(Color.web(COLOR_FONDO), CornerRadii.EMPTY, Insets.EMPTY)));
        layout.setAlignment(Pos.TOP_CENTER);
    }

    @Override
    public Scene getEscena() {
        return (new Scene(layout));
    }

    @Override
    public void actualizar(Jugador jugador, ManejadorDeTurnos manejadorDeTurnos, EtiquetaTiempo unaEtiquetaTiempo) {

        if (pregunta.getTipoDePregunta().equals(VerdaderoFalsoClasico.getNombreDePregunta())) {
            Pane layout = (new LayoutVerdaderoFalsoSinPenalidad(pregunta, this, jugador, manejadorDeTurnos, unaEtiquetaTiempo)).getLayout();
            VBox layoutConBarraDeMenu = new VBox(barraDeMenu, layout);
            layoutConBarraDeMenu.setBackground(new Background(new BackgroundFill(Color.web(COLOR_FONDO), CornerRadii.EMPTY, Insets.EMPTY)));
            layoutConBarraDeMenu.setAlignment(Pos.TOP_CENTER);
            manejadorDeTurnos.getStage().setScene(new Scene(layoutConBarraDeMenu));
        }
        if (pregunta.getTipoDePregunta().equals(VerdaderoFalsoConPenalidad.getNombreDePregunta())) {
            Pane layout = (new LayoutVerdaderoFalsoConPenalidad(pregunta, this, jugador, manejadorDeTurnos, unaEtiquetaTiempo)).getLayout();
            VBox layoutConBarraDeMenu = new VBox(barraDeMenu, layout);
            layoutConBarraDeMenu.setBackground(new Background(new BackgroundFill(Color.web(COLOR_FONDO), CornerRadii.EMPTY, Insets.EMPTY)));
            layoutConBarraDeMenu.setAlignment(Pos.TOP_CENTER);
            manejadorDeTurnos.getStage().setScene(new Scene(layoutConBarraDeMenu));
        }
    }
}
