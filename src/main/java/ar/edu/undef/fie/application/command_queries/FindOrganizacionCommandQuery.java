package ar.edu.undef.fie.application.command_queries;

import ar.edu.undef.fie.domain.organizacion.Organizacion;
import ar.edu.undef.fie.infrastructure.OrganizacionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class FindOrganizacionCommandQuery {
    private final OrganizacionRepository repository;

    public FindOrganizacionCommandQuery(OrganizacionRepository repository) {
        this.repository = repository;
    }

    public List<Organizacion> findAll(){
        return repository.findAll();
    }

   public Organizacion findById(Long id) {
        return repository
                .findById(id)
                .orElseThrow(()->new RuntimeException("No se encontro la organizacion con id" + id));

    }


    public Optional<Organizacion> findByIdDos(Long id) {
        return repository.findById(id);

    }


}
