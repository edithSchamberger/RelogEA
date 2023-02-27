package ar.edu.undef.fie.application.command_services;


import ar.edu.undef.fie.domain.inicio.Usuario;
import ar.edu.undef.fie.infrastructure.UsuarioRepository;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.stereotype.Service;

@Service
public class UsuarioCommandService {
    private UsuarioRepository usuarioRepository;

    public UsuarioCommandService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario getUsuario(String email) {
        return usuarioRepository.findByEmail(email);
    }

    public Usuario getUser(String rol) {
        return usuarioRepository.findByRol(rol);
    }

    public void eliminar(Long id) {
        usuarioRepository.deleteById(id);
    }


    public Usuario registrar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }


    public Usuario obtenerUsuarioPorCredenciales(Usuario usuario) {

        Usuario userEncontrado = usuarioRepository.findByEmail(usuario.getEmail());
        if (userEncontrado== null) {
            return null;
        }

        String passwordHashed = userEncontrado.getPassword();

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        if (argon2.verify(passwordHashed, usuario.getPassword())) {
            return userEncontrado;
        }
        return null;
    }
}

