package ar.edu.undef.fie.application.command_services;

import ar.edu.undef.fie.interfaces.request.EstadoAbastecimientoRequest;
import ar.edu.undef.fie.application.command_queries.FindEstadoAbastecimientoCommandQuery;
import ar.edu.undef.fie.domain.estadoAbastecimiento.movimiento.EstadoAbastecimiento;
import ar.edu.undef.fie.infrastructure.EfectoRepository;
import ar.edu.undef.fie.infrastructure.EstadoAbastecimientoRepository;
import ar.edu.undef.fie.infrastructure.OrganizacionRepository;
import org.springframework.stereotype.Service;

@Service
public class EstadoAbastecimientoCommandService {
    private final EstadoAbastecimientoRepository repository;
    private final FindEstadoAbastecimientoCommandQuery  query;
    private final OrganizacionRepository organizacionRepository;
    private final EfectoRepository efectoRepository;

    public EstadoAbastecimientoCommandService(EstadoAbastecimientoRepository repository, FindEstadoAbastecimientoCommandQuery query, OrganizacionRepository organizacionRepository, EfectoRepository efectoRepository) {
        this.repository = repository;
        this.query = query;
        this.organizacionRepository = organizacionRepository;
        this.efectoRepository = efectoRepository;
    }


    public EstadoAbastecimiento save(EstadoAbastecimientoRequest request, Long idOrganizacion, Long efectoId) {
        EstadoAbastecimiento estadoAbastecimiento = new EstadoAbastecimiento(
                efectoRepository.findById(efectoId).orElse(null),
                request.getCantidadNecesaria(),
                request.getCantidadDisponible(),
                organizacionRepository.findById(idOrganizacion).orElse(null)
        );
        return repository.save(estadoAbastecimiento);

    }
    public void eliminar(EstadoAbastecimiento estadoAbastecimiento){
        repository.delete(estadoAbastecimiento);}

    public void modificar(EstadoAbastecimiento estadoAbastecimiento){
        repository.save(estadoAbastecimiento);}




}
