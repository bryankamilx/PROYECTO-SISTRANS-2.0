package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="oficinas")
public class Oficina {

    @Id
    private Integer numero_oficina;
    private String servicios_ofrecidos;

    public Oficina(Integer numero_Oficina, String servicios_Ofrecidos) {
        super();
        this.numero_oficina = numero_Oficina;
        this.servicios_ofrecidos = servicios_Ofrecidos;
    }

    public Oficina() {
    }

    public Integer getNumero_oficina() {
        return numero_oficina;
    }

    public void setNumero_oficina(Integer numeroOficina) {
        this.numero_oficina = numeroOficina;
    }

    public String getServicios_ofrecidos() {
        return servicios_ofrecidos;
    }

    public void setServicios_ofrecidos(String serviciosOfrecidos) {
        this.servicios_ofrecidos = serviciosOfrecidos;
    }
}
