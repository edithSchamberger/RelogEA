package ar.edu.undef.fie.interfaces;

import ar.edu.undef.fie.exception.NotFoundException;
import ar.edu.undef.fie.interfaces.request.SolicitudRequest;
import ar.edu.undef.fie.application.command_queries.FindOrganizacionCommandQuery;
import ar.edu.undef.fie.application.command_queries.FindSolicitudCommandQuery;
import ar.edu.undef.fie.application.command_services.SolicitudCommandService;
import ar.edu.undef.fie.domain.requerimiento.Solicitud;
import ar.edu.undef.fie.interfaces.responses.SolicitudResponse;
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

    @DeleteMapping(value = "/solicitudes/{id}")
    public ResponseEntity<String> eliminarSolicitud(@PathVariable Long id) throws NotFoundException {
        service.eliminar(service.findById(id));

        return new ResponseEntity<>(
                "Persona eliminada con éxito",
                HttpStatus.OK);

    }

    //solicitudes s/organizaciones
    @GetMapping("/organizaciones/{orgazanizacionId}/solicitudes")
    public List<SolicitudResponse> findAllByOrganizacion(@PathVariable Long orgazanizacionId) {
        return query
                .findByOrganizacion(orgazanizacionId)
                .stream()
                .map(Solicitud::response)
                .collect(Collectors.toList());
    }

    //solicitudes s/requerimiento
   /* @GetMapping("/requerimiento/{requerimientoId}/solicitudes")
    public List<SolicitudResponse> findAllByRequerimiento(@PathVariable Long requerimientoId) {
        return query
                .findByRequerimiento(requerimientoId)
                .stream()
                .map(Solicitud::response)
                .collect(Collectors.toList());
    }*/



}
