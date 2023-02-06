package edu.fiuba.algo3.vista.Escenas;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.ManejadorDeTurnos;
import edu.fiuba.algo3.vista.EtiquetaTiempo;
import javafx.scene.Scene;

public interface Escena {

    Scene getEscena();

    void actualizar(Jugador jugador, ManejadorDeTurnos manejadorDeTurnos, EtiquetaTiempo unaEtiquetaTiempo);
}
