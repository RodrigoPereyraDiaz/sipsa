/*
 * Sistemas de Informacion II 2009
 * Proyecto Sipsa
 */

package sipsa.controles;

import java.util.Iterator;
import java.util.List;
import javax.swing.table.DefaultTableModel;

import sipsa.dominio.Pv;
import sipsa.persistencia.FachadaPersistencia;
import sipsa.gui.interfaces.IListarAgregarEliminar;
import sipsa.gui.interfaces.IEmpresaDatos;
import sipsa.gui.escritorio.EmpresaDatos;
import sipsa.gui.escritorio.ListarAgregarEliminar;

/**
 * Controlador de Punto de Venta
 * @author Claudio Rodrigo Pereyra Diaz
 * @author Maria Eugenia Sanchez
 */
public class PvControl implements IEmpresaDatos, IListarAgregarEliminar {

    private FachadaPersistencia persistencia = new FachadaPersistencia();
    private List<Pv> listaPv;
    /**
     * Muestra el formulacion para Administrar Puntos de Venta
     */
    public void MostrarAdministrar(){
        ListarAgregarEliminar listarControl = new ListarAgregarEliminar(this);
        listarControl.setVisible(true);
    }

    /**
     * Guarda en el medio de persistencia el nuevo Punto de Venta
     * @param cuit CUIT del Punto de Venta
     * @param nombre Nombre del Punto de venta
     * @return Resultado de la persistencia
     */
    public Boolean aceptarDatosEmpresa(String cuit, String nombre) {
        Pv pv = new Pv();
        pv.setCuit(cuit);
        pv.setNombre(nombre);
        if (this.persistencia.existPv(pv)){
           //TODO informar que ya existe
           return false;
        } else {
           return this.persistencia.savePv(pv);
        }
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
    public void Agregar() {
        EmpresaDatos formulario = new EmpresaDatos(this);
        formulario.setVisible(true);
    }

    /**
     * Eliminar del medio de persistencia el Punto de Venta identificado
     * @param id Identificador unico del Punto de Venta
     */
    public void Eliminar(int index) {
        Pv pv = this.listaPv.get(index);
        this.persistencia.deletePv(pv);
    }

    /**
     * Obtiene el modelo para llenar un jTable con los Puntos de Venta
     * @return TableModel de Puntos de Venta
     */
    public DefaultTableModel getModelo() {
        String[] columnNames = {"Cuit", "Nombre"};
        DefaultTableModel modelo = new DefaultTableModel(columnNames, 0);
        this.listaPv = persistencia.getListPv();
        for (Iterator PvIt = this.listaPv.iterator(); PvIt.hasNext();) {
            Pv pv = (Pv) PvIt.next();
            Object[] datos = new String[modelo.getColumnCount()];
            datos[0] = pv.getCuit();
            datos[1] = pv.getNombre();
            modelo.addRow(datos);
        }
        return modelo;
    }
}
