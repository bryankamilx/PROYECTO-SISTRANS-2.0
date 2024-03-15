package uniandes.edu.co.proyecto;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uniandes.edu.co.proyecto.modelo.Usuario;
import uniandes.edu.co.proyecto.repositorio.UsuarioRepository;


@Service
public class Prueba {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Collection<Usuario> prueba(){

         return usuarioRepository.darUsuarios();

        
    }

    
}
