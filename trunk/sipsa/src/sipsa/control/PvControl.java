/*
 * Sistemas de Informacion II 2009
 * Proyecto Sipsa
 */

package sipsa.control;

import java.util.Iterator;
import java.util.List;
import javax.swing.table.DefaultTableModel;

import sipsa.dominio.Pv;
import sipsa.persistencia.Persistencia;
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
    private List<Pv> listaPv;
    /**
     * Muestra el formulacion para Administrar Puntos de Venta
     */
    public void mostrarAdministrar(){
        ListarABM listarABMPv = new ListarABM(this);
        listarABMPv.setVisible(true);
    }

    /**
     * Guarda en el medio de persistencia el nuevo Punto de Venta
     * @param cuit CUIT del Punto de Venta
     * @param nombre Nombre del Punto de venta
     * @return Resultado de la persistencia
     */
    public void aceptarDatosEmpresa(String cuit, String nombre) throws Exception {
        Pv pv = new Pv();
        pv.setCuit(cuit);
        pv.setNombre(nombre);
        if (this.persistencia.existPv(pv)){
            throw new Exception("El punto de venta ya existe, imposible agregar");
        } else {
            this.persistencia.savePv(pv);
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
    public void agregar() {
        EmpresaDatos formulario = new EmpresaDatos(this);
        formulario.setVisible(true);
    }

    /**
     * eliminar del medio de persistencia el Punto de Venta identificado
     * @param id Identificador unico del Punto de Venta
     */
    public void eliminar(int index) {
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
            Object[] datos = new Object[modelo.getColumnCount()];
            datos[0] = pv.getCuit();
            datos[1] = pv.getNombre();
            modelo.addRow(datos);
        }
        return modelo;
    }

    public void modificar(int index) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
