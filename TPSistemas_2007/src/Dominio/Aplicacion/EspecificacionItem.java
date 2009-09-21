package Dominio.Aplicacion;
import java.util.ArrayList;

public class EspecificacionItem extends Items {
    private int cantidad;
    private int tipo;
    private float subtotal;
    private Items mItem;
    private float subcosto;
    
      
    
    public EspecificacionItem() {
    }
    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int val) {
        this.cantidad = val;
    }
    public int getTipo() {
        return tipo;
    }
   public void setTipo(int val) {
        this.tipo = val;
    }
    public float getSubtotal() {
        return subtotal;
    }
    public void setSubtotal(float val) {
        this.subtotal = val;
    }
    public Items getItem() {
        return mItem;
    }
    public void setItem(Items val) {
        this.mItem = val;
    }
     public float getSubCosto() {
        return subcosto;
    }
    public void setSubCosto(float val) {
        this.subcosto = val;
    }
}
