package edu.fiuba.algo3.modelo.opciones;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class OpcionTest {
    @Test
    public void testCreoDosRespuestasIguales(){
        Opcion opcion1 = new Opcion("unaRespuesta");
        Opcion opcion2 = new Opcion("unaRespuesta");

        assert(opcion1.esIgualA(opcion2));
    }

    @Test
    public void testCreoDosRespuestasDistintas(){
        Opcion opcion1 = new Opcion("unaRespuesta");
        Opcion opcion2 = new Opcion("diferenteRespuesta");

        assert(!opcion1.esIgualA(opcion2));
    }

    @Test
    public void testComparacionExitosaSiLaOpcionTieneElMismoRotulo(){
        String rotulo = "unaOpcion";
        Opcion opcion1 = new Opcion(rotulo);

        assert(opcion1.tieneLaMisma(rotulo) );
    }

    @Test
    public void testComparacionNoTieneElMismoRotulo(){
        String rotulo = "unaOpcion";
        String otroRotulo = "otraOpcion";
        Opcion opcion1 = new Opcion(rotulo);

        assert(!opcion1.tieneLaMisma(otroRotulo) );
    }

}
