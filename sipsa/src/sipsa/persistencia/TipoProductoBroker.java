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
import sipsa.dominio.TipoProducto;

/**
 * Capa de abstraccion para adaptar instancia de Tipo de Producto de dominio a informacion de Tipo de Producto en en medios de persistencia
 * @author Claudio Rodrigo Pereyra Diaz
 * @author Maria Eugenia Sanchez
 */
class TipoProductoBroker implements ISipsaBroker {

    /**
     * Obtiene un Tipo de producto desde la base de datos
     * @param id Identificar unico del Tipo de Producto
     * @return Instancia del Tipo de Producto
     */
    protected TipoProducto getTipoProducto(int id) {
    }

    /**
     * Guarda un Tipo de Producto en la base de datos
     * @param tipoProducto Tipo de Producto a guardar
     * @return Resultado de la operacion
     */
    protected boolean saveTipoProducto(TipoProducto tipoProducto) {
    }

    /**
     * Elimina un Tipo de Producto de la base de datos
     * @param tipoProducto Tipo de Producto a eliminar
     * @return Resultado de la operacion
     */
    protected boolean deleteTipoProducto(TipoProducto tipoProducto) {
    }

    /**
     * Verifica la existencia de un Tipo de Producto en la base de datos
     * @param tipoProducto Tipo de Producto a verificar
     * @return Existencia del Tipo de Producto
     */
    protected boolean exist(TipoProducto tipoProducto) {
    }

    /**
     * Obtiene una lista de Tipos de Producto desde la base de datos
     * @return Lista de Tipos de Productos
     */
    protected List<TipoProducto> getList() {
    }

    public IPersistible existe(IPersistible o) throws SipsaExcepcion {
        boolean existe = false;
        Connection conn = DB.getConexion();
        PreparedStatement ps;
        ResultSet rs;
        StringBuilder consulta = new StringBuilder();
        consulta.append("SELECT ");
        consulta.append("id ");
        consulta.append("FROM ");
        consulta.append("TiposProducto ");
        consulta.append("WHERE ");
        consulta.append("descripcion = ? ");
        try {
            ps = conn.prepareStatement(consulta.toString());

            ps.setString(1, tipoProducto.getDescripcion());

            rs = ps.executeQuery();
            existe = rs.next();
            ps.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return existe;
    }

    public void actualizar(IPersistible o) throws SipsaExcepcion {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void guardar(IPersistible o) throws SipsaExcepcion {
        Connection conn = DB.getConexion();
        PreparedStatement ps;
        StringBuilder consulta = new StringBuilder();
        consulta.append("INSERT ");
        consulta.append("INTO ");
        consulta.append("TiposProducto ");
        consulta.append("VALUES ( ");
        consulta.append("default "); //id Autoincremental
        consulta.append(", ");
        consulta.append("? "); //descripcion
        consulta.append(", ");
        consulta.append("? "); //duracionGarantia
        consulta.append(") ");
        try {
            ps = conn.prepareStatement(consulta.toString());

            ps.setString(1, tipoProducto.getDescripcion());
            ps.setInt(2, tipoProducto.getDuracionGarantia());

            ps.execute();
            ps.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public void eliminar(IPersistible o) throws SipsaExcepcion {
        Connection conn = DB.getConexion();
        PreparedStatement ps;
        StringBuilder consulta = new StringBuilder();
        consulta.append("DELETE ");
        consulta.append("FROM ");
        consulta.append("TiposProducto ");
        consulta.append("WHERE ");
        consulta.append("id = ? ");
        try {
            ps = conn.prepareStatement(consulta.toString());

            ps.setInt(1, tipoProducto.getID());

            ps.execute();
            ps.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public IPersistible recuperar(IPersistible o) throws SipsaExcepcion {
        TipoProducto tipoProducto = new TipoProducto(id);
        Connection conn = DB.getConexion();
        PreparedStatement ps;
        ResultSet rs;
        StringBuilder consulta = new StringBuilder();
        consulta.append("SELECT ");
        consulta.append("nombre ");
        consulta.append(", ");
        consulta.append("duracionGarantia ");
        consulta.append("FROM ");
        consulta.append("TiposProducto ");
        consulta.append("WHERE ");
        consulta.append("id = ? ");
        try {
            ps = conn.prepareStatement(consulta.toString());

            ps.setInt(1, tipoProducto.getID());

            rs = ps.executeQuery();
            if (rs.next()) {
                tipoProducto.setDescripcion(rs.getString("nombre"));
                tipoProducto.setDuracionGarantia(rs.getInt("duracionGarantia"));
                ModeloBroker modeloBroker = new ModeloBroker();
                tipoProducto.setModelos(modeloBroker.getList(tipoProducto.getID()));
            }
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new SipsaExcepcion("Error al recuperar el Tipo de Producto id: " + o.getID());
        }
        return tipoProducto;
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
        consulta.append("TiposProducto ");
        try {
            ps = conn.prepareStatement(consulta.toString());
            rs = ps.executeQuery();
            while (rs.next()) {
                TipoProducto tipoProducto = new TipoProducto(rs.getInt("id"));
                tipoProducto = (TipoProducto) recuperar(tipoProducto);
                lista.add(tipoProducto);
            }
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        return lista;
    }
}