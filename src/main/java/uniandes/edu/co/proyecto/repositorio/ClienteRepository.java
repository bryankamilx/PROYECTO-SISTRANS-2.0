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
        Integer getCliente_id();
        String getTipo_cliente();
        String getNombre_usuario();
        Long getNumero_cuentas();
        Long getNumero_prestamos();
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

    @Query(value = "SELECT c.id AS cliente_id, c.tipo_cliente, u.nombre AS nombre_usuario, " +
            "COUNT(cuentas.id) AS numero_cuentas, COUNT(prestamos.id_prestamo) AS numero_prestamos " +
            "FROM clientes c " +
            "LEFT JOIN usuarios u ON c.id = u.id " +
            "LEFT JOIN cuentas cuentas ON c.id = cuentas.cliente_id " +
            "LEFT JOIN prestamos prestamos ON c.id = prestamos.id_cliente " +
            "WHERE c.id = :id_cliente " +
            "GROUP BY c.id, c.tipo_cliente, u.nombre", nativeQuery = true)
    Collection<RespuestaInformacionCliente> obtenerInformacionCliente(@Param("id_cliente") Integer idCliente);
}
