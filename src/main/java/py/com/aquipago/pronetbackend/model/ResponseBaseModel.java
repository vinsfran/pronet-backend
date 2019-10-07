package py.com.aquipago.pronetbackend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@AllArgsConstructor
public class ResponseBaseModel implements Serializable {

    @NotNull
    @NotBlank
    @JsonProperty("code")
    @SerializedName("code")
    private Integer code;

    @NotNull
    @NotBlank
    @JsonProperty("status")
    @SerializedName("status")
    private boolean status;

    @NotNull
    @NotBlank
    @JsonProperty("message")
    @SerializedName("message")
    private String message;

}
