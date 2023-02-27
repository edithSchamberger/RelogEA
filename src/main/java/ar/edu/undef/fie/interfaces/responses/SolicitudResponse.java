package ar.edu.undef.fie.interfaces.responses;

public class SolicitudResponse {
    private Long solicitudId;
    private Long cantidad;

    //private Long requerimientoId;
    private EfectoResponse efecto;
    private OrganizacionResponse organizacion;
    private Boolean confirmadaSolicitud;

    public SolicitudResponse(Long solicitudId, Long cantidad, EfectoResponse efecto, OrganizacionResponse organizacion, Boolean confirmadaSolicitud) {
        this.solicitudId = solicitudId;
        this.cantidad = cantidad;
        this.efecto = efecto;
        this.organizacion = organizacion;
        this.confirmadaSolicitud = confirmadaSolicitud;
    }


    public Long getSolicitudId() {
        return solicitudId;
    }

    public void setSolicitudId(Long solicitudId) {
        this.solicitudId = solicitudId;
    }

    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }

    public EfectoResponse getEfecto() {
        return efecto;
    }

    public void setEfecto(EfectoResponse efecto) {
        this.efecto = efecto;
    }

    public OrganizacionResponse getOrganizacion() {
        return organizacion;
    }

    public void setOrganizacion(OrganizacionResponse organizacion) {
        this.organizacion = organizacion;
    }

    public Boolean getConfirmadaSolicitud() {
        return confirmadaSolicitud;
    }

    public void setConfirmadaSolicitud(Boolean confirmadaSolicitud) {
        this.confirmadaSolicitud = confirmadaSolicitud;
    }

    public SolicitudResponse response() {
        return new SolicitudResponse(
                solicitudId,
                cantidad,
                efecto,
                organizacion,
                confirmadaSolicitud);
    }

}

