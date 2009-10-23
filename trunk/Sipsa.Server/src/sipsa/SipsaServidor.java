/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sipsa;

import javax.swing.UIManager;
import sipsa.control.servicios.Servidor;
import sipsa.presentacion.escritorio.ServidorGUI;

/**
 *
 * @author elsupergomez
 */
public class SipsaServidor {
    private static boolean demonio = false;
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

        // TODO manejar los argumentos, y dar posibilidad a daemonizar o usar frontend
        Servidor servidor = new Servidor();
        for (int i = 0; i < args.length; i++) {
            String string = args[i];
            if (string.equalsIgnoreCase("-d")){
                demonio = true;
            } else if (string.startsWith("-p=")){
                int puerto = Integer.valueOf(string.substring(3));
                servidor.setPuerto(puerto);
            } else {
                StringBuilder ayuda = new StringBuilder();
                ayuda.append("-d       --> Servidor en modo Demonio");
                ayuda.append("-p=<nro> --> Indica en <nro> el puerto escucha del servidor");
                ayuda.append("-h       --> Muestra este mensaje de ayuda");
                System.out.println(ayuda.toString());
                System.exit(1);
            }
        }
        if (SipsaServidor.demonio){
            servidor.setDaemon(demonio);
            servidor.iniciar();
        } else {
            ServidorGUI servidorGUI = new ServidorGUI(servidor);
            servidorGUI.setVisible(true);
        }
    }
}
