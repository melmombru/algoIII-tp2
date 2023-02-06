package edu.fiuba.algo3.modelo.Preguntas;

import edu.fiuba.algo3.modelo.opciones.ListaOpciones;

public abstract class MultipleChoice extends Pregunta {

    protected ListaOpciones opcionesCorrectas;
    protected ListaOpciones opcionesIncorrectas;

    public ListaOpciones getOpcionesCorrectas() {return opcionesCorrectas;}

    public ListaOpciones getOpcionesIncorrectas() {return opcionesIncorrectas;}
}
