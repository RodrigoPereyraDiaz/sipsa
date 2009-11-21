package sipsa.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import sipsa.SipsaExcepcion;
import sipsa.dominio.Modelo;

class ModeloBroker implements ISipsaBroker {

    /**
     * Obtiene un Modelo desde la base de datos
     * @param id Identificador unico del Modelo
     * @return Instancia de Modelo
     */
    @Deprecated
    protected Modelo getModelo(int id){
        Modelo modelo = new Modelo(id);
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

            ps.setInt(1, id);

            rs = ps.executeQuery();
            if (rs.next()) {
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
    @Deprecated
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
    @Deprecated
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
    @Deprecated
    protected boolean exist(Modelo modelo){
        boolean existe = false;
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
    @Deprecated
    protected List<Modelo> getList(int idTipoProducto){
        List<Modelo> lista = new ArrayList<Modelo>();
        Connection conn = DB.getConexion();
        PreparedStatement ps;
        ResultSet rs;
        StringBuilder consulta = new StringBuilder();
        consulta.append("SELECT ");
        consulta.append("id ");
        consulta.append("FROM ");
        consulta.append("Modelos ");
        //consulta.append("WHERE ");
        //consulta.append("idTipoProducto = ? ");
        try {
            ps = conn.prepareStatement(consulta.toString());
            rs = ps.executeQuery();

            //ps.setInt(1, idTipoProducto);

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
        throw new UnsupportedOperationException("Not supported yet.");
    }
}