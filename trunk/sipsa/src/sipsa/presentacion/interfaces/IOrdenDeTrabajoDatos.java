package sipsa.presentacion.interfaces;

import javax.swing.ComboBoxModel;

import sipsa.SipsaExcepcion;
import sipsa.dominio.OrdenDeTrabajo;
import sipsa.dominio.Pac;

/**
 * Interface a implementar para controlar el fomulario OrdendeTrabajodatos
 * @author Claudio Rodrigo Pereyra Diaz
 * @author Maria Eugenia Sanchez
 */
public interface IOrdenDeTrabajoDatos {

    /**
     * Acción correspondiente al botón guardar ordenes de trabajo
     * @param ordenDeTrabajo
     * @throws SipsaExcepcion Si no es posible guardar la orden de trabajo
     */
    public void guardarOrdenDeTrabajo(OrdenDeTrabajo ordenDeTrabajo) throws SipsaExcepcion;

    /**
     *Obtiene la lista de Puntos de venta para llenar el comboBox
     * @return devuelve la lista de Puntos de Venta
     * @throws SipsaExcepcion Si no es posible obtener la lista de puntos de venta
     */
    public ComboBoxModel getListaPuntosDeVenta() throws SipsaExcepcion;

    /**
     * Obtiene la lista de los Modelos para llenar el comboBox
     * @return devuelve la lista de Modelos
     * @throws SipsaExcepcion Si no es posible obtener la lista de modelos
     */
    public ComboBoxModel getListaModelos() throws SipsaExcepcion;

    /**
     * Obtiene el Pac que esta operando las ordenes de trabajo
     * @return
     */
    public Pac getPac();
}
