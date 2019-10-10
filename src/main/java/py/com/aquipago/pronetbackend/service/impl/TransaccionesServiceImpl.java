package py.com.aquipago.pronetbackend.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import py.com.aquipago.pronetbackend.converter.TransaccionesConverter;
import py.com.aquipago.pronetbackend.data.dto.Pantalla3DTO;
import py.com.aquipago.pronetbackend.data.entity.Transacciones;
import py.com.aquipago.pronetbackend.data.mapper.TransaccionesMapper;
import py.com.aquipago.pronetbackend.data.repository.TransaccionesRepository;
import py.com.aquipago.pronetbackend.resource.transacciones.Pantalla2Model;
import py.com.aquipago.pronetbackend.resource.transacciones.Pantalla3Model;
import py.com.aquipago.pronetbackend.resource.transacciones.TransaccionesModel;
import py.com.aquipago.pronetbackend.service.TransaccionesService;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author vinsfran
 */
@Service("transaccionesServiceImpl")
public class TransaccionesServiceImpl implements TransaccionesService {

    private static final Log LOG = LogFactory.getLog(TransaccionesServiceImpl.class);

    @Autowired
    @Qualifier("transaccionesRepository")
    private TransaccionesRepository transaccionesRepository;

    @Autowired
    private TransaccionesMapper transaccionesMapper;

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

    @Override
    public Pantalla3Model findByRangoFechaPantall3(Date startDate, Date endDate) throws Exception {
        Pantalla3Model pantalla3Model;
        try {
            List<Pantalla3DTO> pantalla3DTOList = transaccionesMapper.findByRangoFechaGroupBy(startDate, endDate);
            if (pantalla3DTOList == null) {
                throw new Exception("No existen Transacciones");
            }
            pantalla3Model = new Pantalla3Model();
            Pantalla3DTO pantalla3DTO = pantalla3DTOList.get(0);
            pantalla3Model.setImporteTotal(pantalla3DTO.getImporte().multiply(new BigDecimal(100)).divide(new BigDecimal(pantalla3DTO.getPorcentaje()), 2, RoundingMode.HALF_UP));
            pantalla3Model.setTransacciones(pantalla3DTOList);

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return pantalla3Model;
    }
}
