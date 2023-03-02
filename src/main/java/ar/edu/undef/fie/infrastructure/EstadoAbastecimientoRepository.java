package ar.edu.undef.fie.infrastructure;

import ar.edu.undef.fie.domain.organizacion.Organizacion;
import ar.edu.undef.fie.domain.estadoAbastecimiento.movimiento.EstadoAbastecimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EstadoAbastecimientoRepository extends JpaRepository<EstadoAbastecimiento, Long> {
    List<EstadoAbastecimiento> findByOrganizacion(Optional<Organizacion> org);

    List<EstadoAbastecimiento> findAllByOrganizacion_OrganizacionId(Long organizacionId);
}
