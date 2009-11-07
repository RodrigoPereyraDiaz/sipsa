package sipsa.control.servicios;

import java.util.ArrayList;
import sipsa.dominio.OrdenDeTrabajo;

class RespuestaReporte extends Mensaje{

    @Override
    public Mensaje procesar() {
        ArrayList<OrdenDeTrabajo> list = (ArrayList<OrdenDeTrabajo>) this.getContenido();
        Cliente.handleReporte(list);
        return MensajesFabrica.newRespuestaOK();
    }
}
