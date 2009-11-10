package sipsa.control.servicios;

import java.util.List;
import sipsa.dominio.OrdenDeTrabajo;

class RespuestaOrdenesDeTrabajo extends Mensaje{

    //TODO ver si es necesario siempre devolver un mensaje
    @Override
    public Mensaje procesar() {
        List<OrdenDeTrabajo> list = (List<OrdenDeTrabajo>) this.getContenido();
        Cliente.getCliente().handleOrdenesDeTrabajo(list);
        return MensajesFabrica.newRespuestaOK();
    }

}
