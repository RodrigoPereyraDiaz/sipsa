/*
 * Sistemas de Informacion II 2009
 * Proyecto Sipsa
 */
package sipsa.presentacion.interfaces;

import sipsa.SipsaExcepcion;
import sipsa.dominio.TipoProducto;

/**
 * Interface a implementar para controlar el fomulario TipoProductoDatos
 * @author Claudio Rodrigo Pereyra Diaz
 * @author Maria Eugenia Sanchez
 */
public interface ITipoProductoDatos {

    /**
     * Acción para guardar el Tipo de producto
     * @param tipoProducto
     * @throws SipsaExcepcion
     */
    public void guardarTipoProducto(TipoProducto tipoProducto) throws SipsaExcepcion;
}
