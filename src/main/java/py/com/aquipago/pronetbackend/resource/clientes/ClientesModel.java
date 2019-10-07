package py.com.aquipago.pronetbackend.resource.clientes;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

@Data
public class ClientesModel implements Serializable {

    @JsonProperty("id")
    @SerializedName("id")
    private Long id;

    @JsonProperty("tipo_documento")
    @SerializedName("tipo_documento")
    private String tipoDocumento;

    @JsonProperty("numero_documento")
    @SerializedName("numero_documento")
    private String numeroDocumento;

    @JsonProperty("nombre_completo")
    @SerializedName("nombre_completo")
    private String nombreCompleto;


}
