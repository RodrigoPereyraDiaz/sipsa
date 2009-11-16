/*
 * Sistemas de Informacion II 2009
 * Proyecto Sipsa
 */

package sipsa.persistencia;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;
import java.util.ArrayList;

import sipsa.SipsaExcepcion;
import sipsa.dominio.Producto;

/**
 * Capa de abstraccion para adaptar instancia de Producto de dominio a informacion de Producto en en medios de persistencia
 * @author Claudio Rodrigo Pereyra Diaz
 * @author Maria Eugenia Sanchez
 */
class ProductoBroker implements ISipsaBroker{

    /**
     * Obtiene una Prdocuto desde el una base de datos
     * @param id Identificador unico de Producto
     * @return Instancia de Producto
     */
    protected Producto getProducto(int id){
        Producto producto = new Producto(id);
        Connection conn = DB.getConexion();
        PreparedStatement ps;
        ResultSet rs;
        StringBuilder consulta = new StringBuilder();
        consulta.append("SELECT ");
        consulta.append("nroSerie ");
        consulta.append(", ");
        consulta.append("idModelo ");
        consulta.append(", ");
        consulta.append("idFabrica ");
        consulta.append(", ");
        consulta.append("fechaFabricacion ");
        consulta.append("FROM ");
        consulta.append("Productos ");
        consulta.append("WHERE ");
        consulta.append("id = ? ");
        try {
            ps = conn.prepareStatement(consulta.toString());

            ps.setInt(1, id);
            //TODO definiar ModeloBroker y FabricaBroker para cargar el producto
            rs = ps.executeQuery();
            if (rs.next()) {
                producto.setNroSerie(rs.getString("nroSerie"));
                ModeloBroker modeloBroker = new ModeloBroker();
                producto.setModelo(modeloBroker.getModelo(rs.getInt("idmodelo")));
                FabricaBroker fabricaBroker = new FabricaBroker();
                producto.setFabrica(fabricaBroker.getFabrica(rs.getInt("idfabrica")));
                producto.setFechaFabricacion(rs.getDate("fechaFabricacion"));
            }
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return producto;
    }

    /**
     * Guarda un Producto en una base de datos
     * @param producto Producto a guardar
     * @return Resultado de la operacion
     */
    protected boolean saveProducto(Producto producto){
        Connection conn = DB.getConexion();
        PreparedStatement ps;
        StringBuilder consulta = new StringBuilder();
        consulta.append("INSERT ");
        consulta.append("INTO ");
        consulta.append("Productos ");
        consulta.append("VALUES ( ");
        consulta.append("default "); //id Autoincremental
        consulta.append(", ");
        consulta.append("? "); //nroSerie
        consulta.append(", ");
        consulta.append("? "); //idModelo
        consulta.append(", ");
        consulta.append("? "); //idFabrica
        consulta.append(", ");
        consulta.append("1"); //fechaFabricacion
        consulta.append(") ");
        try {
            ps = conn.prepareStatement(consulta.toString());

            ps.setString(1, producto.getNroSerie());
            ps.setInt(2, producto.getModelo().getID());
            ps.setInt(3, producto.getFabrica().getID());
            ps.setDate(4,(Date) producto.getFechaFabricacion());
            
            ps.execute();
            ps.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    /**
     * Elimina un Producto de la base de datos
     * @param producto Producto a eliminar
     * @return Resultado de la operacion
     */
    protected boolean deleteProducto(Producto producto){
        Connection conn = DB.getConexion();
        PreparedStatement ps;
        StringBuilder consulta = new StringBuilder();
        consulta.append("DELETE ");
        consulta.append("FROM ");
        consulta.append("Productos ");
        consulta.append("WHERE ");
        consulta.append("id = ? ");
        try {
            ps = conn.prepareStatement(consulta.toString());
            ps.setInt(1, producto.getID());
            ps.execute();
            ps.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }    }

    /**
     * Verificar la existencia de un Producto en la base de datos
     * @param producto Producto a verificar
     * @return Existencia del Producto
     */
    protected Producto exist(Producto producto){
        Connection conn = DB.getConexion();
        PreparedStatement ps;
        ResultSet rs;
        StringBuilder consulta = new StringBuilder();
        consulta.append("SELECT ");
        consulta.append("id ");
        consulta.append("FROM ");
        consulta.append("Productos ");
        consulta.append("WHERE ");
        consulta.append("idModelo = ? ");
        consulta.append("AND ");
        consulta.append("nroSerie = ? ");
        try {
            ps = conn.prepareStatement(consulta.toString());

            ps.setInt(1, producto.getModelo().getID());
            ps.setString(2, producto.getNroSerie());

            rs = ps.executeQuery();
            if (rs.next()){
                producto = getProducto(rs.getInt("id"));
            } else {
                producto = null;
            }
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return producto;
    }

    /**
     * Obtiene una lista de Productos de la base de datos
     * @return Lista de Productos
     */
    protected List<Producto> getList(){
        List<Producto> lista = new ArrayList<Producto>();
        Connection conn = DB.getConexion();
        PreparedStatement ps;
        ResultSet rs;
        StringBuilder consulta = new StringBuilder();
        consulta.append("SELECT ");
        consulta.append("id ");
        consulta.append("FROM ");
        consulta.append("Productos ");
        try {
            ps = conn.prepareStatement(consulta.toString());
            rs = ps.executeQuery();
            while (rs.next()) {
                Producto producto = getProducto(rs.getInt("id"));
                lista.add(producto);
            }
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    public IPersistible existe(IPersistible o) throws SipsaExcepcion {
        Producto producto = (Producto) o;
        Connection conn = DB.getConexion();
        PreparedStatement ps;
        ResultSet rs;
        StringBuilder consulta = new StringBuilder();
        consulta.append("SELECT ");
        consulta.append("id ");
        consulta.append("FROM ");
        consulta.append("Productos ");
        consulta.append("WHERE ");
        consulta.append("idModelo = ? ");
        consulta.append("AND ");
        consulta.append("nroSerie = ? ");
        try {
            ps = conn.prepareStatement(consulta.toString());

            ps.setInt(1, producto.getModelo().getID());
            ps.setString(2, producto.getNroSerie());

            rs = ps.executeQuery();
            if (rs.next()){
                producto = getProducto(rs.getInt("id"));
            } else {
                producto = null;
            }
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new SipsaExcepcion("No se pudo determinar la existencia del Punto de Atención al Cliente");
        }
        return producto;
    }

    public boolean actualizar(IPersistible o) throws SipsaExcepcion {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean guardar(IPersistible o) throws SipsaExcepcion {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean eliminar(IPersistible o) throws SipsaExcepcion {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<IPersistible> recuperarLista() throws SipsaExcepcion {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public IPersistible recuperar(IPersistible o) throws SipsaExcepcion {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}