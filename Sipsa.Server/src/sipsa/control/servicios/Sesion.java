package sipsa.control.servicios;

import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Sesion extends Thread {

    private Conexion conexion;

    public Sesion(Socket socket) {
        conexion = new Conexion(socket);
        this.start();
    }

    @Override
    public void run() {
        while (true){
            try {
                Mensaje mensaje = conexion.recibirMensaje();
                Mensaje respuesta = this.procesarMensaje(mensaje);
                conexion.enviarMensaje(respuesta);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Sesion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private Mensaje procesarMensaje(Mensaje mensaje){
        //TODO procesar mensaje y armar mensaje de respuesta
        if (mensaje.getDescriptor().equalsIgnoreCase("hola servidor"))
            mensaje.setDescriptor("hola cliente");
        return mensaje;
    }
}
