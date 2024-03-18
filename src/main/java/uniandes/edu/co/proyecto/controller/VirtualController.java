package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import uniandes.edu.co.proyecto.modelo.Virtual;
import uniandes.edu.co.proyecto.repositorio.VirtualRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class VirtualController {

    @Autowired
    private VirtualRepository virtualRepository;

    @GetMapping("/virtuales")
    public String virtuales(Model model) {
        model.addAttribute("virtuales", virtualRepository.darVirtuales());

        return "virtuales";
    }

    @GetMapping("/virtuales/new")
    public String virtualForm(Model model) {
        model.addAttribute("virtual", new Virtual());
        return "virtualNuevo";
    }

    @PostMapping("/virtuales/new/save")
    public String virtualGuardar(@ModelAttribute Virtual virtual) {
        virtualRepository.insertarVirtual( virtual.getPlataforma());
        
        return "redirect:/virtuales";
    }

    @GetMapping("/virtuales/{id}/edit")
    public String virtualEditarForm(@PathVariable("id") Integer id, Model model) {
        Virtual virtual = virtualRepository.darVirtual(id);
        if(virtual != null){
            model.addAttribute("virtual", virtual);
            return "virtualEditar";
        } else {
            return "redirect:/virtuales";
        }
    }

    @PostMapping("/virtuales/{id}/edit/save")
    public String virtualEditarGuardar(@PathVariable("id") Integer id, @ModelAttribute Virtual virtual){
        virtualRepository.actualizarVirtual(id, virtual.getPlataforma());
        return "redirect:/virtuales";
    }

    @GetMapping("/virtuales/{id}/delete")
    public String virtualEliminar(@PathVariable("id") Integer id){
        virtualRepository.eliminarVirtual(id);
        return "redirect:/virtuales";
    }
    
}
