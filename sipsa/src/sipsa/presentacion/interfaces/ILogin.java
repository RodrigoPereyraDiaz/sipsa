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
     * Implementa el la validacion de usuario al presionar el boton Ingresar del formulario Login
     * @param usuario Identificacion del usuario
     * @exception Exception Si no se pudo validar el usuario
     */
    public void ingresar(String usuario) throws Exception;
}