/*
 * Sistemas de Informacion II 2009
 * Proyecto Sipsa
 */
package sipsa.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sipsa.SipsaExcepcion;
import sipsa.dominio.Producto;
import sipsa.dominio.Pv;
import sipsa.dominio.Venta;

class VentaBroker implements ISipsaBroker {

    public IPersistible existe(IPersistible o) throws SipsaExcepcion {
        Venta venta = (Venta) o;
        Connection conn = DB.getConexion();
        PreparedStatement ps;
        ResultSet rs;
        StringBuilder consulta = new StringBuilder();
        consulta.append("SELECT ");
        consulta.append("id ");
        consulta.append("FROM ");
        consulta.append("Ventas ");
        consulta.append("WHERE ");
        consulta.append("idProducto = ? ");
        try {
            ps = conn.prepareStatement(consulta.toString());

            ps.setInt(1, venta.getProducto().getID());

            rs = ps.executeQuery();
            if (rs.next()) {
                venta = new Venta(rs.getInt("id"));
                venta = (Venta) recuperar(venta);
            } else {
                venta = null;
            }
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new SipsaExcepcion("Error al verificar la existencia de la Venta");
        }
        return venta;
    }

    public void actualizar(IPersistible o) throws SipsaExcepcion {
        Venta venta = (Venta) o;
        Connection conn = DB.getConexion();
        PreparedStatement ps;
        StringBuilder consulta = new StringBuilder();
        consulta.append("UPDATE ");
        consulta.append("Ventas ");
        consulta.append("SET ");
        consulta.append("idPv = ? "); //idPv
        consulta.append(", ");
        consulta.append("idProducto = ? "); //idProducto
        consulta.append(", ");
        consulta.append("nroFactura = ? "); //nroFactura
        consulta.append(", ");
        consulta.append("fechaFactura = ? "); //fechaFactura
        consulta.append("WHERE ");
        consulta.append("id = ? ");
        try {
            ps = conn.prepareStatement(consulta.toString());

            ps.setInt(1, venta.getEmpresaVendedora().getID());
            ps.setInt(2, venta.getProducto().getID());
            ps.setString(3, venta.getNroFactura());
            ps.setDate(4, new Date(venta.getFechaFactura().getTime()));
            ps.setInt(5, venta.getID());

            ps.execute();
            ps.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new SipsaExcepcion("Error al actualizar la Venta");
        }
    }

    public void guardar(IPersistible o) throws SipsaExcepcion {
        Venta venta = (Venta) o;
        Connection conn = DB.getConexion();
        PreparedStatement ps;
        StringBuilder consulta = new StringBuilder();
        consulta.append("INSERT ");
        consulta.append("INTO ");
        consulta.append("Ventas ");
        consulta.append("VALUES ( ");
        consulta.append("default "); //id Autoincremental
        consulta.append(", ");
        consulta.append("? "); //idPv
        consulta.append(", ");
        consulta.append("? "); //idProducto
        consulta.append(", ");
        consulta.append("? "); //nroFactura
        consulta.append(", ");
        consulta.append("? "); //FechaFactura
        consulta.append(") ");
        try {
            ps = conn.prepareStatement(consulta.toString());

            ps.setInt(1, venta.getEmpresaVendedora().getID());
            ps.setInt(2, venta.getProducto().getID());
            ps.setString(3, venta.getNroFactura());
            ps.setDate(4, new Date(venta.getFechaFactura().getTime()));

            ps.execute();
            ps.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new SipsaExcepcion("Error al guardar la Venta");
        }
    }

    public void eliminar(IPersistible o) throws SipsaExcepcion {
        Connection conn = DB.getConexion();
        PreparedStatement ps;
        StringBuilder consulta = new StringBuilder();
        consulta.append("DELETE ");
        consulta.append("FROM ");
        consulta.append("Ventas ");
        consulta.append("WHERE ");
        consulta.append("id = ? ");
        try {
            ps = conn.prepareStatement(consulta.toString());

            ps.setInt(1, o.getID());

            ps.execute();
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new SipsaExcepcion("Error al eliminar la Venta id: " + o.getID());
        }
    }

    public IPersistible recuperar(IPersistible o) throws SipsaExcepcion {
        Venta venta = (Venta) o;
        Connection conn = DB.getConexion();
        PreparedStatement ps;
        ResultSet rs;
        StringBuilder consulta = new StringBuilder();
        consulta.append("SELECT ");
        consulta.append("id ");
        consulta.append(", ");
        consulta.append("idPv ");
        consulta.append(", ");
        consulta.append("idProducto ");
        consulta.append(", ");
        consulta.append("nroFactura ");
        consulta.append(", ");
        consulta.append("fechaFactura ");
        consulta.append("FROM ");
        consulta.append("Ventas ");
        consulta.append("WHERE ");
        consulta.append("id = ? ");
        try {
            ps = conn.prepareStatement(consulta.toString());

            ps.setInt(1, venta.getID());

            rs = ps.executeQuery();
            if (rs.next()) {
                PvBroker pvBroker = new PvBroker();
                Pv pv = new Pv(rs.getInt("idPv"));
                pv = (Pv) pvBroker.recuperar(pv);
                venta.setEmpresaVendedora(pv);
                ProductoBroker productoBroker = new ProductoBroker();
                Producto producto = new Producto(rs.getInt("idProducto"));
                producto = (Producto) productoBroker.recuperar(producto);
                venta.setProducto(producto);
                venta.setNroFactura(rs.getString("nroFactura"));
                venta.setFechaFactura(rs.getDate("fechaFactura"));
            }
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new SipsaExcepcion("Error al recuperar la Venta id: " + o.getID());
        }
        return venta;
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
        consulta.append("Ventas ");
        try {
            ps = conn.prepareStatement(consulta.toString());
            rs = ps.executeQuery();
            while (rs.next()) {
                Venta venta = new Venta(rs.getInt("id"));
                venta = (Venta) recuperar(venta);
                lista.add(venta);
            }
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new SipsaExcepcion("Error al recuperar la lista de Ventas");
        }
        return lista;
    }
}
