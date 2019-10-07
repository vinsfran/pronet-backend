package py.com.aquipago.pronetbackend.resource.servicios;

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
public class ServiciosResponse extends BaseResponse {

    @JsonProperty("servicios")
    @SerializedName("servicios")
    private List<ServiciosModel> servicios;

    public ServiciosResponse(Integer status, List<MessageResponse> messages, List<ServiciosModel> servicios) {
        super(status, messages);
        this.servicios = servicios;
    }
}
