package sipsa.control.servicios;

public interface IServicio {
    public void iniciar();
    public void notificar(String mensaje);
    public void addReceptorNotificado(IReceptorNotificado iReceptorNotificado);
    public void removeReceptorNotificado(IReceptorNotificado iReceptorNotificado);
}