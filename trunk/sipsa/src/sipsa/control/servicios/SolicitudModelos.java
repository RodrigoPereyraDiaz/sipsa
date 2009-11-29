/*
 * Sistemas de Informacion II 2009
 * Proyecto Sipsa
 */
package sipsa.control.servicios;

import sipsa.SipsaExcepcion;
import sipsa.control.OTControl;

/**
 * Mensaje de solcitud de lista de Modelos
 * @author Claudio Rodrigo Pereyra Diaz
 * @author Maria Eugenia Sanchez
 */
public class SolicitudModelos extends Mensaje {

    @Override
    public Object procesar() throws SipsaExcepcion {
        Mensaje respuesta = MensajesFabrica.newRespuesta();
        OTControl oTControl = new OTControl();
        respuesta.setContenido(oTControl.getListaModelos());
        return respuesta;
    }
}
