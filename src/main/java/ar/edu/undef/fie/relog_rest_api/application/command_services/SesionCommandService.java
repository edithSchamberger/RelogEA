package ar.edu.undef.fie.relog_rest_api.application.command_services;

import ar.edu.undef.fie.relog_rest_api.domain.inicio.Sesion;
import ar.edu.undef.fie.relog_rest_api.domain.inicio.Usuario;
import ar.edu.undef.fie.relog_rest_api.infrastructure.SesionRepository;
import org.springframework.stereotype.Service;

import java.util.Calendar;
@Service
public class SesionCommandService {
    private final SesionRepository sesionRepository;

    public SesionCommandService(SesionRepository sesionRepository) {
        this.sesionRepository = sesionRepository;
    }


    public Sesion getSesionActiva() {
        return sesionRepository.findSesionByActiva(true);
    }


    public void nuevaSesion(Usuario usuario) {
        cerrarSesion();
        Sesion sesionNueva = new Sesion();
        sesionNueva.setUsuario(usuario);
        sesionNueva.setInicioSesion(Calendar.getInstance());
        sesionNueva.setActiva(true);
        sesionRepository.save(sesionNueva);
    }


    public void cerrarSesion() {
        Sesion sesionActiva = getSesionActiva();
        if (sesionActiva != null){
            sesionActiva.setActiva(false);
            sesionActiva.setFinSesion(Calendar.getInstance());
            sesionRepository.save(sesionActiva);
        }

    }

}
