/*
 * Sistemas de Informacion II 2009
 * Proyecto Sipsa
 */

package sipsa.dominio;

import java.io.Serializable;
import sipsa.persistencia.IPersistible;

/**
 * Punto de Atencion al Cliente
 * @author Claudio Rodrigo Pereyra Diaz
 * @author Maria Eugenia Sanchez
 */
public class Pac implements IPersistible, Serializable{
    private int id;
    private String cuit;
    private String nombre;

    public Pac() {
        
    }

    public Pac(int id) {
        this.id = id;
    }

    public int getID() {
        return this.id;
    }

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
        System.out.println("Pac set cuit");
        this.cuit = cuit;
    }
}