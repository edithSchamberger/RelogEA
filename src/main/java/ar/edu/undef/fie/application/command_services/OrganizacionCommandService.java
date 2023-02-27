package ar.edu.undef.fie.application.command_services;

import ar.edu.undef.fie.application.command_queries.FindOrganizacionCommandQuery;
import ar.edu.undef.fie.interfaces.request.OrganizacionRequest;
import ar.edu.undef.fie.domain.organizacion.Organizacion;
import ar.edu.undef.fie.infrastructure.EfectoRepository;
import ar.edu.undef.fie.infrastructure.EstadoAbastecimientoRepository;
import ar.edu.undef.fie.infrastructure.OrganizacionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class OrganizacionCommandService {
    private final OrganizacionRepository repository;
    private final FindOrganizacionCommandQuery query;

    private final EfectoRepository efectoRepository;
    private final EstadoAbastecimientoRepository estadoAbastecimientoRepository;


    public OrganizacionCommandService(OrganizacionRepository repository, FindOrganizacionCommandQuery query, EfectoRepository efectoRepository, EstadoAbastecimientoRepository estadoAbastecimientoRepository) {
        this.repository = repository;
        this.query = query;
        this.efectoRepository = efectoRepository;
        this.estadoAbastecimientoRepository = estadoAbastecimientoRepository;
    }

    public Organizacion create(OrganizacionRequest request) {

        var nuevaOrganizacion = new Organizacion(request.getNombre(), request.getEfectivoOrganico(), request.getLatitud(), request.getLongitud());
        return repository.save(nuevaOrganizacion);
    }

    public List<Organizacion> findAll() {
        return repository.findAll();
    }

    public Optional<Organizacion> findById(long id) {
        return repository.findById(id);
    }

    public void delete(Organizacion organizacion){
        repository.delete(organizacion);}





}
