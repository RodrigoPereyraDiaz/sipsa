package sipsa.control.servicios;

public class MensajesFabrica {
    public static Mensaje newRespuestaError(){
        return new RespuestaError();
    }

    public static Mensaje newRespuestaOK(){
        return new RespuestaOK();
    }

    public static Mensaje newRespuestaOrdenesDeTrabajo(){
        return new RespuestaOrdenesDeTrabajo();
    }

    public static Mensaje newSolicitudLogin(){
        return new SolicitudLogin();
    }

    public static Mensaje newSolicitudOrdenesDeTrabajo(){
        return new SolicitudOrdenesDeTrabajo();
    }

    public static Mensaje newSolicitudOrdenDeTrabajoGuardar(){
        return new SolicitudOrdenDeTrabajoGuardar();
    }
}