/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sipsa.control;

import sipsa.dominio.Venta;

/**
 *
 * @author elsupergomez
 */
public class VentaControl {

    public boolean activarGarantia(Venta venta) {
        if (venta.getNroFactura().equals("1")){
            return true;  
        } else {
            return false;
        }
        
    }
//TODO completar
}
