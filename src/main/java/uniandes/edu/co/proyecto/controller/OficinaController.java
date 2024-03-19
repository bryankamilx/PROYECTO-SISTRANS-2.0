package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import uniandes.edu.co.proyecto.modelo.Oficina;
import uniandes.edu.co.proyecto.repositorio.OficinaRepository;

@Controller
public class OficinaController {
    
    @Autowired
    private OficinaRepository oficinaRepository;

    @GetMapping("/oficinas")
    public String oficinas(Model model){
        model.addAttribute("oficinas", oficinaRepository.findAll());
        return "oficinas";
    }

    @GetMapping("/oficinas/new")
    public String oficinaForm(Model model){
        model.addAttribute("oficina", new Oficina());
        return "oficinaNuevo";
    }

    @SuppressWarnings("null")
    @PostMapping("/oficinas/new/save")
    public String oficinaGuardar(@ModelAttribute Oficina oficina){
        oficinaRepository.save(oficina);
        return "redirect:/oficinas";
    }

    @GetMapping("/oficinas/{numero_oficina}/edit")
    public String oficinaEditarForm(@PathVariable("numero_oficina") Integer numero_oficina, Model model) {
        @SuppressWarnings("null")
        Oficina oficina = oficinaRepository.findById(numero_oficina).orElse(null);
        if(oficina != null){
            model.addAttribute("oficina", oficina);
            return "oficinaEditar";
        } else {
            return "redirect:/oficinas";
        }
    }
    
    @PostMapping("/oficinas/{numero_oficina}/edit/save")
    public String oficinaEditarGuardar(@PathVariable("numero_oficina") Integer numero_oficina, @ModelAttribute Oficina oficina){
        oficinaRepository.save(oficina);
        return "redirect:/oficinas";
    }

    @GetMapping("/oficinas/{numero_oficina}/delete")
    public String oficinaEliminar(@PathVariable("numero_oficina") Integer numero_oficina) {
        oficinaRepository.deleteById(numero_oficina);
        return "redirect:/oficinas";
    }
}
