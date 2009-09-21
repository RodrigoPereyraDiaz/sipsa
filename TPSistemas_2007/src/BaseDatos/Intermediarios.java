package BaseDatos;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public abstract class Intermediarios {
    
    /** Creates a new instance of Intermediarios */
    public Intermediarios() {
    }
    
    abstract Vector getLista();
    
    public Statement conectarBase(){
        try{
            Sql sql = Sql.getIntancia();
            Connection con = sql.conectar();
            Statement statement = con.createStatement();
            return statement;
            
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    
}
