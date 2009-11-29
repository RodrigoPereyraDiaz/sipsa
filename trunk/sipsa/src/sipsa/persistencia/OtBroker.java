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
import sipsa.dominio.EstadoOT;
import sipsa.dominio.OrdenDeTrabajo;
import sipsa.dominio.Pac;
import sipsa.dominio.Venta;

class OtBroker implements ISipsaBroker {

    public IPersistible existe(IPersistible o) throws SipsaExcepcion {
        //Por defecto toda orden de trabajo es distinta de todas las demas, salvo que tenga un identificador
        OrdenDeTrabajo ordenDeTrabajo = (OrdenDeTrabajo) o;
        Connection conn = DB.getConexion();
        PreparedStatement ps;
        ResultSet rs;
        StringBuilder consulta = new StringBuilder();
        consulta.append("SELECT ");
        consulta.append("id ");
        consulta.append("FROM ");
        consulta.append("OrdenesDeTrabajo ");
        consulta.append("WHERE ");
        consulta.append("id = ? ");
        try {
            ps = conn.prepareStatement(consulta.toString());

            ps.setInt(1, ordenDeTrabajo.getID());

            rs = ps.executeQuery();
            if (rs.next()) {
                ordenDeTrabajo = new OrdenDeTrabajo(rs.getInt("id"));
                ordenDeTrabajo = (OrdenDeTrabajo) recuperar(ordenDeTrabajo);
            } else {
                ordenDeTrabajo = null;
            }
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new SipsaExcepcion("Error al verificar la existencia de la Orden de Trabajo");
        }
        return ordenDeTrabajo;
    }

    public void actualizar(IPersistible o) throws SipsaExcepcion {
        OrdenDeTrabajo ordenDeTrabajo = (OrdenDeTrabajo) o;
        Connection conn = DB.getConexion();
        PreparedStatement ps;
        StringBuilder consulta = new StringBuilder();
        consulta.append("UPDATE ");
        consulta.append("OrdenesDeTrabajo ");
        consulta.append("SET ");
        consulta.append("idPac = ? "); //idPac
        consulta.append(", ");
        consulta.append("idVenta = ? "); //idVenta
        consulta.append(", ");
        consulta.append("observacion = ? "); //observaciones
        consulta.append(", ");
        consulta.append("idEstado = ? "); //idEstado
        consulta.append(", ");
        consulta.append("motivoEstado = ? "); //motivoEstado
        consulta.append(", ");
        consulta.append("fechaEntrega = ? "); //fechaEntrega
        consulta.append("WHERE ");
        consulta.append("id = ? ");
        try {
            ps = conn.prepareStatement(consulta.toString());

            ps.setInt(1, ordenDeTrabajo.getPac().getID());
            ps.setInt(2, ordenDeTrabajo.getVenta().getID());
            ps.setString(3, ordenDeTrabajo.getObservaciones());
            ps.setInt(4, EstadoOT.toInt(ordenDeTrabajo.getEstado()));
            ps.setString(5, ordenDeTrabajo.getMotivoEstado());
            ps.setDate(6, new Date(ordenDeTrabajo.getFechaEntrega().getTime()));
            ps.setInt(7, ordenDeTrabajo.getID());

            ps.execute();
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new SipsaExcepcion("Error al actualizar la Orden de Trabajo");
        }
    }

    public void guardar(IPersistible o) throws SipsaExcepcion {
        OrdenDeTrabajo ordenDeTrabajo = (OrdenDeTrabajo) o;
        Connection conn = DB.getConexion();
        PreparedStatement ps;
        StringBuilder consulta = new StringBuilder();
        consulta.append("INSERT ");
        consulta.append("INTO ");
        consulta.append("OrdenesDeTrabajo ");
        consulta.append("VALUES ( ");
        consulta.append("default "); //id Autoincremental
        consulta.append(", ");
        consulta.append("? "); //idPac
        consulta.append(", ");
        consulta.append("? "); //idVenta
        consulta.append(", ");
        consulta.append("? "); //observaciones
        consulta.append(", ");
        consulta.append("? "); //idEstado
        consulta.append(", ");
        consulta.append("? "); //motivoEstado
        consulta.append(", ");
        consulta.append("? "); //fechaEntrega
        consulta.append(") ");
        try {
            ps = conn.prepareStatement(consulta.toString());

            ps.setInt(1, ordenDeTrabajo.getPac().getID());
            ps.setInt(2, ordenDeTrabajo.getVenta().getID());
            ps.setString(3, ordenDeTrabajo.getObservaciones());
            ps.setInt(4, EstadoOT.toInt(ordenDeTrabajo.getEstado()));
            ps.setString(5, ordenDeTrabajo.getMotivoEstado());
            ps.setDate(6, new Date(ordenDeTrabajo.getFechaEntrega().getTime()));

            ps.execute();
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new SipsaExcepcion("Error al guardar la Orden de Trabajo");
        }
    }

    public void eliminar(IPersistible o) throws SipsaExcepcion {
        Connection conn = DB.getConexion();
        PreparedStatement ps;
        StringBuilder consulta = new StringBuilder();
        consulta.append("DELETE ");
        consulta.append("FROM ");
        consulta.append("OrdenesDeTrabajo ");
        consulta.append("WHERE ");
        consulta.append("id = ? ");
        try {
            ps = conn.prepareStatement(consulta.toString());

            ps.setInt(1, o.getID());

            ps.execute();
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new SipsaExcepcion("Error al eliminar la Orden de Trabajo id: " + o.getID());
        }
    }

    public IPersistible recuperar(IPersistible o) throws SipsaExcepcion {
        OrdenDeTrabajo ordenDeTrabajo = (OrdenDeTrabajo) o;
        Connection conn = DB.getConexion();
        PreparedStatement ps;
        ResultSet rs;
        StringBuilder consulta = new StringBuilder();
        consulta.append("SELECT ");
        consulta.append("idPac ");
        consulta.append(", ");
        consulta.append("idVenta ");
        consulta.append(", ");
        consulta.append("observacion ");
        consulta.append(", ");
        consulta.append("idEstado ");
        consulta.append(", ");
        consulta.append("motivoEstado ");
        consulta.append(", ");
        consulta.append("fechaEntrega ");
        consulta.append("FROM ");
        consulta.append("OrdenesDeTrabajo ");
        consulta.append("WHERE ");
        consulta.append("id = ? ");
        try {
            ps = conn.prepareStatement(consulta.toString());

            ps.setInt(1, o.getID());

            rs = ps.executeQuery();
            if (rs.next()) {
                PacBroker pacBroker = new PacBroker();
                Pac pac = new Pac(rs.getInt("idPac"));
                pac = (Pac) pacBroker.recuperar(pac);
                ordenDeTrabajo.setPac(pac);
                VentaBroker ventaBroker = new VentaBroker();
                Venta venta = new Venta(rs.getInt("idVenta"));
                venta = (Venta) ventaBroker.recuperar(venta);
                ordenDeTrabajo.setVenta(venta);
                ordenDeTrabajo.setObservaciones(rs.getString("observacion"));
                ordenDeTrabajo.setEstado(EstadoOT.fromInt(rs.getInt("idEstado")));
                ordenDeTrabajo.setMotivoEstado(rs.getString("motivoEstado"));
                ordenDeTrabajo.setFechaEntrega(rs.getDate("fechaEntrega"));
            }
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new SipsaExcepcion("Error al recuperar la Orden de Trabajo id: " + o.getID());
        }
        return ordenDeTrabajo;
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
        consulta.append("OrdenesDeTrabajo ");
        try {
            ps = conn.prepareStatement(consulta.toString());
            rs = ps.executeQuery();
            while (rs.next()) {
                OrdenDeTrabajo ordenDeTrabajo = new OrdenDeTrabajo(rs.getInt("id"));
                ordenDeTrabajo = (OrdenDeTrabajo) recuperar(ordenDeTrabajo);
                lista.add(ordenDeTrabajo);
            }
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new SipsaExcepcion("Error al recuperar la lista de Ordenes de Trabajo");
        }
        return lista;
    }
}
