/*
 * Sistemas de Informacion II 2009
 * Proyecto Sipsa
 */
package sipsa.control;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFileChooser;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import sipsa.SipsaExcepcion;
import sipsa.dominio.Fabrica;
import sipsa.dominio.Modelo;
import sipsa.dominio.Producto;
import sipsa.persistencia.Persistencia;
import sipsa.presentacion.escritorio.DialogoMensaje;
import sipsa.presentacion.escritorio.ReporteVisor;
import sipsa.presentacion.interfaces.IReporte;

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
    public void importarProductosDesdeArchivo() {
        JFileChooser jfileChooser = new JFileChooser();
        jfileChooser.setDialogType(JFileChooser.OPEN_DIALOG);
        int i = jfileChooser.showOpenDialog(jfileChooser);
        if (i == JFileChooser.APPROVE_OPTION) {
            String pathFile = jfileChooser.getSelectedFile().getPath();
            this.importarProductos(pathFile);
        }
    }

    /**
     * Importa una lista de productos desde un archivo de texto y los almacena en la base de datos
     * @param archivo Ruta absoluta del archivo a importar
     */
    protected void importarProductos(String archivo) {
        BufferedReader entrada = null;
        String[] columnNames = {"Nro de Serie", "id Modelo", "Fecha Fabricacion", "id Fabrica", "Detalle"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        List<String> lineasError = new ArrayList<String>();
        try {
            entrada = new BufferedReader(new FileReader(archivo));
            String s = "";
            while ((s = entrada.readLine()) != null) {
                String[] productoRegistro = s.split(";");
                Producto producto = new Producto();
                producto.setNroSerie(productoRegistro[0]);
                Modelo modelo = new Modelo(Integer.parseInt(productoRegistro[1]));
                producto.setModelo(modelo);
                Fabrica fabrica = new Fabrica(Integer.parseInt(productoRegistro[2]));
                producto.setFabrica(fabrica);
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                try {
                    producto.setFechaFabricacion(sdf.parse(productoRegistro[3]));
                } catch (ParseException ex) {
                    ex.printStackTrace();
                    lineasError.add(s);
                }
                try {
                    Producto productoExiste = (Producto) persistencia.existe(producto);
                    Object[] datos = new Object[tableModel.getColumnCount()];
                    if (productoExiste == null) {
                        persistencia.guardar(producto);
                        datos[0] = producto.getNroSerie();
                        datos[1] = producto.getModelo().getID();
                        datos[2] = producto.getFechaFabricacion();
                        datos[3] = producto.getFabrica().getID();
                        datos[4] = "Importado y agregado";
                    } else {
                        datos[0] = productoExiste.getNroSerie();
                        datos[1] = productoExiste.getModelo().getID();
                        datos[2] = productoExiste.getFechaFabricacion();
                        datos[3] = productoExiste.getFabrica().getID();
                        datos[4] = "Ya existe en registro";
                    }
                    tableModel.addRow(datos);
                } catch (SipsaExcepcion ex) {
                    ex.printStackTrace();
                    lineasError.add(s);
                }
            }
            entrada.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                entrada.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            if (lineasError.size() > 0) {
                new DialogoMensaje(DialogoMensaje.Tipo.Error, "Se encontro error al importar algunos productos, se procede a generar un nuevo archivo con las lineas en cuestion");
                try {
                    BufferedWriter salida = new BufferedWriter(new FileWriter(archivo + ".errores"));
                    for(String lineaError : lineasError) {
                        salida.write(lineaError);
                        salida.newLine();
                    }
                    salida.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            Reporte reporte = new Reporte();
            reporte.setNombre("Reporte de Productos importados desde archivo");
            reporte.setDatos(tableModel);
            ReporteVisor reporteVisor = new ReporteVisor(reporte);
            reporteVisor.setVisible(true);
        }
    }

    /**
     * Verifica que el Producto especificado este en garantía
     * @param producto
     * @return devuelve verdadero si el producto esta en garantía, sino devuelve
     * falso
     */
    public boolean isEnGarantia(Producto producto) {
        //TODO agregar la validacion de si se encuentra en garantia
        return true;
    }

    /**
     * Verifica que el producto exista
     * @param producto
     * @return devuelve un Producto si existe sino devuelve una excepción
     */
    public Producto existe(Producto producto) throws SipsaExcepcion {
        return (Producto) persistencia.existe(producto);
    }
}
