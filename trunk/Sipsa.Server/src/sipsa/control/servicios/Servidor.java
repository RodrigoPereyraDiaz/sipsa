package sipsa.control.servicios;

import java.io.IOException;
import java.net.*;
import java.util.ArrayList;
import java.util.Iterator;

public class Servidor extends Thread implements IServicio{
   private int puerto = 1027;
   private static ArrayList<IReceptorNotificado> receptores = new ArrayList<IReceptorNotificado>();
   
   public void iniciar() {
        this.notificar("Iniciando Servidor...");
            this.start();
   }

   @Override
    final public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(this.puerto);
            this.notificar("Servidor aceptando conexiones...");
            while (true){
                Socket socket = serverSocket.accept();
                new Sesion(socket);
                this.notificar("Nueva conexion desde: " + socket.getInetAddress());
            }
        } catch (IOException ex) {
            this.notificar("Error en el servidor: " + ex.getLocalizedMessage());
        }
    }

    public void setPuerto(int puerto) {
        this.puerto = puerto;
    }
    
    public void notificar(String mensaje){
        for (Iterator<IReceptorNotificado> it = receptores.iterator(); it.hasNext();) {
            IReceptorNotificado iReceptorNotificado = it.next();
            iReceptorNotificado.procesarNotificacion(mensaje);
        }
        System.out.println(mensaje);
    }

    public void addReceptorNotificado(IReceptorNotificado iReceptorNotificado) {
        receptores.add(iReceptorNotificado);
    }

    public void removeReceptorNotificado(IReceptorNotificado iReceptorNotificado) {
        receptores.remove(iReceptorNotificado);
    }
}
