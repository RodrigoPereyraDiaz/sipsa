/*
 * Sistemas de Informacion II 2009
 * Proyecto Sipsa
 */

package sipsa.control;

import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.table.DefaultTableModel;
import java.util.List;

import javax.swing.table.TableModel;
import sipsa.SipsaExcepcion;

import sipsa.dominio.Empresa;
import sipsa.dominio.Pac;
import sipsa.persistencia.IPersistible;
import sipsa.persistencia.Persistencia;
import sipsa.presentacion.interfaces.IListarABM;
import sipsa.presentacion.interfaces.IEmpresaDatos;
import sipsa.presentacion.escritorio.EmpresaDatos;
import sipsa.presentacion.escritorio.ListarABM;
import sipsa.presentacion.escritorio.DialogoMensaje;

/**
 * Controlador de Punto de Atencion la Cliente
 * @author Claudio Rodrigo Pereyra Diaz
 * @author Maria Eugenia Sanchez
 */
public class PacControl implements IEmpresaDatos, IListarABM {
    private Persistencia persistencia = Persistencia.getPersistencia();
    private List<Pac> listaPacs = new ArrayList<Pac>();

    private void recuperarLista(){
        try {
            List<IPersistible> lista = persistencia.recuperarLista(Pac.class);
            for (Iterator iterator = lista.iterator(); iterator.hasNext();) {
                Pac pac = (Pac) iterator.next();
                listaPacs.add(pac);
            }
        } catch (SipsaExcepcion ex) {
            new DialogoMensaje(DialogoMensaje.Tipo.Error, ex.getLocalizedMessage());
        }
    }

    /**
     *Muestra el formulario para Administrar Puntos de Atención al Cliente
     */
    public void mostrarAdministrar(){
        this.recuperarLista();
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
        Pac pac = new Pac();
        EmpresaDatos empresaDatos = new EmpresaDatos(this, pac);
        empresaDatos.setVisible(true);
    }

    public void modificar(int index) {
        Pac pac = this.listaPacs.get(index);
        this.listaPacs.remove(pac);
        EmpresaDatos empresaDatos = new EmpresaDatos(this,pac);
        empresaDatos.setVisible(true);
        if (empresaDatos.isSinCambio()){
            this.listaPacs.add(pac);
        }
    }

    /**
     * Elimina del medio de persistencia el Punto de Atencion al Cliente especificado
     * @param index
     */
    public void eliminar(int index) {
        try {
            Pac pac = this.listaPacs.get(index);
            this.persistencia.eliminar(pac);
            this.listaPacs.remove(pac);
        } catch (SipsaExcepcion ex) {
            new DialogoMensaje(DialogoMensaje.Tipo.Error, ex.getLocalizedMessage());
        }
    }

    /**
     * Obtiene el modelo para llenar un jTable con los Puntos de Atencion al Cliente
     * @return TableModel de Puntos de Atencion al Cliente
     */
    public TableModel getModelo() {
        String[] columnNames = {"Cuit", "Nombre"};
        DefaultTableModel modelo = new DefaultTableModel(columnNames, 0);
        for (Iterator PacIt = this.listaPacs.iterator(); PacIt.hasNext();) {
            Pac pac = (Pac) PacIt.next();
            Object[] datos = new Object[modelo.getColumnCount()];
            datos[0] = pac.getCuit();
            datos[1] = pac.getNombre();
            modelo.addRow(datos);
        }
        return modelo;
    }

    public void guardarEmpresa(Empresa empresa) throws SipsaExcepcion {
        Pac pac = (Pac) empresa;
        //TODO Validar CUIT
        if (pac.getCuit().equals("") || pac.getNombre().equals("")){
            throw new SipsaExcepcion("Debe completar todos los datos solicitados");
        }
        if (pac.getID() > 0){
            persistencia.actualizar(pac);
        } else {
            if (persistencia.existe(pac).getID() > 0){
                throw new SipsaExcepcion("El Punto de Atencion ya exite, imposible agregar");
            } else {
                persistencia.guardar(pac);
            }
        }
        this.listaPacs.add(pac);
    }
}
