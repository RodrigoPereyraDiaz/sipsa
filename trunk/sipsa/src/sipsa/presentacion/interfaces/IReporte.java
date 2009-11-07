/*
 * Sistemas de Informacion II 2009
 * Proyecto Sipsa
 */

package sipsa.presentacion.interfaces;

/**
 * Interface a implementar los metodos necesarios para generar un Reporte
 * @author Claudio Rodrigo Pereyra Diaz
 * @author Maria Eugenia Sanchez
 */
public interface IReporte {
    //TODO definir los metodos faltantes para generar reportes
    /**
     * Obiene el nombre del Reporte a mostrar
     * @return
     */
    public String getNombre();
    /**
     * Accion para getReporte el reporte
     */
    public void getReporte();
    /**
     * Accion para imprimir el reporte
     */
    public void imprimir();
    /**
     * Accion para exportar el reporte
     */
    public void exportar();
}
