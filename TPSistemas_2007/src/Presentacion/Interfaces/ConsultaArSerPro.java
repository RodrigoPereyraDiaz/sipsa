package Presentacion.Interfaces;
import Dominio.Aplicacion.*;
import Dominio.Controladores.*;
import Presentacion.Interfaces.*;

import java.sql.SQLException;
import java.util.*;
import java.util.regex.*;
import javax.swing.table.DefaultTableModel;


/**
* <p>
* Pantalla de ingreso para Administrar los ítems. 
 * Se pueden consultar artículos,
 *productos y servicios. La consulta se realiza filtrando
 *por id, costo y/o descripción de los ítems.
 *Los resultados de la consulta se muestran en una tabla, especificando
 *id, descripción, costo y precio de cada ítem.
* </p>
*/

public class ConsultaArSerPro extends javax.swing.JDialog {
    ControladorABM control;
 
    AMItem am;
    int tipoItem;
    Items it, m;
    boolean focoCreacion, realizoBusqueda;
    //variables filtros busqueda
    int indiceArti, indiceCosto, idIt = 0;
    String vacio = "", d;
    float  p;
    float c;

    
    public ConsultaArSerPro(java.awt.Frame parent, boolean modal, int tItem) {
        super(parent, modal);
        initComponents();
        this.tipoItem = tItem;
        control = new ControladorABM(tipoItem);
     
        focoCreacion = true;
        realizoBusqueda = false;
        this.jTFArticulo.setEditable(false);
        this.jTFCosto.setEditable(false);
    }
    
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jBAgregar = new javax.swing.JButton();
        jBModificar = new javax.swing.JButton();
        jBEliminar = new javax.swing.JButton();
        jBSalir = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTFArticulo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTFDescripcion = new javax.swing.JTextField();
        jTFCosto = new javax.swing.JTextField();
        jCBCosto = new javax.swing.JComboBox();
        jBBuscar = new javax.swing.JButton();
        jCBArticulo = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta");
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Código", "Descripción", "Costo", "Precio"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Float.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jBAgregar.setText("Agregar");
        jBAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAgregarActionPerformed(evt);
            }
        });

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

        jBSalir.setText("Salir");
        jBSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalirActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .add(31, 31, 31)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
                    .add(jBSalir)
                    .add(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jBAgregar)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jBModificar)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jBEliminar))
                    .add(jLabel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 509, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 124, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jLabel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 20, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jBAgregar)
                    .add(jBModificar)
                    .add(jBEliminar))
                .add(17, 17, 17)
                .add(jBSalir)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jLabel1.setText("C\u00f3digo ");

        jLabel3.setText("Descripci\u00f3n");

        jLabel4.setText("Costo");

        jCBCosto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todos", "Igual a", "Mayor que", "Menor que" }));
        jCBCosto.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCBCostoItemStateChanged(evt);
            }
        });

        jBBuscar.setText("Buscar");
        jBBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBuscarActionPerformed(evt);
            }
        });

        jCBArticulo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todos", "Igual a", "Mayor que", "Menor que" }));
        jCBArticulo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCBArticuloItemStateChanged(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jLabel1)
                    .add(jLabel4))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(jCBArticulo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jTFArticulo))
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(jCBCosto, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jTFCosto, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 50, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(jLabel3)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jTFDescripcion, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 148, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(27, 27, 27)
                .add(jBBuscar)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1)
                    .add(jCBArticulo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel3)
                    .add(jTFDescripcion, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jTFArticulo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jBBuscar))
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(15, 15, 15)
                        .add(jLabel4))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(jCBCosto, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(jTFCosto, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-614)/2, (screenSize.height-395)/2, 614, 395);
    }// </editor-fold>//GEN-END:initComponents

    private void jBSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalirActionPerformed

        this.getParent().setVisible(false);
    }//GEN-LAST:event_jBSalirActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus

        if (focoCreacion){
            focoCreacion = false;
        }else{
            if(realizoBusqueda){
                try {
                    this.refrescarPantalla();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }//GEN-LAST:event_formWindowGainedFocus

    private void jCBArticuloItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCBArticuloItemStateChanged
        if (this.jCBArticulo.getSelectedIndex() == 0){
            this.jTFArticulo.setText("");
            this.jTFArticulo.setEditable(false);
        }else{
            this.jTFArticulo.setEditable(true);
        }
    }//GEN-LAST:event_jCBArticuloItemStateChanged

    
/**
* <p>
* Realiza la consulta de los ítems de acuerdo a los 
 * fitros ingresados, mostrando los resultados en una tabla.
* </p>
*/    
    
    private void jBBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBuscarActionPerformed
        indiceArti = 0;
        indiceCosto = 0;
        idIt = 0;
        d ="";
        c = 0;
        realizoBusqueda = true;
        jLabel2.setText("");

        //Obtengo datos ingresados en filtros para variables de busqueda
        if (!(jTFArticulo.getText().equals(vacio)))
            idIt = Integer.parseInt(jTFArticulo.getText());

        if (!(jTFDescripcion.getText().equals(vacio)))
            d = jTFDescripcion.getText();
        
        if (!(jTFCosto.getText().equals(vacio)))
            c = Float.parseFloat(jTFCosto.getText());

        indiceArti = jCBArticulo.getSelectedIndex();
        indiceCosto = jCBCosto.getSelectedIndex();
        Vector v = null;
        try {
            v = control.getListaItems(idIt, d, c, indiceArti, indiceCosto, tipoItem);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        this.llenarTabla(v);
    }//GEN-LAST:event_jBBuscarActionPerformed

    private void jCBCostoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCBCostoItemStateChanged
        if (this.jCBCosto.getSelectedIndex() == 0){
            this.jTFCosto.setText("");
            this.jTFCosto.setEditable(false);
        }else{
            this.jTFCosto.setEditable(true);
        }
    }//GEN-LAST:event_jCBCostoItemStateChanged

    
/**
* <p>
* Elimina el ítem que fue seleccionado de la tabla.
* </p>
*/        
    
    private void jBEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEliminarActionPerformed

        int filaSeleccionada = jTable1.getSelectedRow();
        if (filaSeleccionada == -1){
            if (realizoBusqueda){
                jLabel2.setText("Debe seleccionar un Item de la grilla");
            }else{
                jLabel2.setText("Debe realizar una búsqueda y luego seleccionar un Item de la grilla");
            }
        }else{
                int nro = Integer.parseInt(String.valueOf(jTable1.getValueAt(jTable1.getSelectedRow(),0)));
                try {
                    control.eliminarItem(nro);
                    this.refrescarPantalla();
                    jLabel2.setText("El Item se eliminó correctamente.");
                } catch (Exception ex) {

                    jLabel2.setText("No se puede eliminar el Item.");
                }
        }
    }//GEN-LAST:event_jBEliminarActionPerformed

    
/**
* <p>
* Recoge los datos del ítem seleccionado en la tabla, para la modificación del mismo.
* </p>
*/        
    
    private void jBModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBModificarActionPerformed

        String mCodigo = "", mDescripcion = "", mPrecio = "";
        int filaSeleccionada = jTable1.getSelectedRow();
        if (filaSeleccionada == -1){
            if (realizoBusqueda){
                jLabel2.setText("Debe seleccionar un Item de la grilla");
            }else{
                jLabel2.setText("Debe realizar una búsqueda y luego seleccionar un Item de la grilla");
            }
        }else{
            int id = (Integer)jTable1.getValueAt(jTable1.getSelectedRow(),0);
            String des = (String)jTable1.getValueAt(jTable1.getSelectedRow(),1);
            Float cos = (Float)jTable1.getValueAt(jTable1.getSelectedRow(),2);
            Float pre = (Float)jTable1.getValueAt(jTable1.getSelectedRow(),3);
            
            if (tipoItem ==1){
                new AMProductos(new javax.swing.JFrame(), true, tipoItem, id, des).setVisible(true);
            }else{
                new AMItem(new javax.swing.JFrame(), true, id, des, cos, pre, tipoItem).setVisible(true); 
            }
        }
    }//GEN-LAST:event_jBModificarActionPerformed

    
/**
* <p>
* Ingresa a la pantalla que permite agregar un nuevo ítem.
* </p>
*/        
    
    private void jBAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAgregarActionPerformed

        if (tipoItem ==1){
            new AMProductos(new javax.swing.JFrame(), true, tipoItem).setVisible(true);
        }else{
            new AMItem(new javax.swing.JFrame(), true, tipoItem).setVisible(true);
        }
    }//GEN-LAST:event_jBAgregarActionPerformed
    
    
/**
* <p>
* Completa la tabla con los resultados de la consulta realizada.
* </p>
*/        
    
    public void llenarTabla(Vector v){
        DefaultTableModel defaultTableModel = (DefaultTableModel) jTable1.getModel();
        for (int i=defaultTableModel.getRowCount()-1; i>=0; i--){
            defaultTableModel.removeRow(i);
        }
        for (int i=0;i<v.size();i++){
            Items a=(Items)v.elementAt(i);    
            defaultTableModel.addRow( new Object[]{a.getId(), a.getDescripcion(), a.getCosto(), a.getPrecio()});
        }
    }
    
    public void refrescarPantalla() throws SQLException{
        Vector v = control.getListaItems(idIt, d, c, indiceArti, indiceCosto, tipoItem);
        this.llenarTabla(v);
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAgregar;
    private javax.swing.JButton jBBuscar;
    private javax.swing.JButton jBEliminar;
    private javax.swing.JButton jBModificar;
    private javax.swing.JButton jBSalir;
    private javax.swing.JComboBox jCBArticulo;
    private javax.swing.JComboBox jCBCosto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTFArticulo;
    private javax.swing.JTextField jTFCosto;
    private javax.swing.JTextField jTFDescripcion;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
    
}
