package py.com.aquipago.pronetbackend.resource.clientes;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.extern.apachecommons.CommonsLog;
import py.com.aquipago.pronetbackend.data.entity.Clientes;
import py.com.aquipago.pronetbackend.resource.common.BaseResponse;
import py.com.aquipago.pronetbackend.resource.common.MessageResponse;

import java.util.List;

@CommonsLog
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ClientesResponse extends BaseResponse {

    @JsonProperty("clientes")
    @SerializedName("clientes")
    private List<ClientesModel> clientes;

    public ClientesResponse(Integer status, List<MessageResponse> messages, List<ClientesModel> clientes) {
        super(status, messages);
        this.clientes = clientes;
    }
}
