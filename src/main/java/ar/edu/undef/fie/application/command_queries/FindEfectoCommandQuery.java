package ar.edu.undef.fie.application.command_queries;



import ar.edu.undef.fie.domain.clases.Efecto;
import ar.edu.undef.fie.infrastructure.EfectoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindEfectoCommandQuery {
    private final EfectoRepository repository;

    public FindEfectoCommandQuery(EfectoRepository repository) {
        this.repository = repository;
    }


    public List<Efecto> findAll(){
        return repository.findAll();
    }

    public List<Efecto> findByClase(Long claseId) {
        return repository.findAllByClase_ClaseId(claseId);
    }

    public Efecto findById(Long id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("No se encontró la efecto con id: " + id));
    }


    public Long count() {
        return repository.count();
    }
}
