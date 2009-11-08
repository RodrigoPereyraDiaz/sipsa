/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sipsa.control;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import sipsa.presentacion.escritorio.ListarABM;
import sipsa.presentacion.interfaces.IListarABM;


/**
 *
 * @author elsupergomez
 */
public class OTControl implements IListarABM{

     /**
     * Muestra el formulario para administrar Ordenes de Trabajo
     */
    public void mostrarAdministrar(){
        ListarABM listarABM = new ListarABM(this);
        listarABM.setVisible(true);
    }

    public void agregar() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void modificar(int index) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void eliminar(int index) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String getDescripcion() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public DefaultTableModel getModelo() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public DefaultTableModel getOTRealizadas() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public DefaultTableModel getOTPendientes() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public DefaultTableModel getOTPendientes(String cuit) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public DefaultTableModel getOTRealizadas(String cuit) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    TableModel getOTVencidas() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    TableModel getOTVencidas(String cuit) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
