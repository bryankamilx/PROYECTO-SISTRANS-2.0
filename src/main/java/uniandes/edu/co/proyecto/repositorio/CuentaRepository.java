package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Cuenta;

@Repository
public interface CuentaRepository extends JpaRepository<Cuenta, Integer> {

    @Query(value = "SELECT * FROM cuentas", nativeQuery = true)
    Collection<Cuenta> darCuentas();

    @Query(value = "SELECT * FROM cuentas WHERE id= :id", nativeQuery = true)
    Cuenta darCuenta(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO cuentas (id, tipo_cuenta, estado, saldo, cliente_id, oficina) VALUES (cuentas_seq.nextval, :tipo_cuenta, :estado, :saldo, :cliente_id, :oficina)", nativeQuery = true)
    void insertarCuenta(@Param("tipo_cuenta") String tipoCuenta, @Param("estado") String estado, @Param("saldo") int saldo, @Param("cliente_id") int clienteId, @Param("oficina") int oficina);

    @Modifying
    @Transactional
    @Query(value = "UPDATE cuentas SET tipo_cuenta = :tipo_cuenta, estado = :estado, saldo = :saldo, cliente_id = :cliente_id, oficina = :oficina WHERE id = :id", nativeQuery = true)
    void actualizarCuenta(@Param("id") Integer id, @Param("tipo_cuenta") String tipoCuenta, @Param("estado") String estado, @Param("saldo") int saldo, @Param("cliente_id") int clienteId, @Param("oficina") int oficina);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM cuentas WHERE id = :id", nativeQuery = true)
    void eliminarCuenta(@Param("id") Integer id);

   
}
