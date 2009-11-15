/*
 * Sistemas de Informacion II 2009
 * Proyecto Sipsa
 */

package sipsa.control.servicios;

import java.io.Serializable;

/**
 * Mensaje del Protocolo de comunicación entre el Servidor Sipsa y los Clientes Sipsa
 * @author Claudio Rodrigo Pereyra Diaz
 * @author Maria Eugenia Sanchez
 */
public abstract class Mensaje implements Serializable{
    private Object Contenido;

    /**
     * mensaje
     * @return
     * @throws java.lang.Exception
     */
    public abstract Mensaje procesar() throws Exception;

    /**
     * Obtiene el contenido del cuerpo del mensaje
     * @return Contenido del uerpo del mensaje
     */
    public Object getContenido() {
        return Contenido;
    }

    /**
     * Establece el contenido dle cuerpo del mensaje
     * @param Contenido del cuerpo del mensaje
     */
    public void setContenido(Object Contenido) {
        this.Contenido = Contenido;
    }
}