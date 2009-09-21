package BaseDatos;
import Dominio.Aplicacion.*;
import java.sql.*;
import java.util.*;

public class IntermediarioProveedores extends Intermediarios{

        private Vector LFomPago;   
        
    public IntermediarioProveedores() {
        LFomPago=new Vector();
        Sql SQL=Sql.getIntancia();
        Connection con= SQL.conectar();
        ResultSet resultSet2 = null;
        CallableStatement callableStatement2;
        try{
            callableStatement2 = con.prepareCall("{call getFormaPedido}");
            resultSet2 = callableStatement2.executeQuery(); 
            while (resultSet2.next()){
              FormaPedido fp=new FormaPedido();
              fp.setId(resultSet2.getInt("IdFormaPedido"));
              fp.setDescripcion(resultSet2.getString("Descripcion"));
              LFomPago.addElement(fp);
            }
                  
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public Vector getFormasPedido(){
          return(LFomPago);
    }
    public Vector getLista(){
        Vector v = new Vector();
        try {  
                Sql SQL=Sql.getIntancia();
                Connection con= SQL.conectar();
                CallableStatement callableStatement;
                ResultSet resultSet = null;
                callableStatement = con.prepareCall("{call getProveedores}");
                resultSet = callableStatement.executeQuery();                                
                while (resultSet.next()){
                    Proveedores p = new Proveedores();
                    p.setNumero(resultSet.getInt("IdProveedor"));
                    p.setRazonSocial(resultSet.getString("RazonSocial"));
                    p.setCodigo(resultSet.getString("Codigo"));
                    p.setCuit_dni(resultSet.getString("CuitDni"));
                    p.setMail(resultSet.getString("Mail"));
                    p.setTelefono(resultSet.getString("Telefono"));
                    p.setIva(resultSet.getString("IVA"));
                    p.setDomicilio(resultSet.getString("Domicilio"));
                    int fpid=resultSet.getInt("FormaPedido");
                    p.setFormaPedido((FormaPedido)LFomPago.elementAt(fpid-1));
                    v.add(p);
                }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return v;
    }
    
    public Vector getProvXArticulos(Vector arti){
        Vector v = new Vector();
        int idArti, idPro;
        String descri, fPedido;
        float canti;
        try {  
                Sql SQL=Sql.getIntancia();
                Connection con= SQL.conectar();
                CallableStatement callableStatement;
                ResultSet resultSet = null;
                for (int i = 0; i < arti.size(); i = i+2){
                    idArti = (Integer)arti.elementAt(i);
                    canti = (Float)arti.elementAt(i+1);
                    callableStatement = con.prepareCall("{call getArtiXProvee(?)}");
                    callableStatement.setInt(1,idArti);  
                    resultSet = callableStatement.executeQuery(); 
                    resultSet.next();                
                    idPro = resultSet.getInt("IdProveedor");
                    descri = resultSet.getString("Descripcion");
                    fPedido = resultSet.getString("Nombre");
                    Proveedores prov = new Proveedores();
                    prov = this.getProveedor(idPro);
                    //Se ingresan datos a la tabla
                    v.add(prov);
                    v.add(descri);
                    v.add(canti);
                    v.add(fPedido);
                }
              } catch (SQLException e) {
                    e.printStackTrace();
                }
        return v;
    }

    public Proveedores getProveedor(int id) {
                Sql SQL= Sql.getIntancia();
                Connection con= SQL.conectar();
                Proveedores pro=null;
                try{                    
                    CallableStatement callableStatement = con.prepareCall("{call getProveedor(?)}"); 
                    callableStatement.setInt(1,id);
                    ResultSet resultSet = callableStatement.executeQuery(); 
                    pro=new Proveedores();
                    resultSet.next();
                    pro.setNumero(resultSet.getInt("IdProveedor"));
                    pro.setRazonSocial(resultSet.getString("RazonSocial"));
                    pro.setCodigo(resultSet.getString("Codigo"));
                    pro.setCuit_dni(resultSet.getString("CuitDni"));
                    pro.setMail(resultSet.getString("Mail"));
                    pro.setTelefono(resultSet.getString("Telefono"));
                    pro.setIva(resultSet.getString("IVA"));
                    pro.setDomicilio(resultSet.getString("Domicilio"));
                    int fpid=resultSet.getInt("FormaPedido");
                    pro.setFormaPedido((FormaPedido)LFomPago.elementAt(fpid-1));
                    
                }catch(SQLException e){
                    e.printStackTrace();
                }
                
                return(pro);
    }

    public void guardarProveedor(Proveedores pro) {
       Sql SQL= Sql.getIntancia();
         Connection con= SQL.conectar();
         
         try{
             
             CallableStatement callableStatement = con.prepareCall("{call guardarProveedor(?,?,?,?,?,?,?,?,?)}"); 
             callableStatement.setInt(1,pro.getNumero());
             callableStatement.setString(2,pro.getCodigo());
             callableStatement.setString(3,pro.getRazonSocial());
             callableStatement.setString(4,pro.getCuit_dni());
             callableStatement.setString(5,pro.getIva());
             callableStatement.setString(6,pro.getDomicilio());
             callableStatement.setString(7,pro.getTelefono());
             callableStatement.setString(8,pro.getMail());
             callableStatement.setInt(9,pro.getFormaPedido().getId());
            
             int i= callableStatement.executeUpdate(); 
         }catch(SQLException e){
             e.getMessage();
         }
    }

    public void eliminarPro(Integer id) throws SQLException{
        Sql SQL= Sql.getIntancia();
        Connection con= SQL.conectar();
        CallableStatement callableStatement = con.prepareCall("{call eliminarProveedor(?)}");
        callableStatement.setInt(1,id);
        int i = callableStatement.executeUpdate(); 
    }
    
    public void addProveedorXArtic(int idArtic, int idProvee)throws SQLException{
        
        Statement sta = super.conectarBase();
        String sentencia = "INSERT INTO ArticuloXProveedor(idArticulo, idProveedor) values("+idArtic+","+idProvee+")";
        sta.execute(sentencia);  
    }
    
    public void modifProveedorXArtic(int idArtic, int idProvee)throws SQLException{
        
        Statement sta = super.conectarBase();
        String sentencia = "DELETE ArticuloXProveedor where IdArticulo = "+idArtic;
        sta.execute(sentencia);
        String sentencia1 = "INSERT INTO ArticuloXProveedor(idArticulo, idProveedor) values("+idArtic+","+idProvee+")";
        sta.execute(sentencia1);  
    }
}  