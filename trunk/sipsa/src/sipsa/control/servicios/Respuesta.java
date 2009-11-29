/*
 * Sistemas de Informacion II 2009
 * Proyecto Sipsa
 */
package sipsa.control.servicios;

import sipsa.SipsaExcepcion;
import sipsa.presentacion.escritorio.DialogoMensaje;

/**
 * Mensaje de Respuesta a las solicitudes realizadas al servidor
 * @author Claudio Rodrigo Pereyra Diaz
 * @author Maria Eugenia Sanchez
 */
public class Respuesta extends Mensaje {

    @Override
    public Object procesar() throws SipsaExcepcion {
        if (this.getContenido().getClass().equals(SipsaExcepcion.class)) {
            throw (SipsaExcepcion) this.getContenido();
        }
        if (this.getContenido().getClass().equals(String.class)) {
            new DialogoMensaje(DialogoMensaje.Tipo.Información, this.getContenido().toString());
        }
        return this.getContenido();
    }
}
