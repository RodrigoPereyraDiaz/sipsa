/*
 * Sistemas de Informacion II 2009
 * Proyecto Sipsa
 */
package sipsa;

import sipsa.control.SipsaMenuControl;

/**
 * Punto de inicio del Sistema Sipsa
 * @author Claudio Rodrigo Pereyra Diaz
 * @author Maria Eugenia Sanchez
 */
class Sipsa {

    /**
     * Punto de ingreso al Sistema Sipsa
     * @param args Argumentos de linea de comandos
     */
    public static void main(String[] args) {

        Configuracion configuracion = Configuracion.getInstancia();
        configuracion.setEstiloLocal();

        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("--dbserver")) {
                i++;
                configuracion.setServidorDB(args[i]);
            } else {
                StringBuilder ayuda = new StringBuilder();
                ayuda.append("Ayuda de parametros del Servidor Sipsa:\n");
                ayuda.append("  --dbserver <host>   --> Indica la direccion del servidor de base de datos\n");
                ayuda.append("  --help          --> Muestra este mensaje de ayuda\n");
                System.out.println(ayuda.toString());
                System.exit(1);
            }
        }
        SipsaMenuControl menuSipsaControl = new SipsaMenuControl();
        menuSipsaControl.mostrarMenu();
    }
}
