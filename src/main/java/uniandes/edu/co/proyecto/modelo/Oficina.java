package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="oficinas")
public class Oficina {

    @Id
    private Integer numero_Oficina;
    private String servicios_Ofrecidos;

    public Oficina(Integer numeroOficina, String serviciosOfrecidos) {
        super();
        this.numero_Oficina = numeroOficina;
        this.servicios_Ofrecidos = serviciosOfrecidos;
    }

    public Oficina() {
    }

    public Integer getNumero_Oficina() {
        return numero_Oficina;
    }

    public void setNumero_Oficina(Integer numeroOficina) {
        this.numero_Oficina = numeroOficina;
    }

    public String getServicios_Ofrecidos() {
        return servicios_Ofrecidos;
    }

    public void setServicios_Ofrecidos(String serviciosOfrecidos) {
        this.servicios_Ofrecidos = serviciosOfrecidos;
    }
}
