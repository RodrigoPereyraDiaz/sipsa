/*
 * Sistemas de Informacion II 2009
 * Proyecto Sipsa
 */

package sipsa.control.servicios;

import java.io.Serializable;

/**
 * Mensaje del Protocolo de comunicacion entre el Servidor Sipsa y los Clientes Sipsa
 * @author Claudio Rodrigo Pereyra Diaz
 * @author Maria Eugenia Sanchez
 */
public class Mensaje implements Serializable {
    private String Descriptor;
    private Object Contenido;


    /**
     * Realiza la accion correspondeiente al tipo de Mensaje
     */
    public Mensaje procesar() {
        //TODO hacer que esto use el patron comando
        if (this.getDescriptor().equalsIgnoreCase("hola servidor"))
            this.setDescriptor("hola cliente");
        return this;
    }

    /**
     * Descripcion del Mensaje
     * @return Texto de la descripcion del mensaje
     */
    public String getDescriptor() {
        return Descriptor;
    }

    /**
     * Establece la descripcion del mensaje
     * @param Descriptor del mensaje
     */
    public void setDescriptor(String Descriptor) {
        this.Descriptor = Descriptor;
    }

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