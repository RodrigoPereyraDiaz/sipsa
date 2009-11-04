/*
 * Sistemas de Informacion II 2009
 * Proyecto Sipsa
 */
package sipsa.dominio;

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
     * Obtiene el Modelo del tipo de producto
     * @return the modelo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Establece el Modelo del tipo de producto
     * @param modelo the modelo to set
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * Obtiene el Nombre del tipo de producto
     * @return the nombre
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece la descripcion del tipo de producto
     * @param descripcion
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Obtiene la duracion de la garantia del tipo de producto
     * @return the duracionGarantia
     */
    public int getDuracionGarantia() {
        return duracionGarantia;
    }

    /**
     * Establece la duracion de la garantia del tipo de producto
     * @param duracionGarantia the duracionGarantia to set
     */
    public void setDuracionGarantia(int duracionGarantia) {
        this.duracionGarantia = duracionGarantia;
    }
}