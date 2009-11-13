/*
 * Sistemas de Informacion II 2009
 * Proyecto Sipsa
 */

package sipsa.presentacion.interfaces;

import sipsa.dominio.Empresa;

/**
 * Interface a implementar para controlar el fomulario EmpresaDatos
 * @author Claudio Rodrigo Pereyra Diaz
 * @author Maria Eugenia Sanchez
 */
public interface IEmpresaDatos {

    /**
     * Implementa la accion del boton guardar
     * @param empresa Empresa a guardar
     * @throws java.lang.Exception Si no se puede guardar por algun motivo
     */
    public void guardarEmpresa(Empresa empresa) throws Exception;

    //FIXME eliminar metodo
    /**
     * Guarda en el medio de persistencia
     * @param cuit
     * @param nombre
     * @return Resultado de la persistencia
     */
    @Deprecated
    public void aceptarDatosEmpresa(String cuit, String nombre) throws Exception;

    /**
     * Obtiene la descripcion para utilizar en formularios genericos
     * @return Titulo para el jFrame
     */
    public String getDescripcion();
}