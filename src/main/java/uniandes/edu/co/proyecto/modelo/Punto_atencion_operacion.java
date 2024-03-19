package uniandes.edu.co.proyecto.modelo;


import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="puntos_atencion_operaciones")
public class Punto_atencion_operacion {

    @EmbeddedId
    private Punto_atencion_operacionPK pk;

    public Punto_atencion_operacion() {
        ;
    }

    public Punto_atencion_operacion(Punto_atencion punto_id, Operacion operacion_id) {
        super();
        this.pk = new Punto_atencion_operacionPK(punto_id, operacion_id);
    }

    public Punto_atencion_operacionPK getPk() {
        return pk;
    }

    public void setPk(Punto_atencion_operacionPK pk) {
        this.pk = pk;
    }
    
}
