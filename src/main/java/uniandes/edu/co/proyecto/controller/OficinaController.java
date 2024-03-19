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
        oficinaRepository.insertarOficina(oficina.getNumero_Oficina(), oficina.getServicios_Ofrecidos());
        return "redirect:/oficinas";
    }

    @GetMapping("/oficinas/{numeroOficina}/edit")
    public String oficinaEditarForm(@PathVariable("numeroOficina") Integer numero_Oficina, Model model) {
        Oficina oficina = oficinaRepository.buscarOficinaPorNumero(numero_Oficina);
        if (oficina != null) {
            model.addAttribute("oficina", oficina);
            return "oficinaEditar"; 
        } else {
            return "redirect:/oficinas";
        }
    }

    @PostMapping("/oficinas/{numeroOficina}/edit/save")
    public String oficinaEditarGuardar(@PathVariable("numero_Oficina") Integer numero_Oficina, @ModelAttribute Oficina oficina) {
        oficinaRepository.actualizarServiciosOfrecidos(numero_Oficina, oficina.getServicios_Ofrecidos());
        return "redirect:/oficinas";
    }

    @GetMapping("/oficinas/{numeroOficina}/delete")
    public String oficinaEliminar(@PathVariable("numero_Oficina") Integer numero_Oficina) {
        oficinaRepository.eliminarOficina(numero_Oficina);
        return "redirect:/oficinas";
    }
}


