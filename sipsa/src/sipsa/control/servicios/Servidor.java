/*
 * Sistemas de Informacion II 2009
 * Proyecto Sipsa
 */
package sipsa.control.servicios;

import java.io.IOException;
import java.net.*;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Servidor de Sispa para Arquitectura Cliente-Servidor
 * @author Claudio Rodrigo Pereyra Diaz
 * @author Maria Eugenia Sanchez
 */
public class Servidor extends Thread implements INotificador {

    private int puerto = 1027; //Puerto por defecto
    private ArrayList<IReceptorNotificado> receptores = new ArrayList<IReceptorNotificado>();

    /**
     * Inicia el Servidor Sipsa
     */
    public void iniciar() {
        this.notificar("Iniciando Servidor...");
        this.setName("SipsaServer");
        this.start();
    }

    /**
     * Mientras el servidor esta corriendo queda a espera de conexiones de clientes.
     */
    @Override
    final public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(this.puerto);
            this.notificar("Servidor aceptando Clientes...");
            while (true) {
                Socket socket = serverSocket.accept();
                new Sesion(new Conexion(socket), this);
                this.notificar("Nuevo Cliente desde: " + socket.getInetAddress());
            }
        } catch (IOException ex) {
            this.notificar("Error en el servidor: " + ex.getLocalizedMessage());
        }
    }

    /**
     * Establece el puerto de escucha del servidor
     * @param puerto escucha
     */
    public void setPuerto(int puerto) {
        this.puerto = puerto;
    }

    /**
     * Notifica a todos los Receptores las notificaciones de los eventos del servidor
     * @param mensaje Notificacion
     */
    public void notificar(String mensaje) {
        for (Iterator<IReceptorNotificado> it = receptores.iterator(); it.hasNext();) {
            IReceptorNotificado iReceptorNotificado = it.next();
            iReceptorNotificado.procesarNotificacion(mensaje);
        }
        System.out.println(mensaje);
    }

    /**
     * Agrega un Receptor de Notificaciones a la lista de Receptores de notificacion
     * @param iReceptorNotificado
     */
    public void addReceptorNotificado(IReceptorNotificado iReceptorNotificado) {
        receptores.add(iReceptorNotificado);
    }

    /**
     * Quita un Receptor de Notificacinoes de la lista de Receptores de notificacion
     * @param iReceptorNotificado
     */
    public void removeReceptorNotificado(IReceptorNotificado iReceptorNotificado) {
        receptores.remove(iReceptorNotificado);
    }
}
