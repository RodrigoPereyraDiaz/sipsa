/*
 * Sistemas de Informacion II 2009
 * Proyecto Sipsa
 */

package sipsa.dominio;

import java.util.Date;
import sipsa.persistencia.IPersistible;

/**
 * Venta
 * @author Claudio Rodrigo Pereyra Diaz
 * @author Maria Eugenia Sanchez
 */
public class Venta implements IPersistible{
    private int id;
    private Pv empresaVendedora;
    private Producto productos;
    private String nroFactura;
    private Date fechaFactura;

    public Venta(int id) {
        this.id = id;
    }

    public int getID() {
        return this.id;
    }

    /**
     * @return the productos
     */
    public Producto getProductos() {
        return productos;
    }

    /**
     * @param productos the productos to set
     */
    public void setProductos(Producto productos) {
        this.productos = productos;
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
}