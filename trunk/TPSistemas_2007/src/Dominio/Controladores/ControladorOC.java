package Dominio.Controladores;
import Dominio.Aplicacion.*;
import java.text.SimpleDateFormat;
import java.util.*;
import BaseDatos.*;
import java.io.*;

public class ControladorOC {
    IntermediarioPresupuestos interPresu;
    IntermediarioProveedores interPro;
    GeneraOC oc;
    Vector artiProd, vProd, arti, proveedorXArti, artiTotal, productos;
    Mail mail;
    
    public ControladorOC(){
        interPresu= new IntermediarioPresupuestos();
        interPro = new IntermediarioProveedores();
        oc = new GeneraOC();
        artiProd = new Vector();
        vProd = new Vector();
        arti = new Vector();
        artiTotal = new Vector();
        proveedorXArti = new Vector();
        productos = new Vector();
    }
    
    public void enviarFabricacion(int[] NroPresu) {   
        int idProvee, fPedido, idArti;
        String rSocial, descri;
        float canti;
        artiProd.removeAllElements();
        vProd.removeAllElements();
        arti.removeAllElements();
        artiTotal.removeAllElements();
        proveedorXArti.removeAllElements();
        productos.removeAllElements();

        // articulos y productos de los presupuestos seleccionados
        artiProd = interPresu.getProductos(NroPresu);
        
        if (artiProd.size()!=0){
            // obtengo Vector: productos de presupuestos
            vProd = oc.armarVArtiProdu(artiProd);
        }      
        
        ConcretoCreadorItems it = new ConcretoCreadorItems();       
        if (vProd.size()!=0){
            //Armo mail
            IntermediarioProductos ip = new IntermediarioProductos();
            for (int i=0;i<vProd.size();i=i+2){
                Productos pr = new Productos();
                pr = (Productos)ip.getItem((Integer)vProd.elementAt(i));
                productos.add(pr);
                productos.add((Float)vProd.elementAt(i+1));
            }
        }
        
        if (productos.size()!=0){
            oc.armarSalidaMail(productos);
        }
       
        if (artiProd.size()!=0){
            // obtengo Vector: articulos q forman los productos de presupuestos seleccionados
            IntermediarioArticulos ia = (IntermediarioArticulos) it.factoryMethod(0);
            arti = ia.artiXProdu(artiProd);
        }
     
         if (arti.size()!=0){
            // obtengo Vector: articulos solos + los de los productos
            artiTotal = oc.getArtiTotal(arti);
         }
       
         if(artiTotal.size()!=0){
            proveedorXArti = interPro.getProvXArticulos(artiTotal);
         }
      
         if (proveedorXArti.size()!=0)
             oc.armarSalida(proveedorXArti);
        
        interPresu.actualizarPresupuestos(NroPresu);

   }
   
    public Vector getListaProveedores() {
        return interPro.getLista();
    }
    
    public Vector getListaClientes() {
        IntermediarioClientes InterClientes= new IntermediarioClientes(); 
        return InterClientes.getLista();
    }

    public Vector obtenerPresupuestos(int id_Cli) {
        return interPresu.getListaPresuAprobProd(id_Cli);
    }
}
