package py.com.aquipago.pronetbackend.resource.transacciones;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import py.com.aquipago.pronetbackend.json.JsonDateSimpleDeserializer;
import py.com.aquipago.pronetbackend.json.JsonDateSimpleSerializer;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author vinsfran
 */
@Data
public class TransaccionesModel implements Serializable {

    @JsonProperty("id")
    @SerializedName("id")
    private Long id;

    @ApiModelProperty(value = "Fecha de Transaccion", required = false, example = "AAAA-MM-DD")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @JsonProperty("fecha")
    @SerializedName("fecha")
    @JsonSerialize(using = JsonDateSimpleSerializer.class)
    @JsonDeserialize(using = JsonDateSimpleDeserializer.class)
    private Date fecha;

    @JsonProperty("importe")
    @SerializedName("importe")
    private BigDecimal importe;

    @JsonProperty("comision")
    @SerializedName("comision")
    private BigDecimal comision;

}
