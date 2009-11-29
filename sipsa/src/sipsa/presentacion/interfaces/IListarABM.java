/*
 * Sistemas de Informacion II 2009
 * Proyecto Sipsa
 */
package sipsa.presentacion.interfaces;

import javax.swing.table.TableModel;

/**
 * Interface a implementar para controlar el fomulario ListarAgregarEliminar
 * @author Claudio Rodrigo Pereyra Diaz
 * @author Maria Eugenia Sanchez
 */
public interface IListarABM {

    /**
     * Accion correspondiente al boton Agregar
     */
    public void agregar();

    /**
     * Accion correspondiente al boton Modificar
     * @param index id de la fila seleccionada en el jTable
     */
    public void modificar(int index);

    /**
     * Accion correspondiente al boton Eliminar
     * @param index id de la fila seleccionada en el jTable
     */
    public void eliminar(int index);

    /**
     * Obtiene la descripcion para utilizar en formularios genericos
     * @return Titulo para la Interface de Usuario
     */
    public String getDescripcion();

    /**
     * Obtiene el modelo para llenar un jTable con el contenido y estrutura definido
     * @return TableModel de la Clase de Dominio
     */
    public TableModel getTableModel();

    public void mostrarABM();
}
