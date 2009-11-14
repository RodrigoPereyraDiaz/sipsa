package sipsa.control;

import javax.swing.table.TableModel;
import sipsa.presentacion.interfaces.IReporte;

/**
 * Controlador de Reporte
 * @author Claudio Rodrigo Pereyra Diaz
 * @author Maria Eugenia Sanchez
 */
public class Reporte implements IReporte{
    private TableModel tableModel;
    private String nombre;

    /**
     * Obtiene los datos del Reporte
     * @return devuelve una tabla con los datos del reporte
     */
    public TableModel getDatos() {
        return this.tableModel;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void imprimir() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void exportar() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Establece los datos en la tabla
     * @param datos
     */
    public void setDatos(TableModel datos) {
        this.tableModel = datos;
    }

    /**
     * Establece el nombre del Reporte
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}