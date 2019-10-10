package py.com.aquipago.pronetbackend.resource.transacciones;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import py.com.aquipago.pronetbackend.data.dto.Pantalla3DTO;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author vinsfran
 */
@Data
public class Pantalla3Model implements Serializable {

    @JsonProperty("importe_total")
    @SerializedName("importe_total")
    private BigDecimal importeTotal;

    @JsonProperty("transacciones")
    @SerializedName("transacciones")
    private List<Pantalla3DTO> transacciones;
}
