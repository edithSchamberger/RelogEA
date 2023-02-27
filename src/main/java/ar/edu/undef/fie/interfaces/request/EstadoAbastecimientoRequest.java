package ar.edu.undef.fie.interfaces.request;

public class EstadoAbastecimientoRequest {
    private Long cantidadNecesaria;
    private Long cantidadDisponible;


    public EstadoAbastecimientoRequest() {
    }

    public EstadoAbastecimientoRequest(Long cantidadNecesaria, Long cantidadDisponible, Long idOrg){
        this.cantidadNecesaria = cantidadNecesaria;
        this.cantidadDisponible = cantidadDisponible;
    }

    public Long getCantidadNecesaria() {
        return cantidadNecesaria;
    }

    public void setCantidadNecesaria(Long cantidadNecesaria) {
        this.cantidadNecesaria = cantidadNecesaria;
    }

    public Long getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(Long cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }


}
