package py.com.aquipago.pronetbackend.data.jdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import py.com.aquipago.pronetbackend.data.dto.SempersonaDTO;
import py.com.aquipago.pronetbackend.support.WhereParams;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

@Repository
public class SempersonaJdbcRepository {

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    @Autowired
    DataSource dataSource;

    private NamedParameterJdbcTemplate jdbcTemplate;

    @PostConstruct
    public void init() {
        jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    private String getConsultaPersona(String indTipdocide, String nroDocide, WhereParams params) {
        StringBuilder sql = new StringBuilder();
        sql.append(" select * from sgt.sempersona ");
        sql.append(" WHERE 1=1 ");
        sql.append(params.filter(" AND ind_tipdocide =  :ind_tipdocide ", indTipdocide));
        sql.append(params.filter(" AND empr_nroruc =  :nro_docide ", nroDocide));
        return sql.toString();
    }

    public SempersonaDTO findPersonaByIndTipdocideAndNroDocide(String indTipdocide, String nroDocide) {
        WhereParams params = new WhereParams();
        String sql = getConsultaPersona(indTipdocide, nroDocide, params);
        return jdbcTemplate.queryForObject(sql, params.getParams(), SempersonaDTO.class);
    }


}
