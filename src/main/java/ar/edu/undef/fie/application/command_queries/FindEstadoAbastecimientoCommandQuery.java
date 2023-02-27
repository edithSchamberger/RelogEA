package ar.edu.undef.fie.application.command_queries;

import ar.edu.undef.fie.domain.estadoAbastecimiento.movimiento.EstadoAbastecimiento;
import ar.edu.undef.fie.infrastructure.EstadoAbastecimientoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FindEstadoAbastecimientoCommandQuery {
    private final EstadoAbastecimientoRepository repository;

    public FindEstadoAbastecimientoCommandQuery(EstadoAbastecimientoRepository repository) {
        this.repository = repository;
    }


    public List<EstadoAbastecimiento> findAll() {
        return repository.findAll();
    }


    public EstadoAbastecimiento findById(Long id) {
        return repository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Estado Abastecimiento no encontrada"));
    }

}
