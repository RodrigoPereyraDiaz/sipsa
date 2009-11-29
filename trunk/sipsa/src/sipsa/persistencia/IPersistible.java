/*
 * Sistemas de Informacion II 2009
 * Proyecto Sipsa
 */
package sipsa.persistencia;

import java.io.Serializable;

/**
 * Interface a implementar para controlar que los objetos sean persistibles
 * @author Claudio Rodrigo Pereyra Diaz
 * @author Maria Eugenia Sanchez
 */
public interface IPersistible extends Serializable {

    /**
     * obtiene el identificador de la clase que lo implemente
     * @return devuelve el identificador
     */
    public int getID();
}
