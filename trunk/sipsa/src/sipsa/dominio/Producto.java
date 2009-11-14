/*
 * Sistemas de Informacion II 2009
 * Proyecto Sipsa
 */

package sipsa.dominio;

import java.io.Serializable;
import java.util.Date;
import sipsa.persistencia.IPersistible;

/**
 * Producto
 * @author Claudio Rodrigo Pereyra Diaz
 * @author Maria Eugenia Sanchez
 */
public class Producto implements IPersistible, Serializable {
    private int id;
    private Modelo modelo;
    private String nroSerie;
    private Fabrica fabrica;
    private Date fechaFabricacion;

    public Producto() {

    }
    
    public Producto(int id) {
        this.id = id;
    }

    public int getID() {
        return this.id;
    }

    public Modelo getModelo() {
        return this.modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    /**
     * @return the nroSerie
     */
    public String getNroSerie() {
        return nroSerie;
    }

    /**
     * @param nroSerie the nroSerie to set
     */
    public void setNroSerie(String nroSerie) {
        this.nroSerie = nroSerie;
    }

    /**
     * @return the fechaFabricacion
     */
    public Date getFechaFabricacion() {
        return this.fechaFabricacion;
    }

    /**
     * @param fechaFabricacion the fechaFabricacion to set
     */
    public void setFechaFabricacion(Date fechaFabricacion) {
        this.fechaFabricacion = fechaFabricacion;
    }

    /**
     * @return the fabrica
     */
    public Fabrica getFabrica() {
        return this.fabrica;
    }

    /**
     * @param fabrica the fabrica to set
     */
    public void setFabrica(Fabrica fabrica) {
        this.fabrica = fabrica;
    }
}
