/*
 * Sistemas de Informacion II 2009
 * Proyecto Sipsa
 */

package sipsa.control.controladores;

import java.io.IOException;
import java.text.ParseException;
import javax.swing.JFileChooser;
import sipsa.persistencia.FachadaPersistencia;


/**
 * Controlador de Productos
 * @author Claudio Rodrigo Pereyra Diaz
 * @author Maria Eugenia Sanchez
 */
public class ProductosControl {

    private FachadaPersistencia persistencia = new FachadaPersistencia();
    /**Muestra un dialogo de seleccion de archivo para realizar la importacion de Productos
     * Realiza la importar de un archivo y devuelve una lista de productos
     * @throws IOException 
     * @throws ParseException
     */
    public void ImportarProductosDesdeArchivo() throws IOException, ParseException{
        //@TODO revisar las exepciones
        JFileChooser jfileChooser = new JFileChooser();
        int i = jfileChooser.showOpenDialog(jfileChooser);
        if (i == JFileChooser.APPROVE_OPTION){
            String pathFile = jfileChooser.getSelectedFile().getPath();
            persistencia.importProductos(pathFile);
        }
    }
}
