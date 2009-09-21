package BaseDatos;

public class ConcretoCreadorItems extends CreadorItems{
    

    public ConcretoCreadorItems() {
    }
    
    public  IntermediarioItems factoryMethod(int tipo){
        IntermediarioItems it=null;
        switch(tipo){
            case 0:
                it=new IntermediarioArticulos();
              break;
            case 1:
                it=new IntermediarioProductos();
              break;
              default:
                it= new IntermediarioServicios(); 
                  
        } 
        return it;
    }
    
}
