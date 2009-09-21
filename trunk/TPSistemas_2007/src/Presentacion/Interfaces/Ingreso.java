package Presentacion.Interfaces;
import Server.webserver_starter;

public class Ingreso extends javax.swing.JFrame {

    public Ingreso() {
        initComponents();
        this.setTitle("Menú Principal");
        
    }
   public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               new Ingreso().setVisible(true);
              

            }
        });
    
   }
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jTextField1 = new javax.swing.JTextField();
        salir = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jBOC = new javax.swing.JButton();
        AdmArti = new javax.swing.JButton();
        AdmServ = new javax.swing.JButton();
        AdmClientes = new javax.swing.JButton();
        AdmProveedores = new javax.swing.JButton();
        AdmProductos = new javax.swing.JButton();
        AnalizarBene = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getAccessibleContext().setAccessibleName("frame1");
        jTextField1.setBackground(new java.awt.Color(236, 233, 216));
        jTextField1.setEditable(false);
        jTextField1.setFont(new java.awt.Font("Tahoma", 3, 24));
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("Administraci\u00f3n de Presupuestos");
        jTextField1.setBorder(null);

        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });

        jButton1.setText("Generar Presupuesto");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jBOC.setText("Generar Orden Compra");
        jBOC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBOCActionPerformed(evt);
            }
        });

        AdmArti.setText("Administrar Art\u00edculos");
        AdmArti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdmArtiActionPerformed(evt);
            }
        });

        AdmServ.setText("Administrar Servicios");
        AdmServ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdmServActionPerformed(evt);
            }
        });

        AdmClientes.setText("Administrar Clientes");
        AdmClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdmClientesActionPerformed(evt);
            }
        });

        AdmProveedores.setText("Administrar Proveedores");
        AdmProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdmProveedoresActionPerformed(evt);
            }
        });

        AdmProductos.setText("Administrar Productos");
        AdmProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdmProductosActionPerformed(evt);
            }
        });

        AnalizarBene.setText("Analizar Beneficios");
        AnalizarBene.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnalizarBeneActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(jBOC, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(AnalizarBene, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jButton1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .add(155, 155, 155)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, AdmArti, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, AdmProductos, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                        .add(org.jdesktop.layout.GroupLayout.LEADING, AdmClientes, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(org.jdesktop.layout.GroupLayout.LEADING, AdmProveedores, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .add(org.jdesktop.layout.GroupLayout.LEADING, AdmServ, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE))
                .add(153, 153, 153))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(AdmClientes)
                    .add(jButton1))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jBOC)
                    .add(AdmProveedores))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(AdmProductos)
                    .add(AnalizarBene))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(AdmArti)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(AdmServ)
                .add(27, 27, 27))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap(525, Short.MAX_VALUE)
                .add(salir, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 70, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(41, 41, 41))
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap(110, Short.MAX_VALUE)
                .add(jTextField1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 415, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(111, 111, 111))
            .add(layout.createSequentialGroup()
                .add(36, 36, 36)
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(24, 24, 24)
                .add(jTextField1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 37, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(53, 53, 53)
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(17, 17, 17)
                .add(salir)
                .addContainerGap(53, Short.MAX_VALUE))
        );
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-644)/2, (screenSize.height-400)/2, 644, 400);
    }// </editor-fold>//GEN-END:initComponents

    private void AdmProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdmProductosActionPerformed
// TODO add your handling code here:
       int tipoItem = 1;
        new ConsultaArSerPro(new javax.swing.JFrame(), true, tipoItem).setVisible(true);

    }//GEN-LAST:event_AdmProductosActionPerformed

    private void AnalizarBeneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnalizarBeneActionPerformed
// TODO add your handling code here:
        Beneficios Pantalla = new  Beneficios();
        Pantalla.setVisible(true);
    }//GEN-LAST:event_AnalizarBeneActionPerformed

    private void AdmProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdmProveedoresActionPerformed
// TODO add your handling code here:
        AdminProveedores Pantalla = new   AdminProveedores();
        Pantalla.setVisible(true);
    }//GEN-LAST:event_AdmProveedoresActionPerformed

    private void AdmClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdmClientesActionPerformed
// TODO add your handling code here:
        AdminClientes Pantalla = new AdminClientes();
        Pantalla.setVisible(true);
    }//GEN-LAST:event_AdmClientesActionPerformed

    private void AdmServActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdmServActionPerformed

       int tipoItem = 2;
        new ConsultaArSerPro(new javax.swing.JFrame(), true, tipoItem).setVisible(true);
        
        
    }//GEN-LAST:event_AdmServActionPerformed

    private void AdmArtiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdmArtiActionPerformed
       int tipoItem = 0;
        new ConsultaArSerPro(new javax.swing.JFrame(), true, tipoItem).setVisible(true);

    }//GEN-LAST:event_AdmArtiActionPerformed

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
       
        System.exit(0);
    }//GEN-LAST:event_salirActionPerformed

    private void jBOCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBOCActionPerformed
        new OCyFabrica(new javax.swing.JFrame(), true).setVisible(true);

    }//GEN-LAST:event_jBOCActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
              
        Frm_GeneraPresu Pantalla = new Frm_GeneraPresu();
        Pantalla.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AdmArti;
    private javax.swing.JButton AdmClientes;
    private javax.swing.JButton AdmProductos;
    private javax.swing.JButton AdmProveedores;
    private javax.swing.JButton AdmServ;
    private javax.swing.JButton AnalizarBene;
    private javax.swing.JButton jBOC;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton salir;
    // End of variables declaration//GEN-END:variables
    
}
