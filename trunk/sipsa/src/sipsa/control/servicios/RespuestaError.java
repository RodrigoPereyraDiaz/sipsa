package sipsa.control.servicios;

class RespuestaError extends Mensaje{

    @Override
    public Mensaje procesar() throws Exception {
        Cliente.getCliente().handelError((Exception) this.getContenido());
        return null;
    }
}
