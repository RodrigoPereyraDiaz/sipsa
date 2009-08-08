/*
 * Sistemas de Informacion II 2009
 * Proyecto Sipsa
 */

package sipsa.gui.interfaces;

/**
 * Interface a implementar para controlar el fomulario TipoProductoDatos
 * @author Claudio Rodrigo Pereyra Diaz
 * @author Maria Eugenia Sanchez
 */
public interface ITipoProductoDatos {

    /**
     * Guarda en el medio de persistencia
     * @param modelo
     * @param nombre
     * @param duracionGarantia
     * @return Resultado de la Persistencia
     */
    Boolean aceptarDatosTipoProducto(String modelo, String nombre, int duracionGarantia);
    /**
     * Obtiene la descripcion para utilizar en formularios genericos
     * @return Titulo para el jFrame
     */
    String getDescripcion();

}
