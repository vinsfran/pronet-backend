package py.com.aquipago.pronetbackend.resource.transacciones;

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
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import py.com.aquipago.pronetbackend.resource.common.BaseResponse;
import py.com.aquipago.pronetbackend.resource.common.MessageResponse;
import py.com.aquipago.pronetbackend.resource.common.StatusLevel;
import py.com.aquipago.pronetbackend.service.TransaccionesService;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/pronet-backend/api/transacciones")
@Api(tags = "transacciones-resource")
public class TransaccionesResource {

    private static final Log LOG = LogFactory.getLog(TransaccionesResource.class);

    @Autowired
    @Qualifier("transaccionesServiceImpl")
    private TransaccionesService transaccionesService;

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
    @ApiOperation(value = "getAll", notes = "Retorna lista de transacciones sin paginar")
    @GetMapping()
    public ResponseEntity<?> getAll() {
        HttpStatus httpStatus;
        BaseResponse response;
        MessageResponse message;
        List<MessageResponse> messages = new ArrayList<>();
        try {
            List<TransaccionesModel> transacciones = transaccionesService.findAll();
            if (transacciones != null) {
                httpStatus = HttpStatus.OK;
                message = new MessageResponse(StatusLevel.INFO, "Lista de Transacciones OK");
                messages.add(message);
                response = new TransaccionesResponse(httpStatus.value(), messages, transacciones);
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
    @ApiOperation(value = "getAllByPage", notes = "Retorna lista de transacciones con paginacion")
    @GetMapping("/page")
    public ResponseEntity<?> getAllByPage(@ApiIgnore Pageable pageable) {
        HttpStatus httpStatus;
        BaseResponse response;
        MessageResponse message;
        List<MessageResponse> messages = new ArrayList<>();
        try {
            Page<TransaccionesModel> transacciones = transaccionesService.findAll(pageable);
            if (transacciones != null) {
                httpStatus = HttpStatus.OK;
                message = new MessageResponse(StatusLevel.INFO, "Lista de Transacciones OK");
                messages.add(message);
                response = new TransaccionesPageResponse(httpStatus.value(), messages, transacciones);
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
    @ApiOperation(value = "getAllByPage", notes = "Retorna lista de transacciones con paginacion")
    @GetMapping("/pantalla2")
    public ResponseEntity<?> findByRangoFecha(@ApiIgnore Pageable pageable,
                                              @RequestParam(value = "fecha_desde", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaDesde,
                                              @RequestParam(value = "fecha_hasta", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaHasta) {
        HttpStatus httpStatus;
        BaseResponse response;
        MessageResponse message;
        List<MessageResponse> messages = new ArrayList<>();
        try {
            Page<Pantalla2Model> pantalla2ModelPage = transaccionesService.findByRangoFecha(fechaDesde, fechaHasta, pageable);
            if (pantalla2ModelPage != null) {
                httpStatus = HttpStatus.OK;
                message = new MessageResponse(StatusLevel.INFO, "Lista de Transacciones OK");
                messages.add(message);
                response = new Pantalla2PageResponse(httpStatus.value(), messages, pantalla2ModelPage);
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
