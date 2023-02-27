package ar.edu.undef.fie.domain.estadoAbastecimiento.movimiento.movimiento;

import ar.edu.undef.fie.domain.estadoAbastecimiento.movimiento.EstadoAbastecimiento;
import ar.edu.undef.fie.interfaces.responses.MovimientoResponse;

import javax.persistence.*;
import java.util.Optional;

@Entity
public class Movimiento {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long movimientoId;
    private Long cantidad;

    @OneToOne
    private MovimientoImp movimientoImp;

    //constructor

    public Movimiento() {
    }


    public Movimiento(Long cantidad, MovimientoImp movimientoImp) {
        this.cantidad = cantidad;
        this.movimientoImp = movimientoImp;
    }
    public MovimientoResponse response(){
        return new MovimientoResponse(movimientoId,
                cantidad,
                getMovimientoImpOp().map(MovimientoImp::response).orElse(null));
    }

    public void ejecutar(EstadoAbastecimiento estadoAbastecimiento)
    {
        this.movimientoImp.ejecutar(estadoAbastecimiento, this.cantidad);
    }

    //getters y setters
    public Long getMovimientoId() {
        return movimientoId;
    }

    public void setMovimientoId(Long movimientoId) {
        this.movimientoId = movimientoId;
    }

    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }

    public MovimientoImp getMovimientoImp() {
        return movimientoImp;
    }

    public void setMovimientoImp(MovimientoImp movimientoImp) {
        this.movimientoImp = movimientoImp;
    }

    public Optional<MovimientoImp> getMovimientoImpOp() {
        return Optional.ofNullable(movimientoImp);
    }
}
