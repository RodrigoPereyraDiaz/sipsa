    package BaseDatos;
    import java.io.*;
    import java.sql.*;
    import java.util.*;
    import Dominio.Aplicacion.Clientes;
    import javax.swing.*;
    import javax.swing.table.*;
    import javax.swing.JTable;

        public class IntermediarioClientes extends Intermediarios{

            public IntermediarioClientes(){
                
            }
           

            public Clientes getCliente(int idCli){
                Sql SQL= Sql.getIntancia();
                Connection con= SQL.conectar();
                Clientes cli=null;
                try{                    
                    CallableStatement callableStatement = con.prepareCall("{call getCliente(?)}"); 
                    callableStatement.setInt(1,idCli);
                    ResultSet resultSet = callableStatement.executeQuery(); 
                    cli=new Clientes();
                    resultSet.next();
                    cli.setNumero(resultSet.getInt("IdCliente"));
                    cli.setApellido(resultSet.getString("Apellido"));
                    cli.setNombre(resultSet.getString("Nombre"));
                    cli.setCuit_dni(resultSet.getString("DNI/CUIT"));
                    cli.setMail(resultSet.getString("Mail"));
                    cli.setDomicilio(resultSet.getString("Domicilio"));
                    cli.setTelefono(resultSet.getString("Telefono"));
                    cli.setIva(resultSet.getString("IVA"));
                    cli.setContraseña(resultSet.getString("Contraseña"));
                    cli.setLocalidad(resultSet.getString("Localidad"));
                    cli.setProvincia(resultSet.getString("Provincia"));
                    cli.setFechaAlta(resultSet.getString("FechaAlta"));
                    
                } catch (SQLException e) {
                    e.printStackTrace();
                }                   
                return cli;    
            }
            
            public Vector getLista() {
                Vector Lista = null;
                Sql SQL= Sql.getIntancia();
                Connection con= SQL.conectar();
                try {
                     CallableStatement callableStatement = con.prepareCall("getClientes"); 
                     ResultSet resultSet = callableStatement.executeQuery(); 
                     Lista= new Vector();
                     while (resultSet.next()) {
                         Clientes cli = new Clientes();
                         cli.setNumero(resultSet.getInt("IdCliente"));
                         cli.setNombre(resultSet.getString("Apellido"));
                         cli.setApellido(resultSet.getString("Nombre"));
                         cli.setCuit_dni(resultSet.getString("DNI/CUIT"));
                         cli.setMail(resultSet.getString("Mail"));
                         cli.setDomicilio(resultSet.getString("Domicilio"));
                         cli.setTelefono(resultSet.getString("Telefono"));
                         cli.setIva(resultSet.getString("IVA"));
                         cli.setContraseña(resultSet.getString("Contraseña"));
                         cli.setLocalidad(resultSet.getString("Localidad"));
                         cli.setProvincia(resultSet.getString("Provincia"));
                         cli.setFechaAlta(resultSet.getString("FechaAlta"));
                         Lista.addElement(cli);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
               return Lista;
            }

    public int validar(String cuit, String contrase) {
      int nro=0; 
      try{
        Sql SQL=Sql.getIntancia();
        Connection con= SQL.conectar(); 
        CallableStatement callableStatement = con.prepareCall("select dbo.validarUsuario (?,?) as id"); 
        callableStatement.setString(1,cuit);
        callableStatement.setString(2,contrase);
        ResultSet resultSet= callableStatement.executeQuery(); 
        resultSet.next();
        
        nro=resultSet.getInt("id");
      }catch(Exception e){
          e.printStackTrace();
      }  
        return (nro);
    }
    
    public Vector getVectorClientes() {
        Vector Lista = null;
        Sql SQL= Sql.getIntancia();
        Connection con= SQL.conectar();
        try {
             String sentencia = "Select IdCliente, Apellido, Nombre as Nombre from Clientes Order by Apellido";
             PreparedStatement statement = con.prepareStatement(sentencia); 
             ResultSet resultSet = statement.executeQuery(); 
             Lista= new Vector();
             while (resultSet.next()) {
                 int id = resultSet.getInt("IdCliente");
                 String nombre = resultSet.getString("Apellido")+", "+resultSet.getString("Nombre");
                 Lista.addElement(id);
                 Lista.addElement(nombre);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
       return Lista;
    }

    public void guardarCliente(Clientes cliente) {
         Sql SQL= Sql.getIntancia();
         Connection con= SQL.conectar();
        
         try{
             CallableStatement callableStatement = con.prepareCall("{call guardarCliente(?,?,?,?,?,?,?,?,?,?,?,?)}"); 
             callableStatement.setInt(1,cliente.getNumero());
             callableStatement.setString(2,cliente.getApellido());
             callableStatement.setString(3,cliente.getNombre());
             callableStatement.setString(4,cliente.getCuit_dni());
             callableStatement.setString(5,cliente.getDomicilio());
             callableStatement.setString(6,cliente.getTelefono());
             callableStatement.setString(7,cliente.getLocalidad());
             callableStatement.setString(8,cliente.getProvincia());
             callableStatement.setString(9,cliente.getIva());
             callableStatement.setString(10,cliente.getMail());
             callableStatement.setString(11,cliente.getContraseña());
             callableStatement.setString(12,cliente.getFechaAlta());
             
             int i= callableStatement.executeUpdate(); 
         }catch(SQLException e){
             e.getMessage();
         }
         
    }

    public void eliminarCli(int id) throws SQLException{
        Sql SQL= Sql.getIntancia();
        Connection con= SQL.conectar();
        CallableStatement callableStatement = con.prepareCall("{call eliminarCliente(?)}");
        callableStatement.setInt(1,id);
        int i = callableStatement.executeUpdate(); 
    }
    
        }