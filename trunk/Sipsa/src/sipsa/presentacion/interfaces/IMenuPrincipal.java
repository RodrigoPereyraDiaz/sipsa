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
public interface IMenuPrincipal {

    /**
     * Accion correspondiente al boton Administrar PV
     */
    public void administrarPv();
    /**
     * Accion correspondiente al boton Administrar PAC
     */
    public void administrarPac();
    /**
     * Accion correspondiente al boton Administrar Tipos de Productos
     */
    public void administrarTipoProducto();
    /**
     * Accion correspondiente al boton Importar Productos
     */
    public void importarArchivoProductos();
    
}
