package sipsa.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import sipsa.dominio.OrdenDeTrabajo;

class OtBroker {
       /**
     * Obtiene una instacia de OT desde una base de datos
     * @param cuit Identificador unico de OT
     * @return Instancia de OT
     */
    public OrdenDeTrabajo getOT(int id){
        OrdenDeTrabajo ordenDeTrabajo = new OrdenDeTrabajo();

        Connection conn = DB.getConexion();
        PreparedStatement ps;
        ResultSet rs;
        String consulta =
                //TODO consulta a la base de una OT
                "SELECT cuit, nombre " +
                "FROM   Empresas " +
                "WHERE  cuit = ? " +
                "   and tipo = 0";

        try {
          ps = conn.prepareStatement(consulta);
          ps.setInt(1, id);
          rs = ps.executeQuery();

          if (rs.next()) {
            //TODO cargar los valores
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
    public boolean saveOT(OrdenDeTrabajo ordenDeTrabajo){
        Connection conn = DB.getConexion();
        PreparedStatement ps;
        String consulta =
            //TODO insercion de una OT
            "INSERT INTO Empresas (cuit, nombre, tipo) " +
            "VALUES (?, ? ,0)";
        try {
          ps = conn.prepareStatement(consulta);
          //TODO Competar
          ps.setString(1, ordenDeTrabajo.getMotivoEstado());
          ps.setString(2, ordenDeTrabajo.getObservaciones());
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
    public boolean deleteOT(OrdenDeTrabajo ordenDeTrabajo){
        Connection conn = DB.getConexion();
        PreparedStatement ps;
        String consulta =
            "DELETE FROM OrdenesDeTrabajo " +
            "WHERE  id = ? ";
        try {
          ps = conn.prepareStatement(consulta);
          //TODO modificar por el identificador de la OT
          ps.setString(1, ordenDeTrabajo.toString());
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
    public boolean exist(OrdenDeTrabajo ordenDeTrabajo){
        Connection conn = DB.getConexion();
        PreparedStatement ps;
        ResultSet rs;
        String consulta =
                "SELECT id " +
                "FROM   OrdenesDeTrabajo " +
                "WHERE  id = ? ";
        boolean existe = false;
        try {
          ps = conn.prepareStatement(consulta);
          //Modificar por el identificador de la OT
          ps.setString(1, ordenDeTrabajo.toString());
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
    public ArrayList<OrdenDeTrabajo> getList(){
        ArrayList<OrdenDeTrabajo> lista = new ArrayList<OrdenDeTrabajo>();
        Connection conn = DB.getConexion();
        PreparedStatement ps;
        ResultSet rs;
        String consulta =
                "SELECT id " +
                "FROM OrdenesDeTrabajo";
        try {
          ps = conn.prepareStatement(consulta);
          rs = ps.executeQuery();
          while (rs.next()) {
            OrdenDeTrabajo ordenDeTrabajo = new OrdenDeTrabajo();
            ordenDeTrabajo = getOT(rs.getInt("id"));
            lista.add(ordenDeTrabajo);
          }
          ps.close();
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
        return lista;
    }
}