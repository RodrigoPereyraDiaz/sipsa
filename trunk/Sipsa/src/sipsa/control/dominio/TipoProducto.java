/*
 * Sistemas de Informacion II 2009
 * Proyecto Sipsa
 */
package sipsa.control.dominio;

/**
 * Tipo de Producto
 * @author Claudio Rodrigo Pereyra Diaz
 * @author Maria Eugenia Sanchez
 */
public class TipoProducto{
    private String modelo;
    private String descripcion;
    private int duracionGarantia;

    /**
     * @return the modelo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * @return the nombre
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the duracionGarantia
     */
    public int getDuracionGarantia() {
        return duracionGarantia;
    }

    /**
     * @param duracionGarantia the duracionGarantia to set
     */
    public void setDuracionGarantia(int duracionGarantia) {
        this.duracionGarantia = duracionGarantia;
    }
}
