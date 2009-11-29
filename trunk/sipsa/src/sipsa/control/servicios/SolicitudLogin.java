/*
 * Sistemas de Informacion II 2009
 * Proyecto Sipsa
 */
package sipsa.control.servicios;

import sipsa.SipsaExcepcion;
import sipsa.dominio.Pac;
import sipsa.persistencia.Persistencia;

class SolicitudLogin extends Mensaje {

    @Override
    public Mensaje procesar() {
        Mensaje mensaje = MensajesFabrica.newRespuesta();
        Persistencia persistencia = Persistencia.getPersistencia();
        Pac pac = (Pac) this.getContenido();
        try {
            pac = (Pac) persistencia.existe(pac);
            if (pac == null) {
                mensaje.setContenido(new SipsaExcepcion("Error de autenticación"));
            } else {
                mensaje.setContenido(pac);
            }
        } catch (SipsaExcepcion ex) {
            mensaje.setContenido(ex);
        }
        return mensaje;
    }
}
