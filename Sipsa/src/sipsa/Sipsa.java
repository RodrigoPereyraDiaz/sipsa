/*
 * Sistemas de Informacion II 2009
 * Proyecto Sipsa
 */

package sipsa;

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

        Configuracion configuracion = Configuracion.getInstancia();
        configuracion.setEstiloLocal();

        MenuSipsaControl menuSipsaControl = new MenuSipsaControl();
        menuSipsaControl.mostrarMenu();
    }
}