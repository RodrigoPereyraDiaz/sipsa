/*
 * Sistemas de Informacion II 2009
 * Proyecto Sipsa
 */

package sipsa.control.controladores;

import sipsa.presentacion.escritorio.SipsaMenu;
import sipsa.presentacion.interfaces.ISipsaMenu;

/**
 * Controlador del Menu Principal
 * @author Claudio Rodrigo Pereyra Diaz
 * @author Maria Eugenia Sanchez
 */
public class MenuSipsaControl implements ISipsaMenu {

    /**
     * Muestra el formulario Menu Sipsa
     */
    public void mostrarMenu(){
        SipsaMenu menuSipsa = new SipsaMenu(this);
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
        ProductosControl control = new ProductosControl();
        control.importarProductosDesdeArchivo();
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
