package ar.edu.undef.fie.interfaces.responses;

public class MovimientoResponse {
    private Long movimientoId;
    private Long cantidad;
    private MovimientoImpResponse movimientoImpResponse;

    public MovimientoResponse(Long movimientoId, Long cantidad, MovimientoImpResponse movimientoImpResponse) {
        this.movimientoId = movimientoId;
        this.cantidad = cantidad;
        this.movimientoImpResponse = movimientoImpResponse;
    }

    public Long getMovimientoId() {
        return movimientoId;
    }

    public Long getCantidad() {
        return cantidad;
    }

    public MovimientoImpResponse getMovimientoImpResponse() {
        return movimientoImpResponse;
    }
}
