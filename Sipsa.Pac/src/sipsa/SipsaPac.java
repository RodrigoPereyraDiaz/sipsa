/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sipsa;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import sipsa.control.servicios.Cliente;
import sipsa.control.servicios.Conexion;
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
        Configuracion configuracion = Configuracion.getInstancia();
        configuracion.setEstiloLocal();
        try {
            Conexion conexion = new Conexion(new Socket("localhost", 1027));
            Cliente cliente = new Cliente(conexion);
            Login login = new Login(cliente);
            login.setVisible(true);
        } catch (UnknownHostException ex) {
            Logger.getLogger(SipsaPac.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(1);
        } catch (IOException ex) {
            Logger.getLogger(SipsaPac.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(1);
        }
        
    }
}
