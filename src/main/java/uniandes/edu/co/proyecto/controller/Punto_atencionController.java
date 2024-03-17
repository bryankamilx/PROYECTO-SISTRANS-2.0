package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import uniandes.edu.co.proyecto.modelo.Punto_atencion;
import uniandes.edu.co.proyecto.repositorio.Punto_atencionRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class Punto_atencionController {

    @Autowired
    private Punto_atencionRepository punto_atencionRepository;

    @GetMapping("/puntos_atencion")
    public String puntos_atencion(Model model) {
        model.addAttribute("puntos_atencion", punto_atencionRepository.darPuntosAtencion());

        return "puntos_atencion";
    }

    @GetMapping("/puntos_atencion/new")
    public String punto_atencionForm(Model model) {
        model.addAttribute("punto_atencion", new Punto_atencion());
        return "punto_atencionNuevo";
    }

    @PostMapping("/puntos_atencion/new/save")
    public String punto_atencionGuardar(@ModelAttribute Punto_atencion puntoAtencion) {
        punto_atencionRepository.insertarPuntos_atencion(puntoAtencion.getDireccion(), puntoAtencion.getTipoPunto());
        
        return "redirect:/puntos_atencion";
    }

    @GetMapping("/puntos_atencion/{id}/edit")
    public String punto_atencionEditarForm(@PathVariable("id") Integer id, Model model) {
        Punto_atencion punto_atencion = punto_atencionRepository.darPunto_atencion(id);
        if(punto_atencion != null){
            model.addAttribute("punto_atencion", punto_atencion);
            return "punto_atencionEditar";
        } else {
            return "redirect:/puntos_atencion";
        }
    }

    @PostMapping("/puntos_atencion/{id}/edit/save")
    public String punto_atencionEditarGuardar(@PathVariable("id") Integer id, @ModelAttribute Punto_atencion punto_atencion){
        punto_atencionRepository.actualizarPuntos_atencion(punto_atencion.getId(), punto_atencion.getDireccion(), punto_atencion.getTipoPunto());
        return "redirect:/puntos_atencion";
    }

    @GetMapping("/puntos_atencion/{id}/delete")
    public String punto_atencionEliminar(@PathVariable("id") Integer id){
        punto_atencionRepository.eliminarPuntos_atencion(id);
        return "redirect:/puntos_atencion";
    }
    
    

    
}
