package ar.edu.undef.fie.interfaces;

import ar.edu.undef.fie.application.command_queries.FindRequerimientoCommandQuery;
import ar.edu.undef.fie.application.command_services.RequerimientoCommandService;
import ar.edu.undef.fie.domain.requerimiento.Requerimiento;
import ar.edu.undef.fie.interfaces.request.RequerimientoRequest;
import ar.edu.undef.fie.interfaces.responses.RequerimientoResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class RequerimientoController {

    private final FindRequerimientoCommandQuery query;
    private final RequerimientoCommandService service;


    public RequerimientoController(FindRequerimientoCommandQuery query, RequerimientoCommandService service) {
        this.query = query;
        this.service = service;
    }


    @GetMapping("/requerimientos")
    public List<RequerimientoResponse> mostrarTordosLosRequerimientos(){
        return query
                .findAll()
                .stream()
                .map(Requerimiento::response)
                .collect(Collectors.toList());
    }

    @PostMapping("/requerimientos")
    public RequerimientoResponse create(@RequestBody RequerimientoRequest request) {
        return service
                .create(request)
                .response();
    }
// autorizaciones de requerimientos
    @PatchMapping("/requerimientos/{idRequerimiento}")
    public ResponseEntity<String> actualizar(@PathVariable Long idRequerimiento) {
        service.update(idRequerimiento);
        return new ResponseEntity<>(
                "Requerimiento autorizado",
                HttpStatus.OK);
    }
// requerimientos por organizacion
    @GetMapping("/organizaciones/{orgazanizacionId}/requerimientos")
    public List<RequerimientoResponse> findAllByOrganizacion(@PathVariable Long orgazanizacionId) {
        return query
                .findByOrganizacion(orgazanizacionId)
                .stream()
                .map(Requerimiento::response)
                .collect(Collectors.toList());
    }


}
