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

    public interface ExtractoCuenta {
        Integer getOperacionId();
        Integer getNumeroCuenta();
        String getDetalle();
    }

    @Query(value = "SELECT * FROM cuentas", nativeQuery = true)
    Collection<Cuenta> darCuentas();

    @Query(value = "SELECT * FROM cuentas WHERE id= :id", nativeQuery = true)
    Cuenta darCuenta(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO cuentas (id, tipo, estado, saldo, cliente_id, oficina) VALUES (cuentas_seq.nextval, :tipo, :estado, :saldo, :cliente_id, :oficina)", nativeQuery = true)
    void insertarCuenta(@Param("tipo") String tipo, @Param("estado") String estado, @Param("saldo") int saldo, @Param("cliente_id") int clienteId, @Param("oficina") int oficina);

    @Modifying
    @Transactional
    @Query(value = "UPDATE cuentas SET tipo = :tipo, estado = :estado, saldo = :saldo, cliente_id = :cliente_id, oficina = :oficina WHERE id = :id", nativeQuery = true)
    void actualizarCuenta(@Param("id") Integer id, @Param("tipo") String tipo, @Param("estado") String estado, @Param("saldo") int saldo, @Param("cliente_id") int clienteId, @Param("oficina") int oficina);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM cuentas WHERE id = :id", nativeQuery = true)
    void eliminarCuenta(@Param("id") Integer id);

    //Método para buscar cuentas por tipo de cuenta
    Collection<Cuenta> findByTipo(String tipo);

    // Método para buscar cuentas por estado
    Collection<Cuenta> findByEstado(String estado);

    // Método para buscar cuentas por saldo mayor o igual a un valor dado
    Collection<Cuenta> findBySaldoGreaterThanEqual(int saldo);
   
}
