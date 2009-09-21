package Dominio.Aplicacion;

public class Clientes {
    private int numero;
    private String nombre;
    private String apellido;
    private String cuit_dni;
    private String mail;
    private String telefono;
    private String iva;
    private String domicilio;
    private String localidad;
    private String provincia;
    private String fechaAlta;
    private String contraseña;

    public Clientes() {
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int val) {
        this.numero = val;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String val) {
        this.nombre = val;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String val) {
        this.apellido = val;
    }

    public String getCuit_dni() {
        return cuit_dni;
    }

    public void setCuit_dni(String val) {
        this.cuit_dni = val;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String val) {
        this.mail = val;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String val) {
        this.telefono = val;
    }

    public String getIva() {
        return iva;
    }

    public void setIva(String val) {
        this.iva = val;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String val) {
        this.domicilio = val;
    }
    
    public String getLocalidad() {
        return this.localidad;
    }

    public void setLocalidad(String val) {
        this.localidad = val;
    }
    
    public String getProvincia() {
        return this.provincia;
    }

    public void setProvincia(String val) {
        this.provincia= val;
    }
    
     public String getFechaAlta() {
        return this.fechaAlta;
    }

    public void setFechaAlta(String val) {
        this.fechaAlta= val;
    }
    
     public String getContraseña() {
        return this.contraseña;
    }

    public void setContraseña(String val) {
        this.contraseña= val;
    }
}


