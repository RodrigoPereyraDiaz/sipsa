/*
 * Sistemas de Informacion II 2009
 * Proyecto Sipsa
 */

package sipsa;

import javax.swing.UIManager;
import sipsa.control.controladores.MenuSipsaControl;

/**
 * Punto de inicio del Sistema Sipsa
 * @author Claudio Rodrigo Pereyra Diaz
 * @author Maria Eugenia Sanchez
 */
public class Sipsa {

    /**
     * @param args Argumentos de linea de comandos
     */
    public static void main(String[] args) {

        try {
            //Indica al UIManager que use el tema nativo del Sistema Operativo
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch(Exception e) {
            e.printStackTrace();
        }

        MenuSipsaControl menuSipsaControl = new MenuSipsaControl();
        menuSipsaControl.mostrarMenu();
    }
}