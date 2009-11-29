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
public interface ISipsaPacMenu {

    /**
     * Accion correspondiente al boton Administrar Ordenes de Trabajo
     */
    public void administrarOT();

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
