package sipsa.presentacion.interfaces;

import javax.swing.ComboBoxModel;
import sipsa.dominio.OrdenDeTrabajo;
import sipsa.dominio.TipoProducto;

public interface IOrdenDeTrabajoDatos {

    public void guardarOrdenDeTrabajo(OrdenDeTrabajo ordenDeTrabajo) throws Exception;
    public ComboBoxModel getListaPuntosDeVenta();
    public ComboBoxModel getListaTiposProducto();
    public ComboBoxModel getListaModelos(TipoProducto tipoProducto);
}
