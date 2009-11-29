/*
 * Sistemas de Informacion II 2009
 * Proyecto Sipsa
 */
package sipsa.control.servicios;

/**
 * Interface a implementar para notificar los mensajes del servidor
 * @author Claudio Rodrigo Pereyra Diaz
 * @author Maria Eugenia Sanchez
 */
public interface INotificador {

    /**
     * Notifica al servidor
     * @param mensaje
     */
    public void notificar(String mensaje);

    /**
     * Agrega un receptor notificado
     * @param iReceptorNotificado
     */
    public void addReceptorNotificado(IReceptorNotificado iReceptorNotificado);

    /**
     * remueve un receptor notificado
     * @param iReceptorNotificado
     */
    public void removeReceptorNotificado(IReceptorNotificado iReceptorNotificado);
}
