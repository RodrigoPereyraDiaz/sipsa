/*
 * Sistemas de Informacion II 2009
 * Proyecto Sipsa
 */

package sipsa.presentacion.interfaces;

/**
 * Interface a implementar para controlar el fomulario EmpresaDatos
 * @author Claudio Rodrigo Pereyra Diaz
 * @author Maria Eugenia Sanchez
 */
public interface IEmpresaDatos {

    /**
     * Guarda en el medio de persistencia
     * @param cuit
     * @param nombre
     * @return Resultado de la persistencia
     */
    public Boolean aceptarDatosEmpresa(String cuit, String nombre);

    /**
     * Obtiene la descripcion para utilizar en formularios genericos
     * @return Titulo para el jFrame
     */
    public String getDescripcion();
}