/*
 * Sistemas de Informacion II 2009
 * Proyecto Sipsa
 */

package sipsa;

import java.awt.Image;
import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * Selector de descriptores de Configuracion de los Sistemas Sipsa
 * @author Claudio Rodrigo Pereyra Diaz
 * @author Maria Eugenia Sanchez
 */
public class Configuracion {
    private static Configuracion configuracion;

    /**
     * Obteniene la instancia del selector de recursos
     * @return Instancia de Configuracion
     */
    public static Configuracion getInstancia(){
        if (configuracion == null){
            configuracion = new Configuracion();
        }
        return configuracion;
    }

    /**
     * Obtiene la imagen del logotipo del sistema para las GUI
     * @return Logotipo del sistema
     */
    public Image getIcono(){
        return Toolkit.getDefaultToolkit().getImage(getClass().getResource("/sipsa/presentacion/recursos/Sipsa.png"));
    }

    /**
     * Establece el Look and Feel con es el estilo local del sistema operativo
     */
    public void setEstiloLocal(){
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Configuracion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Configuracion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Configuracion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Configuracion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}