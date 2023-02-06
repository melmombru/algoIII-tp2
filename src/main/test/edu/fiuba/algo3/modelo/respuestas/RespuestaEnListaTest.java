package edu.fiuba.algo3.modelo.respuestas;

import java.util.Arrays;

import edu.fiuba.algo3.modelo.opciones.ListaOpciones;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import edu.fiuba.algo3.modelo.Respuestas.RespuestaEnLista;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class RespuestaEnListaTest {

    @Test
    public void testSeCreaRespuestaEnListaConrrectamente() {
        Opcion opcion1 = new Opcion("una opcion");
        Opcion opcion2 = new Opcion("otra opcion");
        Opcion opcion3 = new Opcion("otra otra opcion");
        ListaOpciones opcionesSeleccionadad = new ListaOpciones(Arrays.asList(opcion1, opcion2, opcion3));
        RespuestaEnLista respuestaEnLista = new RespuestaEnLista(opcionesSeleccionadad);

        assert (respuestaEnLista.getOpcionesSeleccionadas().contieneLoMismo(opcionesSeleccionadad));

    }
}
