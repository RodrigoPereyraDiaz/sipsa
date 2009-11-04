/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sipsa.control.servicios;

import java.io.IOException;

import java.net.Socket;
import sipsa.presentacion.interfaces.ILogin;

/**
 *
 * @author elsupergomez
 */
public class Cliente implements ILogin{

    private Conexion conexion;

    public void conectar(String host, int puerto) throws IOException{
        conexion = new Conexion(new Socket(host,puerto));
    }

    public void ingresar(String usuario, char[] password) {
        throw new UnsupportedOperationException("Not supported yet.");

    }
}
