package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;
import uniandes.edu.co.proyecto.modelo.Virtual;

public interface VirtualRepository extends JpaRepository<Virtual, Integer>{
    
    @Query(value = "SELECT * FROM virtuales", nativeQuery = true)
    Collection<Virtual> darVirtuales();

    @Query(value = "SELECT * FROM virtuales WHERE id = :id", nativeQuery = true)
    Virtual darVirtual(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO virtuales (id, plataforma) VALUES ( puntos_atencion_seq.nextval , :plataforma)", nativeQuery = true)
    void insertarVirtual( @Param("plataforma") String plataforma);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO puntos_atencion (id, tipo_punto, direccion) VALUES ( puntos_atencion_seq.currval , 'Virtual', '')", nativeQuery = true)
    void insertarPunto_atencion();

    @Modifying
    @Transactional
    @Query(value = "UPDATE virtuales SET plataforma = :plataforma WHERE id = :id", nativeQuery = true)
    void actualizarVirtual(@Param("id") Integer id, @Param("plataforma") String plataforma);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM virtuales WHERE id = :id", nativeQuery = true)
    void eliminarVirtual(@Param("id") Integer id);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(value = "DELETE FROM puntos_atencion WHERE id = :id", nativeQuery = true)
    void eliminarPunto_atencion(@Param("id") Integer id);
    
} 
