package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.OperacionPrestamo;

public interface OperacionPrestamoRepository extends JpaRepository<OperacionPrestamo, Integer> {
    
    @Query(value = "SELECT * FROM operaciones_prestamos", nativeQuery = true)
    Collection<OperacionPrestamo> darOperacionesPrestamos();

    @Query(value = "SELECT * FROM operaciones_prestamos WHERE id= :id", nativeQuery = true)
    OperacionPrestamo darOperacionPrestamo(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO operaciones_prestamos (id, detalle_pago, id_prestamo) VALUES(:id, :detalle_pago, :id_prestamo)", nativeQuery = true)
    void insertarOperacionPrestamo(@Param("id") Integer id, @Param("detalle_pago") String detalle_pago, @Param("id_prestamo") Integer id_prestamo);

    @Modifying
    @Transactional
    @Query(value = "UPDATE operaciones_prestamos SET detalle_pago= :detalle_pago, id_prestamo= :id_prestamo WHERE id= :id", nativeQuery = true)
    void actualizarOperacionPrestamo(@Param("id") Integer id, @Param("detalle_pago") String detalle_pago, @Param("id_prestamo") Integer id_prestamo);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM operaciones_prestamos WHERE id= :id", nativeQuery = true)
    void eliminarOperacionPrestamo(@Param("id") Integer id);

}
