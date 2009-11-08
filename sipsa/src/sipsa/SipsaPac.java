/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sipsa;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

import sipsa.control.SipsaPacMenuControl;
import sipsa.control.servicios.Cliente;
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
        //TODO ver como empezar las llamadas

        SipsaPacMenuControl menuPacSipsaControl = new SipsaPacMenuControl();
        menuPacSipsaControl.mostrarMenu();

        try {
            Cliente cliente = new Cliente();
            cliente.conectar("localhost", 1027);
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
