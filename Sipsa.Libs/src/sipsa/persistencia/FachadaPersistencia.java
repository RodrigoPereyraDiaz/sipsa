/*
 * Sistemas de Informacion II 2009
 * Proyecto Sipsa
 */

package sipsa.persistencia;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import sipsa.dominio.*;

/**
 * Punto de acceso a los medios de persistencia
 * @author Claudio Rodrigo Pereyra Diaz
 * @author Maria Eugenia Sanchez
 */
public class FachadaPersistencia {

    ///Fachada de la persistencia de Pac

    /**
     * Obtiene del medio de persistencia el PAC identificado
     * @param id identificador unico de PAC
     * @return Instancia del PAC
     */
    public Pac getPac(String id) {
        PacAdapter pacAdapter = new PacAdapter();
        return pacAdapter.getPac(id);
    }

    /**
     * Guarda el PAC en el medio de persistencia
     * @param pac PAC a guardar
     * @return Resultado de la operacion persistencia
     */
    public boolean savePac(Pac pac){
        PacAdapter pacAdapter = new PacAdapter();
        return pacAdapter.savePac(pac);
    }
    
    /**
     * Elimina un PAC del medio de persistencia
     * @param pac PAC a eliminar
     * @return Resultado de la operacion de persistencia
     */
    public boolean deletePac(Pac pac){
        PacAdapter pacAdapter = new PacAdapter();
        return pacAdapter.deletePac(pac);
    }

    /**
     * Verifica la existencia de un PAC en el medio de persistencia
     * @param pac PAC a verificar
     * @return Existencia del PAC
     */
    public boolean existPac(Pac pac){
        PacAdapter pacAdapter = new PacAdapter();
        return pacAdapter.exist(pac);
    }

    /**
     * Obtiene una lista de los PAC existentes en el medio e persistencia
     * @return Lista de PACs
     */
    public ArrayList<Pac> getListPac(){
        PacAdapter pacAdapter = new PacAdapter();
        return pacAdapter.getList();
    }

    ///Fachada de la persistencia de Pv

    /**
     * Obtiene del medio de persistencia el PV identificado
     * @param id Identificador unico de PV
     * @return Instancia de PV
     */
    public Pv getPV(String id){
        PvAdapter pvAdapter = new PvAdapter();
        return pvAdapter.getPv(id);
    }

    /**
     * Guarda el PV en el medio de persistencia
     * @param pv PV a guardar
     * @return Resultado de la operacion de persistencia
     */
    public boolean savePv(Pv pv){
        PvAdapter pvAdapter = new PvAdapter();
        return pvAdapter.savePv(pv);
    }

    /**
     * Elimina un PV del medio de persistencia
     * @param pv PV a eliminar
     * @return Resultado de la operacion de persistencia
     */
    public boolean deletePv(Pv pv){
        PvAdapter pvAdapter = new PvAdapter();
        return pvAdapter.deletePv(pv);
    }

    /**
     * Verifica la existencia de un PV en el medio de persistencia
     * @param pv PV a verificar existencia
     * @return Existencia del PV
     */
    public boolean existPv(Pv pv){
        PvAdapter pvAdapter = new PvAdapter();
        return pvAdapter.exist(pv);
    }

    /**
     * Obtiene una lista de PVs del medio de persistencia
     * @return Lista de PVs
     */
    public ArrayList<Pv> getListPv(){
        PvAdapter pvAdapter = new PvAdapter();
        return pvAdapter.getList();
    }

    ///Fachada de la persistencia de Producto

    /**
     * Obtiene del medio de persistencia el producto identificado
     * @param id Identificador unico de Producto
     * @return Intancia de Producto
     */
    public Producto getProducto(String id){
        ProductoAdapter productoAdapter = new ProductoAdapter();
        return productoAdapter.getProducto(id);
    }

    /**
     * Guarda un Producto en el medio de persistencia
     * @param producto Producto a Guardar
     * @return Resultado de la operacion de persistencia
     */
    public boolean saveProducto(Producto producto){
        ProductoAdapter productoAdapter = new ProductoAdapter();
        return productoAdapter.saveProducto(producto);
    }

    /**
     * Elimina un Producto del medio de persistencia
     * @param producto Producto a eliminar
     * @return Resultado de la operacion de persistencia
     */
    public boolean deleteProducto(Producto producto){
        ProductoAdapter productoAdapter = new ProductoAdapter();
        return productoAdapter.deleteProducto(producto);
    }

    /**
     * Verifica la existencia de un producto en el medio de persistencia
     * @param producto Producto a verificar
     * @return Existencia del producto
     */
    public boolean existProducto(Producto producto){
        ProductoAdapter productoAdapter = new ProductoAdapter();
        return productoAdapter.exist(producto);
    }

    /**
     * Obtiene una lista de Productos del medio de persistencia
     * @return Lista de Productos
     */
    public ArrayList<Producto> getListProductos(){
        ProductoAdapter productoAdapter = new ProductoAdapter();
        return productoAdapter.getList();
    }

    ///Fachada de la persistencia de Tipo de Producto

    /**
     * Obtiene del medio de persitencia el Tipo de Producto identificado
     * @param id Identificador unico de Tipo de Producto
     * @return Instancia de Tipo de Producto
     */
    public TipoProducto getTipoProducto(String id){
        TipoProductoAdapter tipoProductoAdapter = new TipoProductoAdapter();
        return tipoProductoAdapter.getTipoProducto(id);
    }

    /**
     * Guardar un Tipo de Producto en el medio de persistencia
     * @param tipoProducto Tipo de Producto a Guardar
     * @return Resultado de la operacion de persistencia
     */
    public boolean saveTipoProducto(TipoProducto tipoProducto){
        TipoProductoAdapter tipoProductoAdapter = new TipoProductoAdapter();
        return tipoProductoAdapter.saveTipoProducto(tipoProducto);
    }

    /**
     * Elimina un Tipo de Producto del medio de persistencia
     * @param tipoProducto Tipo de Producto a eliminar
     * @return Resultado del operacion de persistencia
     */
    public boolean deteletTipoProducto(TipoProducto tipoProducto){
        TipoProductoAdapter tipoProductoAdapter = new TipoProductoAdapter();
        return tipoProductoAdapter.deleteTipoProducto(tipoProducto);
    }

    /**
     * Verifica la existencia de un Tipo de Producto en el medio de persistencia
     * @param tipoProducto Tipo de Producto a verificar
     * @return Existencia del Tipo de Producto
     */
    public boolean existTipoProducto(TipoProducto tipoProducto){
        TipoProductoAdapter tipoProductoAdapter = new TipoProductoAdapter();
        return tipoProductoAdapter.exist(tipoProducto);
    }

    /**
     * Obtiene una lista de Tipos de Producto del medio de persistencia
     * @return Lista de Tipos de Producto
     */
    public ArrayList<TipoProducto> getListTipoProducto(){
        TipoProductoAdapter tipoProductoAdapter = new TipoProductoAdapter();
        return tipoProductoAdapter.getList();
    }

    /**
     * Importa Productos desde un archivo al medio de persistencia
     * @param pathFile Ruta absulta del archivo con los productos
     * @return Resultado de la operacion de importacion y persistencia
     * @throws java.io.IOException
     * @throws java.text.ParseException
     */
    //@TODO verfificar las exepciones
    public boolean importProductos(String pathFile) throws IOException, ParseException{
        ProductoAdapter productoAdapter = new ProductoAdapter();
        return productoAdapter.importarProductos(pathFile);
    }

}