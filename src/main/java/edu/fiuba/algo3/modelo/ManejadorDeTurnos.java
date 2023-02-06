package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.controlador.BotonPrimeraPreguntaEventHandler;
import edu.fiuba.algo3.controlador.BotonSiguienteEventHandler;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import edu.fiuba.algo3.modelo.Excepciones.PreguntaCorruptaException;
import edu.fiuba.algo3.vista.BarraDeMenu;
import edu.fiuba.algo3.vista.Layouts.LayoutFinDelJuego;
import edu.fiuba.algo3.vista.Layouts.LayoutSiguienteJugador;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Stack;

import static edu.fiuba.algo3.vista.Constantes.COLOR_FONDO;

public class ManejadorDeTurnos {

    private final Stack<Pregunta> pilaDePreguntas ;
    private final Jugador jugador1;
    private final Jugador jugador2;
    private Boolean jugador2Respodio;
    private Boolean juegoTerminado;
    private Boolean ultimaPregunta;
    private Pregunta pregunta;
    private final Kahoot kahoot;
    private final Stage stage;

    public ManejadorDeTurnos(Stack<Pregunta> pilaDePreguntas, Jugador jugador1, Jugador jugador2, Kahoot kahoot, Stage stage){

        this.pilaDePreguntas = pilaDePreguntas;
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.kahoot = kahoot;
        jugador2Respodio = true;
        juegoTerminado = false;
        ultimaPregunta = false;
        this.stage = stage;
    }

    public void mostrarLayoutPrimerJugador(){
        BotonPrimeraPreguntaEventHandler botonSiguiente = new BotonPrimeraPreguntaEventHandler(this);

        stage.setScene(this.escenaConBarraDeMenu(new LayoutSiguienteJugador(jugador1, this, botonSiguiente).getLayout()));
    }

    public void mostrarLayoutSiguienteJugador(){

        BotonSiguienteEventHandler botonSiguiente = new BotonSiguienteEventHandler(this);

        if(jugador2Respodio && !ultimaPregunta){
            stage.setScene(this.escenaConBarraDeMenu(new LayoutSiguienteJugador(jugador1, this, botonSiguiente).getLayout()));
        }
        else if(!jugador2Respodio){
            stage.setScene(this.escenaConBarraDeMenu(new LayoutSiguienteJugador(jugador2, this, botonSiguiente).getLayout()));
        }
        else{
            mostrarSiguientePregunta();
        }
    }

    public void mostrarPrimeraPregunta () {

        if(pilaDePreguntas.isEmpty()){
            stage.setScene(this.escenaConBarraDeMenu(new LayoutFinDelJuego(jugador1, jugador2).getLayout()));
        }

        else {
            jugador2Respodio = false;

            pregunta = pilaDePreguntas.pop();

            if(pilaDePreguntas.isEmpty()){
                ultimaPregunta = true;
            }

            try {
                stage.setScene(CreadorDeVistas.crearSiguienteEscena(pregunta, jugador1, this));
            } catch (PreguntaCorruptaException e) {
                e.printStackTrace();
                this.mostrarPrimeraPregunta();
            }
        }
    }

    public void mostrarSiguientePregunta(){

        if(pilaDePreguntas.isEmpty() && jugador2Respodio){

            kahoot.evaluarRespuestas(pregunta);

            juegoTerminado = true;
            stage.setScene(this.escenaConBarraDeMenu(new LayoutFinDelJuego(jugador1, jugador2).getLayout()));
        }

        else if(jugador2Respodio && !juegoTerminado) {

            kahoot.evaluarRespuestas(pregunta);
            pregunta = pilaDePreguntas.pop();

            if(pilaDePreguntas.isEmpty()){
                ultimaPregunta = true;
            }

            try {
                stage.setScene(CreadorDeVistas.crearSiguienteEscena(pregunta, jugador1, this));
            }
            catch (PreguntaCorruptaException e) {
                e.printStackTrace();
                this.mostrarSiguientePregunta();
            }

            jugador2Respodio = false;
        }
        else if (!juegoTerminado){
            jugador2Respodio = true;
            try {
                stage.setScene(CreadorDeVistas.crearSiguienteEscena(pregunta, jugador2, this));
            }
            catch (PreguntaCorruptaException e) {
                e.printStackTrace();
                System.exit(1);
            }
        }
    }

    public Kahoot getKahoot() {return kahoot;}

    public Stage getStage() {return stage;}

    public Jugador getJugador1(){ return jugador1;}

    public Jugador getJugador2(){ return jugador2;}

    public Scene escenaConBarraDeMenu(Pane pane){

        BarraDeMenu barraDeMenu = new BarraDeMenu(stage);

        VBox vBox = new VBox(barraDeMenu, pane);
        vBox.setBackground(new Background(new BackgroundFill(Color.web(COLOR_FONDO), CornerRadii.EMPTY, Insets.EMPTY)));
        vBox.setAlignment(Pos.TOP_CENTER);

        return new Scene(vBox);
    }
}
