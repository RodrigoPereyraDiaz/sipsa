package sipsa.control.servicios;

class RespuestaError extends Mensaje{

    @Override
    public Mensaje procesar() {
        Cliente.handelError(this);
        return null;
    }

}
