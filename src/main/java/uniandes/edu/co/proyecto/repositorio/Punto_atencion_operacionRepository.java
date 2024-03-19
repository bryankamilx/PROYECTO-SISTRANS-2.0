package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Operacion;
import uniandes.edu.co.proyecto.modelo.Punto_atencion_operacion;
import uniandes.edu.co.proyecto.modelo.Punto_atencion_operacionPK;

import java.sql.Date;
import java.util.Collection;


public interface Punto_atencion_operacionRepository  extends JpaRepository<Punto_atencion_operacion, Punto_atencion_operacionPK>{

    @Query(value = "SELECT * FROM puntos_atencion_operaciones", nativeQuery = true)
    Collection<Punto_atencion_operacion> darPuntos_atencion_operaciones();


    @Query(value = "SELECT * FROM puntos_atencion_operaciones WHERE punto_id = :punto_id AND operacion_id = :operacion_id", nativeQuery = true)
    Punto_atencion_operacion darPunto_atencion_operacionPorId(@Param("punto_id") Integer punto_id, @Param("operacion_id") Integer operacion_id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM puntos_atencion_operaciones WHERE punto_id = :punto_id AND operacion_id = :operacion_id", nativeQuery = true)
    void eliminarPunto_atencion_operacion(@Param("punto_id") Integer punto_id, @Param("operacion_id") Integer operacion_id);

    @Modifying  
    @Transactional
    @Query(value = "UPDATE puntos_atencion_operaciones SET punto_id = :punto_id_actualizado, operacion_id = :operacion_id_actualizado WHERE punto_id = :punto_id AND operacion_id = :operacion_id", nativeQuery = true)
    void actualizarPunto_atencion_operacion(@Param("punto_id") Integer punto_id, @Param("operacion_id") Integer operacion_id, @Param("punto_id_actualizado") Integer punto_id_actualizado, @Param("operacion_id_actualizado") Integer operacion_id_actualizado);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO puntos_atencion_operaciones (punto_id, operacion_id) VALUES (:punto_id, :operacion_id)", nativeQuery = true)
    void insertarPunto_atencion_operacion(@Param("punto_id") Integer punto_id, @Param("operacion_id") Integer operacion_id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO operaciones (id, tipo, id_usuario, producto, valor, fecha_hora) VALUES(operaciones_seq.nextval, :tipo, :id_usuario, :producto, :valor, :fecha_hora)", nativeQuery = true)
    void insertarOperacion(@Param("tipo") String tipo, 
    @Param("id_usuario") Integer id_usuario, @Param("producto") String producto, 
    @Param("valor") Integer valor, @Param("fecha_hora") Date fecha_hora);

    @Query(value = "SELECT * FROM operaciones WHERE id= :operaciones_seq.currval", nativeQuery = true)
    Operacion darUltimaOperacion();

}