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
    @Query(value = "INSERT INTO virtuales (id, direccion, tipoPunto, plataforma) VALUES ( parranderos_sequence.nextval , :direccion, :tipoPunto, :plataforma)", nativeQuery = true)
    void insertarVirtual(@Param("direccion") String direcion, @Param("tipoPunto") String tipoPunto, @Param("plataforma") String plataforma);

    @Modifying
    @Transactional
    @Query(value = "UPDATE virtuales SET direccion = :direccion, tipoPunto = :tipoPunto, plataforma = :plataforma WHERE id = :id", nativeQuery = true)
    void actualizarVirtual(@Param("id") Integer id, @Param("direccion") String direccion, @Param("tipoPunto") String tipoPunto, @Param("plataforma") String plataforma);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM virtuales WHERE id = :id", nativeQuery = true)
    void eliminarVirtual(@Param("id") Integer id);
    
} 
