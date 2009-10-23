/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sipsa;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import sipsa.control.servicios.Conexion;
import sipsa.control.servicios.Mensaje;
import sipsa.presentacion.escritorio.Login;

/**
 *
 * @author elsupergomez
 */
public class SipsaPac {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            //Indica al UIManager que use el tema nativo del Sistema Operativo
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {

            Socket socket = new Socket("localhost", 1027);
            Conexion conexion = new Conexion(socket);
            Mensaje mensaje = new Mensaje();
            mensaje.setDescriptor("hola servidor");
            conexion.enviarMensaje(mensaje);
            Mensaje mensajerespuesta = conexion.recibirMensaje();
            Login login = new Login();
            login.setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SipsaPac.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SipsaPac.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
