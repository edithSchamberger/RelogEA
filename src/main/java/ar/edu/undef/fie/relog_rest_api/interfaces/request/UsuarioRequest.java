package ar.edu.undef.fie.relog_rest_api.interfaces.request;


import ar.edu.undef.fie.relog_rest_api.domain.inicio.Usuario;

public class UsuarioRequest {
    private Long id;
    private String nombre;
    private String apellido;
    private String email;

    private String password;
    private String rol;

    public UsuarioRequest(String nombre, String apellido, String email, String password,String rol) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
        this.rol=rol;
    }
    public Usuario construct(){
        Usuario usuario = new Usuario(nombre,apellido,email, password,rol);
        return usuario;
    }



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}

