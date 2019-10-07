package py.com.aquipago.pronetbackend.resource.deudas;

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
public class DeudasPageResponse extends BaseResponse {

    @JsonProperty("deudas")
    @SerializedName("deudas")
    private Page<DeudasModel> deudas;

    public DeudasPageResponse(Integer status, List<MessageResponse> messages, Page<DeudasModel> deudas) {
        super(status, messages);
        this.deudas = deudas;
    }
}
