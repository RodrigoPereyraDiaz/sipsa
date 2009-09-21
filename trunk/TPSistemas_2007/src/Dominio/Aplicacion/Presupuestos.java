package Dominio.Aplicacion;

import java.util.*;

public class Presupuestos {
    
    private int numero;
    private String fecha;
    private float total=0;
    private float costo=0;
    private int aprobado=0;
    private int rechazado=0, enviado =0;
    private Clientes mCliente;
    private Vector ListEspe=new Vector();
   
    

    public Presupuestos() {
    }

            
    public int getNumero() {
        return numero;
    }

    public void setNumero(int val) {
        this.numero = val;
    }
    

   public String getFecha() {
        return fecha;
    }

    public void setFecha(String val) {
        this.fecha = val;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float val) {
        this.total = val;
    }

    public Clientes getCliente() {
        return mCliente;
    }

    public void setCliente(Clientes val) {
        this.mCliente = val;
    }
    
    public void setAprobado(int val) {
        this.aprobado = val;
    }
    
    public int getAprobado() {
        return aprobado;
    }
    
     public void setRechazado(int val) {
        this.rechazado = val;
    }
    
    public int getRechazado() {
        return rechazado;
    }
    
    public void setEnviado(int val) {
        this.enviado = val;
    }
    
    public int getEnviado() {
        return enviado;
    }
    public void setCosto(float val) {
        this.costo = val;
    }
    
    public float getCosto() {
        return costo;
    }
    
    public void setListEspeItem(){
        ListEspe=new Vector();
    }

     public Vector getEspecificacionItem() {
        return ListEspe;
    }

    public void setEspecificacionItem(Items it, int cantidad, int tipo) throws NumberFormatException{
       
        EspecificacionItem EspeIte= new EspecificacionItem();
        EspeIte.setTipo(tipo);
        EspeIte.setCantidad(cantidad);
        EspeIte.setItem(it);
        EspeIte.setSubCosto(cantidad*(EspeIte.getItem().getCosto()));
        EspeIte.setSubtotal(cantidad*(EspeIte.getItem().getPrecio()));
        ListEspe.addElement(EspeIte);
        
    }

    
    
    public void deleteItem(int id){
        costo=costo-(((EspecificacionItem)ListEspe.elementAt(id)).getItem().getCosto());
        total= total-((EspecificacionItem)ListEspe.elementAt(id)).getSubtotal();
        ListEspe.remove(id);  
        
    }

     public boolean tieneProductos(){
         boolean a=false;
         for(int i=0;i<ListEspe.size();i++){
               EspecificacionItem ItemPresu= (EspecificacionItem)ListEspe.elementAt(i);           
               if (ItemPresu.getTipo()==1){
                   a=true;                  
                   break;
               }
         }
         return(a);
     }    
    
    
    public Vector getEspecificacionItemProd(int NroPresu) {
        Vector Productos=new Vector();
        for (int i=0;i<ListEspe.size();i++){
            EspecificacionItem ItemPresu= (EspecificacionItem)ListEspe.elementAt(i);           
            if (ItemPresu.getTipo()==1)
                Productos.addElement(ListEspe.elementAt(i));       
        }
        return Productos;
    }
}