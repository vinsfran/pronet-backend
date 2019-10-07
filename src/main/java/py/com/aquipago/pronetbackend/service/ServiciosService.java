package py.com.aquipago.pronetbackend.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import py.com.aquipago.pronetbackend.resource.servicios.ServiciosModel;

import java.util.List;

/**
 * @author vinsfran
 */
public interface ServiciosService {

    List<ServiciosModel> findAll() throws Exception;

    Page<ServiciosModel> findAll(Pageable pageable) throws Exception;
}
