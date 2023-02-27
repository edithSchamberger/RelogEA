package ar.edu.undef.fie.domain.estadoAbastecimiento.movimiento.movimiento;

import ar.edu.undef.fie.domain.estadoAbastecimiento.movimiento.EstadoAbastecimiento;

import javax.persistence.Entity;

@Entity
public  class Ingreso extends MovimientoImp {
    public Ingreso(String descripcion) {
        super(descripcion);
    }

    public Ingreso() {
    }



    @Override
    public void ejecutar(EstadoAbastecimiento estadoAbastecimiento, Long cantidad) {
        estadoAbastecimiento.setCantidadDisponible(estadoAbastecimiento.getCantidadDisponible()+cantidad);

    }
    public String getTipo(){
        return "Ingreso";
    }

}
