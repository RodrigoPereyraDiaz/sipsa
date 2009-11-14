/*
 * Sistemas de Informacion II 2009
 * Proyecto Sipsa
 */

package sipsa.control;

import java.util.Iterator;
import java.util.List;
import javax.swing.table.DefaultTableModel;

import sipsa.dominio.TipoProducto;
import sipsa.presentacion.interfaces.IListarABM;
import sipsa.presentacion.escritorio.ListarABM;
import sipsa.presentacion.interfaces.ITipoProductoDatos;
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
        TipoProductoDatos tipoProductoDatos = new TipoProductoDatos(this, new TipoProducto());
        tipoProductoDatos.setVisible(true);
    }


    public void modificar(int index) {
        TipoProducto tipoProducto = this.getListaTipoProducto().get(index);
        TipoProductoDatos tipoProductoDatos = new TipoProductoDatos(this, tipoProducto);
        tipoProductoDatos.setVisible(true);
    }

    /**
     * Elimina del medio de persistencia el Tipo de Producto identificado
     * @param id Identificador unico de Tipo de Producto
     */

    public void eliminar(int index) {
        TipoProducto tipoProducto = this.getListaTipoProducto().get(index);
        persistencia.deteletTipoProducto(tipoProducto);
        this.listaTipoProducto.remove(tipoProducto);
    }

    /**
     * Obtiene la descripcion para utilizar en formularios genericos
     * @return Titulo para el jFrame
     */
    public String getDescripcion() {
        return "Tipo de Producto";
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

    /**
     * @return the listaTipoProducto
     */
    public List<TipoProducto> getListaTipoProducto() {
        this.listaTipoProducto = persistencia.getListTipoProducto();
        return listaTipoProducto;
    }

    /**
     * Guarda el Tipo de Producto en el sistema Sipsa
     * @param tipoProducto
     * @throws java.lang.Exception
     */
    public void guardarTipoProducto(TipoProducto tipoProducto) throws Exception {
        //TODO validar la garantia sea mayor a 0 meses
        if (this.persistencia.existTipoProducto(tipoProducto)){
           throw new Exception("El tipo de Producto ya existe, imposible agregar");
        } else {
            this.persistencia.saveTipoProducto(tipoProducto);
            this.listaTipoProducto.remove(tipoProducto);
        }
    }
}
