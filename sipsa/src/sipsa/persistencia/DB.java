/*
 * Sistemas de Informacion II 2009
 * Proyecto Sipsa
 */
package sipsa.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import sipsa.SipsaExcepcion;
/**
 * Punto de conexion con base de datos
 * @author Claudio Rodrigo Pereyra Diaz
 * @author Maria Eugenia Sanchez
 */
class DB {
    private static Connection conn;

    /**
     * Conexion a la Base de Datos
     * @return Conexion unica a la base de datos
     */
    public static Connection getConexion() throws SipsaExcepcion {
        if (DB.conn == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                //TODO parametrizar la cadena de conexion
                String connectionUrl = "jdbc:mysql://localhost:3306/sipsa";
                DB.conn = DriverManager.getConnection(connectionUrl, "sipsa", "sipsa");
            } catch (Exception ex) {
                ex.printStackTrace();
                throw new SipsaExcepcion("Error al conectarse a la base de datos de Sipsa");
            }
        }
        return conn;
    }
}
