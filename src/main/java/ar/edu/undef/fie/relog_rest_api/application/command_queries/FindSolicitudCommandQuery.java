package ar.edu.undef.fie.relog_rest_api.application.command_queries;

import ar.edu.undef.fie.relog_rest_api.domain.clases.Efecto;
import ar.edu.undef.fie.relog_rest_api.domain.requerimiento.Solicitud;
import ar.edu.undef.fie.relog_rest_api.infrastructure.SolicitudRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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
