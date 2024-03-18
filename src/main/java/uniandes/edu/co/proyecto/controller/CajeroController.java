package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import uniandes.edu.co.proyecto.modelo.Cajero;
import uniandes.edu.co.proyecto.repositorio.CajeroRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CajeroController {

    @Autowired
    private CajeroRepository cajeroRepository;

    @GetMapping("/cajeros")
    public String cajeros(Model model) {
        model.addAttribute("cajeros", cajeroRepository.darCajeros());

        return "cajeros";
    }

    @GetMapping("/cajeros/new")
    public String cajeroForm(Model model) {
        model.addAttribute("cajero", new Cajero());
        return "cajeroNuevo";
    }

    @PostMapping("/cajeros/new/save")
    public String cajeroGuardar(@ModelAttribute Cajero cajero) {
        cajeroRepository.insertarCajero(  cajero.getMonto_disponible(), cajero.getLimite_retiro(), cajero.getNumerooficina());
        
        return "redirect:/cajeros";
    }

    @GetMapping("/cajeros/{id}/edit")
    public String cajeroEditarForm(@PathVariable("id") Integer id, Model model) {
        Cajero cajero = cajeroRepository.darCajero(id);
        if(cajero != null){
            model.addAttribute("cajero", cajero);
            return "cajeroEditar";
        } else {
            return "redirect:/cajeros";
        }
    }

    @PostMapping("/cajeros/{id}/edit/save")
    public String cajeroEditarGuardar(@PathVariable("id") Integer id, @ModelAttribute Cajero cajero){
        cajeroRepository.actualizarCajero(id, cajero.getMonto_disponible(), cajero.getLimite_retiro(), cajero.getNumerooficina());
        return "redirect:/cajeros";
    }

    @GetMapping("/cajeros/{id}/delete")
    public String cajeroEliminar(@PathVariable("id") Integer id){
        cajeroRepository.eliminarCajero(id);
        return "redirect:/cajeros";
    }
    
}
