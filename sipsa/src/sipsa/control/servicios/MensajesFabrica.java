/*
 * Sistemas de Informacion II 2009
 * Proyecto Sipsa
 */

package sipsa.control.servicios;

/**
 * @author Claudio Rodrigo Pereyra Diaz
 * @author Maria Eugenia Sanchez
 */
public class MensajesFabrica {
    /**
     * Crea un mensaje de respuesta de tipo error
     * @return devuelve un mensaje de tipo error que contiene una excepción
     */
    public static Mensaje newRespuestaError(){
        return new RespuestaError();
    }

    /**
     * Crea u  mensaje de respuesta de tipo Ok
     * @return devuelve un mensaje de tipo OK
     */
    public static Mensaje newRespuestaOK(){
        return new RespuestaOK();
    }

    /**
     * Crea un mensaje de respuesta de tipo Ordenes de Trabajo
     * @return devuelve un mensaje de tipo Ordenes de trabajo
     */
    public static Mensaje newRespuestaOrdenesDeTrabajo(){
        return new RespuestaOrdenesDeTrabajo();
    }

    /**
     * Crea un mensaje de tipo solicitud login
     * @return devuelve un mensaje de tipo login
     */
    public static Mensaje newSolicitudLogin(){
        return new SolicitudLogin();
    }

    /**
     * Crea un mensaje de solicitud orden de trabajo
     * @return devuelve un mensaje de tipo orden de trabajo
     */
    public static Mensaje newSolicitudOrdenesDeTrabajo(){
        return new SolicitudOrdenesDeTrabajo();
    }

    public static Mensaje newSolicitudOrdenDeTrabajoGuardar(){
        return new SolicitudOrdenDeTrabajoGuardar();
    }
}