package py.com.aquipago.pronetbackend.data.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import py.com.aquipago.pronetbackend.data.dto.Pantalla1DTO;

import javax.websocket.server.PathParam;
import java.util.List;

@Mapper
public interface DeudasMapper {

    @ResultMap("ListPantalla1ResultMap")
    @Select("<script> " +
            "SELECT d.servicio_id, d.factura, c.nombre_completo, d.vencimiento, d.importe " +
            "FROM deudas d, clientes c, servicios s " +
            "<where> " +
            "d.cliente_id = c.id " +
            "and d.servicio_id = s.id " +
            "<if test='estado != null'> and d.estado = #{estado} </if>" +
            "<if test='numeroDocumento != null'> and c.numero_documento = #{numeroDocumento} </if>" +
            "<if test='tipoDocumento != null'> and c.tipo_documento = #{tipoDocumento} </if>" +
            "<if test='servicio != null'> and s.descripcion = #{servicio} </if>" +
            "</where>" +
            "</script>")
    List<Pantalla1DTO> listPantalla1(@PathParam("estado") final String estado,
                                     @PathParam("numeroDocumento") final String numeroDocumento,
                                     @PathParam("tipoDocumento") final String tipoDocumento,
                                     @PathParam("servicio") final String servicio);

}
