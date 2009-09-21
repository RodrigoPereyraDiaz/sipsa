package Dominio.Aplicacion;

import Dominio.Controladores.ControladorOC;
import java.util.*;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class Mail{
    static String cuerpoMensaje ="";
    ControladorOC oc;
    
    
   public Mail() {    }
    
    public void enviarMail(Vector v){
        cuerpoMensaje = "Producto          Cantidad\n"+"--------          --------\n";
        for (int k = 0; k < v.size(); k = k+2){
            Productos de = (Productos)v.elementAt(k);
            String art = de.getDescripcion();

              int l = 18-art.length();
              for (int i=0;i<l;i++){
                  art = art + " ";
              }
        cuerpoMensaje = cuerpoMensaje + art;
        cuerpoMensaje = cuerpoMensaje + v.elementAt(k+1) + "\n";
        }
        this.Send();

    }
    public static void Send(){

        String host ="127.0.0.1";
        String from ="adri@yo.com";
        String to = "otro@yo.com";
        
        System.out.println ("Prueba para enviar un mail..." + new java.util.Date()); 
        Properties prop = new Properties();
        
        prop.put("mail.smtp.host", host); 
        
        /*Esta línea es la que indica al API que debe autenticarse*/
        prop.put("mail.smtp.auth", "false"); 
        
        /*Añadir esta linea si queremos ver una salida detallada del programa*/
        //prop.put("mail.debug", "true");
        
        try{ 
            SMTPAuthentication auth = new SMTPAuthentication(); 
            Session session = Session.getInstance(prop , auth ); 
            Message msg = getMessage(session, from, to); 
            System.out.println ("Enviando ..." );
            Transport.send(msg); 
            System.out.println ("Mensaje enviado!");
        }catch (Exception e){ 
            ExceptionManager.ManageException(e); 
        }  
    }
    
    private static MimeMessage getMessage(Session session, String from, String to) {
        try{  
            MimeMessage msg = new MimeMessage(session); 
            msg.setSubject("Productos para fabricar");
            msg.setText(cuerpoMensaje);
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            msg.setFrom(new InternetAddress(from,"Administrador"));
            return msg;
        }catch (java.io.UnsupportedEncodingException ex){ 
            ExceptionManager.ManageException(ex);
            return null;
        }catch (MessagingException ex){  
            ExceptionManager.ManageException(ex);
            return null;  
        } 
    }

}
