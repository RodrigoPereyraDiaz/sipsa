package BaseDatos;
import java.io.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.JTable;

public class Sql {
    static Sql SqlInstancia=null;
   

    private Sql() {
    }

    public static Sql getIntancia(){
        if(SqlInstancia==null)
            SqlInstancia=new Sql();
            
        return SqlInstancia;
    }
    
    public Connection conectar() {
        Connection connection=null;  
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver").newInstance();
            connection = DriverManager.getConnection("jdbc:odbc:Sis2");
            
            } catch (Exception e) {
                e.printStackTrace();
            }
          return connection;
    }

   
   
 
}
