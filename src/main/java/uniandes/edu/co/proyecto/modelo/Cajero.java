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
    
    private Integer monto_disponible;

    private Integer limite_retiro;

    private Integer numerooficina;

    public Cajero( Integer monto_disponible, Integer limite_retiro, Integer numerooficina) {
        
        this.monto_disponible = monto_disponible;
        this.limite_retiro = limite_retiro;
        this.numerooficina = numerooficina;
    }

    public Cajero() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getNumerooficina() {
        return numerooficina;
    }

    public void setNumerooficina(Integer numerooficina) {
        this.numerooficina = numerooficina;
    }
    
    @Override
    public String toString() {
        return "Cajero [id=" + id + ", monto_disponible=" + monto_disponible + ", limite_retiro=" + limite_retiro+ ", numero_oficina=" + numerooficina +"]";
    }
    
}
