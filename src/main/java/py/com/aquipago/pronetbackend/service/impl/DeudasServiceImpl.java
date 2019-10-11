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
import py.com.aquipago.pronetbackend.data.dto.Pantalla1DTO;
import py.com.aquipago.pronetbackend.data.mapper.DeudasMapper;
import py.com.aquipago.pronetbackend.data.repository.DeudasRepository;
import py.com.aquipago.pronetbackend.resource.deudas.DeudasModel;
import py.com.aquipago.pronetbackend.resource.deudas.Pantalla1Model;
import py.com.aquipago.pronetbackend.service.DeudasService;

import java.util.ArrayList;
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

    @Autowired
    private DeudasMapper deudasMapper;

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

    @Override
    public List<Pantalla1Model> findPantall1(String estado, String numeroDocumento, String tipoDocumento, String servicio) throws Exception {
        Pantalla1Model pantalla1Model;
        List<Pantalla1Model> pantalla1Models = null;
        try {
            List<Pantalla1DTO> pantalla1DTOList = deudasMapper.listPantalla1(estado, numeroDocumento, tipoDocumento, servicio);
            if (pantalla1DTOList == null) {
                throw new Exception("No existen Deudas");
            }
            pantalla1Models = new ArrayList<>();
            for (Pantalla1DTO pantalla1DTO : pantalla1DTOList) {
                pantalla1Model = new Pantalla1Model();
                pantalla1Model.setServicioId(pantalla1DTO.getServicioId());
                pantalla1Model.setFactura(pantalla1DTO.getFactura());
                pantalla1Model.setNombreCompleto(pantalla1DTO.getNombreCompleto());
                pantalla1Model.setVencimiento(pantalla1DTO.getVencimiento());
                pantalla1Model.setImporte(pantalla1DTO.getImporte());
                pantalla1Models.add(pantalla1Model);
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return pantalla1Models;
    }

}
