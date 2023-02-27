package ar.edu.undef.fie.application.command_services;

import ar.edu.undef.fie.application.command_queries.FindOrganizacionCommandQuery;
import ar.edu.undef.fie.exception.NotFoundException;
import ar.edu.undef.fie.interfaces.request.SolicitudRequest;
import ar.edu.undef.fie.application.command_queries.FindEfectoCommandQuery;
import ar.edu.undef.fie.domain.requerimiento.Solicitud;
import ar.edu.undef.fie.infrastructure.ClaseRepositoty;
import ar.edu.undef.fie.infrastructure.SolicitudRepository;
import org.springframework.stereotype.Service;

@Service
public class SolicitudCommandService {
    private final SolicitudRepository repositoty;
    private final FindEfectoCommandQuery efectoQuery;
    private final FindOrganizacionCommandQuery orgQuery;
    private final ClaseRepositoty claseRepositoty;

    public SolicitudCommandService(SolicitudRepository repositoty, FindEfectoCommandQuery efectoQuery, FindOrganizacionCommandQuery orgQuery, ClaseRepositoty claseRepositoty) {
        this.repositoty = repositoty;
        this.efectoQuery = efectoQuery;
        this.orgQuery = orgQuery;
        this.claseRepositoty = claseRepositoty;
    }


    public Solicitud create(SolicitudRequest request) {
        var nuevaSolicitud = new Solicitud(request.getCantidad(),efectoQuery.findById(request.getEfectoId()),orgQuery.findById(request.getOrganizacionId()));
        return repositoty.save(nuevaSolicitud);
    }

    public void eliminar(Solicitud solicitud){repositoty.delete(solicitud);}

    public Solicitud findById(Long id) {
        return repositoty
                .findById(id)
                .orElseThrow(() -> new NotFoundException("No se encontró la solicitud"));
    }
}


