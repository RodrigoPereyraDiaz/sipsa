package sipsa.dominio;

import sipsa.persistencia.IPersistible;

public class Modelo implements IPersistible{

    private int id;
    private TipoProducto tipoProducto;
    private String nombre;

    public Modelo(int id) {
        this.id = id;
    }

    public int getID() {
        return this.id;
    }

    public TipoProducto getTipoProducto() {
        return this.tipoProducto;
    }

    public void setTipoProducto(TipoProducto tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
