package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="cajeros")
public class Cajero {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String tipo_punto;

    private String direccion;
    
    private Integer monto_disponible;

    private Integer limite_retiro;

    public Cajero(String tipo_punto, String direccion, Integer monto_disponible, Integer limite_retiro) {
        
        this.tipo_punto = tipo_punto;
        this.direccion = direccion;
        this.monto_disponible = monto_disponible;
        this.limite_retiro = limite_retiro;
    }

    public Cajero() {
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
    
    public Integer getMonto_disponible() {
        return monto_disponible;
    }

    public void setMonto_disponible(Integer monto_disponible) {
        this.monto_disponible = monto_disponible;
    }

    public Integer getLimite_retiro() {
        return limite_retiro;
    }

    public void setLimite_retiro(Integer limite_retiro) {
        this.limite_retiro = limite_retiro;
    }
    
    @Override
    public String toString() {
        return "Cajero [id=" + id + ", tipo_cajero=" + tipo_punto + ", direccion=" + direccion + ", monto_disponible=" + monto_disponible + ", limite_retiro=" + limite_retiro+ "]";
    }
    
}
