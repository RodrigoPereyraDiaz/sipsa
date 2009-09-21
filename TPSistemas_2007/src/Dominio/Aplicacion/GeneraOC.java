package Dominio.Aplicacion;

import java.lang.reflect.Constructor;
import java.util.*;

public class GeneraOC {
    Vector  vArticulos, vProductos;
    
    public GeneraOC() {
        vProductos = new Vector();
        vArticulos = new Vector();
    }
    
    public Vector armarVArtiProdu(Vector artiProd){
        int id, tipoIt, j, posicion = 0;
        float canti;
        boolean esta;
        for (int i = 0; i < artiProd.size(); i = i+3){
            esta = false;
            tipoIt = (Integer)artiProd.elementAt(i);
            id = (Integer)artiProd.elementAt(i+1);
            canti = (Float)artiProd.elementAt(i+2);
            if (tipoIt == 0){
               j = 0;
                while ((!esta) && (j < vArticulos.size())){
                    int idA = (Integer)vArticulos.elementAt(j);
                    if (id == idA){
                        esta = true;
                        posicion = j;
                    }
                    j = j+2;
                }
                if (esta){
                    canti = canti + (Float)vArticulos.elementAt(posicion+1);
                    vArticulos.set(posicion+1,canti);
                }else{
                    vArticulos.add(id);
                    vArticulos.add(canti);
                }
            }else{
                if (tipoIt == 1){
                    j = 0;
                while ((!esta) && (j < vProductos.size())){
                    int idP = (Integer)vProductos.elementAt(j);
                    if (id == idP){
                        esta = true;
                        posicion = j;
                    }
                    j = j+2;
                }
                if (esta){
                    canti = canti + (Float)vProductos.elementAt(posicion+1);
                    vProductos.set(posicion+1,canti);
                }else{
                    vProductos.add(id);
                    vProductos.add(canti);
                }
                }
            }
        }
     
     return vProductos;
    }
   
   public Vector getArtiTotal(Vector arti){
       
       int j, id, tipoIt, posicion = 0;
        float canti;
        boolean esta;
        for (int i = 0; i < arti.size(); i = i+2){
            esta = false;
            id = (Integer)arti.elementAt(i);
            canti = (Float)arti.elementAt(i+1);
                j = 0;
                while ((!esta) && (j < vArticulos.size())){
                    int idA = (Integer)vArticulos.elementAt(j);
                    if (id == idA){
                        esta = true;
                        posicion = j;
                    }
                    j = j+2;
                }
                if (esta){
                    canti = canti + (Float)vArticulos.elementAt(posicion+1);
                    vArticulos.set(posicion+1,canti);
                }else{
                    vArticulos.add(id);
                    vArticulos.add(canti);
                }
        }
      return vArticulos; 
   } 
   
   public void armarSalida(Vector pXArti){
       
      while (pXArti.size()>0){
           Vector v1 = new Vector();
           Proveedores prov = new Proveedores();
           prov = (Proveedores)pXArti.elementAt(0);
           int cProveedor = (Integer)(prov).getNumero();
           
          String fPedido = (String)pXArti.elementAt(3);
          
           int i=0;
           
           while (i<pXArti.size()){
               if (cProveedor == (Integer)((Proveedores)pXArti.elementAt(i)).getNumero()){
                   String artic = (String)pXArti.elementAt(i+1);
                   float can = (Float)pXArti.elementAt(i+2);

                   v1.add(artic);
                   v1.add(can);
                   for (int j=i; j<(i+4); j++){
                       pXArti.removeElementAt(i);
                   }
               }else{
                   i=i+4;
               }
           }

           FactoryArchi far = new FactoryArchi();
           Archivos archivos = (Archivos) far.getArchivo("Dominio.Aplicacion."+fPedido);
           archivos.armarArchi(v1,prov);
           
       }

   }
   
   public void armarSalidaMail(Vector v){
       Mail mail = new Mail();                
        mail.enviarMail(v);

   }
}
