package sipsa.control.servicios;

import java.io.IOException;

import java.net.Socket;
import java.net.UnknownHostException;

import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;

import sipsa.SipsaExcepcion;
import sipsa.control.OTControl;
import sipsa.control.Reporte;
import sipsa.dominio.OrdenDeTrabajo;
import sipsa.dominio.Pac;
import sipsa.dominio.TipoProducto;
import sipsa.presentacion.escritorio.DialogoMensaje;
import sipsa.presentacion.escritorio.ListarABM;
import sipsa.presentacion.escritorio.Login;
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
public class Cliente extends OTControl implements ILogin, ISipsaPacMenu, IOrdenDeTrabajoDatos, IListarABM {

    private String host = "localhost";
    private int puerto = 1027;
    private static Cliente cliente;

    private Cliente() {
    }

    /**
     * Obtiene el Cliente
     * @return devuelve un objeto de tipo Cliente
     */
    public static Cliente getCliente() {
        if (cliente == null) {
            cliente = new Cliente();
        }
        return cliente;
    }

    void handelError(Exception exception) throws Exception {
        throw exception;
    }

    void handelOK(String mensaje) {
        new DialogoMensaje(DialogoMensaje.Tipo.Información, mensaje);
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

    public void getListaOT() throws IOException, Exception {
        if (this.lista == null) {
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
    @Override
    public void guardarOrdenDeTrabajo(OrdenDeTrabajo ordenDeTrabajo) throws SipsaExcepcion {
        //TODO Validar Datos correctos segun el estado de la orden
        if (ordenDeTrabajo.getFechaEntrega().before(new Date(System.currentTimeMillis()))) {
            throw new SipsaExcepcion("La fecha de entrega no puede ser anterior a al dia de hoy");
        }
        Mensaje solicitud = MensajesFabrica.newSolicitudOrdenDeTrabajoGuardar();
        solicitud.setContenido(ordenDeTrabajo);
        try {
            conexion.enviarMensaje(solicitud);
            Mensaje respuesta = conexion.recibirMensaje();
            respuesta.procesar();
            this.listaOdts.add(ordenDeTrabajo);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new SipsaExcepcion("Error solicitando al servidor que guarde la orden de trabajo");
        }
    }

    @Override
    public ComboBoxModel getListaPuntosDeVenta() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ComboBoxModel getListaTiposProducto() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ComboBoxModel getListaModelos(Object tipoProducto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
