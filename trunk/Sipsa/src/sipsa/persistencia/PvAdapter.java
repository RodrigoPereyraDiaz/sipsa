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
import sipsa.control.dominio.Pv;

/**
 * Capa de abstraccion para adaptar instancia de PV de dominio a informacion de PV en en medios de persistencia
 * @author Claudio Rodrigo Pereyra Diaz
 * @author Maria Eugenia Sanchez
 */
public class PvAdapter {

    /**
     * Obtiene un PV desde la base de datos
     * @param cuit Identificador unico del PV
     * @return Instancia de PV
     */
    protected Pv getPv(String cuit){
        Pv pv = new Pv();

        Connection conn = DB.getConexion();
        PreparedStatement ps;
        ResultSet rs;
        String consulta =
                "SELECT cuit, nombre " +
                "FROM   Empresas " +
                "WHERE  cuit = ? " +
                "   and tipo = 1";

        try {
          ps = conn.prepareStatement(consulta);
          ps.setString(1, cuit);
          rs = ps.executeQuery();

          if (rs.next()) {
            pv.setCuit(rs.getString("cuit"));
            pv.setNombre(rs.getString("nombre"));
          }

          ps.close();
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
        return pv;
    }

    /**
     * Guarda un PV en la base de datos
     * @param pv PV a guardar
     * @return Resultado de la operacion
     */
    protected boolean savePv(Pv pv){
        Connection conn = DB.getConexion();
        PreparedStatement ps;
        String consulta =
            "INSERT INTO Empresas (cuit, nombre, tipo) " +
            "VALUES (?, ? ,1)";
        try {
          ps = conn.prepareStatement(consulta);
          ps.setString(1, pv.getCuit());
          ps.setString(2, pv.getNombre());
          ps.execute();
          ps.close();
          return true;
        } catch (SQLException ex) {
          ex.printStackTrace();
          return false;
        }
    }

    /**
     * Elimina un PV de la base de datos
     * @param pv PV a eliminar
     * @return Resultado de la operacion
     */
    protected boolean deletePv(Pv pv){
        Connection conn = DB.getConexion();
        PreparedStatement ps;
        String consulta =
            "DELETE FROM Empresas " +
            "WHERE  cuit = ? " +
            "   and tipo = 1";
        try {
          ps = conn.prepareStatement(consulta);
          ps.setString(1, pv.getCuit());
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
     * @param pv PV a verificar
     * @return Existencia del PV
     */
    protected boolean exist(Pv pv){
        Connection conn = DB.getConexion();
        PreparedStatement ps;
        ResultSet rs;
        String consulta =
                "SELECT cuit " +
                "FROM   Empresas " +
                "WHERE  cuit = ? " +
                "   and tipo = 1";
        boolean existe = false;
        try {
          ps = conn.prepareStatement(consulta);
          ps.setString(1, pv.getCuit());
          rs = ps.executeQuery();

          existe = rs.next();
          ps.close();

        } catch (SQLException ex) {
          ex.printStackTrace();
        }

        return existe;
    }

    /**
     * Obtiene una lista de los PV desde la base de datos
     * @return Lista de PVs
     */
    protected ArrayList<Pv> getList(){
        ArrayList<Pv> lista = new ArrayList<Pv>();
        Connection conn = DB.getConexion();
        PreparedStatement ps;
        ResultSet rs;
        String consulta =
                "SELECT cuit " +
                "FROM   Empresas " +
                "WHERE  tipo = 1";

        try {
          ps = conn.prepareStatement(consulta);
          rs = ps.executeQuery();

          while (rs.next()) {
            Pv p = new Pv();
            p = getPv(rs.getString("cuit"));
            lista.add(p);
          }

          ps.close();
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
        return lista;
    }
}
