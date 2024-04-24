package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import uniandes.edu.co.proyecto.modelo.OperacionPrestamo;
import uniandes.edu.co.proyecto.repositorio.OperacionPrestamoRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OperacionPrestamoController {
    @Autowired
    private OperacionPrestamoRepository operacionPrestamoRepository;

    @GetMapping("/operaciones_prestamo")
    public String operacionesPrestamo(Model model) {
        model.addAttribute("operaciones_prestamo", operacionPrestamoRepository.darOperacionesPrestamos());
        return "operacionesPrestamo";
    }

    @GetMapping("/operaciones_prestamo/new")
    public String operacionPrestamoForm(Model model) {
        model.addAttribute("operacion_prestamo", new OperacionPrestamo());
        return "operacionPrestamoNueva";
    }

    @PostMapping("/operaciones_prestamo/new/save")
    public String operacionPrestamoGuardar(@ModelAttribute OperacionPrestamo operacion) {
        operacionPrestamoRepository.insertarOperacionPrestamo(operacion.getId(), operacion.getDetalle_pago(), operacion.getId_prestamo());
        return "redirect:/operaciones_prestamo";
    }
    
    @GetMapping("/operaciones_prestamo/{id}/edit")
    public String operacionPrestamoEditarForm(@PathVariable("id") Integer id, Model model) {
        OperacionPrestamo operacion = operacionPrestamoRepository.darOperacionPrestamo(id);
        if(operacion != null){
            model.addAttribute("operacion_prestamo", operacion);
            return "operacionPrestamoEditar";
        } else {
            return "redirect:/operaciones_prestamo";
        }
    }

    @PostMapping("/operaciones_prestamo/{id}/edit/save")
    public String operacionPrestamoEditarGuardar(@PathVariable("id") Integer id, @ModelAttribute OperacionPrestamo operacion) {
        operacionPrestamoRepository.actualizarOperacionPrestamo(id, operacion.getDetalle_pago(), operacion.getId_prestamo());
        return "redirect:/operaciones_prestamo";
    }

    @GetMapping("/operaciones_prestamo/{id}/delete")
    public String operacionPrestamoEliminar(@PathVariable("id") Integer id) {
        operacionPrestamoRepository.eliminarOperacionPrestamo(id);
        return "redirect:/operaciones_prestamo";
    }
}
