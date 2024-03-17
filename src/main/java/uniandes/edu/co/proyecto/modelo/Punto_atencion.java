package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="puntos_atencion")


public class Punto_atencion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String direccion;
    private String tipoPunto;
    

    public Punto_atencion(String direccion, String tipoPunto) {
        this.direccion = direccion;
        this.tipoPunto = tipoPunto;
    }

    public Punto_atencion()
    {}

    public Integer getId() {
        return id;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTipoPunto() {
        return tipoPunto;
    }

    public void setId(Integer idPunto) {
        this.id = idPunto;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTipoPunto(String tipoPunto) {
        this.tipoPunto = tipoPunto;
    }   

    
}
