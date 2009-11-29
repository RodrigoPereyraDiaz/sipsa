/*
 * Sistemas de Informacion II 2009
 * Proyecto Sipsa
 */
package sipsa.dominio;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import sipsa.persistencia.IPersistible;

/**
 * Venta
 * @author Claudio Rodrigo Pereyra Diaz
 * @author Maria Eugenia Sanchez
 */
public class Venta implements IPersistible, Serializable {

    private int id;
    private Pv empresaVendedora;
    private Producto producto;
    private String nroFactura;
    private Date fechaFactura;

    /**
     * Construye un nuevo objeto Venta
     */
    public Venta() {
        producto = new Producto();
    }

    /**
     * Construye un nuevo objeto Venta
     * @param id
     */
    public Venta(int id) {
        this.id = id;
    }

    /**
     * Obtiene el identificador de la Venta
     * @return devuelve el identificador de la Venta
     */
    public int getID() {
        return this.id;
    }

    /**
     * @return the productos
     */
    public Producto getProducto() {
        return producto;
    }

    /**
     * @param productos the productos to set
     */
    public void setProducto(Producto productos) {
        this.producto = productos;
    }

    /**
     * @return the fecha
     */
    public Date getFechaFactura() {
        return fechaFactura;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFechaFactura(Date fecha) {
        this.fechaFactura = fecha;
    }

    /**
     * @return the empresaVendedora
     */
    public Pv getEmpresaVendedora() {
        return empresaVendedora;
    }

    /**
     * @param empresaVendedora the empresaVendedora to set
     */
    public void setEmpresaVendedora(Pv empresaVendedora) {
        this.empresaVendedora = empresaVendedora;
    }

    /**
     * @return the nroFactura
     */
    public String getNroFactura() {
        return nroFactura;
    }

    /**
     * @param nroFactura the nroFactura to set
     */
    public void setNroFactura(String nroFactura) {
        this.nroFactura = nroFactura;
    }

    /**
     * Verifica si el producto se encuentra en garantia
     * @return True si esta en garantia, False si la garantia expiro
     */
    public boolean isProductoEnGarantia() {
        Modelo modelo = producto.getModelo();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fechaFactura);
        calendar.add(Calendar.MONTH, modelo.getDuracionGarantia());
        return calendar.getTime().after(new Date(System.currentTimeMillis()));
    }
}
