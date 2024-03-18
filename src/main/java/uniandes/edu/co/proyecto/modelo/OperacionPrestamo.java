package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="operaciones_prestamos")
public class OperacionPrestamo {

    @Id
    private Integer id;
    private String detalle_pago;
    private Integer id_prestamo;

    public OperacionPrestamo()
    {;}

    public OperacionPrestamo(Integer id, String detalle_pago, Integer id_prestamo) {
        this.id = id;
        this.detalle_pago = detalle_pago;
        this.id_prestamo = id_prestamo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDetalle_pago() {
        return detalle_pago;
    }

    public void setDetalle_pago(String detalle_pago) {
        this.detalle_pago = detalle_pago;
    }

    public Integer getId_prestamo() {
        return id_prestamo;
    }

    public void setId_prestamo(Integer id_prestamo) {
        this.id_prestamo = id_prestamo;
    }

    

    
}