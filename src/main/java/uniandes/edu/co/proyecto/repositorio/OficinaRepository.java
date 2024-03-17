package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Oficina;

import java.util.Collection;

@Repository
public interface OficinaRepository extends JpaRepository<Oficina, Integer> {

    @Query(value = "SELECT * FROM oficina", nativeQuery = true)
    Collection<Oficina> darOficinas();

    @Query(value = "SELECT * FROM oficina WHERE numeroOficina = :numeroOficina", nativeQuery = true)
    Oficina buscarOficinaPorNumero(@Param("numeroOficina") Integer numeroOficina);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO oficina (numeroOficina, serviciosOfrecidos) VALUES (:numeroOficina, :serviciosOfrecidos)", nativeQuery = true)
    void insertarOficina(@Param("numeroOficina") Integer numeroOficina, @Param("serviciosOfrecidos") String serviciosOfrecidos);

    @Modifying
    @Transactional
    @Query(value = "UPDATE oficina SET serviciosOfrecidos = :serviciosOfrecidos WHERE numeroOficina = :numeroOficina", nativeQuery = true)
    void actualizarServiciosOfrecidos(@Param("numeroOficina") Integer numeroOficina, @Param("serviciosOfrecidos") String serviciosOfrecidos);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM oficina WHERE numeroOficina = :numeroOficina", nativeQuery = true)
    void eliminarOficina(@Param("numeroOficina") Integer numeroOficina);
}
