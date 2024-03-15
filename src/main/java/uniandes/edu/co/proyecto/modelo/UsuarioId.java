package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class UsuarioId implements Serializable {

    @ManyToOne
    @JoinColumn(name = "TIPODOC",referencedColumnName = "TIPODOC")
    private String tipoDocumento;

    @ManyToOne
    @JoinColumn(name = "NUMDOC",referencedColumnName = "NUMDOC")
    private String numeroDocumento;

    public UsuarioId(String tipoDocumento, String numeroDocumento) {
        super();
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
    }
    public String getTipoDocumento() {
        return tipoDocumento;
    }
    public String getNumeroDocumento() {
        return numeroDocumento;
    }
    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }
    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public UsuarioId()
    {super();}

    
    
}
