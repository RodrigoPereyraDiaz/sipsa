package sipsa.presentacion.interfaces;

import javax.swing.ComboBoxModel;

import sipsa.SipsaExcepcion;
import sipsa.dominio.OrdenDeTrabajo;

/**
 * Interface a implementar para controlar el fomulario OrdendeTrabajodatos
 * @author Claudio Rodrigo Pereyra Diaz
 * @author Maria Eugenia Sanchez
 */
public interface IOrdenDeTrabajoDatos {

    /**
     * Acción correspondiente al botón guardar ordenes de trabajo
     * @param ordenDeTrabajo
     * @throws java.lang.Exception
     */
    public void guardarOrdenDeTrabajo(OrdenDeTrabajo ordenDeTrabajo) throws SipsaExcepcion;

    /**
     *Obtiene la lista de Puntos de venta para llenar el comboBox
     * @return devuelve la lista de Puntos de Venta
     */
    public ComboBoxModel getListaPuntosDeVenta();

    /**
     * Obtiene la lista de Tipos de Productos para llenar el comboBox
     * @return devuelve la lista de Tipos de Productos
     */
    public ComboBoxModel getListaTiposProducto();

    /**
     * Obtiene la lista de los Modelos para llenar el comboBox
     * @param tipoProducto
     * @return devuelve la lista de Modelos
     */
    public ComboBoxModel getListaModelos(Object tipoProducto);
}
