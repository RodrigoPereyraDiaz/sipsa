/*
 * Sistemas de Informacion II 2009
 * Proyecto Sipsa
 */

package sipsa.dominio;

import java.util.Date;

/**
 * Venta
 * @author Claudio Rodrigo Pereyra Diaz
 * @author Maria Eugenia Sanchez
 */
public class Venta {
    private Producto productos;
    private Date fecha;
    private Pv empresaVendedora;
    private String nroFactura;

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
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
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

    //TODO revisar que esten todos los atributos de una venta
}
