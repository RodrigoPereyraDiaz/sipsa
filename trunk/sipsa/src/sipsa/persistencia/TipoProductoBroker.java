/*
 * Sistemas de Informacion II 2009
 * Proyecto Sipsa
 */
package sipsa.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sipsa.SipsaExcepcion;
import sipsa.dominio.TipoProducto;

/**
 * Capa de abstraccion para adaptar instancia de Tipo de Producto de dominio a informacion de Tipo de Producto en en medios de persistencia
 * @author Claudio Rodrigo Pereyra Diaz
 * @author Maria Eugenia Sanchez
 */
class TipoProductoBroker implements ISipsaBroker {

    public IPersistible existe(IPersistible o) throws SipsaExcepcion {
        TipoProducto tipoProducto = (TipoProducto) o;
        Connection conn = DB.getConexion();
        PreparedStatement ps;
        ResultSet rs;
        StringBuilder consulta = new StringBuilder();
        consulta.append("SELECT ");
        consulta.append("id ");
        consulta.append("FROM ");
        consulta.append("TiposProducto ");
        consulta.append("WHERE ");
        consulta.append("descripcion = ? ");
        try {
            ps = conn.prepareStatement(consulta.toString());

            ps.setString(1, tipoProducto.getDescripcion());

            rs = ps.executeQuery();
            if (rs.next()) {
                tipoProducto = new TipoProducto(rs.getInt("id"));
                tipoProducto = (TipoProducto) recuperar(tipoProducto);
            } else {
                tipoProducto = null;
            }
            ps.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new SipsaExcepcion("Error al verificar la existencia del Tipo de Producto");
        }
        return tipoProducto;
    }

    public void actualizar(IPersistible o) throws SipsaExcepcion {
        //TODO definiar actualizacion de Tipo de Producto
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void guardar(IPersistible o) throws SipsaExcepcion {
        TipoProducto tipoProducto = (TipoProducto) o;
        Connection conn = DB.getConexion();
        PreparedStatement ps;
        StringBuilder consulta = new StringBuilder();
        consulta.append("INSERT ");
        consulta.append("INTO ");
        consulta.append("TiposProducto ");
        consulta.append("VALUES ( ");
        consulta.append("default "); //id Autoincremental
        consulta.append(", ");
        consulta.append("? "); //descripcion
        consulta.append(", ");
        consulta.append("? "); //duracionGarantia
        consulta.append(") ");
        try {
            ps = conn.prepareStatement(consulta.toString());

            ps.setString(1, tipoProducto.getDescripcion());
            ps.setInt(2, tipoProducto.getDuracionGarantia());

            ps.execute();
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new SipsaExcepcion("Error al guardar el Tipo de Producto");
        }
    }

    public void eliminar(IPersistible o) throws SipsaExcepcion {
        TipoProducto tipoProducto = (TipoProducto) o;
        Connection conn = DB.getConexion();
        PreparedStatement ps;
        StringBuilder consulta = new StringBuilder();
        consulta.append("DELETE ");
        consulta.append("FROM ");
        consulta.append("TiposProducto ");
        consulta.append("WHERE ");
        consulta.append("id = ? ");
        try {
            ps = conn.prepareStatement(consulta.toString());

            ps.setInt(1, tipoProducto.getID());

            ps.execute();
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new SipsaExcepcion("Error al eliminar el Tipo de Producto id: " + o.getID());
        }
    }

    public IPersistible recuperar(IPersistible o) throws SipsaExcepcion {
        TipoProducto tipoProducto = (TipoProducto) o;
        Connection conn = DB.getConexion();
        PreparedStatement ps;
        ResultSet rs;
        StringBuilder consulta = new StringBuilder();
        consulta.append("SELECT ");
        consulta.append("nombre ");
        consulta.append(", ");
        consulta.append("duracionGarantia ");
        consulta.append("FROM ");
        consulta.append("TiposProducto ");
        consulta.append("WHERE ");
        consulta.append("id = ? ");
        try {
            ps = conn.prepareStatement(consulta.toString());

            ps.setInt(1, tipoProducto.getID());

            rs = ps.executeQuery();
            if (rs.next()) {
                tipoProducto.setDescripcion(rs.getString("nombre"));
                tipoProducto.setDuracionGarantia(rs.getInt("duracionGarantia"));
                ModeloBroker modeloBroker = new ModeloBroker();
                tipoProducto.setModelos(modeloBroker.recuperarLista(tipoProducto));
            }
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new SipsaExcepcion("Error al recuperar el Tipo de Producto id: " + o.getID());
        }
        return tipoProducto;
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
        consulta.append("TiposProducto ");
        try {
            ps = conn.prepareStatement(consulta.toString());
            rs = ps.executeQuery();
            while (rs.next()) {
                TipoProducto tipoProducto = new TipoProducto(rs.getInt("id"));
                tipoProducto = (TipoProducto) recuperar(tipoProducto);
                lista.add(tipoProducto);
            }
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new SipsaExcepcion("Error al recuperar la lista de Tipos de Producto");
        }
        return lista;
    }
}