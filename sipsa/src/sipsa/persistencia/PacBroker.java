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
class PacBroker implements ISipsaBroker{

    /**
     * Obtiene una instacia de PAC desde una base de datos
     * @param id Identificador unico de PAC
     * @return Instancia de PAC
     */
    protected Pac getPac(int id){
        Pac pac = new Pac(id);
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

            ps.setInt(1, id);

            rs = ps.executeQuery();
            if (rs.next()) {
                pac.setCuit(rs.getString("cuit"));
                pac.setNombre(rs.getString("nombre"));
            }
          ps.close();
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
        return pac;
    }

    /**
     * Guarda una instancia de PAC en una base de datos
     * @param pac Pac a guardar
     * @return Resultado de la operacion
     */
    @Deprecated
    protected boolean savePac(Pac pac){
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
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    /**
     * Elimina un PAC de una base de datos
     * @param pac PAC a eliminar
     * @return Resultado de la operacion
     */
    @Deprecated
    protected boolean deletePac(Pac pac){
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
            ps.setInt(1, pac.getID());
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
     * @param pac Pac a verificar
     * @return Resultado de la existencia
     */
    protected boolean exist(Pac pac){
        boolean existe = false;
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
            existe = rs.next();
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return existe;
    }

    /**
     * Obtiene una lista de PACs desde la base de datos
     * @return Lista de instancias de PACs
     */
    @Deprecated
    protected List<Pac> getList(){
        List<Pac> lista = new ArrayList<Pac>();
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
                Pac pac = getPac(rs.getInt("id"));
                lista.add(pac);
            }
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }

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
            rs.next();
            pac = (Pac) recuperar(new Pac(rs.getInt("id")));
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new SipsaExcepcion("No se pudo determinar la existencia del Punto de Atención al Cliente");
        }
        return pac;
    }

    public boolean actualizar(IPersistible o) throws SipsaExcepcion {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean guardar(IPersistible o) throws SipsaExcepcion {
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
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new SipsaExcepcion("No se pudo guardar el Punto de Atención al Cliente");
        }
    }

    public boolean eliminar(IPersistible o) throws SipsaExcepcion {
        Pac pac = (Pac) o;
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
            ps.setInt(1, pac.getID());
            ps.execute();
            ps.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new SipsaExcepcion("No se pudo eliminar el Puntos de Atención al Cliente");
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
            throw new SipsaExcepcion("No se pudo recuperar la lista de Puntos de Atención al Cliente");
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
          throw new SipsaExcepcion("No se pudo recuperar el Puntos de Atención al Cliente");
        }
        return pac;
    }
}