package ar.edu.undef.fie.application.command_queries;

import ar.edu.undef.fie.domain.requerimiento.Solicitud;
import ar.edu.undef.fie.infrastructure.SolicitudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class FindSolicitudCommandQuery {

    private final SolicitudRepository repository;

    public FindSolicitudCommandQuery(SolicitudRepository repository) {
        this.repository = repository;
    }

    public List<Solicitud> findAll(){
        return repository.findAll();
    }

    public Solicitud findById(Long solicitudId) {
        return repository
                .findById(solicitudId)
                .orElseThrow(() -> new RuntimeException("Solicitud no encontrada"));
    }


    public List<Solicitud> findallById(Long id) {
        return repository.findAllBySolicitudId(id);

    }

    public List<Solicitud> findByOrganizacion(Long organizacionId) {
        return repository.findAllByOrganizacion_OrganizacionId(organizacionId);
    }

/*
    public List<Solicitud> findByRequerimiento(Long requerimientoId) {
        return repository.findAllByRequerimiento_RequerimientoId(requerimientoId);
    }
*/
}
