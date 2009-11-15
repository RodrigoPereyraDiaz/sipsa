/*
 * Sistemas de Informacion II 2009
 * Proyecto Sipsa
 */

package sipsa.dominio;

import java.io.Serializable;
import sipsa.persistencia.IPersistible;

/**
 * Punto de Venta
 * @author Claudio Rodrigo Pereyra Diaz
 * @author Maria Eugenia Sanchez
 */
public class Pv extends Empresa implements IPersistible, Serializable {
    private int id;

    /**
     * Construye un nuevo objeto PV
     */
    public Pv() {
    }
    
    /**
     * Construye un nuevo objeto PV
     * @param id
     */
    public Pv(int id) {
        this.id = id;
    }

    /**
     * Obtiene el identificador del PV
     * @return devuelve el identificador del PV
     */
    public int getID() {
        return this.id;
    }
}