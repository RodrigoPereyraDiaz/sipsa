package sipsa.persistencia;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;
import java.util.ArrayList;

import sipsa.dominio.EstadoOT;
import sipsa.dominio.OrdenDeTrabajo;

class OtBroker {
       /**
     * Obtiene una instacia de OT desde una base de datos
     * @param id Identificador unico de OT
     * @return Instancia de OT
     */
    protected OrdenDeTrabajo getOT(int id){
        OrdenDeTrabajo ordenDeTrabajo = new OrdenDeTrabajo(id);
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

            ps.setInt(1, id);

            rs = ps.executeQuery();
            if (rs.next()) {
                PacBroker pacBroker = new PacBroker();
                ordenDeTrabajo.setPac(pacBroker.getPac(rs.getInt("id")));
                VentaBroker ventaBroker = new VentaBroker();
                ordenDeTrabajo.setVenta(ventaBroker.getVenta(rs.getInt("idVenta")));
                ordenDeTrabajo.setObservaciones(rs.getString("observaciones"));
                ordenDeTrabajo.setEstado(EstadoOT.fromInt(rs.getInt("idEstado")));
                ordenDeTrabajo.setMotivoEstado(rs.getString("motivoEstado"));
                ordenDeTrabajo.setFechaEntrega(rs.getDate("fechaEntrega"));
            }
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ordenDeTrabajo;
    }

    /**
     * Guarda una instancia de OT en una base de datos
     * @param ordenDeTrabajo OT a guardar
     * @return Resultado de la operacion
     */
    protected boolean saveOT(OrdenDeTrabajo ordenDeTrabajo){
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
            ps.setDate(6,(Date) ordenDeTrabajo.getFechaEntrega());

            ps.execute();
            ps.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    /**
     * Elimina un OT de una base de datos
     * @param ordenDeTrabajo OT a eliminar
     * @return Resultado de la operacion
     */
    protected boolean deleteOT(OrdenDeTrabajo ordenDeTrabajo){
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

            ps.setInt(1, ordenDeTrabajo.getID());

            ps.execute();
            ps.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    /**
     * Verifica la existencia de un pac en una base de datos
     * @param ordenDeTrabajo a verificar
     * @return Resultado de la existencia
     */
    protected boolean exist(OrdenDeTrabajo ordenDeTrabajo){
        boolean existe = false;
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
            existe = rs.next();
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return existe;
    }

    /**
     * Obtiene una lista de OTs desde la base de datos
     * @return Lista de instancias de OTs
     */
    protected List<OrdenDeTrabajo> getList(){
        List<OrdenDeTrabajo> lista = new ArrayList<OrdenDeTrabajo>();
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
                OrdenDeTrabajo ordenDeTrabajo = getOT(rs.getInt("id"));
                lista.add(ordenDeTrabajo);
            }
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }
}