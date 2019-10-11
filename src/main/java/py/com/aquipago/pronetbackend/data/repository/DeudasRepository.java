package py.com.aquipago.pronetbackend.data.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import py.com.aquipago.pronetbackend.data.entity.Deudas;
import py.com.aquipago.pronetbackend.data.entity.DeudasPK;

@Repository("deudasRepository")
public interface DeudasRepository extends JpaRepository<Deudas, Long> {

    Deudas findByDeudasPK(DeudasPK deudasPK);
}
