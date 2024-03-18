package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="virtuales")
public class Virtual{
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String tipo_punto;

    private String direccion;
    
    private String plataforma;

    public Virtual(String tipo_Punto, String direccion, String plataforma) {
        
        this.tipo_punto = tipo_Punto;
        this.direccion = direccion;
        this.plataforma = plataforma;
    }

    public Virtual() {
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
    
    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    
}
