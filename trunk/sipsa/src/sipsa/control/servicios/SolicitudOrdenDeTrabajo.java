package sipsa.control.servicios;

import sipsa.persistencia.Persistencia;

class SolicitudOrdenDeTrabajo extends Mensaje{

    @Override
    public Mensaje procesar() {
        Persistencia persistencia = Persistencia.getPersistencia();
        Mensaje respuesta = MensajesFabrica.newRespuestaOrdenDeTrabajo();
        respuesta.setContenido(persistencia.getOrdenDeTrabajo(this.getContenido()));
        return respuesta;
    }
}