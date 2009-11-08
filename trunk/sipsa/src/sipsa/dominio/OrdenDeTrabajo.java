/*
 * Sistemas de Informacion II 2009
 * Proyecto Sipsa
 */

package sipsa.dominio;

/**
 * Orden de Trabajo
 * @author Claudio Rodrigo Pereyra Diaz
 * @author Maria Eugenia Sanchez
 */
public class OrdenDeTrabajo {
    private Venta garantia;
    private Pac pac;
    //TODO revisar si esta bien usar un enumerado o es mejor el Patron State, falta fecha de entrega
    private EstadoOT estado;
    private String observaciones;
    private String motivoEstado;

    /**
     * @return the garantia
     */
    public Venta getGarantia() {
        return garantia;
    }

    /**
     * @param garantia the garantia to set
     */
    public void setGarantia(Venta garantia) {
        this.garantia = garantia;
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
}