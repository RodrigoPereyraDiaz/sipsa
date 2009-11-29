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

    public String getDBPassword() {
        return "sipsa";
    }

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

    public String getDBDriver() {
        return "com.mysql.jdbc.Driver";
    }

    public String getDBCadenaConexion() {
        return "jdbc:mysql://"+ servidorDB + ":3306/sipsa";
    }
}
