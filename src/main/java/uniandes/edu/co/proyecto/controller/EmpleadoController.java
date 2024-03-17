package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.Empleado;
import uniandes.edu.co.proyecto.repositorio.EmpleadoRepository;

@Controller
public class EmpleadoController {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @GetMapping("/empleados")
    public String empleados(Model model) {
        model.addAttribute("empleados", empleadoRepository.darEmpleados());
        return "empleados";
    }

    @GetMapping("/empleados/new")
    public String empleadoForm(Model model) {
        model.addAttribute("empleado", new Empleado());
        return "empleadoNuevo";
    }

    @PostMapping("/empleados/new/save")
    public String empleadoGuardar(@ModelAttribute Empleado empleado) {
        empleadoRepository.save(empleado);
        return "redirect:/empleados";
    }

    @GetMapping("/empleados/{id}/edit")
    public String empleadoEditarForm(@PathVariable("id") Integer id, Model model) {
        Empleado empleado = empleadoRepository.darEmpleado(id);
        if (empleado != null) {
            model.addAttribute("empleado", empleado);
            return "empleadoEditar";
        } else {
            return "redirect:/empleados";
        }
    }

    @PostMapping("/empleados/{id}/edit/save")
    public String empleadoEditarGuardar(@PathVariable("id") Integer id, @ModelAttribute Empleado empleado) {
        empleado.setId(id);
        empleadoRepository.save(empleado);
        return "redirect:/empleados";
    }

    @GetMapping("/empleados/{id}/delete")
    public String empleadoEliminar(@PathVariable("id") Integer id) {
        empleadoRepository.eliminarEmpleado(id);
        return "redirect:/empleados";
    }
}
