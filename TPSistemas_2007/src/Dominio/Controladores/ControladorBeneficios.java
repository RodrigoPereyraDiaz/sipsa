
package Dominio.Controladores;
import BaseDatos.IntermediarioPresupuestos;
import java.util.Vector;

public class ControladorBeneficios {
    

    public ControladorBeneficios() {
    }

    
    
    
    public Vector consultar(String fdesde, String fhasta, int filtro) throws Exception {
        IntermediarioPresupuestos InterPro= new IntermediarioPresupuestos();
        return InterPro.obtenerBeneficios(fdesde,fhasta,filtro);
    }
  
     
}
