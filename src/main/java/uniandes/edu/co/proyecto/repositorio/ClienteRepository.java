package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    public interface RespuestaInformacionCliente {
        String getTipo_cliente();
        String getNombre_usuario();
        Long getNumero_cuentas();
        String getOficinas();
        Long getNumero_prestamos();
        String getSaldos_cuentas();
    }

    @Query(value = "SELECT * FROM clientes", nativeQuery = true)
    Collection<Cliente> darClientes();

    @Query(value = "SELECT * FROM clientes WHERE id= :id", nativeQuery = true)
    Cliente darCliente(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO clientes (id, tipo_cliente) VALUES (:id, :tipoCliente)", nativeQuery = true)
    void insertarCliente(@Param("id") Integer id, @Param("tipoCliente") String tipoCliente);

    @Modifying
    @Transactional
    @Query(value = "UPDATE clientes SET tipo_cliente=:tipoCliente WHERE id=:id", nativeQuery = true)
    void actualizarCliente(@Param("id") Integer id, @Param("tipoCliente") String tipoCliente);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM clientes WHERE id = :id", nativeQuery = true)
    void eliminarCliente(@Param("id") Integer id);

    @Query(value = "SELECT " +
    "C.tipo_cliente AS tipo_cliente, " +
    "U.NOMBRE AS nombre_usuario, " +
    "COUNT(CU.ID) AS numero_cuentas, " +
    "LISTAGG(O.NUMERO_OFICINA, ', ') WITHIN GROUP (ORDER BY O.NUMERO_OFICINA) AS oficinas, " +
    "COUNT(P.ID_PRESTAMO) AS numero_prestamos, " +
    "LISTAGG(CU.SALDO, ', ') WITHIN GROUP (ORDER BY CU.ID) AS saldos_cuentas " +
    "FROM " +
    "CLIENTES C " +
    "LEFT JOIN " +
    "USUARIOS U ON C.ID = U.ID " +
    "LEFT JOIN " +
    "CUENTAS CU ON C.ID = CU.CLIENTE_ID " +
    "LEFT JOIN " +
    "OFICINAS O ON CU.OFICINA = O.NUMERO_OFICINA " +
    "LEFT JOIN " +
    "PRESTAMOS P ON C.ID = P.ID_CLIENTE " +
    "WHERE " +
    "C.ID = :id_cliente " +
    "GROUP BY " +
    "C.TIPO_CLIENTE, U.NOMBRE", nativeQuery = true)
    Collection<RespuestaInformacionCliente> obtenerInformacionCliente(@Param("id_cliente") Integer idCliente);
}
