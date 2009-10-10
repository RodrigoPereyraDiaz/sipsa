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
public interface IMenuPrincipalPac {

    /**
     * Accion correspondiente al boton Administrar PV
     */
    public void AdministrarPv();
    /**
     * Accion correspondiente al boton Administrar PAC
     */
    public void AdministrarPac();
    /**
     * Accion correspondiente al boton Administrar Tipos de Productos
     */
    public void AdministrarTipoProducto();
    /**
     * Accion correspondiente al boton Importar Productos
     */
    public void ImportarArchivoProductos();
    
}
