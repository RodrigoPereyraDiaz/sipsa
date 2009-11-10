//TODO completar el codigo para poblar el formulario y para guardar la OT de acuerdo al estado
package sipsa.presentacion.escritorio;

import sipsa.Configuracion;
import sipsa.dominio.OrdenDeTrabajo;
import sipsa.presentacion.interfaces.IOrdenDeTrabajoDatos;

public class OrdenDeTrabajoDatos extends javax.swing.JDialog {

    IOrdenDeTrabajoDatos controlador;

    /** Creates new form OrdenDeTrabajoDatos */
    public OrdenDeTrabajoDatos(IOrdenDeTrabajoDatos controlador) {
        initComponents();
        Configuracion configuracion = Configuracion.getInstancia();
        this.controlador = controlador;
        this.setIconImage(configuracion.getIcono());
        this.setLocationRelativeTo(null);
        this.setTitle("Orden de Trabajo");
    }

    public void setOT(OrdenDeTrabajo ordenDeTrabajo) {
        switch (ordenDeTrabajo.getEstado()){
            case Nueva: this.jPanelVenta.setEnabled(true);
            case Activa: this.jPanelVenta.setEnabled(false);
            case Finalizada: this.jPanelVenta.setEnabled(false);
            case Anulada: this.jPanelVenta.setEnabled(false);
        }
        
        //TODO rellena con los datos de una OT de acuerdo al estado
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonGuardar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jLabelFechaEntrega = new javax.swing.JLabel();
        jScrollPaneObservaciones = new javax.swing.JScrollPane();
        jTextAreaObservaciones = new javax.swing.JTextArea();
        jLabelEstaado = new javax.swing.JLabel();
        jComboBoxEstado = new javax.swing.JComboBox();
        jPanelVenta = new javax.swing.JPanel();
        jLabelPv = new javax.swing.JLabel();
        jComboBoxPv = new javax.swing.JComboBox();
        jLabelTipoProducto = new javax.swing.JLabel();
        jComboBoxTipoProducto = new javax.swing.JComboBox();
        jLabelModelo = new javax.swing.JLabel();
        jComboBoxModelo = new javax.swing.JComboBox();
        jLabelNroFactura = new javax.swing.JLabel();
        jTextFieldNroFactura = new javax.swing.JTextField();
        jLabelNroSerie = new javax.swing.JLabel();
        jTextFieldNroSerie = new javax.swing.JTextField();
        jLabelMotivoEstado = new javax.swing.JLabel();
        jLabelObservaciones = new javax.swing.JLabel();
        jScrollPaneMotivoEstado = new javax.swing.JScrollPane();
        jTextAreaMotivoEstado = new javax.swing.JTextArea();
        jFormattedTextFieldFechaEntrega = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocationByPlatform(true);
        setModal(true);

        jButtonGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sipsa/presentacion/recursos/document-save.png"))); // NOI18N
        jButtonGuardar.setText("Guardar");
        jButtonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarActionPerformed(evt);
            }
        });

        jButtonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sipsa/presentacion/recursos/process-stop.png"))); // NOI18N
        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jLabelFechaEntrega.setText("Fecha de entrega:");

        jTextAreaObservaciones.setColumns(20);
        jTextAreaObservaciones.setRows(5);
        jScrollPaneObservaciones.setViewportView(jTextAreaObservaciones);

        jLabelEstaado.setText("Estado:");

        jComboBoxEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nueva", "Activa", "Finalizada", "Anulada" }));

        jPanelVenta.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelPv.setText("Punto de venta:");

        jComboBoxPv.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Punto de Venta 1", "Punto de Venta 2", "Punto de Venta 3", "Punto de Venta 4" }));

        jLabelTipoProducto.setText("Tipo de Producto:");

        jComboBoxTipoProducto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tipo Producto 1", "Tipo Producto 2", "Tipo Producto 3", "Tipo Producto 4" }));
        jComboBoxTipoProducto.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxTipoProductoItemStateChanged(evt);
            }
        });
        jComboBoxTipoProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTipoProductoActionPerformed(evt);
            }
        });

        jLabelModelo.setText("Modelo:");

        jComboBoxModelo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Modelo 1", "Modelo 2", "Modelo 3", "Modelo 4" }));

        jLabelNroFactura.setText("Nro de Factura:");

        jLabelNroSerie.setText("Nro de Serie:");

        jTextFieldNroSerie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNroSerieActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelVentaLayout = new javax.swing.GroupLayout(jPanelVenta);
        jPanelVenta.setLayout(jPanelVentaLayout);
        jPanelVentaLayout.setHorizontalGroup(
            jPanelVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelVentaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelTipoProducto)
                    .addComponent(jLabelPv)
                    .addComponent(jLabelModelo)
                    .addComponent(jLabelNroSerie)
                    .addComponent(jLabelNroFactura))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldNroFactura, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
                    .addComponent(jTextFieldNroSerie, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
                    .addComponent(jComboBoxPv, 0, 413, Short.MAX_VALUE)
                    .addComponent(jComboBoxTipoProducto, 0, 413, Short.MAX_VALUE)
                    .addComponent(jComboBoxModelo, 0, 413, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelVentaLayout.setVerticalGroup(
            jPanelVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelVentaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxPv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelPv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNroFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNroFactura))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxTipoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelTipoProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelModelo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNroSerie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNroSerie))
                .addGap(12, 12, 12))
        );

        jLabelMotivoEstado.setText("Motivo del Estado:");

        jLabelObservaciones.setText("Observaciones:");

        jTextAreaMotivoEstado.setColumns(20);
        jTextAreaMotivoEstado.setRows(5);
        jScrollPaneMotivoEstado.setViewportView(jTextAreaMotivoEstado);

        jFormattedTextFieldFechaEntrega.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPaneObservaciones, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 587, Short.MAX_VALUE)
                    .addComponent(jPanelVenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelObservaciones, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(358, 358, 358)
                        .addComponent(jButtonGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabelEstaado)
                            .addComponent(jComboBoxEstado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelFechaEntrega, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jFormattedTextFieldFechaEntrega))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelMotivoEstado)
                            .addComponent(jScrollPaneMotivoEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelObservaciones)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneObservaciones, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelEstaado)
                    .addComponent(jLabelMotivoEstado))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jComboBoxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                        .addComponent(jLabelFechaEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFormattedTextFieldFechaEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPaneMotivoEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonGuardar)
                    .addComponent(jButtonCancelar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarActionPerformed
        new DialogoMensaje(DialogoMensaje.Tipo.Información,"No soportado todavia");
    }//GEN-LAST:event_jButtonGuardarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        this.setVisible(false);
}//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jTextFieldNroSerieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNroSerieActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_jTextFieldNroSerieActionPerformed

    private void jComboBoxTipoProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTipoProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxTipoProductoActionPerformed

    private void jComboBoxTipoProductoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxTipoProductoItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxTipoProductoItemStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonGuardar;
    private javax.swing.JComboBox jComboBoxEstado;
    private javax.swing.JComboBox jComboBoxModelo;
    private javax.swing.JComboBox jComboBoxPv;
    private javax.swing.JComboBox jComboBoxTipoProducto;
    private javax.swing.JFormattedTextField jFormattedTextFieldFechaEntrega;
    private javax.swing.JLabel jLabelEstaado;
    private javax.swing.JLabel jLabelFechaEntrega;
    private javax.swing.JLabel jLabelModelo;
    private javax.swing.JLabel jLabelMotivoEstado;
    private javax.swing.JLabel jLabelNroFactura;
    private javax.swing.JLabel jLabelNroSerie;
    private javax.swing.JLabel jLabelObservaciones;
    private javax.swing.JLabel jLabelPv;
    private javax.swing.JLabel jLabelTipoProducto;
    private javax.swing.JPanel jPanelVenta;
    private javax.swing.JScrollPane jScrollPaneMotivoEstado;
    private javax.swing.JScrollPane jScrollPaneObservaciones;
    private javax.swing.JTextArea jTextAreaMotivoEstado;
    private javax.swing.JTextArea jTextAreaObservaciones;
    private javax.swing.JTextField jTextFieldNroFactura;
    private javax.swing.JTextField jTextFieldNroSerie;
    // End of variables declaration//GEN-END:variables

}
