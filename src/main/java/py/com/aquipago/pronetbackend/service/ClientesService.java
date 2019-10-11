package py.com.aquipago.pronetbackend.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import py.com.aquipago.pronetbackend.resource.clientes.ClientesModel;

import java.util.List;

/**
 * @author vinsfran
 */
public interface ClientesService {

    List<ClientesModel> findAll() throws Exception;

    Page<ClientesModel> findAll(Pageable pageable) throws Exception;

    List<String> getTipoDocumentos() throws Exception;
}
