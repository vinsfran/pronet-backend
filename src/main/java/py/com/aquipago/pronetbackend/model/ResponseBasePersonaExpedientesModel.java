package py.com.aquipago.pronetbackend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.extern.apachecommons.CommonsLog;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@CommonsLog
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ResponseBasePersonaExpedientesModel extends ResponseBaseModel {

    @JsonProperty("personaExpedientes")
    @SerializedName("personaExpedientes")
    private PersonaExpedientesModel personaExpedientesModel;

    public ResponseBasePersonaExpedientesModel(@NotNull @NotBlank Integer code, @NotNull @NotBlank boolean status, @NotNull @NotBlank String message, PersonaExpedientesModel personaExpedientesModel) {
        super(code, status, message);
        this.personaExpedientesModel = personaExpedientesModel;
    }
}
