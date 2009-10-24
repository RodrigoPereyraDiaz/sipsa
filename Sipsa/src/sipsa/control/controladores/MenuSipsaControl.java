/*
 * Sistemas de Informacion II 2009
 * Proyecto Sipsa
 */

package sipsa.control.controladores;

import java.io.IOException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

import sipsa.presentacion.escritorio.MenuSipsa;
import sipsa.presentacion.interfaces.IMenuSipsa;

/**
 * Controlador del Menu Principal
 * @author Claudio Rodrigo Pereyra Diaz
 * @author Maria Eugenia Sanchez
 */
public class MenuSipsaControl implements IMenuSipsa {

    /**
     * Muestra el formulario Menu Sipsa
     */
    public void mostrarMenu(){
        MenuSipsa menuSipsa = new MenuSipsa(this);
        menuSipsa.setVisible(true);
    }

    /**
     * Invoca el fomulario para Administracion de Puntos de Venta
     */
    public void administrarPv() {
        PvControl pvControl = new PvControl();
        pvControl.mostrarAdministrar();
    }

    /**
     * Invoca el formulario para Administracion de Puntos de Atencion al Cliente
     */
    public void administrarPac() {
        PacControl pacControl = new PacControl();
        pacControl.mostrarAdministrar();
    }

    /**
     * Invoca el fomulario para Administracion de Tipos de Productos
     */
    public void administrarTipoProducto() {
        TipoProductoControl tipoProductoControl = new TipoProductoControl();
        tipoProductoControl.mostrarAdministrar();
    }

    /**
     * Invoca el servicio de importacion de Productos desde un archivo
     */
    public void importarArchivoProductos() {
        //@TODO revisar los try y catchs
        ProductosControl control = new ProductosControl();
        try {
            try {
                control.importarProductosDesdeArchivo();
            } catch (ParseException ex) {
                Logger.getLogger(MenuSipsaControl.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(MenuSipsaControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void mostrarReporteOTRealizadas() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void mostrarReporteOTPendientes() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void mostrarReporteOTVencidas() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
