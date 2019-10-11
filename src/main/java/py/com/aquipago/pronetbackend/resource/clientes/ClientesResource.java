package py.com.aquipago.pronetbackend.resource.clientes;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import py.com.aquipago.pronetbackend.resource.common.BaseResponse;
import py.com.aquipago.pronetbackend.resource.common.MessageResponse;
import py.com.aquipago.pronetbackend.resource.common.StatusLevel;
import py.com.aquipago.pronetbackend.service.ClientesService;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/pronet-backend/api/clientes")
@Api(tags = "clientes-resource")
public class ClientesResource {

    private static final Log LOG = LogFactory.getLog(ClientesResource.class);

    @Autowired
    @Qualifier("clientesServiceImpl")
    private ClientesService clientesService;

    @ApiResponses(value = {
            @ApiResponse(code = HttpServletResponse.SC_OK, message = "OK")
            ,
            @ApiResponse(code = HttpServletResponse.SC_CREATED, message = "CREATED")
            ,
            @ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, message = "BAD REQUEST")
            ,
            @ApiResponse(code = HttpServletResponse.SC_UNAUTHORIZED, message = "UNAUTHORIZED")
            ,
            @ApiResponse(code = HttpServletResponse.SC_FORBIDDEN, message = "FORBIDDEN")
            ,
            @ApiResponse(code = HttpServletResponse.SC_NOT_FOUND, message = "NOT FOUND")
            ,
            @ApiResponse(code = HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message = "INTERNAL ERROR SERVER")})
    @ApiOperation(value = "getAll", notes = "Retorna lista de clientes sin paginar")
    @GetMapping()
    public ResponseEntity<?> getAll() {
        HttpStatus httpStatus;
        BaseResponse response;
        MessageResponse message;
        List<MessageResponse> messages = new ArrayList<>();
        try {
            List<ClientesModel> clientes = clientesService.findAll();
            if (clientes != null) {
                httpStatus = HttpStatus.OK;
                message = new MessageResponse(StatusLevel.INFO, "Lista de Clientes OK");
                messages.add(message);
                response = new ClientesResponse(httpStatus.value(), messages, clientes);
            } else {
                httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
                message = new MessageResponse(StatusLevel.ERROR, "ERROR");
                messages.add(message);
                response = new BaseResponse(httpStatus.value(), messages);
            }
        } catch (Exception e) {
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            message = new MessageResponse(StatusLevel.INFO, "Error al realizar la consulta a la base de datos!");
            messages.add(message);
            message = new MessageResponse(StatusLevel.ERROR, e.getMessage());
            messages.add(message);
            response = new BaseResponse(httpStatus.value(), messages);
        }
        return new ResponseEntity<>(response, httpStatus);
    }

    @ApiResponses(value = {
            @ApiResponse(code = HttpServletResponse.SC_OK, message = "OK")
            ,
            @ApiResponse(code = HttpServletResponse.SC_CREATED, message = "CREATED")
            ,
            @ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, message = "BAD REQUEST")
            ,
            @ApiResponse(code = HttpServletResponse.SC_UNAUTHORIZED, message = "UNAUTHORIZED")
            ,
            @ApiResponse(code = HttpServletResponse.SC_FORBIDDEN, message = "FORBIDDEN")
            ,
            @ApiResponse(code = HttpServletResponse.SC_NOT_FOUND, message = "NOT FOUND")
            ,
            @ApiResponse(code = HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message = "INTERNAL ERROR SERVER")})
    @ApiOperation(value = "getAllByPage", notes = "Retorna lista de clientes con paginacion")
    @GetMapping("/page")
    public ResponseEntity<?> getAllByPage(@ApiIgnore Pageable pageable) {
        HttpStatus httpStatus;
        BaseResponse response;
        MessageResponse message;
        List<MessageResponse> messages = new ArrayList<>();
        try {
            Page<ClientesModel> clientes = clientesService.findAll(pageable);
            if (clientes != null) {
                httpStatus = HttpStatus.OK;
                message = new MessageResponse(StatusLevel.INFO, "Lista de Clientes OK");
                messages.add(message);
                response = new ClientesPageResponse(httpStatus.value(), messages, clientes);
            } else {
                httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
                message = new MessageResponse(StatusLevel.ERROR, "ERROR");
                messages.add(message);
                response = new BaseResponse(httpStatus.value(), messages);
            }
        } catch (Exception e) {
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            message = new MessageResponse(StatusLevel.INFO, "Error al realizar la consulta a la base de datos!");
            messages.add(message);
            message = new MessageResponse(StatusLevel.ERROR, e.getMessage());
            messages.add(message);
            response = new BaseResponse(httpStatus.value(), messages);
        }
        return new ResponseEntity<>(response, httpStatus);
    }

    @ApiResponses(value = {
            @ApiResponse(code = HttpServletResponse.SC_OK, message = "OK")
            ,
            @ApiResponse(code = HttpServletResponse.SC_CREATED, message = "CREATED")
            ,
            @ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, message = "BAD REQUEST")
            ,
            @ApiResponse(code = HttpServletResponse.SC_UNAUTHORIZED, message = "UNAUTHORIZED")
            ,
            @ApiResponse(code = HttpServletResponse.SC_FORBIDDEN, message = "FORBIDDEN")
            ,
            @ApiResponse(code = HttpServletResponse.SC_NOT_FOUND, message = "NOT FOUND")
            ,
            @ApiResponse(code = HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message = "INTERNAL ERROR SERVER")})
    @ApiOperation(value = "getTipoDocumentos", notes = "Retorna lista de Tipo de Documentos existentes")
    @GetMapping("/tipos-documentos")
    public ResponseEntity<?> getTipoDocumentos() {
        HttpStatus httpStatus;
        BaseResponse response;
        MessageResponse message;
        List<MessageResponse> messages = new ArrayList<>();
        try {
            List<String> tipoDocumentos = clientesService.getTipoDocumentos();
            if (tipoDocumentos != null) {
                httpStatus = HttpStatus.OK;
                message = new MessageResponse(StatusLevel.INFO, "Lista de Tipo de Documentos OK");
                messages.add(message);
                response = new ClientesTiposDocumentosResponse(httpStatus.value(), messages, tipoDocumentos);
            } else {
                httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
                message = new MessageResponse(StatusLevel.ERROR, "ERROR");
                messages.add(message);
                response = new BaseResponse(httpStatus.value(), messages);
            }
        } catch (Exception e) {
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            message = new MessageResponse(StatusLevel.INFO, "Error al realizar la consulta a la base de datos!");
            messages.add(message);
            message = new MessageResponse(StatusLevel.ERROR, e.getMessage());
            messages.add(message);
            response = new BaseResponse(httpStatus.value(), messages);
        }
        return new ResponseEntity<>(response, httpStatus);
    }

}
