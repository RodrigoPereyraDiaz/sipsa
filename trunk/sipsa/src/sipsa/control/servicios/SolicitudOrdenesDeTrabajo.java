package sipsa.control.servicios;

import sipsa.persistencia.Persistencia;

class SolicitudOrdenesDeTrabajo extends Mensaje{

    @Override
    public Mensaje procesar() {
        Persistencia persistencia = Persistencia.getPersistencia();
        Mensaje respuesta = MensajesFabrica.newRespuestaOrdenDeTrabajo();
        respuesta.setContenido(persistencia.getOrdenesDeTrabajo());
        return respuesta;
    }
}
