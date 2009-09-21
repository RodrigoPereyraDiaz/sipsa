package Dominio.Controladores;

import BaseDatos.*;
import Dominio.Aplicacion.*;
import Presentacion.Interfaces.*;
import java.sql.SQLException;
import java.util.Vector;

public class ControladorABM {
    
    Vector ListClientes;
    Vector ListProveedores;
    IntermediarioClientes InterCli;
    IntermediarioProveedores InterPro;
     
    IntermediarioItems interIt;
    IntermediarioProductos iPro;
    ConcretoCreadorItems cci;
    Items item;
     
     
    /** Creates a new instance of ControladorABM */
    public ControladorABM() {
        ListClientes=new Vector();
        ListProveedores=new Vector();
        InterPro= new IntermediarioProveedores();
        InterCli= new IntermediarioClientes();
    }
    
     public ControladorABM(int tipoItem) {
          ListProveedores=new Vector();
          InterPro= new IntermediarioProveedores();
        iPro = new IntermediarioProductos();
        cci = new ConcretoCreadorItems();
        interIt = cci.getIntermediario(tipoItem);
        
        switch(tipoItem){
            case 0: item = new Articulos();
            break;
            case 1: item = new Productos();
            break;
            default: item = new Servicios();
        }
     }
    
     
      public Vector getListaItems(int id, String descri, float costo, int cArt, int cPre, int tipoItem)throws SQLException{
        item.setId(id);
        item.setDescripcion(descri);
        item.setCosto(costo);
        return (interIt.consultaItems(item, cArt, cPre, tipoItem));
    }
    
    public void modificarItem(int id, String descri, float costo, float precio)throws SQLException{
        item.setId(id);
        item.setDescripcion(descri);
        item.setCosto(costo);
        item.setPrecio(precio);
        
        interIt.modificarItem(item);
    }
    
    public Proveedores buscarProveedor(int idArt){
        IntermediarioArticulos iAr = new IntermediarioArticulos();

        return InterPro.getProveedor(iAr.buscarProveedor(idArt));
    }
    
    
    public void insertarItem(String descri, float costo, float precio)throws SQLException{
        item.setId(0);
        item.setDescripcion(descri);
        item.setCosto(costo);
        item.setPrecio(precio);
        
        interIt.insertarItem(item);
    }
    
    public void eliminarItem(int nro)throws SQLException{
        interIt.eliminarItem(nro);
    }
    
    public Vector calcularCostoPrecioProdu(Vector v)throws SQLException{
                
        IntermediarioArticulos iAr = new IntermediarioArticulos();
        
        return iAr.calcularCPProdu(v);
    }
    
     public Articulos getArti(int i){
                
        IntermediarioArticulos iAr = new IntermediarioArticulos();
        
        return (Articulos)iAr.getItem(i);
    }
    
    public int buscarId(){
        
        int i = iPro.buscarId();
        
        return i;
    }
    
    public void insertarArtiXProdu(int idPro, Vector v){

        iPro.insertarArtiXProdu(idPro,v);
    }
    
    public void addProveedorXArtic(int idArt, int idPro) throws SQLException{
        
        InterPro.addProveedorXArtic(idArt,idPro);
    }
    
    public void modifProveedorXArtic(int idArt, int idPro) throws SQLException{

        InterPro.modifProveedorXArtic(idArt,idPro);
    }
    
    public int buscarIdArti(){
        
        IntermediarioArticulos iAr = new IntermediarioArticulos();
        return iAr.buscarIdArti();
    }
    
    public Vector traerArti(int idPro){
        
        return iPro.traerArticulos(idPro);
    }

    public Vector getClientes(){ 
        
           ListClientes=InterCli.getLista();
          return (ListClientes);            
    }
    
    public Clientes getCliente(int id){
        
        Clientes cli=InterCli.getCliente(((Clientes)ListClientes.elementAt(id-1)).getNumero());
        return (cli);
    }
    
   
    public void actCliente(int id){
        
       AMClientes amCli= new AMClientes(new javax.swing.JFrame(), true);
       amCli.fecha.setText(amCli.getFecha());
       amCli.setTitle("Modificar Cliente");
   
       Clientes cli=InterCli.getCliente(id);
       
       amCli.Apellido.setText(cli.getApellido());      
       amCli.Dire.setText(cli.getDomicilio());
       amCli.Localidad.setText(cli.getLocalidad());
       amCli.MAil.setText(cli.getMail());
       amCli.Nombre.setText(cli.getNombre());
       amCli.Provincia.setText(cli.getProvincia());
       amCli.Tele.setText(cli.getTelefono());
       amCli.contra.setText(cli.getContraseña());
       amCli.diniCuit.setText(cli.getCuit_dni());
       amCli.fecha.setText(cli.getFechaAlta());
       amCli.iva.setText(cli.getIva());
       amCli.Nro.setText(String.valueOf(cli.getNumero()));
       
       amCli.setVisible(true);
    }
    

    public void amCliente(){
        AMClientes amCli= new AMClientes(new javax.swing.JFrame(), true);
        amCli.fecha.setText(amCli.getFecha());
        amCli.setTitle("Alta Cliente");
        amCli.setVisible(true);
    }
    
    public void agregarcli(String nro,String ape,String nom,String dire,String loc,String mail,String prov,String tele,String dc, String iva, String contra,String fecha) {
        Clientes cli= new Clientes();

        if (nro.equals("")){ //nuevo cliente
            cli.setNumero(0);
        }else{
            cli.setNumero(Integer.parseInt(nro));
        }
        cli.setApellido(ape);
        cli.setNombre(nom);
        cli.setDomicilio(dire);
        cli.setLocalidad(loc);
        cli.setMail(mail);
        cli.setProvincia(prov);
        cli.setTelefono(tele);
        cli.setCuit_dni(dc);
        cli.setIva(iva);
        cli.setContraseña(contra);
        cli.setFechaAlta(fecha);
        
        InterCli.guardarCliente(cli);
        
    }

    public void eliminarCli(int id) throws SQLException {
       InterCli.eliminarCli(id);
    }

    public Vector getProveedores() {
        ListProveedores=InterPro.getLista();
        return ListProveedores;
    }

    public Proveedores getProveedor(int id) {
       Proveedores pro=InterPro.getProveedor(((Proveedores)ListProveedores.elementAt(id-1)).getNumero());
        return (pro);
    }

    public void amProveedor() {
        AMProveedores amPro= new AMProveedores(new javax.swing.JFrame(), true);        
        amPro.setTitle("Alta Proveedor");
        amPro.setVisible(true);
    }

    public void agregarpro(String nro, String cod, String razon, String dnicuit, String domi, String tel, String mail, String iva, int formapedido) {
       Proveedores pro= new Proveedores();
        if (nro.equals("")){ //nuevo cliente
            pro.setNumero(0);
        }else{
            pro.setNumero(Integer.parseInt(nro));
        }
       pro.setCodigo(cod);
       pro.setRazonSocial(razon);
       pro.setCuit_dni(dnicuit);
       pro.setDomicilio(domi);
       pro.setTelefono(tel);
       pro.setMail(mail);
       pro.setIva(iva);       
       pro.setFormaPedido((FormaPedido)InterPro.getFormasPedido().elementAt(formapedido));

       InterPro.guardarProveedor(pro);
    }

    public void actProveedor(Integer id) {
     AMProveedores amPro= new AMProveedores(new javax.swing.JFrame(), true);
   
       amPro.setTitle("Modificar Proveedor");
   
       Proveedores pro=InterPro.getProveedor(id);
       amPro.cod.setText(pro.getCodigo());      
       amPro.Nro.setText(String.valueOf(pro.getNumero()));
       amPro.dniCuit.setText(pro.getCuit_dni());
       amPro.mail.setText(pro.getMail());
       amPro.iva.setText(pro.getIva());
       amPro.tel.setText(pro.getTelefono());
       amPro.dire.setText(pro.getDomicilio());
       Vector LFormaP=InterPro.getFormasPedido();

       amPro.CFormaPedido.setSelectedIndex(((FormaPedido)pro.getFormaPedido()).getId()-1);
       amPro.razonsocial.setText(pro.getRazonSocial());

       amPro.setVisible(true);
    }

    public void eliminarPro(Integer id) throws SQLException{
       InterPro.eliminarPro(id);
    }
    

}
