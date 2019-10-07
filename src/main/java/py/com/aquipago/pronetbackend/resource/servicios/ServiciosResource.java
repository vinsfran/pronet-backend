package py.com.aquipago.pronetbackend.resource.servicios;

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
import py.com.aquipago.pronetbackend.service.ServiciosService;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/pronet-backend/api/servicios")
@Api(tags = "servicios-resource")
public class ServiciosResource {

    private static final Log LOG = LogFactory.getLog(ServiciosResource.class);

    @Autowired
    @Qualifier("serviciosServiceImpl")
    private ServiciosService serviciosService;

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
    @ApiOperation(value = "getAll", notes = "Retorna lista de servicios sin paginar")
    @GetMapping()
    public ResponseEntity<?> getAll() {
        HttpStatus httpStatus;
        BaseResponse response;
        MessageResponse message;
        List<MessageResponse> messages = new ArrayList<>();
        try {
            List<ServiciosModel> servicios = serviciosService.findAll();
            if (servicios != null) {
                httpStatus = HttpStatus.OK;
                message = new MessageResponse(StatusLevel.INFO, "Lista de Servicios OK");
                messages.add(message);
                response = new ServiciosResponse(httpStatus.value(), messages, servicios);
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
    @ApiOperation(value = "getAllByPage", notes = "Retorna lista de servicios con paginacion")
    @GetMapping("/page")
    public ResponseEntity<?> getAllByPage(@ApiIgnore Pageable pageable) {
        HttpStatus httpStatus;
        BaseResponse response;
        MessageResponse message;
        List<MessageResponse> messages = new ArrayList<>();
        try {
            Page<ServiciosModel> servicios = serviciosService.findAll(pageable);
            if (servicios != null) {
                httpStatus = HttpStatus.OK;
                message = new MessageResponse(StatusLevel.INFO, "Lista de Servicios OK");
                messages.add(message);
                response = new ServiciosPageResponse(httpStatus.value(), messages, servicios);
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
