package sipsa.control;

import java.util.Date;
import sipsa.dominio.Producto;
import sipsa.dominio.Pv;
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

    public void activarGarantia(Pv pv,Date fechaFactura,String nroFactura) throws Exception {
        Venta venta = new Venta();
        ProductosControl productosControl = new ProductosControl();
        Producto producto = new Producto();
        if (producto == null){
            throw new Exception("El el producto no se encuentra disponible para activacion de garantia");
        }
        venta.setProductos(producto);
        if (this.productoRegistrado(venta)){
            throw new Exception("El el producto ya fue registrado anteriormente, la garantia ya se encuentra activada");
        }
        venta.setEmpresaVendedora(pv);
        venta.setFechaFactura(fechaFactura);
        venta.setNroFactura(nroFactura);
        this.guardarVenta(venta);
    }

    public void guardarVenta(Venta venta) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private boolean productoRegistrado(Venta venta){
        //TODO validar que el producto se encuentre registrado
        return true;
    }
}
