package Dominio.Aplicacion;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.*;

public class ArchivoDoc extends Archivos{
    
    public ArchivoDoc(){
    }
    
    public void armarArchi(Vector arti, Proveedores proveedor) {
        
        
        String sFichero = "C:\\" + proveedor.getCodigo() + output + ".doc";
	File fichero = new File(sFichero);
	if (fichero.exists())
  	System.out.println("El fichero " + sFichero + " ya existe");
	else {
		try{
		  BufferedWriter bw = new BufferedWriter(new FileWriter(sFichero));
                  bw.write("Orden de Compra. Fecha: " +output1+ "\n");
	   	  bw.write("Proveedor: " +proveedor.getRazonSocial()+ "\n");
                  bw.write("Forma de Pago: CONTADO\n\n");
                  bw.write("Artículo          Cantidad\n");
                  bw.write("--------          --------\n");
		  for (int k = 0; k < arti.size(); k = k+2){
                      String art = (String)arti.elementAt(k);
                      int l = 18-art.length();
                      for (int i=0;i<l;i++){
                          art = art + " ";
                      }
                      bw.write(art);
                      bw.write(arti.elementAt(k+1)+"\n");
                  }
		  bw.close();
		} catch (IOException ioe){ioe.printStackTrace();}
	}
 
 
    }
}
    
    

