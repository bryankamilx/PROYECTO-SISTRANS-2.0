package uniandes.edu.co.proyecto.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import uniandes.edu.co.proyecto.modelo.Cuenta;
import uniandes.edu.co.proyecto.modelo.OperacionCuenta;
import uniandes.edu.co.proyecto.repositorio.OperacionCuentaRepository;
import uniandes.edu.co.proyecto.servicios.OperacionCuentaService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class OperacionCuentaController {
    @Autowired
    private OperacionCuentaRepository operacionCuentaRepository;

    @Autowired
    private OperacionCuentaService operacionCuentaService;

    @GetMapping("/operaciones_cuenta")
    public String operacionesCuenta(Model model) {
        try {
            model.addAttribute("operaciones_cuenta", operacionCuentaService.consultarOperacionesConFantasma());
        } catch (Exception e) {
        }
        
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

    @GetMapping("/operaciones_cuenta/{id}/edit/wait")
    public String operacionCuentaEditarEsperaForm(@PathVariable("id") Integer id, Model model) {
        OperacionCuenta operacion = operacionCuentaRepository.darOperacionCuenta(id);
        if(operacion != null){
            model.addAttribute("operacion_cuenta", operacion);
            return "operacionCuentaEditarEspera";
        } else {
            return "redirect:/operaciones_cuenta";
        }
    }

    @PostMapping("/operaciones_cuenta/{id}/edit/save/wait")
    public String operacionCuentaEditarGuardarEspera(@PathVariable("id") Integer id, @ModelAttribute OperacionCuenta operacion) {
        operacionCuentaService.actualizar_operacionCuenta_con_espera(id, operacion.getCuenta(), operacion.getDetalle());;
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

    @GetMapping("/operaciones_cuenta/extracto_con_espera")
    public String consultarOperacionesEspera(@RequestParam(required = false) Integer cuenta, Model model, RedirectAttributes redirectAttributes) {
    try {
        Collection<OperacionCuenta> extractoConEspera = operacionCuentaService.consultarOperacionesConEspera(cuenta);
        model.addAttribute("extracto", extractoConEspera);
    } catch (Exception e) {
        System.err.println("Error durante la consulta de operaciones: " + e.getMessage());
        redirectAttributes.addFlashAttribute("errorMessage", "No se pudo consultar el extracto de cuenta con espera.");
        return "redirect:/operaciones_cuenta"; // Redireccionar a la página de operaciones de cuenta
    }
    return "extracto";
    }

    @GetMapping("/operaciones_cuenta/bloqueo")
    public String consultarOperacionesSinFantasma(RedirectAttributes redirectAttributes) {
        try {
            // Indicar el ID del bar a consultar.
            operacionCuentaService.consultarOperacionesSinFantasma();
        } catch (Exception e) {
            System.err.println("Error durante la consulta de operaciones: " + e.getMessage());
            redirectAttributes.addFlashAttribute("errorMessage", "No se pudo consultar las operaciones correctamente.");
            return "redirect:/operaciones_cuenta";
        }
        return "redirect:/operaciones_cuenta";
    }

}


