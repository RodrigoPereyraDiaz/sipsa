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

    /**
     * Obtiene los datos del reporte a mostrar
     * @return devuelve los datos a mostrar en el TableModel
     */
    public TableModel getDatos();

    /**
     * Obiene el nombre del Reporte a mostrar
     * @return devuelve el nombre del reporte a mostrar 
     */
    public String getNombre();

    /**
     * Accion para imprimir el reporte
     * @throws Exception
     */
    public void imprimir() throws Exception;

    /**
     * Accion para exportar el reporte
     * @throws Exception 
     */
    public void exportar() throws Exception;
}
