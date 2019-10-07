package py.com.aquipago.pronetbackend.model;


import lombok.Data;

/**
 * @author vinsfran
 */
@Data
public class UserModel {

    private String username;
    private String email;
    private String nombre;
    private String apellido;
    private String documento;
    private String direccionGeneral;
    private String direccion;
    private String departamento;
    private String unidad;

}
