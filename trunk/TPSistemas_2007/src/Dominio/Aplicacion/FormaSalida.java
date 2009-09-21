package Dominio.Aplicacion;
import java.util.Vector;

public class FormaSalida {
    
    public FormaSalida() {
    }
     public void salida(String formaP, Vector arti, String codigo){
         
           FactoryArchi far = new FactoryArchi();
           Archivos archivos = (Archivos) far.getArchivo(formaP);
           
         /*
        switch (formaP){
            case 1: 
                ar = new ArchivoDoc(arti, codigo);
                break;
                case 2: 
                ar = new ArchivoExcel(arti, codigo);
                break;
                default: 
                ar = new ArchivoHtm(arti, codigo);
                break;
        }*/
    }
}
