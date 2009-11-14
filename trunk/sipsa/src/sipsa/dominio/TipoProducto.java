/*
 * Sistemas de Informacion II 2009
 * Proyecto Sipsa
 */
package sipsa.dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import sipsa.persistencia.IPersistible;

/**
 * Tipo de Producto
 * @author Claudio Rodrigo Pereyra Diaz
 * @author Maria Eugenia Sanchez
 */
public class TipoProducto implements IPersistible, Serializable{
    private int id;
    private String descripcion;
    private int duracionGarantia;
    private List<Modelo> modelos;

    public TipoProducto() {
        
    }

    public TipoProducto(int id) {
        this.id = id;
        this.modelos = new ArrayList<Modelo>();
    }

    public int getID() {
        return this.id;
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

    public void addModelo(Modelo modelo){
        this.getModelos().add(modelo);
    }

    public void removeModelo(Modelo modelo){
        this.getModelos().remove(modelo);
    }

    /**
     * Obtiene la lista de modelos del tipo de producto
     * @return lista de modelos
     */
    public List<Modelo> getModelos() {
        return modelos;
    }

    public void setModelos(List<Modelo> listaModelos) {
        this.modelos = listaModelos;
    }
}