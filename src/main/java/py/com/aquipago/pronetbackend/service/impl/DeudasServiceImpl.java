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
import py.com.aquipago.pronetbackend.data.entity.Deudas;
import py.com.aquipago.pronetbackend.data.entity.DeudasPK;
import py.com.aquipago.pronetbackend.data.entity.Servicios;
import py.com.aquipago.pronetbackend.data.entity.Transacciones;
import py.com.aquipago.pronetbackend.data.mapper.DeudasMapper;
import py.com.aquipago.pronetbackend.data.repository.DeudasRepository;
import py.com.aquipago.pronetbackend.data.repository.ServiciosRepository;
import py.com.aquipago.pronetbackend.data.repository.TransaccionesRepository;
import py.com.aquipago.pronetbackend.resource.deudas.DeudasModel;
import py.com.aquipago.pronetbackend.resource.deudas.Pantalla1Model;
import py.com.aquipago.pronetbackend.service.DeudasService;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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
    @Qualifier("serviciosRepository")
    private ServiciosRepository serviciosRepository;

    @Autowired
    @Qualifier("transaccionesRepository")
    private TransaccionesRepository transaccionesRepository;

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

    @Override
    @Transactional
    public boolean procesarPago(long servicioId, String factura) throws Exception {
        DeudasPK deudasPK = new DeudasPK(servicioId, factura);
        try {
            Deudas deudas = deudasRepository.findByDeudasPK(deudasPK);
            if (deudas == null) {
                throw new Exception("No existe Deuda");
            }
            deudas.setEstado("CO");
            deudasRepository.save(deudas);
            Optional<Servicios> optionalServicios = serviciosRepository.findById(deudas.getDeudasPK().getServicioId());
            if (!optionalServicios.isPresent()) {
                throw new Exception("No existe Servicio");
            }
            Servicios servicios = optionalServicios.get();
            Long nextTransaccionId = transaccionesRepository.maxId() + 1;
            BigDecimal transaccionComision = deudas.getImporte().multiply(new BigDecimal(servicios.getComision())).divide(new BigDecimal(100), 2, RoundingMode.HALF_UP);
            Transacciones transacciones = new Transacciones();
            transacciones.setId(nextTransaccionId);
            transacciones.setDeudas(deudas);
            transacciones.setFecha(new Date());
            transacciones.setImporte(deudas.getImporte());
            transacciones.setComision(transaccionComision);
            transaccionesRepository.save(transacciones);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return true;
    }

}
