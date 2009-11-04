/*
 * Sistemas de Informacion II 2009
 * Proyecto Sipsa
 */

package sipsa.control.controladores;

import java.util.Iterator;
import javax.swing.table.DefaultTableModel;
import java.util.List;

import sipsa.dominio.Pac;
import sipsa.presentacion.interfaces.IListarABM;
import sipsa.presentacion.interfaces.IEmpresaDatos;
import sipsa.presentacion.escritorio.EmpresaDatos;
import sipsa.presentacion.escritorio.ListarABM;
import sipsa.persistencia.Persistencia;

/**
 * Controlador de Punto de Atencion la Cliente
 * @author Claudio Rodrigo Pereyra Diaz
 * @author Maria Eugenia Sanchez
 */
public class PacControl implements IEmpresaDatos, IListarABM {
    private Persistencia persistencia = new Persistencia();
    private List<Pac> listaPac;

    /**
     * Muestra el formulario para administrar Puntos de Atencion al Cliente
     */
    public void mostrarAdministrar(){
        ListarABM listarABM = new ListarABM(this);
        listarABM.setVisible(true);
    }

    /**
     * Guarda en el medio de persistencia el nuevo Punto de Atencion al Cliente
     * @param cuit CUIT del Punto de Atencion al Cliente
     * @param nombre Nombre del Punto de Atencion al Cliente
     * @return Resultado de la persistencia
     */
    public Boolean aceptarDatosEmpresa(String cuit, String nombre) {
        Pac pac = new Pac();
        pac.setCuit(cuit);
        pac.setNombre(nombre);

        if (persistencia.existPac(pac)){
            ///TODO mensaje de que ya existe o permite modificar
            return false;
        } else {
            return persistencia.savePac(pac);
        }
    }

    /**
     * Obtiene la descripcion para utilizar en formularios genericos
     * @return Titulo para el jFrame
     */
    public String getDescripcion() {
        return "Punto de Atencion al Cliente";
    }

    /**
     * Muestra el formulario para agregar un nuevo Punto de Atencion al Cliente
     */
    public void agregar() {
        EmpresaDatos empresaDatos = new EmpresaDatos(this);
        empresaDatos.setVisible(true);
    }

    /**
     * Elimina del medio de persistencia el Punto de Atencion al Cliente especificado
     * @param id Identificador unico de Punto de Atencion al Cliente
     */
    public void eliminar(int index) {
        Pac pac = this.listaPac.get(index);
        this.persistencia.deletePac(pac);
    }

    /**
     * Obtiene el modelo para llenar un jTable con los Puntos de Atencion al Cliente
     * @return TableModel de Puntos de Atencion al Cliente
     */
    public DefaultTableModel getModelo() {
        String[] columnNames = {"Cuit", "Nombre"};
        DefaultTableModel modelo = new DefaultTableModel(columnNames, 0);
        this.listaPac = persistencia.getListPac();
        for (Iterator PacIt = this.listaPac.iterator(); PacIt.hasNext();) {
            Pac pac = (Pac) PacIt.next();
            Object[] datos = new Object[modelo.getColumnCount()];
            datos[0] = pac.getCuit();
            datos[1] = pac.getNombre();
            modelo.addRow(datos);
        }
        return modelo;
    }

    public void modificar(int index) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
