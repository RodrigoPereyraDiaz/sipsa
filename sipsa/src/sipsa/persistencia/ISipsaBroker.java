/*
 * Sistemas de Informacion II 2009
 * Proyecto Sipsa
 */
package sipsa.persistencia;

import java.util.List;

import sipsa.SipsaExcepcion;

interface ISipsaBroker {

    IPersistible existe(IPersistible o) throws SipsaExcepcion;

    void actualizar(IPersistible o) throws SipsaExcepcion;

    void guardar(IPersistible o) throws SipsaExcepcion;

    void eliminar(IPersistible o) throws SipsaExcepcion;

    IPersistible recuperar(IPersistible o) throws SipsaExcepcion;

    List<IPersistible> recuperarLista() throws SipsaExcepcion;
}
