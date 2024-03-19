package uniandes.edu.co.proyecto.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import uniandes.edu.co.proyecto.modelo.Cliente;
import uniandes.edu.co.proyecto.repositorio.ClienteRepository;

@Controller
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/clientes")
    public String clientes(Model model) {
        model.addAttribute("clientes", clienteRepository.darClientes());
        return "clientes";
    }

    @GetMapping("/clientes/new")
    public String clienteForm(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "clienteNuevo";
    }

    @PostMapping("/clientes/new/save")
    public String clienteGuardar(@ModelAttribute Cliente cliente) {
    clienteRepository.insertarCliente(cliente.getId(),cliente.getTipo_cliente()); 
    return "redirect:/clientes";
    }

    @GetMapping("/clientes/{id}/edit")
    public String clienteEditarForm(@PathVariable("id") Integer id, Model model) {
        Cliente cliente = clienteRepository.darCliente(id);
        if (cliente != null) {
            model.addAttribute("cliente", cliente);
            return "clienteEditar";
        } else {
            return "redirect:/clientes";
        }
    }

    @PostMapping("/clientes/{id}/edit/save")
    public String clienteEditarGuardar(@PathVariable("id") Integer id, @ModelAttribute Cliente cliente) {
    cliente.setId(id); 
    clienteRepository.save(cliente); 
    return "redirect:/clientes";
}

    @GetMapping("/clientes/{id}/delete")
    public String clienteEliminar(@PathVariable("id") Integer id) {
        clienteRepository.eliminarCliente(id);
        return "redirect:/clientes";
    }

    @GetMapping("/clientes/{id}/info")
    public String mostrarInformacionCliente(@PathVariable("id") Integer id, Model model) {
        // Obtener la información del cliente utilizando el método del repositorio
        Collection<ClienteRepository.RespuestaInformacionCliente> informacionCliente = clienteRepository.obtenerInformacionCliente(id);
        
        // Agregar la información del cliente al modelo para pasarla a la vista
        model.addAttribute("informacionCliente", informacionCliente);
        
        // Retornar el nombre de la vista donde se mostrará la información del cliente
        return "informacionCliente";
    }

    @GetMapping("/clientes/buscar")
    public String buscarCliente(@RequestParam("clienteId") Integer clienteId, Model model) {
        return "redirect:/clientes/" + clienteId + "/info";
}


}
