package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;
import uniandes.edu.co.proyecto.modelo.Punto_atencion;


public interface Punto_atencionRepository extends JpaRepository<Punto_atencion, Integer>{
    
    @Query(value = "SELECT * FROM puntos_atencion", nativeQuery = true)
    Collection<Punto_atencion> darPuntosAtencion();


    @Query(value = "SELECT * FROM puntos_atencion WHERE id = :id", nativeQuery = true)
    Punto_atencion darPunto_atencion(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO puntos_atencion (id, direccion, tipoPunto) VALUES ( parranderos_sequence.nextval , :direccion, :tipoPunto)", nativeQuery = true)
    void insertarPuntos_atencion(@Param("direccion") String direcion, @Param("tipoPunto") String tipoPunto);

    @Modifying
    @Transactional
    @Query(value = "UPDATE puntos_atencion SET direccion = :direccion, tipoPunto = :tipoPunto WHERE id = :id", nativeQuery = true)
    void actualizarPuntos_atencion(@Param("id") Integer id, @Param("direccion") String direccion, @Param("tipoPunto") String tipoPunto);


    @Modifying
    @Transactional
    @Query(value = "DELETE FROM puntos_atencion WHERE id = :id", nativeQuery = true)
    void eliminarPuntos_atencion(@Param("id") Integer id);
}

