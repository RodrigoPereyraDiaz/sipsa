/*
 * PeticionWeb.java
 *
 * Created on 7 de abril de 2007, 21:09
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package Server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.StringTokenizer;
import Dominio.Controladores.ControladorWeb;
import java.util.Vector;
/**
 *
 * @author Mariano
 */
class PeticionWeb extends Thread{
	
        private webserver_starter message_to;
	private Socket scliente= null;		// representa la petición de nuestro cliente
   	private PrintWriter out= null;		// representa el buffer donde escribimos la respuesta
        private ControladorWeb cw;
        String r="<html>\n" +
             "<body><h1>Petición no soportada\n</h1> <h2>El servidor de destino solo usa metodos GET </h2>\n" +
             "</body>\n" +
             "</html>";
    
        String error="HTTP/1.1  501 Not Implemented”.\r\n"+
                 "Content-type: text/html\r\n"+
                 "Content-length: ";
        
   	PeticionWeb(Socket ps,webserver_starter message){
		this.message_to=message;
                scliente = ps;
		setPriority(NORM_PRIORITY - 1); // hacemos que la prioridad sea baja
                cw=new ControladorWeb();
   	}

	public void run() // emplementamos el metodo run
	{
		
		try{
			BufferedReader in = new BufferedReader(new InputStreamReader(scliente.getInputStream()));
                        PrintWriter out= new PrintWriter(scliente.getOutputStream(),true);
                        s("Procesamos conexion\n");
			String cadena = ""; // cadena donde almacenamos las lineas que leemos
                        
                        Vector header=new Vector(); 
			while(true){
                            cadena="";
                            while (!(cadena=in.readLine()).equals("")){
                                 header.addElement(cadena); 
                             }
                        
                                cadena=(String)header.elementAt(0);
                            
                                if (cadena != null ){
                        		// sleep(500);
                        		s("--" + cadena + "\n");
                                }
                           
                                StringTokenizer st = new StringTokenizer(cadena);

                                if ((st.countTokens() >= 2) && st.nextToken().equals("GET")){
                                      header.removeAllElements();
                                      String cad = st.nextToken(); //saco la peticion    
                                      String re=cw.atenderPeticion(cad);
                                      
                                      out.println(re);
                                      
                                      StringTokenizer ret = new StringTokenizer(re);
                                      re=ret.nextToken(); //saco el HTTP
                                      if (!(ret.nextToken().equals("200"))){ //por error de login
                                          scliente.close();
                                          break;                                
                                      }
                                      
                                      if (cad.startsWith("/salir.html")){ //presiona salir
                                          scliente.close();
                                          break; 
                                      }
                                         
                                }else{
                                      out.println(error+r.length()+"\r\n\r\n"+r); //por error de metodo
                                      scliente.close();
                                       break;
                                }
                            
                            }
                     
		}catch(Exception e)
		{
			s("Error en servidor\n" + e.toString()+"\n");
                        
		}
                
		    s("Un Cliente ha dejado la conexión\n\n");
               
	}
private void s(String s2) { //an alias to avoid typing so much!
    message_to.send_message_to_window(s2);
  }
}



