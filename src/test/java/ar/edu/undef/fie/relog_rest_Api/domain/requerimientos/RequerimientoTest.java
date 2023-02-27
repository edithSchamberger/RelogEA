package ar.edu.undef.fie.relog_rest_Api.domain.requerimientos;

import ar.edu.undef.fie.domain.clases.*;
import ar.edu.undef.fie.domain.organizacion.Organizacion;
import ar.edu.undef.fie.domain.requerimiento.Requerimiento;
import ar.edu.undef.fie.domain.requerimiento.Solicitud;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


public class RequerimientoTest {

    @Test
    @DisplayName("Generar Requerimiento")
    void testRequerimiento(){
        // creo efectos Cl I
        var claseI = new ClaseI();
        var efecto1 = new Efecto("Racion tipo C",claseI);

        var claseII = new ClaseII();
        var efecto2 = new Efecto("Pantalon de Combate",claseII);

        var claseIII = new ClaseIII();
        var efecto3 = new Efecto("Gas Oil",claseIII);

        var claseV = new ClaseV();
        var efecto5 = new Efecto("Pistola 9mm",claseV);

        // creo organizacion
        var organizacion =new Organizacion("Nueva Organizacion",1000., 10.5,10.6);


        // creo solicitid de efectos
        var solicitud1 =new Solicitud(100L, efecto1, organizacion);
        assertFalse(solicitud1.getConfirmadaSolicitud());
        assertEquals("Racionamiento",solicitud1.getEfecto().getClase().getDescripcionTipo());
        assertEquals("Racion tipo C", solicitud1.getEfecto().getNombreEfecto());

        var solicitud2 =new Solicitud(100L, efecto2, organizacion);
        assertFalse(solicitud2.getConfirmadaSolicitud());

        var solicitud3 =new Solicitud(100L, efecto3, organizacion);
        assertFalse(solicitud3.getConfirmadaSolicitud());

        var solicitud4 =new Solicitud(100L, efecto5, organizacion);
        assertFalse(solicitud4.getConfirmadaSolicitud());

        var listaSol = new ArrayList<Solicitud>();
        listaSol.add(solicitud1);
        listaSol.add(solicitud2);
        listaSol.add(solicitud3);

        //creo un Requerimiento
        var requerimiento= new Requerimiento(organizacion, LocalDateTime.now(),listaSol);
        assertFalse(requerimiento.getConfirmado());

        //confirmacion de Requerimiento
        requerimiento.setConfirmado(true);
        assertTrue(requerimiento.getConfirmado());
    }
}
