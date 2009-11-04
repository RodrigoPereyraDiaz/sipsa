/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sipsa.control.servicios;

import sipsa.dominio.Usuario;

/**
 *
 * @author elsupergomez
 */
class Login extends Mensaje {

    @Override
    public Mensaje procesar() {
        Mensaje mensaje = MensajesFabrica.getError();
        Usuario usuario = (Usuario) this.getContenido();
        if  (usuario.isValido()){
            mensaje = MensajesFabrica.getOK();
        }
        return mensaje;
    }
}
