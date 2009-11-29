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
public class TipoProducto implements IPersistible, Serializable {

    private int id;
    private String nombre;
    private int duracionGarantia;
    private List<Modelo> modelos;

    /**
     * Construye un nuevo objeto Tipo de Producto
     */
    public TipoProducto() {
        this.modelos = new ArrayList<Modelo>();
    }

    /**
     * Construye un nuevo objeto Tipo de Producto
     * @param id
     */
    public TipoProducto(int id) {
        this.id = id;
    }

    /**
     * Obtiene el identificador del Tipo de Producto
     * @return devuelve el identificador de Tipo de Producto
     */
    public int getID() {
        return this.id;
    }

    /**
     * Obtiene el Nombre del tipo de producto
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece la nombre del tipo de producto
     * @param nombre nombre del tipo de producto
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    /**
     * Obtiene la lista de modelos del tipo de producto
     * @return lista de modelos
     */
    public List<Modelo> getModelos() {
        return modelos;
    }

    /**
     * Setea un modelo
     * @param listaModelos
     */
    public void setModelos(List<Modelo> listaModelos) {
        this.modelos = listaModelos;
    }

    /**
     * Obtiene la descricion del tipo de producto
     * @return nombre del tipo de producto
     */
    @Override
    public String toString() {
        return nombre;
    }
}
