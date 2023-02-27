package ar.edu.undef.fie.interfaces;

import ar.edu.undef.fie.application.command_services.UsuarioCommandService;
import ar.edu.undef.fie.domain.inicio.Usuario;
import ar.edu.undef.fie.exception.NotFoundException;
import ar.edu.undef.fie.interfaces.request.UsuarioRequest;
import ar.edu.undef.fie.interfaces.responses.UsuarioResponse;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UsuarioController {
    public UsuarioCommandService service;

    public UsuarioController(UsuarioCommandService service) {
        this.service = service;
    }
    @GetMapping(value = "usuarios/{email}")
    public ResponseEntity<UsuarioResponse> getUsuarioController(@PathVariable String email) {
        return ResponseEntity.ok(service.getUsuario(email).representation());
    }

    @PostMapping(value = "usuarios")
    public ResponseEntity<UsuarioResponse> registrarUsuario(@RequestBody UsuarioRequest usuarioRequest) {

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon2.hash(1, 1024, 1, usuarioRequest.getPassword());
        usuarioRequest.setPassword(hash);

        Usuario usuario = usuarioRequest.construct();

        return ResponseEntity.ok(service.registrar(usuario).representation());
    }


    @DeleteMapping(value = "usuarios/{idUser}")
    public  ResponseEntity<String> eliminarUsuario(@PathVariable Long idUser) throws NotFoundException {
        service.eliminar(idUser);
        return new ResponseEntity<>(
                "Usuario eliminado con éxito",
                HttpStatus.OK);
    }
}
