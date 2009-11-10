package sipsa.control.servicios;

import sipsa.dominio.Pac;
import sipsa.persistencia.Persistencia;

class SolicitudOrdenesDeTrabajo extends Mensaje{

    @Override
    public Mensaje procesar() {
        Persistencia persistencia = Persistencia.getPersistencia();
        Mensaje respuesta = MensajesFabrica.newRespuestaOrdenesDeTrabajo();
        Pac pac = (Pac) this.getContenido();
        respuesta.setContenido(persistencia.getOrdenesDeTrabajo(pac));
        return respuesta;
    }
}
