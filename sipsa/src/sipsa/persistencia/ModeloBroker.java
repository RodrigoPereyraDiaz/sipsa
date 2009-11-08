package sipsa.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import sipsa.dominio.Modelo;

class ModeloBroker {

    /**
     * Obtiene un Modelo desde la base de datos
     * @param id Identificador unico del Modelo
     * @return Instancia de Modelo
     */
    protected Modelo getModelo(int id){
        Modelo modelo = new Modelo(id);
        Connection conn = DB.getConexion();
        PreparedStatement ps;
        ResultSet rs;
        StringBuilder consulta = new StringBuilder();
        consulta.append("SELECT ");
        consulta.append("idTipoProducto ");
        consulta.append(", ");
        consulta.append("nombre ");
        consulta.append("FROM ");
        consulta.append("Modelos ");
        consulta.append("WHERE ");
        consulta.append("id = ? ");
        try {
            ps = conn.prepareStatement(consulta.toString());

            ps.setInt(1, id);

            rs = ps.executeQuery();
            if (rs.next()) {
                TipoProductoBroker tipoProductoBroker = new TipoProductoBroker();
                modelo.setTipoProducto(tipoProductoBroker.getTipoProducto(rs.getInt("id")));
                modelo.setNombre(rs.getString("nombre"));
            }
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return modelo;
    }

    /**
     * Guarda un Modelo en la base de datos
     * @param modelo Modelo a guardar
     * @return Resultado de la operacion
     */
    protected boolean saveModelo(Modelo modelo){
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
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    /**
     * Elimina un Modelo de la base de datos
     * @param modelo pv Modelo a eliminar
     * @return Resultado de la operacion
     */
    protected boolean deletePv(Modelo modelo){
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
            
            ps.setInt(1, modelo.getID());

            ps.execute();
            ps.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    /**
     * Verficia la existencia de un PV en la base de datos
     * @param modelo Modelo a verificar
     * @return Existencia del Modelo
     */
    protected boolean exist(Modelo modelo){
        boolean existe = false;
        Connection conn = DB.getConexion();
        PreparedStatement ps;
        ResultSet rs;
        StringBuilder consulta = new StringBuilder();
        consulta.append("SELECT ");
        consulta.append("id ");
        consulta.append("FROM ");
        consulta.append("Modelo ");
        consulta.append("WHERE ");
        consulta.append("idTipoProducto = ? ");
        consulta.append("AND ");
        consulta.append("nombre = ? ");
        try {
            ps = conn.prepareStatement(consulta.toString());

            ps.setInt(1, modelo.getTipoProducto().getID());
            ps.setString(2, modelo.getNombre());

            rs = ps.executeQuery();
            existe = rs.next();
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return existe;
    }

    /**
     * Obtiene una lista de los Modelos desde la base de datos
     * @return Lista de Modelos
     */
    protected List<Modelo> getList(){
        List<Modelo> lista = new ArrayList<Modelo>();
        Connection conn = DB.getConexion();
        PreparedStatement ps;
        ResultSet rs;
        StringBuilder consulta = new StringBuilder();
        consulta.append("SELECT ");
        consulta.append("id ");
        consulta.append("FROM ");
        consulta.append("Modelo ");
        try {
            ps = conn.prepareStatement(consulta.toString());
            rs = ps.executeQuery();
            while (rs.next()) {
                Modelo modelo = getModelo(rs.getInt("id"));
                lista.add(modelo);
            }
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }
}