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
import sipsa.dominio.Fabrica;
import sipsa.dominio.Modelo;
import sipsa.dominio.Producto;

/**
 * Capa de abstraccion para adaptar instancia de Producto de dominio a informacion de Producto en en medios de persistencia
 * @author Claudio Rodrigo Pereyra Diaz
 * @author Maria Eugenia Sanchez
 */
class ProductoBroker implements ISipsaBroker {

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
            if (rs.next()) {
                producto = new Producto(rs.getInt("id"));
                producto = (Producto) recuperar(producto);
            } else {
                producto = null;
            }
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new SipsaExcepcion("Error al verificar la existencia del Producto");
        }
        return producto;
    }

    public void actualizar(IPersistible o) throws SipsaExcepcion {
        //TODO definir actualizacion de Producto
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void guardar(IPersistible o) throws SipsaExcepcion {
        Producto producto = (Producto) o;
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
            ps.setDate(4, (Date) producto.getFechaFabricacion());

            ps.execute();
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new SipsaExcepcion("Error al guardar el Producto");
        }
    }

    public void eliminar(IPersistible o) throws SipsaExcepcion {
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
            ps.setInt(1, o.getID());
            ps.execute();
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new SipsaExcepcion("Error al eliminar el Producto id: " + o.getID());
        }
    }

    public List<IPersistible> recuperarLista() throws SipsaExcepcion {
        List<IPersistible> lista = new ArrayList<IPersistible>();
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
                Producto producto = new Producto(rs.getInt("id"));
                producto = (Producto) recuperar(producto);
                lista.add(producto);
            }
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new SipsaExcepcion("Error al recuperar la lista de Productos");
        }
        return lista;
    }

    public IPersistible recuperar(IPersistible o) throws SipsaExcepcion {
        Producto producto = (Producto) o;
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
            ps.setInt(1, producto.getID());
            rs = ps.executeQuery();
            if (rs.next()) {
                producto.setNroSerie(rs.getString("nroSerie"));
                ModeloBroker modeloBroker = new ModeloBroker();
                Modelo modelo = new Modelo(rs.getInt("idmodelo"));
                modelo = (Modelo) modeloBroker.recuperar(modelo);
                producto.setModelo(modelo);
                FabricaBroker fabricaBroker = new FabricaBroker();
                Fabrica fabrica = new Fabrica(rs.getInt("idfabrica"));
                fabrica = (Fabrica) fabricaBroker.recuperar(fabrica);
                producto.setFabrica(fabrica);
                producto.setFechaFabricacion(rs.getDate("fechaFabricacion"));
            }
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new SipsaExcepcion("Error al recuperar el Producto id: " + o.getID());
        }
        return producto;
    }
}