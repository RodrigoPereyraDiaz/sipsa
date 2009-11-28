package sipsa.control.servicios;

import java.util.List;
import sipsa.dominio.OrdenDeTrabajo;

class RespuestaOrdenesDeTrabajo extends Mensaje{

    @Override
    public Mensaje procesar() {
        List<OrdenDeTrabajo> list = (List<OrdenDeTrabajo>) this.getContenido();
        Cliente.getCliente().handleOrdenesDeTrabajo(list);
        return MensajesFabrica.newRespuestaOK();
    }

}
