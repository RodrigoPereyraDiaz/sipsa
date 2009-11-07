/*
 * Sistemas de Informacion II 2009
 * Proyecto Sipsa
 */

package sipsa;

import sipsa.control.servicios.Servidor;
import sipsa.presentacion.escritorio.ServidorGUI;

/**
 * Aplicacion Servidor de Sipsa
 * @author Claudio Rodrigo Pereyra Diaz
 * @author Maria Eugenia Sanchez
 */
public class SipsaServidor {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Configuracion configuracion = Configuracion.getInstancia();
        configuracion.setEstiloLocal();

        Servidor servidor = new Servidor();
        for (int i = 0; i < args.length; i++) {
            String string = args[i];
            if (string.equalsIgnoreCase("-g")){
                new ServidorGUI(servidor);
            } else if (string.startsWith("-p=")){
                int puerto = Integer.valueOf(string.substring(3));
                servidor.setPuerto(puerto);
            } else {
                StringBuilder ayuda = new StringBuilder();
                ayuda.append("Ayuda de parametros del Servidor Sipsa:\n");
                ayuda.append("  -g       --> Inicia el servidor con interface grafica\n");
                ayuda.append("  -p=<nro> --> Indica en <nro> el puerto escucha del servidor, por defecto p=1027\n");
                ayuda.append("  -h       --> Muestra este mensaje de ayuda\n");
                System.out.println(ayuda.toString());
                System.exit(1);
            }
        }
        servidor.iniciar();
    }
}