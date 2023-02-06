package edu.fiuba.algo3.modelo.preguntas;


import edu.fiuba.algo3.modelo.Excepciones.CantidadDeOpcionesInvalidaException;
import edu.fiuba.algo3.modelo.Preguntas.MultipleChoiceConPenalidad;
import edu.fiuba.algo3.modelo.Puntaje;
import edu.fiuba.algo3.modelo.Respuestas.RespuestaEnLista;
import edu.fiuba.algo3.modelo.bonus.Multiplicador;
import edu.fiuba.algo3.modelo.opciones.ListaOpciones;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MultipleChoiceConPenalidadTest {
    private String consigna;

    private Opcion opcionCorrecta1;
    private Opcion opcionCorrecta2;
    private Opcion opcionIncorrecta1;
    private Opcion opcionIncorrecta2;

    private ListaOpciones opcionesCorrectas ;
    private ListaOpciones opcionesIncorrectas ;

    private ListaOpciones opcionesElegidas;

    @BeforeEach
    public void setup (){

        consigna = "Indicar cuales de las siguientes opciones son quesos";

        opcionCorrecta1 = new Opcion("Cheddar",new Puntaje(1));
        opcionCorrecta2 = new Opcion("Roquefort",new Puntaje(1));
        opcionIncorrecta1 = new Opcion("Ketchup",new Puntaje(-1));
        opcionIncorrecta2 = new Opcion("Mostaza",new Puntaje(-1));

        opcionesCorrectas = opcionCorrecta1.con(opcionCorrecta2);
        opcionesIncorrectas = opcionIncorrecta1.con(opcionIncorrecta2);

        opcionesElegidas = new ListaOpciones();
    }

    @Test
    public void testCrearMultipleChoiceConPenalidad(){
        MultipleChoiceConPenalidad multipleChoiceConPenalidad = new MultipleChoiceConPenalidad(consigna, opcionesCorrectas, opcionesIncorrectas);

        assertEquals("Indicar cuales de las siguientes opciones son quesos", multipleChoiceConPenalidad.getConsigna());
        assert( multipleChoiceConPenalidad.getOpcionesCorrectas().contieneLoMismo(opcionesCorrectas));
        assert( multipleChoiceConPenalidad.getOpcionesIncorrectas().contieneLoMismo(opcionesIncorrectas));
    }

    @Test
    public void testMultipleChoiceConPenalidadLanzaExcepcionSiSeLeIngresan6Opciones() {
        ListaOpciones respuestasCorrectas = new ListaOpciones();
        ListaOpciones respuestasIncorrectas = new ListaOpciones();
        String consigna = "Indicar cuáles de las siguientes opciones son colores";

        Opcion opcionCorrecta1 = new Opcion("Amarillo");
        Opcion opcionCorrecta2 = new Opcion("Azul");
        Opcion opcionCorrecta3 = new Opcion("Verde");
        Opcion opcionCorrecta4 = new Opcion("Rojo");
        Opcion opcionIncorrecta1 = new Opcion("Tractor");
        Opcion opcionIncorrecta2 = new Opcion("Auto");

        respuestasCorrectas.agregar(opcionCorrecta1);
        respuestasCorrectas.agregar(opcionCorrecta2);
        respuestasCorrectas.agregar(opcionCorrecta3);
        respuestasCorrectas.agregar(opcionCorrecta4);
        respuestasIncorrectas.agregar(opcionIncorrecta1);
        respuestasIncorrectas.agregar(opcionIncorrecta2);

        assertThrows(CantidadDeOpcionesInvalidaException.class, () -> new MultipleChoiceConPenalidad(consigna, respuestasCorrectas, respuestasIncorrectas));
    }
    @Test
    public void testMultipleChoiceConPenalidadLanzaExcepcionSiSeLeIngresa1Opcion() {
        ListaOpciones respuestasCorrectas = new ListaOpciones();
        ListaOpciones respuestasIncorrectas = new ListaOpciones();
        String consigna = "Indicar cuáles de las siguientes opciones son colores";

        Opcion opcionCorrecta1 = new Opcion("Amarillo");

        respuestasCorrectas.agregar(opcionCorrecta1);

        assertThrows(CantidadDeOpcionesInvalidaException.class, () -> new MultipleChoiceConPenalidad(consigna, respuestasCorrectas, respuestasIncorrectas));
    }

    @Test
    public void testAplicaPuntajeAUnJugadorDeDosopcionesCorrectas(){
        MultipleChoiceConPenalidad multipleChoiceConPenalidad = new MultipleChoiceConPenalidad(consigna, opcionesCorrectas, opcionesIncorrectas);

        opcionesElegidas.agregar(opcionCorrecta1);
        opcionesElegidas.agregar(opcionCorrecta2);

        RespuestaEnLista respuestaDelJugador = new RespuestaEnLista(opcionesElegidas);

        assertEquals(2, multipleChoiceConPenalidad.evaluarRespuestaPara(respuestaDelJugador).getPuntos());
    }

    @Test
    public void testAplicaPuntajeAUnJugadorDeUnaOpcionCorrecta(){
        MultipleChoiceConPenalidad multipleChoiceConPenalidad = new MultipleChoiceConPenalidad(consigna, opcionesCorrectas, opcionesIncorrectas);

        opcionesElegidas.agregar(opcionCorrecta1);

        RespuestaEnLista respuestaDelJugador = new RespuestaEnLista(opcionesElegidas);

        assertEquals(1, multipleChoiceConPenalidad.evaluarRespuestaPara(respuestaDelJugador).getPuntos());
    }

    @Test
    public void testAplicaPuntajeDeUnaRespuestaCorrectaYOtraIncorrectaSumandoCeroPuntos(){
        MultipleChoiceConPenalidad multipleChoiceConPenalidad = new MultipleChoiceConPenalidad(consigna, opcionesCorrectas, opcionesIncorrectas);

        opcionesElegidas.agregar(opcionCorrecta1);
        opcionesElegidas.agregar(opcionIncorrecta1);

        RespuestaEnLista respuestaDelJugador = new RespuestaEnLista(opcionesElegidas);

        assertEquals(0, multipleChoiceConPenalidad.evaluarRespuestaPara(respuestaDelJugador).getPuntos());
    }

    @Test
    public void testAplicaElPuntajeDe2OpcionesIncorrectas(){
        MultipleChoiceConPenalidad multipleChoiceConPenalidad = new MultipleChoiceConPenalidad(consigna, opcionesCorrectas, opcionesIncorrectas);

        opcionesElegidas.agregar(opcionIncorrecta1);
        opcionesElegidas.agregar(opcionIncorrecta2);

        RespuestaEnLista respuestaDelJugador = new RespuestaEnLista(opcionesElegidas);

        assertEquals(-2, multipleChoiceConPenalidad.evaluarRespuestaPara(respuestaDelJugador).getPuntos());
    }

    @Test
    public void testSeVerificaQueSePuedaUtilizarMultiplicadorX2(){
        MultipleChoiceConPenalidad multipleChoiceConPenalidad = new MultipleChoiceConPenalidad(consigna, opcionesCorrectas, opcionesIncorrectas);
        assert(multipleChoiceConPenalidad.getMultiplicadorX2().getClass() == Multiplicador.class);
    }

    @Test
    public void testSeVerificaQueSePuedaUtilizarMultiplicadorX3(){
        MultipleChoiceConPenalidad multipleChoiceConPenalidad = new MultipleChoiceConPenalidad(consigna, opcionesCorrectas, opcionesIncorrectas);
        assert(multipleChoiceConPenalidad.getMultiplicadorX3().getClass() == Multiplicador.class);
    }

}