package ar.edu.undef.fie.domain.clases;

import javax.persistence.Entity;

@Entity
public class ClaseI extends Clase {
    public ClaseI() {
        super("CLI", "Racionamiento", "unidad");
    }



    @Override
    public String getTipo() {
        return "Clase I";
    }

}
