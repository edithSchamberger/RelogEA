package ar.edu.undef.fie.domain.clases;

import javax.persistence.Entity;

@Entity
public class ClaseII extends Clase {

    public ClaseII() {
        super("CLII", "Vestuario y Equipo", "unidad");
    }


    @Override
    public String getTipo() {
        return "Clase II";
    }

}
