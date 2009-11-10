/*
 * Sistemas de Información II 2009
 * Proyecto Sipsa
 */

package sipsa.presentacion.escritorio;

import sipsa.Configuracion;
import sipsa.presentacion.interfaces.IReporte;

/**
 * Formulario generio para presentar reportes e informes
 * @author Claudio Rodrigo Pereyra Diaz
 * @author Maria Eugenia Sanchez
 */
public class ReporteVisor extends javax.swing.JDialog {

    private IReporte reporte;

    /** Creates new form ReporteVisor
     * @param controlador del comportamiento del formulacion
     */
    public ReporteVisor(IReporte reporte) {
        initComponents();

        Configuracion configuracion = Configuracion.getInstancia();
        this.setIconImage(configuracion.getIcono());
        this.reporte = reporte;
        this.setLocationRelativeTo(null);
        this.setTitle("Visor de Reporte");
        this.jLabelNombre.setText(this.reporte.getNombre());
        this.jTableDatos.setAutoCreateColumnsFromModel(true);
        this.jTableDatos.setModel(this.reporte.getDatos());
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonCerrar = new javax.swing.JButton();
        jButtonImprimir = new javax.swing.JButton();
        jButtonExportar = new javax.swing.JButton();
        jScrollPaneDatos = new javax.swing.JScrollPane();
        jTableDatos = new javax.swing.JTable();
        jLabelNombre = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButtonCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sipsa/presentacion/recursos/system-log-out.png"))); // NOI18N
        jButtonCerrar.setText("Cerrar");
        jButtonCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCerrarActionPerformed(evt);
            }
        });

        jButtonImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sipsa/presentacion/recursos/document-print.png"))); // NOI18N
        jButtonImprimir.setText("Imprimir");
        jButtonImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonImprimirActionPerformed(evt);
            }
        });

        jButtonExportar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sipsa/presentacion/recursos/document-save-as.png"))); // NOI18N
        jButtonExportar.setText("Exportar");
        jButtonExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExportarActionPerformed(evt);
            }
        });

        jTableDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPaneDatos.setViewportView(jTableDatos);

        jLabelNombre.setFont(new java.awt.Font("DejaVu Sans", 1, 24));
        jLabelNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNombre.setText("Reporte OT");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelNombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jScrollPaneDatos, javax.swing.GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonImprimir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonExportar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 162, Short.MAX_VALUE)
                        .addComponent(jButtonCerrar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneDatos, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCerrar)
                    .addComponent(jButtonImprimir)
                    .addComponent(jButtonExportar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCerrarActionPerformed
        this.setVisible(false);
}//GEN-LAST:event_jButtonCerrarActionPerformed

    private void jButtonImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonImprimirActionPerformed
        try {
            this.reporte.imprimir();
        } catch (Exception ex) {
            new DialogoMensaje(DialogoMensaje.Tipo.Información, ex.getLocalizedMessage());
        }
    }//GEN-LAST:event_jButtonImprimirActionPerformed

    private void jButtonExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExportarActionPerformed
        try {
            this.reporte.exportar();
        } catch (Exception ex) {
            new DialogoMensaje(DialogoMensaje.Tipo.Información, ex.getLocalizedMessage());
        }
    }//GEN-LAST:event_jButtonExportarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCerrar;
    private javax.swing.JButton jButtonExportar;
    private javax.swing.JButton jButtonImprimir;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JScrollPane jScrollPaneDatos;
    private javax.swing.JTable jTableDatos;
    // End of variables declaration//GEN-END:variables

}