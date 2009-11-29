/*
 * Sistemas de Informacion II 2009
 * Proyecto Sipsa
 */
package sipsa.persistencia;

import java.util.List;

import sipsa.SipsaExcepcion;

/**
 * Punto de acceso a los medios de persistencia
 * @author Claudio Rodrigo Pereyra Diaz
 * @author Maria Eugenia Sanchez
 */
public class Persistencia {

    private static Persistencia persistencia;

    private Persistencia() {
    }

    /**
     * Obtiene la instancia del punto de acceso a la persistencia
     * @return Instancia de Persistencia
     */
    public static Persistencia getPersistencia() {
        if (persistencia == null) {
            persistencia = new Persistencia();
        }
        return persistencia;
    }

    /**
     * Verifica la existencia de un objecto en el medio de persistencia
     * @param o Objecto a verfificar
     * @return Objecto recuperado desde el medio de persistencia
     * @throws SipsaExcepcion Si no es posible establecer la existencia del objecto
     */
    public IPersistible existe(IPersistible o) throws SipsaExcepcion {
        ISipsaBroker broker = BrokerFabrica.getBroker(o.getClass());
        return broker.existe(o);
    }

    /**
     * Actualiza un Objecto en el medio de persistencia
     * @param o Objecto a actualizar
     * @throws SipsaExcepcion Si no es posible actualizar el objecto
     */
    public void actualizar(IPersistible o) throws SipsaExcepcion {
        ISipsaBroker broker = BrokerFabrica.getBroker(o.getClass());
        broker.actualizar(o);
    }

    /**
     * Guarda un objecto en el medio de persistencia
     * @param o Objecto a guardar
     * @throws SipsaExcepcion si no es posible guardar en el medio de persistencia
     */
    public void guardar(IPersistible o) throws SipsaExcepcion {
        ISipsaBroker broker = BrokerFabrica.getBroker(o.getClass());
        broker.guardar(o);
    }

    /**
     * Elimina un objecto del medio de persistencia
     * @param o Objecto a eliminar
     * @throws SipsaExcepcion si no es posible eliminar el objecto
     */
    public void eliminar(IPersistible o) throws SipsaExcepcion {
        ISipsaBroker broker = BrokerFabrica.getBroker(o.getClass());
        broker.eliminar(o);
    }

    /**
     * Recupera un objecto del medio de persistencia
     * @param o Objecto con la informacion para identificar el objecto
     * @return Objecto recuperado del medio de persistencia
     * @throws SipsaExcepcion si no es posible recuperar el objecto del medio de persistencia
     */
    public IPersistible recuperar(IPersistible o) throws SipsaExcepcion {
        ISipsaBroker broker = BrokerFabrica.getBroker(o.getClass());
        return broker.recuperar(o);
    }

    /**
     * Recupera una lista de objectos del medio de persistencia
     * @param clase Clase de objectos a recuperar
     * @return Lista de objectos
     * @throws SipsaExcepcion si no es posible recuperar la lista desde el medio de persistencia
     */
    public List<IPersistible> recuperarLista(Class clase) throws SipsaExcepcion {
        ISipsaBroker broker = BrokerFabrica.getBroker(clase);
        return broker.recuperarLista();
    }
}
