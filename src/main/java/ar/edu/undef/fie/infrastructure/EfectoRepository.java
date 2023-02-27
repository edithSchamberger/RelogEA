package ar.edu.undef.fie.infrastructure;


import ar.edu.undef.fie.domain.clases.Efecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EfectoRepository extends JpaRepository<Efecto, Long> {

    List<Efecto> findAllByClase_ClaseId(Long efectoId);


}
