package py.com.aquipago.pronetbackend.data.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author vinsfran
 */
@Data
public class Pantalla3DTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("servicio_id")
    @SerializedName("servicio_id")
    private Long servicioId;

    @JsonProperty("descripcion")
    @SerializedName("descripcion")
    private String descripcion;

    @JsonProperty("importe")
    @SerializedName("importe")
    private BigDecimal importe;

    @JsonProperty("porcentaje")
    @SerializedName("porcentaje")
    private Double porcentaje;

}
