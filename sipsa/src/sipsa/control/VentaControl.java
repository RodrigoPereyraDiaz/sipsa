package sipsa.control;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import sipsa.SipsaExcepcion;
import sipsa.dominio.Modelo;
import sipsa.dominio.Producto;
import sipsa.dominio.Pv;
import sipsa.dominio.Venta;
import sipsa.persistencia.Persistencia;

/**
 * Controlador de Ventas
 * @author Claudio Rodrigo Pereyra Diaz
 * @author Maria Eugenia Sanchez
 */
public class VentaControl {
    private Persistencia persistencia = Persistencia.getPersistencia();

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
            throw new SipsaExcepcion("El el producto no se encuentra disponible para activacion de garantia, verifique el tipo, modelo y número de serie");
        }
        venta.setProductos(producto);
        if (this.productoRegistrado(venta)){
            throw new SipsaExcepcion("El el producto ya fue registrado anteriormente, la garantia ya se encuentra activada");
        }
        Date fechaFacturaRegistro;
        try {
            fechaFacturaRegistro = DateFormat.getDateInstance().parse(fechaFactura);
        } catch (ParseException ex) {
            ex.printStackTrace();
            throw new SipsaExcepcion("La fecha ingresada no es una fecha valida");
        }
        if (fechaFacturaRegistro.after(new Date(System.currentTimeMillis()))){
            throw new SipsaExcepcion("La fecha de factura NO puede ser mayor a la fecha actual");
        }
        venta.setFechaFactura(fechaFacturaRegistro);
        if (nroFactura.equals("")){
            throw new SipsaExcepcion("Debe ingresar el numero de factura de la venta");
        }
        venta.setNroFactura(nroFactura);
        venta.setEmpresaVendedora(pv);
        this.guardarVenta(venta);
    }

    /**
     * Guarda la Venta en el sistema Sipsa
     * @param venta
     */
    public void guardarVenta(Venta venta) {
        persistencia.savePv(venta);
    }

    private boolean productoRegistrado(Venta venta){
        return (persistencia.existVenta(venta) != null);
    }
}
