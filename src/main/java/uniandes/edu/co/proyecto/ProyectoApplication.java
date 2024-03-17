package uniandes.edu.co.proyecto;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import uniandes.edu.co.proyecto.modelo.Punto_atencion;
import uniandes.edu.co.proyecto.repositorio.Punto_atencionRepository;




@SpringBootApplication
public class ProyectoApplication implements CommandLineRunner {

	@Autowired
	private Punto_atencionRepository repository;
	public static void main(String[] args) {
		SpringApplication.run(ProyectoApplication.class, args);
	}	

	@Override
	public void run(String...args){
		Collection<Punto_atencion> puntos = repository.darPuntos_atencion();
		for(Punto_atencion punto : puntos){
			System.out.println(punto);
		}
	}

}
