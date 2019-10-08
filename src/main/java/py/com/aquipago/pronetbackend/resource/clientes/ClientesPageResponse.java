package py.com.aquipago.pronetbackend.resource.clientes;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.data.domain.Page;
import py.com.aquipago.pronetbackend.resource.common.BaseResponse;
import py.com.aquipago.pronetbackend.resource.common.MessageResponse;

import java.util.List;

@CommonsLog
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ClientesPageResponse extends BaseResponse {

    @JsonProperty("page")
    @SerializedName("page")
    private Page<ClientesModel> clientes;

    public ClientesPageResponse(Integer status, List<MessageResponse> messages, Page<ClientesModel> clientes) {
        super(status, messages);
        this.clientes = clientes;
    }
}
