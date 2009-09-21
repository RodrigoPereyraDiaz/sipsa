/*
 * ControladorWeb.java
 *
 * Created on 7 de abril de 2007, 6:02
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package Dominio.Controladores;
import Dominio.Aplicacion.Clientes;
import Presentacion.HTTPServer.*;
import java.io.PrintWriter;

import BaseDatos.IntermediarioClientes;
import BaseDatos.IntermediarioPresupuestos;
import java.util.StringTokenizer;
import java.util.Vector;
/**
 *
 * @author Mariano
 */
public class ControladorWeb {
    Clientes cli; 
    Vector lista;
    IntermediarioPresupuestos interPresu;
    String r="<html>\n" +
             "<body><h1>Cliente No Autorizado\n</h1> <h2>Verifique los datos y vuelva a intentar </h2>\n" +
             "</body>\n" +
             "</html>";
    
    String error="HTTP/1.1  401 Unauthorized\r\n"+
                 "Content-type: text/html\r\n"+
                 "Content-length: ";
    
    /** Creates a new instance of ControladorWeb */
    public ControladorWeb() {
    }

    public String atenderPeticion(String cad) {
        Login l=new Login();
        Formulario f=new Formulario();
        String res="";
        if (cad.equals("/")){
            
            res=l.getLogin();
        }else{
                                  
            if (cad.startsWith("/login.html?")){
                String Parametros= cad.substring(12,cad.length());
               // System.out.println(Parametros);
                Vector p=this.obtenerParam(Parametros+"&");
                IntermediarioClientes it=new IntermediarioClientes();
                int id_usuario=it.validar((String)p.elementAt(0),(String)p.elementAt(1));
                if (id_usuario>0){
                    IntermediarioClientes interCli=new IntermediarioClientes();
                    cli=interCli.getCliente(id_usuario);
                    interPresu=new IntermediarioPresupuestos();
                    lista=interPresu.getLista();
                    res=f.getListaPresus(cli,lista);
                }else{
                    
                    res=error+r.length()+"\r\n\r\n"+r;
                    
                }
             
             }else if (cad.startsWith("/guardar.html?")){
                    String Parametros= cad.substring(14,cad.length());
                    //System.out.println(Parametros);
                    Vector p=this.obtenerParam(Parametros+"&");
                    IntermediarioPresupuestos ip=new IntermediarioPresupuestos();
                    ip.ActPresupuestos(p);
                    lista=interPresu.getLista();
                    res=f.getListaPresus(cli,lista);
             }else if (cad.startsWith("/salir.html?"))
                    res=l.getLogin();
                    
        }
        
        return res;
    }
    
   private Vector obtenerParam(String cad){
       Vector v=new Vector();
       StringTokenizer st= new StringTokenizer(cad);
       String var;
       while(st.hasMoreElements()){
           var=st.nextToken("&");
           int i=var.indexOf("=");
           var=var.substring(i+1,var.length());
           v.addElement(var);
           //System.out.println(var);
       }
       return v; 
    }
    
}
