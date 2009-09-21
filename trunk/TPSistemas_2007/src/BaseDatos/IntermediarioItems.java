package BaseDatos;
import Dominio.Aplicacion.*;
import java.io.*;
import java.sql.*;
import java.util.*;    
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.JTable;

public abstract class IntermediarioItems extends Intermediarios  {

    public IntermediarioItems() {       }
    
    public abstract Items getItem(int IdItem);

    public abstract Vector getLista();  
    
   public abstract void modificarItem(Items it)throws SQLException;
    
    public abstract void insertarItem(Items it)throws SQLException;
    
    public abstract void eliminarItem(int nro)throws SQLException;
    
    
    

    public Vector consultaItems(Items it, int cArt, int cPre, int tipoItem){
        Vector vector = null;
        IntermediarioArticulos iAr = new IntermediarioArticulos();
        IntermediarioProveedores InterPro= new IntermediarioProveedores();
      try {  
        Sql SQL=Sql.getIntancia();
        Connection con= SQL.conectar();
        vector = new Vector();
        Statement statement;
        ResultSet resultSet = null;
        statement = con.createStatement();
        String vacio = "";
        String idItem = "",aa = "",bb = "",cc = "";
        Boolean aa1 = false, bb1 = false, cc1 = false;
        String base = null;
        if (tipoItem == 0){
            base = "Select * from Articulos ";
            idItem = "IdArticulo";
        }else{
            if (tipoItem == 2){
                base = "Select * from Servicios ";
                idItem = "IdServicio";
            }else{
                base = "Select * from Productos ";
                idItem = "IdProducto";
            }
            
        }
        if ((it.getId() != 0) || (!it.getDescripcion().equals(vacio)) || (it.getCosto() != 0)){
            if (it.getId() != 0){
                aa1 = true;
                    switch(cArt){
                        case 1: aa = idItem + " = " + it.getId();
                        break;
                        case 2: aa = idItem + " > " + it.getId();
                        break;
                        case 3: aa = idItem + " < " + it.getId();
                        break;
                       }
                }
            if (! it.getDescripcion().equals(vacio)){
                bb1 = true;
                bb = " Descripcion like '%"+ it.getDescripcion() +"%'";
                }
            if (it.getCosto() != 0){
                cc1 = true;
                    switch(cPre){
                        case 1:  cc = " Costo = " + it.getCosto();
                        break;
                        case 2:  cc = " Costo > " + it.getCosto();
                        break;
                        case 3:  cc = " Costo < " + it.getCosto();
                        break;
                       }
                }
        base = base + " where ";
        if (aa1){
            if(bb1){
                if(cc1){
                    base=base+aa+" and "+bb+" and "+cc;
                }else{
                    base=base+aa+" and "+bb;
                }
            }else{
                if(cc1){
                    base=base+aa+" and "+cc;
                }else{
                    base=base+aa;
                }
            }
        }else{
            if(bb1){
                if(cc1){
                    base=base+bb+" and "+cc;
                }else{
                    base=base+bb;
                }
            }else{
                    base=base+cc;
            }
        }
      }
        resultSet = statement.executeQuery(base);
        if (tipoItem == 0){
             while (resultSet.next()) {
                 Articulos arti = new Articulos();
                 int idArtic = resultSet.getInt("IdArticulo");
                 arti.setId(idArtic);
                 arti.setDescripcion(resultSet.getString("Descripcion"));
                 arti.setPrecio(resultSet.getFloat("Precio"));
                 arti.setCosto(resultSet.getFloat("Costo"));
                 
                 int idProvee = iAr.buscarProveedor(idArtic);
                 Proveedores p = InterPro.getProveedor(idProvee);
                 arti.setProveedor(p);
                 vector.addElement(arti);
             }
        }else{
            if (tipoItem == 2){
                while (resultSet.next()) {
                    Servicios serv = new Servicios();
                    serv.setId(resultSet.getInt("IdServicio"));
                    serv.setDescripcion(resultSet.getString("Descripcion"));
                    serv.setPrecio(resultSet.getFloat("Precio"));
                    serv.setCosto(resultSet.getFloat("Costo"));
                 
                    vector.addElement(serv);
             }
            }else{
                while (resultSet.next()) {
                    Productos pro = new Productos();
                    pro.setId(resultSet.getInt("IdProducto"));
                    pro.setDescripcion(resultSet.getString("Descripcion"));
                    pro.setPrecio(resultSet.getFloat("Precio"));
                    pro.setCosto(resultSet.getFloat("Costo"));
                 
                    vector.addElement(pro);
                }
                
            }
                
        }
      } catch (SQLException e) {
            e.printStackTrace();
        }
        return vector;
    }

}  

    