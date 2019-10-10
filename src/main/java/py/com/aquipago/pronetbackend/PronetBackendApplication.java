package py.com.aquipago.pronetbackend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import py.com.aquipago.pronetbackend.data.entity.Transacciones;
import py.com.aquipago.pronetbackend.data.repository.TransaccionesRepository;
import py.com.aquipago.pronetbackend.service.impl.TransaccionesServiceImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan("py.com.aquipago.pronetbackend.data.mapper")
public class PronetBackendApplication implements CommandLineRunner {

    @Autowired
    @Qualifier("transaccionesServiceImpl")
    private TransaccionesServiceImpl transaccionesServiceImpl;

    public static void main(String[] args) {
        SpringApplication.run(PronetBackendApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

        transaccionesServiceImpl.findByRangoFechaPantall3(formato.parse("2019-10-01"), new Date());

//        List<Transacciones> transacciones = transaccionesServiceImpl.findByRangoFechaPantall3(formato.parse("2019-10-01"), new Date());
//
//        for (Transacciones transaccion : transacciones) {
//            System.out.println(transaccion.getId());
//            System.out.println(transaccion.getImporte());
//        }

    }
}
