package uniandes.edu.co.proyecto.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import uniandes.edu.co.proyecto.modelo.Cuenta;
import uniandes.edu.co.proyecto.modelo.OperacionCuenta;
import uniandes.edu.co.proyecto.repositorio.OperacionCuentaRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OperacionCuentaController {
    @Autowired
    private OperacionCuentaRepository operacionCuentaRepository;

    @GetMapping("/operaciones_cuenta")
    public String operacionesCuenta(Model model) {
        model.addAttribute("operaciones_cuenta", operacionCuentaRepository.darOperacionesCuenta());
        return "operacionesCuenta";
    }

    @GetMapping("/operaciones_cuenta/new")
    public String operacionCuentaForm(Model model) {
        model.addAttribute("operacion_cuenta", new OperacionCuenta());
        return "operacionCuentaNueva";
    }

    @PostMapping("/operaciones_cuenta/new/save")
    public String operacionCuentaGuardar(@ModelAttribute OperacionCuenta operacion) {
        operacionCuentaRepository.insertarOperacionCuenta(operacion.getId(), operacion.getCuenta(), operacion.getDetalle());
        return "redirect:/operaciones_cuenta";
    }
    
    @GetMapping("/operaciones_cuenta/{id}/edit")
    public String operacionCuentaEditarForm(@PathVariable("id") Integer id, Model model) {
        OperacionCuenta operacion = operacionCuentaRepository.darOperacionCuenta(id);
        if(operacion != null){
            model.addAttribute("operacion_cuenta", operacion);
            return "operacionCuentaEditar";
        } else {
            return "redirect:/operaciones_cuenta";
        }
    }

    @PostMapping("/operaciones_cuenta/{id}/edit/save")
    public String operacionCuentaEditarGuardar(@PathVariable("id") Integer id, @ModelAttribute OperacionCuenta operacion) {
        operacionCuentaRepository.actualizarOperacionCuenta(id, operacion.getCuenta(), operacion.getDetalle());;
        return "redirect:/operaciones_cuenta";
    }

    @GetMapping("/operaciones_cuenta/{id}/delete")
    public String operacionCuentaEliminar(@PathVariable("id") Integer id) {
        operacionCuentaRepository.eliminarOperacionCuenta(id);
        return "redirect:/operaciones_cuenta";
    }

    @GetMapping("/operaciones_cuenta/extracto")
    public String extractoCuenta(@RequestParam(required = false) Integer cuenta, Model model) {
        Collection<OperacionCuenta> operaciones = operacionCuentaRepository.findByCuenta(cuenta);
        model.addAttribute("extracto", operaciones);
        return "extracto"; // Vista para cuentas filtradas por tipo
    }
}
