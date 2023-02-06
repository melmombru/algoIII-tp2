package edu.fiuba.algo3.modelo.respuestas;

import edu.fiuba.algo3.modelo.opciones.ListaOpciones;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import edu.fiuba.algo3.modelo.Respuestas.RespuestaDeGrupos;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class RespuestaDeGruposTest {

    @Test
    public void testSeCreaRespuestaDeGruposConrrectamente() {
        Opcion opcion1A = new Opcion("una opcion");
        Opcion opcion2A = new Opcion("otra opcion");
        Opcion opcion1B = new Opcion("otra otra opcion");
        Opcion opcion2B = new Opcion("otra otra otra opcion");
        ListaOpciones opcionesSeleccionadasGrupoA = new ListaOpciones(Arrays.asList(opcion1A, opcion2A));
        ListaOpciones opcionesSeleccionadasGrupoB = new ListaOpciones(Arrays.asList(opcion1B, opcion2B));
        RespuestaDeGrupos respuestaDeGrupos = new RespuestaDeGrupos(opcionesSeleccionadasGrupoA, opcionesSeleccionadasGrupoB);

        assert (respuestaDeGrupos.getOpcionesSeleccionadasGrupoA().contieneLoMismo(opcionesSeleccionadasGrupoA));
        assert (respuestaDeGrupos.getOpcionesSeleccionadasGrupoB().contieneLoMismo(opcionesSeleccionadasGrupoB));
    }
}
