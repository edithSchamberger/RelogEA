package ar.edu.undef.fie.interfaces.request;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class RequerimientoRequest {
    private Long orgId;
    private LocalDateTime fechaDeEntregaRequerida;
    private List<Long> idSolicitudes;

    public RequerimientoRequest() {
        this.idSolicitudes = new ArrayList<>();
    }



    public RequerimientoRequest(Long orgId, LocalDateTime fechaDeEntregaRequerida, List<Long> idSolicitudes) {
        this.orgId = orgId;
        this.fechaDeEntregaRequerida = fechaDeEntregaRequerida;
        this.idSolicitudes = idSolicitudes;
    }


    public Long getOrgId() {
        return orgId;
    }

    public LocalDateTime getFechaDeEntregaRequerida() {
        return fechaDeEntregaRequerida;
    }


    public List<Long> getIdSolicitudes() {
        return idSolicitudes;
    }
}
