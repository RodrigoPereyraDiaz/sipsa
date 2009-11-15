//TODO generalizar para que se usen pocos metodos
//TODO hacer que el save sera un insert si no existe, y un update si ya existe

/*
 * Sistemas de Informacion II 2009
 * Proyecto Sipsa
 */

package sipsa.persistencia;

import java.util.List;
import sipsa.dominio.*;

/**
 * Punto de acceso a los medios de persistencia
 * @author Claudio Rodrigo Pereyra Diaz
 * @author Maria Eugenia Sanchez
 * Patrones: Facade, Singleton

 */
public class Persistencia {
    //TODO unificar la logica de los metodos para disminuir la complejidad de uso
    private static Persistencia persistencia;

    /**
     * Obtiene la instancia del punto de acceso a la persistencia
     * @return Instancia de Persistencia
     */
    public static Persistencia getPersistencia(){
        if (persistencia == null){
            persistencia = new Persistencia();
        }
        return persistencia;
    }

    private Persistencia(){};

    /**
     * Obtiene una orden de trabajo
     * @param id
     * @return devuelve un objeto orden de Trabajo
     */
    public OrdenDeTrabajo getOrdenDeTrabajo(Object id) {
        OtBroker otBroker = new OtBroker();
        return otBroker.getOT(Integer.parseInt(id.toString()));
    }

    /**
     * Obtiene una lista de ordenes de trabajo
     * @return devuelve una lista de ordenes de Trabajo
     */
    public List<OrdenDeTrabajo> getOrdenesDeTrabajo() {
        OtBroker otBroker = new OtBroker();
        return otBroker.getList();
    }

    /**
     * Obtiene la lista de ordenes de Trabajo para un pac especifico
     * @param pac
     * @return devuelve la lista de ordenes de Trabajo para un pac específico
     */
    public List<OrdenDeTrabajo> getOrdenesDeTrabajo(Pac pac) {
        //FIXME poner logica para devolver solo las de un pac
        return this.getOrdenesDeTrabajo();

    }

    ///Fachada de la persistencia de Pac

    /**
     * Obtiene del medio de persistencia el PAC identificado
     * @param id identificador unico de PAC
     * @return Instancia del PAC
     */
    public Pac getPac(int id) {
        PacBroker pacAdapter = new PacBroker();
        return pacAdapter.getPac(id);
    }

    /**
     * Guarda el PAC en el medio de persistencia
     * @param pac PAC a guardar
     * @return Resultado de la operacion persistencia
     */
    public boolean savePac(Pac pac){
        PacBroker pacAdapter = new PacBroker();
        return pacAdapter.savePac(pac);
    }
    
    /**
     * Elimina un PAC del medio de persistencia
     * @param pac PAC a eliminar
     * @return Resultado de la operacion de persistencia
     */
    public boolean deletePac(Pac pac){
        PacBroker pacAdapter = new PacBroker();
        return pacAdapter.deletePac(pac);
    }

    /**
     * Verifica la existencia de un PAC en el medio de persistencia
     * @param pac PAC a verificar
     * @return Existencia del PAC
     */
    public boolean existPac(Pac pac){
        PacBroker pacAdapter = new PacBroker();
        return pacAdapter.exist(pac);
    }

    /**
     * Obtiene una lista de los PAC existentes en el medio e persistencia
     * @return Lista de PACs
     */
    public List<Pac> getListPac(){
        PacBroker pacAdapter = new PacBroker();
        return pacAdapter.getList();
    }

    ///Fachada de la persistencia de Pv

    /**
     * Obtiene del medio de persistencia el PV identificado
     * @param id Identificador unico de PV
     * @return Instancia de PV
     */
    public Pv getPV(int id){
        PvBroker pvAdapter = new PvBroker();
        return pvAdapter.getPv(id);
    }

    /**
     * Guarda el PV en el medio de persistencia
     * @param pv PV a guardar
     * @return Resultado de la operacion de persistencia
     */
    public boolean savePv(Pv pv){
        PvBroker pvAdapter = new PvBroker();
        return pvAdapter.savePv(pv);
    }

    /**
     * Elimina un PV del medio de persistencia
     * @param pv PV a eliminar
     * @return Resultado de la operacion de persistencia
     */
    public boolean deletePv(Pv pv){
        PvBroker pvAdapter = new PvBroker();
        return pvAdapter.deletePv(pv);
    }

    /**
     * Verifica la existencia de un PV en el medio de persistencia
     * @param pv PV a verificar existencia
     * @return Existencia del PV
     */
    public boolean existPv(Pv pv){
        PvBroker pvAdapter = new PvBroker();
        return pvAdapter.exist(pv);
    }

    /**
     * Obtiene una lista de PVs del medio de persistencia
     * @return Lista de PVs
     */
    public List<Pv> getListPv(){
        PvBroker pvAdapter = new PvBroker();
        return pvAdapter.getList();
    }

    ///Fachada de la persistencia de Producto

    /**
     * Obtiene del medio de persistencia el producto identificado
     * @param id Identificador unico de Producto
     * @return Intancia de Producto
     */
    public Producto getProducto(int id){
        ProductoBroker productoAdapter = new ProductoBroker();
        return productoAdapter.getProducto(id);
    }

    /**
     * Guarda un Producto en el medio de persistencia
     * @param producto Producto a Guardar
     * @return Resultado de la operacion de persistencia
     */
    public boolean saveProducto(Producto producto){
        ProductoBroker productoAdapter = new ProductoBroker();
        return productoAdapter.saveProducto(producto);
    }

    /**
     * Elimina un Producto del medio de persistencia
     * @param producto Producto a eliminar
     * @return Resultado de la operacion de persistencia
     */
    public boolean deleteProducto(Producto producto){
        ProductoBroker productoAdapter = new ProductoBroker();
        return productoAdapter.deleteProducto(producto);
    }

    /**
     * Verifica la existencia de un producto en el medio de persistencia
     * @param producto Producto a verificar
     * @return Existencia del producto
     */
    public boolean existProducto(Producto producto){
        ProductoBroker productoAdapter = new ProductoBroker();
        return productoAdapter.exist(producto);
    }

    /**
     * Obtiene una lista de Productos del medio de persistencia
     * @return Lista de Productos
     */
    public List<Producto> getListProductos(){
        ProductoBroker productoAdapter = new ProductoBroker();
        return productoAdapter.getList();
    }

    ///Fachada de la persistencia de Tipo de Producto

    /**
     * Obtiene del medio de persitencia el Tipo de Producto identificado
     * @param id Identificador unico de Tipo de Producto
     * @return Instancia de Tipo de Producto
     */
    public TipoProducto getTipoProducto(int id){
        TipoProductoBroker tipoProductoAdapter = new TipoProductoBroker();
        return tipoProductoAdapter.getTipoProducto(id);
    }

    /**
     * Guardar un Tipo de Producto en el medio de persistencia
     * @param tipoProducto Tipo de Producto a Guardar
     * @return Resultado de la operacion de persistencia
     */
    public boolean saveTipoProducto(TipoProducto tipoProducto){
        TipoProductoBroker tipoProductoAdapter = new TipoProductoBroker();
        return tipoProductoAdapter.saveTipoProducto(tipoProducto);
    }

    /**
     * Elimina un Tipo de Producto del medio de persistencia
     * @param tipoProducto Tipo de Producto a eliminar
     * @return Resultado del operacion de persistencia
     */
    public boolean deteletTipoProducto(TipoProducto tipoProducto){
        TipoProductoBroker tipoProductoAdapter = new TipoProductoBroker();
        return tipoProductoAdapter.deleteTipoProducto(tipoProducto);
    }

    /**
     * Verifica la existencia de un Tipo de Producto en el medio de persistencia
     * @param tipoProducto Tipo de Producto a verificar
     * @return Existencia del Tipo de Producto
     */
    public boolean existTipoProducto(TipoProducto tipoProducto){
        TipoProductoBroker tipoProductoAdapter = new TipoProductoBroker();
        return tipoProductoAdapter.exist(tipoProducto);
    }

    /**
     * Obtiene una lista de Tipos de Producto del medio de persistencia
     * @return Lista de Tipos de Producto
     */
    public List<TipoProducto> getListTipoProducto(){
        TipoProductoBroker tipoProductoAdapter = new TipoProductoBroker();
        return tipoProductoAdapter.getList();
    }

    /**
     * Guarda una orden de trabajo
     * @param ordenDeTrabajo
     * @return devuelve verdadero si se guardo correctamente sino devuelve falso
     */
    public boolean saveOrdenDeTrabajo(OrdenDeTrabajo ordenDeTrabajo){
        OtBroker otBroker = new OtBroker();
        return otBroker.saveOT(ordenDeTrabajo);
    }
}