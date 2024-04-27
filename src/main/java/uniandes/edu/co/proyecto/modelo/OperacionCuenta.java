package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="operaciones_cuentas")
public class OperacionCuenta {

    @Id
    private Integer id;
    private Integer cuenta;
    private String detalle;

    public OperacionCuenta()
    {;}

    public OperacionCuenta(Integer id, Integer cuenta, String detalle) {
        this.id = id;
        this.cuenta = cuenta;
        this.detalle = detalle;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCuenta() {
        return cuenta;
    }

    public void setCuenta(Integer cuenta) {
        this.cuenta = cuenta;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    

    
}
