package sipsa.persistencia;

import java.util.List;
import sipsa.SipsaExcepcion;

interface ISipsaBroker {
    IPersistible existe(IPersistible o) throws SipsaExcepcion;
    boolean actualizar(IPersistible o) throws SipsaExcepcion;
    boolean guardar(IPersistible o) throws SipsaExcepcion;
    boolean eliminar(IPersistible o) throws SipsaExcepcion;
    IPersistible recuperar(IPersistible o) throws SipsaExcepcion;
    List<IPersistible> recuperarLista() throws SipsaExcepcion;
}