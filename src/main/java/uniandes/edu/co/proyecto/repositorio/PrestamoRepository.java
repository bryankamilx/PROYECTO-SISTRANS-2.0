package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Prestamo;

@Repository
public interface PrestamoRepository extends JpaRepository<Prestamo, Integer> {

    @Query(value = "SELECT * FROM prestamos", nativeQuery = true)
    Collection<Prestamo> darPrestamos();

    @Query(value = "SELECT * FROM prestamos WHERE id = :id", nativeQuery = true)
    Prestamo darPrestamo(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO prestamos (id_prestamo, id_cliente, tipo_prestamo, estado) VALUES (prestamos_seq.nextval, :idCliente, :tipoPrestamo, :estado)", nativeQuery = true)
    void insertarPrestamo(@Param("idCliente") Integer idCliente, @Param("tipoPrestamo") String tipoPrestamo, @Param("estado") String estado);    

    @Modifying
    @Transactional
    @Query(value = "UPDATE prestamos SET id_cliente = :id_cliente, tipo_prestamo = :tipoPrestamo, estado = :estado WHERE id = :id", nativeQuery = true)
    void actualizarPrestamo(@Param("id") Integer id, @Param("id_cliente") Integer idCliente, @Param("tipoPrestamo") String tipoPrestamo, @Param("estado") String estado);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM prestamos WHERE id = :id", nativeQuery = true)
    void eliminarPrestamo(@Param("id") Integer id);
}
