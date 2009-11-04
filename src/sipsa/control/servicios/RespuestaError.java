/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sipsa.control.servicios;

import sipsa.control.servicios.Mensaje;

/**
 *
 * @author elsupergomez
 */
class RespuestaError extends Mensaje{

    @Override
    public Mensaje procesar() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
