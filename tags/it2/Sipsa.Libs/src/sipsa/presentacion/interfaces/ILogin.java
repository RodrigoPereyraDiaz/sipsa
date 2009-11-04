/*
 * Sistemas de Informacion II 2009
 * Proyecto Sipsa
 */

package sipsa.presentacion.interfaces;

/**
 * Interface a implementar los metodos necesarios para identificar y autenticar usuarios
 * @author Claudio Rodrigo Pereyra Diaz
 * @author Maria Eugenia Sanchez
 */
public interface ILogin {
    /**
     * Implementa el comportamiento de validacion de usuario al presionar el boton Ingresar del formulario Login
     * @param usuario Identificacion
     * @param password Autenticacion
     * @return True si se pudo identificar y autenticar satisfactoriamente
     */
    public void ingresar(String usuario,char[] password) throws SecurityException;
}