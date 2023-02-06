package ar.edu.undef.fie.relog_rest_api.interfaces;

import ar.edu.undef.fie.relog_rest_api.application.command_queries.FindOrganizacionCommandQuery;
import ar.edu.undef.fie.relog_rest_api.application.command_queries.FindSolicitudCommandQuery;
import ar.edu.undef.fie.relog_rest_api.application.command_services.SolicitudCommandService;
import ar.edu.undef.fie.relog_rest_api.domain.clases.Clase;
import ar.edu.undef.fie.relog_rest_api.domain.clases.Efecto;
import ar.edu.undef.fie.relog_rest_api.domain.organizacion.Organizacion;
import ar.edu.undef.fie.relog_rest_api.domain.requerimiento.Solicitud;
import ar.edu.undef.fie.relog_rest_api.exception.NotFoundException;
import ar.edu.undef.fie.relog_rest_api.interfaces.request.SolicitudRequest;
import ar.edu.undef.fie.relog_rest_api.interfaces.responses.SolicitudResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class solicitudController {
    private final FindSolicitudCommandQuery query;

    private final SolicitudCommandService service;
    private final FindOrganizacionCommandQuery orgQuery;

    public solicitudController(FindSolicitudCommandQuery query, SolicitudCommandService service, FindOrganizacionCommandQuery orgQuery) {
        this.query = query;
        this.service = service;
        this.orgQuery = orgQuery;
    }



    @GetMapping("/solicitudes")
    public List<SolicitudResponse> todosLasSolicitudes(){
        return query
                .findAll()
                .stream()
                .map(Solicitud::response)
                .collect(Collectors.toList());
    }



    @PostMapping("/solicitudes")
    public SolicitudResponse create(@RequestBody SolicitudRequest request){
        return service
                .create(request)
                .response();
    }
    @DeleteMapping(value = "solicitudes/{id}")
    public ResponseEntity<String> eliminarSolicitud(@PathVariable Long id) throws NotFoundException {
        service.eliminar(service.findById(id));

        return new ResponseEntity<>(
                "Solicitud eliminada con éxito",
                HttpStatus.OK);

    }
}
