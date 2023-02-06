package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.bonus.Multiplicador;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import edu.fiuba.algo3.modelo.Preguntas.VerdaderoFalsoConPenalidad;
import edu.fiuba.algo3.modelo.Puntaje;
import edu.fiuba.algo3.modelo.Respuestas.RespuestaUnica;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class VerdaderoFalsoConPenalidadTest {
    private Opcion opcionVerdaderaCorrecta;
    private Opcion opcionFalsaCorrecta;
    @BeforeEach
    public void setup() {
        opcionVerdaderaCorrecta = new Opcion("Verdadero", new Puntaje(1));
        opcionFalsaCorrecta = new Opcion("Falso", new Puntaje(1));
    }
    @Test
    public void testSeCreaUnVoFConPenalidadConRespuestaCorrectaFalso() {
        String consigna = "Consigna:";
        VerdaderoFalsoConPenalidad verdaderoFalsoConPenalidad = VerdaderoFalsoConPenalidad.crearVerdaderoFalsoCorrectoFalso(consigna);

        Opcion opcionCorrecta = opcionFalsaCorrecta;
        Opcion opcionIncorrecta = verdaderoFalsoConPenalidad.getOpcionIncorrecta();

        assertEquals(consigna, verdaderoFalsoConPenalidad.getConsigna());

        assertEquals("Falso", opcionCorrecta.getOpcion());
        assertEquals(1, opcionCorrecta.getPuntaje().getPuntos());

        assertEquals("Verdadero", opcionIncorrecta.getOpcion());
        assertEquals(-1, opcionIncorrecta.getPuntaje().getPuntos());
    }

    @Test
    public void testSeLePideLaRespuestaIncorrectaAUnVoFConPenalidadYTienePuntajeMenosUno() {
        VerdaderoFalsoConPenalidad verdaderoFalsoConPenalidad = VerdaderoFalsoConPenalidad.crearVerdaderoFalsoCorrectoVerdadero("Consigna:");

        Opcion opcionIncorrecta = verdaderoFalsoConPenalidad.getOpcionIncorrecta();

        assertEquals("Falso", opcionIncorrecta.getOpcion());
        assertEquals(-1, opcionIncorrecta.getPuntaje().getPuntos());
    }

    @Test
    public void testSeEvaluaLaRespuestaIncorrectaDeUnJugadorRestandoleUnPunto() {
        VerdaderoFalsoConPenalidad verdaderoFalsoConPenalidad = VerdaderoFalsoConPenalidad.crearVerdaderoFalsoCorrectoVerdadero("Consigna:");
        RespuestaUnica respuestaDelJugador = new RespuestaUnica(verdaderoFalsoConPenalidad.getOpcionIncorrecta());

        assertEquals(-1, verdaderoFalsoConPenalidad.evaluarRespuestaPara(respuestaDelJugador).getPuntos());
    }

    @Test
    public void testSeEvaluaLaRespuestaIncorrectaDeUnJugadorSumandoleUnPunto() {
        VerdaderoFalsoConPenalidad verdaderoFalsoConPenalidad = VerdaderoFalsoConPenalidad.crearVerdaderoFalsoCorrectoVerdadero("Consigna:");
        RespuestaUnica respuestaDelJugador = new RespuestaUnica(opcionVerdaderaCorrecta);

        assertEquals(1, verdaderoFalsoConPenalidad.evaluarRespuestaPara(respuestaDelJugador).getPuntos());
    }

    @Test
    public void testSeVerificaQueSePuedaUtilizarMultiplicadorX2(){
        VerdaderoFalsoConPenalidad verdaderoFalsoConPenalidad = VerdaderoFalsoConPenalidad.crearVerdaderoFalsoCorrectoVerdadero("Consigna:");

        assert(verdaderoFalsoConPenalidad.getMultiplicadorX2().getClass() == Multiplicador.class);
    }

    @Test
    public void testSeVerificaQueSePuedaUtilizarMultiplicadorX3(){
        VerdaderoFalsoConPenalidad verdaderoFalsoConPenalidad = VerdaderoFalsoConPenalidad.crearVerdaderoFalsoCorrectoVerdadero("Consigna:");

        assert(verdaderoFalsoConPenalidad.getMultiplicadorX3().getClass() == Multiplicador.class);
    }


}