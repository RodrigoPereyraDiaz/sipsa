/*
 * Sistemas de Informacion II 2009
 * Proyecto Sipsa
 */

package sipsa.control;

import sipsa.presentacion.escritorio.ReporteVisor;
import sipsa.presentacion.escritorio.SipsaMenu;
import sipsa.presentacion.interfaces.IReporte;
import sipsa.presentacion.interfaces.ISipsaMenu;

/**
 * Controlador del Menu Principal
 * @author Claudio Rodrigo Pereyra Diaz
 * @author Maria Eugenia Sanchez
 */
public class SipsaMenuControl implements ISipsaMenu {

    /**
     * Muestra el formulario Menu Sipsa
     */
    public void mostrarMenu(){
        SipsaMenu  sipsaMenu = new SipsaMenu(this);
        sipsaMenu.setVisible(true);
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
        IReporte reporte = ReportesFactoria.getReporteOTRealizadas();
        ReporteVisor reporteVisor = new ReporteVisor(reporte);
        reporteVisor.setVisible(true);
    }

    public void mostrarReporteOTPendientes() {
        IReporte reporte = ReportesFactoria.getReporteOTPendientes();
        ReporteVisor reporteVisor = new ReporteVisor(reporte);
        reporteVisor.setVisible(true);
    }

    public void mostrarReporteOTVencidas() {
        IReporte reporte = ReportesFactoria.getReporteOTVencidas();
        ReporteVisor reporteVisor = new ReporteVisor(reporte);
        reporteVisor.setVisible(true);
    }
}
