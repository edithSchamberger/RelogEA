package ar.edu.undef.fie.relog_rest_api.interfaces;

import ar.edu.undef.fie.relog_rest_api.application.command_services.SesionCommandService;
import ar.edu.undef.fie.relog_rest_api.application.command_services.UsuarioCommandService;
import ar.edu.undef.fie.relog_rest_api.domain.inicio.Usuario;
import ar.edu.undef.fie.relog_rest_api.interfaces.request.UsuarioRequest;
import ar.edu.undef.fie.relog_rest_api.utils.JWTUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    private final UsuarioCommandService usuarioService;
    private final JWTUtil jwtUtil;
    private final SesionCommandService sesionService;

    public AuthController(UsuarioCommandService usuarioService, JWTUtil jwtUtil, SesionCommandService sesionService) {
        this.usuarioService = usuarioService;
        this.jwtUtil = jwtUtil;
        this.sesionService = sesionService;
    }


    @PostMapping(value = "login")
    public ResponseEntity<String> login(@RequestBody UsuarioRequest usuarioRequest) {

        Usuario usuarioLogueado = usuarioService.obtenerUsuarioPorCredenciales(usuarioRequest.construct());

        if (usuarioLogueado != null) {
            sesionService.nuevaSesion(usuarioLogueado);
            String tokenJwt = jwtUtil.create(String.valueOf(usuarioLogueado.getId()), usuarioLogueado.getEmail());
            return ResponseEntity.ok(tokenJwt);
        }else {
            return new ResponseEntity<>(
                    "Error en la autenticación",
                    HttpStatus.BAD_REQUEST);
        }
    }

}
