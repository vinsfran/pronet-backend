package py.com.aquipago.pronetbackend.data.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import py.com.aquipago.pronetbackend.data.dto.MovexpDTO;

import javax.websocket.server.PathParam;
import java.util.List;

@Mapper
public interface SedmovexpMapperRepository {

    @ResultMap("MovexpResultMap")
    @Select("SELECT m.nro_expediente, m.ind_ejefiscar, d.des_depen,t.des_tipmov, m.fec_alta " +
            "FROM sgt.sedmovexp AS m, sgt.semdepen AS d, sgt.sebtipmov as t " +
            "WHERE m.cod_depen = d.cod_depen " +
            "AND m.nro_tipmov = t.nro_tipmov " +
            "AND nro_carpeta = #{nroCarpeta} " +
            "AND ind_ejefiscar = #{indEjefiscar} " +
            "ORDER BY fec_alta desc")
    List<MovexpDTO> listByNroCarpetaEjerFiscal(@PathParam("nroCarpeta") final Integer nroCarpeta, @PathParam("indEjefiscar") final Integer indEjefiscar);

}


