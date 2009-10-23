package sipsa.control.servicios;

import java.io.Serializable;

public class Mensaje implements Serializable {
    private String Descriptor;
    private Object Contenido;

    public void procesar() {
        //TODO aca se procesa el mensaje de acuerdo a su contenido
    }

    public String getDescriptor() {
        return Descriptor;
    }

    public void setDescriptor(String Descriptor) {
        this.Descriptor = Descriptor;
    }

    public Object getContenido() {
        return Contenido;
    }

    public void setContenido(Object Contenido) {
        this.Contenido = Contenido;
    }
}