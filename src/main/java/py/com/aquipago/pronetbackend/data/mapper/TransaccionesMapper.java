package py.com.aquipago.pronetbackend.data.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import py.com.aquipago.pronetbackend.data.dto.Pantalla3DTO;

import javax.websocket.server.PathParam;
import java.util.Date;
import java.util.List;

@Mapper
public interface TransaccionesMapper {

    @ResultMap("GroupByResultMap")
    @Select("select t.servicio_id, s.descripcion, sum(t.importe), " +
            "(sum(t.importe)*100/(select sum(importe) from transacciones " +
            "where fecha BETWEEN #{startDate} AND #{endDate})) as porcentaje " +
            "from transacciones as t, servicios as s " +
            "where t.servicio_id = s.id " +
            "and t.fecha BETWEEN #{startDate} AND #{endDate} " +
            "group by t.servicio_id, s.descripcion " +
            "order by s.descripcion")
    List<Pantalla3DTO> findByRangoFechaGroupBy(@PathParam("startDate") final Date startDate, @PathParam("endDate") final Date endDate);



}


