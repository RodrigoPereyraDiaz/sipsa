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
import sipsa.dominio.Pac;

/**
 * Capa de abstraccion para adaptar instancia de PAC de dominio a informacion de PAC en en medios de persistencia
 * @author Claudio Rodrigo Pereyra Diaz
 * @author Maria Eugenia Sanchez
 */
class PacBroker implements ISipsaBroker {

    public IPersistible existe(IPersistible o) throws SipsaExcepcion {
        Pac pac = (Pac) o;
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
        consulta.append("tipo = 0 ");
        try {
            ps = conn.prepareStatement(consulta.toString());

            ps.setString(1, pac.getCuit());

            rs = ps.executeQuery();
            if (rs.next()) {
                pac = (Pac) recuperar(new Pac(rs.getInt("id")));
            } else {
                pac = null;
            }
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new SipsaExcepcion("Error al verificar la existencia del Punto de Atención al Cliente");
        }
        return pac;
    }

    public void actualizar(IPersistible o) throws SipsaExcepcion {
        Pac pac = (Pac) o;
        Connection conn = DB.getConexion();
        PreparedStatement ps;
        StringBuilder consulta = new StringBuilder();
        consulta.append("UPDATE ");
        consulta.append("Empresas ");
        consulta.append("SET ");
        consulta.append("nombre = ? "); //nombre
        consulta.append("WHERE "); //id Autoincremental
        consulta.append("id = ? ");
        try {
            ps = conn.prepareStatement(consulta.toString());

            ps.setString(1, pac.getNombre());
            ps.setInt(2, pac.getID());

            ps.execute();
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new SipsaExcepcion("Error al actualizar el Punto de Atención al Cliente");
        }
    }

    public void guardar(IPersistible o) throws SipsaExcepcion {
        Pac pac = (Pac) o;
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
        consulta.append("0"); //tipo
        consulta.append(") ");
        try {
            ps = conn.prepareStatement(consulta.toString());

            ps.setString(1, pac.getCuit());
            ps.setString(2, pac.getNombre());

            ps.execute();
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new SipsaExcepcion("Error al guardar el Punto de Atención al Cliente");
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
            throw new SipsaExcepcion("Error al eliminar el Punto de Atención al Cliente id: " + o.getID());
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
        consulta.append("tipo = 0 ");
        try {
            ps = conn.prepareStatement(consulta.toString());
            rs = ps.executeQuery();
            while (rs.next()) {
                Pac pac = (Pac) recuperar(new Pac(rs.getInt("id")));
                lista.add(pac);
            }
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new SipsaExcepcion("Error al recuperar la lista de Puntos de Ateción al Cliente");
        }
        return lista;
    }

    public IPersistible recuperar(IPersistible o) throws SipsaExcepcion {
        Pac pac = (Pac) o;
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
        consulta.append("tipo = 0 ");
        try {
            ps = conn.prepareStatement(consulta.toString());

            ps.setInt(1, pac.getID());

            rs = ps.executeQuery();
            if (rs.next()) {
                pac.setCuit(rs.getString("cuit"));
                pac.setNombre(rs.getString("nombre"));
            }
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new SipsaExcepcion("Error al recuperar el Punto de Atención al Cliente id: " + o.getID());
        }
        return pac;
    }
}