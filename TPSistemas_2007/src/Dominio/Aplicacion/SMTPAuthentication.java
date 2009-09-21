/*
 * SMTPAuthentication.java
 *
 * Created on 8 de abril de 2007, 13:25
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package Dominio.Aplicacion;

/**
 *
 * @author Mariano
 */
import javax.mail.PasswordAuthentication;


public class SMTPAuthentication extends javax.mail.Authenticator{
    
    public PasswordAuthentication getPasswordAuthentication(){
        String username = "nombre_de_usuario";
        String password = "clave";
        return new PasswordAuthentication(username, password);
    }

}
