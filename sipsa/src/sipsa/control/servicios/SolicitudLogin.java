package sipsa.control.servicios;

import sipsa.dominio.Usuario;

class SolicitudLogin extends Mensaje {

    @Override
    public Mensaje procesar() {
        Mensaje mensaje = null;
        Usuario usuario = (Usuario) this.getContenido();
        if  (usuario.isValido()){
            mensaje = MensajesFabrica.newRespuestaOK();
            mensaje.setContenido("Ingreso satisfactorio");
        } else {
            mensaje = MensajesFabrica.newRespuestaError();
            mensaje.setContenido("Error de autenticacón");
        }
        return mensaje;
    }
}