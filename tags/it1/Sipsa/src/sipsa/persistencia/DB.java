/*
 * Sistemas de Informacion II 2009
 * Proyecto Sipsa
 */

package sipsa.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Punto de conexion con base de datos
 * @author Claudio Rodrigo Pereyra Diaz
 * @author Maria Eugenia Sanchez
 */
public class DB {
    private static Connection conn;

    /**
     * Conexion a la Base de Datos
     * @return Conexion unica a la base de datos
     */
    protected static Connection getConexion() {
        if (DB.conn == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();

                String connectionUrl = "jdbc:mysql://elsupergomez.dyndns.org:3306/sipsa";
                //String connectionUrl = "jdbc:mysql://192.168.1.101:3306/sipsa";
                //String connectionUrl = "jdbc:mysql://192.168.1.13:3306/sipsa";
                //String connectionUrl = "jdbc:mysql://localhost:3306/sipsa";
                DB.conn = DriverManager.getConnection(connectionUrl, "sipsa", "sipsa");

            } catch (InstantiationException ex) {
                Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                System.err.println("Error al cargar el driver de JDBC");
                ex.printStackTrace();
            } catch (SQLException ex) {
                System.err.println("Error al conectarse a la base de datos");
                ex.printStackTrace();
            }
        }

        return conn;
    }
}
