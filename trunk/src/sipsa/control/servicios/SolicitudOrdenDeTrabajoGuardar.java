/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sipsa.control.servicios;

import sipsa.dominio.OrdenDeTrabajo;
import sipsa.persistencia.Persistencia;

/**
 *
 * @author elsupergomez
 */
class SolicitudOrdenDeTrabajoGuardar extends Mensaje{

    @Override
    public Mensaje procesar() {
        Mensaje mensaje = MensajesFabrica.getError();
        Persistencia persistencia = Persistencia.getPersistencia();
        OrdenDeTrabajo ordenDeTrabajo = (OrdenDeTrabajo) this.getContenido();
        if  (persistencia.saveOrdenDeTrabajo(ordenDeTrabajo)){
            mensaje = MensajesFabrica.getOK();
        }
        return mensaje;
    }
}
