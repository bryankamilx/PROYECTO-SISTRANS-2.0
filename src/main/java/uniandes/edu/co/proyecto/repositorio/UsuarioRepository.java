package uniandes.edu.co.proyecto.repositorio;
import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    @Query(value = "SELECT * FROM usuarios", nativeQuery = true)
    Collection<Usuario> darUsuarios();

    @Query(value = "SELECT * FROM usuarios WHERE id= :id", nativeQuery = true)
    Usuario darUsuario(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO usuarios (id,nombre,login,palabra_clave,nacionalidad,direccion,telefono,ciudad,codigo_postal,rol) VALUES(usuarios_seq.nextval,:nombre,:login,:palabra_clave,:nacionalidad,:direccion,:telefono,:ciudad,:codigo_postal,:rol)",nativeQuery=true)
    void insertarUsuario(@Param("nombre") String nombre,@Param("login") String login,@Param("palabra_clave") String palabra_clave,@Param("nacionalidad") String nacionalidad,@Param("direccion") String direccion,@Param("telefono") String telefono,@Param("ciudad") String ciudad,@Param("codigo_postal") String codigo_postal,@Param("rol") String rol);

    @Modifying
    @Transactional
    @Query(value = "UPDATE usuarios SET id=:id,nombre=:nombre,login=:login,palabra_clave=:palabra_clave,nacionalidad=:nacionalidad,direccion=:direccion,telefono=:telefono,ciudad=:ciudad,codigo_postal=:codigo_postal,rol=:rol WHERE id=:id", nativeQuery = true)
    void actualizarUsuario(@Param("id") Integer id,@Param("nombre") String nombre,@Param("login") String login,@Param("palabra_clave") String palabra_clave,@Param("nacionalidad") String nacionalidad,@Param("direccion") String direccion,@Param("telefono") String telefono,@Param("ciudad") String ciudad,@Param("codigo_postal") String codigo_postal,@Param("rol") String rol);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM usuarios WHERE id = :id", nativeQuery = true)
    void eliminarUsuario(@Param("id") Integer id);
 }