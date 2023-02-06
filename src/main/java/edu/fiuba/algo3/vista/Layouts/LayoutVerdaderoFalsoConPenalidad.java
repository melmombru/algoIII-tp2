package edu.fiuba.algo3.vista.Layouts;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.ManejadorDeTurnos;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaConPenalidad;
import edu.fiuba.algo3.modelo.Preguntas.VerdaderoFalso;
import edu.fiuba.algo3.modelo.Respuestas.RespuestaUnica;
import edu.fiuba.algo3.vista.Contenedores.ContenedorConsigna;
import edu.fiuba.algo3.vista.Contenedores.ContenedorPrimerReglonPreguntaConPenalidad;
import edu.fiuba.algo3.vista.Escenas.Escena;
import edu.fiuba.algo3.vista.EtiquetaTiempo;
import javafx.geometry.Insets;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import static edu.fiuba.algo3.vista.Constantes.COLOR_FONDO;

public class LayoutVerdaderoFalsoConPenalidad extends LayoutVerdaderoFalso{

    public LayoutVerdaderoFalsoConPenalidad(Pregunta pregunta, Escena scene, Jugador unJugador, ManejadorDeTurnos manejadorDeTurnos) {

        EtiquetaTiempo unaEtiquetaTiempo = new EtiquetaTiempo(unJugador, new RespuestaUnica(new Opcion("No contestada")), manejadorDeTurnos);

        this.crearLayout(pregunta, scene, unJugador, manejadorDeTurnos, unaEtiquetaTiempo);
    }

    public LayoutVerdaderoFalsoConPenalidad(Pregunta pregunta, Escena scene, Jugador unJugador, ManejadorDeTurnos manejadorDeTurnos, EtiquetaTiempo unaEtiquetaTiempo) {

        this.crearLayout(pregunta, scene, unJugador, manejadorDeTurnos, unaEtiquetaTiempo);
    }

    private void crearLayout(Pregunta pregunta, Escena scene, Jugador unJugador, ManejadorDeTurnos manejadorDeTurnos, EtiquetaTiempo unaEtiquetaTiempo){

        VerdaderoFalso verdaderoFalso = (VerdaderoFalso)pregunta;
        ContenedorPrimerReglonPreguntaConPenalidad contenedorPrimerReglon = new ContenedorPrimerReglonPreguntaConPenalidad((PreguntaConPenalidad) verdaderoFalso, scene, unJugador, manejadorDeTurnos, unaEtiquetaTiempo);
        ContenedorConsigna contenedorConsigna = new ContenedorConsigna(pregunta);
        HBox contenedorVerdaderoFalso = this.obtenerContenedorDeOpcionesVoF(verdaderoFalso, unJugador, manejadorDeTurnos, contenedorPrimerReglon.getTiempo());

        layout = new VBox(contenedorPrimerReglon.getLayout(), contenedorConsigna.getLayout(), contenedorVerdaderoFalso);
        layout.setBackground(new Background(new BackgroundFill(Color.web(COLOR_FONDO), CornerRadii.EMPTY, Insets.EMPTY)));
        layout.setSpacing(40);
    }
}
