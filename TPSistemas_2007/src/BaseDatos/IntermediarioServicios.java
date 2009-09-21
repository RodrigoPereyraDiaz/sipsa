
package BaseDatos;

import java.sql.Statement;
import java.util.*;
import java.sql.*;
import java.util.Vector;
import Dominio.Aplicacion.Servicios;
import Dominio.Aplicacion.Items;


public class IntermediarioServicios extends IntermediarioItems{
    

    public IntermediarioServicios() {
    }
    
    public void insertarItem(Items it) throws SQLException{
     
        Statement sta = super.conectarBase();
        String sentencia = "INSERT INTO Servicios(Descripcion, Precio, Costo) values('"+it.getDescripcion()+"', "+it.getPrecio()+", "+it.getCosto()+")";
        sta.execute(sentencia);  
   
    }
    
    public void modificarItem(Items it)throws SQLException{
      
        Statement sta = super.conectarBase();
        String sentencia = "UPDATE Servicios SET Descripcion = '"+it.getDescripcion()+"', Costo = "+it.getCosto()+", Precio = "+it.getPrecio()+" where IdServicio = "+it.getId();
        sta.execute(sentencia);   
    
    }
    
    public void eliminarItem(int nro)throws SQLException {
       
        Statement sta = super.conectarBase();
        String sentencia = "DELETE Servicios where IdServicio = "+nro;
        sta.execute(sentencia);    
     
    }
    
     public Vector getLista() {
                  
                Vector Lista=null;
              try {  
                Sql SQL=Sql.getIntancia();
                Connection con= SQL.conectar();
                Lista=new Vector();
                CallableStatement callableStatement;
                ResultSet resultSet;
                
                callableStatement = con.prepareCall("getServicios"); 
                resultSet = callableStatement.executeQuery(); 
                while (resultSet.next()) {
                      Servicios serv=new Servicios();
                      serv.setId(resultSet.getInt("IdServicio"));
                      serv.setDescripcion(resultSet.getString("Descripcion"));
                      serv.setPrecio(resultSet.getFloat("Precio"));
                      serv.setCosto(resultSet.getFloat("Costo"));
                      Lista.addElement(serv);
                }   
                         

              }catch (SQLException e) {
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
                callableStatement.setInt(2,2);
                ResultSet resultSet = callableStatement.executeQuery(); 
                resultSet.next();
                            
                it= new Servicios();
                it.setId(resultSet.getInt("IdServicio"));
                it.setDescripcion(resultSet.getString("Descripcion"));
                it.setPrecio(resultSet.getFloat("Precio"));    
                it.setCosto(resultSet.getFloat("Costo"));                              
                    
                } catch (SQLException e) {
                    e.printStackTrace();
                }                   
                return it;    
            }
            
            
}
