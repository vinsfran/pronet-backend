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

import java.math.BigDecimal;
import java.util.List;

@CommonsLog
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Pantalla3PageResponse extends BaseResponse {

    @JsonProperty("importe_total")
    @SerializedName("importe_total")
    private BigDecimal importeTotal;

    @JsonProperty("page")
    @SerializedName("page")
    private Page<Pantalla3Model> pantalla3Models;

    public Pantalla3PageResponse(Integer status, List<MessageResponse> messages, Page<Pantalla3Model> pantalla3Models) {
        super(status, messages);
        this.pantalla3Models = pantalla3Models;
    }
}
