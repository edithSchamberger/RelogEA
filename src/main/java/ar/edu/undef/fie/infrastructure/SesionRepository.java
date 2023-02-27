package ar.edu.undef.fie.infrastructure;


import ar.edu.undef.fie.domain.inicio.Sesion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SesionRepository extends JpaRepository<Sesion,Integer> {
    Sesion findSesionByActiva(Boolean activa);
}
