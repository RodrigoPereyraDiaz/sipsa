package sipsa.persistencia;

import java.util.List;

public interface IPersistencia {
    public Object existe(Object o);
    public boolean actualizar(Object o);
    public boolean guardar(Object o);
    public boolean eliminar(Object o);
    public Object obteber(int id);
    public List<Object> obteberLista(Class c);
}