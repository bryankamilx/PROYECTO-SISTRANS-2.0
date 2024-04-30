package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Cuenta;
import uniandes.edu.co.proyecto.modelo.OperacionCuenta;
import java.util.List;


public interface OperacionCuentaRepository extends JpaRepository<OperacionCuenta, Integer> {

    public interface ExtractoCuenta {
        Integer getId();
        Integer getNum_cuenta();
        String getDetalle();
    }   

    @Query(value = "SELECT * FROM operaciones_cuentas", nativeQuery = true)
    Collection<OperacionCuenta> darOperacionesCuenta();

    @Query(value = "SELECT * FROM operaciones_cuentas WHERE id= :id", nativeQuery = true)
    OperacionCuenta darOperacionCuenta(@Param("id") int id);

    @Query(value = "SELECT * FROM operaciones_cuentas WHERE id= :id FOR UPDATE", nativeQuery = true)
    OperacionCuenta darOperacionCuentaEspera(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO operaciones_cuentas (id, cuenta, detalle) VALUES(:id, :cuenta, :detalle)", nativeQuery = true)
    void insertarOperacionCuenta(@Param("id") Integer id, @Param("cuenta") Integer num_cuenta, @Param("detalle") String detalle);

    @Modifying
    @Transactional
    @Query(value = "UPDATE operaciones_cuentas SET cuenta= :cuenta, detalle= :detalle WHERE id= :id", nativeQuery = true)
    void actualizarOperacionCuenta(@Param("id") Integer id, @Param("cuenta") Integer cuenta, @Param("detalle") String detalle);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM operaciones_cuentas WHERE id= :id", nativeQuery = true)
    void eliminarOperacionCuenta(@Param("id") Integer id);

    List<OperacionCuenta> findByCuenta(Integer cuenta);
}
