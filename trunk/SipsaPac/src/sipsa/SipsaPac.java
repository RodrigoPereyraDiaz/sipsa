package sipsa;

import sipsa.control.servicios.Cliente;

/**
 * Punto de Inicio al sistema PAC
 * @author Claudio Rodrigo Pereyra Diaz
 * @author Maria Eugenia Sanchez
 */
public class SipsaPac {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Cliente cliente = Cliente.getCliente();
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("--host")) {
                i++;
                cliente.setHost(args[i]);
            } else if (args[i].startsWith("--port")) {
                i++;
                cliente.setPuerto(Integer.valueOf(args[i].substring(3)));
            } else {
                StringBuilder ayuda = new StringBuilder();
                ayuda.append("Ayuda de parametros del Servidor Sipsa:\n");
                ayuda.append("  --host <host>   --> Inicia el servidor con interface grafica\n");
                ayuda.append("  --port <port>   --> Indica en <nro> el puerto escucha del servidor, por defecto p=1027\n");
                ayuda.append("  --help          --> Muestra este mensaje de ayuda\n");
                System.out.println(ayuda.toString());
                System.exit(1);
            }
        }
        
        Configuracion configuracion = Configuracion.getInstancia();
        configuracion.setEstiloLocal();

        cliente.iniciar();
    }
}
