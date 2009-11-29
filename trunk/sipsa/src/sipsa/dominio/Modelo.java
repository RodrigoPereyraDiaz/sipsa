package sipsa.dominio;

import java.io.Serializable;
import sipsa.persistencia.IPersistible;

/**
 * Modelo de Tipo de producto
 * @author Claudio Rodrigo Pereyra Diaz
 * @author Maria Eugenia Sanchez
 */
public class Modelo implements IPersistible, Serializable {

    private int id;
    private TipoProducto tipoProducto;
    private String nombre;
    private int duracionGarantia;

    /**
     * Construye un nuevo objeto modelo
     */
    public Modelo() {
    }

    /**
     * Construye un nuevo objeto modelo
     * @param id
     */
    public Modelo(int id) {
        this.id = id;
    }

    /**
     * Obtiene el identificador de Modelo
     * @return devuelve el id de un modelo
     */
    public int getID() {
        return this.id;
    }

    /**
     * Obtiene el Tipo de Producto
     * @return devuelve el Tipo de Producto
     */
    public TipoProducto getTipoProducto() {
        return this.tipoProducto;
    }

    /**
     * Obtiene el nombre del modelo
     * @return devuelve el nombre del Modelo
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Setea el nombre del Modelo
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipoProducto(TipoProducto tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public void setDuracionGarantia(int duracionGarantia) {
        this.duracionGarantia = duracionGarantia;
    }

    /**
     * @return the duracionGarantia
     */
    public int getDuracionGarantia() {
        return duracionGarantia;
    }

    @Override
    public String toString() {
        return getNombre();
    }
}
