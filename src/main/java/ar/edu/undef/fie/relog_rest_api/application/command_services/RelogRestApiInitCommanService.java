package ar.edu.undef.fie.relog_rest_api.application.command_services;

import ar.edu.undef.fie.relog_rest_api.application.command_queries.FindClaseCommandQuery;
import ar.edu.undef.fie.relog_rest_api.application.command_queries.FindEfectoCommandQuery;
import ar.edu.undef.fie.relog_rest_api.application.command_queries.FindMovimientoImpCommandQuery;
import ar.edu.undef.fie.relog_rest_api.domain.clases.*;
import ar.edu.undef.fie.relog_rest_api.domain.estadoAbastecimiento.movimiento.movimiento.Egreso;
import ar.edu.undef.fie.relog_rest_api.domain.estadoAbastecimiento.movimiento.movimiento.Ingreso;
import ar.edu.undef.fie.relog_rest_api.domain.estadoAbastecimiento.movimiento.movimiento.MovimientoImp;
import ar.edu.undef.fie.relog_rest_api.infrastructure.ClaseRepositoty;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class RelogRestApiInitCommanService implements CommandLineRunner {
    private final FindClaseCommandQuery findClase;
    private final ClaseCommandService claseCommandService;
    private final FindMovimientoImpCommandQuery findMovimientoCommandQuery;
    private final MovimientoImpCommandService movimientoCommandService;
    private final FindEfectoCommandQuery findEfectoCommandQuery;
    private final EfectoCommandService efectoCommandService;
    private final ClaseRepositoty claseRepositoty;

    public RelogRestApiInitCommanService(FindClaseCommandQuery findClase, ClaseCommandService claseCommandService, FindMovimientoImpCommandQuery findMovimientoCommandQuery, MovimientoImpCommandService movimientoCommandService, FindEfectoCommandQuery findEfectoCommandQuery, EfectoCommandService efectoCommandService,
                                         ClaseRepositoty claseRepositoty) {
        this.findClase = findClase;
        this.claseCommandService = claseCommandService;
        this.findMovimientoCommandQuery = findMovimientoCommandQuery;
        this.movimientoCommandService = movimientoCommandService;
        this.findEfectoCommandQuery = findEfectoCommandQuery;
        this.efectoCommandService = efectoCommandService;
        this.claseRepositoty = claseRepositoty;
    }


    @Override
    public void run(String... args) throws Exception {
        System.out.println("ReLog");
        if(findClase.countClases() == 0){
            var clases = new ArrayList<Clase>();
            clases.add(new ClaseI());
            clases.add(new ClaseII());
            clases.add(new ClaseIII());
            clases.add(new ClaseV());
            claseCommandService.create(clases);
        }
        if(findMovimientoCommandQuery.count() == 0){
            MovimientoImp ingreso = new Ingreso("Ingreso");
            movimientoCommandService.save(ingreso);
            MovimientoImp egreso = new Egreso("Egreso");

            movimientoCommandService.save(egreso);
        }
        /*if(findEfectoCommandQuery.count() == 0){
            var efectos = new ArrayList<Clase>();
            efectos.add(new Efecto("Racion tipo C",findClase.findById(1));
            efectoCommandService.create(efectos);
        }*/
    }
}


/*
@Component
public class DataSeeder implements CommandLineRunner {

    @Autowired
    EstadoRepository estadoRepository;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Creando ReLog!!!");

        this.validateEstadoRepository();
    }

    private void validateEstadoRepository() {
        if(estadoRepository.findAll().isEmpty())
            this.createEstados();
    }


    private void createEstados() {
        estadoRepository.save(EstadoPersistent.builder()
                .id(1L).descripcion("Con Stock").build());

        estadoRepository.save(EstadoPersistent.builder()
                .id(2L).descripcion("Con Faltantes").build());
    }

}*/
