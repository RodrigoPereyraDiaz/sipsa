package sipsa.control.servicios;

import sipsa.dominio.Usuario;

class SolicitudLogin extends Mensaje {

    @Override
    public Mensaje procesar() {
        Mensaje mensaje = null;
        Usuario usuario = (Usuario) this.getContenido();
        if  (usuario.isValido()){
            mensaje = MensajesFabrica.newRespuestaOK();
            mensaje.setDescriptor("Ingreso satisfactorio");
            mensaje.setContenido("Bienvenido al sistema Sipsa");
        } else {
            mensaje = MensajesFabrica.newRespuestaError();
            mensaje.setDescriptor("Error de autenticacón");
            mensaje.setContenido("No se pudo ingresar al sistema, intente nuevamente");
        }
        return mensaje;
    }
}