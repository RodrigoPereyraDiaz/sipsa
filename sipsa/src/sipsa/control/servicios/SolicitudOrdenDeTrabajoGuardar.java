/*
 * Sistemas de Informacion II 2009
 * Proyecto Sipsa
 */
package sipsa.control.servicios;

import sipsa.SipsaExcepcion;
import sipsa.control.OTControl;
import sipsa.dominio.OrdenDeTrabajo;

class SolicitudOrdenDeTrabajoGuardar extends Mensaje {

    @Override
    public Mensaje procesar() {
        Mensaje mensaje = MensajesFabrica.newRespuesta();
        OTControl oTControl = new OTControl();
        OrdenDeTrabajo ordenDeTrabajo = (OrdenDeTrabajo) this.getContenido();
        try {
            oTControl.guardarOrdenDeTrabajo(ordenDeTrabajo);
            mensaje.setContenido("Orden de Trabajo guardada con exito");
        } catch (SipsaExcepcion ex) {
            mensaje.setContenido(ex);
        }
        return mensaje;
    }
}
