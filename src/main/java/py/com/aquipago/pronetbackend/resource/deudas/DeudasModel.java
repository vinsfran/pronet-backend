package py.com.aquipago.pronetbackend.resource.deudas;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import py.com.aquipago.pronetbackend.json.JsonDateSimpleDeserializer;
import py.com.aquipago.pronetbackend.json.JsonDateSimpleSerializer;
import py.com.aquipago.pronetbackend.resource.clientes.ClientesModel;
import py.com.aquipago.pronetbackend.resource.servicios.ServiciosModel;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class DeudasModel implements Serializable {

    @JsonProperty("servicio_id")
    @SerializedName("servicio_id")
    private long servicioId;

    @JsonProperty("factura")
    @SerializedName("factura")
    private String factura;

    @JsonProperty("importe")
    @SerializedName("importe")
    private BigDecimal importe;

    @ApiModelProperty(value = "Fecha de Vencimiento", required = false, example = "AAAA-MM-DD")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @JsonProperty("vencimiento")
    @SerializedName("vencimiento")
    @JsonSerialize(using = JsonDateSimpleSerializer.class)
    @JsonDeserialize(using = JsonDateSimpleDeserializer.class)
    private Date vencimiento;

    @JsonProperty("estado")
    @SerializedName("estado")
    private String estado;

    @JsonProperty("cliente")
    @SerializedName("cliente")
    private ClientesModel cliente;

    @JsonProperty("servicio")
    @SerializedName("servicio")
    private ServiciosModel servicio;

}
