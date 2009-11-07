package sipsa.control.servicios;

public class MensajesFabrica {
    public static Mensaje newRespuestaError(){
        return new RespuestaError();
    }

    public static Mensaje newRespuestaOK(){
        return new RespuestaOK();
    }

    public static Mensaje newRespuestaOrdenDeTrabajo(){
        return new RespuestaOrdenDeTrabajo();
    }

    public static Mensaje newRespuestaOrdenesDeTrabajo(){
        return new RespuestaOrdenesDeTrabajo();
    }

    public static Mensaje newRespuestaReporte(){
        return new RespuestaReporte();
    }

    public static Mensaje newSolicitudLogin(){
        return new SolicitudLogin();
    }

    public static Mensaje newSolicitudOrdenDeTrabajo(){
        return new SolicitudOrdenDeTrabajo();
    }

    public static Mensaje newSolicitudOrdenesDeTrabajo(){
        return new SolicitudOrdenesDeTrabajo();
    }

    public static Mensaje newSolicitudOrdenDeTrabajoGuardar(){
        return new SolicitudOrdenDeTrabajoGuardar();
    }

    public static Mensaje newSolicitudReporte(){
        return new SolicitudReporte();
    }
}