/*
 * Sistemas de Informacion II 2009
 * Proyecto Sipsa
 */
package sipsa.dominio;

import java.io.Serializable;
import java.util.Date;
import sipsa.persistencia.IPersistible;

/**
 * Orden de Trabajo
 * @author Claudio Rodrigo Pereyra Diaz
 * @author Maria Eugenia Sanchez
 */
public class OrdenDeTrabajo implements IPersistible, Serializable {

    private int id;
    private Pac pac;
    private Venta venta;
    private String observaciones;
    private EstadoOT estado;
    private String motivoEstado;
    private Date fechaEntrega;

    /**
     * Construye un nuevo objeto Orden de Trabajo con estado Nueva
     */
    public OrdenDeTrabajo() {
        this.estado = EstadoOT.Nueva;
    }

    /**
     * Construye un nuevo objeto Orden de trabajo
     * @param id
     */
    public OrdenDeTrabajo(int id) {
        this.id = id;
    }

    /**
     * Obtiene el identificador de la orden de Trabajo
     * @return el identificador de la orden de Trabajo
     */
    public int getID() {
        return this.id;
    }

    /**
     * Obtiene la fecha de entrega de la orden de trabajo
     * @return devuelve la fecha de entrega
     */
    public Date getFechaEntrega() {
        return this.fechaEntrega;
    }

    /** Obtiene la venta
     * @return la venta
     */
    public Venta getVenta() {
        return venta;
    }

    /**
     * Setea la fecha de entrega
     * @param fechaEntrega
     */
    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    /**
     * @param venta the venta to set
     */
    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    /**
     * @return the pac
     */
    public Pac getPac() {
        return pac;
    }

    /**
     * @param pac the pac to set
     */
    public void setPac(Pac pac) {
        this.pac = pac;
    }

    /**
     * @return the estado
     */
    public EstadoOT getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(EstadoOT estado) {
        this.estado = estado;
    }

    /**
     * @return the observaciones
     */
    public String getObservaciones() {
        return observaciones;
    }

    /**
     * @param observaciones the observaciones to set
     */
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    /**
     * Obtiene el motivo del estado
     * @return devuelve el estado del motivo
     */
    public String getMotivoEstado() {
        return motivoEstado;
    }

    /**
     * Setea el motivo del estado
     * @param motivoEstado 
     */
    public void setMotivoEstado(String motivoEstado) {
        this.motivoEstado = motivoEstado;
    }
}
