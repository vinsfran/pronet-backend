package py.com.aquipago.pronetbackend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

@Data
public class PersonaModel implements Serializable {

    @JsonProperty("indTipdocide")
    @SerializedName("indTipdocide")
    private String indTipdocide;

    @JsonProperty("nroDocide")
    @SerializedName("nroDocide")
    private String nroDocide;

    @JsonProperty("desPersona")
    @SerializedName("desPersona")
    private String desPersona;
}
