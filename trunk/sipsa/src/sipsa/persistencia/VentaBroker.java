/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sipsa.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import sipsa.dominio.Venta;

/**
 *
 * @author elsupergomez
 */
class VentaBroker {
    /**
     * Obtiene un Tipo de producto desde la base de datos
     * @param modelo Identificar unico del Tipo de Producto
     * @return Instancia del Tipo de Producto
     */
    public Venta getVenta(int id){
        Venta venta = new Venta();
        Connection conn = DB.getConexion();
        PreparedStatement ps;
        ResultSet rs;
        String consulta =
                "SELECT * " +
                "FROM   Ventas " +
                "WHERE  id = ?";

        try {
          ps = conn.prepareStatement(consulta);
          ps.setInt(1, id);
          rs = ps.executeQuery();

          if (rs.next()) {
          //TODO
              /*
              tipoProducto.setDescripcion(rs.getString("descripcion"));
            tipoProducto.setModelo(rs.getString("modelo"));
            tipoProducto.setDuracionGarantia(rs.getInt("duracionGarantia"));
           */
          }

          ps.close();
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
        return venta;
    }

    /**
     * Guarda un Tipo de Producto en la base de datos
     * @param tipoProducto Tipo de Producto a guardar
     * @return Resultado de la operacion
     */
    public boolean saveVenta(Venta venta){
        Connection conn = DB.getConexion();
        PreparedStatement ps;
        String consulta =
            //TODO modificar por la info de una venta
                "INSERT INTO TiposProducto (modelo, descripcion, duracionGarantia) " +
            "VALUES (?, ?, ?)";
        try {
          ps = conn.prepareStatement(consulta);
          //TODO modificar por datos de venta
          /*
          ps.setString(1, tipoProducto.getModelo());
          ps.setString(2, tipoProducto.getDescripcion());
          ps.setInt(3, tipoProducto.getDuracionGarantia());
           */
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
    public boolean deleteVenta(Venta venta){
        Connection conn = DB.getConexion();
        PreparedStatement ps;
        String consulta =
            "DELETE FROM Ventas " +
            "WHERE  id = ? ";
        try {
          ps = conn.prepareStatement(consulta);
          ps.setString(1, venta.getNroFactura());
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
    public boolean exist(Venta venta){
        Connection conn = DB.getConexion();
        PreparedStatement ps;
        ResultSet rs;
        String consulta =
                "SELECT id " +
                "FROM   Ventas " +
                "WHERE  id = ?";
//TODO modificar por id de venta
        boolean existe = false;
        try {
          ps = conn.prepareStatement(consulta);
          ps.setString(1, venta.getNroFactura());
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
    public ArrayList<Venta> getList() throws SQLException{
        ArrayList<Venta> lista = new ArrayList<Venta>();
        Connection conn = DB.getConexion();
        PreparedStatement ps;
        ResultSet rs;
        String consulta =
                "SELECT id " +
                "FROM Ventas";
        try {
          ps = conn.prepareStatement(consulta);
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
}
