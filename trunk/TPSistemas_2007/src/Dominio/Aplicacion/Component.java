package Dominio.Aplicacion;
import java.util.*;

public abstract class Component extends Items{
    float cantidad;

    public Component() {
    }
    public void setCantidad(float canti){
        cantidad = canti;
    }
    
    public float getCantidad(){
        return cantidad;
    }
    public abstract void operacion();    
    public abstract void add(Component C);   
    public abstract void remove(Component C);
    public abstract Enumeration getChild(int id);
    public abstract float getCostoTotal();    
    public abstract float getPrecioTotal();
    
}
