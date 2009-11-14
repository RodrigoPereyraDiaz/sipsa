/*
 * Sistemas de Informacion II 2009
 * Proyecto Sipsa
 */

package sipsa.control;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFileChooser;

import sipsa.dominio.Fabrica;
import sipsa.dominio.Modelo;
import sipsa.dominio.Producto;
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
     */
    public void importarProductosDesdeArchivo(){
        //@TODO revisar las exepciones
        JFileChooser jfileChooser = new JFileChooser();
        int i = jfileChooser.showOpenDialog(jfileChooser);
        if (i == JFileChooser.APPROVE_OPTION){
            try {
                String pathFile = jfileChooser.getSelectedFile().getPath();
                this.importarProductos(pathFile);
            } catch (IOException ex) {
                Logger.getLogger(ProductosControl.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(ProductosControl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

        /**
     * Importa una lista de productos desde un archivo de texto y los almacena en la base de datos
     * @param archivo Ruta absoluta del archivo a importar
     * @return Resultado de la importacion y almacenamiento
     * @throws java.io.IOException
     * @throws java.text.ParseException
     */
    //@TODO revisar las excepciones
    protected Boolean importarProductos(String archivo) throws IOException, ParseException{
        List<Producto> lista = new ArrayList<Producto>();
        boolean ok = false;
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String s = "";
            while ((s = entrada.readLine()) != null) {
               String[] productoRegistro = s.split(";");
               Producto producto = new Producto();
               producto.setNroSerie(productoRegistro[0]);
               Fabrica fabrica = new Fabrica(Integer.parseInt(productoRegistro[1]));
               producto.setFabrica(fabrica);
               SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
               producto.setFechaFabricacion(sdf.parse(productoRegistro[2]));
               Modelo modelo = new Modelo(Integer.parseInt(productoRegistro[3]));
               //FIXME verificar que exista el modelo, caso contrario agregarlo
               producto.setModelo(modelo);
               lista.add(producto);
            }
            for (Iterator ProdIt = lista.iterator(); ProdIt.hasNext();) {
                Producto producto = (Producto) ProdIt.next();
                persistencia.saveProducto(producto);
            }
            entrada.close();
            ok = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
       return ok;
    }

    /**
     * Verifica que el Producto especificado este en garantía
     * @param producto
     * @return devuelve verdadero si el producto esta en garantía, sino devuelve
     * falso
     */
    public boolean isEnGarantia(Producto producto){
        //TODO agregar la validacion de si se encuentra en garantia
        return true;
    }
}
