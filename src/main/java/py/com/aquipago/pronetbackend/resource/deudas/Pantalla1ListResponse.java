package py.com.aquipago.pronetbackend.resource.deudas;

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
public class Pantalla1ListResponse extends BaseResponse {

    @JsonProperty("page")
    @SerializedName("page")
    private List<Pantalla1Model> pantalla1Models;

    public Pantalla1ListResponse(Integer status, List<MessageResponse> messages, List<Pantalla1Model> pantalla1Models) {
        super(status, messages);
        this.pantalla1Models = pantalla1Models;
    }
}
