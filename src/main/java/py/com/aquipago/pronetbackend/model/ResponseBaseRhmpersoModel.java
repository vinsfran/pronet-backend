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

@CommonsLog
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ResponseBaseRhmpersoModel extends ResponseBaseModel {

    @NotNull
    @NotBlank
    @JsonProperty("persona")
    @SerializedName("persona")
    private SempersonaDTO persona;

    public ResponseBaseRhmpersoModel(Integer code, boolean status, String message, @NotNull @NotBlank SempersonaDTO persona) {
        super(code, status, message);
        this.persona = persona;
    }

}
