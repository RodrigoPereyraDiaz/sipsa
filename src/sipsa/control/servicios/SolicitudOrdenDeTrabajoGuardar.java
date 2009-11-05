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
            mensaje.setDescriptor("Orden de Trabajo guardada con exito");
            mensaje.setContenido("");
        } else {
            mensaje = MensajesFabrica.newRespuestaError();
            mensaje.setDescriptor("Error al guardar la Orden de Trabajo");
            mensaje.setContenido("Verifique que todos los datos sean correctos e intente nuevamente");
        }
        return mensaje;
    }
}