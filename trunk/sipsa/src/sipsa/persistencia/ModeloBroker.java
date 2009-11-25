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
import sipsa.dominio.Modelo;
import sipsa.dominio.TipoProducto;

class ModeloBroker implements ISipsaBroker {

    public IPersistible existe(IPersistible o) throws SipsaExcepcion {
        Modelo modelo = (Modelo) o;
        Connection conn = DB.getConexion();
        PreparedStatement ps;
        ResultSet rs;
        StringBuilder consulta = new StringBuilder();
        consulta.append("SELECT ");
        consulta.append("id ");
        consulta.append("FROM ");
        consulta.append("Modelos ");
        consulta.append("WHERE ");
        consulta.append("idTipoProducto = ? ");
        consulta.append("AND ");
        consulta.append("nombre = ? ");
        try {
            ps = conn.prepareStatement(consulta.toString());

            ps.setInt(1, modelo.getTipoProducto().getID());
            ps.setString(2, modelo.getNombre());

            rs = ps.executeQuery();
            if (rs.next()) {
                modelo = new Modelo(rs.getInt("id"));
                modelo = (Modelo) recuperar(modelo);
            } else {
                modelo = null;
            }
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new SipsaExcepcion("Error al verificar la existencia del Modelo");
        }
        return modelo;
    }

    public void actualizar(IPersistible o) throws SipsaExcepcion {
        Modelo modelo = (Modelo) o;
        Connection conn = DB.getConexion();
        PreparedStatement ps;
        StringBuilder consulta = new StringBuilder();
        consulta.append("UPDATE ");
        consulta.append("Modelos ");
        consulta.append("SET ");
        consulta.append("idTipoProducto = ? "); //idTipoProducto
        consulta.append(", ");
        consulta.append("nombre = ? "); //nombre
        consulta.append("WHERE ");
        consulta.append("id = ? ");

        try {
            ps = conn.prepareStatement(consulta.toString());

            ps.setInt(1, modelo.getTipoProducto().getID());
            ps.setString(2, modelo.getNombre());
            ps.setInt(3, modelo.getID());

            ps.execute();
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new SipsaExcepcion("Error al actualizar el Modelo");
        }
    }

    public void guardar(IPersistible o) throws SipsaExcepcion {
        Modelo modelo = (Modelo) o;
        Connection conn = DB.getConexion();
        PreparedStatement ps;
        StringBuilder consulta = new StringBuilder();
        consulta.append("INSERT ");
        consulta.append("INTO ");
        consulta.append("Modelos ");
        consulta.append("VALUES ( ");
        consulta.append("default "); //id Autoincremental
        consulta.append(", ");
        consulta.append("? "); //idTipoProducto
        consulta.append(", ");
        consulta.append("? "); //nombre
        consulta.append(") ");
        try {
            ps = conn.prepareStatement(consulta.toString());

            ps.setInt(1, modelo.getTipoProducto().getID());
            ps.setString(2, modelo.getNombre());

            ps.execute();
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new SipsaExcepcion("Error al guardar el Modelo");
        }
    }

    public void eliminar(IPersistible o) throws SipsaExcepcion {
        Connection conn = DB.getConexion();
        PreparedStatement ps;
        StringBuilder consulta = new StringBuilder();
        consulta.append("DELETE ");
        consulta.append("FROM ");
        consulta.append("Modelos ");
        consulta.append("WHERE ");
        consulta.append("id = ? ");
        try {
            ps = conn.prepareStatement(consulta.toString());

            ps.setInt(1, o.getID());

            ps.execute();
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new SipsaExcepcion("Error al eliminar el Modelo id: " + o.getID());
        }
    }

    public IPersistible recuperar(IPersistible o) throws SipsaExcepcion {
        Modelo modelo = (Modelo) o;
        Connection conn = DB.getConexion();
        PreparedStatement ps;
        ResultSet rs;
        StringBuilder consulta = new StringBuilder();
        consulta.append("SELECT ");
        consulta.append("nombre ");
        consulta.append("FROM ");
        consulta.append("Modelos ");
        consulta.append("WHERE ");
        consulta.append("id = ? ");
        try {
            ps = conn.prepareStatement(consulta.toString());

            ps.setInt(1, modelo.getID());

            rs = ps.executeQuery();
            if (rs.next()) {
                modelo.setNombre(rs.getString("nombre"));
            }
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new SipsaExcepcion("Error al recuperar el Modelo id: " + o.getID());
        }
        return modelo;
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
        consulta.append("Modelos ");
        try {
            ps = conn.prepareStatement(consulta.toString());
            rs = ps.executeQuery();

            while (rs.next()) {
                Modelo modelo = new Modelo(rs.getInt("id"));
                modelo = (Modelo) recuperar(modelo);
                lista.add(modelo);
            }
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new SipsaExcepcion("Error al recuperar la lista de Modelos");
        }
        return lista;
    }

    public List<Modelo> recuperarLista(TipoProducto tipoProducto) throws SipsaExcepcion {
        List<Modelo> lista = new ArrayList<Modelo>();
        Connection conn = DB.getConexion();
        PreparedStatement ps;
        ResultSet rs;
        StringBuilder consulta = new StringBuilder();
        consulta.append("SELECT ");
        consulta.append("id ");
        consulta.append("FROM ");
        consulta.append("Modelos ");
        consulta.append("WHERE ");
        consulta.append("idTipoProducto = ? ");
        try {
            ps = conn.prepareStatement(consulta.toString());

            ps.setInt(1, tipoProducto.getID());

            rs = ps.executeQuery();
            while (rs.next()) {
                Modelo modelo = new Modelo(rs.getInt("id"));
                modelo = (Modelo) recuperar(modelo);
                lista.add(modelo);
            }
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new SipsaExcepcion("Error al recuperar la lista de Modelos del Tipo de Producto id: " + tipoProducto.getID());
        }
        return lista;
    }
}