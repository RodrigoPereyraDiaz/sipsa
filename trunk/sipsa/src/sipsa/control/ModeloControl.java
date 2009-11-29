package sipsa.control;

import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.ComboBoxModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import sipsa.SipsaExcepcion;
import sipsa.dominio.Modelo;
import sipsa.persistencia.Persistencia;
import sipsa.presentacion.escritorio.DialogoMensaje;
import sipsa.presentacion.escritorio.ListarABM;
import sipsa.presentacion.escritorio.ModeloDatos;
import sipsa.presentacion.interfaces.IListarABM;
import sipsa.presentacion.interfaces.IModeloDatos;

public class ModeloControl implements IListarABM, IModeloDatos {

    private ArrayList<Modelo> lista;
    private Persistencia persistencia = Persistencia.getPersistencia();

    private void recuperarLista() {
        lista = new ArrayList<Modelo>();
        try {
            for (Object modelo : persistencia.recuperarLista(Modelo.class)) {
                lista.add((Modelo) modelo);
            }
        } catch (SipsaExcepcion ex) {
            new DialogoMensaje(DialogoMensaje.Tipo.Error, ex.getLocalizedMessage());
        }
    }

    public void agregar() {
        Modelo modelo = new Modelo();
        ModeloDatos modeloDatos = new ModeloDatos(this, modelo);
        modeloDatos.setVisible(true);
        recuperarLista();
    }

    public void modificar(int index) {
        Modelo modelo = lista.get(index);
        ModeloDatos modeloDatos = new ModeloDatos(this, modelo);
        modeloDatos.setVisible(true);
        recuperarLista();
    }

    public void eliminar(int index) {
        try {
            Modelo modelo = lista.get(index);
            this.persistencia.eliminar(modelo);
            recuperarLista();
        } catch (SipsaExcepcion ex) {
            new DialogoMensaje(DialogoMensaje.Tipo.Error, ex.getLocalizedMessage());
        }
    }

    public String getDescripcion() {
        return "Modelo";
    }

    public TableModel getTableModel() {
        String[] columnNames = {"Tipo de Producto", "Modelo", "Duracion Garantia"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        recuperarLista();
        for (Iterator tpIt = lista.iterator(); tpIt.hasNext();) {
            Modelo modelo = (Modelo) tpIt.next();
            Object[] datos = new Object[tableModel.getColumnCount()];
            datos[0] = modelo.getTipoProducto().getNombre();
            datos[1] = modelo.getNombre();
            datos[2] = modelo.getDuracionGarantia();
            tableModel.addRow(datos);
        }
        return tableModel;
    }

    public void guardar(Modelo modelo) throws SipsaExcepcion {
        if (modelo.getNombre().equals("")) {
            throw new SipsaExcepcion("Debe completar el nombre del Modelo");
        }
        if (modelo.getDuracionGarantia() <= 0) {
            throw new SipsaExcepcion("La duración de la garantia debe ser mayor a 0 meses");
        }
        if (modelo.getTipoProducto() == null) {
            throw new SipsaExcepcion("Debe indicar el Tipo de Producto del Modelo");
        }
        if (modelo.getID() > 0) {
            persistencia.actualizar(modelo);
        } else {
            if (persistencia.existe(modelo) == null) {
                persistencia.guardar(modelo);
            } else {
                throw new SipsaExcepcion("El Modelo ya exite, Imposible agregar");
            }
        }
    }

    public ComboBoxModel getTiposProducto() {
        TipoProductoControl tipoProductoControl = new TipoProductoControl();
        return tipoProductoControl.getComboBox();
    }

    public void mostrarABM() {
        recuperarLista();
        ListarABM listarABM = new ListarABM(this);
        listarABM.setVisible(true);
    }

    /**
     * @return the lista
     */
    public ArrayList<Modelo> getListaModelos() {
        recuperarLista();
        return lista;
    }
}
