package uniandes.edu.co.proyecto.modelo;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nombre;
    private String login;
    private String palabra_clave;
    private String nacionalidad;
    private String direccion;
    private String telefono;
    private String ciudad;
    private String codigo_postal;
    private String rol;

    public Usuario(String tipoDocumento, String numeroDocumento,String nombre, String login, String palabra_clave, String nacionalidad, String direccion, String telefono, String ciudad, String codigo_postal, String rol) {
        super();
        
        this.nombre = nombre;
        this.login = login;
        this.palabra_clave = palabra_clave;
        this.nacionalidad = nacionalidad;
        this.direccion = direccion;
        this.telefono = telefono;
        this.ciudad = ciudad;
        this.codigo_postal = codigo_postal;
        this.rol = rol;
    }

    public Usuario()
    {;}

    public Integer getId(){
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getLogin() {
        return login;
    }

    public String getPalabraClave() {
        return palabra_clave;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getCodigoPostal() {
        return codigo_postal;
    }

    public String getRol() {
        return rol;
    }


    public void setId(Integer id){
        this.id =id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPalabraClave(String palabraClave) {
        this.palabra_clave = palabraClave;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setCodigoPostal(String codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    

}
