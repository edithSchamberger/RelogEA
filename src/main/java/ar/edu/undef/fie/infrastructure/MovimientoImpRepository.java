package ar.edu.undef.fie.infrastructure;

import ar.edu.undef.fie.domain.estadoAbastecimiento.movimiento.movimiento.MovimientoImp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovimientoImpRepository extends JpaRepository<MovimientoImp, Long> {
}

