package py.com.aquipago.pronetbackend.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import py.com.aquipago.pronetbackend.converter.ServiciosConverter;
import py.com.aquipago.pronetbackend.data.repository.ServiciosRepository;
import py.com.aquipago.pronetbackend.resource.servicios.ServiciosModel;
import py.com.aquipago.pronetbackend.service.ServiciosService;

import java.util.List;

/**
 * @author vinsfran
 */
@Service("serviciosServiceImpl")
public class ServiciosServiceImpl implements ServiciosService {

    private static final Log log = LogFactory.getLog(ServiciosServiceImpl.class);

    @Autowired
    @Qualifier("serviciosRepository")
    private ServiciosRepository serviciosRepository;

    @Override
    @Transactional(readOnly = true)
    public List<ServiciosModel> findAll() throws Exception {
        List<ServiciosModel> servicios;
        try {
            servicios = ServiciosConverter.listEntitytoListModel(serviciosRepository.findAll());
            if (servicios == null) {
                throw new Exception("No existen Servicios");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return servicios;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<ServiciosModel> findAll(Pageable pageable) throws Exception {
        Page<ServiciosModel> servicios;
        try {
            servicios = ServiciosConverter.pageEntitytoPageModel(pageable, serviciosRepository.findAll(pageable));
            if (servicios == null) {
                throw new Exception("No existen Servicios");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return servicios;
    }

}
