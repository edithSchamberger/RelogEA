package ar.edu.undef.fie.application.command_queries;

import ar.edu.undef.fie.domain.requerimiento.Requerimiento;
import ar.edu.undef.fie.infrastructure.RequerimientoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class FindRequerimientoCommandQuery {

    private final RequerimientoRepository repository;


    public FindRequerimientoCommandQuery(RequerimientoRepository repository) {
        this.repository = repository;
    }

    public List<Requerimiento> findAll(){
        return repository.findAll();
    }
    public Requerimiento findById(Long id) {
        return repository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Requerimiento no encontrado"));
    }

    public List<Requerimiento>findByOrganizacion(Long organizacionId) {
        return repository.findAllByOrganizacion_OrganizacionId(organizacionId);
    }
}
