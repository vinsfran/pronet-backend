package py.com.aquipago.pronetbackend.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import py.com.aquipago.pronetbackend.resource.transacciones.Pantalla2Model;
import py.com.aquipago.pronetbackend.resource.transacciones.TransaccionesModel;

import java.util.Date;
import java.util.List;

/**
 * @author vinsfran
 */
public interface TransaccionesService {

    List<TransaccionesModel> findAll() throws Exception;

    Page<TransaccionesModel> findAll(Pageable pageable) throws Exception;

    Page<Pantalla2Model> findByRangoFecha(@Param("startDate") Date startDate, @Param("endDate") Date endDate, Pageable pageable) throws Exception;
}
