package sipsa.dominio;

import sipsa.persistencia.IPersistible;

/**
 * Fabrica
 * @author Claudio Rodrigo Pereyra Diaz
 * @author Maria Eugenia Sanchez
 */
public class Fabrica implements IPersistible {

    private int id;
    private String nombre;

    /**
     *
     * @param id
     */
    public Fabrica(int id) {
        this.id = id;
    }

    /**
     * Obtiene el Id de la fabrica
     * @return el id de la fabrica
     */
    public int getID() {
        return this.id;
    }

    /**
     * Obtiene el nombre de la fabrica
     * @return el nombre d ela fabrica
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * setea el nombre de la fabrica
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}