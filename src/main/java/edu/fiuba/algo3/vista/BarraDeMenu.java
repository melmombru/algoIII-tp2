package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.*;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class BarraDeMenu extends MenuBar {

    private final MenuItem opcionPantallaCompleta = new MenuItem("Maximizar tamaño");
    private MenuItem opcionSalirDePantallaCompleta = new MenuItem("Minimizar tamaño");

    public BarraDeMenu(Stage stage) {

        Menu menuArchivo = new Menu("Archivo");
        Menu menuVer = new Menu("Ver");
        Menu menuAyuda = new Menu("Ayuda");

        MenuItem opcionSalir = new MenuItem("Salir");
        MenuItem opcionAcercaDe = new MenuItem("Acerca de Kahoot!");

        OpcionSalirEventHandler opcionSalirHandler = new OpcionSalirEventHandler();
        opcionSalir.setOnAction(opcionSalirHandler);

        OpcionAcercaDeEventHandler opcionAcercaDeHandler = new OpcionAcercaDeEventHandler();
        opcionAcercaDe.setOnAction(opcionAcercaDeHandler);

        OpcionPantallaCompletaEventHandler opcionPantallaCompletaHandler = new OpcionPantallaCompletaEventHandler(stage, opcionSalirDePantallaCompleta, menuVer);
        opcionPantallaCompleta.setOnAction(opcionPantallaCompletaHandler);

        OpcionSalirDePantallaCompletaEventHandler opcionSalirDePantallaCompletaEventHandler = new OpcionSalirDePantallaCompletaEventHandler(stage, opcionPantallaCompleta, menuVer);
        opcionSalirDePantallaCompleta.setOnAction(opcionSalirDePantallaCompletaEventHandler);

        KeyEscEventHandler keyEscEventHandler = new KeyEscEventHandler(opcionSalirDePantallaCompleta);
        stage.getScene().setOnKeyPressed(keyEscEventHandler);

        menuArchivo.getItems().addAll(opcionSalir);
        menuAyuda.getItems().addAll(opcionAcercaDe);
        menuVer.getItems().addAll(opcionPantallaCompleta);

        this.getMenus().addAll(menuArchivo, menuVer, menuAyuda);
    }

    public void aplicacionMaximizada() {
        opcionPantallaCompleta.setDisable(false);

    }
}
