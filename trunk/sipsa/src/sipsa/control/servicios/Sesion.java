/*
 * Sistemas de Informacion II 2009
 * Proyecto Sipsa
 */

package sipsa.control.servicios;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Sesion de Cliente conectado al Servidor
 * @author Claudio Rodrigo Pereyra Diaz
 * @author Maria Eugenia Sanchez
 */
class Sesion extends Thread {

    private Conexion conexion;
    private Servidor servidor;

    /**
     * Crea una nueva instancia de Sesion
     * @param conexion Conexion con el Cliente
     * @param servidor Servidor receptor de la conexion
     */
    public Sesion(Conexion conexion,Servidor servidor) {
        this.conexion = conexion;
        this.servidor = servidor;
        this.start();
    }

    /**
     * Espera mensaje de solicitud desde el cliente, y envia la respuesta correspondiente
     */
    @Override
    final public void run() {
        try {
            while (true){
                Mensaje solicitud = conexion.recibirMensaje();
                servidor.notificar("<== " + this.conexion.getDireccionRemota());
                Mensaje respuesta = solicitud.procesar();
                conexion.enviarMensaje(respuesta);
                servidor.notificar("==> " + this.conexion.getDireccionRemota());
            }
        } catch (IOException ex) {
            servidor.notificar("Cliente desde " + this.conexion.getDireccionRemota() + " desconectado");
        } catch (Exception ex) {
            Logger.getLogger(Sesion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}