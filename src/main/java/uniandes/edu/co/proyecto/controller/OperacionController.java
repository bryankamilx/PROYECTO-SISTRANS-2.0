package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import uniandes.edu.co.proyecto.modelo.Operacion;
import uniandes.edu.co.proyecto.repositorio.OperacionRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;




@Controller
public class OperacionController {
    
    @Autowired
    private OperacionRepository operacionRepository;

    @GetMapping("/operaciones")
    public String operaciones(Model model) {
        model.addAttribute("operaciones", operacionRepository.darOperaciones());
        return "operaciones";
    }

    @GetMapping("/operaciones/new")
    public String operacionForm(Model model) {
        model.addAttribute("operacion", new Operacion());
        return "operacionNueva";
    }

    @PostMapping("/operaciones/new/save")
    public String operacionGuardar(@ModelAttribute Operacion operacion) {
        operacionRepository.insertarOperacion(operacion.getTipo(),operacion.getId_usuario(), 
        operacion.getProducto(),operacion.getValor(), operacion.getFecha_hora());
        return "redirect:/operaciones";
    }
    
    @GetMapping("/operaciones/{id}/edit")
    public String operacionEditarForm(@PathVariable("id") Integer id, Model model) {
        Operacion operacion = operacionRepository.darOperacion(id);
        if(operacion != null){
            model.addAttribute("operacion", operacion);
            return "operacionEditar";
        } else {
            return "redirect:/operaciones";
        }
    }

    @PostMapping("/operaciones/{id}/edit/save")
    public String operacionEditarGuardar(@PathVariable("id") Integer id, @ModelAttribute Operacion operacion) {
        operacionRepository.actualizarOperacion(id,operacion.getTipo(), operacion.getId_usuario(),
         operacion.getProducto(), operacion.getValor(), operacion.getFecha_hora());
        return "redirect:/operaciones";
    }

    @GetMapping("/operaciones/{id}/delete")
    public String operacionEliminar(@PathVariable("id") Integer id) {
        operacionRepository.eliminarOperacion(id);
        return "redirect:/operaciones";
    }
    
}
