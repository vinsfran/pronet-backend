package py.com.aquipago.pronetbackend.converter;

import lombok.extern.apachecommons.CommonsLog;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import py.com.aquipago.pronetbackend.data.entity.Servicios;
import py.com.aquipago.pronetbackend.resource.servicios.ServiciosModel;

import java.util.ArrayList;
import java.util.List;

@CommonsLog
@Component("serviciosConverter")
public class ServiciosConverter {

    private static final Log LOG = LogFactory.getLog(ServiciosConverter.class);

    public static Servicios serviciosModelToServicios(ServiciosModel serviciosModel) {
        Servicios servicios = new Servicios();
        servicios.setId(serviciosModel.getId());
        servicios.setDescripcion(serviciosModel.getDescripcion());
        servicios.setComision(serviciosModel.getComision());
        servicios.setEstado(serviciosModel.getEstado());
        return servicios;
    }

    public static ServiciosModel serviciosToServiciosModel(Servicios servicios) {
        ServiciosModel serviciosModel = new ServiciosModel();
        serviciosModel.setId(servicios.getId());
        serviciosModel.setDescripcion(servicios.getDescripcion());
        serviciosModel.setComision(servicios.getComision());
        serviciosModel.setEstado(servicios.getEstado());
        return serviciosModel;
    }

    public static List<ServiciosModel> listEntitytoListModel(List<Servicios> listEntity) {
        List<ServiciosModel> listModel = new ArrayList<>();
        for (Servicios entity : listEntity) {
            listModel.add(serviciosToServiciosModel(entity));
        }
        return listModel;
    }

    static List<ServiciosModel> mapEntitiesIntoDTOs(Iterable<Servicios> entities) {
        List<ServiciosModel> dtos = new ArrayList<>();
        entities.forEach(e -> dtos.add(serviciosToServiciosModel(e)));
        return dtos;
    }

    public static Page<ServiciosModel> pageEntitytoPageModel(Pageable pageable, Page<Servicios> pageEntity) {
        List<ServiciosModel> models = mapEntitiesIntoDTOs(pageEntity.getContent());
        return new PageImpl<>(models, pageable, pageEntity.getTotalElements());
    }
}
