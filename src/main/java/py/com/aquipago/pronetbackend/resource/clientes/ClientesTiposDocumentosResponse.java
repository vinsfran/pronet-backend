package py.com.aquipago.pronetbackend.resource.clientes;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.extern.apachecommons.CommonsLog;
import py.com.aquipago.pronetbackend.resource.common.BaseResponse;
import py.com.aquipago.pronetbackend.resource.common.MessageResponse;

import java.util.List;

@CommonsLog
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ClientesTiposDocumentosResponse extends BaseResponse {

    @JsonProperty("tipos_documentos")
    @SerializedName("tipos_documentos")
    private List<String> tiposDocumentos;

    public ClientesTiposDocumentosResponse(Integer status, List<MessageResponse> messages, List<String> tiposDocumentos) {
        super(status, messages);
        this.tiposDocumentos = tiposDocumentos;
    }
}
