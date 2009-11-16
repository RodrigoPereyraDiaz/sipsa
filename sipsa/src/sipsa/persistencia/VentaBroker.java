package sipsa.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import sipsa.SipsaExcepcion;
import sipsa.dominio.Venta;

class VentaBroker implements ISipsaBroker{

    protected Venta getVenta(int id){
        Venta venta = new Venta(id);
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
                venta.setEmpresaVendedora(pvBroker.getPv(rs.getInt("idPv")));
                ProductoBroker productoBroker = new ProductoBroker();
                venta.setProductos(productoBroker.getProducto(rs.getInt("idProducto")));
                venta.setNroFactura(rs.getString("nroFactura"));
                venta.setFechaFactura(rs.getDate("fechaFactura"));
            }
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return venta;
    }

    protected boolean saveVenta(Venta venta){
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
            ps.setInt(2, venta.getProductos().getID());
            ps.setString(3, venta.getNroFactura());
            ps.setDate(4,Date.valueOf(venta.getFechaFactura().toString()));

            ps.execute();
            ps.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    protected boolean deleteVenta(Venta venta){
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

            ps.setInt(1, venta.getID());

            ps.execute();
            ps.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    protected Venta exist(Venta venta){
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

            ps.setInt(1, venta.getProductos().getID());

            rs = ps.executeQuery();
            if (rs.next()){
                venta = this.getVenta(rs.getInt("id"));
            } else {
                venta = null;
            }

            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return venta;
    }

    protected List<Venta> getList(){
        List<Venta> lista = new ArrayList<Venta>();
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
            Venta venta = getVenta(rs.getInt("id"));
            lista.add(venta);
            }
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    public IPersistible existe(IPersistible o) throws SipsaExcepcion {
        throw new UnsupportedOperationException("Not supported yet.");
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

    public IPersistible recuperar(IPersistible o) throws SipsaExcepcion {
        throw new UnsupportedOperationException("Not supported yet.");
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
            Venta venta = getVenta(rs.getInt("id"));
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