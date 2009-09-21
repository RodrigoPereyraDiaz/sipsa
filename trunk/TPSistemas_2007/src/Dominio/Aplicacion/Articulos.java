package Dominio.Aplicacion;
import java.util.*;
public class Articulos extends Component {
       
    Proveedores p;
    
    public Articulos() {
    }

    public void operacion(){
        
    } 
     public void add(Component C){
     }   
    public void remove(Component C){        
    }
    public Enumeration getChild(int id){  
        return null;
    }
   
    public float getCostoTotal(){
        return this.getCosto();
    }
   
    public float getPrecioTotal(){
        return this.getPrecio();
    }
    
    public void setProveedor(Proveedores pro){
        p = pro;
    }
    
    public Proveedores getProveedor(){
        return p;
    }
}

