package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.proyecto.modelo.Cuenta;
import uniandes.edu.co.proyecto.repositorio.CuentaRepository;

import java.util.Collection;

@Controller
public class CuentaController {

    @Autowired
    private CuentaRepository cuentaRepository;

    @GetMapping("/cuentas")
    public String cuentas(Model model) {
        Collection<Cuenta> cuentas = cuentaRepository.darCuentas();
        model.addAttribute("cuentas", cuentas);
        return "cuentas"; // Vista que muestra la lista de cuentas
    }

    @GetMapping("/cuentas/new")
    public String cuentaForm(Model model) {
        model.addAttribute("cuenta", new Cuenta());
        return "cuentaNuevo"; // Vista para el formulario de creación de cuenta
    }

    @PostMapping("/cuentas/new/save")
    public String cuentaGuardar(@ModelAttribute Cuenta cuenta) {
        cuentaRepository.insertarCuenta(cuenta.getNumeroCuenta(), cuenta.getTipoCuenta(), cuenta.getSaldo(), cuenta.getEstado(), cuenta.getIdCliente());
        return "redirect:/cuentas";
    }

    @GetMapping("/cuentas/{numeroCuenta}/edit")
    public String cuentaEditarForm(@PathVariable("numeroCuenta") Integer numeroCuenta, @RequestParam("tipoCuenta") String tipoCuenta, Model model) {
        Cuenta cuenta = cuentaRepository.buscarCuentaPorNumeroYTipo(numeroCuenta, tipoCuenta);
        if (cuenta != null) {
            model.addAttribute("cuenta", cuenta);
            return "cuentaEditar"; // Vista para el formulario de edición de cuenta
        } else {
            return "redirect:/cuentas";
        }
    }

    @PostMapping("/cuentas/{numeroCuenta}/edit/save")
    public String cuentaEditarGuardar(@PathVariable("numeroCuenta") Integer numeroCuenta, @ModelAttribute Cuenta cuenta) {
        cuentaRepository.actualizarCuenta(numeroCuenta, cuenta.getTipoCuenta(), cuenta.getSaldo(), cuenta.getEstado(), cuenta.getIdCliente());
        return "redirect:/cuentas";
    }

    @GetMapping("/cuentas/{numeroCuenta}/delete")
    public String cuentaEliminar(@PathVariable("numeroCuenta") Integer numeroCuenta, @RequestParam("tipoCuenta") String tipoCuenta) {
        cuentaRepository.eliminarCuenta(numeroCuenta, tipoCuenta);
        return "redirect:/cuentas";
    }
}
