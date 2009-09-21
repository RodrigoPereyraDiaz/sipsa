package Dominio.Aplicacion;
public abstract class Items {
    private int id;
    private String descripcion;
    private float precio,costo;
    

    public  Items() {
    }

    public int getId() {
        return id;
    }

    public void setId(int val) {
        this.id = val;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String val) {
        this.descripcion = val;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float val) {
        this.precio = val;
    }

     public float getCosto() {
        return costo;
    }

    public void setCosto(float val) {
        this.costo = val;
    }
   

   
}
