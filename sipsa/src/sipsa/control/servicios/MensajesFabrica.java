/*
 * Sistemas de Informacion II 2009
 * Proyecto Sipsa
 */
package sipsa.control.servicios;

/**
 * Fabrica de Mensajes crea instancias de mensajes solicitado
 * @author Claudio Rodrigo Pereyra Diaz
 * @author Maria Eugenia Sanchez
 */
public class MensajesFabrica {

    /**
     * Crea un nuevo Mensaje de Respuesta
     * @return Mensaje de respuesta
     */
    public static Mensaje newRespuesta() {
        return new Respuesta();
    }

    /**
     * Crea un mensaje de tipo solicitud login
     * @return devuelve un mensaje de tipo login
     */
    public static Mensaje newSolicitudLogin() {
        return new SolicitudLogin();
    }

    /**
     * Crea un mensaje de solicitud orden de trabajo
     * @return devuelve un mensaje de tipo orden de trabajo
     */
    public static Mensaje newSolicitudOrdenesDeTrabajo() {
        return new SolicitudOrdenesDeTrabajo();
    }

    /**
     *
     * @return
     */
    public static Mensaje newSolicitudOrdenDeTrabajoGuardar() {
        return new SolicitudOrdenDeTrabajoGuardar();
    }

    /**
     * Crea un nuevo mensaje de solicitud de lista de puntos de venta
     * @return Mensaje de solicitud
     */
    public static Mensaje newSolicitudListsaPuntosDeVenta() {
        return new SolicitudPuntosDeVenta();
    }

    static Mensaje newSolicitudListaModelos() {
        return new SolicitudModelos();
    }
}
