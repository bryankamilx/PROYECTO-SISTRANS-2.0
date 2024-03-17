package uniandes.edu.co.proyecto;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import uniandes.edu.co.proyecto.modelo.Empleado;
import uniandes.edu.co.proyecto.repositorio.EmpleadoRepository;




@SpringBootApplication
public class ProyectoApplication implements CommandLineRunner{

	@Autowired
	EmpleadoRepository empleadoRepository;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoApplication.class, args);
	}

	@Override
	public void run(String... arg){
		Collection<Empleado> clientes = empleadoRepository.darEmpleados();
		for (Empleado c:clientes){
			System.out.println(c.getId());
		}
	}

}
