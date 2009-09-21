package Presentacion.Interfaces;
import Dominio.Aplicacion.*;
import Dominio.Controladores.*;
import java.sql.SQLException;
import java.text.*;
import java.util.*;
import javax.swing.JFormattedTextField;
import javax.swing.text.*;


/**
* <p>
* Permite completar los datos para ingresar un nuevo ítem o
 * modificar los datos de un ítem existente.
 *Los ítems pueden ser artículos o servicios.
* </p>
*/    

public class AMItem extends javax.swing.JDialog {

    int tipoItem;
    ControladorABM control;
    int idIt, posicCombo;
    String d;
    float  p, c;
    boolean esArticulo = false;
    Vector LProv;


    public AMItem(java.awt.Frame parent, boolean modal, int tipoIt) {
        super(parent, modal);
        initComponents();
        ComboProv.setVisible(false);
        jLabel6.setVisible(false);
        
        this.tipoItem = tipoIt;
        control = new ControladorABM(tipoItem);
        
         if (tipoIt==0){
            LProv = new Vector();
            LProv = control.getProveedores();
            for(int i=0;i<LProv.size();i++)
                ComboProv.addItem(((Proveedores)LProv.elementAt(i)).getRazonSocial());
            jLabel6.setVisible(true); 
            ComboProv.setVisible(true);
            esArticulo = true;
        }
        jLabel5.setText("");

    }
    
    public AMItem(java.awt.Frame parent, boolean modal, int idIt, String d, float c, float p, int tipoIt) {
        super(parent, modal);
        initComponents();
        this.tipoItem = tipoIt;
        jTFId.setText(String.valueOf(idIt));
        jTFDescripcion.setText(d);
        jTFCosto.setText(String.valueOf(c));
        jTFPrecio.setText(String.valueOf(p));
        
        ComboProv.setVisible(false);
        jLabel6.setVisible(false);
        
        control = new ControladorABM(tipoItem);
         if (tipoIt==0){
            Articulos arti = new Articulos();
            arti = control.getArti(idIt);
            Proveedores pro = control.buscarProveedor(idIt);
            String rz = pro.getRazonSocial();
            LProv = new Vector();
            LProv = control.getProveedores();
            for(int i=0;i<LProv.size();i++)
                ComboProv.addItem(((Proveedores)LProv.elementAt(i)).getRazonSocial());
            jLabel6.setVisible(true); 
            ComboProv.setVisible(true);
            esArticulo = true;
            int posicion = 0;
            boolean esProvee = false;
            while (! esProvee){
                String razon = (String)ComboProv.getItemAt(posicion);
                if (rz.equals(razon))
                    esProvee=true;
                else
                    posicion = posicion +1;
            }
            ComboProv.setSelectedIndex(posicion);
        }
        jLabel5.setText("");
        
    }
    
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTFId = new javax.swing.JTextField();
        jTFDescripcion = new javax.swing.JTextField();
        jTFPrecio = new javax.swing.JTextField();
        jBAceptar = new javax.swing.JButton();
        jBCancelar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTFCosto = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        ComboProv = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Alta y Modificaci\u00f3n");
        jLabel1.setText("Id");

        jLabel2.setText("Descripci\u00f3n");

        jLabel3.setText("Precio");

        jTFId.setEditable(false);

        jBAceptar.setText("Aceptar");
        jBAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAceptarActionPerformed(evt);
            }
        });

        jBCancelar.setText("Cancelar");
        jBCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCancelarActionPerformed(evt);
            }
        });

        jLabel4.setText("Costo");

        jLabel6.setText("Proveedor");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(layout.createSequentialGroup()
                        .addContainerGap(92, Short.MAX_VALUE)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                    .add(jLabel2)
                                    .add(jLabel1)
                                    .add(jLabel4)
                                    .add(jLabel3)
                                    .add(jLabel6))
                                .add(14, 14, 14))
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                                .add(jBAceptar)
                                .add(23, 23, 23)))
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jTFDescripcion, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 143, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(layout.createSequentialGroup()
                                .add(1, 1, 1)
                                .add(jTFId, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 28, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(jBCancelar)
                            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                                .add(org.jdesktop.layout.GroupLayout.LEADING, jTFPrecio)
                                .add(org.jdesktop.layout.GroupLayout.LEADING, jTFCosto, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
                            .add(ComboProv, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 155, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                    .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                        .add(31, 31, 31)
                        .add(jLabel5, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)))
                .add(44, 44, 44))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(53, 53, 53)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jTFId, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel1))
                .add(32, 32, 32)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jTFDescripcion, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel2))
                .add(32, 32, 32)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel4)
                    .add(jTFCosto, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(34, 34, 34)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel3)
                    .add(jTFPrecio, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(17, 17, 17)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel6)
                    .add(ComboProv, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 29, Short.MAX_VALUE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jBCancelar)
                    .add(jBAceptar))
                .add(14, 14, 14)
                .add(jLabel5, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 23, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(32, 32, 32))
        );

        layout.linkSize(new java.awt.Component[] {jTFDescripcion, jTFId, jTFPrecio}, org.jdesktop.layout.GroupLayout.VERTICAL);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-383)/2, (screenSize.height-418)/2, 383, 418);
    }// </editor-fold>//GEN-END:initComponents

    
/**
* <p>
* Recoge los datos de un nuevo ítem para ser ingresado o
 * los datos de un ítem existente para ser actualizado.
* </p>
*/        
    
    private void jBAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAceptarActionPerformed

        String vacio="";
        d = "";
        c = 0;
        p = 0;

        if ((jTFDescripcion.getText()).equals(vacio) || (jTFPrecio.getText()).equals(vacio) || (jTFCosto.getText()).equals(vacio)){
            jLabel5.setText("Debe completar todos los campos");
        }else{
            try{
                d = jTFDescripcion.getText();
                c = Float.parseFloat(jTFCosto.getText());
                p = Float.parseFloat(jTFPrecio.getText());

            if (jTFId.getText().equals(vacio)){
                idIt = 0;
                try {
                    control.insertarItem(d, c, p);
                    if(esArticulo){
                        int idAr = control.buscarIdArti();
                        posicCombo = ComboProv.getSelectedIndex();
                        control.addProveedorXArtic(idAr,((Proveedores)LProv.elementAt(posicCombo)).getNumero());
                    }
                } catch (SQLException ex) {
                   ex.printStackTrace();

                }
            }else{
                idIt = Integer.parseInt(jTFId.getText());
                try {
                    control.modificarItem(idIt, d, c, p);
                    if(esArticulo){
                        posicCombo = ComboProv.getSelectedIndex();
                        control.modifProveedorXArtic(idIt,((Proveedores)LProv.elementAt(posicCombo)).getNumero());
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            this.getParent().setVisible(false);
            }catch(Exception e){
                jLabel5.setText("Los campos Costo y Precio son numéricos ");
            }
        }
    }//GEN-LAST:event_jBAceptarActionPerformed

    private void jBCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCancelarActionPerformed

        this.getParent().setVisible(false);
    }//GEN-LAST:event_jBCancelarActionPerformed
    
   
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox ComboProv;
    private javax.swing.JButton jBAceptar;
    private javax.swing.JButton jBCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField jTFCosto;
    private javax.swing.JTextField jTFDescripcion;
    private javax.swing.JTextField jTFId;
    private javax.swing.JTextField jTFPrecio;
    // End of variables declaration//GEN-END:variables
    
}
