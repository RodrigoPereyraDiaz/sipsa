/*
 * Sistemas de Informacion II 2009
 * Proyecto Sipsa
 */
package sipsa.control.servicios;

import sipsa.SipsaExcepcion;
import sipsa.control.PvControl;

/**
 * Mensaje de solicitd de lista de Puntos de Venta
 * @author Claudio Rodrigo Pereyra Diaz
 * @author Maria Eugenia Sanchez
 */
public class SolicitudPuntosDeVenta extends Mensaje {

    @Override
    public Object procesar() throws SipsaExcepcion {
        Mensaje respuesta = MensajesFabrica.newRespuesta();
        PvControl pvControl = new PvControl();
        respuesta.setContenido(pvControl.getComboBox());
        return respuesta;
    }
}
