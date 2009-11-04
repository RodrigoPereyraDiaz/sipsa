/*
 * Sistemas de Informacion II 2009
 * Proyecto Sipsa
 */

package sipsa.presentacion.escritorio;

import sipsa.Configuracion;
import sipsa.presentacion.interfaces.IListarABM;

/**
 * Formulario generio para listar objectos y permiter agregar, modificar y eliminar
 * @author Claudio Rodrigo Pereyra Diaz
 * @author Maria Eugenia Sanchez
 */
public class ListarABM extends javax.swing.JDialog {

    private IListarABM controlador;

    /** Creates new form ListarABM
     * @param controlador Controlador del formulario
     */
    public ListarABM(IListarABM controlador) {
        initComponents();
        
        Configuracion configuracion = Configuracion.getInstancia();
        this.controlador = controlador;
        this.setIconImage(configuracion.getIcono());
        this.setLocationRelativeTo(null);
        this.setTitle("Administrar " + this.controlador.getDescripcion());
        this.jTableDatos.setAutoCreateColumnsFromModel(true);
        this.refrescarTabla();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPaneDatos = new javax.swing.JScrollPane();
        jTableDatos = new javax.swing.JTable();
        jButtonAgregar = new javax.swing.JButton();
        jButtonEliminar = new javax.swing.JButton();
        jButtonCerrar = new javax.swing.JButton();
        jButtonModificar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setFocusCycleRoot(false);
        setLocationByPlatform(true);
        setModal(true);

        jTableDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPaneDatos.setViewportView(jTableDatos);

        jButtonAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sipsa/presentacion/recursos/list-add.png"))); // NOI18N
        jButtonAgregar.setText("Agregar");
        jButtonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarActionPerformed(evt);
            }
        });

        jButtonEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sipsa/presentacion/recursos/list-remove.png"))); // NOI18N
        jButtonEliminar.setText("Eliminar");
        jButtonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarActionPerformed(evt);
            }
        });

        jButtonCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sipsa/presentacion/recursos/system-log-out.png"))); // NOI18N
        jButtonCerrar.setText("Cerrar");
        jButtonCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCerrarActionPerformed(evt);
            }
        });

        jButtonModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sipsa/presentacion/recursos/accessories-text-editor.png"))); // NOI18N
        jButtonModificar.setText("Modificar");
        jButtonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonModificar, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                        .addGap(110, 110, 110)
                        .addComponent(jButtonCerrar, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE))
                    .addComponent(jScrollPaneDatos, javax.swing.GroupLayout.DEFAULT_SIZE, 497, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPaneDatos, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jButtonAgregar)
                    .addComponent(jButtonCerrar)
                    .addComponent(jButtonModificar)
                    .addComponent(jButtonEliminar))
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarActionPerformed
        this.controlador.agregar();
        this.refrescarTabla();
}//GEN-LAST:event_jButtonAgregarActionPerformed

    private void jButtonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarActionPerformed
        int indice = this.jTableDatos.getSelectedRow();
        this.controlador.eliminar(indice);
        this.refrescarTabla();
}//GEN-LAST:event_jButtonEliminarActionPerformed

    private void jButtonCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCerrarActionPerformed
        this.setVisible(false);
}//GEN-LAST:event_jButtonCerrarActionPerformed

    private void jButtonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarActionPerformed
        int indice = this.jTableDatos.getSelectedRow();
        this.controlador.modificar(indice);
        this.refrescarTabla();
}//GEN-LAST:event_jButtonModificarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAgregar;
    private javax.swing.JButton jButtonCerrar;
    private javax.swing.JButton jButtonEliminar;
    private javax.swing.JButton jButtonModificar;
    private javax.swing.JScrollPane jScrollPaneDatos;
    private javax.swing.JTable jTableDatos;
    // End of variables declaration//GEN-END:variables

    private void refrescarTabla(){
        this.jTableDatos.setModel(this.controlador.getModelo());
    }
}