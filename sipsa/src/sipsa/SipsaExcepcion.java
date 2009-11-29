/*
 * Sistemas de Informacion II 2009
 * Proyecto Sipsa
 */
package sipsa;

/**
 * Excepsion Sipsa para manejar las excepciones del dominio
 * @author Claudio Rodrigo Pereyra Diaz
 * @author Maria Eugenia Sanchez
 */
public class SipsaExcepcion extends Exception {

    /**
     * Crea una nueva Excepcion Sipsa
     * @param string Mensaje descriptivo de la excepcion
     */
    public SipsaExcepcion(String string) {
        super(string);
    }
}
