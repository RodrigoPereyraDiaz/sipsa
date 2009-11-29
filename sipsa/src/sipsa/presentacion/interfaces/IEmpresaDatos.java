/*
 * Sistemas de Informacion II 2009
 * Proyecto Sipsa
 */
package sipsa.presentacion.interfaces;

import sipsa.SipsaExcepcion;
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
     * @throws SipsaExcepcion Si no se puede guardar por algun motivo
     */
    public void guardarEmpresa(Empresa empresa) throws SipsaExcepcion;

    /**
     * Obtiene la descripcion para utilizar en formularios genericos
     * @return Titulo para el jFrame
     */
    public String getDescripcion();
}
