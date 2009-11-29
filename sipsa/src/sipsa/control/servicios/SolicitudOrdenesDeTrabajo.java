/*
 * Sistemas de Informacion II 2009
 * Proyecto Sipsa
 */
package sipsa.control.servicios;

import sipsa.control.OTControl;
import sipsa.dominio.Pac;

class SolicitudOrdenesDeTrabajo extends Mensaje {

    @Override
    public Mensaje procesar() {
        OTControl oTControl = new OTControl();
        Mensaje respuesta = MensajesFabrica.newRespuesta();
        Pac pac = (Pac) this.getContenido();
        respuesta.setContenido(oTControl.getListaOT(pac));
        return respuesta;
    }
}
