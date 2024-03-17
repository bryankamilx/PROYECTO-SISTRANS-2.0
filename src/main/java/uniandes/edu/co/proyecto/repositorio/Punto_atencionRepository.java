package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Punto_atencion;

@Repository
public interface Punto_atencionRepository extends JpaRepository<Punto_atencion, Integer>{

        @Query(value = "SELECT * FROM puntos_atencion", nativeQuery = true)
        Collection<Punto_atencion> darPuntos_atencion();

        @Query(value = "SELECT * FROM puntos_atencion WHERE id = :id", nativeQuery = true)
        Punto_atencion darPuntos_atencion(@Param("id") int id);

        @Modifying
        @Transactional
        @Query(value = "INSERT INTO puntos_atencion (id, tipo_punto, direccion) VALUES ( puntos_atencion_seq.nextval , :tipo_punto, :direccion)", nativeQuery = true)
        void insertarPunto_atencion(@Param("tipo_punto") String tipo_punto, @Param("direccion") String direccion);

        @Modifying
        @Transactional
        @Query(value = "UPDATE puntos_atencion SET tipo_punto = :tipo_punto, direccion = :direccion WHERE id = :id", nativeQuery = true)
        void actualizarPunto_atencion(@Param("id") long id, @Param("tipo_punto") String tipo_punto, @Param("direccion") String direccion);


        @Modifying
        @Transactional
        @Query(value = "DELETE FROM puntos_atencion WHERE id = :id", nativeQuery = true)
        void eliminarPunto_atencion(@Param("id") long id);


        
}

