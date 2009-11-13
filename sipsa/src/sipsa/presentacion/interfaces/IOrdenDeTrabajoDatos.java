package sipsa.presentacion.interfaces;

import javax.swing.ComboBoxModel;
import sipsa.dominio.OrdenDeTrabajo;
import sipsa.dominio.TipoProducto;

public interface IOrdenDeTrabajoDatos {

    public void guardarOrdenDeTrabajo(OrdenDeTrabajo ordenDeTrabajo) throws Exception;
    //TODO ver si es necesario y si esta bien usar un ComboBoxModel
    public ComboBoxModel getListaPuntosDeVenta();
    public ComboBoxModel getListaTiposProducto();
    public ComboBoxModel getListaModelos(TipoProducto tipoProducto);
    
    @Deprecated
    void aceptarDatos(OrdenDeTrabajo ordenDeTrabajo) throws Exception;
}
