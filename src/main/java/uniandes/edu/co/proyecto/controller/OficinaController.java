package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.proyecto.modelo.Oficina;
import uniandes.edu.co.proyecto.repositorio.OficinaRepository;

import java.util.Collection;

@Controller
public class OficinaController {

    @Autowired
    private OficinaRepository oficinaRepository;

    @GetMapping("/oficinas")
    public String oficinas(Model model) {
        Collection<Oficina> oficinas = oficinaRepository.darOficinas();
        model.addAttribute("oficinas", oficinas);
        return "oficinas";
    }

    @GetMapping("/oficinas/new")
    public String oficinaForm(Model model) {
        model.addAttribute("oficina", new Oficina());
        return "oficinaNuevo"; 
    }

    @PostMapping("/oficinas/new/save")
    public String oficinaGuardar(@ModelAttribute Oficina oficina) {
        oficinaRepository.insertarOficina(oficina.getNumeroOficina(), oficina.getServiciosOfrecidos());
        return "redirect:/oficinas";
    }

    @GetMapping("/oficinas/{numeroOficina}/edit")
    public String oficinaEditarForm(@PathVariable("numeroOficina") Integer numeroOficina, Model model) {
        Oficina oficina = oficinaRepository.buscarOficinaPorNumero(numeroOficina);
        if (oficina != null) {
            model.addAttribute("oficina", oficina);
            return "oficinaEditar"; 
        } else {
            return "redirect:/oficinas";
        }
    }

    @PostMapping("/oficinas/{numeroOficina}/edit/save")
    public String oficinaEditarGuardar(@PathVariable("numeroOficina") Integer numeroOficina, @ModelAttribute Oficina oficina) {
        oficinaRepository.actualizarServiciosOfrecidos(numeroOficina, oficina.getServiciosOfrecidos());
        return "redirect:/oficinas";
    }

    @GetMapping("/oficinas/{numeroOficina}/delete")
    public String oficinaEliminar(@PathVariable("numeroOficina") Integer numeroOficina) {
        oficinaRepository.eliminarOficina(numeroOficina);
        return "redirect:/oficinas";
    }
}


