package Presentacion.Interfaces;
import Dominio.Aplicacion.*;
import Dominio.Controladores.*;
import BaseDatos.*;
import java.sql.SQLException;
import java.util.*;
import javax.swing.table.DefaultTableModel;


/**
* <p>
* Permite completar los datos para ingresar un nuevo producto o
 * modificar los datos de un producto existente.
* </p>
*/

public class AMProductos extends javax.swing.JDialog {
    Vector vArti;
    ControladorABM control;

    public AMProductos(java.awt.Frame parent, boolean modal, int tItem) {
        super(parent, modal);
        initComponents();
        vArti = new Vector();
        this.llenarCombo();
        control = new ControladorABM(tItem);
        jLabel6.setText("");
        this.vaciarTabla();
    }
    
    public AMProductos(java.awt.Frame parent, boolean modal, int tItem, int idPro, String descri) {
        super(parent, modal);
        initComponents();
        jTFId.setText(String.valueOf(idPro));
        jTFDescriProd.setText(descri);
        vArti = new Vector();
        this.llenarCombo();
        control = new ControladorABM(tItem);
        jLabel6.setText("");
        this.vaciarTabla();
        Vector vectorA = new Vector();
        vectorA = control.traerArti(idPro);
        this.llenarTabla(vectorA);
    }
    

    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTFId = new javax.swing.JTextField();
        jTFDescriProd = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jCBDescriArti = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jTFCantidad = new javax.swing.JTextField();
        jBAgregar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jBModificar = new javax.swing.JButton();
        jBEliminar = new javax.swing.JButton();
        jBAceptar = new javax.swing.JButton();
        jBCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Alta y Modificaci\u00f3n");
        jLabel1.setText("Id Producto");

        jLabel2.setText("Descripci\u00f3n Producto");

        jTFId.setEditable(false);

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(36, 36, 36)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jLabel1)
                    .add(jLabel2))
                .add(17, 17, 17)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jTFId, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 44, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jTFDescriProd, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 208, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(178, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1)
                    .add(jTFId, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(19, 19, 19)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel2)
                    .add(jTFDescriProd, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel3.setText("Art\u00edculos Asociados al Producto:");

        jLabel4.setText("Descripci\u00f3n Art\u00edculo");

        jLabel5.setText("Cantidad");

        jBAgregar.setText("Agregar");
        jBAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAgregarActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel2Layout.createSequentialGroup()
                        .add(jLabel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 205, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .add(jPanel2Layout.createSequentialGroup()
                        .add(jLabel4)
                        .add(13, 13, 13)
                        .add(jCBDescriArti, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 136, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(51, 51, 51)
                        .add(jLabel5)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jTFCantidad, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 55, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 38, Short.MAX_VALUE)
                        .add(jBAgregar)
                        .add(23, 23, 23))))
            .add(jPanel2Layout.createSequentialGroup()
                .add(34, 34, 34)
                .add(jLabel6, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel3)
                .add(15, 15, 15)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel4)
                    .add(jBAgregar)
                    .add(jCBDescriArti, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jTFCantidad, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel5))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 17, Short.MAX_VALUE)
                .add(jLabel6, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 15, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Id Artículo", "Descripción", "Cantidad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jBModificar.setText("Modificar");
        jBModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBModificarActionPerformed(evt);
            }
        });

        jBEliminar.setText("Eliminar");
        jBEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEliminarActionPerformed(evt);
            }
        });

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

        org.jdesktop.layout.GroupLayout jPanel3Layout = new org.jdesktop.layout.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel3Layout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel3Layout.createSequentialGroup()
                        .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jPanel3Layout.createSequentialGroup()
                                .add(jBModificar)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jBEliminar))
                            .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 452, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(30, 30, 30))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel3Layout.createSequentialGroup()
                        .add(jBAceptar)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jBCancelar)
                        .addContainerGap())))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel3Layout.createSequentialGroup()
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 107, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jBModificar)
                    .add(jBEliminar))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jBCancelar)
                    .add(jBAceptar))
                .addContainerGap())
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(39, 39, 39))
        );
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-567)/2, (screenSize.height-452)/2, 567, 452);
    }// </editor-fold>//GEN-END:initComponents

    private void jBCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCancelarActionPerformed

        this.getParent().setVisible(false);
    }//GEN-LAST:event_jBCancelarActionPerformed

    
/**
* <p>
* Recoge los datos del nuevo producto a ser ingresado o
 * los datos de un producto existente para ser actualizado.
* </p>
*/
    
    private void jBAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAceptarActionPerformed

        String vacio = "", descri;
        int idProdu =0, cantiFilas;
        Vector vecArti = new Vector();
        descri = jTFDescriProd.getText();
        cantiFilas = jTable1.getRowCount();
        
        if (descri.equals(vacio) || (cantiFilas == 0)){
            jLabel6.setText("Debe ingresar Descripción Producto y asociar al menos un Artículo");
        }else{
            jLabel6.setText("");
            for (int i = 0; i<cantiFilas;i++){
                vecArti.addElement(Integer.parseInt(String.valueOf(jTable1.getValueAt(i,0))));
                vecArti.addElement(Float.parseFloat(String.valueOf(jTable1.getValueAt(i,2))));
            }
            //Obtener Costo y Precio del Producto en base a los Artículos q lo componen
            Vector v = new Vector();
            try {
                v = control.calcularCostoPrecioProdu(vecArti);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            if (jTFId.getText().equals(vacio)){
                try {
                    control.insertarItem(descri, (Float)v.elementAt(0), (Float)v.elementAt(1));
                    idProdu = control.buscarId();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
               
            }else{
                idProdu = Integer.parseInt(jTFId.getText());
                try {
                    control.modificarItem(idProdu, descri, (Float)v.elementAt(0), (Float)v.elementAt(1));
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            control.insertarArtiXProdu(idProdu, vecArti);
            this.getParent().setVisible(false);
        }
    }//GEN-LAST:event_jBAceptarActionPerformed

    private void jBEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEliminarActionPerformed

        int filaSeleccionada = jTable1.getSelectedRow();
        if (filaSeleccionada == -1){
            jLabel6.setText("Debe seleccionar una fila de la tabla");
        }else{
            jLabel6.setText("");
            DefaultTableModel defaultTableModel = (DefaultTableModel) jTable1.getModel();
            defaultTableModel.removeRow(jTable1.getSelectedRow());
        }
    }//GEN-LAST:event_jBEliminarActionPerformed

    private void jBModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBModificarActionPerformed

        int filaSeleccionada = jTable1.getSelectedRow();
        if (filaSeleccionada == -1){
            jLabel6.setText("Debe seleccionar una fila de la tabla");
        }else{
            jLabel6.setText("");
            String descri = String.valueOf(jTable1.getValueAt(jTable1.getSelectedRow(),1));
            String canti = String.valueOf(jTable1.getValueAt(jTable1.getSelectedRow(),2));
            int posicion = 0;
            boolean esDescri = false;
            while (! esDescri){
                String d = (String)jCBDescriArti.getItemAt(posicion);
                if (descri.equals(d))
                    esDescri=true;
                else
                    posicion = posicion +1;
            }
            jCBDescriArti.setSelectedIndex(posicion);
            jTFCantidad.setText(canti);
            DefaultTableModel defaultTableModel = (DefaultTableModel) jTable1.getModel();
            defaultTableModel.removeRow(jTable1.getSelectedRow());
        }
        
        
    }//GEN-LAST:event_jBModificarActionPerformed

    private void jBAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAgregarActionPerformed

        String vacio = "";
        jLabel6.setText("");
        if ((jCBDescriArti.getSelectedIndex()) < 0){
            jLabel6.setText("Debe seleccionar un Artículo");
        }else{
            try{
            int i = (jCBDescriArti.getSelectedIndex());
            int id = ((Articulos)vArti.elementAt(i)).getId();
            String desc = ((Articulos)vArti.elementAt(i)).getDescripcion();
            if ((jTFCantidad.getText()).equals(vacio)){
                jLabel6.setText("Debe ingresar una cantidad");
            }else{
                DefaultTableModel defaultTableModel = (DefaultTableModel) jTable1.getModel();
                
                int numeroFilasTabla = jTable1.getRowCount();
                boolean articuloExiste=false;
                int k=0;
                while ((! articuloExiste)&&(k<numeroFilasTabla)){
                    if (desc.equals(String.valueOf(jTable1.getValueAt(k,1)))){
                        articuloExiste = true;
                    }
                    k=k+1;
                }
                if (articuloExiste){
                    jLabel6.setText("El artículo ya fue ingresado");
                }else{
                    float canti = Float.parseFloat(jTFCantidad.getText());
                    defaultTableModel.addRow( new Object[]{id, desc, canti});
                }
                
            }
        }catch(Exception e){
            jLabel6.setText("El campo Cantidad es numérico");
        }
        }
        
        
    }//GEN-LAST:event_jBAgregarActionPerformed
    
    public void llenarCombo(){
        IntermediarioArticulos inter = new IntermediarioArticulos();
        vArti = inter.getVectorArticulos();
        for(int i=0; i<vArti.size(); i++){
            String descri = ((Articulos)vArti.elementAt(i)).getDescripcion();
            jCBDescriArti.addItem(descri);
        }
    }
    
    public void vaciarTabla(){
        DefaultTableModel defaultTableModel = (DefaultTableModel) jTable1.getModel();
        for (int i=defaultTableModel.getRowCount()-1; i>=0; i--){
            defaultTableModel.removeRow(i);
        }
    }
    
    public void llenarTabla(Vector v){
        this.vaciarTabla();
        DefaultTableModel defaultTableModel = (DefaultTableModel) jTable1.getModel();
        for (int i=0;i<v.size();i=i+3){
            defaultTableModel.addRow( new Object[]{(Integer)v.elementAt(i), (String)v.elementAt(i+1), (Float)v.elementAt(i+2)});
        }
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAceptar;
    private javax.swing.JButton jBAgregar;
    private javax.swing.JButton jBCancelar;
    private javax.swing.JButton jBEliminar;
    private javax.swing.JButton jBModificar;
    private javax.swing.JComboBox jCBDescriArti;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTFCantidad;
    private javax.swing.JTextField jTFDescriProd;
    private javax.swing.JTextField jTFId;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
    
}
