package ar.edu.undef.fie.application.command_services;

import ar.edu.undef.fie.application.command_queries.FindClaseCommandQuery;
import ar.edu.undef.fie.domain.clases.Efecto;
import ar.edu.undef.fie.infrastructure.EfectoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EfectoCommandService {
    private final EfectoRepository efectoRepositoty;
    private final FindClaseCommandQuery clase;

    public EfectoCommandService(EfectoRepository efectoRepositoty, FindClaseCommandQuery clase) {
        this.efectoRepositoty = efectoRepositoty;
        this.clase = clase;
    }

    public Efecto create(Efecto efecto){
     return efectoRepositoty.save(efecto);
    }

    public List<Efecto> create(List<Efecto> efectos) {
        return efectoRepositoty.saveAll(efectos);
    }



    public Efecto update(Long efectoId, Long claseId) {
        var efecto = efectoRepositoty.findById(efectoId)
                .orElseThrow(() -> new RuntimeException("Efecto no encontrado"));

        var clase = this.clase
                .findById(claseId)
                .orElseThrow(() -> new RuntimeException("Criticidad no encontrada"));

        efecto.setClase(clase);

        return efectoRepositoty.save(efecto);
    }

    public void deleteAll(List<Efecto> efectos) {
        efectoRepositoty.deleteAll(efectos);
    }
}
