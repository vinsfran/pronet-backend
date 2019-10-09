package py.com.aquipago.pronetbackend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import py.com.aquipago.pronetbackend.converter.TransaccionesConverter;
import py.com.aquipago.pronetbackend.data.repository.TransaccionesRepository;
import py.com.aquipago.pronetbackend.resource.transacciones.Pantalla2Model;
import py.com.aquipago.pronetbackend.resource.transacciones.TransaccionesModel;
import py.com.aquipago.pronetbackend.service.TransaccionesService;

import java.util.Date;
import java.util.List;

/**
 * @author vinsfran
 */
@Service("transaccionesServiceImpl")
public class TransaccionesServiceImpl implements TransaccionesService {


    @Autowired
    @Qualifier("transaccionesRepository")
    private TransaccionesRepository transaccionesRepository;

    @Override
    @Transactional(readOnly = true)
    public List<TransaccionesModel> findAll() throws Exception {
        List<TransaccionesModel> transacciones;
        try {
            transacciones = TransaccionesConverter.listEntitytoListModel(transaccionesRepository.findAll());
            if (transacciones == null) {
                throw new Exception("No existen Transacciones");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return transacciones;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<TransaccionesModel> findAll(Pageable pageable) throws Exception {
        Page<TransaccionesModel> transacciones;
        try {
            transacciones = TransaccionesConverter.pageEntitytoPageModel(pageable, transaccionesRepository.findAll(pageable));
            if (transacciones == null) {
                throw new Exception("No existen Transacciones");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return transacciones;
    }

    @Override
    public Page<Pantalla2Model> findByRangoFecha(Date startDate, Date endDate, Pageable pageable) throws Exception {
        Page<Pantalla2Model> pantalla2ModelPage;
        try {
            pantalla2ModelPage = TransaccionesConverter.pageTransaccionesToPagePantalla2Model(pageable, transaccionesRepository.findByRangoFecha(startDate, endDate, pageable));
            if (pantalla2ModelPage == null) {
                throw new Exception("No existen Transacciones");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return pantalla2ModelPage;
    }
}
