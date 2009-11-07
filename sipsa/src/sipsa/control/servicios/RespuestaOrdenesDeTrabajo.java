package sipsa.control.servicios;

import java.util.ArrayList;
import sipsa.dominio.OrdenDeTrabajo;

class RespuestaOrdenesDeTrabajo extends Mensaje{

    //TODO ver si es necesario siempre devolver un mensaje
    @Override
    public Mensaje procesar() {
        ArrayList<OrdenDeTrabajo> list = (ArrayList<OrdenDeTrabajo>) this.getContenido();
        Cliente.handleOrdenesDeTrabajo(list);
        return MensajesFabrica.newRespuestaOK();
    }

}
