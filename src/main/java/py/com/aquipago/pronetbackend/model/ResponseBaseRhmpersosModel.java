package py.com.aquipago.pronetbackend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.extern.apachecommons.CommonsLog;
import py.com.aquipago.pronetbackend.data.dto.SempersonaDTO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@CommonsLog
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ResponseBaseRhmpersosModel extends ResponseBaseModel {

    @NotNull
    @NotBlank
    @JsonProperty("cantidad")
    @SerializedName("cantidad")
    private Integer cantidad;

    @NotNull
    @NotBlank
    @JsonProperty("personas")
    @SerializedName("personas")
    private List<SempersonaDTO> personas;

    public ResponseBaseRhmpersosModel(Integer code, boolean status, String message, @NotNull @NotBlank Integer cantidad, @NotNull @NotBlank List<SempersonaDTO> personas) {
        super(code, status, message);
        this.cantidad = cantidad;
        this.personas = personas;
    }

}
