package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Cuenta;

import java.util.Collection;

@Repository
public interface CuentaRepository extends JpaRepository<Cuenta, Integer> {

    @Query(value = "SELECT * FROM cuenta", nativeQuery = true)
    Collection<Cuenta> darCuentas();

    @Query(value = "SELECT * FROM cuenta WHERE numeroCuenta = :numeroCuenta AND tipoCuenta = :tipoCuenta", nativeQuery = true)
    Cuenta buscarCuentaPorNumeroYTipo(@Param("numeroCuenta") Integer numeroCuenta, @Param("tipoCuenta") String tipoCuenta);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO cuenta (numeroCuenta, tipoCuenta, saldo, estado, idCliente) VALUES (:numeroCuenta, :tipoCuenta, :saldo, :estado, :idCliente)", nativeQuery = true)
    void insertarCuenta(@Param("numeroCuenta") Integer numeroCuenta, @Param("tipoCuenta") String tipoCuenta, @Param("saldo") Double saldo, @Param("estado") String estado, @Param("idCliente") Integer idCliente);

    @Modifying
    @Transactional
    @Query(value = "UPDATE cuenta SET saldo = :saldo, estado = :estado, idCliente = :idCliente WHERE numeroCuenta = :numeroCuenta AND tipoCuenta = :tipoCuenta", nativeQuery = true)
    void actualizarCuenta(@Param("numeroCuenta") Integer numeroCuenta, @Param("tipoCuenta") String tipoCuenta, @Param("saldo") Double saldo, @Param("estado") String estado, @Param("idCliente") Integer idCliente);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM cuenta WHERE numeroCuenta = :numeroCuenta AND tipoCuenta = :tipoCuenta", nativeQuery = true)
    void eliminarCuenta(@Param("numeroCuenta") Integer numeroCuenta, @Param("tipoCuenta") String tipoCuenta);
}
