package Presentacion.Interfaces;

import java.util.*;
import Dominio.Aplicacion.EspecificacionItem;

public class Envio extends javax.swing.JFrame {
    

    public Envio(int NroPresu,Vector ListaProd) {
        initComponents();
        String nuevaLinea = "\n";
        String tab = "\t";
        
        jTArea1.append("Presupuesto Numero: "+NroPresu+nuevaLinea);
        jTArea1.append(nuevaLinea);
        jTArea1.append("Productos incluidos en el presupuesto: "+nuevaLinea+nuevaLinea);
        jTArea1.append("          Producto "+tab+"Cantidad"+nuevaLinea);
        for (int j=0;j<ListaProd.size();j++/*=j+2*/){
              EspecificacionItem p=(EspecificacionItem)ListaProd.elementAt(j);
              jTArea1.append("          "+p.getItem().getDescripcion()+tab+p.getCantidad()+nuevaLinea);  
          }
        this.setVisible(true);
    }

    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jScrollPane1 = new javax.swing.JScrollPane();
        jTArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Detalle Productos por Presupuesto");
        jTArea1.setColumns(20);
        jTArea1.setEditable(false);
        jTArea1.setRows(5);
        jScrollPane1.setViewportView(jTArea1);

        jButton1.setText("Enviar");
        jButton1.setEnabled(false);

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(20, 20, 20)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(layout.createSequentialGroup()
                        .add(jButton2)
                        .add(14, 14, 14)
                        .add(jButton1))
                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 303, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(77, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 221, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jButton1)
                    .add(jButton2))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTextArea jTArea1;
    // End of variables declaration//GEN-END:variables
}
