/*
 * Login.java
 *
 * Created on 5 de abril de 2007, 16:10
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package Presentacion.HTTPServer;

import java.io.PrintWriter;

/**
 *
 * @author Mariano
 */
public class Login {
    
    String pag_login=   "<html>\n" +
                        "<head><title>Sistema de Presupuesto WEB</title></head>\n" +
                        "<body>\n" +
                        "<H1><b><i><u> Bienvenido al Sistema</b></i></u></H1>\n"+
                        "<HR></HR>\n"+
                        "<FORM ACTION='http://localhost/login.html' METHOD='GET' ENCTYPE='application/octect-stream'>\n"+  
                        " CUIT: <INPUT TYPE=TEXT NAME='cuit' SIZE=10 MAXLENGTH=10 VALUE=''>\n\n "+  
                        " Contraseña: <INPUT TYPE=PASSWORD NAME='contra' SIZE=5 MAXLENGTH=5 VALUE=''><TR>\n"+                 
                        "<HR></HR>\n"+
                        "<INPUT TYPE=SUBMIT NAME='seguir' VALUE='Entrar'></TR>\n"+                        
                        "</FORM>\n" +                         
                        "</body>\n" +
                        "</html>\n";
    
    String ok="HTTP/1.1  200 OK\r\n"+
              "Content-type: text/html\r\n"+
              "Content-length: ";

    /** Creates a new instance of Login */
    public Login() {
       
    }
    
    public String getLogin(){
       
        return(ok+pag_login.length()+"\r\n\r\n"+pag_login);
    }
}
