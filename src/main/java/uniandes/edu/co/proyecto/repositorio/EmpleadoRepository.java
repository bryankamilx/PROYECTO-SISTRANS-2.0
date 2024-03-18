package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.Empleado;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {

    @Query(value = "SELECT * FROM empleados", nativeQuery = true)
    Collection<Empleado> darEmpleados();

    @Query(value = "SELECT * FROM empleados WHERE id= :id", nativeQuery = true)
    Empleado darEmpleado(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO empleados (id, numero_oficina) VALUES (:id, :numeroOficina)", nativeQuery = true)
    void insertarEmpleado(@Param("id") Integer id, @Param("numeroOficina") String numeroOficina);

    @Modifying
    @Transactional
    @Query(value = "UPDATE empleados SET numero_oficina=:numeroOficina WHERE id=:id", nativeQuery = true)
    void actualizarEmpleado(@Param("id") Integer id, @Param("numeroOficina") String numeroOficina);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM empleados WHERE id = :id", nativeQuery = true)
    void eliminarEmpleado(@Param("id") Integer id);
}
