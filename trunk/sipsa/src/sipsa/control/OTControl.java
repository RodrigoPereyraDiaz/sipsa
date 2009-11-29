package sipsa.control;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import sipsa.SipsaExcepcion;
import sipsa.dominio.EstadoOT;
import sipsa.dominio.OrdenDeTrabajo;
import sipsa.dominio.Pac;
import sipsa.dominio.Producto;
import sipsa.dominio.Venta;
import sipsa.persistencia.Persistencia;
import sipsa.presentacion.escritorio.DialogoMensaje;
import sipsa.presentacion.escritorio.ListarABM;
import sipsa.presentacion.escritorio.OrdenDeTrabajoDatos;
import sipsa.presentacion.interfaces.IListarABM;
import sipsa.presentacion.interfaces.IOrdenDeTrabajoDatos;

/**
 * Controlador de Ordenes de Trabajo
 * @author Claudio Rodrigo Pereyra Diaz
 * @author Maria Eugenia Sanchez
 */
public class OTControl implements IListarABM, IOrdenDeTrabajoDatos {

    private Persistencia persistencia = Persistencia.getPersistencia();
    protected List<OrdenDeTrabajo> lista;

    protected void recuperarLista() {
        lista = new ArrayList<OrdenDeTrabajo>();
        try {
            for (Iterator iterator = persistencia.recuperarLista(OrdenDeTrabajo.class).iterator(); iterator.hasNext();) {
                OrdenDeTrabajo ordenDeTrabajo = (OrdenDeTrabajo) iterator.next();
                lista.add(ordenDeTrabajo);
            }
        } catch (SipsaExcepcion ex) {
            new DialogoMensaje(DialogoMensaje.Tipo.Error, ex.getLocalizedMessage());
        }
    }

    /**
     * Muestra el formulario para administrar Ordenes de Trabajo
     */
    public void mostrarABM() {
        recuperarLista();
        ListarABM listarABM = new ListarABM(this);
        listarABM.setVisible(true);
    }

    public void agregar() {
        OrdenDeTrabajo ordenDeTrabajo = new OrdenDeTrabajo();
        OrdenDeTrabajoDatos ordenDeTrabajoDatos = new OrdenDeTrabajoDatos(this, ordenDeTrabajo);
        ordenDeTrabajoDatos.setVisible(true);
        recuperarLista();
    }

    public void modificar(int index) {
        OrdenDeTrabajo ordenDeTrabajo = lista.get(index);
        OrdenDeTrabajoDatos ordenDeTrabajoDatos = new OrdenDeTrabajoDatos(this, ordenDeTrabajo);
        ordenDeTrabajoDatos.setVisible(true);
        recuperarLista();
    }

    public void eliminar(int index) {
        OrdenDeTrabajo ordenDeTrabajo = lista.get(index);
        ordenDeTrabajo.setEstado(EstadoOT.Anulada);
        OrdenDeTrabajoDatos ordenDeTrabajoDatos = new OrdenDeTrabajoDatos(this, ordenDeTrabajo);
        ordenDeTrabajoDatos.setVisible(true);
        recuperarLista();
    }

    public String getDescripcion() {
        return "Orden de Trabajo";
    }

    public TableModel getTableModel() {
        String[] columnNames = {"Nro de Orden", "Estado", "Pac"};
        DefaultTableModel modelo = new DefaultTableModel(columnNames, 0);
        recuperarLista();
        for (Iterator it = lista.iterator(); it.hasNext();) {
            OrdenDeTrabajo ordenDeTrabajo = (OrdenDeTrabajo) it.next();
            if (ordenDeTrabajo.getEstado().equals(EstadoOT.Activa)) {
                Object[] fila = new Object[modelo.getColumnCount()];
                fila[0] = ordenDeTrabajo.getID();
                fila[1] = ordenDeTrabajo.getEstado();
                fila[2] = ordenDeTrabajo.getPac().getNombre();
                modelo.addRow(fila);
            }
        }
        return modelo;
    }

    /**
     * Obtiene la lista de Ordenes de Trabajo realizadas
     * @return devuelve una lista de ordenes de Trabajo realizadas para mostrar en la tabla
     */
    public TableModel getOTRealizadas(Date fechaDesde, Date fechaHasta) {
        String[] columnNames = {"Nro de Orden", "Estado", "Fecha Entregado", "Pac"};
        DefaultTableModel modelo = new DefaultTableModel(columnNames, 0);
        recuperarLista();
        for (Iterator it = lista.iterator(); it.hasNext();) {
            OrdenDeTrabajo ordenDeTrabajo = (OrdenDeTrabajo) it.next();
            if (ordenDeTrabajo.getEstado().equals(EstadoOT.Finalizada) && ordenDeTrabajo.getFechaEntrega().after(fechaDesde) && ordenDeTrabajo.getFechaEntrega().before(fechaHasta)) {
                Object[] fila = new Object[modelo.getColumnCount()];
                fila[0] = ordenDeTrabajo.getID();
                fila[1] = ordenDeTrabajo.getEstado();
                fila[2] = ordenDeTrabajo.getFechaEntrega().toString();
                fila[3] = ordenDeTrabajo.getPac().getNombre();
                modelo.addRow(fila);
            }
        }
        return modelo;
    }

    /**
     * Obtiene la lista de Ordenes de Trabajo Pendientes
     * @return devuelve una lista de ordenes de trabajo pendientes para mostrar en la tabla
     */
    public TableModel getOTPendientes() {
        String[] columnNames = {"Nro de Orden", "Estado", "Fecha a Entregar", "Pac"};
        DefaultTableModel modelo = new DefaultTableModel(columnNames, 0);
        recuperarLista();
        for (Iterator it = lista.iterator(); it.hasNext();) {
            OrdenDeTrabajo ordenDeTrabajo = (OrdenDeTrabajo) it.next();
            if (ordenDeTrabajo.getEstado().equals(EstadoOT.Activa)) {
                Object[] fila = new Object[modelo.getColumnCount()];
                fila[0] = ordenDeTrabajo.getID();
                fila[1] = ordenDeTrabajo.getEstado();
                fila[2] = ordenDeTrabajo.getFechaEntrega().toString();
                fila[3] = ordenDeTrabajo.getPac().getNombre();
                modelo.addRow(fila);
            }

        }
        return modelo;
    }

    /**
     * Obtiene la lista de Ordenes de Trabajo Vencidas
     * @return devuelve una lista de Ordenes de Trabajo vencidas
     */
    public TableModel getOTVencidas() {
        String[] columnNames = {"Nro de Orden", "Estado", "Dias Vencida", "Pac"};
        DefaultTableModel modelo = new DefaultTableModel(columnNames, 0);
        recuperarLista();
        for (Iterator it = lista.iterator(); it.hasNext();) {
            OrdenDeTrabajo ordenDeTrabajo = (OrdenDeTrabajo) it.next();
            if (ordenDeTrabajo.getEstado().equals(EstadoOT.Activa) && ordenDeTrabajo.getFechaEntrega().before(new Date(System.currentTimeMillis()))) {
                Object[] fila = new Object[modelo.getColumnCount()];
                fila[0] = ordenDeTrabajo.getID();
                fila[1] = ordenDeTrabajo.getEstado();
                Date hoy = new Date(System.currentTimeMillis());
                fila[2] = (hoy.getTime() - ordenDeTrabajo.getFechaEntrega().getTime()) / 86400000;
                fila[3] = ordenDeTrabajo.getPac().getNombre();
                modelo.addRow(fila);
            }
        }
        return modelo;
    }

    /**
     * Guarda una orden de trabajo en el sistema Sipsa
     * @param ordenDeTrabajo
     * @throws java.lang.Exception Lanza una excepción si no se puede guardar
     * la orden de Trabajo
     */
    public void guardarOrdenDeTrabajo(OrdenDeTrabajo ordenDeTrabajo) throws SipsaExcepcion {
        if (ordenDeTrabajo.getFechaEntrega().before(new Date(System.currentTimeMillis()))) {
            throw new SipsaExcepcion("La fecha de entrega no puede ser anterior a al dia de hoy");
        }
        if (ordenDeTrabajo.getObservaciones().equals("")) {
            throw new SipsaExcepcion("Debe completar la observacion del trabajo a realizar");
        }
        switch (ordenDeTrabajo.getEstado()) {
            case Nueva:
                Venta venta = ordenDeTrabajo.getVenta();
                venta.setProducto((Producto) persistencia.existe(venta.getProducto()));
                venta = (Venta) persistencia.existe(venta);
                if (venta == null) {
                    throw new SipsaExcepcion("La venta no se encuentra registra en el sistema");
                }
                if (venta.isProductoEnGarantia()) {
                    ordenDeTrabajo.setEstado(EstadoOT.Activa);
                    ordenDeTrabajo.setVenta(venta);
                    persistencia.guardar(ordenDeTrabajo);
                } else {
                    new DialogoMensaje(DialogoMensaje.Tipo.Información, "Garantia del producto vencida");
                }
                break;
            case Activa:
                persistencia.actualizar(ordenDeTrabajo);
                break;
            case Finalizada:
                if (ordenDeTrabajo.getMotivoEstado().equals("")) {
                    throw new SipsaExcepcion("Debe completar el motivo del estado Finalizada");
                }
                persistencia.actualizar(ordenDeTrabajo);
                break;
            case Anulada:
                if (ordenDeTrabajo.getMotivoEstado().equals("")) {
                    throw new SipsaExcepcion("Debe completar el motivo del estado Anulada");
                }
                persistencia.actualizar(ordenDeTrabajo);
                break;
        }
        recuperarLista();
    }

    /**
     * Obtiene una lista de Puntos de Venta
     * @return devuelve una lista de PV para cargar el ComboBOx
     */
    public ComboBoxModel getListaPuntosDeVenta() {
        PvControl pvControl = new PvControl();
        DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel();
        for (Object o : pvControl.getListaPvs()) {
            comboBoxModel.addElement(o);
        }
        return comboBoxModel;
    }

    /**
     * Obtiene la lista de Modelos para un Tipo de Producto específico
     * @param tipoProducto
     * @return devuelve una lista de Modelos para un Tipo de Prod específico,
     * para cargar el ComboBox
     */
    public ComboBoxModel getListaModelos() {
        ModeloControl modeloControl = new ModeloControl();
        DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel();
        for (Object o : modeloControl.getListaModelos()) {
            comboBoxModel.addElement(o);
        }
        return comboBoxModel;
    }

    public List<OrdenDeTrabajo> getListaOT(Pac pac) {
        recuperarLista();
        //TODO Filtrar solo por el pac
        return lista;
    }

    public Pac getPac() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
