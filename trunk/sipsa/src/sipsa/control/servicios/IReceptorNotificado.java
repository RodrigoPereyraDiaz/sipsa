/*
 * Sistemas de Informacion II 2009
 * Proyecto Sipsa
 */

package sipsa.control.servicios;

/**
 * Interface a implementar por los Notificados
 * @author Claudio Rodrigo Pereyra Diaz
 * @author Maria Eugenia Sanchez
 */
public interface IReceptorNotificado {
    /**
     * procesa la notificación
     * @param notificacion
     */
    public void procesarNotificacion(String notificacion);
}
