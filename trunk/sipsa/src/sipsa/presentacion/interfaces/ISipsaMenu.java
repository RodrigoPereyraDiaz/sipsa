/*
 * Sistemas de Informacion II 2009
 * Proyecto Sipsa
 */
package sipsa.presentacion.interfaces;

/**
 * Interface a implementar para controlar el fomulario MenuPrincipal
 * @author Claudio Rodrigo Pereyra Diaz
 * @author Maria Eugenia Sanchez
 */
public interface ISipsaMenu {

    /**
     * Accion correspondiente al boton Administrar Puntos de Venta
     */
    public void administrarPv();

    /**
     * Accion correspondiente al boton Administrar Puntos de Atencion al Cliente
     */
    public void administrarPac();

    /**
     * Accion correspondiente al boton Administrar Tipos de Productos
     */
    public void administrarTipoProducto();

    /**
     * Accion correspondiente al boton Administrar Modelos
     */
    public void administrarModelos();

    /**
     * Accion correspondiente al boton Importar Productos
     */
    public void importarArchivoProductos();

    /**
     * Accion correspondiente al boton Reporte Ordenes de Trabajo Realizadas
     */
    public void mostrarReporteOTRealizadas();

    /**
     * Accion correspondiente al boton Reporte Ordenes de Trabajo Pendientes
     */
    public void mostrarReporteOTPendientes();

    /**
     * Accion correspondiente al boton Reporte Ordenes de Trabajo Vencidas
     */
    public void mostrarReporteOTVencidas();
}
