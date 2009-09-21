package BaseDatos;

import java.sql.*;
import java.util.*;
import Dominio.Aplicacion.*;

public class IntermediarioProductos extends IntermediarioItems{
    
    public IntermediarioProductos() {
    }
    
    public void insertarItem(Items it) throws SQLException{
      
        Statement sta = super.conectarBase();
        String sentencia = "INSERT INTO Productos(Descripcion, Precio, Costo) values('"+it.getDescripcion()+"',"+it.getPrecio()+","+it.getCosto()+")";
        sta.execute(sentencia);    
        
    }
    
    public void modificarItem(Items it)throws SQLException{
      
        Statement sta = super.conectarBase();
        String sentencia = "UPDATE Productos SET Descripcion = '"+it.getDescripcion()+"', Costo = "+it.getCosto()+", Precio = "+it.getPrecio()+" where IdProducto = "+it.getId();
        sta.execute(sentencia);    
      
    }
    
    public void eliminarItem(int nro)throws SQLException {
      
        Statement sta = super.conectarBase();
        String sentencia1 = "DELETE ArticulosXProducto where IdProducto = "+nro;
        sta.execute(sentencia1);   
        String sentencia2 = "DELETE Productos where IdProducto = "+nro;
        sta.execute(sentencia2);    
       
    }
    
    
    public Vector getLista() {

        Vector Lista=null;
      try{  
        Sql SQL=Sql.getIntancia();
        Connection con= SQL.conectar();
        Lista=new Vector();
        CallableStatement callableStatement;
        ResultSet resultSet;

                  callableStatement = con.prepareCall("getProductos"); 
                  resultSet = callableStatement.executeQuery(); 
                  while (resultSet.next()) {
                    Productos prod=new Productos();
                    prod.setId(resultSet.getInt("IdProducto"));
                    prod.setDescripcion(resultSet.getString("Descripcion"));
                    prod.setPrecio(resultSet.getFloat("Precio"));
                    prod.setCosto(resultSet.getFloat("Costo"));
                    Lista.addElement(prod);
                  }   
      } catch (SQLException e) {
            e.printStackTrace();
        }

        return Lista;
    }
    
    public Items getItem(int IdItem){
        Vector Lista=null;
        Sql SQL=Sql.getIntancia();
        Connection con= SQL.conectar();
        String tabla;
        Items it=null;
     try{ 
        CallableStatement callableStatement = con.prepareCall("{call getItems(?,?)}"); 
        callableStatement.setInt(1,IdItem);
        callableStatement.setInt(2,1);
        ResultSet resultSet = callableStatement.executeQuery(); 
        resultSet.next();

        it= new Productos();
        it.setId(resultSet.getInt("IdProducto"));
        it.setDescripcion(resultSet.getString("Descripcion"));
        it.setPrecio(resultSet.getFloat("Precio"));
        it.setCosto(resultSet.getFloat("Costo"));


        } catch (SQLException e) {
            e.printStackTrace();
        }                   
        return it;    
    }
    
    public int buscarId(){
        
        int id =0;
        try{
            Sql SQL=Sql.getIntancia();
        Connection con= SQL.conectar();
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        String sentencia = "SELECT MAX(IdProducto) FROM Productos";
        preparedStatement = con.prepareStatement(sentencia);
        resultSet=preparedStatement.executeQuery();
        resultSet.next();
        id = resultSet.getInt("IdProducto");
  
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return id;
    }
    
    public void insertarArtiXProdu(int idPro, Vector v){
        
        try{
        Statement sta = super.conectarBase();
        String sentencia = "DELETE ArticulosXProducto where IdProducto = "+idPro;
        sta.execute(sentencia);
        for (int i =0;i<v.size();i=i+2){
            int idAr = (Integer)v.elementAt(i);
            float canti = (Float)v.elementAt(i+1);
            String sentencia1 = "INSERT INTO ArticulosXProducto(IdProducto, IdArticulo, Cantidad) values("+idPro+","+idAr+","+canti+")";
            sta.execute(sentencia1);
        }
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        
    }
    
       
    public Vector traerArticulos(int idProdu){
        
        int idArti;
        String descri;
        float canti;
        Vector v = new Vector();
        try {  
        Sql SQL=Sql.getIntancia();
        Connection con= SQL.conectar();
        CallableStatement callableStatement;
        ResultSet resultSet = null;

            callableStatement = con.prepareCall("{call getArtiXProdu(?)}");
            callableStatement.setInt(1,idProdu);  
            resultSet = callableStatement.executeQuery(); 
            while (resultSet.next()){
                idArti = resultSet.getInt("IdArticulo");
                descri = resultSet.getString("Descripcion");
                canti = resultSet.getFloat("Cantidad");
                v.add(idArti);
                v.add(descri);
                v.add(canti);
        }   
         
        
      } catch (SQLException e) {
            e.printStackTrace();
      }
    return v;    
    
    }

}
