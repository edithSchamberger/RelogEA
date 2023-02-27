package ar.edu.undef.fie.infrastructure;

import ar.edu.undef.fie.domain.requerimiento.Requerimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequerimientoRepository extends JpaRepository<Requerimiento, Long> {

    List<Requerimiento> findAllByOrganizacion_OrganizacionId(Long organizacionId);
}
