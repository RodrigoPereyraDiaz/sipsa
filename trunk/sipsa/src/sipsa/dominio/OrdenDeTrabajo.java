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
public class OrdenDeTrabajo implements IPersistible, Serializable{
    private int id;
    private Pac pac;
    private Venta venta;
    private String observaciones;
    private EstadoOT estado;
    private String motivoEstado;
    private Date fechaEntrega;

    public OrdenDeTrabajo() {
        this.estado = EstadoOT.Nueva;
    }

    public OrdenDeTrabajo(int id) {
        this.id = id;
    }

    public int getID() {
        return this.id;
    }

    public Date getFechaEntrega() {
        return this.fechaEntrega;
    }

    /**
     * @return the venta
     */
    public Venta getVenta() {
        return venta;
    }

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
     * @return the motivoEstado
     */
    public String getMotivoEstado() {
        return motivoEstado;
    }

    /**
     * @param motivoEstado the motivoEstado to set
     */
    public void setMotivoEstado(String motivoEstado) {
        this.motivoEstado = motivoEstado;
    }

    public boolean isEnGarantia(){
        //TODO implementar la validacion de garantia activa
        return true;
    }
}
