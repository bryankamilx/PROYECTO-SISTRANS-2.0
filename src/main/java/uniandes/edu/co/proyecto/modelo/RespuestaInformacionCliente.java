package uniandes.edu.co.proyecto.modelo;

public class RespuestaInformacionCliente {
    private Integer cliente_id;
    private String tipo_cliente;
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
    private Long numero_cuentas;

    // Constructor
    public RespuestaInformacionCliente(Integer cliente_id, String tipo_cliente, Integer id, String nombre, String login, String palabra_clave, String nacionalidad, String direccion, String telefono, String ciudad, String codigo_postal, String rol, Long numero_cuentas) {
        this.cliente_id = cliente_id;
        this.tipo_cliente = tipo_cliente;
        this.id = id;
        this.nombre = nombre;
        this.login = login;
        this.palabra_clave = palabra_clave;
        this.nacionalidad = nacionalidad;
        this.direccion = direccion;
        this.telefono = telefono;
        this.ciudad = ciudad;
        this.codigo_postal = codigo_postal;
        this.rol = rol;
        this.numero_cuentas = numero_cuentas;
    }

    // Getters and setters
    public Integer getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(Integer cliente_id) {
        this.cliente_id = cliente_id;
    }

    public String getTipo_cliente() {
        return tipo_cliente;
    }

    public void setTipo_cliente(String tipo_cliente) {
        this.tipo_cliente = tipo_cliente;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPalabra_clave() {
        return palabra_clave;
    }

    public void setPalabra_clave(String palabra_clave) {
        this.palabra_clave = palabra_clave;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCodigo_postal() {
        return codigo_postal;
    }

    public void setCodigo_postal(String codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Long getNumero_cuentas() {
        return numero_cuentas;
    }

    public void setNumero_cuentas(Long numero_cuentas) {
        this.numero_cuentas = numero_cuentas;
    }
}

