/*
 * Sistemas de Informacion II 2009
 * Proyecto Sipsa
 */

package sipsa.dominio;

import java.io.Serializable;

/**
 * Enumerado de Estados de Orden de Trabajo
 * @author Claudio Rodrigo Pereyra Diaz
 * @author Maria Eugenia Sanchez
 */
public enum EstadoOT implements Serializable {
    /**
     * Orden de Trabajo Nueva
     */
    Nueva,
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
    Anulada;

    //FIXME ver la otra tecnica para convertir los enumerados y obtenerlos
    /**
     * Convierte los enumerados a valores numericos
     * @param estadoOT
     * @return devuelve los valores correspondientes a los enumerados
     */
    public static int toInt(EstadoOT estadoOT) {
		switch (estadoOT) {
            case Nueva: { return 0; }
            case Activa: { return 1; }
			case Finalizada: { return 2; }
			case Anulada: { return 3; }
			default: { return -1; }
		}
	}

    /**
     * Analiza los valores de los estados
     * @param numero
     * @return devuelve el estado 
     */
    public static EstadoOT fromInt(int numero) {
		switch (numero) {
			case 0: { return Nueva; }
            case 1: { return Activa; }
			case 2: { return Finalizada; }
			case 3: { return Anulada; }
			default: { return null; }
		}
	}
}
