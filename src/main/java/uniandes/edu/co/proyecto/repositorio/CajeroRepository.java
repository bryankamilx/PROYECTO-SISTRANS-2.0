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
    // Agregar cajero
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO cajeros (id, monto_disponible, limite_retiro, numerooficina) VALUES ( puntos_atencion_seq.currval , :monto_disponible, :limite_retiro, :numerooficina)", nativeQuery = true)
    void insertarCajero( @Param("monto_disponible") Integer monto_disponible, @Param("limite_retiro") Integer limite_retiro, @Param("numerooficina") Integer numerooficina);


    @Modifying
    @Transactional
    @Query(value = "INSERT INTO puntos_atencion (id, tipo_punto, direccion) VALUES ( puntos_atencion_seq.nextval , 'Cajero', 'Direccion')", nativeQuery = true)
    void insertarPunto_atencion();


    // Actualizar cajero
    @Modifying
    @Transactional
    @Query(value = "UPDATE cajeros SET monto_disponible = :monto_disponible , limite_retiro = :limite_retiro , numerooficina = :numerooficina WHERE id = :id", nativeQuery = true)
    void actualizarCajero(@Param("id") Integer id, @Param("monto_disponible") Integer monto_disponible, @Param("limite_retiro") Integer limite_retiro, @Param("numerooficina") Integer numerooficina);


    //Eliminar cajero
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM cajeros WHERE id = :id", nativeQuery = true)
    void eliminarCajero(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM puntos_atencion WHERE id = :id", nativeQuery = true)
    void eliminarPunto_atencion(@Param("id") Integer id);
    
}
