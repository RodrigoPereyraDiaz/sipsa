package sipsa.control.servicios;

import sipsa.SipsaExcepcion;
import sipsa.dominio.Pac;
import sipsa.persistencia.Persistencia;

class SolicitudLogin extends Mensaje {

    @Override
    public Mensaje procesar() {
        Mensaje mensaje = null;
        Persistencia persistencia = Persistencia.getPersistencia();
        Pac pac = (Pac) this.getContenido();
        try {
            pac = (Pac) persistencia.existe(pac);
            if (pac.getID() > 0) {
                mensaje = MensajesFabrica.newRespuestaOK();
                mensaje.setContenido(pac);
            } else {
                mensaje = MensajesFabrica.newRespuestaError();
                mensaje.setContenido(new SipsaExcepcion("Error de autenticación"));
            }
        } catch (SipsaExcepcion ex) {
            mensaje = MensajesFabrica.newRespuestaError();
            mensaje.setContenido(ex);
        }
        return mensaje;
    }
}