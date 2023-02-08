package ar.edu.undef.fie.relog_rest_api.domain.requerimiento;

import ar.edu.undef.fie.relog_rest_api.domain.clases.Clase;
import ar.edu.undef.fie.relog_rest_api.domain.clases.Efecto;
import ar.edu.undef.fie.relog_rest_api.domain.organizacion.Organizacion;
import ar.edu.undef.fie.relog_rest_api.interfaces.responses.SolicitudResponse;

import javax.persistence.*;
import java.util.Optional;

@Entity
public class Solicitud {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long solicitudId;

    private Long cantidad;
    @OneToOne
    private Efecto efecto;

    @ManyToOne
    private Organizacion organizacion;

    private Boolean confirmadaSolicitud;

    //constructor
    /*
    public Solicitud(Long cantidad, Optional<Efecto> byId) {
    }
     public Solicitud(Long cantidad, Efecto efecto) {
        this.cantidad = cantidad;
        this.efecto = efecto;
    }
*/

//constructor
    public Solicitud(Long cantidad, Efecto efecto, Organizacion organizacion) {
        this.cantidad = cantidad;
        this.efecto = efecto;
        this.organizacion = organizacion;
        this.confirmadaSolicitud = false;
    }

    public Solicitud() {

    }

    public Solicitud(Long cantidad, Optional<Efecto> byId,Optional< Organizacion> orgById) {
    }
    public Optional<Efecto> getEfectoOp() {
        return Optional.ofNullable(efecto);
    }

    public Optional<Organizacion> getOrgOp() {
        return Optional.ofNullable(organizacion);
    }

    public SolicitudResponse response(){
        return new SolicitudResponse(
                solicitudId,
                cantidad,
                efecto.response(),
                organizacion.response(),
                confirmadaSolicitud);
    }

    //getters y setters
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

    public Efecto getEfecto() {
        return efecto;
    }

    public void setEfecto(Efecto efecto) {
        this.efecto = efecto;
    }

    public Organizacion getOrganizacion() {
        return organizacion;
    }

    public void setOrganizacion(Organizacion organizacion) {
        this.organizacion = organizacion;
    }

    public Boolean getConfirmadaSolicitud() {
        return confirmadaSolicitud;
    }

    public void setConfirmadaSolicitud(Boolean confirmadaSolicitud) {
        this.confirmadaSolicitud = confirmadaSolicitud;
    }
}
