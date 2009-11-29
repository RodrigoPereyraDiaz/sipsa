/*
 * Sistemas de Informacion II 2009
 * Proyecto Sipsa
 */
package sipsa;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.UIManager;

/**
 * Selector de descriptores de Configuracion de los Sistemas Sipsa
 * @author Claudio Rodrigo Pereyra Diaz
 * @author Maria Eugenia Sanchez
 */
public class Configuracion {

    private static Configuracion configuracion;
    private String servidorDB = "localhost";

    /**
     * Obteniene la instancia del selector de recursos
     * @return Instancia de Configuracion
     */
    public static Configuracion getInstancia() {
        if (configuracion == null) {
            configuracion = new Configuracion();
        }
        return configuracion;
    }

    /**
     * Obtiene la contrasela para acceder a la base de datos
     * @return
     */
    public String getDBPassword() {
        return "sipsa";
    }

    /**
     * Obtiene el usuario de la base de datos
     * @return
     */
    public String getDBUsuario() {
        return "sipsa";
    }

    /**
     * Obtiene la imagen del logotipo del sistema para las GUI
     * @return Logotipo del sistema
     */
    public Image getIcono() {
        return Toolkit.getDefaultToolkit().getImage(getClass().getResource("/sipsa/presentacion/recursos/Sipsa.png"));
    }

    /**
     * Establece el Look and Feel con es el estilo local del sistema operativo
     */
    public void setEstiloLocal() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Obtiene el driver a utilizar para conectarse con la base de datos
     * @return Driver de la Base de datos
     */
    public String getDBDriver() {
        return "com.mysql.jdbc.Driver";
    }

    /**
     * Obtiene la cadena de conexion a la base de datos
     * @return Cadena de conexion a la base de datos
     */
    public String getDBCadenaConexion() {
        return "jdbc:mysql://" + servidorDB + ":3306/sipsa";
    }

    /**
     * Establecer el nombre-ruta del servidor de base de datos
     * @param servidorDB the servidorDB to set
     */
    public void setServidorDB(String servidorDB) {
        this.servidorDB = servidorDB;
    }
}
