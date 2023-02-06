package edu.fiuba.algo3.vista.Contenedores;

import edu.fiuba.algo3.controlador.BotonEmpezarJuegoEventHandler;
import edu.fiuba.algo3.modelo.ManejadorDeTurnos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

import static edu.fiuba.algo3.vista.Constantes.ESTILO_BOTONES;

public class ContenedorBotonEmpezar {

    private final HBox contenedorBoton;
    private final Button iniciarJuego;

    public ContenedorBotonEmpezar(TextField nombreJugador1, TextField nombreJugador2, ManejadorDeTurnos manejadorDeTurnos) {

        iniciarJuego = new Button("Iniciar Kahoot");
        iniciarJuego.setStyle(ESTILO_BOTONES);

        BotonEmpezarJuegoEventHandler botonComienzoDeJuego = new BotonEmpezarJuegoEventHandler(nombreJugador1,
                nombreJugador2, manejadorDeTurnos);

        iniciarJuego.setOnAction(botonComienzoDeJuego);

        contenedorBoton = new HBox(iniciarJuego);
        contenedorBoton.setAlignment(Pos.BOTTOM_RIGHT);
        contenedorBoton.setPadding(new Insets(20));
    }

    public HBox getLayout(){
        return contenedorBoton;
    }

    public Button getButton(){ return iniciarJuego;}
}
