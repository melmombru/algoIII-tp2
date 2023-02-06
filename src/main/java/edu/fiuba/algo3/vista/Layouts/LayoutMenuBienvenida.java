package edu.fiuba.algo3.vista.Layouts;

import edu.fiuba.algo3.controlador.KeyEnterPrimerJugadorHandler;
import edu.fiuba.algo3.controlador.KeyEnterSegundoJugadorHandler;
import edu.fiuba.algo3.modelo.ManejadorDeTurnos;
import edu.fiuba.algo3.vista.Contenedores.ContenedorBienvenida;
import edu.fiuba.algo3.vista.Contenedores.ContenedorBotonEmpezar;
import edu.fiuba.algo3.vista.Contenedores.ContenedorNombresJugadores;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import static edu.fiuba.algo3.vista.Constantes.COLOR_FONDO;

public class LayoutMenuBienvenida {

    private final Pane layout;

    public LayoutMenuBienvenida(ManejadorDeTurnos manejadorDeTurnos) {

        ContenedorBienvenida contenedorBienvenida = new ContenedorBienvenida();

        ContenedorNombresJugadores contenedorNombresJugadores = new ContenedorNombresJugadores(manejadorDeTurnos.getJugador1(), manejadorDeTurnos.getJugador2());

        ContenedorBotonEmpezar contenedorBotonEmpezar = new ContenedorBotonEmpezar(contenedorNombresJugadores.nombreJugador1(),
                                                    contenedorNombresJugadores.nombreJugador2(), manejadorDeTurnos);

        KeyEnterPrimerJugadorHandler keyEnterPrimerJugadorHandler = new KeyEnterPrimerJugadorHandler(contenedorNombresJugadores.nombreJugador2());
        contenedorNombresJugadores.nombreJugador1().setOnKeyPressed(keyEnterPrimerJugadorHandler);

        KeyEnterSegundoJugadorHandler keyEnterSegundoJugadorHandler = new KeyEnterSegundoJugadorHandler(contenedorBotonEmpezar);
        contenedorNombresJugadores.nombreJugador2().setOnKeyPressed(keyEnterSegundoJugadorHandler);

        VBox contenedorInicioDeKahoot = new VBox(contenedorBienvenida.getLayout(), contenedorNombresJugadores.getLayout(), contenedorBotonEmpezar.getLayout());

        contenedorInicioDeKahoot.setSpacing(160);
        contenedorInicioDeKahoot.setBackground(new Background(new BackgroundFill(Color.web(COLOR_FONDO), CornerRadii.EMPTY, Insets.EMPTY)));
        contenedorInicioDeKahoot.setAlignment(Pos.TOP_CENTER);

        layout = contenedorInicioDeKahoot;
    }

    public Pane getLayout(){return layout;}
}
