package sipsa.presentacion.interfaces;

import javax.swing.ComboBoxModel;
import sipsa.SipsaExcepcion;
import sipsa.dominio.Modelo;

public interface IModeloDatos {

    public void guardar(Modelo modelo) throws SipsaExcepcion;
    public ComboBoxModel getTiposProducto();
}
