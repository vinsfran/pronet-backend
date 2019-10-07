package py.com.aquipago.pronetbackend.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import py.com.aquipago.pronetbackend.resource.deudas.DeudasModel;

import java.util.List;

/**
 * @author vinsfran
 */
public interface DeudasService {

    List<DeudasModel> findAll() throws Exception;

    Page<DeudasModel> findAll(Pageable pageable) throws Exception;
}
