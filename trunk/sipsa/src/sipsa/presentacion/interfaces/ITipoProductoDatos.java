/*
 * Sistemas de Informacion II 2009
 * Proyecto Sipsa
 */

package sipsa.presentacion.interfaces;

/**
 * Interface a implementar para controlar el fomulario TipoProductoDatos
 * @author Claudio Rodrigo Pereyra Diaz
 * @author Maria Eugenia Sanchez
 */
public interface ITipoProductoDatos {

    /**
     * Guarda en el medio de persistencia
     * @param nombre
     * @param duracionGarantia
     * @return Resultado de la Persistencia
     */
    public void aceptarDatosTipoProducto(String nombre, int duracionGarantia) throws Exception;
}
