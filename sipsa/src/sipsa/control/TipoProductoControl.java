/*
 * Sistemas de Informacion II 2009
 * Proyecto Sipsa
 */

package sipsa.control;

import java.util.Iterator;
import java.util.List;
import javax.swing.table.DefaultTableModel;

import sipsa.dominio.TipoProducto;
import sipsa.presentacion.interfaces.ITipoProductoDatos;
import sipsa.presentacion.interfaces.IListarABM;
import sipsa.presentacion.escritorio.ListarABM;
import sipsa.presentacion.escritorio.TipoProductoDatos;
import sipsa.persistencia.Persistencia;

/**
 * Controlador de Tipo de Producto
 * @author Claudio Rodrigo Pereyra Diaz
 * @author Maria Eugenia Sanchez
 */
public class TipoProductoControl implements IListarABM, ITipoProductoDatos{

    private Persistencia persistencia = Persistencia.getPersistencia();
    private List<TipoProducto> listaTipoProducto;

    /**
     * Muestra el administrador de Tipos de Productos
     */
    public void mostrarAdministrar(){
        ListarABM listarControl = new ListarABM(this);
        listarControl.setVisible(true);
    }

    /**
     * Muestra el formulario para agregar un nuevo Tipo de Producto
     */
    public void agregar() {
        TipoProductoDatos tipoProductoDatos = new TipoProductoDatos(this);
        tipoProductoDatos.setVisible(true);
    }

    /**
     * Elimina del medio de persistencia el Tipo de Producto identificado
     * @param id Identificador unico de Tipo de Producto
     */
    public void eliminar(int index) {
        TipoProducto tipoProducto = this.getListaTipoProducto().get(index);
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
    public void aceptarDatosTipoProducto(String nombre, int duracionGarantia) throws Exception {
        //FIXME ver como agregar los modelos
        TipoProducto tp = new TipoProducto();
        tp.setDescripcion(nombre);
        tp.setDuracionGarantia(duracionGarantia);
        if (this.persistencia.existTipoProducto(tp)){
           throw new Exception("El tipo de Producto ya existe, imposible agregar");
        } else {
            this.persistencia.saveTipoProducto(tp);
        }
    }

    /**
     * Obtiene el modelo para llenar un jTable con los Tipos de Productos
     * @return TableModel de Tipos de Productos
     */
    public DefaultTableModel getModelo() {
        String[] columnNames = {"Modelo", "Descripcion", "Duracion Garantia"};
        DefaultTableModel modelo = new DefaultTableModel(columnNames, 0);
        for (Iterator tpIt = this.getListaTipoProducto().iterator(); tpIt.hasNext();) {
            TipoProducto tipoProducto = (TipoProducto) tpIt.next();
            Object[] datos = new Object[modelo.getColumnCount()];
            datos[0] = tipoProducto.getDescripcion();
            datos[1] = tipoProducto.getDuracionGarantia();
            modelo.addRow(datos);
        }
        return modelo;
    }

    public void modificar(int index) {
        //FIXME manejar la modificacion de los tipos de productos
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * @return the listaTipoProducto
     */
    public List<TipoProducto> getListaTipoProducto() {
        this.listaTipoProducto = persistencia.getListTipoProducto();
        return listaTipoProducto;
    }

}
