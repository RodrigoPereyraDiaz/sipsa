package sipsa.dominio;

public abstract class Empresa {
    private String nombre;
    private String cuit;

     /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the cuit
     */
    public String getCuit() {
        return cuit;
    }

    /**
     * @param cuit the cuit to set
     */
    public void setCuit(String cuit) {
        this.cuit = cuit;
    }
}
