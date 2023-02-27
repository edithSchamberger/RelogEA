package ar.edu.undef.fie.infrastructure;

import ar.edu.undef.fie.domain.inicio.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByEmail (String email);
    Usuario findByRol (String rol);

}
