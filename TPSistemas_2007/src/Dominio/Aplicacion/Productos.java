package Dominio.Aplicacion;

import java.util.*;

public class Productos extends Component {
    
    
    private Vector arbol;
    
    public Productos() {
        this.arbol=new Vector();
    }

  
    public void operacion(){
        
    }    
    public void add(Component C){
        this.arbol.addElement(C);
    }   
    public void remove(Component c){
         this.arbol.removeElement(c);        
    }
    public Enumeration getChild(int id){
        return arbol.elements();
    }
     public float getCostoTotal(){
        float total = this.getCosto();
        for (int i=0;i<arbol.size();i++){
            float canti = ((Component)arbol.elementAt(i)).getCantidad();
            float cos = ((Component)arbol.elementAt(i)).getCosto();
            total+=canti*cos;
        }
        return total;
    }
   
    public float getPrecioTotal(){
        float total = this.getPrecio();
        for (int i=0;i<arbol.size();i++){
            float canti = ((Component)arbol.elementAt(i)).getCantidad();
            float pre = ((Component)arbol.elementAt(i)).getPrecio();
            total+=canti*pre;
        }
        return total;
    }


}

