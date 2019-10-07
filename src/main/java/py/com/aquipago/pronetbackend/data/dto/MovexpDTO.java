package py.com.aquipago.pronetbackend.data.dto;

import lombok.Data;
import lombok.extern.apachecommons.CommonsLog;

import java.util.Date;

@Data
@CommonsLog
public class MovexpDTO {

    private Integer nroExpediente;
    private Integer indEjefisexp;
    private Integer indEjefiscar;
    private String desDepen;
    private String desTipmov;
    private Date fecAlta;
}
