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
}
