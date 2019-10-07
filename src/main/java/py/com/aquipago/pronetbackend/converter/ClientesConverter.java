package py.com.aquipago.pronetbackend.converter;

import lombok.extern.apachecommons.CommonsLog;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import py.com.aquipago.pronetbackend.data.entity.Clientes;
import py.com.aquipago.pronetbackend.resource.clientes.ClientesModel;

import java.util.ArrayList;
import java.util.List;

@CommonsLog
@Component("clientesConverter")
public class ClientesConverter {

    private static final Log LOG = LogFactory.getLog(ClientesConverter.class);

    public static Clientes clientesModelToClientes(ClientesModel clientesModel) {
        Clientes clientes = new Clientes();
        clientes.setId(clientesModel.getId());
        clientes.setTipoDocumento(clientesModel.getTipoDocumento());
        clientes.setNumeroDocumento(clientesModel.getNumeroDocumento());
        clientes.setNombreCompleto(clientesModel.getNombreCompleto());
        return clientes;
    }

    public static ClientesModel clientesToClientesModel(Clientes clientes) {
        ClientesModel clientesModel = new ClientesModel();
        clientesModel.setId(clientes.getId());
        clientesModel.setTipoDocumento(clientes.getTipoDocumento());
        clientesModel.setNumeroDocumento(clientes.getNumeroDocumento());
        clientesModel.setNombreCompleto(clientes.getNombreCompleto());
        return clientesModel;
    }

    public static List<ClientesModel> listEntitytoListModel(List<Clientes> listEntity) {
        List<ClientesModel> listModel = new ArrayList<>();
        for (Clientes entity : listEntity) {
            listModel.add(clientesToClientesModel(entity));
        }
        return listModel;
    }

    static List<ClientesModel> mapEntitiesIntoDTOs(Iterable<Clientes> entities) {
        List<ClientesModel> dtos = new ArrayList<>();
        entities.forEach(e -> dtos.add(clientesToClientesModel(e)));
        return dtos;
    }

    public static Page<ClientesModel> pageEntitytoPageModel(Pageable pageable, Page<Clientes> pageEntity) {
        List<ClientesModel> models = mapEntitiesIntoDTOs(pageEntity.getContent());
        return new PageImpl<>(models, pageable, pageEntity.getTotalElements());
    }
}
