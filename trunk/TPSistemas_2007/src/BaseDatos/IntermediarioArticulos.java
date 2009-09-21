package BaseDatos;
import java.sql.*;
import java.util.*;
import Dominio.Aplicacion.*;

public class IntermediarioArticulos extends IntermediarioItems{
    
    public IntermediarioArticulos() {    }
    
    public void insertarItem(Items it)throws SQLException{
       
        Statement sta = super.conectarBase();
        String sentencia = "INSERT INTO Articulos(Descripcion, Precio, Costo) values('"+it.getDescripcion()+"', "+it.getPrecio()+", "+it.getCosto()+")";
        sta.execute(sentencia);    
        
    }
    
    public void modificarItem(Items it)throws SQLException {
        
        Statement sta = super.conectarBase();
        String sentencia = "UPDATE Articulos SET Descripcion = '"+it.getDescripcion()+"', Costo = "+it.getCosto()+", Precio = "+it.getPrecio()+" where IdArticulo = "+it.getId();
        sta.execute(sentencia); 
       
    }
    
    public void eliminarItem(int nro)throws SQLException{
      
        Statement sta = super.conectarBase();
        String sentencia = "DELETE ArticuloXProveedor where IdArticulo = "+nro;
        sta.execute(sentencia);  
        sentencia = "DELETE Articulos where IdArticulo = "+nro;
        sta.execute(sentencia);  
    }
    
    public Items getItem(int IdItem){

        Sql SQL=Sql.getIntancia();
        Connection con= SQL.conectar();
        String tabla;
        Items it=null;
     try{ 
        CallableStatement callableStatement = con.prepareCall("{call getItems(?,?)}"); 
        callableStatement.setInt(1,IdItem);
        callableStatement.setInt(2,0);
        ResultSet resultSet = callableStatement.executeQuery(); 
        resultSet.next();
        it = new Articulos();
        it.setId(resultSet.getInt("IdArticulo"));
        it.setDescripcion(resultSet.getString("Descripcion"));
        it.setPrecio(resultSet.getFloat("Precio"));
        it.setCosto(resultSet.getFloat("Costo"));
        } catch (SQLException e) {   e.printStackTrace();   }                   
        return it;    
    }
            
    public Vector getLista() {
        Vector Lista=null;
      try {  
        Sql SQL=Sql.getIntancia();
        Connection con= SQL.conectar();
        Lista=new Vector();
        CallableStatement callableStatement;
        ResultSet resultSet;
      callableStatement = con.prepareCall("getArticulos"); 
      resultSet = callableStatement.executeQuery(); 
      while (resultSet.next()) {
        Articulos art=new Articulos();
        art.setId(resultSet.getInt("IdArticulo"));
        art.setDescripcion(resultSet.getString("Descripcion"));
        art.setPrecio(resultSet.getFloat("Precio"));
        art.setCosto(resultSet.getFloat("Costo"));
        Lista.addElement(art);      }
      } catch (SQLException e) {  e.printStackTrace();  }
        return Lista;
    }
    
    
    public Vector artiXProdu(Vector artiProd){
        int idArti;
        float canti;
        Vector v = new Vector();
        try {  
        Sql SQL=Sql.getIntancia();
        Connection con= SQL.conectar();
        CallableStatement callableStatement;
        ResultSet resultSet = null;
        for(int i=0; i<artiProd.size();i=i+3){
         if ((Integer)artiProd.elementAt(i)==1){
            callableStatement = con.prepareCall("{call getArtiXProdu(?)}");
            callableStatement.setInt(1,(Integer)artiProd.elementAt(i+1));  
            resultSet = callableStatement.executeQuery(); 
            while (resultSet.next()){
                idArti = resultSet.getInt("IdArticulo");
                canti = resultSet.getFloat("Cantidad");
                v.add(idArti);
                v.add(canti);
        }   
         }
        }
      } catch (SQLException e) {
            e.printStackTrace();
      }
    return v;    
    }
    
    public Vector getVectorArticulos() {
        Vector Lista= new Vector();
        Sql SQL = Sql.getIntancia();
        Connection con = SQL.conectar();
        try {
             String sentencia = "Select IdArticulo, Descripcion, Costo, Precio from Articulos";
             PreparedStatement statement = con.prepareStatement(sentencia); 
             ResultSet resultSet = statement.executeQuery(); 
             
             while (resultSet.next()) {
                 Articulos a = new Articulos();
                 a.setId(resultSet.getInt("IdArticulo"));
                 a.setDescripcion(resultSet.getString("Descripcion"));
                 a.setCosto(resultSet.getFloat("Costo"));
                 a.setPrecio(resultSet.getFloat("Precio"));
                 Lista.addElement(a);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
       return Lista;
    }
    
    public Vector calcularCPProdu(Vector v){
        
        Vector vector = new Vector();
        float costo =0, precio=0, canti;
        for (int i=0;i<v.size();i=i+2){
            Articulos arti = new Articulos();
            arti = (Articulos)this.getItem((Integer)v.elementAt(i));
            canti = (Float)v.elementAt(i+1);
            costo = costo + arti.getCosto() * canti;
            precio = precio + arti.getPrecio() * canti;
        }
        vector.add(costo);
        vector.add(precio);
        
        return vector;
        
    }
    
    public int buscarIdArti(){
        int id =0;
        try{
            Sql SQL=Sql.getIntancia();
        Connection con= SQL.conectar();
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        String sentencia = "SELECT MAX(IdArticulo) FROM Articulos";
        preparedStatement = con.prepareStatement(sentencia);
        resultSet=preparedStatement.executeQuery();
        resultSet.next();
        id = resultSet.getInt("IdArticulo");
  
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return id;
    }
    
    public int buscarProveedor(int idArt){
        int id =0;
        try{
            Sql SQL=Sql.getIntancia();
        Connection con= SQL.conectar();
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        String sentencia = "SELECT IdProveedor FROM ArticuloXProveedor where IdArticulo = "+idArt;
        preparedStatement = con.prepareStatement(sentencia);
        resultSet=preparedStatement.executeQuery();
        resultSet.next();
        id = resultSet.getInt("IdProveedor");
  
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return id;
    }
       
}
