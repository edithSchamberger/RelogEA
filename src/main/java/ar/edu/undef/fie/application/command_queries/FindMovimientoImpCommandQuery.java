package ar.edu.undef.fie.application.command_queries;

import ar.edu.undef.fie.infrastructure.MovimientoImpRepository;
import ar.edu.undef.fie.domain.estadoAbastecimiento.movimiento.movimiento.MovimientoImp;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FindMovimientoImpCommandQuery {
    private final MovimientoImpRepository repository;

    public FindMovimientoImpCommandQuery(MovimientoImpRepository repository) {
        this.repository = repository;
    }
    public Long count(){
        return repository.count();
    }


    public List<MovimientoImp> findAll() {
        return repository.findAll();
    }

    public Optional<MovimientoImp> findById(Long movimientoImpId) {
        return repository.findById(movimientoImpId);
    }
}
