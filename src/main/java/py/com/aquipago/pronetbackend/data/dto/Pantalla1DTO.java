package py.com.aquipago.pronetbackend.data.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class Pantalla1DTO {

    private long servicioId;
    private String factura;
    private String nombreCompleto;
    private Date vencimiento;
    private BigDecimal importe;
}
