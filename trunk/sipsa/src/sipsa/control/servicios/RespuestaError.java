package sipsa.control.servicios;

import sipsa.SipsaExcepcion;

class RespuestaError extends Mensaje{

    @Override
    public Mensaje procesar() throws SipsaExcepcion {
        Cliente.getCliente().handelError((SipsaExcepcion) this.getContenido());
        return null;
    }
}
