package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;
import uniandes.edu.co.proyecto.modelo.Cajero;

public interface CajeroRepository extends JpaRepository<Cajero, Integer>{
    
    @Query(value = "SELECT * FROM cajeros", nativeQuery = true)
    Collection<Cajero> darCajeros();

    @Query(value = "SELECT * FROM cajeros WHERE id = :id", nativeQuery = true)
    Cajero darCajero(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO cajeros (id, tipo_Punto, direcccion, monto_disponible, limite_retiro) VALUES ( puntos_atencion_seq.nextval , :tipo_Punto, :direccion, :monto_disponible, :limite_retiro)", nativeQuery = true)
    void insertarCajero(@Param("tipo_Punto") String tipo_Punto, @Param("direccion") String direcion, @Param("monto_disponible") Integer monto_disponible, @Param("limite_retiro") Integer limite_retiro);

    @Modifying
    @Transactional
    @Query(value = "UPDATE cajeros SET tipo_Punto = :tipo_Punto, direccion = :direccion, monto_disponible = :monto_disponible , limite_retiro = :limite_retiro WHERE id = :id", nativeQuery = true)
    void actualizarCajero(@Param("id") Integer id, @Param("tipo_Punto") String tipo_Punto, @Param("direccion") String direccion, @Param("monto_disponible") Integer monto_disponible, @Param("limite_retiro") Integer limite_retiro);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM cajeros WHERE id = :id", nativeQuery = true)
    void eliminarCajero(@Param("id") Integer id);
    
}
