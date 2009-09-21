package Dominio.Aplicacion;
import Dominio.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.*;


/**
* <p>
* Genera un archivo Html con los datos de los artículos solicitados.
* </p>
*/

public class ArchivoHtm extends Archivos {
    
     public ArchivoHtm(){
    }

    public void armarArchi(Vector arti, Proveedores proveedor) {

        String sFichero = "C:\\" + proveedor.getCodigo() + output + ".htm";
	File fichero = new File(sFichero);
	if (fichero.exists())
  	System.out.println("El fichero " + sFichero + " ya existe");
	else {
		try{
		  BufferedWriter bw = new BufferedWriter(new FileWriter(sFichero));
                  bw.write("<p><b>Orden de Compra.</b>      Fecha: " +output1+ "</p>\n\n");
                  bw.write("<p><b>Proveedor:</b> " +proveedor.getRazonSocial()+ "        <b>CUIT:</b> "+proveedor.getCuit_dni()+"</p>\n");
                  bw.write("<p><b>Dirección:</b> " +proveedor.getDomicilio());
                  bw.write("<b>       Teléfono:</b> " +proveedor.getTelefono()+ "</p>\n");
                  bw.write("<p><b>Foma de Pago: </b> Contado</p>\n\n");
                  bw.write("<CENTER>");
                  bw.write("<TABLE BORDER = 1>");
                  bw.write("<TR>");
                  bw.write("<TH>Artículo </TH> <TH>Cantidad\n</TH>");
                  
		  for (int k = 0; k < arti.size(); k = k+2){
                       bw.write("<TR>");
                      bw.write("<TD>"+arti.elementAt(k)+"</TD>");
                      bw.write("<TD>"+arti.elementAt(k+1)+"</TD>");
                  }
                  
                  bw.write("</TABLE>");
                  bw.write("</CENTER>");
		  bw.close();
		} catch (IOException ioe){ioe.printStackTrace();}
	}
    }
    
}
