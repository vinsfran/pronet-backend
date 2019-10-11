package py.com.aquipago.pronetbackend.resource.deudas;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Pantalla1Request {

    @JsonProperty("servicio_id")
    @SerializedName("servicio_id")
    private long servicioId;

    @JsonProperty("factura")
    @SerializedName("factura")
    private String factura;
}
