package Dominio.Aplicacion;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;


public class Archivos {
    Date today;
    String output, pattern = "_ddMM_hh_mm_ss";
    String output1, pattern1 = "dd/MM/yyyy";
    SimpleDateFormat formatter, formatter1;
    
    
    public Archivos() {

        today = new Date();
        formatter1 = new SimpleDateFormat(pattern1);
        output1 = formatter1.format(today);
        formatter = new SimpleDateFormat(pattern);
        output = formatter.format(today);

    }
    
    public void armarArchi(Vector arti, Proveedores proveedor){    
    }
    


}
