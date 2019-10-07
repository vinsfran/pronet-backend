package py.com.aquipago.pronetbackend.resource.transacciones;

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
public class TransaccionesResponse extends BaseResponse {

    @JsonProperty("transacciones")
    @SerializedName("transacciones")
    private List<TransaccionesModel> transacciones;

    public TransaccionesResponse(Integer status, List<MessageResponse> messages, List<TransaccionesModel> transacciones) {
        super(status, messages);
        this.transacciones = transacciones;
    }
}
