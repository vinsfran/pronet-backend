package py.com.aquipago.pronetbackend.data.dto;

import lombok.Data;
import lombok.extern.apachecommons.CommonsLog;

import java.util.Date;

@Data
@CommonsLog
public class SemexpedienteDTO {

    private Integer nroExpediente;
    private Integer indEjefisexp;
    private Integer nroCarpeta;
    private Integer indEjefiscar;
    private String desExpediente;
    private Integer nroTipexp;
    private Integer nroTitular;
    private Integer nroRepresentante;
    private String indPrioridad;
    private Date fecIniexp;
    private Date fecUltmov;
    private Integer nroMesent;
    private String codDepen;
    private Integer nroTarea;
    private Integer nroFuncionario;
    private String obsExpediente;
    private Integer nroEstexp;
    private String usuAlta;
    private Date fecAlta;
    private String usuUltmod;
    private Date fecUltmod;
}
