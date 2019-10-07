package py.com.aquipago.pronetbackend.data.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import py.com.aquipago.pronetbackend.data.dto.ExpedienteDTO;
import py.com.aquipago.pronetbackend.data.dto.SemexpedienteDTO;

import javax.websocket.server.PathParam;
import java.util.List;

@Mapper
public interface SemexpedienteMapperRepository {

    @ResultMap("SemexpedienteResultMap")
    @Select("SELECT * FROM sgt.semexpediente")
    List<SemexpedienteDTO> listAll();

    @ResultMap("ExpedienteResultMap")
    @Select("SELECT e.nro_expediente, " +
            "e.ind_ejefisexp, " +
            "e.nro_carpeta, " +
            "e.ind_ejefiscar, " +
            "e.des_expediente, " +
            "e.nro_titular, " +
            "e.fec_ultmov, " +
            "e.cod_depen, " +
            "d.des_depen " +
            "FROM sgt.semexpediente AS e, sgt.semdepen AS d " +
            "WHERE e.cod_depen = d.cod_depen " +
            "AND e.nro_titular = #{nroTitular}")
    List<ExpedienteDTO> listByNroTitular(@PathParam("nroTitular") final Integer nroTitular);

    @ResultMap("ExpedienteResultMap")
    @Select("SELECT e.nro_expediente, " +
            "e.ind_ejefisexp, " +
            "e.nro_carpeta, " +
            "e.ind_ejefiscar, " +
            "e.des_expediente, " +
            "e.nro_titular, " +
            "e.fec_ultmov, " +
            "e.cod_depen, " +
            "d.des_depen " +
            "FROM sgt.semexpediente AS e, sgt.semdepen AS d " +
            "WHERE e.cod_depen = d.cod_depen " +
            "AND e.ind_ejefiscar = #{indEjefiscar} " +
            "AND e.nro_expediente = #{nroExpediente} ")
    ExpedienteDTO getExpediente(@PathParam("indEjefiscar") final Integer indEjefiscar, @PathParam("nroExpediente") final Integer nroExpediente);
}
