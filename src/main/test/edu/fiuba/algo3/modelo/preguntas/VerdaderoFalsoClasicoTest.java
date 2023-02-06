package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.bonus.Exclusividad;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import edu.fiuba.algo3.modelo.Preguntas.VerdaderoFalsoClasico;
import edu.fiuba.algo3.modelo.Puntaje;
import edu.fiuba.algo3.modelo.Respuestas.RespuestaUnica;
import edu.fiuba.algo3.modelo.Excepciones.OpcionNoValidaException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


import static org.junit.jupiter.api.Assertions.assertThrows;

public class VerdaderoFalsoClasicoTest {
    private Opcion opcionVerdaderaCorrecta;
    private Opcion opcionFalsaCorrecta;

    @BeforeEach
    public void setup() {
        opcionVerdaderaCorrecta = new Opcion("Verdadero", new Puntaje(1));
        opcionFalsaCorrecta = new Opcion("Falso", new Puntaje(1));
    }

    @Test
    public void testCrearUnaPreguntaVerdaderoYFalsoClasicoIndicandoleLaRespuestaCorrectaVerdadera() {
        VerdaderoFalsoClasico vofVerdaderaCorrecta = VerdaderoFalsoClasico.crearVerdaderoFalsoCorrectaVerdadero("foo");
        Opcion opcionCorrecta = new Opcion("Verdadero");

        assert (opcionVerdaderaCorrecta.esIgualA(opcionCorrecta));
        assertEquals("foo", vofVerdaderaCorrecta.getConsigna());
    }

    @Test
    public void testCrearUnaPreguntaVerdaderoYFalsoClasicoLaRespuestaCorrectaFalso() {
        VerdaderoFalsoClasico vofFalsaCorrecta = VerdaderoFalsoClasico.crearVerdaderoFalsoCorrectoFalso("bar");
        Opcion opcionCorrecta = new Opcion("Falso");

        assert (opcionFalsaCorrecta.esIgualA(opcionCorrecta));
        assertEquals("bar", vofFalsaCorrecta.getConsigna());
    }


    @Test
    public void testVoFClasicoLanzaExcepcionSiSeLaDaUnaRespuestaNoValidaAlEvaluarRespuestas() {
        Opcion opcionInvalida = new Opcion("foo");
        RespuestaUnica respuestaDelJugador = new RespuestaUnica(opcionInvalida);

        VerdaderoFalsoClasico vofClasico = VerdaderoFalsoClasico.crearVerdaderoFalsoCorrectaVerdadero("bar");

        assertThrows(OpcionNoValidaException.class, () -> vofClasico.evaluarRespuestaPara(respuestaDelJugador));
    }

    @Test
    public void testSeVerificaQueSePuedaUtilizarExclusividad() {
        VerdaderoFalsoClasico vofVerdaderaCorrecta = VerdaderoFalsoClasico.crearVerdaderoFalsoCorrectaVerdadero("foo");

        assert (vofVerdaderaCorrecta.getExclusividad().getClass() == Exclusividad.class);
    }
}
