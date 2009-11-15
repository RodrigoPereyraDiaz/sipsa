//TODO agregar la logica para poblar el formulario y para agregar y eliminar modelos

/*
 * Sistemas de Información II 2009
 * Proyecto Sipsa
 */

package sipsa.presentacion.escritorio;

import sipsa.Configuracion;
import sipsa.dominio.TipoProducto;
import sipsa.presentacion.interfaces.ITipoProductoDatos;

/**
 * Formulario de datos de Tipo de Producto
 * @author Claudio Rodrigo Pereyra Diaz
 * @author Maria Eugenia Sanchez
 */
public class TipoProductoDatos extends javax.swing.JDialog {
    private ITipoProductoDatos controlador;
    private TipoProducto tipoProducto;

    /** Construye el formulario de Tipos de Producto
     * @param controlador Controlador del formulario
     * @param tipoProducto
     */
    public TipoProductoDatos(ITipoProductoDatos controlador, TipoProducto tipoProducto) {
        initComponents();
        Configuracion configuracion = Configuracion.getInstancia();
        this.controlador = controlador;
        this.tipoProducto = tipoProducto;
        this.setIconImage(configuracion.getIcono());
        this.setLocationRelativeTo(null);
        this.setTitle("Tipo de Producto");
        this.poblarFormulario();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelNombreProducto = new javax.swing.JLabel();
        jLabelDuracionGarantia = new javax.swing.JLabel();
        jTextFieldNombre = new javax.swing.JTextField();
        jButtonGuardar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jLabelMeses = new javax.swing.JLabel();
        jSpinnerDuracionGarantia = new javax.swing.JSpinner();
        jLabelModelos = new javax.swing.JLabel();
        jScrollPaneModelos = new javax.swing.JScrollPane();
        jListModelos = new javax.swing.JList();
        jTextFieldModelo = new javax.swing.JTextField();
        jButtonEliminarModelo = new javax.swing.JButton();
        jButtonAgregarModelo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(null);
        setLocationByPlatform(true);
        setModal(true);
        setResizable(false);

        jLabelNombreProducto.setText("Nombre:");

        jLabelDuracionGarantia.setText("Duración de la garantía:");

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

        jLabelMeses.setText("Meses");

        jLabelModelos.setText("Modelo:");

        jListModelos.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Modelo 1", "Modelo 2", "Modelo 3", "Modelo 4", "Modelo 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jListModelos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPaneModelos.setViewportView(jListModelos);

        jButtonEliminarModelo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sipsa/presentacion/recursos/list-remove.png"))); // NOI18N
        jButtonEliminarModelo.setToolTipText("Eliminar Modelo");
        jButtonEliminarModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarModeloActionPerformed(evt);
            }
        });

        jButtonAgregarModelo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sipsa/presentacion/recursos/list-add.png"))); // NOI18N
        jButtonAgregarModelo.setToolTipText("Agregar Modelo");
        jButtonAgregarModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarModeloActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPaneModelos, javax.swing.GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelDuracionGarantia)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSpinnerDuracionGarantia, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelMeses))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelNombreProducto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButtonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabelModelos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldModelo, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonAgregarModelo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonEliminarModelo)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNombreProducto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDuracionGarantia)
                    .addComponent(jSpinnerDuracionGarantia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelMeses))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelModelos)
                            .addComponent(jTextFieldModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonAgregarModelo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonEliminarModelo))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneModelos, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonGuardar)
                    .addComponent(jButtonCancelar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarActionPerformed
        this.tipoProducto.setDescripcion(this.jTextFieldNombre.getText());
        this.tipoProducto.setDuracionGarantia(Integer.valueOf(this.jSpinnerDuracionGarantia.getValue().toString()));
        //TODO agregar los modelos desde la lista
        try {
            this.controlador.guardarTipoProducto(this.tipoProducto);
            this.setVisible(false);
        } catch (Exception ex) {
            new DialogoMensaje(DialogoMensaje.Tipo.Error, ex.getLocalizedMessage());
        }
}//GEN-LAST:event_jButtonGuardarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonAgregarModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarModeloActionPerformed
        //TODO agregar modelo a la lista de modelos
}//GEN-LAST:event_jButtonAgregarModeloActionPerformed

    private void jButtonEliminarModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarModeloActionPerformed
        //TODO eliminar modelo de la lista de modelos
    }//GEN-LAST:event_jButtonEliminarModeloActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAgregarModelo;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonEliminarModelo;
    private javax.swing.JButton jButtonGuardar;
    private javax.swing.JLabel jLabelDuracionGarantia;
    private javax.swing.JLabel jLabelMeses;
    private javax.swing.JLabel jLabelModelos;
    private javax.swing.JLabel jLabelNombreProducto;
    private javax.swing.JList jListModelos;
    private javax.swing.JScrollPane jScrollPaneModelos;
    private javax.swing.JSpinner jSpinnerDuracionGarantia;
    private javax.swing.JTextField jTextFieldModelo;
    private javax.swing.JTextField jTextFieldNombre;
    // End of variables declaration//GEN-END:variables

    private void poblarFormulario(){
        this.jTextFieldNombre.setText(this.tipoProducto.getDescripcion());
        this.jSpinnerDuracionGarantia.setValue(this.tipoProducto.getDuracionGarantia());
        this.jTextFieldModelo.setText("");
        //TODO llenar la lista de modelos
    }
}