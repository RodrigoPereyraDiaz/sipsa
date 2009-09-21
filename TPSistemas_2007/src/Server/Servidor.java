/*
 * Servidor.java
 *
 * Created on 5 de abril de 2007, 2:50
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package Server;

import java.io.*;
import java.net.*;



/**
 *
 * @author Mariano
 */
public class Servidor{
  private webserver_starter message_to; //the starter class, needed for gui
  private int port; //port we are going to listen to
  

    
    public Servidor(int puerto,webserver_starter to_send_message_to) {
         message_to = to_send_message_to;
         port = puerto;
         
        this.arranca();
  
    }
    
   
   private void arranca(){
         
       try{
       
         s("Aceptando conexiones en el puerto: " + port+"\n");
         s("Servidor HTTP en ejecucion...\n");
         s("Esperando peticiones ....\n\n");
      
        ServerSocket serversocket = new ServerSocket(port);

        while (true){
              
             Socket connectionsocket = serversocket.accept();
             InetAddress client = connectionsocket.getInetAddress();

             s(client.getHostName() + " conectado al servidor.\n");
           
             PeticionWeb pCliente = new PeticionWeb(connectionsocket,message_to);
	     pCliente.start();
                      
        }
       
        
              
      }catch(IOException e){
           s(e.getMessage()+" --->>Servidor abortado");
       }
       
      
   }
   
 private void s(String s2) { //an alias to avoid typing so much!
    message_to.send_message_to_window(s2.toUpperCase());
  }


}


