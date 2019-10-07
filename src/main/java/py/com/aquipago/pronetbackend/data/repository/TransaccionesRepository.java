package py.com.aquipago.pronetbackend.data.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import py.com.aquipago.pronetbackend.data.entity.Transacciones;

@Repository("transaccionesRepository")
public interface TransaccionesRepository extends JpaRepository<Transacciones, Long> {

}
