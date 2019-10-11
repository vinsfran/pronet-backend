package py.com.aquipago.pronetbackend.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import py.com.aquipago.pronetbackend.data.entity.Clientes;

import java.util.List;

@Repository("clientesRepository")
public interface ClientesRepository extends JpaRepository<Clientes, Long> {

    @Query(value = "SELECT DISTINCT(u.tipoDocumento) FROM Clientes u")
    List<String> getTipoDocumentos();
}
