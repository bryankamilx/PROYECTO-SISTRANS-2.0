package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="puntos_atencion")
public class Punto_atencion {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String tipo_punto;

    private String direccion;

    public Punto_atencion(){;}

    public Punto_atencion(String tipo_punto, String direccion)
    {
        this.tipo_punto = tipo_punto;
        this.direccion = direccion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo_punto() {
        return tipo_punto;
    }

    public void setTipo_punto(String tipo_punto) {
        this.tipo_punto = tipo_punto;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString()
    {
        return this.tipo_punto+"|"+this.direccion;
    }
    
}
