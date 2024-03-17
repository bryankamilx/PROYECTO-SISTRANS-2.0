package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="virtuales")
public class Virtual extends Punto_atencion{

    private String plataforma;

    public Virtual(String direccion, String tipoPunto, String plataforma) {
        super(direccion, tipoPunto);
        this.plataforma = plataforma;
    }

    public Virtual() {
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    
}
