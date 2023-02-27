package ar.edu.undef.fie.interfaces.request;

public class SolicitudRequest {
    private Long solid;

    private Long cantidad;
    private Long efectoId;
    private Long organizacionId;
    private Boolean confirmadaSolicitud;

    public Long getCantidad() {
        return cantidad;
    }

    public Long getEfectoId() {
        return efectoId;
    }

    public Long getOrganizacionId() {
        return organizacionId;
    }


    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }

    public void setEfectoId(Long efectoId) {
        this.efectoId = efectoId;
    }
    public void setOrganizacionId(Long organizacionId) {
        this.organizacionId = organizacionId;
    }

    public Long getSolid() {
        return solid;
    }

    public void setSolid(Long solid) {
        this.solid = solid;
    }

    public Boolean getConfirmadaSolicitud() {
        return confirmadaSolicitud;
    }

    public void setConfirmadaSolicitud(Boolean confirmadaSolicitud) {
        this.confirmadaSolicitud = confirmadaSolicitud;
    }
}
