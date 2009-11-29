package sipsa.presentacion.interfaces;

import javax.swing.ComboBoxModel;
import sipsa.SipsaExcepcion;
import sipsa.dominio.Modelo;

/**
 * Intefacer que define los metodos para controlar la interface de usuario ModeloDatos
  * @author Claudio Rodrigo Pereyra Diaz
 * @author Maria Eugenia Sanchez
 */
public interface IModeloDatos {

    /**
     * Accion correspondiente al boton guardar
     * @param modelo Modelo a guardar
     * @throws SipsaExcepcion si no es posible guardar el modelo
     */
    public void guardar(Modelo modelo) throws SipsaExcepcion;
    /**
     * Obtiene la lista de Tipos de Productos para cargar el combo correspondiente
     * @return
     */
    public ComboBoxModel getTiposProducto();
}
