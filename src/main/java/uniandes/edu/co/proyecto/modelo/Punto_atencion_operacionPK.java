package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class Punto_atencion_operacionPK implements Serializable {
 
    @ManyToOne
    @JoinColumn(name = "punto_id", referencedColumnName = "id")
    private Punto_atencion punto_id;

    @ManyToOne
    @JoinColumn(name = "operacion_id", referencedColumnName = "id")
    private Operacion operacion_id;

    

    public Punto_atencion_operacionPK() {
       super();
    }

    public Punto_atencion_operacionPK(Punto_atencion punto_id, Operacion operacion_id) {
        super();
        this.punto_id = punto_id;
        this.operacion_id = operacion_id;
    }

    public Punto_atencion getPunto_id() {
        return punto_id;
    }

    public void setPunto_id(Punto_atencion punto_id) {
        this.punto_id = punto_id;
    }

    public Operacion getOperacion_id() {
        return operacion_id;
    }

    public void setOperacion_id(Operacion operacion_id) {
        this.operacion_id = operacion_id;
    }


}
