package sipsa.control;

import sipsa.dominio.Venta;

public class VentaControl {

    public boolean activarGarantia(Venta venta) throws Exception {
        //TODO validar los datos de la venta guardar en caso positivo, excepcion en caso negativo
        if (venta.getNroFactura().equals("1")){
            return true;  
        } else {
            return false;
        }
    }
}
