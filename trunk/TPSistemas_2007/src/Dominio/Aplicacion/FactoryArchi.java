package Dominio.Aplicacion;
import java.lang.reflect.*;

public class FactoryArchi {
    
       public FactoryArchi() {
    }
       
       public Object getArchivo(String fPedido){
           Object object = null;
      try {
          Class classDefinition = Class.forName(fPedido);
          object = classDefinition.newInstance();
          
      } catch (InstantiationException e) {
          System.out.println(e);
      } catch (IllegalAccessException e) {
          System.out.println(e);
      } catch (ClassNotFoundException e) {
          System.out.println(e);
      }
      return object;
   }

}
