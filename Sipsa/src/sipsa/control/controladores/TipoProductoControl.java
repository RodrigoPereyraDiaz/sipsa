/*
 * Sistemas de Informacion II 2009
 * Proyecto Sipsa
 */

package sipsa.control.controladores;

import java.util.Iterator;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import sipsa.presentacion.interfaces.ITipoProductoDatos;
import sipsa.presentacion.interfaces.IListarAgregarEliminar;
import sipsa.persistencia.FachadaPersistencia;
import sipsa.dominio.TipoProducto;
import sipsa.presentacion.escritorio.ListarAgregarEliminar;
import sipsa.presentacion.escritorio.TipoProductoDatos;

/**
 * Controlador de Tipo de Producto
 * @author Claudio Rodrigo Pereyra Diaz
 * @author Maria Eugenia Sanchez
 */
public class TipoProductoControl implements IListarAgregarEliminar, ITipoProductoDatos{

    private FachadaPersistencia persistencia = new FachadaPersistencia();
    private List<TipoProducto> listaTipoProducto;

    /**
     * Muestra el administrador de Tipos de Productos
     */
    public void MostrarAdministrar(){
        ListarAgregarEliminar listarControl = new ListarAgregarEliminar(this);
        listarControl.setVisible(true);
    }

    /**
     * Muestra el formulario para agregar un nuevo Tipo de Producto
     */
    public void Agregar() {
        TipoProductoDatos tipoProductoDatos = new TipoProductoDatos(this);
        tipoProductoDatos.setVisible(true);
    }

    /**
     * Elimina del medio de persistencia el Tipo de Producto identificado
     * @param id Identificador unico de Tipo de Producto
     */
    public void Eliminar(int index) {
        TipoProducto tipoProducto = this.listaTipoProducto.get(index);
        persistencia.deteletTipoProducto(tipoProducto);
    }

    /**
     * Obtiene la descripcion para utilizar en formularios genericos
     * @return Titulo para el jFrame
     */
    public String getDescripcion() {
        return "Tipo de Producto";
    }

    /**
     * Guardar en el medio de persistencia el nuevo Tipo de Producto
     * @param modelo Modelo del Tipo de Producto
     * @param nombre Nombre del Tipo de Producto
     * @param duracionGarantia Duracion de la garantia en meses del tipo de producto
     * @return Resultado de la persistencia
     */
    public Boolean aceptarDatosTipoProducto(String modelo, String nombre, int duracionGarantia){
        TipoProducto tp = new TipoProducto();
        tp.setModelo(modelo);
        tp.setDescripcion(nombre);
        tp.setDuracionGarantia(duracionGarantia);
        if (this.persistencia.existTipoProducto(tp)){
           //TODO informar que ya existe
           return false;
        } else {
           return this.persistencia.saveTipoProducto(tp);
        }
    }

    /**
     * Obtiene el modelo para llenar un jTable con los Tipos de Productos
     * @return TableModel de Tipos de Productos
     */
    public DefaultTableModel getModelo() {
        String[] columnNames = {"Modelo", "Descripcion", "Duracion Garantia"};
        DefaultTableModel modelo = new DefaultTableModel(columnNames, 0);
        this.listaTipoProducto = persistencia.getListTipoProducto();
        for (Iterator tpIt = this.listaTipoProducto.iterator(); tpIt.hasNext();) {
            TipoProducto tipoProducto = (TipoProducto) tpIt.next();
            Object[] datos = new Object[modelo.getColumnCount()];
            datos[0] = tipoProducto.getModelo();
            datos[1] = tipoProducto.getDescripcion();
            datos[2] = tipoProducto.getDuracionGarantia();
            modelo.addRow(datos);
        }
        return modelo;
    }
}
