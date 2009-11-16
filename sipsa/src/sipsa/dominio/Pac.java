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
public class Pac extends Empresa implements IPersistible, Serializable{
    private int id;

    /**
     * Construye un nuevo objeto Pac
     */
    public Pac() {
    }

    /**
     * Construye un nuevo objeto Pac
     * @param id
     */
    public Pac(int id) {
        this.id = id;
    }

    /**
     * Obtiene el identificador del Pac
     * @return
     */
    public int getID() {
        return this.id;
    }
}