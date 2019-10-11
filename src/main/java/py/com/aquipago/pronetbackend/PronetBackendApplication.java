package py.com.aquipago.pronetbackend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import py.com.aquipago.pronetbackend.data.dto.Pantalla1DTO;
import py.com.aquipago.pronetbackend.data.mapper.DeudasMapper;

import java.text.SimpleDateFormat;
import java.util.List;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan("py.com.aquipago.pronetbackend.data.mapper")
public class PronetBackendApplication implements CommandLineRunner {

    @Autowired
    private DeudasMapper deudasMapper;

    public static void main(String[] args) {
        SpringApplication.run(PronetBackendApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

//        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
//
//        List<Pantalla1DTO> pantalla1DTOList = deudasMapper.listPantalla1("PE", null, null, "ANDE");
//
//        for (Pantalla1DTO pantalla1DTO : pantalla1DTOList) {
//            System.out.println(pantalla1DTO.getServicioId() + " " + pantalla1DTO.getFactura() + " " + pantalla1DTO.getNombreCompleto() + " " + pantalla1DTO.getVencimiento() + " " + pantalla1DTO.getImporte());
//        }

    }
}
