package ar.edu.undef.fie.application.command_queries;

import ar.edu.undef.fie.infrastructure.MovimientoRepository;
import org.springframework.stereotype.Service;

@Service
public class FindMovimientoCommandQuery {
    private final MovimientoRepository repository;

    public FindMovimientoCommandQuery(MovimientoRepository repository) {
        this.repository = repository;
    }
    public Long count(){
        return repository.count();
    }
}
