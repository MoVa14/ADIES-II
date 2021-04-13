/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import java.awt.Color;

/**
 *
 * @author moise
 */
public class frmCitas extends javax.swing.JFrame {

    /**
     * Creates new form frmCitas
     */
    public frmCitas() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pbarra = new javax.swing.JPanel();
        psalir = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        pprincipal = new javax.swing.JPanel();
        presumen = new javax.swing.JPanel();
        pcpendientes = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        pcatendidas = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        pccanceladas = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        pagendar = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        pconfirmar = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pbarra.setBackground(new java.awt.Color(133, 156, 206));
        pbarra.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        psalir.setBackground(new java.awt.Color(133, 156, 206));
        psalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                psalirMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                psalirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                psalirMouseExited(evt);
            }
        });
        psalir.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/close_peq.png"))); // NOI18N
        psalir.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 30, 30));

        pbarra.add(psalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(868, 0, 32, -1));

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cita.png"))); // NOI18N
        pbarra.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 30));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel16.setText("Registro de Citas");
        pbarra.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 300, 30));

        getContentPane().add(pbarra, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 30));

        pprincipal.setBackground(new java.awt.Color(247, 247, 247));
        pprincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        presumen.setBackground(new java.awt.Color(247, 247, 247));
        presumen.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Resumen de Citas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        presumen.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pcpendientes.setBackground(new java.awt.Color(244, 187, 71));
        pcpendientes.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Pendientes");

        javax.swing.GroupLayout pcpendientesLayout = new javax.swing.GroupLayout(pcpendientes);
        pcpendientes.setLayout(pcpendientesLayout);
        pcpendientesLayout.setHorizontalGroup(
            pcpendientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pcpendientesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(180, Short.MAX_VALUE))
        );
        pcpendientesLayout.setVerticalGroup(
            pcpendientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pcpendientesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(65, Short.MAX_VALUE))
        );

        presumen.add(pcpendientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 270, -1));

        pcatendidas.setBackground(new java.awt.Color(51, 204, 51));
        pcatendidas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Atendidas");

        javax.swing.GroupLayout pcatendidasLayout = new javax.swing.GroupLayout(pcatendidas);
        pcatendidas.setLayout(pcatendidasLayout);
        pcatendidasLayout.setHorizontalGroup(
            pcatendidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pcatendidasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(197, Short.MAX_VALUE))
        );
        pcatendidasLayout.setVerticalGroup(
            pcatendidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pcatendidasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(65, Short.MAX_VALUE))
        );

        presumen.add(pcatendidas, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 30, 280, -1));

        pccanceladas.setBackground(new java.awt.Color(243, 106, 54));
        pccanceladas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Canceladas");

        javax.swing.GroupLayout pccanceladasLayout = new javax.swing.GroupLayout(pccanceladas);
        pccanceladas.setLayout(pccanceladasLayout);
        pccanceladasLayout.setHorizontalGroup(
            pccanceladasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pccanceladasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(149, Short.MAX_VALUE))
        );
        pccanceladasLayout.setVerticalGroup(
            pccanceladasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pccanceladasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(65, Short.MAX_VALUE))
        );

        presumen.add(pccanceladas, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 30, 240, -1));

        pprincipal.add(presumen, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 880, 140));

        pagendar.setBackground(new java.awt.Color(247, 247, 247));
        pagendar.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Agendar Cita", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        pagendar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField1.setEditable(false);
        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        pagendar.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(143, 30, 115, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Paciente");
        pagendar.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 63, 62, -1));

        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextField2.setToolTipText("Digite el Nombre del Paciente");
        pagendar.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(82, 60, 145, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Medico");
        pagendar.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 95, 62, -1));

        jTextField3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pagendar.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(82, 92, 145, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Fecha");
        pagendar.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 127, 62, -1));

        jFormattedTextField1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pagendar.add(jFormattedTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(82, 124, 176, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Motivo de Cita:");
        pagendar.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 120, -1));

        jComboBox1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00" }));
        pagendar.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(82, 156, 176, -1));

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lupa.png"))); // NOI18N
        pagendar.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 90, 30, 30));

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lupa.png"))); // NOI18N
        pagendar.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 60, 30, 30));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setText("Hora");
        pagendar.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 159, 62, -1));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        pagendar.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 209, 280, -1));

        pconfirmar.setBackground(new java.awt.Color(247, 247, 247));
        pconfirmar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pconfirmarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pconfirmarMouseExited(evt);
            }
        });

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/confirmar.png"))); // NOI18N
        jLabel13.setText("Agendar y Notificar");

        javax.swing.GroupLayout pconfirmarLayout = new javax.swing.GroupLayout(pconfirmar);
        pconfirmar.setLayout(pconfirmarLayout);
        pconfirmarLayout.setHorizontalGroup(
            pconfirmarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
        );
        pconfirmarLayout.setVerticalGroup(
            pconfirmarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        pagendar.add(pconfirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 310, 150, 30));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel14.setText("No. Registro de Cita");
        pagendar.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 33, -1, -1));

        pprincipal.add(pagendar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 320, 360));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        pprincipal.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 210, 540, 310));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Resumen de Citas del Dia");
        pprincipal.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 180, 200, 20));

        getContentPane().add(pprincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 900, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void psalirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_psalirMouseEntered
        // TODO add your handling code here:
        psalir.setBackground(Color.red);
    }//GEN-LAST:event_psalirMouseEntered

    private void psalirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_psalirMouseExited
        // TODO add your handling code here:
        psalir.setBackground(new Color(133,156,206));
    }//GEN-LAST:event_psalirMouseExited

    private void psalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_psalirMouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_psalirMouseClicked

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void pconfirmarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pconfirmarMouseEntered
        // TODO add your handling code here:
        pconfirmar.setBackground(new Color(51,204,51));
    }//GEN-LAST:event_pconfirmarMouseEntered

    private void pconfirmarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pconfirmarMouseExited
        // TODO add your handling code here:
        pconfirmar.setBackground(new Color(247,247,247));
    }//GEN-LAST:event_pconfirmarMouseExited

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmCitas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmCitas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmCitas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmCitas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmCitas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JPanel pagendar;
    private javax.swing.JPanel pbarra;
    private javax.swing.JPanel pcatendidas;
    private javax.swing.JPanel pccanceladas;
    private javax.swing.JPanel pconfirmar;
    private javax.swing.JPanel pcpendientes;
    private javax.swing.JPanel pprincipal;
    private javax.swing.JPanel presumen;
    private javax.swing.JPanel psalir;
    // End of variables declaration//GEN-END:variables
}
