/*
 * Sistemas de Informacion II 2009
 * Proyecto Sipsa
 */

package sipsa.presentacion.interfaces;

import sipsa.dominio.TipoProducto;

/**
 * Interface a implementar para controlar el fomulario TipoProductoDatos
 * @author Claudio Rodrigo Pereyra Diaz
 * @author Maria Eugenia Sanchez
 */
public interface ITipoProductoDatos {

    public void guardarTipoProducto(TipoProducto tipoProducto) throws Exception;
}
