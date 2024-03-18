package uniandes.edu.co.proyecto;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import uniandes.edu.co.proyecto.modelo.Empleado;
import uniandes.edu.co.proyecto.modelo.Operacion;
import uniandes.edu.co.proyecto.modelo.OperacionCuenta;
import uniandes.edu.co.proyecto.modelo.OperacionPrestamo;
import uniandes.edu.co.proyecto.repositorio.EmpleadoRepository;
import uniandes.edu.co.proyecto.repositorio.OperacionCuentaRepository;
import uniandes.edu.co.proyecto.repositorio.OperacionPrestamoRepository;
import uniandes.edu.co.proyecto.repositorio.OperacionRepository;




@SpringBootApplication
public class ProyectoApplication implements CommandLineRunner{

	@Autowired
	EmpleadoRepository empleadoRepository;

	@Autowired
	OperacionRepository operacionRepository;

	@Autowired
	OperacionCuentaRepository operacionCuentaRepository;

	@Autowired
	OperacionPrestamoRepository operacionPrestamoRepository;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoApplication.class, args);
	}

	@Override
	public void run(String... arg){
		Collection<Empleado> clientes = empleadoRepository.darEmpleados();
		for (Empleado c:clientes){
			System.out.println(c.getId());
		}
		Collection<Operacion> operaciones = operacionRepository.darOperaciones();
		for (Operacion c:operaciones){
			System.out.println(c.getId());
		}

		Collection<OperacionCuenta> operaciones_cuenta = operacionCuentaRepository.darOperacionesCuenta();
		for (OperacionCuenta c:operaciones_cuenta){
			System.out.println(c.getId());
		}

		Collection<OperacionPrestamo> operaciones_prestamos = operacionPrestamoRepository.darOperacionesPrestamos();
		for (OperacionPrestamo c:operaciones_prestamos){
			System.out.println(c.getId());
		}
	}

}
