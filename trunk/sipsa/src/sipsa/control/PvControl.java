/*
 * Sistemas de Informacion II 2009
 * Proyecto Sipsa
 */
package sipsa.control;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import sipsa.SipsaExcepcion;
import sipsa.dominio.Empresa;
import sipsa.dominio.Pv;
import sipsa.persistencia.Persistencia;
import sipsa.presentacion.escritorio.DialogoMensaje;
import sipsa.presentacion.interfaces.IListarABM;
import sipsa.presentacion.interfaces.IEmpresaDatos;
import sipsa.presentacion.escritorio.EmpresaDatos;
import sipsa.presentacion.escritorio.ListarABM;

/**
 * Controlador de Punto de Venta
 * @author Claudio Rodrigo Pereyra Diaz
 * @author Maria Eugenia Sanchez
 */
public class PvControl implements IEmpresaDatos, IListarABM {

    private Persistencia persistencia = Persistencia.getPersistencia();
    private List<Pv> lista;

    private void recuperarLista() {
        lista = new ArrayList<Pv>();
        try {
            for (Iterator iterator = persistencia.recuperarLista(Pv.class).iterator(); iterator.hasNext();) {
                Pv pv = (Pv) iterator.next();
                lista.add(pv);
            }
        } catch (SipsaExcepcion ex) {
            new DialogoMensaje(DialogoMensaje.Tipo.Error, ex.getLocalizedMessage());
        }
    }

    /**
     * Muestra el formulario para Administrar Puntos de Venta
     */
    public void mostrarABM() {
        recuperarLista();
        ListarABM listarABMPv = new ListarABM(this);
        listarABMPv.setVisible(true);
    }

    /**
     * Obtiene la descripcion para utilizar en formularios genericos
     * @return Titulo para el jFrame
     */
    public String getDescripcion() {
        return "Punto de Venta";
    }

    /**
     * Muestra el formulario para agregar un nuevo Punto de Venta
     */
    public void agregar() {
        EmpresaDatos formulario = new EmpresaDatos(this, new Pv());
        formulario.setVisible(true);
        recuperarLista();
    }

    public void modificar(int index) {
        EmpresaDatos formulario = new EmpresaDatos(this, this.getListaPvs().get(index));
        formulario.setVisible(true);
        recuperarLista();
    }

    /**
     * eliminar del medio de persistencia el Punto de Venta identificado
     */
    public void eliminar(int index) {
        Pv pv = this.getListaPvs().get(index);
        try {
            this.persistencia.eliminar(pv);
            recuperarLista();
        } catch (SipsaExcepcion ex) {
            new DialogoMensaje(DialogoMensaje.Tipo.Error, ex.getLocalizedMessage());
        }
    }

    /**
     * Obtiene el modelo para llenar un jTable con los Puntos de Venta
     * @return TableModel de Puntos de Venta
     */
    public TableModel getTableModel() {
        String[] columnNames = {"Cuit", "Nombre"};
        DefaultTableModel modelo = new DefaultTableModel(columnNames, 0);
        recuperarLista();
        for (Iterator PvIt = this.getListaPvs().iterator(); PvIt.hasNext();) {
            Pv pv = (Pv) PvIt.next();
            Object[] datos = new Object[modelo.getColumnCount()];
            datos[0] = pv.getCuit();
            datos[1] = pv.getNombre();
            modelo.addRow(datos);
        }
        return modelo;
    }

    /**
     * Obtiene la listsa de Puntos de Venta para usar en un ComboBox
     * @return Modelo del ComboBox cargado con los puntos de venta
     */
    public ComboBoxModel getComboBox() {
        DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel();
        recuperarLista();
        for (Object o : lista) {
            comboBoxModel.addElement(o);
        }
        return comboBoxModel;
    }

    public void guardarEmpresa(Empresa empresa) throws SipsaExcepcion {
        Pv pv = (Pv) empresa;
        if (pv.getCuit().equals("") || pv.getNombre().equals("")) {
            throw new SipsaExcepcion("Debe completar todos los datos solicitados");
        }
        if (!CUIT.validaCuit(pv.getCuit())) {
            throw new SipsaExcepcion("El Cuit ingresado no es valido, debe escribir el cuit sin guiones");
        }
        if (pv.getID() > 0) {
            persistencia.actualizar(pv);
        } else {
            if (persistencia.existe(pv) == null) {
                persistencia.guardar(pv);
            } else {
                throw new SipsaExcepcion("El Punto de Venta ya exite. Imposible agregar");
            }
        }
        recuperarLista();
    }

    /**
     * Obtiene la lista de Puntos de Venta
     * @return the listaPvs
     */
    public List<Pv> getListaPvs() {
        recuperarLista();
        return lista;
    }

    /**
     * Verifica la existencia del Punto de Venta
     * @param pv
     * @return devuelve el Punto de Venta si existe, sino muestra una excepción
     * @throws SipsaExcepcion si no se puede verificar la existencia del punto de venta
     */
    public Pv existePv(Pv pv) throws SipsaExcepcion {
        pv = (Pv) persistencia.existe(pv);
        if (pv == null) {
            throw new SipsaExcepcion("El Punto de Venta no existe");
        } else {
            return pv;
        }
    }
}
