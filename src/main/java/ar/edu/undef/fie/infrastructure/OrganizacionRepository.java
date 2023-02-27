package ar.edu.undef.fie.infrastructure;

import ar.edu.undef.fie.domain.organizacion.Organizacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizacionRepository extends JpaRepository<Organizacion, Long> {
    Organizacion findByNombre(String nombre);

}

