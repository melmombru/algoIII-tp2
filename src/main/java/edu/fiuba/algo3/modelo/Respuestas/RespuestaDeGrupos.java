package edu.fiuba.algo3.modelo.Respuestas;

import edu.fiuba.algo3.modelo.opciones.ListaOpciones;

public class RespuestaDeGrupos implements Respuesta {

    private final ListaOpciones opcionesSeleccionadasGrupoA;
    private final ListaOpciones opcionesSeleccionadasGrupoB;

    public RespuestaDeGrupos(ListaOpciones unasOpcionesSeleccionadasDelGrupoA, ListaOpciones unasOpcionesSeleccionadasDelGrupoB) {

        opcionesSeleccionadasGrupoA = unasOpcionesSeleccionadasDelGrupoA;
        opcionesSeleccionadasGrupoB = unasOpcionesSeleccionadasDelGrupoB;
    }

    public ListaOpciones getOpcionesSeleccionadasGrupoA() {
        return opcionesSeleccionadasGrupoA;
    }

    public ListaOpciones getOpcionesSeleccionadasGrupoB() {
        return opcionesSeleccionadasGrupoB;
    }

    public boolean grupoAContieneLoMismo(ListaOpciones opcionesGrupoA) {
        return opcionesSeleccionadasGrupoA.contieneLoMismo(opcionesGrupoA);
    }

    public boolean grupoBContieneLoMismo(ListaOpciones opcionesGrupoB) {
        return opcionesSeleccionadasGrupoB.contieneLoMismo(opcionesGrupoB);
    }
}
