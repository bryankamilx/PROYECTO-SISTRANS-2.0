package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import uniandes.edu.co.proyecto.modelo.Punto_atencion;
import uniandes.edu.co.proyecto.repositorio.Punto_atencionRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class Punto_atencionController {

    @Autowired
    private Punto_atencionRepository punto_atencionRepository;

    @GetMapping("/puntos_atencion")
    public String puntos_atencion(Model model) {
        model.addAttribute("puntos_atencion", punto_atencionRepository.darPuntos_atencion());

        return "puntos_atencion";
    }

    @GetMapping("/puntos_atencion/new")
    public String punto_atencionForm(Model model) {

        model.addAttribute("punto_atencion", new Punto_atencion());
        return "punto_atencionNuevo";
    }

    @PostMapping("/puntos_atencion/new/save")
    public String punto_atencionGuardar(@ModelAttribute Punto_atencion puntoAtencion) {
        punto_atencionRepository.insertarPunto_atencion(puntoAtencion.getTipo_punto(), puntoAtencion.getDireccion());

        if (puntoAtencion.getTipo_punto().equals("Cajero")) {
            punto_atencionRepository.insertarCajero(puntoAtencion.getTipo_punto(), puntoAtencion.getDireccion());
        } else if (puntoAtencion.getTipo_punto().equals("Presencial")) {
            punto_atencionRepository.insertarPresencial(puntoAtencion.getTipo_punto(), puntoAtencion.getDireccion());
        } else if (puntoAtencion.getTipo_punto().equals("Virtual")) {
            punto_atencionRepository.insertarVirtual(puntoAtencion.getTipo_punto(), puntoAtencion.getDireccion());
        }	
        
        return "redirect:/puntos_atencion";
    }

    @GetMapping("/puntos_atencion/{id}/edit")
    public String punto_atencionEditarForm(@PathVariable("id") Integer id, Model model) {
        Punto_atencion punto_atencion = punto_atencionRepository.darPuntos_atencion(id);
        if(punto_atencion != null){
            model.addAttribute("punto_atencion", punto_atencion);
            return "punto_atencionEditar";
        } else {
            return "redirect:/puntos_atencion";
        }
    }

    @PostMapping("/puntos_atencion/{id}/edit/save")
    public String punto_atencionEditarGuardar(@PathVariable("id") Integer id, @ModelAttribute Punto_atencion punto_atencion){
        punto_atencionRepository.actualizarPunto_atencion(id, punto_atencion.getDireccion());
        Punto_atencion puntoExistente = punto_atencionRepository.darPuntos_atencion(id);
       
            
        if(puntoExistente.getTipo_punto().equals("Cajero")){
            punto_atencionRepository.actualizarCajero(id, puntoExistente.getDireccion());
        } else if(puntoExistente.getTipo_punto().equals("Presencial")){
            punto_atencionRepository.actualizarPresencial(id, puntoExistente.getDireccion());
        } else if(puntoExistente.getTipo_punto().equals("Virtual")){
            punto_atencionRepository.actualizarVirtual(id, puntoExistente.getDireccion());
        }
        
        
        return "redirect:/puntos_atencion";
    }

    @GetMapping("/puntos_atencion/{id}/delete")
    public String punto_atencionEliminar(@PathVariable("id") Integer id){
        punto_atencionRepository.eliminarPunto_atencion(id);
        punto_atencionRepository.eliminarCajero(id);
        punto_atencionRepository.eliminarPresencial(id);
        punto_atencionRepository.eliminarVirtual(id);
        return "redirect:/puntos_atencion";
    }
    
    

    
}
