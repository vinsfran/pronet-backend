package py.com.aquipago.pronetbackend.resource.servicios;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

@Data
public class ServiciosModel implements Serializable {

    @JsonProperty("id")
    @SerializedName("id")
    private Long id;

    @JsonProperty("descripcion")
    @SerializedName("descripcion")
    private String descripcion;

    @JsonProperty("comision")
    @SerializedName("comision")
    private Short comision;

    @JsonProperty("estado")
    @SerializedName("estado")
    private String estado;

}
