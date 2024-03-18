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
    @Query(value = "INSERT INTO virtuales (id, tipo_Punto, direcccion, plataforma) VALUES ( puntos_atencion_seq.nextval , :tipo_Punto, :direccion, :plataforma)", nativeQuery = true)
    void insertarVirtual(@Param("tipo_Punto") String tipo_Punto, @Param("direccion") String direcion, @Param("plataforma") String plataforma);

    @Modifying
    @Transactional
    @Query(value = "UPDATE virtuales SET tipo_Punto = :tipo_Punto, direccion = :direccion, plataforma = :plataforma WHERE id = :id", nativeQuery = true)
    void actualizarVirtual(@Param("id") Integer id, @Param("tipo_Punto") String tipo_Punto, @Param("direccion") String direccion, @Param("plataforma") String plataforma);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM virtuales WHERE id = :id", nativeQuery = true)
    void eliminarVirtual(@Param("id") Integer id);
    
} 
