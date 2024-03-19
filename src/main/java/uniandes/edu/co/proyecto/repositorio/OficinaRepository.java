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

    @Query(value = "SELECT * FROM oficinas", nativeQuery = true)
    Collection<Oficina> darOficinas();

    @Query(value = "SELECT * FROM oficinas WHERE numero_oficina = :numero_oficina", nativeQuery = true)
    Oficina buscarOficinaPorNumero(@Param("numero_oficina") Integer numero_oficina);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO oficinas (numero_oficina, servicios_ofrecidos) VALUES (:numero_oficina, :servicios_ofrecidos)", nativeQuery = true)
    void insertarOficina(@Param("numero_oficina") Integer numero_oficina, @Param("servicios_ofrecidos") String servicios_Ofrecidos);

    @Modifying
    @Transactional
    @Query(value = "UPDATE oficinas SET servicios_ofrecidos = :servicios_ofrecidos WHERE numero_oficina = :numero_oficina", nativeQuery = true)
    void actualizarServiciosOfrecidos(@Param("numero_oficina") Integer numero_oficina, @Param("servicios_ofrecidos") String servicios_Ofrecidos);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM oficinas WHERE numero_oficina = :numero_oficina", nativeQuery = true)
    void eliminarOficina(@Param("numero_oficina") Integer numero_oficina);
}

