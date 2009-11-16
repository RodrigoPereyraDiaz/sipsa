package sipsa.control;

import java.util.ArrayList;
import javax.swing.ComboBoxModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import sipsa.dominio.OrdenDeTrabajo;
import sipsa.dominio.TipoProducto;
import sipsa.presentacion.escritorio.ListarABM;
import sipsa.presentacion.escritorio.OrdenDeTrabajoDatos;
import sipsa.presentacion.interfaces.IListarABM;
import sipsa.presentacion.interfaces.IOrdenDeTrabajoDatos;

//TODO revisar los metodos agregar modificar eliminar para que dependan del estado
/**
 * Controlador de Ordenes de Trabajo
 * @author Claudio Rodrigo Pereyra Diaz
 * @author Maria Eugenia Sanchez
 */

public class OTControl implements IListarABM, IOrdenDeTrabajoDatos{

    private ArrayList<OrdenDeTrabajo> lista;
     /**
     * Muestra el formulario para administrar Ordenes de Trabajo
     */
    public void mostrarAdministrar(){
        ListarABM listarABM = new ListarABM(this);
        listarABM.setVisible(true);
    }

    public void agregar() {
        OrdenDeTrabajoDatos ordenDeTrabajoDatos = new OrdenDeTrabajoDatos(this, new OrdenDeTrabajo());
        ordenDeTrabajoDatos.setVisible(true);
    }

    public void modificar(int index) {
        OrdenDeTrabajo ordenDeTrabajo = lista.get(index);
        OrdenDeTrabajoDatos ordenDeTrabajoDatos = new OrdenDeTrabajoDatos(this, ordenDeTrabajo);
        ordenDeTrabajoDatos.setVisible(true);
    }

    public void eliminar(int index) {
        OrdenDeTrabajo ordenDeTrabajo = lista.get(index);
        OrdenDeTrabajoDatos ordenDeTrabajoDatos = new OrdenDeTrabajoDatos(this, ordenDeTrabajo);
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

    /**
     * Obtiene la lista de Ordenes de Trabajo realizadas
     * @return devuelve una lista de ordenes de Trabajo realizadas para mostrar en la tabla
     */
    public DefaultTableModel getOTRealizadas() {
        String[] columnNames = {"Nro de Orden", "Estado", "Nro Serie de Producto", "PAC"};
        //TODO completar
        DefaultTableModel modelo = new DefaultTableModel(columnNames, 0);
        return modelo;
    }

    /**
     * Obtiene la lista de Ordenes de Trabajo Pendientes
     * @return devuelve una lista de ordenes de trabajo pendientes para mostrar en la tabla
     */
    public DefaultTableModel getOTPendientes() {
        String[] columnNames = {"Nro de Orden", "Estado", "Nro Serie de Producto", "PAC"};
        //TODO completar
        DefaultTableModel modelo = new DefaultTableModel(columnNames, 0);
        return modelo;
    }

    /**
     * Obtiene la lista de Ordenes de Trabajo Pendientes para un PV específico
     * @param cuit
     * @return devuelve una lista de Ordenes de Trabajo pendientes para un PV específico
     */
    
    public DefaultTableModel getOTPendientes(String cuit) {
        String[] columnNames = {"Nro de Orden", "Estado", "Nro Serie de Producto"};
        //TODO completar
        DefaultTableModel modelo = new DefaultTableModel(columnNames, 0);
        return modelo;
    }

    /**
     * Obtiene la lista de Ordenes de Trabajo Realizadas para un PV específico
     * @param cuit
     * @return devuelve una lista de Ordenes de Trabajo realizadas para un PV específico
     */
    public DefaultTableModel getOTRealizadas(String cuit) {
        String[] columnNames = {"Nro de Orden", "Estado", "Nro Serie de Producto"};
        //TODO completar
        DefaultTableModel modelo = new DefaultTableModel(columnNames, 0);
        return modelo;
    }

    /**
     * Obtiene la lista de Ordenes de Trabajo Vencidas
     * @return devuelve una lista de Ordenes de Trabajo vencidas
     */
    public TableModel getOTVencidas() {
        String[] columnNames = {"Nro de Orden", "Estado", "Nro Serie de Producto"};
        //TODO completar
        TableModel modelo = new DefaultTableModel(columnNames, 0);
        return modelo;
    }

    /**
     * Obtiene la lista de Ordenes de Trabajo Vencidas para un PV específico
     * @param cuit
     * @return devuelve una lista de Ordenes de Trabajo para un PV específico
     */
    public TableModel getOTVencidas(String cuit) {
        String[] columnNames = {"Nro de Orden", "Estado", "Nro Serie de Producto"};
        //TODO completar
        DefaultTableModel modelo = new DefaultTableModel(columnNames, 0);
        return modelo;
    }
    /**
     * Guarda una orden de trabajo en el sistema Sipsa
     * @param ordenDeTrabajo
     * @throws java.lang.Exception Lanza una excepción si no se puede guardar
     * la orden de Trabajo
     */
    public void guardarOrdenDeTrabajo(OrdenDeTrabajo ordenDeTrabajo) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Obtiene una lista de Puntos de Venta
     * @return devuelve una lista de PV para cargar el ComboBOx
     */
    public ComboBoxModel getListaPuntosDeVenta() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Obtiene la lista de Tipos de Productos
     * @return devuelve una lista de Tipos de Productos para cargar el ComboBox
     */
    public ComboBoxModel getListaTiposProducto() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Obtiene la lista de Modelos para un Tipo de Producto específico
     * @param tipoProducto
     * @return devuelve una lista de Modelos para un Tipo de Prod específico,
     * para cargar el ComboBOx
     */
    public ComboBoxModel getListaModelos(TipoProducto tipoProducto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}