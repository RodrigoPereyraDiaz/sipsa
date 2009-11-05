package sipsa.control.servicios;

import sipsa.dominio.OrdenDeTrabajo;

class RespuestaOrdenDeTrabajo extends Mensaje{
//TODO ver si es realmente necesario siempre devolver un Mensaje
    @Override
    public Mensaje procesar() {
        OrdenDeTrabajo ordenDeTrabajo = (OrdenDeTrabajo) this.getContenido();
        Cliente.handleOrdenDeTrabajo(ordenDeTrabajo);
        return MensajesFabrica.newRespuestaOK();
    }

}