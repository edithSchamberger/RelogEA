package ar.edu.undef.fie.domain.clases;

import javax.persistence.Entity;

@Entity
public class ClaseIII extends Clase {


    public ClaseIII() {
        super("CLIII", "Combustible y Lubricantes", "lts/kg");
    }

    @Override
    public String getTipo() {
        return "Clase III";
    }
}