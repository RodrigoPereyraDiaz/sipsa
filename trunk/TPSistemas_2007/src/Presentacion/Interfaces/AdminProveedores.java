package Presentacion.Interfaces;

import Dominio.Aplicacion.Proveedores;
import Dominio.Controladores.ControladorABM;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;


public class AdminProveedores extends javax.swing.JDialog {
    
    ControladorABM controlador;
   
    public AdminProveedores() {
       
        initComponents();
        controlador= new ControladorABM();
        this.setTitle("Administrar Proveedores");
        this.cargarPantalla();
        this.setVisible(true);
    }
    

    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();
        jLCliente = new javax.swing.JLabel();
        jCBCliente = new javax.swing.JComboBox();
        jBConsultar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        Agregar = new javax.swing.JButton();
        jBEliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        Modificar = new javax.swing.JButton();
        Aviso = new javax.swing.JTextField();
        cancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jLCliente.setText("Proveedor");

        jCBCliente.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todos" }));

        jBConsultar.setText("Consultar");
        jBConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBConsultarActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                .add(53, 53, 53)
                .add(jLCliente)
                .add(15, 15, 15)
                .add(jCBCliente, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 188, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 72, Short.MAX_VALUE)
                .add(jBConsultar)
                .add(158, 158, 158))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLCliente)
                    .add(jBConsultar)
                    .add(jCBCliente, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Agregar.setText("Agregar");
        Agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarActionPerformed(evt);
            }
        });

        jBEliminar.setText("Eliminar");
        jBEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEliminarActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Número", "Código", "Razón Social", "DNI/CUIT", "IVA", "Dirección", "Forma de Pedido"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        Modificar.setText("Modificar");
        Modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificarActionPerformed(evt);
            }
        });

        Aviso.setEditable(false);

        cancelar.setText("Salir");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(Aviso, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 591, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel2Layout.createSequentialGroup()
                        .add(Agregar)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(Modificar)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jBEliminar)
                        .add(46, 46, 46)
                        .add(cancelar))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 591, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 179, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(Agregar)
                    .add(Modificar)
                    .add(jBEliminar)
                    .add(cancelar))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 22, Short.MAX_VALUE)
                .add(Aviso, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(21, 21, 21)
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(20, 20, 20)
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(27, 27, 27)
                .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-659)/2, (screenSize.height-375)/2, 659, 375);
    }// </editor-fold>//GEN-END:initComponents

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed

        this.getParent().setVisible(false);
    }//GEN-LAST:event_cancelarActionPerformed

    
    
    private void ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificarActionPerformed

     try{   
       DefaultTableModel defaultTableModel = (DefaultTableModel) jTable1.getModel();
        controlador.actProveedor((Integer) defaultTableModel.getValueAt(jTable1.getSelectedRow(),0));
        
        this.refrescarPantalla(); 
        
     }catch(Exception e){
           Aviso.setText(e.getMessage()+" Error: Debe seleccionar un Proveedor o realizar una búsqueda");
     }
    }//GEN-LAST:event_ModificarActionPerformed

    private void jBEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEliminarActionPerformed
       try{
            DefaultTableModel defaultTableModel = (DefaultTableModel) jTable1.getModel();
            controlador.eliminarPro((Integer) defaultTableModel.getValueAt(jTable1.getSelectedRow(),0));
            Aviso.setText("El Proveedor fue eliminado correctamente");
             this.refrescarPantalla(); 
        }catch(SQLException e){
            Aviso.setText(e.getMessage()+": "+"Hay Presupuestos con Articulos del Proveeedor seleccionado, no se puede eliminar");
        }catch(Exception e){
            Aviso.setText(e.getMessage()+" Error: Debe seleccionar un Proveedor o realizar una búsqueda");
        }
    }//GEN-LAST:event_jBEliminarActionPerformed

    private void AgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarActionPerformed
        controlador.amProveedor();
        this.refrescarPantalla();       
      
    }//GEN-LAST:event_AgregarActionPerformed

    private void jBConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBConsultarActionPerformed
        DefaultTableModel defaultTableModel = (DefaultTableModel) jTable1.getModel();

        for (int i=defaultTableModel.getRowCount()-1; i>=0; i--){
            defaultTableModel.removeRow(i);
        }
        
        if (jCBCliente.getSelectedIndex() != 0){
            Proveedores pro=controlador.getProveedor(jCBCliente.getSelectedIndex());
            defaultTableModel.addRow( new Object[]{pro.getNumero(),pro.getCodigo(),pro.getRazonSocial(),pro.getCuit_dni(),pro.getIva(),pro.getDomicilio(),pro.getFormaPedido().getDescripcion()});
        }else{
            Vector Lpro=controlador.getProveedores();
            for(int i=0;i<Lpro.size();i++){
                Proveedores pro=(Proveedores)Lpro.elementAt(i);
                defaultTableModel.addRow( new Object[]{pro.getNumero(),pro.getCodigo(),pro.getRazonSocial(),pro.getCuit_dni(),pro.getIva(),pro.getDomicilio(),pro.getFormaPedido().getDescripcion()});
            }
        }
    }//GEN-LAST:event_jBConsultarActionPerformed
    
     public void refrescarPantalla(){
       this.cargarPantalla();
        DefaultTableModel defaultTableModel = (DefaultTableModel) jTable1.getModel();
             
        for (int i=defaultTableModel.getRowCount()-1; i>=0; i--){
            defaultTableModel.removeRow(i);
        }
        
        Vector Lpro=controlador.getProveedores();
            for(int i=0;i<Lpro.size();i++){
                Proveedores pro=(Proveedores)Lpro.elementAt(i);
                defaultTableModel.addRow( new Object[]{pro.getNumero(),pro.getCodigo(),pro.getRazonSocial(),pro.getCuit_dni(),pro.getIva(),pro.getDomicilio(),pro.getFormaPedido().getDescripcion()});
            }
    }
    
     public void cargarPantalla(){
        
         jCBCliente.removeAllItems();
        jCBCliente.addItem("Todos");
        Vector LProveedores=controlador.getProveedores();
        for(int i=0; i<LProveedores.size(); i++){
            Proveedores p = (Proveedores)LProveedores.elementAt(i);
            jCBCliente.addItem(p.getRazonSocial());
        }
        
    }
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Agregar;
    private javax.swing.JTextField Aviso;
    private javax.swing.JButton Modificar;
    private javax.swing.JButton cancelar;
    private javax.swing.JButton jBConsultar;
    private javax.swing.JButton jBEliminar;
    private javax.swing.JComboBox jCBCliente;
    private javax.swing.JLabel jLCliente;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
    
}
