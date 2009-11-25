package sipsa.control.servicios;

import java.io.IOException;

import java.net.Socket;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.swing.ComboBoxModel;

import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import sipsa.SipsaExcepcion;
import sipsa.control.OTControl;
import sipsa.control.PvControl;
import sipsa.control.Reporte;
import sipsa.control.TipoProductoControl;
import sipsa.dominio.OrdenDeTrabajo;
import sipsa.dominio.Pac;
import sipsa.dominio.TipoProducto;
import sipsa.presentacion.escritorio.DialogoMensaje;
import sipsa.presentacion.escritorio.ListarABM;
import sipsa.presentacion.escritorio.Login;
import sipsa.presentacion.escritorio.RangoFechas;
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

    void handelError(SipsaExcepcion exception) throws SipsaExcepcion {
        throw exception;
    }

    void handelOK(Object respuesta) {
        if (respuesta.getClass().equals(Pac.class)) {
            this.pac = (Pac) respuesta;
        }
        if (respuesta.getClass().equals(String.class)) {
            new DialogoMensaje(DialogoMensaje.Tipo.Información, respuesta.toString());
        }
    //TODO otras respuestas
    }

    void handleOrdenesDeTrabajo(List<OrdenDeTrabajo> lista) {
        this.lista = lista;
    }

//TODO Completar la clase cliente que es controlador del cliente pac
    private Conexion conexion;
    private Pac pac;

    /**
     * Muestra la pantalla de Login
     */
    public void iniciar() {
        Login login = new Login(cliente);
        login.setVisible(true);
    }

    public void ingresar(String cuit) throws SipsaExcepcion {
        Mensaje login = MensajesFabrica.newSolicitudLogin();
        Pac pacLogin = new Pac();
        pacLogin.setCuit(cuit);
        login.setContenido(pacLogin);
        try {
            this.conexion = new Conexion(new Socket(getHost(), getPuerto()));
            conexion.enviarMensaje(login);
            Mensaje respuesta = conexion.recibirMensaje();
            respuesta.procesar();
            recuperarLista();
            SipsaPacMenu sipsaPacMenu = new SipsaPacMenu(this);
            sipsaPacMenu.setVisible(true);
        } catch (IOException ex) {
            throw new SipsaExcepcion("Imposible conectar a: " + this.getHost() + "\n" + ex.getLocalizedMessage());
        }
    }

    @Override
    protected void recuperarLista() {
        if (this.lista == null) {
            try {
                Mensaje solicitud = MensajesFabrica.newSolicitudOrdenesDeTrabajo();
                solicitud.setContenido(this.pac);
                conexion.enviarMensaje(solicitud);
                Mensaje respuesta = conexion.recibirMensaje();
                respuesta.procesar();
            } catch (Exception ex) {
                new DialogoMensaje(DialogoMensaje.Tipo.Error, ex.getLocalizedMessage());
            }
        }
    }

    public void administrarOT() {
        ListarABM listarABM = new ListarABM(this);
        listarABM.setVisible(true);
    }

    public void mostrarReporteOTRealizadas() {
        RangoFechas rangoFechas = new RangoFechas();
        rangoFechas.setVisible(true);
        if (rangoFechas.getReturnStatus() == RangoFechas.RET_OK) {
            Reporte reporte = new Reporte();
            reporte.setNombre("Ordenes de Trabajo Realizadas");
            reporte.setDatos(this.getOTRealizadas(rangoFechas.getFechaDesde(), rangoFechas.getFechaHasta()));
            ReporteVisor reporteVisor = new ReporteVisor(reporte);
            reporteVisor.setVisible(true);
        }
    }

    public void mostrarReporteOTPendientes() {
        //TODO filtrar la lista
        Reporte reporte = new Reporte();
        reporte.setNombre("Ordenes de Trabajo Pendientes");
        reporte.setDatos(this.getOTPendientes());
        ReporteVisor reporteVisor = new ReporteVisor(reporte);
        reporteVisor.setVisible(true);
    }

    public void mostrarReporteOTVencidas() {
        //TODO filtrar la lista
        Reporte reporte = new Reporte();
        reporte.setNombre("Ordenes de Trabajo Vencidas");
        reporte.setDatos(this.getOTVencidas());
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
            this.lista.add(ordenDeTrabajo);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new SipsaExcepcion("Error solicitando al servidor que guarde la orden de trabajo");
        }
    }

    /**
     * Obtiene una lista de Puntos de Venta
     * @return devuelve una lista de PV para cargar el ComboBOx
     */
    @Override
    public ComboBoxModel getListaPuntosDeVenta() {
        PvControl pvControl = new PvControl();
        DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel(pvControl.getListaPvs().toArray());
        return comboBoxModel;
    }

    /**
     * Obtiene la lista de Tipos de Productos
     * @return devuelve una lista de Tipos de Productos para cargar el ComboBox
     */
    @Override
    public ComboBoxModel getListaTiposProducto() {
        TipoProductoControl tipoProductoControl = new TipoProductoControl();
        DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel(tipoProductoControl.getListaTipoProducto().toArray());
        return comboBoxModel;
    }

    /**
     * Obtiene la lista de Modelos para un Tipo de Producto específico
     * @param tipoProducto
     * @return devuelve una lista de Modelos para un Tipo de Prod específico,
     * para cargar el ComboBOx
     */
    @Override
    public ComboBoxModel getListaModelos(Object tipoProducto) {
        TipoProducto tp = (TipoProducto) tipoProducto;
        DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel(tp.getModelos().toArray());
        return comboBoxModel;
    }

    @Override
    public TableModel getModelo() {
        String[] columnNames = {"Nro de Orden", "Estado"};
        DefaultTableModel modelo = new DefaultTableModel(columnNames, 0);
        for (Iterator it = lista.iterator(); it.hasNext();) {
            OrdenDeTrabajo ordenDeTrabajo = (OrdenDeTrabajo) it.next();
            Object[] fila = new Object[modelo.getColumnCount()];
            fila[0] = ordenDeTrabajo.getID();
            fila[1] = ordenDeTrabajo.getEstado();
            modelo.addRow(fila);
        }
        return modelo;
    }

    /**
     * Obtiene la lista de Ordenes de Trabajo realizadas
     * @return devuelve una lista de ordenes de Trabajo realizadas para mostrar en la tabla
     */
    @Override
    public TableModel getOTRealizadas(Date fechaDesde, Date fechaHasta) {
        //TODO completar con todos los datos de la orden para visualizar en el reporte
        String[] columnNames = {"Nro de Orden", "Estado"};
        DefaultTableModel modelo = new DefaultTableModel(columnNames, 0);
        //TODO filtrar solo las ordenes de trabajo realizadas
        List<OrdenDeTrabajo> lista = new ArrayList<OrdenDeTrabajo>();
        for (Iterator it = lista.iterator(); it.hasNext();) {
            OrdenDeTrabajo ordenDeTrabajo = (OrdenDeTrabajo) it.next();
            Object[] fila = new Object[modelo.getColumnCount()];
            fila[0] = ordenDeTrabajo.getID();
            fila[1] = ordenDeTrabajo.getEstado();
            fila[2] = ordenDeTrabajo.getPac().getNombre();
            modelo.addRow(fila);
        }
        return modelo;
    }

    /**
     * Obtiene la lista de Ordenes de Trabajo Pendientes
     * @return devuelve una lista de ordenes de trabajo pendientes para mostrar en la tabla
     */
    @Override
    public TableModel getOTPendientes() {
        //TODO completar con todos los datos de la orden para visualizar en el reporte
        String[] columnNames = {"Nro de Orden", "Estado"};
        DefaultTableModel modelo = new DefaultTableModel(columnNames, 0);
        //TODO filtrar solo las ordenes de trabajo Pendientes
        List<OrdenDeTrabajo> lista = new ArrayList<OrdenDeTrabajo>();
        for (Iterator it = lista.iterator(); it.hasNext();) {
            OrdenDeTrabajo ordenDeTrabajo = (OrdenDeTrabajo) it.next();
            Object[] fila = new Object[modelo.getColumnCount()];
            fila[0] = ordenDeTrabajo.getID();
            fila[1] = ordenDeTrabajo.getEstado();
            modelo.addRow(fila);
        }
        return modelo;
    }

    /**
     * Obtiene la lista de Ordenes de Trabajo Vencidas
     * @return devuelve una lista de Ordenes de Trabajo vencidas
     */
    @Override
    public TableModel getOTVencidas() {
        //TODO completar con todos los datos de la orden para visualizar en el reporte
        String[] columnNames = {"Nro de Orden", "Estado"};
        DefaultTableModel modelo = new DefaultTableModel(columnNames, 0);
        //TODO filtrar solo las ordenes de trabajo vencidas
        List<OrdenDeTrabajo> lista = new ArrayList<OrdenDeTrabajo>();
        for (Iterator it = lista.iterator(); it.hasNext();) {
            OrdenDeTrabajo ordenDeTrabajo = (OrdenDeTrabajo) it.next();
            Object[] fila = new Object[modelo.getColumnCount()];
            fila[0] = ordenDeTrabajo.getID();
            fila[1] = ordenDeTrabajo.getEstado();
            modelo.addRow(fila);
        }
        return modelo;
    }
}
