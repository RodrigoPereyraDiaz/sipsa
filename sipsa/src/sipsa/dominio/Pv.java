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

    public Pv() {
        this.setCuit("");
        this.setNombre("");
    }
    
    public Pv(int id) {
        this.id = id;
    }

    public int getID() {
        return this.id;
    }
}