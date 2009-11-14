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

    public Pac() {
        this.setCuit("");
        this.setNombre("");
    }

    public Pac(int id) {
        this.id = id;
    }

    public int getID() {
        return this.id;
    }
}