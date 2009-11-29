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
import sipsa.dominio.Fabrica;

class FabricaBroker implements ISipsaBroker {

    public IPersistible existe(IPersistible o) throws SipsaExcepcion {
        Fabrica fabrica = (Fabrica) o;
        Connection conn = DB.getConexion();
        PreparedStatement ps;
        ResultSet rs;
        StringBuilder consulta = new StringBuilder();
        consulta.append("SELECT ");
        consulta.append("id ");
        consulta.append("FROM ");
        consulta.append("Fabricas ");
        consulta.append("WHERE ");
        consulta.append("nombre = ? ");
        try {
            ps = conn.prepareStatement(consulta.toString());

            ps.setString(1, fabrica.getNombre());

            rs = ps.executeQuery();
            if (rs.next()) {
                fabrica = new Fabrica(rs.getInt("id"));
                fabrica = (Fabrica) recuperar(fabrica);
            } else {
                fabrica = null;
            }
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new SipsaExcepcion("Error al verificar la existencia de la Fabrica");
        }
        return fabrica;
    }

    public void actualizar(IPersistible o) throws SipsaExcepcion {
        Fabrica fabrica = (Fabrica) o;
        Connection conn = DB.getConexion();
        PreparedStatement ps;
        StringBuilder consulta = new StringBuilder();
        consulta.append("UPDATE ");
        consulta.append("Fabrica ");
        consulta.append("SET ");
        consulta.append("nombre = ? "); //nombre
        consulta.append("WHERE ");
        consulta.append("id = ? ");
        try {
            ps = conn.prepareStatement(consulta.toString());

            ps.setString(1, fabrica.getNombre());
            ps.setInt(2, fabrica.getID());

            ps.execute();
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new SipsaExcepcion("Error al actualizar la Fabrica");
        }
    }

    public void guardar(IPersistible o) throws SipsaExcepcion {
        Fabrica fabrica = (Fabrica) o;
        Connection conn = DB.getConexion();
        PreparedStatement ps;
        StringBuilder consulta = new StringBuilder();
        consulta.append("INSERT ");
        consulta.append("INTO ");
        consulta.append("Fabrica ");
        consulta.append("VALUES ( ");
        consulta.append("default "); //id Autoincremental
        consulta.append("? "); //nombre
        consulta.append(") ");
        try {
            ps = conn.prepareStatement(consulta.toString());

            ps.setString(2, fabrica.getNombre());

            ps.execute();
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new SipsaExcepcion("Error al guardar la Fabrica");
        }
    }

    public void eliminar(IPersistible o) throws SipsaExcepcion {
        Connection conn = DB.getConexion();
        PreparedStatement ps;
        StringBuilder consulta = new StringBuilder();
        consulta.append("DELETE ");
        consulta.append("FROM ");
        consulta.append("Fabrica ");
        consulta.append("WHERE ");
        consulta.append("id = ? ");
        try {
            ps = conn.prepareStatement(consulta.toString());

            ps.setInt(1, o.getID());

            ps.execute();
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new SipsaExcepcion("Error al eliminar la Fabrica id: " + o.getID());
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
        consulta.append("Fabricas ");
        try {
            ps = conn.prepareStatement(consulta.toString());
            rs = ps.executeQuery();
            while (rs.next()) {
                Fabrica fabrica = (Fabrica) recuperar(new Fabrica(rs.getInt("id")));
                lista.add(fabrica);
            }
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new SipsaExcepcion("Error al recuperar la lista de Fabricas");
        }
        return lista;
    }

    public IPersistible recuperar(IPersistible o) throws SipsaExcepcion {
        Fabrica fabrica = (Fabrica) o;
        Connection conn = DB.getConexion();
        PreparedStatement ps;
        ResultSet rs;
        StringBuilder consulta = new StringBuilder();
        consulta.append("SELECT ");
        consulta.append("nombre ");
        consulta.append("FROM ");
        consulta.append("Fabricas ");
        consulta.append("WHERE ");
        consulta.append("id = ? ");
        try {
            ps = conn.prepareStatement(consulta.toString());

            ps.setInt(1, o.getID());

            rs = ps.executeQuery();
            if (rs.next()) {
                fabrica.setNombre(rs.getString("nombre"));
            }
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new SipsaExcepcion("Error al recuperar la Fabrica id: " + o.getID());
        }
        return fabrica;
    }
}
