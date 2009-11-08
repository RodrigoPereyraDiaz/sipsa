package sipsa.dominio;

import sipsa.persistencia.IPersistible;

public class Fabrica implements IPersistible {

    private int id;
    private String nombre;

    public Fabrica(int id) {
        this.id = id;
    }

    public int getID() {
        return this.id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}