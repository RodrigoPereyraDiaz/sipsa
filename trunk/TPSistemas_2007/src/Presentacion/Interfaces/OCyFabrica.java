package Presentacion.Interfaces;
import Dominio.Aplicacion.*;
import Dominio.Controladores.*;
import BaseDatos.*;
import java.lang.String;
import java.text.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class OCyFabrica extends javax.swing.JDialog {
    private ControladorOC Controlador;
    boolean realizoConsulta;
    Vector vClientes = new Vector();
    

    public OCyFabrica(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        realizoConsulta = false;
        Controlador = new ControladorOC();
        this.cargarPantalla();
        
    }

    public void cargarPantalla(){
        IntermediarioClientes interCli = new IntermediarioClientes();
        vClientes = interCli.getVectorClientes();
        for(int i=1; i<vClientes.size(); i=i+2){
            String nom = (String)vClientes.elementAt(i);
            jCBCliente.addItem(nom);
        }
    }

    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();
        jLCliente = new javax.swing.JLabel();
        jCBCliente = new javax.swing.JComboBox();
        jBConsultar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jBGenerarOC = new javax.swing.JButton();
        jBCancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jLCliente.setText("Cliente");

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
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 18, Short.MAX_VALUE)
                .add(jCBCliente, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 188, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jBConsultar)
                .add(158, 158, 158))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLCliente)
                    .add(jCBCliente, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jBConsultar))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jBGenerarOC.setText("Generar OC");
        jBGenerarOC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGenerarOCActionPerformed(evt);
            }
        });

        jBCancelar.setText("Cancelar");
        jBCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCancelarActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Fecha", "Presupuesto", "Cliente", "Total ($)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel2Layout.createSequentialGroup()
                        .add(jBGenerarOC)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jBCancelar))
                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 517, Short.MAX_VALUE)
                    .add(jLabel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 501, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 133, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(14, 14, 14)
                .add(jLabel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jBCancelar)
                    .add(jBGenerarOC))
                .addContainerGap())
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(34, 34, 34)
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(20, 20, 20)
                .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-565)/2, (screenSize.height-395)/2, 565, 395);
    }// </editor-fold>//GEN-END:initComponents

    private void jBCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCancelarActionPerformed

        this.getParent().setVisible(false);
    }//GEN-LAST:event_jBCancelarActionPerformed

    private void jBGenerarOCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGenerarOCActionPerformed

        jLabel1.setText("");
        int[] n = jTable1.getSelectedRows();
        int longitud = n.length;
        if (longitud == 0){
            if (realizoConsulta){
                jLabel1.setText("Debe seleccionar al menos un Item de la grilla");
            }else{
                jLabel1.setText("Debe realizar una consulta y luego seleccionar al menos un Item de la grilla");
            }
            Object[] options = {"OK"};
        }else{
            int[] NroPresu = new int[n.length];
            for (int i=0; i<longitud;i++){
                NroPresu[i] = Integer.parseInt(String.valueOf(jTable1.getValueAt(n[i],1)));
            }
            Controlador.enviarFabricacion(NroPresu);
            this.getParent().setVisible(false);
        }
        
    }//GEN-LAST:event_jBGenerarOCActionPerformed

    private void jBConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBConsultarActionPerformed

        realizoConsulta = true;
        int posicCli, idCli = 0;

        if (jCBCliente.getSelectedIndex() != 0){
            posicCli = 2*jCBCliente.getSelectedIndex()-2;
            idCli = (Integer)vClientes.elementAt(posicCli);
        }
            
        Vector Lista = Controlador.obtenerPresupuestos(idCli);
        DefaultTableModel defaultTableModel = (DefaultTableModel) jTable1.getModel();
        
        //Vaciar la tabla de presupuestos
       for (int i=defaultTableModel.getRowCount()-1; i>=0; i--){
            defaultTableModel.removeRow(i);
        }
        
        //Llenar la tabla de presupuestos
        String patternN = "###,###.00";
        DecimalFormat myFormatter = new DecimalFormat(patternN);
        Date today;
        
        for (int i=0;i<Lista.size();i++){
          Presupuestos p=(Presupuestos)Lista.elementAt(i);   
          String outputN = myFormatter.format(p.getTotal());
          defaultTableModel.addRow( new Object[]{p.getFecha(),p.getNumero(),p.getCliente().getNombre()+' '+p.getCliente().getApellido(),outputN});
        }
    
    }//GEN-LAST:event_jBConsultarActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBCancelar;
    private javax.swing.JButton jBConsultar;
    private javax.swing.JButton jBGenerarOC;
    private javax.swing.JComboBox jCBCliente;
    private javax.swing.JLabel jLCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
    
}
