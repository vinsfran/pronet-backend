package py.com.aquipago.pronetbackend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import py.com.aquipago.pronetbackend.resource.clientes.ClientesModel;

import java.util.List;

@Data
public class PersonaExpedientesModel {

    @JsonProperty("persona")
    @SerializedName("persona")
    private PersonaModel personaModel;

    @JsonProperty("expedientes")
    @SerializedName("expedientes")
    private List<ClientesModel> clientesModelList;
}
