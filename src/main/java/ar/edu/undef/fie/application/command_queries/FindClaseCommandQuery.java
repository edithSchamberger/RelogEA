package ar.edu.undef.fie.application.command_queries;

import ar.edu.undef.fie.domain.clases.Clase;
import ar.edu.undef.fie.infrastructure.ClaseRepositoty;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class FindClaseCommandQuery {
    private final ClaseRepositoty claseRepositoty;
    public FindClaseCommandQuery(ClaseRepositoty claseRepositoty) {
        this.claseRepositoty = claseRepositoty;
    }

    public Long countClases() {
        return claseRepositoty.count();
    }
    public List<Clase> findAll() {
        return claseRepositoty.findAll();
    }

    public Optional<Clase> findById(Long claseId) {
        return claseRepositoty.findById(claseId);
    }

}


