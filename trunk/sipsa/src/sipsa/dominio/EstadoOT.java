/*
 * Sistemas de Informacion II 2009
 * Proyecto Sipsa
 */

package sipsa.dominio;

/**
 * Enumerado de Estados de Orden de Trabajo
 * @author Claudio Rodrigo Pereyra Diaz
 * @author Maria Eugenia Sanchez
 */
public enum EstadoOT {
    //TODO revisar si es una buena opcion o es mejor usar un Patron State
    /**
     * Orden de Trabajo Activa
     */
    Activa,
    /**
     * Orden de Trabajo Finalizada
     */
    Finalizada,
    /**
     * Orden de Trabajo Anulada
     */
    Anulada,
}
