package py.com.aquipago.pronetbackend.resource.deudas;

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
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import py.com.aquipago.pronetbackend.resource.common.BaseResponse;
import py.com.aquipago.pronetbackend.resource.common.MessageResponse;
import py.com.aquipago.pronetbackend.resource.common.StatusLevel;
import py.com.aquipago.pronetbackend.resource.transacciones.Pantalla2PageResponse;
import py.com.aquipago.pronetbackend.service.DeudasService;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/pronet-backend/api/deudas")
@Api(tags = "deudas-resource")
public class DeudasResource {

    private static final Log LOG = LogFactory.getLog(DeudasResource.class);

    @Autowired
    @Qualifier("deudasServiceImpl")
    private DeudasService deudasService;

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
    @ApiOperation(value = "getAll", notes = "Retorna lista de deudas sin paginar")
    @GetMapping()
    public ResponseEntity<?> getAll() {
        HttpStatus httpStatus;
        BaseResponse response;
        MessageResponse message;
        List<MessageResponse> messages = new ArrayList<>();
        try {
            List<DeudasModel> deudas = deudasService.findAll();
            if (deudas != null) {
                httpStatus = HttpStatus.OK;
                message = new MessageResponse(StatusLevel.INFO, "Lista de Deudas OK");
                messages.add(message);
                response = new DeudasResponse(httpStatus.value(), messages, deudas);
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
    @ApiOperation(value = "getAllByPage", notes = "Retorna lista de deudas con paginacion")
    @GetMapping("/page")
    public ResponseEntity<?> getAllByPage(@ApiIgnore Pageable pageable) {
        HttpStatus httpStatus;
        BaseResponse response;
        MessageResponse message;
        List<MessageResponse> messages = new ArrayList<>();
        try {
            Page<DeudasModel> deudas = deudasService.findAll(pageable);
            if (deudas != null) {
                httpStatus = HttpStatus.OK;
                message = new MessageResponse(StatusLevel.INFO, "Lista de Deudas OK");
                messages.add(message);
                response = new DeudasPageResponse(httpStatus.value(), messages, deudas);
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
    @ApiOperation(value = "findPantall1", notes = "Retorna lista de deudas")
    @GetMapping("/pantalla1")
    public ResponseEntity<?> findPantall1(@RequestParam(value = "estado", required = false) String estado,
                                          @RequestParam(value = "numero_documento", required = false) String numeroDocumento,
                                          @RequestParam(value = "tipo_documento", required = false) String tipoDocumento,
                                          @RequestParam(value = "servicio", required = false) String servicio) {
        HttpStatus httpStatus;
        BaseResponse response;
        MessageResponse message;
        List<MessageResponse> messages = new ArrayList<>();
        try {
            if (estado.isEmpty()) {
                estado = null;
            }
            if (numeroDocumento.isEmpty()) {
                numeroDocumento = null;
            }
            if (tipoDocumento.isEmpty()) {
                tipoDocumento = null;
            }
            if (servicio.isEmpty()) {
                servicio = null;
            }
            List<Pantalla1Model> pantalla1ModelList = deudasService.findPantall1(estado, numeroDocumento, tipoDocumento, servicio);
            if (pantalla1ModelList != null) {
                httpStatus = HttpStatus.OK;
                message = new MessageResponse(StatusLevel.INFO, "Lista de Deudas OK");
                messages.add(message);
                response = new Pantalla1ListResponse(httpStatus.value(), messages, pantalla1ModelList);
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
    @ApiOperation(value = "procesarPago", notes = "Procesa pago de deudas")
    @PutMapping(path = "/procesar-pago", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> procesarPago(@Valid @RequestBody Pantalla1Request pantalla1Request) {
        HttpStatus httpStatus;
        BaseResponse response;
        MessageResponse message;
        List<MessageResponse> messages = new ArrayList<>();
        try {
            if (deudasService.procesarPago(pantalla1Request.getServicioId(), pantalla1Request.getFactura())) {
                httpStatus = HttpStatus.OK;
                message = new MessageResponse(StatusLevel.INFO, "Pago procesado OK");
                messages.add(message);
                response = new BaseResponse(httpStatus.value(), messages);
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
