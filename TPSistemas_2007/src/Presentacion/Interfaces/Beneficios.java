package Presentacion.Interfaces;

import Dominio.Aplicacion.Presupuestos;
import Dominio.Controladores.ControladorBeneficios;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;


public class Beneficios extends javax.swing.JFrame {
    
    ControladorBeneficios controlador;
    int filtro;
    /** Creates new form Beneficios */
    public Beneficios() {
        initComponents();
        controlador=new ControladorBeneficios(); 
        this.setTitle("Analizar Beneficios");
        fechaHasta.setText(getFecha());
        Fechadesde.setText(getFecha());
        Todos.setSelected(true);
        filtro=1;
    }
    

    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Fechadesde = new javax.swing.JTextField();
        fechaHasta = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        enFabi = new javax.swing.JRadioButton();
        apro = new javax.swing.JRadioButton();
        Todos = new javax.swing.JRadioButton();
        Consultar = new javax.swing.JButton();
        nuevos = new javax.swing.JRadioButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        Aviso = new javax.swing.JTextField();
        aceptar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        ganaciaTotal = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        jLabel1.setText("Fecha Desde:");

        jLabel2.setText("Fecha Hasta:");

        enFabi.setText("En fabricaci\u00f3n");
        enFabi.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        enFabi.setMargin(new java.awt.Insets(0, 0, 0, 0));
        enFabi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enFabiActionPerformed(evt);
            }
        });

        apro.setText("Aprobados");
        apro.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        apro.setMargin(new java.awt.Insets(0, 0, 0, 0));
        apro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aproActionPerformed(evt);
            }
        });

        Todos.setText("Todos");
        Todos.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        Todos.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Todos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TodosActionPerformed(evt);
            }
        });

        Consultar.setText("Consultar");
        Consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsultarActionPerformed(evt);
            }
        });

        nuevos.setText("Nuevos");
        nuevos.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        nuevos.setMargin(new java.awt.Insets(0, 0, 0, 0));
        nuevos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevosActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(Todos)
                    .add(jLabel1))
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(Fechadesde, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 77, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(39, 39, 39)
                        .add(jLabel2)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(fechaHasta, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 76, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(15, 15, 15)
                        .add(nuevos)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(enFabi)
                        .add(22, 22, 22)
                        .add(apro)))
                .add(97, 97, 97)
                .add(Consultar)
                .addContainerGap(219, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1)
                    .add(Fechadesde, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel2)
                    .add(fechaHasta, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 20, Short.MAX_VALUE)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(Todos)
                    .add(Consultar)
                    .add(apro)
                    .add(enFabi)
                    .add(nuevos)))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nro.Presupuesto", "Cliente", "Fecha", "Estado", "Costo Total", "Precio Total", "Ganacia"
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

        Aviso.setEditable(false);

        aceptar.setText("Salir");
        aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarActionPerformed(evt);
            }
        });

        jLabel3.setText("Ganancia Total $");

        ganaciaTotal.setEditable(false);

        org.jdesktop.layout.GroupLayout jPanel4Layout = new org.jdesktop.layout.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 719, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, Aviso, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 719, Short.MAX_VALUE)
                    .add(jPanel4Layout.createSequentialGroup()
                        .add(jLabel3)
                        .add(12, 12, 12)
                        .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(ganaciaTotal)
                            .add(aceptar, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 244, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 14, Short.MAX_VALUE)
                .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel3)
                    .add(ganaciaTotal, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(6, 6, 6)
                .add(aceptar)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(Aviso, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jPanel4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-765)/2, (screenSize.height-462)/2, 765, 462);
    }// </editor-fold>//GEN-END:initComponents

    private void ConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsultarActionPerformed
// TODO add your handling code here:
        try{ 
         String estado;
         Vector Lpresu=new Vector();
         Lpresu=controlador.consultar(Fechadesde.getText(),fechaHasta.getText(),filtro);
         DefaultTableModel defaultTableModel = (DefaultTableModel) jTable1.getModel();
         
         for(int j=defaultTableModel.getRowCount();j>0;j--)
         defaultTableModel.removeRow(j-1);
         
         float ganTotal=0;
         for(int i=0;i<Lpresu.size();i++){
             Presupuestos p=(Presupuestos)Lpresu.elementAt(i);
             ganTotal+=(p.getTotal()-p.getCosto());
             estado="";
             if ((p.getAprobado()==0)&&(p.getRechazado()==0)&&(p.getEnviado()==0))
                 estado="Nuevo";
             else
                 if((p.getAprobado()==1)&&(p.getEnviado()==0))
                     estado="Aprobado";
                 else
                    if(p.getEnviado()==1)
                        estado="En Producción";
             
             defaultTableModel.addRow( new Object[]{p.getNumero(),p.getCliente().getApellido()+","+p.getCliente().getNombre(),p.getFecha(),estado,"$"+p.getCosto(),"$"+p.getTotal(),"$"+(p.getTotal()-p.getCosto())});
         }
         ganaciaTotal.setText(Float.toString(ganTotal));
       }catch(Exception e){
         Aviso.setText(e.getMessage()+": "+"Error: Verifique el formato de las fechas 'DD/MM/AAAA'");
        }

    }//GEN-LAST:event_ConsultarActionPerformed

    private void nuevosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevosActionPerformed
// TODO add your handling code here:
        Todos.setSelected(false);
        apro.setSelected(false);
        enFabi.setSelected(false);
        filtro=4;
    }//GEN-LAST:event_nuevosActionPerformed

    private void aproActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aproActionPerformed
// TODO add your handling code here:
        nuevos.setSelected(false);
        Todos.setSelected(false);
        enFabi.setSelected(false);
        filtro=3;
    }//GEN-LAST:event_aproActionPerformed

    private void enFabiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enFabiActionPerformed
// TODO add your handling code here:
        apro.setSelected(false);
        Todos.setSelected(false);
        nuevos.setSelected(false);
        filtro=2;
    }//GEN-LAST:event_enFabiActionPerformed

    private void TodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TodosActionPerformed
// TODO add your handling code here:
        nuevos.setSelected(false);
        apro.setSelected(false);
        enFabi.setSelected(false);
        filtro=1;
    }//GEN-LAST:event_TodosActionPerformed

    
 
  
    private String getFecha(){
        Date fechaActual= new Date();
        SimpleDateFormat formato= new SimpleDateFormat("dd/MM/yyyy"); 
        return formato.format(fechaActual);
    }
    
    private void aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarActionPerformed

        this.setVisible(false);
    }//GEN-LAST:event_aceptarActionPerformed
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Aviso;
    private javax.swing.JButton Consultar;
    private javax.swing.JTextField Fechadesde;
    private javax.swing.JRadioButton Todos;
    private javax.swing.JButton aceptar;
    private javax.swing.JRadioButton apro;
    private javax.swing.JRadioButton enFabi;
    private javax.swing.JTextField fechaHasta;
    private javax.swing.JTextField ganaciaTotal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JRadioButton nuevos;
    // End of variables declaration//GEN-END:variables
    
}
