package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Preguntas.*;
import edu.fiuba.algo3.modelo.Respuestas.RespuestaDeGrupos;
import edu.fiuba.algo3.modelo.Respuestas.RespuestaEnLista;
import edu.fiuba.algo3.modelo.Respuestas.RespuestaUnica;
import edu.fiuba.algo3.modelo.opciones.ListaOpciones;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class AsignacionDePuntosTest {
    private Opcion opcionFalsaCorrecta;

    private String consignaMultipleChoice;
    private Opcion opcionCorrectaTierra;
    private Opcion opcionCorrectaMarte;
    private Opcion opcionCorrectaJupiter;
    private Opcion opcionCorrectaSaturno;
    private Opcion opcionIncorrectaAzul;
    private Opcion opcionIncorrectaAmarillo;

    private Opcion opcionIncorrectaAzulPenalidad;
    private Opcion opcionIncorrectaAmarilloPenalidad;

    private String consignaGroupChoice;
    private String nombreGrupoA;
    private String nombreGrupoB;
    private Opcion opcion1DeGrupoA;
    private Opcion opcion2DeGrupoA;
    private Opcion opcion3DeGrupoA;
    private Opcion opcion1DeGrupoB;
    private Opcion opcion2DeGrupoB;
    private Opcion opcion3DeGrupoB;


    private String consignaOrderdChoice;
    private Opcion primerOpcion;
    private Opcion segundaOpcion;
    private Opcion terceraOpcion;
    private Opcion cuartaOpcion;
    private Opcion quintaOpcion;


    @BeforeEach
    public void setupOpcionesVerdaderoFalso() {
        opcionFalsaCorrecta = new Opcion("Falso", new Puntaje(1));
    }

    @BeforeEach
    public void setupOpcionesMultipleChoice() {
        consignaMultipleChoice = "Indicar cuales de los siguientes con planetas:";
        opcionCorrectaTierra = new Opcion("Tierra", new Puntaje(1));
        opcionCorrectaMarte = new Opcion("Marte", new Puntaje(1));
        opcionCorrectaJupiter = new Opcion("Jupiter", new Puntaje(1));
        opcionCorrectaSaturno = new Opcion("Saturno", new Puntaje(1));
        opcionIncorrectaAzul = new Opcion("Azul", new Puntaje(0));
        opcionIncorrectaAmarillo = new Opcion("Amarillo", new Puntaje(0));

        opcionIncorrectaAzulPenalidad = new Opcion("Azul", new Puntaje(-1));
        opcionIncorrectaAmarilloPenalidad = new Opcion("Amarillo", new Puntaje(-1));
    }

    @BeforeEach
    public void setupOpcionesGroupChoice() {
        consignaGroupChoice = "Agrupe en las categorias A y B:";
        nombreGrupoA = "Grupo A";
        nombreGrupoB = "Grupo B";

        opcion1DeGrupoA = new Opcion("respuesta1GrupoA");
        opcion2DeGrupoA = new Opcion("respuesta2GrupoA");
        opcion3DeGrupoA = new Opcion("respuesta3GrupoA");
        opcion1DeGrupoB = new Opcion("respuesta1GrupoB");
        opcion2DeGrupoB = new Opcion("respuesta2GrupoB");
        opcion3DeGrupoB = new Opcion("respuesta3GrupoB");
    }

    @BeforeEach
    public void setupOpcionesOrderedChoice() {
        consignaOrderdChoice = "Ordene correctamente las opciones:";

        primerOpcion = new Opcion("1er Opcion");
        segundaOpcion = new Opcion("2da Opcion");
        terceraOpcion = new Opcion("3era Opcion");
        cuartaOpcion = new Opcion("4ta Opcion");
        quintaOpcion = new Opcion("5ta Opcion");
    }

    @Test
    public void testVerdaderoFalsoClasicoJugador1AsertaYJugador2FallaSumandoCorrectamenteLosPuntajes() {

        String consigna = "El Sol es azul";
        VerdaderoFalsoClasico preguntaVerderoFalsoClasico = VerdaderoFalsoClasico.crearVerdaderoFalsoCorrectoFalso(consigna);

        Kahoot kahoot = new Kahoot();

        RespuestaUnica respuestaDelJugador1 = new RespuestaUnica(opcionFalsaCorrecta);
        RespuestaUnica respuestaDelJugador2 = new RespuestaUnica(preguntaVerderoFalsoClasico.getOpcionIncorrecta());

        kahoot.setRespuestaJugador(respuestaDelJugador1, kahoot.getJugador1());
        kahoot.setRespuestaJugador(respuestaDelJugador2, kahoot.getJugador2());

        kahoot.evaluarRespuestas(preguntaVerderoFalsoClasico);

        assertEquals(1, kahoot.getPuntajeJugador1().getPuntos());
        assertEquals(0, kahoot.getPuntajeJugador2().getPuntos());
    }

    @Test
    public void testVerdaderoFalsoConPenalidadJugador1AsertaYJugador2FallaSumandoleCorrectamenteLosPuntajes() {

        String consigna = "El Sol es azul";
        VerdaderoFalsoConPenalidad preguntaVerderoFalsoConPenalidad = VerdaderoFalsoConPenalidad.crearVerdaderoFalsoCorrectoFalso(consigna);

        Kahoot kahoot = new Kahoot();

        RespuestaUnica respuestaDelJugador1 = new RespuestaUnica(opcionFalsaCorrecta);
        RespuestaUnica respuestaDelJugador2 = new RespuestaUnica(preguntaVerderoFalsoConPenalidad.getOpcionIncorrecta());

        kahoot.setRespuestaJugador(respuestaDelJugador1, kahoot.getJugador1());
        kahoot.setRespuestaJugador(respuestaDelJugador2, kahoot.getJugador2());

        kahoot.evaluarRespuestas(preguntaVerderoFalsoConPenalidad);

        assertEquals(1, kahoot.getPuntajeJugador1().getPuntos());
        assertEquals(-1, kahoot.getPuntajeJugador2().getPuntos());
    }

    @Test
    public void testMultipleChoiceParcialJugadorAciertanTodasLasRespuestasCorrectasSumandolesCorrectamenteLosPuntosDeLasRespuestasCorrectas() {
        ListaOpciones opcionesCorrectas = opcionCorrectaTierra.con(opcionCorrectaMarte).con(opcionCorrectaJupiter);
        ListaOpciones opcionesIncorrectas = opcionIncorrectaAzul.con(opcionIncorrectaAmarillo);
        ListaOpciones opcionesSeleccionadas = new ListaOpciones(opcionesCorrectas);

        MultipleChoiceParcial preguntaMultipleChoiceParcial = new MultipleChoiceParcial(consignaMultipleChoice, opcionesCorrectas, opcionesIncorrectas);

        Kahoot kahoot = new Kahoot();

        RespuestaEnLista respuestaDelJugador1 = new RespuestaEnLista(opcionesSeleccionadas);
        RespuestaEnLista respuestaDelJugador2 = new RespuestaEnLista(opcionesSeleccionadas);

        kahoot.setRespuestaJugador(respuestaDelJugador1, kahoot.getJugador1());
        kahoot.setRespuestaJugador(respuestaDelJugador2, kahoot.getJugador2());

        kahoot.evaluarRespuestas(preguntaMultipleChoiceParcial);

        assertEquals(3, kahoot.getPuntajeJugador1().getPuntos());
        assertEquals(3, kahoot.getPuntajeJugador2().getPuntos());
    }

    @Test
    public void testMultipleChoiceParcialJugadoresAciertanTodasLasOpcionesCorrectasYUnaIncorrectaSumandoCeroPuntos() {
        ListaOpciones opcionesCorrectas = opcionCorrectaTierra.con(opcionCorrectaMarte);
        ListaOpciones opcionesIncorrectas = opcionIncorrectaAzul.con(opcionIncorrectaAmarillo);

        ListaOpciones opcionesSeleccionadas = opcionesCorrectas.con(opcionIncorrectaAzul);

        MultipleChoiceParcial preguntaMultipleChoiceParcial = new MultipleChoiceParcial(consignaMultipleChoice, opcionesCorrectas, opcionesIncorrectas);

        Kahoot kahoot = new Kahoot();

        RespuestaEnLista respuestaDelJugador1 = new RespuestaEnLista(opcionesSeleccionadas);
        RespuestaEnLista respuestaDelJugador2 = new RespuestaEnLista(opcionesSeleccionadas);

        kahoot.setRespuestaJugador(respuestaDelJugador1, kahoot.getJugador1());
        kahoot.setRespuestaJugador(respuestaDelJugador2, kahoot.getJugador2());


        kahoot.evaluarRespuestas(preguntaMultipleChoiceParcial);

        assertEquals(0, kahoot.getPuntajeJugador1().getPuntos());
        assertEquals(0, kahoot.getPuntajeJugador2().getPuntos());
    }

    @Test
    public void testMultipleChoiceParcialJugadoresAciertanAlgunasCorrectasYNingunaIncorrectaSumandolesCorrectamenteLosPuntos() {
        ListaOpciones opcionesCorrectas = opcionCorrectaTierra.con(opcionCorrectaMarte).con(opcionCorrectaJupiter);
        ListaOpciones opcionesIncorrectas = opcionIncorrectaAzul.con(opcionIncorrectaAmarillo);

        ListaOpciones opcionesSeleccionadas = opcionCorrectaTierra.con(opcionCorrectaMarte);

        MultipleChoiceParcial preguntaMultipleChoiceParcial = new MultipleChoiceParcial(consignaMultipleChoice, opcionesCorrectas, opcionesIncorrectas);

        Kahoot kahoot = new Kahoot();

        RespuestaEnLista respuestaDelJugador1 = new RespuestaEnLista(opcionesSeleccionadas);
        RespuestaEnLista respuestaDelJugador2 = new RespuestaEnLista(opcionesSeleccionadas);

        kahoot.setRespuestaJugador(respuestaDelJugador1, kahoot.getJugador1());
        kahoot.setRespuestaJugador(respuestaDelJugador2, kahoot.getJugador2());

        kahoot.evaluarRespuestas(preguntaMultipleChoiceParcial);

        assertEquals(2, kahoot.getPuntajeJugador1().getPuntos());
        assertEquals(2, kahoot.getPuntajeJugador2().getPuntos());
    }

    @Test
    public void testMultipleChoiceParcialJugadoresNoAciertaNingunaCorrectasSumandolesCeroPuntos() {
        ListaOpciones opcionesCorrectas = opcionCorrectaTierra.con(opcionCorrectaMarte).con(opcionCorrectaJupiter);
        ListaOpciones opcionesIncorrectas = opcionIncorrectaAzul.con(opcionIncorrectaAmarillo);
        ListaOpciones opcionesSeleccionadas = new ListaOpciones();
        opcionesSeleccionadas.agregar(opcionIncorrectaAmarillo);

        MultipleChoiceParcial preguntaMultipleChoiceParcial = new MultipleChoiceParcial(consignaMultipleChoice, opcionesCorrectas, opcionesIncorrectas);

        Kahoot kahoot = new Kahoot();

        RespuestaEnLista respuestaDelJugador1 = new RespuestaEnLista(opcionesSeleccionadas);
        RespuestaEnLista respuestaDelJugador2 = new RespuestaEnLista(opcionesSeleccionadas);

        kahoot.setRespuestaJugador(respuestaDelJugador1, kahoot.getJugador1());
        kahoot.setRespuestaJugador(respuestaDelJugador2, kahoot.getJugador2());


        kahoot.evaluarRespuestas(preguntaMultipleChoiceParcial);

        assertEquals(0, kahoot.getPuntajeJugador1().getPuntos());
        assertEquals(0, kahoot.getPuntajeJugador2().getPuntos());
    }

    @Test
    public void testMultipleChoiceClasicoJugadorAciertaTodasLasOpcionesCorrectasSumandoleUnPunto() {
        ListaOpciones opcionesCorrectas = opcionCorrectaTierra.con(opcionCorrectaMarte).con(opcionCorrectaJupiter);
        ListaOpciones opcionesIncorrectas = opcionIncorrectaAzul.con(opcionIncorrectaAmarillo);

        ListaOpciones opcionesSeleccionadas = new ListaOpciones(opcionesCorrectas);

        MultipleChoiceClasico preguntaMultipleChoiceClasico = new MultipleChoiceClasico(consignaMultipleChoice, opcionesCorrectas, opcionesIncorrectas);

        Kahoot kahoot = new Kahoot();

        RespuestaEnLista respuestaDelJugador1 = new RespuestaEnLista(opcionesSeleccionadas);
        RespuestaEnLista respuestaDelJugador2 = new RespuestaEnLista(opcionesSeleccionadas);

        kahoot.setRespuestaJugador(respuestaDelJugador1, kahoot.getJugador1());
        kahoot.setRespuestaJugador(respuestaDelJugador2, kahoot.getJugador2());


        kahoot.evaluarRespuestas(preguntaMultipleChoiceClasico);

        assertEquals(1, kahoot.getPuntajeJugador1().getPuntos());
        assertEquals(1, kahoot.getPuntajeJugador2().getPuntos());
    }

    @Test
    public void testMultipleChoiceClasicoJugadoresAciertanTodasLasRespuestasCorrectasYUnaIncorrectaSumandolesCeroPuntos() {
        ListaOpciones opcionesCorrectas = opcionCorrectaTierra.con(opcionCorrectaMarte).con(opcionCorrectaJupiter);
        ListaOpciones opcionesIncorrectas = opcionIncorrectaAzul.con(opcionIncorrectaAmarillo);

        ListaOpciones opcionesSeleccionadas = new ListaOpciones();
        opcionesSeleccionadas.agregarTodo(opcionesCorrectas);
        opcionesSeleccionadas.agregar(opcionIncorrectaAzul);

        MultipleChoiceClasico preguntaMultipleChoiceClasico = new MultipleChoiceClasico(consignaMultipleChoice, opcionesCorrectas, opcionesIncorrectas);

        Kahoot kahoot = new Kahoot();

        RespuestaEnLista respuestaDelJugador1 = new RespuestaEnLista(opcionesSeleccionadas);
        RespuestaEnLista respuestaDelJugador2 = new RespuestaEnLista(opcionesSeleccionadas);

        kahoot.setRespuestaJugador(respuestaDelJugador1, kahoot.getJugador1());
        kahoot.setRespuestaJugador(respuestaDelJugador2, kahoot.getJugador2());


        kahoot.evaluarRespuestas(preguntaMultipleChoiceClasico);

        assertEquals(0, kahoot.getPuntajeJugador1().getPuntos());
        assertEquals(0, kahoot.getPuntajeJugador2().getPuntos());
    }

    @Test
    public void testMultipleChoiceClasicoJugadoesrNoAciertanNingunaRespuestasCorrectasSumandolesCeroPuntos() {
        ListaOpciones opcionesCorrectas = opcionCorrectaTierra.con(opcionCorrectaMarte).con(opcionCorrectaJupiter);
        ListaOpciones opcionesIncorrectas = opcionIncorrectaAzul.con(opcionIncorrectaAmarillo);

        ListaOpciones opcionesSeleccionadas = new ListaOpciones(opcionesIncorrectas);

        MultipleChoiceClasico preguntaMultipleChoiceClasico = new MultipleChoiceClasico(consignaMultipleChoice, opcionesCorrectas, opcionesIncorrectas);

        Kahoot kahoot = new Kahoot();

        RespuestaEnLista respuestaDelJugador1 = new RespuestaEnLista(opcionesSeleccionadas);
        RespuestaEnLista respuestaDelJugador2 = new RespuestaEnLista(opcionesSeleccionadas);

        kahoot.setRespuestaJugador(respuestaDelJugador1, kahoot.getJugador1());
        kahoot.setRespuestaJugador(respuestaDelJugador2, kahoot.getJugador2());

        kahoot.evaluarRespuestas(preguntaMultipleChoiceClasico);

        assertEquals(0, kahoot.getPuntajeJugador1().getPuntos());
        assertEquals(0, kahoot.getPuntajeJugador2().getPuntos());
    }

    @Test
    public void testGroupChoiceJugador1YJugador2AgrupanCorrectamenteLasRespuestasAsignandolesUnPuntoACadaUno() {
        ListaOpciones opcionesGrupoA = opcion1DeGrupoA.con(opcion2DeGrupoA).con(opcion3DeGrupoA);
        ListaOpciones opcionesGrupoB = opcion1DeGrupoB.con(opcion2DeGrupoB).con(opcion3DeGrupoB);

        GroupChoice preguntaGroupChoice = new GroupChoice(consignaGroupChoice, nombreGrupoA, opcionesGrupoA, nombreGrupoB, opcionesGrupoB);

        RespuestaDeGrupos respuestasJugador1 = new RespuestaDeGrupos(opcionesGrupoA, opcionesGrupoB);
        RespuestaDeGrupos respuestasJugador2 = new RespuestaDeGrupos(opcionesGrupoA, opcionesGrupoB);

        Kahoot kahoot = new Kahoot();

        kahoot.setRespuestaJugador(respuestasJugador1, kahoot.getJugador1());
        kahoot.setRespuestaJugador(respuestasJugador2, kahoot.getJugador2());

        kahoot.evaluarRespuestas(preguntaGroupChoice);

        assertEquals(1, kahoot.getPuntajeJugador1().getPuntos());
        assertEquals(1, kahoot.getPuntajeJugador2().getPuntos());
    }

    @Test
    public void testGroupChoiceJugador1AgrupaCorrectamenteLasOpcionesYJugador2AgrupaIncorrectamenteLasOpcionesAsignandolesCorrectamenteLosPuntajes() {
        ListaOpciones opcionesGrupoA = opcion1DeGrupoA.con(opcion2DeGrupoA).con(opcion3DeGrupoA);
        ListaOpciones opcionesGrupoB = opcion1DeGrupoB.con(opcion2DeGrupoB).con(opcion3DeGrupoB);

        GroupChoice preguntaGroupChoice = new GroupChoice(consignaGroupChoice, nombreGrupoA, opcionesGrupoA, nombreGrupoB, opcionesGrupoB);

        RespuestaDeGrupos respuestasJugador1 = new RespuestaDeGrupos(opcionesGrupoA, opcionesGrupoB);
        RespuestaDeGrupos respuestasJugador2 = new RespuestaDeGrupos(opcionesGrupoB, opcionesGrupoA);

        Kahoot kahoot = new Kahoot();

        kahoot.setRespuestaJugador(respuestasJugador1, kahoot.getJugador1());
        kahoot.setRespuestaJugador(respuestasJugador2, kahoot.getJugador2());

        kahoot.evaluarRespuestas(preguntaGroupChoice);

        assertEquals(1, kahoot.getPuntajeJugador1().getPuntos());
        assertEquals(0, kahoot.getPuntajeJugador2().getPuntos());
    }

    @Test
    public void testGroupChoiceJugador1YJugador2AgrupanIncorrectamenteLasOpcionesAsignandolesCeroPuntosACadaUno() {
        ListaOpciones opcionesGrupoA = opcion1DeGrupoA.con(opcion2DeGrupoA).con(opcion3DeGrupoA);
        ListaOpciones opcionesGrupoB = opcion1DeGrupoB.con(opcion2DeGrupoB).con(opcion3DeGrupoB);

        GroupChoice preguntaGroupChoice = new GroupChoice(consignaGroupChoice, nombreGrupoA, opcionesGrupoA, nombreGrupoB, opcionesGrupoB);

        RespuestaDeGrupos respuestasJugador1 = new RespuestaDeGrupos(opcionesGrupoB, opcionesGrupoA);
        RespuestaDeGrupos respuestasJugador2 = new RespuestaDeGrupos(opcionesGrupoB, opcionesGrupoA);

        Kahoot kahoot = new Kahoot();

        kahoot.setRespuestaJugador(respuestasJugador1, kahoot.getJugador1());
        kahoot.setRespuestaJugador(respuestasJugador2, kahoot.getJugador2());

        kahoot.evaluarRespuestas(preguntaGroupChoice);

        assertEquals(0, kahoot.getPuntajeJugador1().getPuntos());
        assertEquals(0, kahoot.getPuntajeJugador2().getPuntos());
    }

    @Test
    public void testOrderedChoiceJugador1YJugador2OrdenanCorrectamenteLasOpcionesAsignandolesCeroPuntosACadaUno() {
        ListaOpciones opcionesOrdenadasCorrectamente = primerOpcion.con(segundaOpcion).con(terceraOpcion).con(cuartaOpcion).con(quintaOpcion);

        OrderedChoice preguntaGroupChoice = new OrderedChoice(consignaOrderdChoice, opcionesOrdenadasCorrectamente);

        RespuestaEnLista respuestasJugador1 = new RespuestaEnLista(new ListaOpciones(opcionesOrdenadasCorrectamente));
        RespuestaEnLista respuestasJugador2 = new RespuestaEnLista(new ListaOpciones(opcionesOrdenadasCorrectamente));

        Kahoot kahoot = new Kahoot();

        kahoot.setRespuestaJugador(respuestasJugador1, kahoot.getJugador1());
        kahoot.setRespuestaJugador(respuestasJugador2, kahoot.getJugador2());

        kahoot.evaluarRespuestas(preguntaGroupChoice);

        assertEquals(1, kahoot.getPuntajeJugador1().getPuntos());
        assertEquals(1, kahoot.getPuntajeJugador2().getPuntos());
    }

    @Test
    public void testOrderedChoiceJugador1YJugador2OrdenanIncorrectamenteLasOpcionesAsignandolesCeroPuntosACadaUno() {
        ListaOpciones opcionesOrdenadasCorrectamente = primerOpcion.con(segundaOpcion).con(terceraOpcion).con(cuartaOpcion).con(quintaOpcion);
        ListaOpciones opcionesOrdenadasInorrectamente = primerOpcion.con(terceraOpcion).con(segundaOpcion).con(cuartaOpcion).con(quintaOpcion);

        OrderedChoice preguntaGroupChoice = new OrderedChoice(consignaOrderdChoice, opcionesOrdenadasCorrectamente);

        RespuestaEnLista respuestasJugador1 = new RespuestaEnLista(new ListaOpciones(opcionesOrdenadasInorrectamente));
        RespuestaEnLista respuestasJugador2 = new RespuestaEnLista(new ListaOpciones(opcionesOrdenadasInorrectamente));

        Kahoot kahoot = new Kahoot();

        kahoot.setRespuestaJugador(respuestasJugador1, kahoot.getJugador1());
        kahoot.setRespuestaJugador(respuestasJugador2, kahoot.getJugador2());

        kahoot.evaluarRespuestas(preguntaGroupChoice);

        assertEquals(0, kahoot.getPuntajeJugador1().getPuntos());
        assertEquals(0, kahoot.getPuntajeJugador2().getPuntos());
    }

    @Test
    public void testOrderedChoiceJugador1OrdenaCorrectamenteLasOpcionesYJugador2OrdenaInorrectamenteLasOpcionesAsignandolesCorrectamenteLosPuntajes() {
        ListaOpciones opcionesOrdenadasCorrectamente = primerOpcion.con(segundaOpcion).con(terceraOpcion).con(cuartaOpcion).con(quintaOpcion);
        ListaOpciones opcionesOrdenadasInorrectamente = primerOpcion.con(terceraOpcion).con(segundaOpcion).con(cuartaOpcion).con(quintaOpcion);

        OrderedChoice preguntaOrderedChoice = new OrderedChoice(consignaOrderdChoice, opcionesOrdenadasCorrectamente);

        RespuestaEnLista respuestasJugador1 = new RespuestaEnLista(new ListaOpciones(opcionesOrdenadasCorrectamente));
        RespuestaEnLista respuestasJugador2 = new RespuestaEnLista(new ListaOpciones(opcionesOrdenadasInorrectamente));

        Kahoot kahoot = new Kahoot();

        kahoot.setRespuestaJugador(respuestasJugador1, kahoot.getJugador1());
        kahoot.setRespuestaJugador(respuestasJugador2, kahoot.getJugador2());

        kahoot.evaluarRespuestas(preguntaOrderedChoice);

        assertEquals(1, kahoot.getPuntajeJugador1().getPuntos());
        assertEquals(0, kahoot.getPuntajeJugador2().getPuntos());
    }


    @Test
    public void testMultipleChoiceConPenalidadJugador1AciertaCuatroOpcionesYJugador2AciertaCuatroOpcionesSumandolesCorrectamenteCuatroPuntos() {
        ListaOpciones opcionesCorrectas = opcionCorrectaTierra.con(opcionCorrectaMarte).con(opcionCorrectaJupiter).con(opcionCorrectaSaturno);
        ListaOpciones opcionesIncorrectas = new ListaOpciones();
        opcionesIncorrectas.agregar(opcionIncorrectaAzulPenalidad);

        RespuestaEnLista respuestasJugador1 = new RespuestaEnLista(new ListaOpciones(opcionesCorrectas));
        RespuestaEnLista respuestasJugador2 = new RespuestaEnLista(new ListaOpciones(opcionesCorrectas));

        MultipleChoiceConPenalidad preguntaMultipleChoiceConPenalidad = new MultipleChoiceConPenalidad(consignaMultipleChoice, opcionesCorrectas, opcionesIncorrectas);

        Kahoot kahoot = new Kahoot();

        kahoot.setRespuestaJugador(respuestasJugador1, kahoot.getJugador1());
        kahoot.setRespuestaJugador(respuestasJugador2, kahoot.getJugador2());

        kahoot.evaluarRespuestas(preguntaMultipleChoiceConPenalidad);

        assertEquals(4, kahoot.getPuntajeJugador1().getPuntos());
        assertEquals(4, kahoot.getPuntajeJugador2().getPuntos());
    }

    @Test
    public void testMultipleChoiceConPenalidadJugador1EligeTresOpcionesCorrectasYUnaIncorrectaYJugador2EligeDosOpcionesCorrectasYDosIncorrectaAsignandolesCorrectamenteLosPuntos() {
        ListaOpciones opcionesCorrectas = opcionCorrectaTierra.con(opcionCorrectaMarte).con(opcionCorrectaJupiter);
        ListaOpciones opcionesIncorrectas = opcionIncorrectaAzulPenalidad.con(opcionIncorrectaAmarilloPenalidad);

        ListaOpciones opcionesJugador1 = opcionCorrectaTierra.con(opcionCorrectaMarte).con(opcionCorrectaJupiter).con(opcionIncorrectaAzulPenalidad);
        ListaOpciones opcionesJugador2 = opcionCorrectaTierra.con(opcionCorrectaMarte).con(opcionIncorrectaAmarilloPenalidad).con(opcionIncorrectaAzulPenalidad);

        RespuestaEnLista respuestasJugador1 = new RespuestaEnLista(opcionesJugador1);
        RespuestaEnLista respuestasJugador2 = new RespuestaEnLista(opcionesJugador2);

        MultipleChoiceConPenalidad preguntaMultipleChoiceConPenalidad = new MultipleChoiceConPenalidad(consignaMultipleChoice, opcionesCorrectas, opcionesIncorrectas);

        Kahoot kahoot = new Kahoot();

        kahoot.setRespuestaJugador(respuestasJugador1, kahoot.getJugador1());
        kahoot.setRespuestaJugador(respuestasJugador2, kahoot.getJugador2());

        kahoot.evaluarRespuestas(preguntaMultipleChoiceConPenalidad);

        assertEquals(2, kahoot.getPuntajeJugador1().getPuntos());
        assertEquals(0, kahoot.getPuntajeJugador2().getPuntos());
    }

    @Test
    public void testMultipleChoiceConPenalidadJugador1EligeUnaOpcionYDosIncorrectasYJugador2EligeCeroOpcionesCorrectasYDosIncorrectaAsignandolesCorrectamenteLosPuntos() {
        ListaOpciones opcionesCorrectas = opcionCorrectaTierra.con(opcionCorrectaMarte).con(opcionCorrectaJupiter);
        ListaOpciones opcionesIncorrectas = opcionIncorrectaAzulPenalidad.con(opcionIncorrectaAmarilloPenalidad);

        ListaOpciones opcionesJugador1 = opcionCorrectaTierra.con(opcionIncorrectaAmarilloPenalidad).con(opcionIncorrectaAzulPenalidad);
        ListaOpciones opcionesJugador2 = opcionIncorrectaAzulPenalidad.con(opcionIncorrectaAmarilloPenalidad);

        RespuestaEnLista respuestaJugador1 = new RespuestaEnLista(opcionesJugador1);
        RespuestaEnLista respuestaJugador2 = new RespuestaEnLista(opcionesJugador2);

        MultipleChoiceConPenalidad preguntaMultipleChoiceConPenalidad = new MultipleChoiceConPenalidad(consignaMultipleChoice, opcionesCorrectas, opcionesIncorrectas);

        Kahoot kahoot = new Kahoot();

        kahoot.setRespuestaJugador(respuestaJugador1, kahoot.getJugador1());
        kahoot.setRespuestaJugador(respuestaJugador2, kahoot.getJugador2());

        kahoot.evaluarRespuestas(preguntaMultipleChoiceConPenalidad);

        assertEquals(-1, kahoot.getPuntajeJugador1().getPuntos());
        assertEquals(-2, kahoot.getPuntajeJugador2().getPuntos());
    }

    @Test
    public void testVerdaderoFalsoClasicoJugador1AsertaYJugador2FallaSumandoCorrectamenteLosPuntajesConUnaExclusividad() {

        String consigna = "El Sol es azul";
        VerdaderoFalsoClasico preguntaVerderoFalsoClasico = VerdaderoFalsoClasico.crearVerdaderoFalsoCorrectoFalso(consigna);

        Kahoot kahoot = new Kahoot();

        RespuestaUnica respuestaDelJugador1 = new RespuestaUnica(opcionFalsaCorrecta);
        RespuestaUnica respuestaDelJugador2 = new RespuestaUnica(preguntaVerderoFalsoClasico.getOpcionIncorrecta());

        kahoot.setRespuestaJugador(respuestaDelJugador1, kahoot.getJugador1());
        kahoot.setRespuestaJugador(respuestaDelJugador2, kahoot.getJugador2());

        kahoot.agregarExclusividad(preguntaVerderoFalsoClasico, kahoot.getJugador1());

        kahoot.evaluarRespuestas(preguntaVerderoFalsoClasico);

        assertEquals(2, kahoot.getPuntajeJugador1().getPuntos());
        assertEquals(0, kahoot.getPuntajeJugador2().getPuntos());
    }

    @Test
    public void testVerdaderoFalsoConPenalidadJugador1AsertaYJugador2FallaSumandoleCorrectamenteLosPuntajesConUnMultiplicadorDelJugador2() {
        String consigna = "El Sol es azul";
        VerdaderoFalsoConPenalidad preguntaVerderoFalsoConPenalidad = VerdaderoFalsoConPenalidad.crearVerdaderoFalsoCorrectoFalso(consigna);

        Kahoot kahoot = new Kahoot();

        RespuestaUnica respuestaDelJugador1 = new RespuestaUnica(opcionFalsaCorrecta);
        RespuestaUnica respuestaDelJugador2 = new RespuestaUnica(preguntaVerderoFalsoConPenalidad.getOpcionIncorrecta());

        kahoot.setRespuestaJugador(respuestaDelJugador1, kahoot.getJugador1());
        kahoot.setRespuestaJugador(respuestaDelJugador2, kahoot.getJugador2());

        kahoot.agregarMultiplicadorX2(preguntaVerderoFalsoConPenalidad, kahoot.getJugador2());

        kahoot.evaluarRespuestas(preguntaVerderoFalsoConPenalidad);

        assertEquals(1, kahoot.getPuntajeJugador1().getPuntos());
        assertEquals(-2, kahoot.getPuntajeJugador2().getPuntos());
    }

    @Test
    public void testMultipleChoiceParcialJugadorAciertanTodasLasRespuestasCorrectasSumandolesCorrectamenteLosPuntosDeLasRespuestasCorrectasConUnaExclusividad() {
        ListaOpciones opcionesCorrectas = opcionCorrectaTierra.con(opcionCorrectaMarte).con(opcionCorrectaJupiter);
        ListaOpciones opcionesIncorrectas = opcionIncorrectaAzul.con(opcionIncorrectaAmarillo);

        ListaOpciones opcionesSeleccionadas = new ListaOpciones(opcionesCorrectas);

        MultipleChoiceParcial preguntaMultipleChoiceParcial = new MultipleChoiceParcial(consignaMultipleChoice, opcionesCorrectas, opcionesIncorrectas);

        Kahoot kahoot = new Kahoot();

        RespuestaEnLista respuestaDelJugador1 = new RespuestaEnLista(opcionesSeleccionadas);
        RespuestaEnLista respuestaDelJugador2 = new RespuestaEnLista(opcionesSeleccionadas);

        kahoot.setRespuestaJugador(respuestaDelJugador1, kahoot.getJugador1());
        kahoot.setRespuestaJugador(respuestaDelJugador2, kahoot.getJugador2());

        kahoot.agregarExclusividad(preguntaMultipleChoiceParcial, kahoot.getJugador1());

        kahoot.evaluarRespuestas(preguntaMultipleChoiceParcial);

        assertEquals(0, kahoot.getPuntajeJugador1().getPuntos());
        assertEquals(0, kahoot.getPuntajeJugador2().getPuntos());
    }

    @Test
    public void testMultipleChoiceParcialJugadoresNoAciertaNingunaCorrectasSumandolesCeroPuntosConExclusividad() {
        ListaOpciones opcionesCorrectas = opcionCorrectaTierra.con(opcionCorrectaMarte).con(opcionCorrectaJupiter);
        ListaOpciones opcionesIncorrectas = opcionIncorrectaAzul.con(opcionIncorrectaAmarillo);

        ListaOpciones opcionesSeleccionadas = new ListaOpciones();
        opcionesSeleccionadas.agregar(opcionIncorrectaAmarillo);

        MultipleChoiceParcial preguntaMultipleChoiceParcial = new MultipleChoiceParcial(consignaMultipleChoice, opcionesCorrectas, opcionesIncorrectas);

        Kahoot kahoot = new Kahoot();

        RespuestaEnLista respuestaDelJugador1 = new RespuestaEnLista(opcionesSeleccionadas);
        RespuestaEnLista respuestaDelJugador2 = new RespuestaEnLista(opcionesSeleccionadas);

        kahoot.setRespuestaJugador(respuestaDelJugador1, kahoot.getJugador1());
        kahoot.setRespuestaJugador(respuestaDelJugador2, kahoot.getJugador2());

        kahoot.agregarExclusividad(preguntaMultipleChoiceParcial, kahoot.getJugador1());

        kahoot.evaluarRespuestas(preguntaMultipleChoiceParcial);

        assertEquals(0, kahoot.getPuntajeJugador1().getPuntos());
        assertEquals(0, kahoot.getPuntajeJugador2().getPuntos());
    }

    @Test
    public void testGroupChoiceJugador1AgrupaCorrectamenteLasOpcionesYJugador2AgrupaIncorrectamenteLasOpcionesAsignandolesCorrectamenteLosPuntajesConDosExclusividades() {
        ListaOpciones opcionesGrupoA = opcion1DeGrupoA.con(opcion2DeGrupoA).con(opcion3DeGrupoA);
        ListaOpciones opcionesGrupoB = opcion1DeGrupoB.con(opcion2DeGrupoB).con(opcion3DeGrupoB);

        GroupChoice preguntaGroupChoice = new GroupChoice(consignaGroupChoice, nombreGrupoA, opcionesGrupoA, nombreGrupoB, opcionesGrupoB);

        RespuestaDeGrupos respuestasJugador1 = new RespuestaDeGrupos(opcionesGrupoA, opcionesGrupoB);
        RespuestaDeGrupos respuestasJugador2 = new RespuestaDeGrupos(opcionesGrupoB, opcionesGrupoA);

        Kahoot kahoot = new Kahoot();

        kahoot.setRespuestaJugador(respuestasJugador1, kahoot.getJugador1());
        kahoot.setRespuestaJugador(respuestasJugador2, kahoot.getJugador2());

        kahoot.agregarExclusividad(preguntaGroupChoice, kahoot.getJugador1());
        kahoot.agregarExclusividad(preguntaGroupChoice, kahoot.getJugador2());

        kahoot.evaluarRespuestas(preguntaGroupChoice);

        assertEquals(4, kahoot.getPuntajeJugador1().getPuntos());
        assertEquals(0, kahoot.getPuntajeJugador2().getPuntos());
    }

    @Test
    public void testMultipleChoiceConPenalidadJugador1AciertaCuatroOpcionesYJugador2AciertaCuatroOpcionesSumandolesCorrectamenteOchoPuntosConDosMultiplicadoresX2() {
        ListaOpciones opcionesCorrectas = opcionCorrectaTierra.con(opcionCorrectaMarte).con(opcionCorrectaJupiter).con(opcionCorrectaSaturno);
        ListaOpciones opcionesIncorrectas = new ListaOpciones();
        opcionesIncorrectas.agregar(opcionIncorrectaAzulPenalidad);

        RespuestaEnLista respuestasJugador1 = new RespuestaEnLista(new ListaOpciones(opcionesCorrectas));
        RespuestaEnLista respuestasJugador2 = new RespuestaEnLista(new ListaOpciones(opcionesCorrectas));

        MultipleChoiceConPenalidad preguntaMultipleChoiceConPenalidad = new MultipleChoiceConPenalidad(consignaMultipleChoice, opcionesCorrectas, opcionesIncorrectas);

        Kahoot kahoot = new Kahoot();

        kahoot.setRespuestaJugador(respuestasJugador1, kahoot.getJugador1());
        kahoot.setRespuestaJugador(respuestasJugador2, kahoot.getJugador2());

        kahoot.agregarMultiplicadorX2(preguntaMultipleChoiceConPenalidad, kahoot.getJugador1());
        kahoot.agregarMultiplicadorX2(preguntaMultipleChoiceConPenalidad, kahoot.getJugador2());

        kahoot.evaluarRespuestas(preguntaMultipleChoiceConPenalidad);

        assertEquals(8, kahoot.getPuntajeJugador1().getPuntos());
        assertEquals(8, kahoot.getPuntajeJugador2().getPuntos());
    }

    @Test
    public void testMultipleChoiceConPenalidadJugador1EligeTresOpcionesCorrectasYUnaIncorrectaYJugador2EligeDosOpcionesCorrectasYDosIncorrectaAsignandolesCorrectamenteLosPuntosConDosMultiplicadoresDeUnJugador() {
        ListaOpciones opcionesCorrectas = opcionCorrectaTierra.con(opcionCorrectaMarte).con(opcionCorrectaJupiter);
        ListaOpciones opcionesIncorrectas = opcionIncorrectaAzulPenalidad.con(opcionIncorrectaAmarilloPenalidad);

        ListaOpciones opcionesJugador1 = opcionCorrectaTierra.con(opcionCorrectaJupiter).con(opcionCorrectaMarte).con(opcionIncorrectaAzulPenalidad);
        ListaOpciones opcionesJugador2 = opcionCorrectaTierra.con(opcionCorrectaMarte).con(opcionIncorrectaAmarilloPenalidad).con(opcionIncorrectaAzulPenalidad);

        RespuestaEnLista respuestasJugador1 = new RespuestaEnLista(opcionesJugador1);
        RespuestaEnLista respuestasJugador2 = new RespuestaEnLista(opcionesJugador2);

        MultipleChoiceConPenalidad preguntaMultipleChoiceConPenalidad = new MultipleChoiceConPenalidad(consignaMultipleChoice, opcionesCorrectas, opcionesIncorrectas);

        Kahoot kahoot = new Kahoot();

        kahoot.setRespuestaJugador(respuestasJugador1, kahoot.getJugador1());
        kahoot.setRespuestaJugador(respuestasJugador2, kahoot.getJugador2());

        kahoot.agregarMultiplicadorX2(preguntaMultipleChoiceConPenalidad, kahoot.getJugador1());
        kahoot.agregarMultiplicadorX3(preguntaMultipleChoiceConPenalidad, kahoot.getJugador1());

        kahoot.evaluarRespuestas(preguntaMultipleChoiceConPenalidad);

        assertEquals(12, kahoot.getPuntajeJugador1().getPuntos());
        assertEquals(0, kahoot.getPuntajeJugador2().getPuntos());
    }
}
