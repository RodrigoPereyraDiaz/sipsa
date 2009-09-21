package BaseDatos;
import Dominio.Aplicacion.*;
import java.io.*;
import java.sql.*;
import java.text.*;
import java.util.Date;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.JTable;

public class IntermediarioPresupuestos extends Intermediarios {
    
    Presupuestos Presu;
 
    Vector listaArtiProd;


    public IntermediarioPresupuestos() {
      listaArtiProd = new Vector();
    }
    
    
    
    
    
    public void crearPresupuesto(String Fecha){
        Presu=new Presupuestos();
        Presu.setFecha(Fecha);
        Presu.setNumero(this.getNumPresu());
          System.out.println(this.getNumPresu());
        Presu.setTotal(0);
    }

    public void asignarCliente(Clientes Cli){
        Presu.setCliente(Cli);
    }
    
    public void addItemPresupuesto(int IdItem, int Cant, int Tipo)throws NumberFormatException{
        
        CreadorItems ci;
        ci= new ConcretoCreadorItems();
        IntermediarioItems InterItem= ci.getIntermediario(Tipo);
        Presu.setEspecificacionItem(InterItem.getItem(IdItem),Cant,Tipo);
        Presu.setCosto(Presu.getCosto()+(InterItem.getItem(IdItem).getCosto()*Cant));
        Presu.setTotal(Presu.getTotal()+(InterItem.getItem(IdItem).getPrecio()*Cant));
    }
    
    public EspecificacionItem getItemPresupuesto(int id){
          Vector Lis=Presu.getEspecificacionItem();
        return (EspecificacionItem)Lis.elementAt(id);
    }
    
    public void eliminarItem(int id){
         Presu.deleteItem(id);
    }
    
    public Vector getLista(){
        Vector Lista = null;
         Sql SQL=Sql.getIntancia();
         Connection con= SQL.conectar();
         Connection con2= SQL.conectar();
         Connection con3= SQL.conectar();
        
         try {
             CallableStatement callableStatement = con.prepareCall("getPresupuestos"); 
             ResultSet resultSet = callableStatement.executeQuery(); 
             Lista = new Vector();
         
             while (resultSet.next()) {
                 Presupuestos presu = new Presupuestos();
                 Clientes cli = new Clientes ();                
                 presu.setNumero(resultSet.getInt("IdPresupuesto"));                 
                 cli.setNumero(resultSet.getInt("IdCliente"));
                 cli.setApellido(resultSet.getString("Apellido"));
                 cli.setNombre(resultSet.getString("Nombre"));
                 presu.setCliente(cli);
                 SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                 String outputF = formatter.format(resultSet.getDate("Fecha"));
                 presu.setFecha(outputF);  
                 presu.setTotal(resultSet.getFloat("Total"));
                 presu.setAprobado(resultSet.getInt("Aprobado"));
                 presu.setRechazado(resultSet.getInt("Rechazado"));
                 presu.setCosto(resultSet.getFloat("Costo"));
                 
                 CallableStatement callableStatement2 = con2.prepareCall("{call getArtiPresu(?)}"); //de la tabla ArtxPresupuesto
                 callableStatement2.setInt(1,presu.getNumero());                   
                 ResultSet resultSet2 = callableStatement2.executeQuery(); 
                 CreadorItems ci;
                 ci= new ConcretoCreadorItems();
                 while (resultSet2.next()) {                     
                     IntermediarioItems InterItems=ci.getIntermediario(0);
                     presu.setEspecificacionItem(InterItems.getItem(resultSet2.getInt("IdArticulo")),resultSet2.getInt("Cantidad"),0);
                 }
                 
                 callableStatement2 = con2.prepareCall("{call getServixPresu(?)}");
                 callableStatement2.setInt(1,presu.getNumero());  
                 resultSet2 = callableStatement2.executeQuery(); 
                 while (resultSet2.next()) {
                     IntermediarioItems InterItems=ci.getIntermediario(2);
                     presu.setEspecificacionItem(InterItems.getItem(resultSet2.getInt("IdServicio")),resultSet2.getInt("Cantidad"),2);
                 }
                 
                 callableStatement2 = con2.prepareCall("{call getProdxPresu(?)}");
                 callableStatement2.setInt(1,presu.getNumero()); 
                 resultSet2 = callableStatement2.executeQuery();
                 while (resultSet2.next()) {
                     IntermediarioItems InterItems=ci.getIntermediario(1);
                     int IdProd=resultSet2.getInt("IdProducto");
                     Productos p=(Productos)InterItems.getItem(IdProd);
                     CallableStatement callableStatement3 = con3.prepareCall("{call getArtixProdu(?)}"); //de la tabla ArticulosxProd
                     callableStatement3.setInt(1,IdProd); 
                     ResultSet resultSet3 = callableStatement3.executeQuery();
                     IntermediarioItems InterItems2=ci.getIntermediario(0);
                     while (resultSet3.next()) {            
                         int id_art=resultSet3.getInt("IdArticulo");
                         int cant=resultSet3.getInt("Cantidad");
                        for(int i=0;i<cant;i++){                            
                         Articulos art =(Articulos) InterItems2.getItem(id_art);                         
                         p.add(art);
                        }
                     }
                     
                     presu.setEspecificacionItem(p,resultSet2.getInt("Cantidad"),1);
                 }
                 
                 Lista.addElement(presu);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
       return Lista;
        
        
    }
    
   
      
 public Vector getListaPresuAprobProd(int idCli) {
        Vector Lista = new Vector();
        Vector ListaAproProd = new Vector();
        Lista = this.getListaP(idCli);
        for(int i = 0; i < Lista.size(); i++){
          
           Presu = (Presupuestos)Lista.elementAt(i);
           Clientes cli = Presu.getCliente();
           if ((cli.getNumero()==idCli | idCli==0) & (Presu.getAprobado()==1)){
                ListaAproProd.addElement(Lista.elementAt(i));
           }
        }
        return ListaAproProd;
    }
 
   public int getNumPresu(){
        int nro=0;
        try{   
          Sql SQL=Sql.getIntancia();
          Connection con= SQL.conectar(); 
          CallableStatement callableStatement = con.prepareCall("getNroID"); 
          ResultSet resultSet= callableStatement.executeQuery(); 
          resultSet.next();
          nro=resultSet.getInt("Numero");
        }catch (SQLException e){
             e.printStackTrace();
        }
        return nro;    
       
    }
     
     public void finalizarPresupuesto() throws NullPointerException {
         try{    
             Sql SQL=Sql.getIntancia();
             Connection con= SQL.conectar();
            int val=0;      
             System.out.println(Presu.getNumero());
            PreparedStatement preparedStatement = con.prepareStatement("insert into Presupuestos  values ("+Presu.getCliente().getNumero()+","+"'"+Presu.getFecha()+"'"+","+Presu.getTotal()+","+val+","+val+","+val+","+Presu.getCosto()+")");
            preparedStatement.executeUpdate();
            Vector Items=Presu.getEspecificacionItem();
            String Tabla; 
            for(int i=0;i<Items.size();i++){
               EspecificacionItem Espe=(EspecificacionItem)Items.elementAt(i);
               switch(Espe.getTipo()){
                         case 0:
                             Tabla="ArticulosXPresupuesto";
                         break;
                         case 1:
                             Tabla="ProductosXPresupuesto";
                         break;
                         default:
                             Tabla="ServiciosXPresupuesto";                             
               }  
             
               PreparedStatement preparedStatement2 = 
               con.prepareStatement("insert into "+Tabla+" values ("+Espe.getItem().getId()+","+Presu.getNumero()+","+Espe.getCantidad()+")");
               preparedStatement2.executeUpdate();
               con.commit();
            }
          }catch(SQLException e){
              e.printStackTrace();
          }
      }

  
     
        
     
     public Vector getProductos(int[] nroPresu) {     //version Adriana   
        int idArti, idProdu, j, posicion = 0;
        float canti;
        boolean esta;
        Sql SQL=Sql.getIntancia();
        Connection con= SQL.conectar();
        CallableStatement callableStatement;
        ResultSet resultSet;
        try{
            for (int i=0; i<nroPresu.length; i++){
            callableStatement = con.prepareCall("{call getArtiPresu(?)}"); 
            callableStatement.setInt(1,nroPresu[i]);
            resultSet = callableStatement.executeQuery();
            while(resultSet.next()){
                idArti = resultSet.getInt("IdArticulo");
                canti = resultSet.getFloat("Cantidad");
                esta = false;
                j = 0;
                    while ((!esta) && (j < listaArtiProd.size())){
                        int esArti = (Integer)listaArtiProd.elementAt(j);
                        int idA = (Integer)listaArtiProd.elementAt(j+1);
                        if ((esArti == 0) && (idArti == idA)){
                            esta = true;
                            posicion = j;
                        }
                        j = j+3;
                    }
                    if (esta){
                        canti = canti + (Float)listaArtiProd.elementAt(posicion+2);
                        listaArtiProd.set(posicion+2,canti);
                
                    }else{
                        listaArtiProd.add(0);
                        listaArtiProd.add(idArti);
                        listaArtiProd.add(canti);
                    }
            }
            callableStatement = con.prepareCall("{call getProPresu(?)}"); 
            callableStatement.setInt(1,nroPresu[i]);
            resultSet = callableStatement.executeQuery();
            while(resultSet.next()){
                idProdu = resultSet.getInt("IdProducto");
                canti = resultSet.getFloat("Cantidad");
                esta = false;
                j = 0;
                    while ((!esta) && (j < listaArtiProd.size())){
                        int esProdu = (Integer)listaArtiProd.elementAt(j);
                        int idPro = (Integer)listaArtiProd.elementAt(j+1);
                        if ((esProdu == 1) && (idProdu == idPro)){
                            esta = true;
                            posicion = j;
                        }
                        j = j+3;
                    }
                    if (esta){
                        canti = canti + (Float)listaArtiProd.elementAt(posicion+2);
                        listaArtiProd.set(posicion+2,canti);
                    }else{
                        listaArtiProd.add(1);
                        listaArtiProd.add(idProdu);
                        listaArtiProd.add(canti);
                    }
            }
            }    
        }catch(Exception e){
            e.printStackTrace();
        }
         return  listaArtiProd;
    }
    public void ActPresupuestos(Vector p) {
        String accion=(String)p.lastElement();
        String presu;
        int i=0;
        Sql SQL=Sql.getIntancia();
        Connection con= SQL.conectar();
        while(!(presu=(String)p.elementAt(i)).equals(accion)){
            try{
                
                CallableStatement callableStatement = con.prepareCall("{call ActPresu(?,?)}"); 
                callableStatement.setInt(1,Integer.parseInt(presu));
                callableStatement.setString(2,accion);
                callableStatement.executeUpdate();  
            }catch(SQLException e){
                System.out.println(e.getMessage()+": No se puede actualizar los presupuestos");
            }
            i++;
        }
    }

   
public Vector getListaP(int idCli) {
        Vector Lista = null;
        Sql SQL=Sql.getIntancia();
         Connection con= SQL.conectar();
        try {
             CallableStatement callableStatement = con.prepareCall("{call getPresupuestoAprobados(?)}"); 
             callableStatement.setInt(1,idCli);
             ResultSet resultSet = callableStatement.executeQuery(); 
             Lista = new Vector();
         
             while (resultSet.next()) {
                 Presupuestos presu = new Presupuestos();
                 Clientes cli = new Clientes ();
                 presu.setNumero(resultSet.getInt("IdPresupuesto"));
                 cli.setNumero(resultSet.getInt("IdCliente"));
                 cli.setApellido(resultSet.getString("Apellido"));
                 cli.setNombre(resultSet.getString("Nombre"));
                 presu.setCliente(cli);
                 SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                 String outputF = formatter.format(resultSet.getDate("Fecha"));
                 presu.setFecha(outputF); 
                 presu.setTotal(resultSet.getFloat("Total"));
                 presu.setAprobado(resultSet.getInt("Aprobado"));

                 Lista.addElement(presu);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
       return Lista;
    }
    
  
  public Vector obtenerBeneficios(String fdesde, String fhasta, int filtro) throws Exception{
        Vector LPresus=new Vector();
               
        LPresus=this.getLista();
        for(int i=0;i<LPresus.size();i++)
             if (((Presupuestos)LPresus.elementAt(i)).getRechazado()==1)
                     LPresus.removeElementAt(i);
        
         int n;
        switch (filtro){
            
            case 2:
                   n=0;
                   while(n<LPresus.size()){
                        if (((Presupuestos)LPresus.elementAt(n)).getEnviado()==0){
                            LPresus.removeElementAt(n);
                        }else  
                          n++; 
                   }
                   break;
            case 3:
                   n=0;
                   while(n<LPresus.size()){
                        if ( ( ((Presupuestos)LPresus.elementAt(n)).getEnviado()==1) || ( ((Presupuestos)LPresus.elementAt(n)).getAprobado()==0)){ 
                            LPresus.removeElementAt(n);
                        }else  
                          n++; 
                   }
                   break;
            case 4:                
                   n=0;
                   while(n<LPresus.size()){
                   
                        if  ( ((Presupuestos)LPresus.elementAt(n)).getAprobado()==1){
                              LPresus.removeElementAt(n);
                              n=0;
                        }else  
                          n++;      
                     
                    }
                   break;
                 
        }
         String fechap;
         SimpleDateFormat formato= new SimpleDateFormat("dd/MM/yyyy");
         
           
            int i=0;
           while (i<LPresus.size()){
                    fechap=((Presupuestos)LPresus.elementAt(i)).getFecha();                                                   
                    Date fpres= formato.parse(fechap);
                  if (( !(fdesde.equals("")) && !(fhasta.equals("")) )){                         
                        Date fdes= formato.parse(fdesde);
                        Date fhas= formato.parse(fhasta);
                        if (!(fpres.after(fdes) && fpres.before(fhas))){
                            LPresus.removeElementAt(i);
                            i=0;
                        }else                           
                          i++;
                  }else
                         if ((fdesde.equals("")) && !(fhasta.equals(""))){
                            Date fhas= formato.parse(fhasta);
                            if ((fpres.after(fhas))){
                                LPresus.removeElementAt(i);
                                i=0;
                            }else                            
                                i++;
                         }
                         
                 else if ((fhasta.equals(""))&& !(fdesde.equals(""))){
                         Date fdes= formato.parse(fdesde);
                         if ((fpres.before(fdes))){
                           LPresus.removeElementAt(i);
                           i=0;
                         }else                           
                             i++;                         
                       }if ((fhasta.equals(""))&& (fdesde.equals("")))
                           break;
                    
           }  
                
        
        return LPresus;
    }
          
  
  public void actualizarPresupuestos(int[] nroPresu){
        
        try{    
             Sql SQL=Sql.getIntancia();
             Connection con= SQL.conectar();
            int val=0;  
            for (int i=0;i<nroPresu.length;i++){
                val = nroPresu[i];
                PreparedStatement preparedStatement = con.prepareStatement("UPDATE Presupuestos SET Enviado = 1 WHERE IdPresupuesto = "+val);
                preparedStatement.executeUpdate();
            }
          }catch(SQLException e){
              e.printStackTrace();
          }
    }
   
     
}
