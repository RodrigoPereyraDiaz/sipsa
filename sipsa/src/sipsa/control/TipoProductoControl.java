/*
 * Sistemas de Informacion II 2009
 * Proyecto Sipsa
 */
package sipsa.control;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.table.DefaultTableModel;

import sipsa.SipsaExcepcion;
import sipsa.dominio.TipoProducto;
import sipsa.presentacion.interfaces.IListarABM;
import sipsa.presentacion.escritorio.ListarABM;
import sipsa.presentacion.interfaces.ITipoProductoDatos;
import sipsa.presentacion.escritorio.TipoProductoDatos;
import sipsa.persistencia.Persistencia;
import sipsa.presentacion.escritorio.DialogoMensaje;

/**
 * Controlador de Tipo de Producto
 * @author Claudio Rodrigo Pereyra Diaz
 * @author Maria Eugenia Sanchez
 */
public class TipoProductoControl implements IListarABM, ITipoProductoDatos {

    private Persistencia persistencia = Persistencia.getPersistencia();
    private List<TipoProducto> lista;

    private void recuperarLista() {
        lista = new ArrayList<TipoProducto>();
        try {
            for (Iterator iterator = persistencia.recuperarLista(TipoProducto.class).iterator(); iterator.hasNext();) {
                TipoProducto tipoProducto = (TipoProducto) iterator.next();
                lista.add(tipoProducto);
            }
        } catch (SipsaExcepcion ex) {
            new DialogoMensaje(DialogoMensaje.Tipo.Error, ex.getLocalizedMessage());
        }
    }

    /**
     * Muestra el administrador de Tipos de Productos
     */
    public void mostrarAdministrar() {
        ListarABM listarControl = new ListarABM(this);
        listarControl.setVisible(true);
    }

    /**
     * Muestra el formulario para agregar un nuevo Tipo de Producto
     */
    public void agregar() {
        TipoProductoDatos tipoProductoDatos = new TipoProductoDatos(this, new TipoProducto());
        tipoProductoDatos.setVisible(true);
        recuperarLista();
    }

    public void modificar(int index) {
        TipoProducto tipoProducto = this.getListaTipoProducto().get(index);
        TipoProductoDatos tipoProductoDatos = new TipoProductoDatos(this, tipoProducto);
        tipoProductoDatos.setVisible(true);
        recuperarLista();
    }

    /**
     * Elimina del medio de persistencia el Tipo de Producto identificado
     * @param index
     */
    public void eliminar(int index) {
        TipoProducto tipoProducto = this.getListaTipoProducto().get(index);
        try {
            persistencia.eliminar(tipoProducto);
            recuperarLista();
        } catch (SipsaExcepcion ex) {
            new DialogoMensaje(DialogoMensaje.Tipo.Error, ex.getLocalizedMessage());
        }
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
        String[] columnNames = {"Descripcion", "Duracion Garantia"};
        DefaultTableModel modelo = new DefaultTableModel(columnNames, 0);
        recuperarLista();
        for (Iterator tpIt = lista.iterator(); tpIt.hasNext();) {
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
        recuperarLista();
        return lista;
    }

    /**
     * Guarda el Tipo de Producto en el sistema Sipsa
     * @param tipoProducto
     * @throws java.lang.Exception
     */
    public void guardarTipoProducto(TipoProducto tipoProducto) throws SipsaExcepcion {
        if (tipoProducto.getDescripcion().equals("")) {
            throw new SipsaExcepcion("Debe completar todos los datos solicitados");
        }
        if (tipoProducto.getDuracionGarantia() <= 0) {
            throw new SipsaExcepcion("La duración de la garantia debe ser mayor a 0 meses");
        }
        if (tipoProducto.getModelos().isEmpty()) {
            throw new SipsaExcepcion("Debe definir por lo menos un Modelo del Tipo de Producto");
        }
        if (tipoProducto.getID() > 0) {
            persistencia.actualizar(tipoProducto);
        } else {
            if (persistencia.existe(tipoProducto) == null) {
                persistencia.guardar(tipoProducto);
            } else {
                throw new SipsaExcepcion("El Punto de Atencion ya exite, imposible agregar");
            }
        }
        recuperarLista();
    }
}
