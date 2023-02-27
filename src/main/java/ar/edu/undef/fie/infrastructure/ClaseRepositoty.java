package ar.edu.undef.fie.infrastructure;

import ar.edu.undef.fie.domain.clases.Clase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClaseRepositoty extends JpaRepository<Clase, Long> {

}
