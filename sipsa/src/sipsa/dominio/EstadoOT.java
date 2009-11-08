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
    public static int toInt(EstadoOT estadoOT) {
		switch (estadoOT) {
			case Activa: { return 0; }
			case Finalizada: { return 1; }
			case Anulada: { return 2; }
			default: { return -1; }
		}
	}
	public static EstadoOT fromInt(int numero) {
		switch (numero) {
			case 0: { return Activa; }
			case 1: { return Finalizada; }
			case 2: { return Anulada; }
			default: { return null; }
		}
	}
}
