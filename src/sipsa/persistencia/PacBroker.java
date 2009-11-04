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

import sipsa.dominio.Pac;

/**
 * Capa de abstraccion para adaptar instancia de PAC de dominio a informacion de PAC en en medios de persistencia
 * @author Claudio Rodrigo Pereyra Diaz
 * @author Maria Eugenia Sanchez
 */
class PacBroker {

    /**
     * Obtiene una instacia de PAC desde una base de datos
     * @param cuit Identificador unico de PAC
     * @return Instancia de PAC
     */
    public Pac getPac(String cuit){
        Pac p = new Pac();

        Connection conn = DB.getConexion();
        PreparedStatement ps;
        ResultSet rs;
        String consulta =
                "SELECT cuit, nombre " +
                "FROM   Empresas " +
                "WHERE  cuit = ? " +
                "   and tipo = 0";

        try {
          ps = conn.prepareStatement(consulta);
          ps.setString(1, cuit);
          rs = ps.executeQuery();

          if (rs.next()) {
            p.setCuit(rs.getString("cuit"));
            p.setNombre(rs.getString("nombre"));
          }

          ps.close();
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
        return p;
    }

    /**
     * Guarda una instancia de PAC en una base de datos
     * @param pac Pac a guardar
     * @return Resultado de la operacion
     */
    public boolean savePac(Pac pac){
        Connection conn = DB.getConexion();
        PreparedStatement ps;
        String consulta =
            "INSERT INTO Empresas (cuit, nombre, tipo) " +
            "VALUES (?, ? ,0)";
        try {
          ps = conn.prepareStatement(consulta);
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
    public boolean deletePac(Pac pac){
        Connection conn = DB.getConexion();
        PreparedStatement ps;
        String consulta =
            "DELETE FROM Empresas " +
            "WHERE  cuit = ? " +
            "   and tipo = 0";
        try {
          ps = conn.prepareStatement(consulta);
          ps.setString(1, pac.getCuit());
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
    public boolean exist(Pac pac){
        Connection conn = DB.getConexion();
        PreparedStatement ps;
        ResultSet rs;
        String consulta =
                "SELECT cuit " +
                "FROM   Empresas " +
                "WHERE  cuit = ? " +
                "   and tipo = 0";
        boolean existe = false;
        try {
          ps = conn.prepareStatement(consulta);
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
    public ArrayList<Pac> getList(){
        ArrayList<Pac> lista = new ArrayList<Pac>();
        Connection conn = DB.getConexion();
        PreparedStatement ps;
        ResultSet rs;
        String consulta =
                "SELECT cuit " +
                "FROM   Empresas " +
                "WHERE  tipo = 0";

        try {
          ps = conn.prepareStatement(consulta);
          rs = ps.executeQuery();

          while (rs.next()) {
            Pac pac = new Pac();
            pac = getPac(rs.getString("cuit"));
            lista.add(pac);
          }

          ps.close();
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
        return lista;
    }
}