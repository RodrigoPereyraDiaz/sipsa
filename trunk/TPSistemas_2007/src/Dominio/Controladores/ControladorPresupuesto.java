package Dominio.Controladores;
import BaseDatos.*;
import Dominio.Aplicacion.Clientes;
import Dominio.Aplicacion.EspecificacionItem;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

public class ControladorPresupuesto {
    IntermediarioPresupuestos InterPresu= new IntermediarioPresupuestos();
    

    public ControladorPresupuesto() {
        InterPresu.crearPresupuesto(this.getFecha());
    }

    
    
    public Clientes getCliente(int id){
        IntermediarioClientes InterClientes= new IntermediarioClientes();
        Clientes cli=InterClientes.getCliente(id);        
        InterPresu.asignarCliente(cli);
        return cli;     
    }
    
   public void addItemPresupuesto(int IdItem, int Cant, int Tipo)throws NumberFormatException{
       InterPresu.addItemPresupuesto(IdItem,Cant,Tipo);
        
    }
   
   public EspecificacionItem getItemPresupuesto(int id){
       return InterPresu.getItemPresupuesto(id);
        
    }
   
    public void eliminarItem(int id){
        InterPresu.eliminarItem(id);
    }
    
    
    
    public String getFecha(){    
        Date fechaActual= new Date();
        SimpleDateFormat formato= new SimpleDateFormat("dd/MM/yyyy hh:mm"); 
        return formato.format(fechaActual);
    }
    public int getNro(){
        return InterPresu.getNumPresu();
    }  

    public void finalizarPresupuesto() throws NullPointerException{
        InterPresu.finalizarPresupuesto();
    }
}
