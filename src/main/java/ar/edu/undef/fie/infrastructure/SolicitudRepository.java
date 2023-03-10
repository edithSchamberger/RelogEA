package ar.edu.undef.fie.infrastructure;

import ar.edu.undef.fie.domain.requerimiento.Solicitud;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SolicitudRepository extends JpaRepository<Solicitud, Long> {
    public List<Solicitud> findAllBySolicitudIdIn(List<Long> ids);

    List<Solicitud> findAllBySolicitudId(Long id);

    List<Solicitud> findAllByOrganizacion_OrganizacionId(Long organizacionId);

   /* List<Solicitud> findAllByRequerimiento_RequerimientoId(Long requerimientoId);*/
}

