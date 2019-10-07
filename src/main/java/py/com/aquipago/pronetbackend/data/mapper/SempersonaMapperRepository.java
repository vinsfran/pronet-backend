package py.com.aquipago.pronetbackend.data.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import py.com.aquipago.pronetbackend.data.dto.SempersonaDTO;

import javax.websocket.server.PathParam;

@Mapper
public interface SempersonaMapperRepository {

//    @Select("select * from rhvdepen")
//    List<Rhvdepen> findAll();
//
//    @Select("SELECT * FROM rhvdepen WHERE cod_depen = #{codDepen}")
//    List<Rhvdepen> findCodDepen(@PathParam("codDepen") final String codDepen);

//    @Insert("insert into usuarios(name, salary) values(#{name}, #{salary})")
//    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id",
//            before = false, resultType = Integer.class)
//    void insert(SempersonaDTO users);

    @ResultMap("SempersonaResultMap")
    @Select("SELECT * FROM sgt.sempersona WHERE ind_tipdocide = #{indTipdocide} AND nro_docide = #{nroDocide}")
    SempersonaDTO findPersonaByIndTipdocideAndNroDocide(@PathParam("indTipdocide") final String indTipdocide, @PathParam("nroDocide") final String nroDocide);

    @ResultMap("SempersonaResultMap")
    @Select("SELECT * FROM sgt.sempersona WHERE nro_persona = #{nroPersona}")
    SempersonaDTO getPersonaByNroPersona(@PathParam("nroPersona") final Integer nroPersona);
}
