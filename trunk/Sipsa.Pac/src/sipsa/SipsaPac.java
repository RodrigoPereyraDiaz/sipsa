/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sipsa;

import javax.swing.UIManager;
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
        } catch(Exception e) {
            e.printStackTrace();
        }

        Login login = new Login();
        login.setVisible(true);

    }

}
