package py.com.aquipago.pronetbackend.resource.transacciones;

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
public class Pantalla3Response extends BaseResponse {

    @JsonProperty("data")
    @SerializedName("data")
    private Pantalla3Model pantalla3Model;

    public Pantalla3Response(Integer status, List<MessageResponse> messages, Pantalla3Model pantalla3Model) {
        super(status, messages);
        this.pantalla3Model = pantalla3Model;
    }
}
