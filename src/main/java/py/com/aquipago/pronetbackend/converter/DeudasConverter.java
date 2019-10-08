package py.com.aquipago.pronetbackend.converter;

import lombok.extern.apachecommons.CommonsLog;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import py.com.aquipago.pronetbackend.data.entity.Deudas;
import py.com.aquipago.pronetbackend.data.entity.DeudasPK;
import py.com.aquipago.pronetbackend.resource.deudas.DeudasModel;

import java.util.ArrayList;
import java.util.List;

@CommonsLog
@Component("deudasConverter")
public class DeudasConverter {

    private static final Log LOG = LogFactory.getLog(DeudasConverter.class);

    public static Deudas deudasModelToDeudas(DeudasModel deudasModel) {
        Deudas deudas = new Deudas();
        deudas.setDeudasPK(new DeudasPK(deudasModel.getServicioId(), deudasModel.getFactura()));
        deudas.setVencimiento(deudasModel.getVencimiento());
        deudas.setEstado(deudasModel.getEstado());
        deudas.setClienteId(ClientesConverter.clientesModelToClientes(deudasModel.getCliente()));
        deudas.setServicios(ServiciosConverter.serviciosModelToServicios(deudasModel.getServicio()));
        return deudas;
    }

    public static DeudasModel deudasToDeudasModel(Deudas deudas) {
        DeudasModel deudasModel = new DeudasModel();
        deudasModel.setServicioId(deudas.getDeudasPK().getServicioId());
        deudasModel.setFactura(deudas.getDeudasPK().getFactura());
        deudasModel.setVencimiento(deudas.getVencimiento());
        deudasModel.setEstado(deudas.getEstado());
        deudasModel.setCliente(ClientesConverter.clientesToClientesModel(deudas.getClienteId()));
        deudasModel.setServicio(ServiciosConverter.serviciosToServiciosModel(deudas.getServicios()));
        return deudasModel;
    }

    public static List<DeudasModel> listEntitytoListModel(List<Deudas> listEntity) {
        List<DeudasModel> listModel = new ArrayList<>();
        for (Deudas entity : listEntity) {
            listModel.add(deudasToDeudasModel(entity));
        }
        return listModel;
    }

    static List<DeudasModel> mapEntitiesIntoDTOs(Iterable<Deudas> entities) {
        List<DeudasModel> dtos = new ArrayList<>();
        entities.forEach(e -> dtos.add(deudasToDeudasModel(e)));
        return dtos;
    }

    public static Page<DeudasModel> pageEntitytoPageModel(Pageable pageable, Page<Deudas> pageEntity) {
        List<DeudasModel> models = mapEntitiesIntoDTOs(pageEntity.getContent());
        return new PageImpl<>(models, pageable, pageEntity.getTotalElements());
    }
}
