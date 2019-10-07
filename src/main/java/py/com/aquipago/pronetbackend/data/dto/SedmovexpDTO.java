package py.com.aquipago.pronetbackend.data.dto;

import lombok.Data;
import lombok.extern.apachecommons.CommonsLog;

import java.util.Date;

@Data
@CommonsLog
public class SedmovexpDTO {

    private Integer nroSecuencia;
    private Integer nroExpediente;
    private Integer indEjefisexp;
    private Integer nroCarpeta;
    private Integer indEjefiscar;
    private Date fecMovexp;
    private Integer nroTipmov;
    private Integer nroMesent;
    private String codDepen;
    private Integer nroFuncionario;
    private Integer nroTarea;
    private Integer nroEstexp;
    private String usuAlta;
    private Date fecAlta;
}
