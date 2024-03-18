package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import uniandes.edu.co.proyecto.modelo.Presencial;
import uniandes.edu.co.proyecto.repositorio.PresencialRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PresencialController {

    @Autowired
    private PresencialRepository presencialRepository;

    @GetMapping("/presenciales")
    public String presenciales(Model model) {
        model.addAttribute("presenciales", presencialRepository.darPresenciales());

        return "presenciales";
    }

    @GetMapping("/presenciales/new")
    public String presencialForm(Model model) {
        model.addAttribute("presencial", new Presencial());
        return "presencialNuevo";
    }

    @PostMapping("/presenciales/new/save")
    public String presencialGuardar(@ModelAttribute Presencial presencial) {
        presencialRepository.insertarPresencial( presencial.getCajeros_disponibles(), presencial.getHorario_atencion_inicio(), presencial.getHorario_atencion_fin(), presencial.getNumerooficina());
        
        return "redirect:/presenciales";
    }

    @GetMapping("/presenciales/{id}/edit")
    public String presencialEditarForm(@PathVariable("id") Integer id, Model model) {
        Presencial presencial = presencialRepository.darPresencial(id);
        if(presencial != null){
            model.addAttribute("presencial", presencial);
            return "presencialEditar";
        } else {
            return "redirect:/presenciales";
        }
    }

    @PostMapping("/presenciales/{id}/edit/save")
    public String presencialEditarGuardar(@PathVariable("id") Integer id, @ModelAttribute Presencial presencial){
        presencialRepository.actualizarPresencial(id, presencial.getCajeros_disponibles(), presencial.getHorario_atencion_inicio(), presencial.getHorario_atencion_fin(), presencial.getNumerooficina());
        return "redirect:/presenciales";
    }

    @GetMapping("/presenciales/{id}/delete")
    public String presencialEliminar(@PathVariable("id") Integer id){
        presencialRepository.eliminarPresencial(id);
        return "redirect:/presenciales";
    }
    
}
