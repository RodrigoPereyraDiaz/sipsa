package sipsa.control;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import sipsa.dominio.OrdenDeTrabajo;
import sipsa.presentacion.escritorio.ListarABM;
import sipsa.presentacion.escritorio.OrdenDeTrabajoDatos;
import sipsa.presentacion.interfaces.IListarABM;
import sipsa.presentacion.interfaces.IOrdenDeTrabajoDatos;

//TODO revisar los metodos agregar modificar eliminar para que dependan del estado
public class OTControl implements IListarABM, IOrdenDeTrabajoDatos{

     /**
     * Muestra el formulario para administrar Ordenes de Trabajo
     */
    public void mostrarAdministrar(){
        ListarABM listarABM = new ListarABM(this);
        listarABM.setVisible(true);
    }

    public void agregar() {
        OrdenDeTrabajoDatos ordenDeTrabajoDatos = new OrdenDeTrabajoDatos(this);
        ordenDeTrabajoDatos.setVisible(true);
    }

    public void modificar(int index) {
        OrdenDeTrabajoDatos ordenDeTrabajoDatos = new OrdenDeTrabajoDatos(this);
        ordenDeTrabajoDatos.setVisible(true);
    }

    public void eliminar(int index) {
        OrdenDeTrabajoDatos ordenDeTrabajoDatos = new OrdenDeTrabajoDatos(this);
        ordenDeTrabajoDatos.setVisible(true);
    }

    public String getDescripcion() {
        return "Orden de Trabajo";
    }

    public DefaultTableModel getModelo() {
        String[] columnNames = {"Nro de Orden", "Estado", "Nro Serie de Producto"};
        //TODO completar
        DefaultTableModel modelo = new DefaultTableModel(columnNames, 0);
        return modelo;
    }

    public DefaultTableModel getOTRealizadas() {
        String[] columnNames = {"Nro de Orden", "Estado", "Nro Serie de Producto", "PAC"};
        //TODO completar
        DefaultTableModel modelo = new DefaultTableModel(columnNames, 0);
        return modelo;
    }

    public DefaultTableModel getOTPendientes() {
        String[] columnNames = {"Nro de Orden", "Estado", "Nro Serie de Producto", "PAC"};
        //TODO completar
        DefaultTableModel modelo = new DefaultTableModel(columnNames, 0);
        return modelo;
    }

    public DefaultTableModel getOTPendientes(String cuit) {
        String[] columnNames = {"Nro de Orden", "Estado", "Nro Serie de Producto"};
        //TODO completar
        DefaultTableModel modelo = new DefaultTableModel(columnNames, 0);
        return modelo;
    }

    public DefaultTableModel getOTRealizadas(String cuit) {
        String[] columnNames = {"Nro de Orden", "Estado", "Nro Serie de Producto"};
        //TODO completar
        DefaultTableModel modelo = new DefaultTableModel(columnNames, 0);
        return modelo;
    }

    public TableModel getOTVencidas() {
        String[] columnNames = {"Nro de Orden", "Estado", "Nro Serie de Producto"};
        //TODO completar
        DefaultTableModel modelo = new DefaultTableModel(columnNames, 0);
        return modelo;
    }

    public TableModel getOTVencidas(String cuit) {
        String[] columnNames = {"Nro de Orden", "Estado", "Nro Serie de Producto"};
        //TODO completar
        DefaultTableModel modelo = new DefaultTableModel(columnNames, 0);
        return modelo;
    }

    public void aceptarDatos(OrdenDeTrabajo ordenDeTrabajo) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}