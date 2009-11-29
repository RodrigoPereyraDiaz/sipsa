/*
 * Sistemas de Informacion II 2009
 * Proyecto Sipsa
 */
package sipsa.control.servicios;

import java.net.*;
import java.io.*;

/**
 * Coneccion utilizada para la comunicacion entre el Servidor Sipsa y los Clientes Sipsa
 * @author Claudio Rodrigo Pereyra Diaz
 * @author Maria Eugenia Sanchez
 */
class Conexion {

    private Socket socket;
    private String direccionRemota;

    /**
     * Conexion Activa entre entre entre Cliente Sipsa y Servidor Sipsa
     * @param socket Socket de conexion para la comunicacion
     */
    public Conexion(Socket socket) {
        this.socket = socket;
        this.direccionRemota = socket.getInetAddress().getHostName();
    }

    public String getDireccionRemota() {
        return this.direccionRemota;
    }

    public void finalizar() throws IOException {
        this.socket.close();
    }

    /**
     * Espera recibir un Mesaje del Protocolo por el canal de comunicacion
     * @return Mensaje recibido, Mensaje de Error en caso de no recibir correctamente
     */
    public Mensaje recibirMensaje() throws IOException {
        Mensaje solicitud = MensajesFabrica.newRespuesta();
        ObjectInputStream entrada = new ObjectInputStream(socket.getInputStream());
        try {
            solicitud = (Mensaje) entrada.readObject();
        } catch (ClassNotFoundException ex) {
            solicitud.setContenido("Error " + ex.getLocalizedMessage());
        } finally {
            return solicitud;
        }
    }

    /**
     * Envia un mensaje del protocolo por el canal de comunicacion
     * @param mensaje
     */
    public void enviarMensaje(Mensaje mensaje) throws IOException {
        ObjectOutputStream salida = new ObjectOutputStream(socket.getOutputStream());
        salida.writeObject(mensaje);
    }
}
