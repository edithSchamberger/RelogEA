package ar.edu.undef.fie.application.command_services;

import ar.edu.undef.fie.domain.estadoAbastecimiento.movimiento.movimiento.MovimientoImp;
import ar.edu.undef.fie.infrastructure.MovimientoImpRepository;
import org.springframework.stereotype.Service;

@Service
public class MovimientoImpCommandService {
    private final MovimientoImpRepository repository;

    public MovimientoImpCommandService(MovimientoImpRepository repository) {
        this.repository = repository;
    }
    public MovimientoImp save(MovimientoImp movimientoImp){
        return repository.save(movimientoImp);
    }
}
