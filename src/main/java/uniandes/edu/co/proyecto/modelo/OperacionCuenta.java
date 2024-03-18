package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="operaciones_cuentas")
public class OperacionCuenta {

    @Id
    private Integer id;
    private Integer num_cuenta;
    private String detalle;

    public OperacionCuenta()
    {;}

    public OperacionCuenta(Integer id, Integer num_cuenta, String detalle) {
        this.id = id;
        this.num_cuenta = num_cuenta;
        this.detalle = detalle;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNum_cuenta() {
        return num_cuenta;
    }

    public void setNum_cuenta(Integer num_cuenta) {
        this.num_cuenta = num_cuenta;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    

    
}
