/*
 * Sistemas de Informacion II 2009
 * Proyecto Sipsa
 */

package sipsa.persistencia;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import sipsa.dominio.Producto;

/**
 * Capa de abstraccion para adaptar instancia de Producto de dominio a informacion de Producto en en medios de persistencia
 * @author Claudio Rodrigo Pereyra Diaz
 * @author Maria Eugenia Sanchez
 */
public class ProductoAdapter {

    /**
     * Obtiene una Prdocuto desde el una base de datos
     * @param nroSerie Identificador unico de Producto
     * @return Instancia de Producto
     */
    protected Producto getProducto(String nroSerie){
        Producto producto = new Producto();
        Connection conn = DB.getConexion();
        PreparedStatement ps;
        ResultSet rs;
        String consulta =
                "SELECT nroSerie, nombre, Productos.modelo, fabrica, fechaFabricacion, duracionGarantia " +
                "FROM   Productos " +
                "   INNER JOIN TipoProductos " +
                "       ON Procutos.modelo = TipoProductos.modelo " +
                "WHERE  nroSerie = ?";

        try {
          ps = conn.prepareStatement(consulta);
          ps.setString(1, nroSerie);
          rs = ps.executeQuery();

          if (rs.next()) {
            producto.setNroSerie(rs.getString("nroSerie"));
            producto.setFabrica(rs.getString("fabrica"));
            producto.setFechaFabricacion(rs.getDate("fechaFabricacion"));
            producto.setNombre(rs.getString("nombre"));
            producto.setModelo(rs.getString("modelo"));
            producto.setDuracionGarantia(rs.getInt("duracionGarantia"));
          }

          ps.close();
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
        return producto;
    }

    /**
     * Guarda un Producto en una base de datos
     * @param producto Producto a guardar
     * @return Resultado de la operacion
     */
    protected boolean saveProducto(Producto producto){
        Connection conn = DB.getConexion();
        PreparedStatement ps;
        String consulta =
            "INSERT INTO Productos (nroSerie, fabrica, fechaFabricacion, modelo) " +
            "VALUES (?, ?, ?, ?)";
        try {
          ps = conn.prepareStatement(consulta);
          ps.setString(1, producto.getNroSerie());
          ps.setString(2, producto.getFabrica());
          ps.setDate(3,new Date(producto.getFechaFabricacion().getTime()));
          ps.setString(4, producto.getModelo());
          ps.execute();
          ps.close();
          return true;
        } catch (SQLException ex) {
          ex.printStackTrace();
          return false;
        }

    }

    /**
     * Elimina un Producto de la base de datos
     * @param producto Producto a eliminar
     * @return Resultado de la operacion
     */
    protected boolean deleteProducto(Producto producto){
        Connection conn = DB.getConexion();
        PreparedStatement ps;
        String consulta =
            "DELETE FROM Productos " +
            "WHERE  nroSerie = ? ";
        try {
          ps = conn.prepareStatement(consulta);
          ps.setString(1, producto.getNroSerie());
          ps.execute();
          ps.close();
          return true;
        } catch (SQLException ex) {
          ex.printStackTrace();
          return false;
        }
    }

    /**
     * Verificar la existencia de un Producto en la base de datos
     * @param producto Producto a verificar
     * @return Existencia del Producto
     */
    protected boolean exist(Producto producto){
        Connection conn = DB.getConexion();
        PreparedStatement ps;
        ResultSet rs;
        String consulta =
                "SELECT nroSerie" +
                "FROM   Productos " +
                "WHERE  nroSerie = ?";

        boolean existe = false;
        try {
          ps = conn.prepareStatement(consulta);
          ps.setString(1, producto.getNroSerie());
          rs = ps.executeQuery();

          existe = rs.next();
          ps.close();

        } catch (SQLException ex) {
          ex.printStackTrace();
        }

        return existe;
    }

    /**
     * Obtiene una lista de Productos de la base de datos
     * @return Lista de Productos
     */
    protected ArrayList<Producto> getList(){
        ArrayList<Producto> lista = new ArrayList<Producto>();
        Connection conn = DB.getConexion();
        PreparedStatement ps;
        ResultSet rs;
        String consulta =
                "SELECT nroSerie " +
                "FROM   Productos";

        try {
          ps = conn.prepareStatement(consulta);
          rs = ps.executeQuery();

          while (rs.next()) {
            Producto producto = new Producto();
            producto = getProducto(rs.getString("nroSerie"));
            lista.add(producto);
          }

          ps.close();
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
        return lista;
    }

    /**
     * Importa una lista de productos desde un archivo de texto y los almacena en la base de datos
     * @param archivo Ruta absoluta del archivo a importar
     * @return Resultado de la importacion y almacenamiento
     * @throws java.io.IOException
     * @throws java.text.ParseException
     */
    //@TODO revisar las excepciones
    protected Boolean importarProductos(String archivo) throws IOException, ParseException{
        ArrayList<Producto> lista = new ArrayList<Producto>();
        boolean ok = false;

        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String s = "";

            while ((s = entrada.readLine()) != null) {
               System.out.println(s);
               String[] producto = s.split(";");
               Producto p = new Producto();
               p.setNroSerie(producto[0]);
               System.out.println(p.getNroSerie());
               p.setFabrica(producto[1]);
               SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
               p.setFechaFabricacion(sdf.parse(producto[2]));
               p.setModelo(producto[3]);
               lista.add(p);
            }

            for (Iterator ProdIt = lista.iterator(); ProdIt.hasNext();) {
                Producto prod = (Producto) ProdIt.next();
                this.saveProducto(prod);
            }
            entrada.close();
            ok = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
       return ok;
    }
}