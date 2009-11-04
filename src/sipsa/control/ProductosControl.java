/*
 * Sistemas de Informacion II 2009
 * Proyecto Sipsa
 */

package sipsa.control;

import java.io.IOException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

import sipsa.persistencia.Persistencia;

/**
 * Controlador de Productos
 * @author Claudio Rodrigo Pereyra Diaz
 * @author Maria Eugenia Sanchez
 */
public class ProductosControl {

    private Persistencia persistencia = Persistencia.getPersistencia();
    /**Muestra un dialogo de seleccion de archivo para realizar la importacion de Productos
     * Realiza la importar de un archivo y devuelve una lista de productos
     * @throws IOException 
     * @throws ParseException
     */
    public void importarProductosDesdeArchivo(){
        //@TODO revisar las exepciones
        JFileChooser jfileChooser = new JFileChooser();
        int i = jfileChooser.showOpenDialog(jfileChooser);
        if (i == JFileChooser.APPROVE_OPTION){
            try {
                String pathFile = jfileChooser.getSelectedFile().getPath();
                persistencia.importProductos(pathFile);
            } catch (IOException ex) {
                Logger.getLogger(ProductosControl.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(ProductosControl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
