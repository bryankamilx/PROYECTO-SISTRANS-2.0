package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "empleados")
public class Empleado {

    @Id
    private Integer id;

    private String numero_oficina;

    public Empleado(Integer id, String numero_oficina) {
        this.id = id;
        this.numero_oficina = numero_oficina;
    }

    public Empleado() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumero_oficina() {
        return numero_oficina;
    }

    public void setNumero_oficina(String numero_oficina) {
        this.numero_oficina = numero_oficina;
    }
}
