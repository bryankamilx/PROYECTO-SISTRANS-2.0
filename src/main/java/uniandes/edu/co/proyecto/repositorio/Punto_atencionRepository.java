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

        //Insertar puntos atencion

        @Modifying
        @Transactional
        @Query(value = "INSERT INTO puntos_atencion (id, tipo_punto, direccion) VALUES ( puntos_atencion_seq.nextval , :tipo_punto, :direccion)", nativeQuery = true)
        void insertarPunto_atencion(@Param("tipo_punto") String tipo_punto, @Param("direccion") String direccion);


        @Modifying
        @Transactional
        @Query(value = "INSERT INTO cajeros (id, monto_disponible, limite_retiro, numerooficina) VALUES (puntos_atencion_seq.currval, 0, 100, 1)", nativeQuery = true)
        void insertarCajero();
    
        @Modifying
        @Transactional
        @Query(value = "INSERT INTO presenciales (id, cajeros_disponibles, horario_atencion_inicio, horario_atencion_fin, numerooficina) VALUES (puntos_atencion_seq.currval, 0, NULL, NULL, 1)", nativeQuery = true)
        void insertarPresencial();
    
        @Modifying
        @Transactional
        @Query(value = "INSERT INTO virtuales (id, plataforma) VALUES (puntos_atencion_seq.currval, 'Web')", nativeQuery = true)
        void insertarVirtual();



        // Actualizar puntos atencion
        @Modifying
        @Transactional
        @Query(value = "UPDATE puntos_atencion SET direccion = :direccion WHERE id = :id", nativeQuery = true)
        void actualizarPunto_atencion(@Param("id") long id, @Param("direccion") String direccion);

        //Eliminar puntos atencion

        @Modifying
        @Transactional
        @Query(value = "DELETE FROM puntos_atencion WHERE id = :id", nativeQuery = true)
        void eliminarPunto_atencion(@Param("id") long id);


        @Modifying(clearAutomatically = true)
        @Transactional
        @Query(value = "DELETE FROM cajeros WHERE id = :id", nativeQuery = true)
        void eliminarCajero(@Param("id") long id);

        @Modifying(clearAutomatically = true)
        @Transactional
        @Query(value = "DELETE FROM presenciales WHERE id = :id", nativeQuery = true)
        void eliminarPresencial(@Param("id") long id);

        @Modifying(clearAutomatically = true)
        @Transactional
        @Query(value = "DELETE FROM virtuales WHERE id = :id", nativeQuery = true)
        void eliminarVirtual(@Param("id") long id);


        
}

