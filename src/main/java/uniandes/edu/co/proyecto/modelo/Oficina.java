package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="oficinas")
public class Oficina {

    @Id
    private Integer numeroOficina;
    private String serviciosOfrecidos;

    public Oficina(Integer numeroOficina, String serviciosOfrecidos) {
        super();
        this.numeroOficina = numeroOficina;
        this.serviciosOfrecidos = serviciosOfrecidos;
    }

    public Oficina() {
    }

    public Integer getNumeroOficina() {
        return numeroOficina;
    }

    public void setNumeroOficina(Integer numeroOficina) {
        this.numeroOficina = numeroOficina;
    }

    public String getServiciosOfrecidos() {
        return serviciosOfrecidos;
    }

    public void setServiciosOfrecidos(String serviciosOfrecidos) {
        this.serviciosOfrecidos = serviciosOfrecidos;
    }
}
