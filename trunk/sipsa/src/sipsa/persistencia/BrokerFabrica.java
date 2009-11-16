package sipsa.persistencia;

import sipsa.SipsaExcepcion;

class BrokerFabrica {
    static ISipsaBroker getBroker(Class c) throws SipsaExcepcion{
        ISipsaBroker broker = null;
        if (c.getName().equals("sipsa.dominio.Fabrica")) broker = new FabricaBroker();
        if (c.getName().equals("sipsa.dominio.Modelo")) broker =  new ModeloBroker();
        if (c.getName().equals("sipsa.dominio.OrdenDeTrabajo")) broker = new OtBroker();
        if (c.getName().equals("sipsa.dominio.Pac")) broker =  new PacBroker();
        if (c.getName().equals("sipsa.dominio.Producto")) broker =  new ProductoBroker();
        if (c.getName().equals("sipsa.dominio.Pv")) broker =  new PvBroker();
        if (c.getName().equals("sipsa.dominio.TipoProducto")) broker = new TipoProductoBroker();
        if (c.getName().equals("sipsa.dominio.Venta")) broker =  new VentaBroker();
        if (broker == null)
            throw new SipsaExcepcion("El objecto no pertenece a una clase del dominio del sistema que pueda ser almacenado en forma permanente");
        return broker;
    }
}