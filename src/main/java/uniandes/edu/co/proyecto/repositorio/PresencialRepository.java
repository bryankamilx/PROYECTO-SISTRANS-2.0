package uniandes.edu.co.proyecto.repositorio;

import java.sql.Timestamp;
import java.util.Collection;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;
import uniandes.edu.co.proyecto.modelo.Presencial;

public interface PresencialRepository extends JpaRepository<Presencial, Integer>{
    
    @Query(value = "SELECT * FROM presenciales", nativeQuery = true)
    Collection<Presencial> darPresenciales();

    @Query(value = "SELECT * FROM presenciales WHERE id = :id", nativeQuery = true)
    Presencial darPresencial(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO presenciales (id, cajeros_disponibles, horario_atencion_inicio, horario_atencion_fin, numerooficina) VALUES ( puntos_atencion_seq.nextval , :cajeros_disponibles, :horario_atencion_inicio, :horario_atencion_fin, :numerooficina)", nativeQuery = true)
    void insertarPresencial(@Param("cajeros_disponibles") Integer cajeros_disponibles, @Param("horario_atencion_inicio") Timestamp horario_atencion_inicio, @Param("horario_atencion_fin") Timestamp horario_atencion_fin, @Param("numerooficina") Integer numerooficina);

    @Modifying
    @Transactional
    @Query(value = "UPDATE presenciales SET cajeros_disponibles = :cajeros_disponibles , horario_atencion_inicio = :horario_atencion_inicio , horario_atencion_fin = :horario_atencion_fin, numerooficina = :numerooficina WHERE id = :id", nativeQuery = true)
    void actualizarPresencial(@Param("id") Integer id, @Param("cajeros_disponibles") Integer cajeros_disponibles, @Param("horario_atencion_inicio") Timestamp horario_atencion_inicio, @Param("horario_atencion_fin") Timestamp horario_atencion_fin, @Param("numerooficina") Integer numerooficina);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM presenciales WHERE id = :id", nativeQuery = true)
    void eliminarPresencial(@Param("id") Integer id);
    
}
