package sipsa.control.servicios;

import java.io.IOException;

import java.net.Socket;
import java.net.UnknownHostException;

import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import sipsa.control.Reporte;
import sipsa.dominio.EstadoOT;
import sipsa.dominio.OrdenDeTrabajo;
import sipsa.dominio.Pac;
import sipsa.dominio.TipoProducto;
import sipsa.presentacion.escritorio.DialogoMensaje;
import sipsa.presentacion.escritorio.ListarABM;
import sipsa.presentacion.escritorio.Login;
import sipsa.presentacion.escritorio.OrdenDeTrabajoDatos;
import sipsa.presentacion.escritorio.ReporteVisor;
import sipsa.presentacion.escritorio.SipsaPacMenu;

import sipsa.presentacion.interfaces.IListarABM;
import sipsa.presentacion.interfaces.ILogin;
import sipsa.presentacion.interfaces.IOrdenDeTrabajoDatos;
import sipsa.presentacion.interfaces.ISipsaPacMenu;

/**
 * Controlador del lado del cliente Pac
 * @author Claudio Rodrigo Pereyra Diaz
 * @author Maria Eugenia Sanchez
 */
public class Cliente implements ILogin, ISipsaPacMenu, IOrdenDeTrabajoDatos, IListarABM{

    private String host = "localhost";
    private int puerto = 1027;

    private static Cliente cliente;

    private Cliente(){}

    /**
     * Obtiene el Cliente
     * @return devuelve un objeto de tipo Cliente
     */
    public static Cliente getCliente(){
        if (cliente == null)
            cliente = new Cliente();
        return cliente;
    }

    void handelError(Exception exception) throws Exception {
        throw exception;
    }

    void handelOK(String mensaje) {
        System.out.println(mensaje);
    }

    void handleOrdenesDeTrabajo(List<OrdenDeTrabajo> list) {
        this.lista = list;
    }

//TODO Completar la clase cliente que es controlador del cliente pac
    private Conexion conexion;
    private List<OrdenDeTrabajo> lista;
    private Pac pac;

    /**
     * Muestra la pantalla de Login
     */
    public void iniciar() {
            Login login = new Login(cliente);
            login.setVisible(true);
    }

    public void ingresar(String cuit) throws Exception {
        Mensaje login = MensajesFabrica.newSolicitudLogin();
        Pac pacLogin = new Pac();
        pacLogin.setCuit(cuit);
        login.setContenido(pacLogin);
        try {
            this.conexion = new Conexion(new Socket(getHost(), getPuerto()));
            conexion.enviarMensaje(login);
            Mensaje respuesta = conexion.recibirMensaje();
            respuesta.procesar();
            SipsaPacMenu sipsaPacMenu = new SipsaPacMenu(this);
            sipsaPacMenu.setVisible(true);
        } catch (UnknownHostException ex) {
            new DialogoMensaje(DialogoMensaje.Tipo.Error, "Imposible conectar a: " + this.getHost() + "\n" + ex.getLocalizedMessage());
        } catch (IOException ex) {
            new DialogoMensaje(DialogoMensaje.Tipo.Error, "Imposible conectar a: " + this.getHost() + "\n" + ex.getLocalizedMessage());
        }
    }

    private void getListaOT() throws IOException, Exception{
        if (this.lista == null){
            Mensaje solicitud = MensajesFabrica.newSolicitudOrdenesDeTrabajo();
            solicitud.setContenido(this.pac);
            conexion.enviarMensaje(solicitud);
            Mensaje respuesta = conexion.recibirMensaje();
            respuesta.procesar();
        }
    }

    public void administrarOT() {
        ListarABM listarABM = new ListarABM(this);
        listarABM.setVisible(true);
    }

    public void mostrarReporteOTRealizadas() {
        //TODO filtrar la lista
        Reporte reporte = new Reporte();
        reporte.setNombre("Ordenes de Trabajo Realizadas");
        reporte.setDatos(this.getModelo());
        ReporteVisor reporteVisor = new ReporteVisor(reporte);
        reporteVisor.setVisible(true);
    }

    public void mostrarReporteOTPendientes() {
        //TODO filtrar la lista
        Reporte reporte = new Reporte();
        reporte.setNombre("Ordenes de Trabajo Pendientes");
        reporte.setDatos(this.getModelo());
        ReporteVisor reporteVisor = new ReporteVisor(reporte);
        reporteVisor.setVisible(true);
    }

    public void mostrarReporteOTVencidas() {
        //TODO filtrar la lista
        Reporte reporte = new Reporte();
        reporte.setNombre("Ordenes de Trabajo Vencidas");
        reporte.setDatos(this.getModelo());
        ReporteVisor reporteVisor = new ReporteVisor(reporte);
        reporteVisor.setVisible(true);
    }

    /**
     *
     * @param ordenDeTrabajo
     * @throws java.lang.Exception
     */
    public void aceptarDatos(OrdenDeTrabajo ordenDeTrabajo) throws Exception {
        Mensaje solicitud = MensajesFabrica.newSolicitudOrdenDeTrabajoGuardar();
        solicitud.setContenido(ordenDeTrabajo);
        conexion.enviarMensaje(solicitud);
        Mensaje respuesta = conexion.recibirMensaje();
        respuesta.procesar();
    }

    public void agregar() {
        OrdenDeTrabajoDatos ordenDeTrabajoDatos = new OrdenDeTrabajoDatos(this, new OrdenDeTrabajo());
        ordenDeTrabajoDatos.setVisible(true);
    }

    public void modificar(int index) {
        OrdenDeTrabajo ordenDeTrabajo = lista.get(index);
        ordenDeTrabajo.setEstado(EstadoOT.Activa);
        OrdenDeTrabajoDatos ordenDeTrabajoDatos = new OrdenDeTrabajoDatos(this, ordenDeTrabajo);
        ordenDeTrabajoDatos.setVisible(true);
    }

    public void eliminar(int index) {
        OrdenDeTrabajo ordenDeTrabajo = lista.get(index);
        ordenDeTrabajo.setEstado(EstadoOT.Anulada);
        OrdenDeTrabajoDatos ordenDeTrabajoDatos = new OrdenDeTrabajoDatos(this, ordenDeTrabajo);
        ordenDeTrabajoDatos.setVisible(true);
    }

    public String getDescripcion() {
        return "Administrar Ordenes de Trabajo";
    }

    public TableModel getModelo() {
        try {
            this.getListaOT();
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        String[] columnNames = {"Nro de Orden", "Estado", "Nro Serie de Producto"};
        DefaultTableModel modelo = new DefaultTableModel(columnNames, 0);
        for (Iterator otIt = this.lista.iterator(); otIt.hasNext();) {
            OrdenDeTrabajo ordenDeTrabajo = (OrdenDeTrabajo) otIt.next();
            Object[] datos = new Object[modelo.getColumnCount()];
            datos[0] = ordenDeTrabajo.getID();
            datos[1] = ordenDeTrabajo.getEstado().toString();
            datos[1] = ordenDeTrabajo.getVenta().getProductos().getNroSerie();
            modelo.addRow(datos);
        }
        return modelo;
    }

    /**
     * @return the host
     */
    public String getHost() {
        return host;
    }

    /**
     * @param host the host to set
     */
    public void setHost(String host) {
        this.host = host;
    }

    /**
     * @return the puerto
     */
    public int getPuerto() {
        return puerto;
    }

    /**
     * @param puerto the puerto to set
     */
    public void setPuerto(int puerto) {
        this.puerto = puerto;
    }

    /**
     * 
     * @param ordenDeTrabajo
     * @throws java.lang.Exception
     */
    public void guardarOrdenDeTrabajo(OrdenDeTrabajo ordenDeTrabajo) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public ComboBoxModel getListaPuntosDeVenta() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public ComboBoxModel getListaTiposProducto() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public ComboBoxModel getListaModelos(TipoProducto tipoProducto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
