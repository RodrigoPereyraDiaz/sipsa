package sipsa.control;

import java.util.Date;
import sipsa.dominio.Modelo;
import sipsa.dominio.Producto;
import sipsa.dominio.Pv;
import sipsa.dominio.Venta;

/**
 * Controlador de Ventas
 * @author Claudio Rodrigo Pereyra Diaz
 * @author Maria Eugenia Sanchez
 */
public class VentaControl {

    /**
     * Valida los datos de la venta y activa la garantía
     * @param venta
     * @return devuelve verdadero si pudo activar la garantía sino devuelve una
     * excepción
     * @throws java.lang.Exception
     */
    public boolean activarGarantia(Venta venta) throws Exception {
        //TODO validar los datos de la venta guardar en caso positivo, excepcion en caso negativo
        if (venta.getNroFactura().equals("1")){
            return true;  
        } else {
            return false;
        }
    }

    /**
     * Activa una garantía para una nueva venta
     * @param pv
     * @param fechaFactura
     * @param nroFactura
     * @param idTipoProducto
     * @param idModelo
     * @param nroSerie
     * @throws java.lang.Exception
     */
    public void activarGarantia(Pv pv, Date fechaFactura, String nroFactura, int idTipoProducto, int idModelo, String nroSerie) throws Exception {
        Venta venta = new Venta();
        ProductosControl productosControl = new ProductosControl();
        Producto producto = new Producto();
        producto.setNroSerie(nroSerie);
        producto.setModelo(new Modelo(idModelo));
        producto = productosControl.existe(producto);
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

    /**
     * Guarda la Venta en el sistema Sipsa
     * @param venta
     */
    public void guardarVenta(Venta venta) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private boolean productoRegistrado(Venta venta){
        //TODO validar que el producto se encuentre registrado
        return true;
    }
}
