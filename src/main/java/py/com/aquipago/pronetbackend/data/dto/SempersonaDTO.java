package py.com.aquipago.pronetbackend.data.dto;

import lombok.Data;
import lombok.extern.apachecommons.CommonsLog;

import java.util.Date;

@Data
@CommonsLog
public class SempersonaDTO {

    private String indTipdocide;
    private String nroDocide;
    private Integer nroPersona;
    private String desPersona;
    private String nomFantasia;
    private String indSexo;
    private String indEstciv;
    private String indTipsoc;
    private Date fecNaccon;
    private String dirPrincipal;
    private String telPrincipal;
    private String emailPrincipal;
    private String indTipper;
    private String obsPersona;
    private String indActivo;
    private String usuAlta;
    private Date fecAlta;
    private String usuUltmod;
    private Date fecUltmod;

}
