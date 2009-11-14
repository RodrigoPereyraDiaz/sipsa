package sipsa.control.servicios;

import sipsa.dominio.Pac;
import sipsa.persistencia.Persistencia;

class SolicitudLogin extends Mensaje {

    @Override
    public Mensaje procesar() {
        Mensaje mensaje = null;
        Persistencia persistencia = Persistencia.getPersistencia();
        System.out.println("Recibiendo pac");
        Pac pac = (Pac) this.getContenido();
        System.out.println("Verificando existencia pac");
        if  (persistencia.existPac(pac)){
            mensaje = MensajesFabrica.newRespuestaOK();
            mensaje.setContenido("Ingreso satisfactorio");
        } else {
            mensaje = MensajesFabrica.newRespuestaError();
            mensaje.setContenido(new Exception("Error de autenticación"));
        }
        return mensaje;
    }
}