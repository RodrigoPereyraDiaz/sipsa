package sipsa.control.servicios;

class RespuestaOK extends Mensaje{

    @Override
    public Mensaje procesar() {
        Cliente.getCliente().handelOK(this.getContenido().toString());
        return null;
    }

}
