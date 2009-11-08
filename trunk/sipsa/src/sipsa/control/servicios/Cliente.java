package sipsa.control.servicios;

import java.io.IOException;

import java.net.Socket;
import java.util.ArrayList;
import sipsa.dominio.OrdenDeTrabajo;
import sipsa.presentacion.interfaces.ILogin;

public class Cliente implements ILogin{

    static void handelError(RespuestaError error) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    static void handelOK(RespuestaOK mensaje) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    static void handleOrdenDeTrabajo(OrdenDeTrabajo ordenDeTrabajo) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    static void handleOrdenesDeTrabajo(ArrayList<OrdenDeTrabajo> list) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    static void handleReporte(ArrayList<OrdenDeTrabajo> list) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

//TODO Completar la clase cliente que es controlador del cliente pac
    private Conexion conexion;

    public void conectar(String host, int puerto) throws IOException{
        this.conexion = new Conexion(new Socket(host,puerto));
    }

    public void ingresar(String text) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
