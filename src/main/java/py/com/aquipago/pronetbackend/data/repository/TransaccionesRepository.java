package py.com.aquipago.pronetbackend.data.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import py.com.aquipago.pronetbackend.data.entity.Transacciones;

import java.util.Date;
import java.util.List;

@Repository("transaccionesRepository")
public interface TransaccionesRepository extends JpaRepository<Transacciones, Long> {

    @Query(value = "SELECT u FROM Transacciones u WHERE u.fecha BETWEEN :startDate AND :endDate")
    Page<Transacciones> findByRangoFecha(@Param("startDate") Date startDate, @Param("endDate") Date endDate, Pageable pageable);

//    @Query(value = "SELECT u FROM Transacciones u WHERE u.fecha BETWEEN :startDate AND :endDate GROUP BY u.deudas.deudasPK.servicioId")
//    Page<Transacciones> findByRangoFechaGroupBy(@Param("startDate") Date startDate, @Param("endDate") Date endDate, Pageable pageable);

    @Query(value = "SELECT u FROM Transacciones u WHERE u.fecha BETWEEN :startDate AND :endDate")
    List<Transacciones> findByRangoFecha(@Param("startDate") Date startDate, @Param("endDate") Date endDate);
}
