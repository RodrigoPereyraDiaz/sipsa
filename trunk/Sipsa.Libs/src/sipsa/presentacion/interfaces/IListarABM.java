/*
 * Sistemas de Informacion II 2009
 * Proyecto Sipsa
 */

package sipsa.presentacion.interfaces;

import javax.swing.table.DefaultTableModel;
/**
 * Interface a implementar para controlar el fomulario ListarAgregarEliminar
 * @author Claudio Rodrigo Pereyra Diaz
 * @author Maria Eugenia Sanchez
 */
public interface IListarABM {

    /**
     * Accion correspondiente al boton agregar
     */
    public void agregar();
    /**
     * Accion correspondiente al boton eliminar
     * @param id Identificar de la fila seleccionada en el jTable
     */
    public void eliminar(int index);
    /**
     * Obtiene la descripcion para utilizar en formularios genericos
     * @return Titulo para el jFrame
     */
    public String getDescripcion();
    /**
     * Obtiene el modelo para llenar un jTable con el contenido y estrutura definido
     * @return TableModel de la Clase de Dominio
     */
    public DefaultTableModel getModelo();
}