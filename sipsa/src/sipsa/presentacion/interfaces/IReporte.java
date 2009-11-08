/*
 * Sistemas de Informacion II 2009
 * Proyecto Sipsa
 */

package sipsa.presentacion.interfaces;

import javax.swing.table.TableModel;

/**
 * Interface a implementar los metodos necesarios para generar un Reporte
 * @author Claudio Rodrigo Pereyra Diaz
 * @author Maria Eugenia Sanchez
 */
public interface IReporte {

    public TableModel getDatos();
    /**
     * Obiene el nombre del Reporte a mostrar
     * @return
     */
    public String getNombre();
    /**
     * Accion para imprimir el reporte
     */
    public void imprimir() throws Exception;
    /**
     * Accion para exportar el reporte
     */
    public void exportar() throws Exception;
}
