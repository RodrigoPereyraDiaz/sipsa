package BaseDatos;


public abstract class CreadorItems {
    
    /** Creates a new instance of CreadorItems */
    public CreadorItems() {
    }    
    public abstract IntermediarioItems factoryMethod(int tipo);
    public IntermediarioItems getIntermediario(int tipo){
        return factoryMethod(tipo);
    }
}
