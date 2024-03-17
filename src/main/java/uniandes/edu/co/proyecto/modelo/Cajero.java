package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="cajeros")
public class Cajero extends Punto_atencion {

    private Integer montoDisponible;
    private Integer limiteRetiro;

   
    

    public Cajero(String direccion, String tipoPunto, Integer montoDisponible, Integer limiteRetiro) {
        super(direccion, tipoPunto);
        this.montoDisponible = montoDisponible;
        this.limiteRetiro = limiteRetiro;
    }

    public Cajero() {
    }

    public Integer getMontoDisponible() {
        return montoDisponible;
    }

    public Integer getLimiteRetiro() {
        return limiteRetiro;
    }

    public void setMontoDisponible(Integer montoDisponible) {
        this.montoDisponible = montoDisponible;
    }

    public void setLimiteRetiro(Integer limiteRetiro) {
        this.limiteRetiro = limiteRetiro;
    }
    
}

