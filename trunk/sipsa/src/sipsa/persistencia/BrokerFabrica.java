package sipsa.persistencia;

import sipsa.SipsaExcepcion;
import sipsa.dominio.Fabrica;
import sipsa.dominio.Modelo;
import sipsa.dominio.OrdenDeTrabajo;
import sipsa.dominio.Pac;
import sipsa.dominio.Producto;
import sipsa.dominio.Pv;
import sipsa.dominio.TipoProducto;
import sipsa.dominio.Venta;

class BrokerFabrica {
    static ISipsaBroker getBroker(Class c) throws SipsaExcepcion{
        ISipsaBroker broker = null;
        if (c.equals(Fabrica.class)) broker = new FabricaBroker();
        if (c.equals(Modelo.class)) broker =  new ModeloBroker();
        if (c.equals(OrdenDeTrabajo.class)) broker = new OtBroker();
        if (c.equals(Pac.class)) broker =  new PacBroker();
        if (c.equals(Producto.class)) broker =  new ProductoBroker();
        if (c.equals(Pv.class)) broker =  new PvBroker();
        if (c.equals(TipoProducto.class)) broker = new TipoProductoBroker();
        if (c.equals(Venta.class)) broker =  new VentaBroker();
        if (broker == null)
            throw new SipsaExcepcion("El objecto no pertenece a una clase del dominio del sistema que pueda ser almacenado en forma permanente");
        return broker;
    }
}