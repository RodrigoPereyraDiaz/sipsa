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
import sipsa.dominio.TipoProducto;

/**
 * Capa de abstraccion para adaptar instancia de Tipo de Producto de dominio a informacion de Tipo de Producto en en medios de persistencia
 * @author Claudio Rodrigo Pereyra Diaz
 * @author Maria Eugenia Sanchez
 */
public class TipoProductoAdapter {

    /**
     * Obtiene un Tipo de producto desde la base de datos
     * @param modelo Identificar unico del Tipo de Producto
     * @return Instancia del Tipo de Producto
     */
    protected TipoProducto getTipoProducto(String modelo){
        TipoProducto tipoProducto = new TipoProducto();
        Connection conn = DB.getConexion();
        PreparedStatement ps;
        ResultSet rs;
        String consulta =
                "SELECT modelo, descripcion, duracionGarantia " +
                "FROM   TiposProducto " +
                "WHERE  modelo = ?";

        try {
          ps = conn.prepareStatement(consulta);
          ps.setString(1, modelo);
          rs = ps.executeQuery();

          if (rs.next()) {
            tipoProducto.setDescripcion(rs.getString("descripcion"));
            tipoProducto.setModelo(rs.getString("modelo"));
            tipoProducto.setDuracionGarantia(rs.getInt("duracionGarantia"));
          }

          ps.close();
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
        return tipoProducto;
    }

    /**
     * Guarda un Tipo de Producto en la base de datos
     * @param tipoProducto Tipo de Producto a guardar
     * @return Resultado de la operacion
     */
    protected boolean saveTipoProducto(TipoProducto tipoProducto){
        Connection conn = DB.getConexion();
        PreparedStatement ps;
        String consulta =
            "INSERT INTO TiposProducto (modelo, descripcion, duracionGarantia) " +
            "VALUES (?, ?, ?)";
        try {
          ps = conn.prepareStatement(consulta);
          ps.setString(1, tipoProducto.getModelo());
          ps.setString(2, tipoProducto.getDescripcion());
          ps.setInt(3, tipoProducto.getDuracionGarantia());
          ps.execute();
          ps.close();
          return true;
        } catch (SQLException ex) {
          ex.printStackTrace();
          return false;
        }
    }

    /**
     * Elimina un Tipo de Producto de la base de datos
     * @param tipoProducto Tipo de Producto a eliminar
     * @return Resultado de la operacion
     */
    protected boolean deleteTipoProducto(TipoProducto tipoProducto){
        Connection conn = DB.getConexion();
        PreparedStatement ps;
        String consulta =
            "DELETE FROM TiposProducto " +
            "WHERE  modelo = ? ";
        try {
          ps = conn.prepareStatement(consulta);
          ps.setString(1, tipoProducto.getModelo());
          ps.execute();
          ps.close();
          return true;
        } catch (SQLException ex) {
          ex.printStackTrace();
          return false;
        }

    }

    /**
     * Verifica la existencia de un Tipo de Producto en la base de datos
     * @param tipoProducto Tipo de Producto a verificar
     * @return Existencia del Tipo de Producto
     */
    protected boolean exist(TipoProducto tipoProducto){
        Connection conn = DB.getConexion();
        PreparedStatement ps;
        ResultSet rs;
        String consulta =
                "SELECT modelo " +
                "FROM   TiposProducto " +
                "WHERE  modelo = ?";

        boolean existe = false;
        try {
          ps = conn.prepareStatement(consulta);
          ps.setString(1, tipoProducto.getModelo());
          rs = ps.executeQuery();

          existe = rs.next();
          ps.close();

        } catch (SQLException ex) {
          ex.printStackTrace();
        }

        return existe;
    }

    /**
     * Obtiene una lista de Tipos de Producto desde la base de datos
     * @return Lista de Tipos de Productos
     */
    protected ArrayList<TipoProducto> getList(){
        ArrayList<TipoProducto> lista = new ArrayList<TipoProducto>();
        Connection conn = DB.getConexion();
        PreparedStatement ps;
        ResultSet rs;
        String consulta =
                "SELECT modelo " +
                "FROM TiposProducto";
        try {
          ps = conn.prepareStatement(consulta);
          rs = ps.executeQuery();

          while (rs.next()) {
            TipoProducto tipoProducto = new TipoProducto();
            tipoProducto = getTipoProducto(rs.getString("modelo"));
            lista.add(tipoProducto);
          }

          ps.close();
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
        return lista;
    }
}