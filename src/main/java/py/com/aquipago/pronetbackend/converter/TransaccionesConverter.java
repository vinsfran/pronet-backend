package py.com.aquipago.pronetbackend.converter;

import lombok.extern.apachecommons.CommonsLog;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import py.com.aquipago.pronetbackend.data.entity.Transacciones;
import py.com.aquipago.pronetbackend.resource.transacciones.Pantalla2Model;
import py.com.aquipago.pronetbackend.resource.transacciones.TransaccionesModel;

import java.util.ArrayList;
import java.util.List;

@CommonsLog
@Component("transaccionesConverter")
public class TransaccionesConverter {

    private static final Log LOG = LogFactory.getLog(TransaccionesConverter.class);

    public static Transacciones transaccionesModelToTransacciones(TransaccionesModel transaccionesModel) {
        Transacciones transacciones = new Transacciones();
        transacciones.setId(transaccionesModel.getId());
        transacciones.setFecha(transaccionesModel.getFecha());
        transacciones.setImporte(transaccionesModel.getImporte());
        transacciones.setComision(transaccionesModel.getComision());
        return transacciones;
    }

    public static TransaccionesModel transaccionesToTransaccionesModel(Transacciones transacciones) {
        TransaccionesModel transaccionesModel = new TransaccionesModel();
        transaccionesModel.setId(transacciones.getId());
        transaccionesModel.setFecha(transacciones.getFecha());
        transaccionesModel.setImporte(transacciones.getImporte());
        transaccionesModel.setComision(transacciones.getComision());
        return transaccionesModel;
    }

    public static Pantalla2Model transaccionesToPantalla2Model(Transacciones transacciones) {
        Pantalla2Model pantalla2Model = new Pantalla2Model();
        pantalla2Model.setFecha(transacciones.getFecha());
        pantalla2Model.setServicio(transacciones.getDeudas().getServicios().getDescripcion());
        pantalla2Model.setFactura(transacciones.getDeudas().getDeudasPK().getFactura());
        pantalla2Model.setCliente(transacciones.getDeudas().getClienteId().getNombreCompleto());
        pantalla2Model.setTotal(transacciones.getImporte().add(transacciones.getComision()));
        return pantalla2Model;
    }


    public static List<TransaccionesModel> listEntitytoListModel(List<Transacciones> listEntity) {
        List<TransaccionesModel> listModel = new ArrayList<>();
        for (Transacciones entity : listEntity) {
            listModel.add(transaccionesToTransaccionesModel(entity));
        }
        return listModel;
    }

    static List<TransaccionesModel> mapEntitiesIntoDTOs(Iterable<Transacciones> entities) {
        List<TransaccionesModel> dtos = new ArrayList<>();
        entities.forEach(e -> dtos.add(transaccionesToTransaccionesModel(e)));
        return dtos;
    }

    public static Page<TransaccionesModel> pageEntitytoPageModel(Pageable pageable, Page<Transacciones> pageEntity) {
        List<TransaccionesModel> models = mapEntitiesIntoDTOs(pageEntity.getContent());
        return new PageImpl<>(models, pageable, pageEntity.getTotalElements());
    }


    public static List<Pantalla2Model> listTransaccionesToListPantalla2Model(List<Transacciones> listEntity) {
        List<Pantalla2Model> listModel = new ArrayList<>();
        for (Transacciones entity : listEntity) {
            listModel.add(transaccionesToPantalla2Model(entity));
        }
        return listModel;
    }

    static List<Pantalla2Model> mapTransaccionesToPantalla2Model(Iterable<Transacciones> entities) {
        List<Pantalla2Model> dtos = new ArrayList<>();
        entities.forEach(e -> dtos.add(transaccionesToPantalla2Model(e)));
        return dtos;
    }

    public static Page<Pantalla2Model> pageTransaccionesToPagePantalla2Model(Pageable pageable, Page<Transacciones> pageEntity) {
        List<Pantalla2Model> models = mapTransaccionesToPantalla2Model(pageEntity.getContent());
        return new PageImpl<>(models, pageable, pageEntity.getTotalElements());
    }
}
