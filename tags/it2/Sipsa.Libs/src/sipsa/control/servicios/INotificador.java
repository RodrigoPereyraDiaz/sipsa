package sipsa.control.servicios;

import sipsa.control.servicios.*;

public interface INotificador {
    public void notificar(String mensaje);
    public void addReceptorNotificado(IReceptorNotificado iReceptorNotificado);
    public void removeReceptorNotificado(IReceptorNotificado iReceptorNotificado);
}