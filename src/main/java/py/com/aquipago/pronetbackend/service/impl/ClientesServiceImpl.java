package py.com.aquipago.pronetbackend.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import py.com.aquipago.pronetbackend.converter.ClientesConverter;
import py.com.aquipago.pronetbackend.data.entity.Clientes;
import py.com.aquipago.pronetbackend.data.repository.ClientesRepository;
import py.com.aquipago.pronetbackend.resource.clientes.ClientesModel;
import py.com.aquipago.pronetbackend.service.ClientesService;

import java.util.List;

/**
 * @author vinsfran
 */
@Service("clientesServiceImpl")
public class ClientesServiceImpl implements ClientesService {

    private static final Log log = LogFactory.getLog(ClientesServiceImpl.class);

    @Autowired
    @Qualifier("clientesRepository")
    private ClientesRepository clientesRepository;

    @Override
    @Transactional(readOnly = true)
    public List<ClientesModel> findAll() throws Exception {
        List<ClientesModel> clientes;
        try {
            clientes = ClientesConverter.listEntitytoListModel(clientesRepository.findAll());
            if (clientes == null) {
                throw new Exception("No existen Clientes");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return clientes;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<ClientesModel> findAll(Pageable pageable) throws Exception {
        Page<ClientesModel> clientes;
        try {
            clientes = ClientesConverter.pageEntitytoPageModel(pageable, clientesRepository.findAll(pageable));
            if (clientes == null) {
                throw new Exception("No existen Clientes");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return clientes;
    }


}
