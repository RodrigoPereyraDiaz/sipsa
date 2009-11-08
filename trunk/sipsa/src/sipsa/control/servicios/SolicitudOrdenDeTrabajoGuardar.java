package sipsa.control.servicios;

import sipsa.dominio.OrdenDeTrabajo;
import sipsa.persistencia.Persistencia;

class SolicitudOrdenDeTrabajoGuardar extends Mensaje{

    @Override
    public Mensaje procesar() {
        Mensaje mensaje = null;
        Persistencia persistencia = Persistencia.getPersistencia();
        OrdenDeTrabajo ordenDeTrabajo = (OrdenDeTrabajo) this.getContenido();
        if  (persistencia.saveOrdenDeTrabajo(ordenDeTrabajo)){
            mensaje = MensajesFabrica.newRespuestaOK();
            mensaje.setContenido("Orden de Trabajo guardada con exito");
        } else {
            mensaje = MensajesFabrica.newRespuestaError();
            mensaje.setContenido("Error al guardar la Orden de Trabajo");
        }
        return mensaje;
    }
}