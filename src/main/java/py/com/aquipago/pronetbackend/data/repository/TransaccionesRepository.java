package py.com.aquipago.pronetbackend.data.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import py.com.aquipago.pronetbackend.data.entity.Transacciones;

import java.util.Date;

@Repository("transaccionesRepository")
public interface TransaccionesRepository extends JpaRepository<Transacciones, Long> {

    @Query(value = "select u from Transacciones u where u.fecha BETWEEN :startDate and :endDate")
    Page<Transacciones> findByRangoFecha(@Param("startDate") Date startDate, @Param("endDate") Date endDate, Pageable pageable);

}
