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
import sipsa.dominio.Empresa;
import sipsa.dominio.Pv;
import sipsa.persistencia.IPersistible;
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
    private List<Pv> listaPvs = null;

    private void recuperarLista(){
        if (getListaPvs() == null)
            listaPvs = new ArrayList<Pv>();
        try {
            List<IPersistible> lista = persistencia.recuperarLista(Pv.class);
            for (Iterator iterator = lista.iterator(); iterator.hasNext();) {
                Pv pv = (Pv) iterator.next();
                getListaPvs().add(pv);
            }
        } catch (SipsaExcepcion ex) {
            new DialogoMensaje(DialogoMensaje.Tipo.Error, ex.getLocalizedMessage());
        }
    }

    /**
     * Verifica la existencia del Punto de Venta
     * @param pv
     * @return devuelve el Punto de Venta si existe, sino muestra una excepción
     * @throws java.lang.Exception
     */
    
    public Pv existePv(Pv pv) throws Exception{
        pv = persistencia.existPv(pv);
        if (pv.getID() > 0){
            return pv;
        } else {
            throw new Exception("Pv no existe");
        }
    }
    /**
     * Muestra el formulario para Administrar Puntos de Venta
     */
    public void mostrarAdministrar(){
        this.recuperarLista();
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
    }

    public void modificar(int index) {
        EmpresaDatos formulario = new EmpresaDatos(this, this.getListaPvs().get(index));
        formulario.setVisible(true);
    }

    /**
     * eliminar del medio de persistencia el Punto de Venta identificado
     */
    public void eliminar(int index) {
        Pv pv = this.getListaPvs().get(index);
        this.persistencia.deletePv(pv);
        this.getListaPvs().remove(pv);
    }

    /**
     * Obtiene el modelo para llenar un jTable con los Puntos de Venta
     * @return TableModel de Puntos de Venta
     */
    public DefaultTableModel getModelo() {
        String[] columnNames = {"Cuit", "Nombre"};
        DefaultTableModel modelo = new DefaultTableModel(columnNames, 0);
        for (Iterator PvIt = this.getListaPvs().iterator(); PvIt.hasNext();) {
            Pv pv = (Pv) PvIt.next();
            Object[] datos = new Object[modelo.getColumnCount()];
            datos[0] = pv.getCuit();
            datos[1] = pv.getNombre();
            modelo.addRow(datos);
        }
        return modelo;
    }

    public void guardarEmpresa(Empresa empresa) throws Exception {
        Pv pv = (Pv) empresa;
        //TODO Validaciones
        if (this.persistencia.existPv(pv).equals(pv)){
            this.persistencia.savePv(pv);
            this.getListaPvs().add(pv);
        } else {
            throw new Exception("El punto de venta ya existe, imposible agregar");
        }
    }

    /**
     * @return the listaPvs
     */
    public List<Pv> getListaPvs() {
        if (listaPvs == null)
            this.recuperarLista();
        return listaPvs;
    }
}
