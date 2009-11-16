package sipsa.control.servicios;

import sipsa.SipsaExcepcion;
import sipsa.control.OTControl;
import sipsa.dominio.OrdenDeTrabajo;

class SolicitudOrdenDeTrabajoGuardar extends Mensaje {

    @Override
    public Mensaje procesar() {
        Mensaje mensaje = null;
        OTControl oTControl = new OTControl();
        OrdenDeTrabajo ordenDeTrabajo = (OrdenDeTrabajo) this.getContenido();
        try {
            oTControl.guardarOrdenDeTrabajo(ordenDeTrabajo);
            mensaje = MensajesFabrica.newRespuestaOK();
            mensaje.setContenido("Orden de Trabajo guardada con exito");
        } catch (SipsaExcepcion ex) {
            mensaje = MensajesFabrica.newRespuestaError();
            mensaje.setContenido(ex);
        }
        return mensaje;
    }
}