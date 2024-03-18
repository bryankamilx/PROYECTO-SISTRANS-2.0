package uniandes.edu.co.proyecto.repositorio;


import java.sql.Date;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Operacion;


public interface OperacionRepository extends JpaRepository<Operacion,Integer> {

    @Query(value = "SELECT * FROM operaciones", nativeQuery = true)
    Collection<Operacion> darOperaciones();

    @Query(value = "SELECT * FROM operaciones WHERE id= :id", nativeQuery = true)
    Operacion darOperacion(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO operaciones (id, tipo, id_usuario, producto, valor, fecha_hora) VALUES(operaciones_seq.nextval, :tipo, :id_usuario, :producto, :valor, :fecha_hora)", nativeQuery = true)
    void insertarOperacion(@Param("tipo") String tipo, 
    @Param("id_usuario") Integer id_usuario, @Param("producto") String producto, 
    @Param("valor") Integer valor, @Param("fecha_hora") Date fecha_hora);
    
    @Modifying
    @Transactional
    @Query(value = "UPDATE operaciones SET tipo= :tipo, id_usuario= :id_usuario, producto= :producto, valor= :valor, fecha_hora= :fecha_hora WHERE id= :id", nativeQuery = true)
    void actualizarOperacion(@Param("id") Integer id, @Param("tipo") String tipo, 
    @Param("id_usuario") Integer id_usuario, @Param("producto") String producto, 
    @Param("valor") Integer valor, @Param("fecha_hora") Date fecha_hora);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM operaciones WHERE id= :id", nativeQuery = true)
    void eliminarOperacion(@Param("id") Integer id);
}
