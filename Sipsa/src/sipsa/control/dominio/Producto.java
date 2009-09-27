/*
 * Sistemas de Informacion II 2009
 * Proyecto Sipsa
 */

package sipsa.control.dominio;

import java.util.Date;

/**
 * Producto
 * @author Claudio Rodrigo Pereyra Diaz
 * @author Maria Eugenia Sanchez
 */
public class Producto extends TipoProducto {
    private  String nroSerie;
    private Date fechaFabricacion;
    private String fabrica;

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
        return fechaFabricacion;
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
    public String getFabrica() {
        return fabrica;
    }

    /**
     * @param fabrica the fabrica to set
     */
    public void setFabrica(String fabrica) {
        this.fabrica = fabrica;
    }
    
}
