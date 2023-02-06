package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Preguntas.*;
import edu.fiuba.algo3.modelo.Excepciones.PreguntaCorruptaException;
import edu.fiuba.algo3.modelo.opciones.ListaOpciones;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import edu.fiuba.algo3.vista.Escenas.*;
import javafx.scene.Scene;

public class CreadorDeVistas {

    public static Scene crearSiguienteEscena(Pregunta pregunta, Jugador jugador, ManejadorDeTurnos manejadorDeTurnos) throws PreguntaCorruptaException{

        Escena escena;

        Opcion opcion1 = new Opcion("opcion1");
        Opcion opcion2 = new Opcion("opcion2");
        Opcion opcion3 = new Opcion("opcion3");
        Opcion opcion4 = new Opcion("opcion4");

        ListaOpciones listaOpciones1 = new ListaOpciones();
        listaOpciones1.agregar(opcion1);
        listaOpciones1.agregar(opcion2);
        ListaOpciones listaOpciones2 = new ListaOpciones();
        listaOpciones2.agregar(opcion3);
        listaOpciones2.agregar(opcion4);

        VerdaderoFalsoClasico vofClasico =  VerdaderoFalsoClasico.crearVerdaderoFalsoCorrectaVerdadero("");
        VerdaderoFalsoConPenalidad vofConPenalidad = VerdaderoFalsoConPenalidad.crearVerdaderoFalsoCorrectoVerdadero("");
        MultipleChoiceClasico multipleChoiceClasico = new MultipleChoiceClasico("", listaOpciones1, listaOpciones2);
        MultipleChoiceParcial multipleChoiceParcial = new MultipleChoiceParcial("", listaOpciones1, listaOpciones2);
        MultipleChoiceConPenalidad multipleChoiceConPenalidad = new MultipleChoiceConPenalidad("", listaOpciones1, listaOpciones2);
        OrderedChoice orderedChoice = new OrderedChoice("", listaOpciones1);
        GroupChoice groupChoice = new GroupChoice("","", listaOpciones1, "",listaOpciones2);

        if(pregunta.esElMismoTipoDePreguinta(vofClasico)){

            escena = new EscenaVerdaderoFalso(pregunta, jugador, manejadorDeTurnos);

        }else if (pregunta.esElMismoTipoDePreguinta(vofConPenalidad)){

            escena = new EscenaVerdaderoFalso(pregunta, jugador, manejadorDeTurnos);

        }else if (pregunta.esElMismoTipoDePreguinta(multipleChoiceClasico)){

            escena = new EscenaMultipleChoice(pregunta, jugador, manejadorDeTurnos);

        }else if (pregunta.esElMismoTipoDePreguinta(multipleChoiceParcial)){

            escena = new EscenaMultipleChoice(pregunta, jugador, manejadorDeTurnos);

        }else if (pregunta.esElMismoTipoDePreguinta(multipleChoiceConPenalidad)){

            escena = new EscenaMultipleChoice(pregunta, jugador, manejadorDeTurnos);

        }else if (pregunta.esElMismoTipoDePreguinta(orderedChoice)){

            escena = new EscenaOrderedChoice(pregunta, jugador, manejadorDeTurnos);

        }else if (pregunta.esElMismoTipoDePreguinta(groupChoice)) {

            escena = new EscenaGroupChoice(pregunta, jugador, manejadorDeTurnos);
        }
        else
            throw new PreguntaCorruptaException();

        return escena.getEscena();
    }
}