
package Presentacion.Interfaces;
import BaseDatos.*;
import Dominio.Controladores.ControladorPresupuesto;
import Dominio.Aplicacion.*;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;


public class Frm_GeneraPresu extends javax.swing.JFrame {
    ControladorPresupuesto Controlador;
    
    
    public Frm_GeneraPresu() {
        initComponents();
        this.Controlador = new ControladorPresupuesto();
        this.CargarPantalla();
        this.setVisible(true);
    }
    
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        Cmb_Clientes = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jField = new javax.swing.JLabel();
        FechaPresu = new javax.swing.JLabel();
        jTFech = new javax.swing.JTextField();
        jPanelClientes = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        Cli_num = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        Cli_nom = new javax.swing.JTextField();
        Cli_mail = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanelItems = new javax.swing.JPanel();
        Cmb_Items = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        jTFCantidad = new javax.swing.JTextField();
        jBAgregar = new javax.swing.JButton();
        jCTipoItem = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTGrillaItems = new javax.swing.JTable();
        jBModiItem = new javax.swing.JButton();
        jBEliItem = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jTFTotal = new javax.swing.JTextField();
        Cancelar = new javax.swing.JButton();
        jTPresuNum = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        Aviso = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Generar Presupuesto");
        setResizable(false);
        Cmb_Clientes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione" }));
        Cmb_Clientes.setFocusable(false);
        Cmb_Clientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeleccionarCliente(evt);
            }
        });

        jLabel1.setText("Cliente");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel5.setText("N\u00famero");

        jField.setFont(new java.awt.Font("Arial", 1, 12));
        jField.setText("Fecha");

        jTFech.setEditable(false);

        jLabel3.setText("N\u00famero");

        Cli_num.setEditable(false);
        Cli_num.setBorder(null);

        jLabel2.setText("Nombre y Apellido");

        Cli_nom.setEditable(false);
        Cli_nom.setBorder(null);

        Cli_mail.setEditable(false);
        Cli_mail.setBorder(null);

        jLabel6.setText("Mail");

        org.jdesktop.layout.GroupLayout jPanelClientesLayout = new org.jdesktop.layout.GroupLayout(jPanelClientes);
        jPanelClientes.setLayout(jPanelClientesLayout);
        jPanelClientesLayout.setHorizontalGroup(
            jPanelClientesLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanelClientesLayout.createSequentialGroup()
                .add(23, 23, 23)
                .add(jPanelClientesLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanelClientesLayout.createSequentialGroup()
                        .add(jLabel3)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(Cli_num, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(525, Short.MAX_VALUE))
                    .add(jPanelClientesLayout.createSequentialGroup()
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jLabel2)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(Cli_nom, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 234, Short.MAX_VALUE)
                        .add(jLabel6)
                        .add(12, 12, 12)
                        .add(Cli_mail, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(212, 212, 212))))
        );
        jPanelClientesLayout.setVerticalGroup(
            jPanelClientesLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanelClientesLayout.createSequentialGroup()
                .add(jPanelClientesLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(Cli_num, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel3))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanelClientesLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(Cli_nom, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel6)
                    .add(Cli_mail, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel2))
                .addContainerGap())
        );

        jLabel4.setFont(new java.awt.Font("Arial", 3, 14));
        jLabel4.setText("Datos del Cliente");

        jLabel7.setFont(new java.awt.Font("Arial", 3, 14));
        jLabel7.setText("Detalle de Items");

        Cmb_Items.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cmb_ItemsActionPerformed(evt);
            }
        });

        jLabel8.setText("Cantidad");

        jTFCantidad.setColumns(3);
        jTFCantidad.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTFCantidad.setText("            ");
        jTFCantidad.setCaretPosition(1);
        jTFCantidad.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jTFCantidad.setScrollOffset(3);

        jBAgregar.setText("Agregar");
        jBAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarItem(evt);
            }
        });

        jCTipoItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCTipoItemActionPerformed(evt);
            }
        });

        jLabel9.setText("Item");

        jLabel10.setText("Tipo");

        org.jdesktop.layout.GroupLayout jPanelItemsLayout = new org.jdesktop.layout.GroupLayout(jPanelItems);
        jPanelItems.setLayout(jPanelItemsLayout);
        jPanelItemsLayout.setHorizontalGroup(
            jPanelItemsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanelItemsLayout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel10)
                .add(10, 10, 10)
                .add(jCTipoItem, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 130, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(jLabel9)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(Cmb_Items, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 183, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(jLabel8)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jTFCantidad, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(19, 19, 19)
                .add(jBAgregar)
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanelItemsLayout.setVerticalGroup(
            jPanelItemsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanelItemsLayout.createSequentialGroup()
                .add(25, 25, 25)
                .add(jPanelItemsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel10)
                    .add(jCTipoItem, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel9)
                    .add(Cmb_Items, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jBAgregar)
                    .add(jLabel8)
                    .add(jTFCantidad, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane1.setBorder(null);
        jTGrillaItems.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cód. Item", "Tipo", "Descripción", "Precio", "Cantidad", "Subtotal"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTGrillaItems);

        jBModiItem.setText("Modificar");
        jBModiItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBModiItemActionPerformed(evt);
            }
        });

        jBEliItem.setText("Eliminar");
        jBEliItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEliItemActionPerformed(evt);
            }
        });

        jLabel11.setText("Total $");

        jTFTotal.setEditable(false);
        jTFTotal.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jBModiItem, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                .add(17, 17, 17)
                .add(jBEliItem, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                .add(279, 279, 279)
                .add(jLabel11)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jTFTotal, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 46, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(32, 32, 32))
            .add(jPanel1Layout.createSequentialGroup()
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 626, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 128, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 18, Short.MAX_VALUE)
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jBModiItem)
                            .add(jBEliItem))
                        .addContainerGap())
                    .add(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel11)
                            .add(jTFTotal, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );

        Cancelar.setText("Cancelar");
        Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarActionPerformed(evt);
            }
        });

        jTPresuNum.setEditable(false);
        jTPresuNum.setBorder(null);

        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        Aviso.setEditable(false);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel7)
                            .add(jLabel4)
                            .add(layout.createSequentialGroup()
                                .add(jLabel1)
                                .add(14, 14, 14)
                                .add(Cmb_Clientes, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 247, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(54, 54, 54)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(layout.createSequentialGroup()
                                        .add(jField)
                                        .add(18, 18, 18)
                                        .add(FechaPresu))
                                    .add(jLabel5))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(jTFech, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 138, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(jTPresuNum, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                            .add(jPanelItems, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                    .add(layout.createSequentialGroup()
                        .add(20, 20, 20)
                        .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
            .add(layout.createSequentialGroup()
                .add(28, 28, 28)
                .add(jPanelClientes, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(66, Short.MAX_VALUE))
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                        .add(24, 24, 24)
                        .add(Aviso, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE))
                    .add(layout.createSequentialGroup()
                        .addContainerGap(476, Short.MAX_VALUE)
                        .add(jButton1)
                        .add(23, 23, 23)
                        .add(Cancelar)))
                .add(34, 34, 34))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jField)
                            .add(FechaPresu)
                            .add(jTFech, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel5)
                            .add(jTPresuNum, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                    .add(layout.createSequentialGroup()
                        .add(27, 27, 27)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel1)
                            .add(Cmb_Clientes, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                .add(20, 20, 20)
                .add(jLabel4)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanelClientes, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(14, 14, 14)
                .add(jLabel7)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanelItems, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(14, 14, 14)
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(34, 34, 34)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(Cancelar)
                    .add(jButton1))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(Aviso, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(20, 20, 20))
        );
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-683)/2, (screenSize.height-533)/2, 683, 533);
    }// </editor-fold>//GEN-END:initComponents
    
    private void CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarActionPerformed

        this.setVisible(false);
        
    }//GEN-LAST:event_CancelarActionPerformed
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

       try{
        DefaultTableModel defaultTableModel=(DefaultTableModel) jTGrillaItems.getModel(); 
        if(defaultTableModel.getRowCount()>0){
            Controlador.finalizarPresupuesto();
            this.setVisible(false);
            this.dispose();
        }else{
           Aviso.setText("Debe agregar almenos un item al presupuesto"); 
        }
       }catch(NullPointerException e){
           Aviso.setText("Error "+e.getMessage()+": Seleccione un cliente");
       }
    }//GEN-LAST:event_jButton1ActionPerformed
    
    private void jBEliItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEliItemActionPerformed

     try{   
       DefaultTableModel defaultTableModel=(DefaultTableModel) jTGrillaItems.getModel();
        Controlador.eliminarItem(jTGrillaItems.getSelectedRow());
        float a= Float.parseFloat(jTFTotal.getText());
        a-=Float.parseFloat(String.valueOf(jTGrillaItems.getValueAt(jTGrillaItems.getSelectedRow(),5)));
        defaultTableModel.removeRow(jTGrillaItems.getSelectedRow());
        jTFTotal.setText(String.valueOf(a));
        
       this.setVisible(true);
     }catch(ArrayIndexOutOfBoundsException e){
           Aviso.setText("Error"+e.getMessage()+": Seleccione un item");
     }
    }//GEN-LAST:event_jBEliItemActionPerformed
    
    private void jBModiItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBModiItemActionPerformed

       try{
            DefaultTableModel defaultTableModel = (DefaultTableModel) jTGrillaItems.getModel();
            String Descri= (String) defaultTableModel.getValueAt(jTGrillaItems.getSelectedRow(),1);
            if (Descri.equals("Artículos")){
                jCTipoItem.setSelectedIndex(0);
            }else{   
                  if(Descri.equals("Productos")){
                    jCTipoItem.setSelectedIndex(1);
                  }else{
                    jCTipoItem.setSelectedIndex(2);
                  }                
            }
            int id= (Integer) defaultTableModel.getValueAt(jTGrillaItems.getSelectedRow(),0);
            Cmb_Items.setSelectedIndex(id-1);
            int cant= (Integer) defaultTableModel.getValueAt(jTGrillaItems.getSelectedRow(),4);
            jTFCantidad.setText(String.valueOf(cant));
            this.jBEliItemActionPerformed(evt);
       }catch(ArrayIndexOutOfBoundsException e){
           Aviso.setText("Error"+e.getMessage()+": Seleccione un item");
       }
    }//GEN-LAST:event_jBModiItemActionPerformed
    
    private void jCTipoItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCTipoItemActionPerformed
        
        
        CreadorItems ci;
        ci= new ConcretoCreadorItems();
        IntermediarioItems InterItems= ci.getIntermediario(jCTipoItem.getSelectedIndex());
        Cmb_Items.removeAllItems();
        Vector Items=InterItems.getLista();
        for(int i=0; i<Items.size(); i++){
            Items item = (Items)Items.elementAt(i);
            Cmb_Items.addItem(item.getDescripcion());
        }
        this.setVisible(true);
    }//GEN-LAST:event_jCTipoItemActionPerformed
    
    private void AgregarItem(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarItem
        try{
       
        Controlador.addItemPresupuesto(Cmb_Items.getSelectedIndex()+1,Integer.parseInt(jTFCantidad.getText()),jCTipoItem.getSelectedIndex());
        EspecificacionItem itn=Controlador.getItemPresupuesto(jTGrillaItems.getRowCount());
        int canti= Integer.parseInt((String)jTFCantidad.getText());
        DefaultTableModel defaultTableModel = (DefaultTableModel) jTGrillaItems.getModel();
        defaultTableModel.addRow( new Object[]{itn.getItem().getId(),jCTipoItem.getSelectedItem(),itn.getItem().getDescripcion(),"$"+itn.getItem().getPrecio(),canti,String.valueOf(itn.getItem().getPrecio()*canti)});
        float a= Float.parseFloat(jTFTotal.getText());
        a+= itn.getSubtotal();
        jTFTotal.setText(String.valueOf(a));
        jTFCantidad.setText("");
        }catch(NumberFormatException e){
            Aviso.setText("Error "+e.getMessage()+": Ingrese la cantidad del item");
        }
        
    }//GEN-LAST:event_AgregarItem
    
    private void Cmb_ItemsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cmb_ItemsActionPerformed
        
    }//GEN-LAST:event_Cmb_ItemsActionPerformed
    
    private void SeleccionarCliente(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeleccionarCliente
        
        int select=Cmb_Clientes.getSelectedIndex();
        
        if (select>0){
            Clientes c=Controlador.getCliente(select);
            Cli_nom.setText(c.getNombre()+", "+c.getApellido());
            Cli_mail.setText(c.getMail());
            String s=String.valueOf(c.getNumero());
            Cli_num.setText(s);
        }else{
            Cli_nom.setText("          ");
            Cli_mail.setText("          ");
            Cli_num.setText("          ");
        }
        this.setVisible(true);
        
    }//GEN-LAST:event_SeleccionarCliente
    
    private void CargarPantalla(){
        jTFech.setText(Controlador.getFecha());
        jTFCantidad.setText("");
        jTFTotal.setText("0.0");
        jTFech.setEditable(false);
        jTPresuNum.setText(String.valueOf(Controlador.getNro()));
        jCTipoItem.addItem("Artículos");
        jCTipoItem.addItem("Productos");
        jCTipoItem.addItem("Servicios");
        
       IntermediarioClientes InterClientes= new IntermediarioClientes(); 
        Vector Clientes=InterClientes.getLista();
        
        for(int i=0; i<Clientes.size(); i++){
            Clientes c = (Clientes)Clientes.elementAt(i);
            Cmb_Clientes.addItem(c.getNombre()+" "+c.getApellido());
        }
        
        CreadorItems ci;
        ci= new ConcretoCreadorItems();       
        IntermediarioItems InterItems= ci.getIntermediario(jCTipoItem.getSelectedIndex()); 
        Vector Items=InterItems.getLista();
        for(int i=0; i<Items.size(); i++){
            Items item = (Items)Items.elementAt(i);
            Cmb_Items.addItem(item.getDescripcion());
        }
       
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Aviso;
    private javax.swing.JButton Cancelar;
    protected javax.swing.JTextField Cli_mail;
    protected javax.swing.JTextField Cli_nom;
    protected javax.swing.JTextField Cli_num;
    protected javax.swing.JComboBox Cmb_Clientes;
    protected javax.swing.JComboBox Cmb_Items;
    private javax.swing.JLabel FechaPresu;
    private javax.swing.JButton jBAgregar;
    private javax.swing.JButton jBEliItem;
    private javax.swing.JButton jBModiItem;
    private javax.swing.JButton jButton1;
    protected javax.swing.JComboBox jCTipoItem;
    private javax.swing.JLabel jField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    protected javax.swing.JPanel jPanel1;
    protected javax.swing.JPanel jPanelClientes;
    private javax.swing.JPanel jPanelItems;
    private javax.swing.JScrollPane jScrollPane1;
    protected javax.swing.JTextField jTFCantidad;
    protected javax.swing.JTextField jTFTotal;
    protected javax.swing.JTextField jTFech;
    protected javax.swing.JTable jTGrillaItems;
    protected javax.swing.JTextField jTPresuNum;
    // End of variables declaration//GEN-END:variables
    
}
