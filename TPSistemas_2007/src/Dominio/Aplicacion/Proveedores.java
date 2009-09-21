/*
 * Proveedores.java
 *
 * Created on 8 de abril de 2007, 13:08
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package Dominio.Aplicacion;

/**
 *
 * @author Mariano
 */

    
    /** Creates a new instance of Proveedores */
   public class Proveedores {
    
    private int numero;
    private String razonSocial;
    private String codigo;
    private String cuit_dni;
    private String mail;
    private String telefono;
    private String iva;
    private String domicilio;
    private FormaPedido formaP;

    public Proveedores() {
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int val) {
        this.numero = val;
    }

        
    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String val) {
        this.razonSocial = val;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String val) {
        this.codigo = val;
    }

    public String getCuit_dni() {
        return cuit_dni;
    }

    public void setCuit_dni(String val) {
        this.cuit_dni = val;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String val) {
        this.mail = val;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String val) {
        this.telefono = val;
    }

    public String getIva() {
        return iva;
    }

    public void setIva(String val) {
        this.iva = val;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String val) {
        this.domicilio = val;
    }
    
    public void setFormaPedido(FormaPedido fp){
        this.formaP=fp;
    }
       
    public FormaPedido getFormaPedido(){
        return(this.formaP);
    }
}

    

