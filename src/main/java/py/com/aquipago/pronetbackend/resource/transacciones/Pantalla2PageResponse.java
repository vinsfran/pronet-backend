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
public class Pantalla2PageResponse extends BaseResponse {

    @JsonProperty("page")
    @SerializedName("page")
    private Page<Pantalla2Model> pantalla2Models;

    public Pantalla2PageResponse(Integer status, List<MessageResponse> messages, Page<Pantalla2Model> pantalla2Models) {
        super(status, messages);
        this.pantalla2Models = pantalla2Models;
    }
}
