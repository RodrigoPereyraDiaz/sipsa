package sipsa.control.servicios;

class RespuestaOK extends Mensaje{

    @Override
    public Mensaje procesar() {
        Cliente.handelOK(this);
        return null;
    }

}
