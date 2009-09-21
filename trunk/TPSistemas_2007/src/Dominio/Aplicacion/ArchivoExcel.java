package Dominio.Aplicacion;
import Dominio.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.*;


/**
* <p>
* Genera un archivo Excel con los datos de los artículos solicitados.
* </p>
*/

public class ArchivoExcel extends Archivos {
    
    public ArchivoExcel(){

    }
    

    public void armarArchi(Vector arti, Proveedores proveedor) {

        String sFichero = "C:\\" + proveedor.getCodigo() + output + ".xls";
	File fichero = new File(sFichero);
	if (fichero.exists())
  	System.out.println("El fichero " + sFichero + " ya existe");
	else {
		try{
		  BufferedWriter bw = new BufferedWriter(new FileWriter(sFichero));
                  bw.write("Orden de Compra. Fecha: " +output1+ "\n\n");
	   	  bw.write("Proveedor: " +proveedor.getRazonSocial()+ "\n\n");
                  bw.write("Forma de Pago: CONTADO\n\n");
                  bw.write("\tARTICULO\tCANTIDAD\n");
		  for (int k = 0; k < arti.size(); k = k+2){
                      bw.write("\t"+arti.elementAt(k)+"\t");
                      bw.write(arti.elementAt(k+1)+"\n");
                  }
		  bw.close();
		} catch (IOException ioe){ioe.printStackTrace();}
	}
    }
 
    
}
