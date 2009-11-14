/*
 * Sistemas de Informacion II 2009
 * Proyecto Sipsa
 */

package sipsa.presentacion.escritorio;

import sipsa.Configuracion;
import sipsa.control.servicios.IReceptorNotificado;
import sipsa.control.servicios.INotificador;

/**
 * Sesion de Cliente conectado al Servidor
 * @author Claudio Rodrigo Pereyra Diaz
 * @author Maria Eugenia Sanchez
 */
public class ServidorGUI extends javax.swing.JFrame implements IReceptorNotificado {

    INotificador servidor;

    /** Creates new form ServidorGUI
     * @param servidor Servidor a observar notificaciones
     */
    public ServidorGUI(INotificador servidor) {
        initComponents();
        Configuracion configuracion = Configuracion.getInstancia();
        this.servidor = servidor;
        this.servidor.addReceptorNotificado(this);
        this.setIconImage(configuracion.getIcono());
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonSalir = new javax.swing.JButton();
        jScrollPaneEventos = new javax.swing.JScrollPane();
        jTextAreaEventos = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Servidor Sipsa");
        setName("SipsaServerGui"); // NOI18N

        jButtonSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sipsa/presentacion/recursos/system-log-out.png"))); // NOI18N
        jButtonSalir.setText("Salir");
        jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirActionPerformed(evt);
            }
        });

        jTextAreaEventos.setColumns(20);
        jTextAreaEventos.setEditable(false);
        jTextAreaEventos.setRows(5);
        jScrollPaneEventos.setViewportView(jTextAreaEventos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonSalir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE)
                    .addComponent(jScrollPaneEventos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPaneEventos, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonSalir)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed
        this.servidor.removeReceptorNotificado(this);
        this.setVisible(false);
        System.exit(0);
}//GEN-LAST:event_jButtonSalirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JScrollPane jScrollPaneEventos;
    private javax.swing.JTextArea jTextAreaEventos;
    // End of variables declaration//GEN-END:variables

    /**
     * Realiza las tareas correspondientes al recibir una natificacion
     * @param notificacion
     */
    public void procesarNotificacion(String notificacion) {
        this.jTextAreaEventos.append(notificacion + "\n");
    }
}