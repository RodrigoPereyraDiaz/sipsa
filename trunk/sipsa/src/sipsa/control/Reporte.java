package sipsa.control;

import javax.swing.table.TableModel;
import sipsa.presentacion.interfaces.IReporte;

public class Reporte implements IReporte{
    private TableModel tableModel;
    private String nombre;

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

    public void setDatos(TableModel oTRealizadas) {
        this.tableModel = oTRealizadas;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}