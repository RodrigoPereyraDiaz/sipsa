package sipsa.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import sipsa.SipsaExcepcion;
import sipsa.dominio.Fabrica;

class FabricaBroker implements ISipsaBroker{

    /**
     * Obtiene un Fabrica desde la base de datos
     * @param id Identificador unico del Fabrica
     * @return Instancia de Fabrica
     */
    protected Fabrica getFabrica(int id){
        Fabrica fabrica = new Fabrica(id);
        Connection conn = DB.getConexion();
        PreparedStatement ps;
        ResultSet rs;
        StringBuilder consulta = new StringBuilder();
        consulta.append("SELECT ");
        consulta.append("nombre ");
        consulta.append("FROM ");
        consulta.append("Fabricas ");
        consulta.append("WHERE ");
        consulta.append("id = ? ");
        try {
            ps = conn.prepareStatement(consulta.toString());

            ps.setInt(1, id);

            rs = ps.executeQuery();
            if (rs.next()) {
                fabrica.setNombre(rs.getString("nombre"));
            }
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return fabrica;
    }

    /**
     * Guarda un Fabrica en la base de datos
     * @param fabrica pv Fabrica a guardar
     * @return Resultado de la operacion
     */
    protected boolean saveFabrica(Fabrica fabrica){
        Connection conn = DB.getConexion();
        PreparedStatement ps;
        StringBuilder consulta = new StringBuilder();
        consulta.append("INSERT ");
        consulta.append("INTO ");
        consulta.append("Fabrica ");
        consulta.append("VALUES ( ");
        consulta.append("default "); //id Autoincremental
        consulta.append("? "); //nombre
        consulta.append(") ");
        try {
            ps = conn.prepareStatement(consulta.toString());

            ps.setString(2, fabrica.getNombre());

            ps.execute();
            ps.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    /**
     * Elimina una Fabrica de la base de datos
     * @param fabrica  Fabrica a eliminar
     * @return Resultado de la operacion
     */
    protected boolean deleteFabrica(Fabrica fabrica){
        Connection conn = DB.getConexion();
        PreparedStatement ps;
        StringBuilder consulta = new StringBuilder();
        consulta.append("DELETE ");
        consulta.append("FROM ");
        consulta.append("Fabrica ");
        consulta.append("WHERE ");
        consulta.append("id = ? ");
        try {
            ps = conn.prepareStatement(consulta.toString());
            
            ps.setInt(1, fabrica.getID());

            ps.execute();
            ps.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    /**
     * Verficia la existencia de un Fabrica en la base de datos
     * @param fabrica Fabrica a verificar
     * @return Existencia del Fabrica
     */
    protected boolean exist(Fabrica fabrica){
        boolean existe = false;
        Connection conn = DB.getConexion();
        PreparedStatement ps;
        ResultSet rs;
        StringBuilder consulta = new StringBuilder();
        consulta.append("SELECT ");
        consulta.append("id ");
        consulta.append("FROM ");
        consulta.append("Fabricas ");
        consulta.append("WHERE ");
        consulta.append("nombre = ? ");
        try {
            ps = conn.prepareStatement(consulta.toString());

            ps.setString(1, fabrica.getNombre());

            rs = ps.executeQuery();
            existe = rs.next();
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return existe;
    }

    /**
     * Obtiene una lista de los Fabricas desde la base de datos
     * @return Lista de Fabricas
     */
    protected List<Fabrica> getList(){
        List<Fabrica> lista = new ArrayList<Fabrica>();
        Connection conn = DB.getConexion();
        PreparedStatement ps;
        ResultSet rs;
        StringBuilder consulta = new StringBuilder();
        consulta.append("SELECT ");
        consulta.append("id ");
        consulta.append("FROM ");
        consulta.append("Fabricas ");
        try {
            ps = conn.prepareStatement(consulta.toString());
            rs = ps.executeQuery();
            while (rs.next()) {
                Fabrica fabrica = getFabrica(rs.getInt("id"));
                lista.add(fabrica);
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

    public List<IPersistible> recuperarLista() throws SipsaExcepcion {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public IPersistible recuperar(IPersistible o) throws SipsaExcepcion {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}