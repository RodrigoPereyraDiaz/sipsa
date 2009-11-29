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
import sipsa.dominio.Pv;

/**
 * Capa de abstraccion para adaptar instancia de PV de dominio a informacion de PV en en medios de persistencia
 * @author Claudio Rodrigo Pereyra Diaz
 * @author Maria Eugenia Sanchez
 */
class PvBroker implements ISipsaBroker {

    public IPersistible existe(IPersistible o) throws SipsaExcepcion {
        Pv pv = (Pv) o;
        Connection conn = DB.getConexion();
        PreparedStatement ps;
        ResultSet rs;
        StringBuilder consulta = new StringBuilder();
        consulta.append("SELECT ");
        consulta.append("id ");
        consulta.append("FROM ");
        consulta.append("Empresas ");
        consulta.append("WHERE ");
        consulta.append("cuit = ? ");
        consulta.append("AND ");
        consulta.append("tipo = 1 ");
        try {
            ps = conn.prepareStatement(consulta.toString());

            ps.setString(1, pv.getCuit());

            rs = ps.executeQuery();
            if (rs.next()) {
                pv = new Pv(rs.getInt("id"));
                pv = (Pv) recuperar(pv);
            } else {
                pv = null;
            }
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new SipsaExcepcion("Error al verificar la existencia del Punto de Venta");
        }
        return pv;
    }

    public void actualizar(IPersistible o) throws SipsaExcepcion {
        Pv pv = (Pv) o;
        Connection conn = DB.getConexion();
        PreparedStatement ps;
        StringBuilder consulta = new StringBuilder();
        consulta.append("UPDATE ");
        consulta.append("Empresas ");
        consulta.append("SET ");
        consulta.append("cuit = ? "); //cuit
        consulta.append(", ");
        consulta.append("nombre = ? "); //nombre
        consulta.append("WHERE "); //id Autoincremental
        consulta.append("id = ? ");
        try {
            ps = conn.prepareStatement(consulta.toString());

            ps.setString(1, pv.getCuit());
            ps.setString(2, pv.getNombre());
            ps.setInt(1, pv.getID());

            ps.execute();
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new SipsaExcepcion("Error al actualizar el Punto de Venta");
        }
    }

    public void guardar(IPersistible o) throws SipsaExcepcion {
        Pv pv = (Pv) o;
        Connection conn = DB.getConexion();
        PreparedStatement ps;
        StringBuilder consulta = new StringBuilder();
        consulta.append("INSERT ");
        consulta.append("INTO ");
        consulta.append("Empresas ");
        consulta.append("VALUES ( ");
        consulta.append("default "); //id Autoincremental
        consulta.append(", ");
        consulta.append("? "); //cuit
        consulta.append(", ");
        consulta.append("? "); //nombre
        consulta.append(", ");
        consulta.append("1"); //tipo
        consulta.append(") ");
        try {
            ps = conn.prepareStatement(consulta.toString());

            ps.setString(1, pv.getCuit());
            ps.setString(2, pv.getNombre());

            ps.execute();
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new SipsaExcepcion("Error al guardar el Punto de Venta");
        }
    }

    public void eliminar(IPersistible o) throws SipsaExcepcion {
        Connection conn = DB.getConexion();
        PreparedStatement ps;
        StringBuilder consulta = new StringBuilder();
        consulta.append("DELETE ");
        consulta.append("FROM ");
        consulta.append("Empresas ");
        consulta.append("WHERE ");
        consulta.append("id = ? ");
        try {
            ps = conn.prepareStatement(consulta.toString());
            ps.setInt(1, o.getID());
            ps.execute();
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new SipsaExcepcion("Error al eliminar el Tipo de Producto id: " + o.getID());
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
        consulta.append("Empresas ");
        consulta.append("WHERE ");
        consulta.append("tipo = 1 ");
        try {
            ps = conn.prepareStatement(consulta.toString());
            rs = ps.executeQuery();
            while (rs.next()) {
                Pv pv = new Pv(rs.getInt("id"));
                pv = (Pv) recuperar(pv);
                lista.add(pv);
            }
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new SipsaExcepcion("Error al recuperar la lista de Puntos de Venta");
        }
        return lista;
    }

    public IPersistible recuperar(IPersistible o) throws SipsaExcepcion {
        Pv pv = (Pv) o;
        Connection conn = DB.getConexion();
        PreparedStatement ps;
        ResultSet rs;
        StringBuilder consulta = new StringBuilder();
        consulta.append("SELECT ");
        consulta.append("cuit ");
        consulta.append(", ");
        consulta.append("nombre ");
        consulta.append("FROM ");
        consulta.append("Empresas ");
        consulta.append("WHERE ");
        consulta.append("id = ? ");
        consulta.append(" AND ");
        consulta.append("tipo = 1 ");
        try {
            ps = conn.prepareStatement(consulta.toString());

            ps.setInt(1, pv.getID());

            rs = ps.executeQuery();
            if (rs.next()) {
                pv.setCuit(rs.getString("cuit"));
                pv.setNombre(rs.getString("nombre"));
            }
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new SipsaExcepcion("Error al recuperar el Punto de Venta id: " + o.getID());
        }
        return pv;
    }
}
