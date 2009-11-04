/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sipsa.control.servicios;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import sipsa.presentacion.interfaces.ILogin;

/**
 *
 * @author elsupergomez
 */
public class Cliente implements ILogin{

    private Conexion conexion;


    public Cliente(Conexion conexion) throws IOException{
            this.conexion = conexion;
            this.saludar();
    }

    public boolean ingresar(String usuario, char[] password) {
        throw new UnsupportedOperationException("Not supported yet.");

    }

    @Deprecated
    private void saludar(){
        try {
            Mensaje mensaje = new Mensaje();
            mensaje.setDescriptor("hola servidor");
            conexion.enviarMensaje(mensaje);
            Mensaje mensajerespuesta = conexion.recibirMensaje();
            mensajerespuesta.procesar();
            mensaje.setDescriptor("hola de nuevo servidor");
            conexion.enviarMensaje(mensaje);
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
