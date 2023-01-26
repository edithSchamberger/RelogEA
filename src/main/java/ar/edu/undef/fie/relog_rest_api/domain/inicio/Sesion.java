package ar.edu.undef.fie.relog_rest_api.domain.inicio;

import javax.persistence.*;
import java.util.Calendar;

@Entity
public class Sesion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "sesion_id")
    private Usuario usuario;
    private boolean activa;
    private Calendar inicioSesion;
    private Calendar finSesion;

    public Sesion(Usuario usuario, boolean activa, Calendar inicioSesion, Calendar finSesion) {
        this.usuario = usuario;
        this.activa = activa;
        this.inicioSesion = inicioSesion;
        this.finSesion = finSesion;
    }

    public Sesion() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public boolean isActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }

    public Calendar getInicioSesion() {
        return inicioSesion;
    }

    public void setInicioSesion(Calendar inicioSesion) {
        this.inicioSesion = inicioSesion;
    }

    public Calendar getFinSesion() {
        return finSesion;
    }

    public void setFinSesion(Calendar finSesion) {
        this.finSesion = finSesion;
    }
}
