package py.com.aquipago.pronetbackend.data.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ExpedienteDTO {

    private Integer nroExpediente;
    private Integer indEjefisexp;
    private Integer nroCarpeta;
    private Integer indEjefiscar;
    private String desExpediente;
    private Integer nroTitular;
    private Date fecUltmov;
    private String codDepen;
    private String desDepen;
}
