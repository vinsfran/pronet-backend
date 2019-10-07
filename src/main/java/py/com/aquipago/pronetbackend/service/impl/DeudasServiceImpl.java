package py.com.aquipago.pronetbackend.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import py.com.aquipago.pronetbackend.converter.DeudasConverter;
import py.com.aquipago.pronetbackend.data.repository.DeudasRepository;
import py.com.aquipago.pronetbackend.resource.deudas.DeudasModel;
import py.com.aquipago.pronetbackend.service.DeudasService;

import java.util.List;

/**
 * @author vinsfran
 */
@Service("deudasServiceImpl")
public class DeudasServiceImpl implements DeudasService {

    private static final Log log = LogFactory.getLog(DeudasServiceImpl.class);

    @Autowired
    @Qualifier("deudasRepository")
    private DeudasRepository deudasRepository;

    @Override
    @Transactional(readOnly = true)
    public List<DeudasModel> findAll() throws Exception {
        List<DeudasModel> deudas;
        try {
            deudas = DeudasConverter.listEntitytoListModel(deudasRepository.findAll());
            if (deudas == null) {
                throw new Exception("No existen Deudas");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return deudas;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<DeudasModel> findAll(Pageable pageable) throws Exception {
        Page<DeudasModel> deudas;
        try {
            deudas = DeudasConverter.pageEntitytoPageModel(pageable, deudasRepository.findAll(pageable));
            if (deudas == null) {
                throw new Exception("No existen Deudas");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return deudas;
    }

}
