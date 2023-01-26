package ar.edu.undef.fie.relog_rest_api.infrastructure;


import ar.edu.undef.fie.relog_rest_api.domain.inicio.Sesion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SesionRepository extends JpaRepository<Sesion,Integer> {
    Sesion findSesionByActiva(Boolean activa);
}
