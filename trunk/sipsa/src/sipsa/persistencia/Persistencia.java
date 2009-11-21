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
    //TODO paquete revisar las consultas Existe, revisar JavaDoc, modificar los Eliminar para que sean bajas logicas

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

    public IPersistible existe(IPersistible o) throws SipsaExcepcion {
        ISipsaBroker broker = BrokerFabrica.getBroker(o.getClass());
        return broker.existe(o);
    }

    public void actualizar(IPersistible o) throws SipsaExcepcion {
        ISipsaBroker broker = BrokerFabrica.getBroker(o.getClass());
        broker.actualizar(o);
    }

    public void guardar(IPersistible o) throws SipsaExcepcion {
        ISipsaBroker broker = BrokerFabrica.getBroker(o.getClass());
        broker.guardar(o);
    }

    public void eliminar(IPersistible o) throws SipsaExcepcion {
        ISipsaBroker broker = BrokerFabrica.getBroker(o.getClass());
        broker.eliminar(o);
    }

    public IPersistible recuperar(IPersistible o) throws SipsaExcepcion {
        ISipsaBroker broker = BrokerFabrica.getBroker(o.getClass());
        return broker.recuperar(o);
    }

    public List<IPersistible> recuperarLista(Class clase) throws SipsaExcepcion {
        ISipsaBroker broker = BrokerFabrica.getBroker(clase);
        return broker.recuperarLista();
    }
}
