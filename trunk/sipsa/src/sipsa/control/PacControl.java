/*
 * Sistemas de Informacion II 2009
 * Proyecto Sipsa
 */

package sipsa.control;

import java.util.Iterator;
import javax.swing.table.DefaultTableModel;
import java.util.List;

import sipsa.dominio.Empresa;
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
    private Persistencia persistencia = Persistencia.getPersistencia();
    private List<Pac> listaPac;

    /**
     *Muestra el formulario para Administrar Puntos de Atención al Cliente
     */
    public void mostrarAdministrar() {
        this.listaPac = persistencia.getListPac();
        ListarABM listarABM = new ListarABM(this);
        listarABM.setVisible(true);
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
        EmpresaDatos empresaDatos = new EmpresaDatos(this, new Pac());
        empresaDatos.setVisible(true);
    }

    public void modificar(int index) {
        EmpresaDatos empresaDatos = new EmpresaDatos(this, this.listaPac.get(index));
        empresaDatos.setVisible(true);
    }

    /**
     * Elimina del medio de persistencia el Punto de Atencion al Cliente especificado
     * @param index
     */
    public void eliminar(int index) {
        Pac pac = this.listaPac.get(index);
        this.persistencia.deletePac(pac);
        this.listaPac.remove(pac);
    }

    /**
     * Obtiene el modelo para llenar un jTable con los Puntos de Atencion al Cliente
     * @return TableModel de Puntos de Atencion al Cliente
     */
    public DefaultTableModel getModelo() {
        String[] columnNames = {"Cuit", "Nombre"};
        DefaultTableModel modelo = new DefaultTableModel(columnNames, 0);
        for (Iterator PacIt = this.listaPac.iterator(); PacIt.hasNext();) {
            Pac pac = (Pac) PacIt.next();
            Object[] datos = new Object[modelo.getColumnCount()];
            datos[0] = pac.getCuit();
            datos[1] = pac.getNombre();
            modelo.addRow(datos);
        }
        return modelo;
    }

    public void guardarEmpresa(Empresa empresa) throws Exception {
        Pac pac = (Pac) empresa;
        //TODO Validar CUIT
        if (persistencia.existPac(pac)){
            throw new Exception("El Punto de Atencion ya exite, imposible agregar");
        } else {
            persistencia.savePac(pac);
            this.listaPac.add(pac);
        }
    }


}
