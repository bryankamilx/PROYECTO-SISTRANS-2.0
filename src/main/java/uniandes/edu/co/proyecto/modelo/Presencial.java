package uniandes.edu.co.proyecto.modelo;



import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="presenciales")
public class Presencial{
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    
    private Integer cajeros_disponibles;

    private Timestamp horario_atencion_inicio;

    private Timestamp horario_atencion_fin;

    private Integer numerooficina;


    public Presencial(Integer cajeros_disponibles, Timestamp horario_atencion_inicio, Timestamp horario_atencion_fin, Integer numerooficina) {
        
        this.cajeros_disponibles = cajeros_disponibles;
        this.horario_atencion_inicio = horario_atencion_inicio;
        this.horario_atencion_fin = horario_atencion_fin;
        this.numerooficina = numerooficina;
    }

    public Presencial() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    
    public Integer getCajeros_disponibles() {
        return cajeros_disponibles;
    }

    public void setCajeros_disponibles(Integer cajeros_disponibles) {
        this.cajeros_disponibles = cajeros_disponibles;
    }

    public Timestamp getHorario_atencion_inicio() {
        return horario_atencion_inicio;
    }

    public void setHorario_atencion_inicio(Timestamp horario_atencion_inicio) {
        this.horario_atencion_inicio = horario_atencion_inicio;
    }

    public Timestamp getHorario_atencion_fin() {
        return horario_atencion_fin;
    }

    public void setHorario_atencion_fin(Timestamp horario_atencion_fin) {
        this.horario_atencion_fin = horario_atencion_fin;
    }

    public Integer getNumerooficina() {
        return numerooficina;
    }

    public void setNumerooficina(Integer numerooficina) {
        this.numerooficina = numerooficina;
    }
    

    
}
