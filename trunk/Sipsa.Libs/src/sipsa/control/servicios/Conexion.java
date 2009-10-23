package sipsa.control.servicios;

import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {

    private Socket socket;

    public Conexion(Socket socket) {
        this.socket = socket;
    }

    public Mensaje recibirMensaje() throws ClassNotFoundException{
        Mensaje solicitud = new Mensaje();
        solicitud.setDescriptor("Error");
        try {
            ObjectInputStream entrada = new ObjectInputStream(socket.getInputStream());
            solicitud = (Mensaje) entrada.readObject();
            System.out.println(solicitud.getDescriptor());
            return solicitud;
        } catch (IOException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            return solicitud;
        }
    }

    public void enviarMensaje(Mensaje mensaje){
        try {
            ObjectOutputStream salida = null;
            salida = new ObjectOutputStream(socket.getOutputStream());
            salida.writeObject(mensaje);
        } catch (IOException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}