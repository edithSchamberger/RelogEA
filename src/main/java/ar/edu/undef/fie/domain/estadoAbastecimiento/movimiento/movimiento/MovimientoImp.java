package ar.edu.undef.fie.domain.estadoAbastecimiento.movimiento.movimiento;

import ar.edu.undef.fie.domain.estadoAbastecimiento.movimiento.EstadoAbastecimiento;
import ar.edu.undef.fie.interfaces.responses.MovimientoImpResponse;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public abstract class MovimientoImp {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long movimientoId;
    private String descripcion;

    public abstract  void ejecutar(EstadoAbastecimiento estadoAbastecimiento, Long cantidad);
    public abstract String getTipo();


    //constructores
    public MovimientoImp( String descripcion) {
        this.descripcion = descripcion;
    }

    public MovimientoImp() {
    }

    public MovimientoImpResponse response(){
        return new MovimientoImpResponse(movimientoId, descripcion);
    }


    //getters y setters
    public Long getMovimientoId() {
        return movimientoId;
    }

    public void setMovimientoId(Long movimientoId) {
        this.movimientoId = movimientoId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
