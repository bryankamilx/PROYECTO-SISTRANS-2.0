package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import uniandes.edu.co.proyecto.modelo.Punto_atencion;
import uniandes.edu.co.proyecto.modelo.Operacion;
import uniandes.edu.co.proyecto.modelo.Punto_atencion_operacion;
import uniandes.edu.co.proyecto.modelo.Punto_atencion_operacionPK;
import uniandes.edu.co.proyecto.repositorio.Punto_atencionRepository;
import uniandes.edu.co.proyecto.repositorio.OperacionRepository;
import uniandes.edu.co.proyecto.repositorio.Punto_atencion_operacionRepository;

@Controller
public class Punto_atencion_operacionController {

    @Autowired
    private Punto_atencion_operacionRepository punto_atencion_operacionRepository;

    @Autowired
    private Punto_atencionRepository punto_atencionRepository;

    @Autowired
    private OperacionRepository operacionRepository;



    @GetMapping("/punto_atencion_operacion/edit")
    public String punto_atencion_operacionForm(Model model) {
        model.addAttribute("puntos_atencion", punto_atencionRepository.darPuntos_atencion());
        model.addAttribute("operaciones", operacionRepository.darOperaciones());
        return "formularioOperacion";
    }


     @PostMapping("/punto_atencion_operacion/new/save")
    public String punto_atencion_operacionGuardar(@ModelAttribute("punto_id") Integer punto_id,
            @ModelAttribute("operacion_id") int operacion_id) {

        Punto_atencion punto_atencion = punto_atencionRepository.darPunto_atencion(punto_id);
        Operacion operacion = operacionRepository.darOperacion(operacion_id);
        Punto_atencion_operacionPK pk = new Punto_atencion_operacionPK(punto_atencion, operacion);
        Punto_atencion_operacion punto_atencion_operacion = new Punto_atencion_operacion();
        punto_atencion_operacion.setPk(pk);
        punto_atencion_operacionRepository.insertarPunto_atencion_operacion(punto_atencion_operacion.getPk().getPunto_id().getId(), punto_atencion_operacion.getPk().getOperacion_id().getId());
        return "redirect:/puntos_atencion";
    }


    @GetMapping("/presenciales/{id}/operacion/nueva")
    public String mostrarFormularioNuevaOperacion(@PathVariable("id") Integer punto_id, Model model) {

        Punto_atencion presencial = punto_atencionRepository.darPunto_atencion(punto_id);
        if(presencial != null){
            model.addAttribute("punto_id", punto_id);
            model.addAttribute("operacion", new Operacion());
            return "presencialOperacionNueva";
        } else {
            return "redirect:/presenciales";
        }        
    }


    @PostMapping("/puntos_atencion/{id}/operacion/nueva/save")
    public String guardarOperacionYAsociacion(@RequestParam("punto_id") Integer punto_id, @ModelAttribute Operacion operacion) {
        operacionRepository.insertarOperacion(operacion.getTipo(), operacion.getId_usuario(), operacion.getProducto(), operacion.getValor(), operacion.getFecha_hora());
        Operacion nuevaOperacion = operacionRepository.darOperacion(operacion.getId());
        Punto_atencion puntoAtencion = punto_atencionRepository.darPunto_atencion(punto_id);
        Punto_atencion_operacionPK pk = new Punto_atencion_operacionPK(puntoAtencion, nuevaOperacion);
        Punto_atencion_operacion punto_atencion_operacion = new Punto_atencion_operacion();
        punto_atencion_operacion.setPk(pk);
        punto_atencion_operacionRepository.insertarPunto_atencion_operacion(punto_atencion_operacion.getPk().getPunto_id().getId(), punto_atencion_operacion.getPk().getOperacion_id().getId());

        return "redirect:/presenciales";
    }



}
