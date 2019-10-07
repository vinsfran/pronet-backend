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
public class ResponseBaseUserModel extends ResponseBaseModel {

    @NotNull
    @NotBlank
    @JsonProperty("usuario")
    @SerializedName("usuario")
    private UserModel usuario;

    public ResponseBaseUserModel(Integer code, boolean status, String message, UserModel usuario) {
        super(code, status, message);
        this.usuario = usuario;
    }

}
