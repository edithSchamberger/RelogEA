package ar.edu.undef.fie.relog_rest_Api.domain.efectos;

import ar.edu.undef.fie.relog_rest_api.domain.clases.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EfectosTest {

    @Test
    @DisplayName("Tipos de Efectos")
    void testTiposEfectos(){
        // efectos Cl I
        var claseI = new ClaseI();
        assertEquals("CLI", claseI.getAbreviatura());
        var efecto = new Efecto("Racion tipo C",claseI);
        assertEquals("Racionamiento",efecto.getClase().getDescripcionTipo());
        assertEquals("Racion tipo C", efecto.getNombreEfecto());

        // efectos Cl II
        var claseII = new ClaseII();
        assertEquals("CLII", claseII.getAbreviatura());
        var efecto2 = new Efecto("Pantalon de Combate",claseII);
        assertEquals("Vestuario y Equipo",efecto2.getClase().getDescripcionTipo());
        assertEquals("Pantalon de Combate", efecto2.getNombreEfecto());

        // efectos Cl III
        var claseIII = new ClaseIII();
        assertEquals("CLIII", claseIII.getAbreviatura());
        var efecto3 = new Efecto("Gas Oil",claseIII);
        assertEquals("Combustible y Lubricantes",efecto3.getClase().getDescripcionTipo());
        assertEquals("Gas Oil", efecto3.getNombreEfecto());

        // efectos Cl V
        var claseV = new ClaseV();
        assertEquals("CLV", claseV.getAbreviatura());
        var efecto5 = new Efecto("Pistola 9mm",claseV);
        assertEquals("Municion",efecto5.getClase().getDescripcionTipo());
        assertEquals("Pistola 9mm", efecto5.getNombreEfecto());

    }
}
