package ar.edu.undef.fie.relog_rest_Api.domain.usuario;


import ar.edu.undef.fie.domain.inicio.Usuario;
import ar.edu.undef.fie.utils.JWTUtil;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UsuarioTest {
    @Test
    @DisplayName("Test de encriptado y comparacion de contraeñas")
    void testEncriptadoyContraseñas(){
        var usuario = new Usuario(null,null,"usuario@mail.com",null,"Administrador");
        usuario.setId(24L);
        var passwordLimpia = "Test123";
        var jwtUtil = new JWTUtil();
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        usuario.setPassword(argon2.hash(1, 1024, 1, passwordLimpia));

        assertTrue(argon2.verify(usuario.getPassword(), passwordLimpia));
        assertFalse(argon2.verify(usuario.getPassword(),"12345"));
    }

}
