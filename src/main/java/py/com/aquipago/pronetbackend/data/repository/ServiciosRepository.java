package py.com.aquipago.pronetbackend.data.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import py.com.aquipago.pronetbackend.data.entity.Servicios;

@Repository("serviciosRepository")
public interface ServiciosRepository extends JpaRepository<Servicios, Long> {

}
