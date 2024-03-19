package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.Usuario;
import uniandes.edu.co.proyecto.repositorio.UsuarioRepository;



@Controller
public class UsuarioController {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/usuarios")
    public String usuarios(Model model){

        model.addAttribute("usuarios", usuarioRepository.darUsuarios());
        return "usuarios";

    }

    @GetMapping("/usuarios/new")
    public String usuarioForm(Model model){

        model.addAttribute("usuario", new Usuario());
        return "usuarioNuevo";
        
    }

    @PostMapping("/usuarios/new/save")
    public String usuarioGuardar(@ModelAttribute Usuario usuario){
        usuarioRepository.insertarUsuario(usuario.getNombre(), usuario.getLogin(), usuario.getPalabra_clave(), usuario.getNacionalidad(), usuario.getDireccion(), usuario.getTelefono(), usuario.getCiudad(), usuario.getCodigo_postal(), usuario.getRol());
        return "redirect:/usuarios";
    }

    @GetMapping("/usuarios/{id}/edit")
    public String usuarioEditarForm(@PathVariable("id") Integer id, Model model) {
        Usuario usuario = usuarioRepository.darUsuario(id);
      if(usuario != null){
            model.addAttribute("usuario", usuario);
            return "usuarioEditar";
    } else{
        return "redirect:/usuarios";
    }
    }
    
    @PostMapping("/usuarios/{id}/edit/save")
    public String usuarioEditarGuardar(@PathVariable("id") Integer id, @ModelAttribute Usuario usuario){
        usuarioRepository.actualizarUsuario(id, usuario.getNombre(), usuario.getLogin(), usuario.getPalabra_clave(), usuario.getNacionalidad(), usuario.getDireccion(), usuario.getTelefono(), usuario.getCiudad(), usuario.getCodigo_postal(), usuario.getRol());
        return "redirect:/usuarios";
    }

    @GetMapping("/usuarios/{id}/delete")
    public String usuarioEliminar(@PathVariable("id") Integer id) {
        usuarioRepository.eliminarUsuario(id);
        return "redirect:/usuarios";
    }
    

    }
