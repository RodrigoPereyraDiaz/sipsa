/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sipsa.control.servicios;

import sipsa.control.servicios.mensajes.*;
import sipsa.control.servicios.Mensaje;

/**
 *
 * @author elsupergomez
 */
public class MensajesFabrica {

    public static Mensaje getError(){
        return new RespuestaError();
    }

    public static Mensaje getOK(){
        return new RespuestaOK();
    }
}
