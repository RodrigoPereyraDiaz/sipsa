/*
 * Formulario.java
 *
 * Created on 5 de abril de 2007, 21:46
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package Presentacion.HTTPServer;

import Dominio.Aplicacion.Clientes;
import Dominio.Aplicacion.Presupuestos;
import java.io.PrintWriter;
import java.util.Vector;
/**
 *
 * @author Mariano
 */
public class Formulario {
    String ok="HTTP/1.1  200 OK\r\n"+
              "Content-type: text/html\r\n"+
              "Content-length: ";

    
    /** Creates a new instance of Formulario */
    public Formulario() {
    }
    
    public String getListaPresus(Clientes c,Vector listP){
  
        String cad1=("<html>\n" +
                        "<head><title>Sistema de Presupuestos WEB</title></head>\n" +
                        "<body>" +
                        "<FORM ACTION='http://localhost/guardar.html' METHOD='GET' ENCTYPE='application/octect-stream'>\n"+  
                        "<HR></HR>"+
                        " <b>Nro Cliente: </b>"+c.getNumero()+"    <b>Nombre y Apellido: </b>"+c.getNombre()+", "+c.getApellido()+                 
                        "<HR></HR>"+
                        "<TABLE BORDER=10 WIDTH='90%' ALIGN='justify'>\n"+   
                        "<H3><b><i><u> Presupuestos para Aprobar/Rechazar</b></i></u></H3>\n"+   
                        "<TH ALIGN='center'>Nro. Presupuesto</TH>\n"+   
                        "<TH ALIGN='center'>Fecha</TH>\n"+
                        "<TH ALIGN='center'>Total</TH>\n"+
                        "<TH ALIGN='center'>Seleccionar</TH>\n"+
                        "<tr>\n");
                        String cad2="";
                        for(int i=1;i<=listP.size();i++){
                           Presupuestos p=(Presupuestos)listP.elementAt(i-1);
                           if ((c.getNumero()==p.getCliente().getNumero())&&(p.getAprobado()==0)&&(p.getRechazado()==0))
                            cad2+=("<TD ALIGN='center'>"+p.getNumero()+"</TD>"+   
                            "<TD ALIGN='center'>"+p.getFecha()+"</TD>\n"+
                            "<TD ALIGN='center'>"+p.getTotal()+"</TD>\n"+
                            "<TD ALIGN='center'><INPUT TYPE=CHECKBOX NAME='value' VALUE='"+p.getNumero()+"'></TD>\n"+  
                            "<TR>");
                        }
                        String cad3=("</TR>\n"+  
                        "</TABLE>\n"+   
                        "<HR></HR>"+
                        "<INPUT TYPE=SUBMIT NAME='aprobar' VALUE='Aprobar'>  \n"+
                        "<INPUT TYPE=SUBMIT NAME='rechazar' VALUE='Rechazar'>  \n"+
                        "</FORM>\n" +                                
                        "<FORM ACTION='http://localhost/salir.html' METHOD='GET' ENCTYPE='application/octect-stream'>\n"+
                        "<INPUT TYPE=SUBMIT NAME='salir' VALUE='Salir'>  \n"+
                        "</FORM>\n" +                                
                        "</body>\n" +
                        "</html>\n");
                       
                        return (ok+(cad1.length()+cad2.length()+cad3.length())+"\r\n\r\n"+cad1+cad2+cad3);
    }
        
}
    

