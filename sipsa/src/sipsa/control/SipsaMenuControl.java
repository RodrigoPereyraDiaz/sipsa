/*
 * Sistemas de Informacion II 2009
 * Proyecto Sipsa
 */
package sipsa.control;

import sipsa.presentacion.escritorio.RangoFechas;
import sipsa.presentacion.escritorio.ReporteVisor;
import sipsa.presentacion.escritorio.SipsaMenu;
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
    public void mostrarMenu() {
        SipsaMenu sipsaMenu = new SipsaMenu(this);
        sipsaMenu.setVisible(true);
    }

    /**
     * Invoca el fomulario para Administracion de Puntos de Venta
     */
    public void administrarPv() {
        PvControl pvControl = new PvControl();
        pvControl.mostrarABM();
    }

    /**
     * Invoca el formulario para Administracion de Puntos de Atencion al Cliente
     */
    public void administrarPac() {
        PacControl pacControl = new PacControl();
        pacControl.mostrarABM();
    }

    /**
     * Invoca el fomulario para Administracion de Tipos de Productos
     */
    public void administrarTipoProducto() {
        TipoProductoControl tipoProductoControl = new TipoProductoControl();
        tipoProductoControl.mostrarABM();
    }

    public void administrarModelos() {
        ModeloControl modeloControl = new ModeloControl();
        modeloControl.mostrarABM();
    }

    /**
     * Invoca el servicio de importacion de Productos desde un archivo
     */
    public void importarArchivoProductos() {
        ProductosControl control = new ProductosControl();
        control.importarProductosDesdeArchivo();
    }

    public void mostrarReporteOTRealizadas() {
        RangoFechas rangoFechas = new RangoFechas();
        rangoFechas.setVisible(true);
        if (rangoFechas.getReturnStatus() == RangoFechas.RET_OK) {
            Reporte reporte = new Reporte();
            reporte.setNombre("Ordenes de Trabajo Realizadas");
            OTControl oTControl = new OTControl();
            reporte.setDatos(oTControl.getOTRealizadas(rangoFechas.getFechaDesde(), rangoFechas.getFechaHasta()));
            ReporteVisor reporteVisor = new ReporteVisor(reporte);
            reporteVisor.setVisible(true);
        }
    }

    public void mostrarReporteOTPendientes() {
        Reporte reporte = new Reporte();
        reporte.setNombre("Ordenes de Trabajo Pendientes");
        OTControl oTControl = new OTControl();
        reporte.setDatos(oTControl.getOTPendientes());
        ReporteVisor reporteVisor = new ReporteVisor(reporte);
        reporteVisor.setVisible(true);
    }

    public void mostrarReporteOTVencidas() {
        Reporte reporte = new Reporte();
        reporte.setNombre("Ordenes de Trabajo Vencidas");
        OTControl oTControl = new OTControl();
        reporte.setDatos(oTControl.getOTVencidas());
        ReporteVisor reporteVisor = new ReporteVisor(reporte);
        reporteVisor.setVisible(true);
    }
}
