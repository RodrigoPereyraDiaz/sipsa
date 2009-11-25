/*
 * Sistemas de Informacion II 2009
 * Proyecto Sipsa
 */
package sipsa.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;

import sipsa.Configuracion;
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
                Configuracion configuracion = Configuracion.getInstancia();
                Class.forName(configuracion.getDBDriver()).newInstance();
                String connectionUrl = configuracion.getDBCadenaConexion();
                String usuario = configuracion.getDBUsuario();
                String password = configuracion.getDBPassword();
                DB.conn = DriverManager.getConnection(connectionUrl, usuario, password);
            } catch (Exception ex) {
                ex.printStackTrace();
                throw new SipsaExcepcion("Error al conectarse a la base de datos de Sipsa");
            }
        }
        return conn;
    }
}
