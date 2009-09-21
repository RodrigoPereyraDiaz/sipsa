/*
 * FormaPedido.java
 *
 * Created on 9 de abril de 2007, 8:30
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package Dominio.Aplicacion;

/**
 *
 * @author Mariano
 */
public class FormaPedido {
    private int Id;
    private String Descripcion;
        
    /** Creates a new instance of FormaPedido */
    public FormaPedido() {
                
    }
    
    public int getId(){
        return(Id);
    }
    
    public void setId(int val){
        this.Id=val;
    }
    
     public String getDescripcion(){
        return(Descripcion);
    }
    
    public void setDescripcion(String val){
        this.Descripcion=val;
    }
    
}
