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
public class frmPaciente extends javax.swing.JFrame {

    /**
     * Creates new form frmPaciente
     */
    public frmPaciente() {
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

        jPanel1 = new javax.swing.JPanel();
        psalir = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        pprincipal = new javax.swing.JPanel();
        pdatos = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jLabel15 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        pdatosclinicos = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel17 = new javax.swing.JLabel();
        pguardar = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        pcancelar = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(0, 0));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(133, 156, 206));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/close_peq.png"))); // NOI18N

        javax.swing.GroupLayout psalirLayout = new javax.swing.GroupLayout(psalir);
        psalir.setLayout(psalirLayout);
        psalirLayout.setHorizontalGroup(
            psalirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
        );
        psalirLayout.setVerticalGroup(
            psalirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jPanel1.add(psalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(768, 0, -1, -1));

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel20.setText("Registro de Pacientes");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 210, 30));

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/patient.png"))); // NOI18N
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 30, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 30));

        pprincipal.setBackground(new java.awt.Color(247, 247, 247));
        pprincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pdatos.setBackground(new java.awt.Color(247, 247, 247));
        pdatos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Personales", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        pdatos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("No. Registo de Paciente");
        pdatos.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 33, 152, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("No. de Identificación");
        pdatos.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 63, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Nombres");
        pdatos.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 92, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Apellidos");
        pdatos.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(393, 92, -1, -1));

        jTextField1.setEditable(false);
        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        pdatos.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(172, 30, 210, -1));

        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        pdatos.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(172, 60, 209, -1));

        jTextField3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        pdatos.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(81, 89, 300, -1));

        jTextField4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        pdatos.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(454, 89, 290, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Dirección");
        pdatos.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 126, -1, -1));

        jTextField5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });
        pdatos.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(82, 123, 660, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Celular");
        pdatos.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 160, -1, -1));

        jTextField6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        pdatos.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 157, 160, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Correo");
        pdatos.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 160, -1, -1));

        jTextField7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        pdatos.add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(302, 157, 440, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Estado Civil");
        pdatos.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 194, -1, -1));

        jComboBox1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Casado(a)", "Divorciado(a)", "Soltero(a)", "Union Libre", "Viudo(a)" }));
        pdatos.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 191, 145, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Sexo");
        pdatos.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 194, -1, -1));

        jComboBox2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Femenino", "Masculino" }));
        pdatos.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(302, 191, 179, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Fecha");
        pdatos.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 33, 53, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("04/04/2021");
        pdatos.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(519, 33, 105, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("País de Nacimiento");
        pdatos.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 235, -1, -1));

        jTextField8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        pdatos.add(jTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(139, 232, 241, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("Fecha de Nacimiento");
        pdatos.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(398, 235, -1, -1));

        jFormattedTextField1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        pdatos.add(jFormattedTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(534, 232, 210, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("Tipo de Sangre");
        pdatos.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(499, 194, 100, -1));

        jComboBox3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A +", "A -", "B +", "B -", "O +", "O -", "AB +", "AB -" }));
        pdatos.add(jComboBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(603, 191, 140, -1));

        pprincipal.add(pdatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 770, 280));

        pdatosclinicos.setBackground(new java.awt.Color(247, 247, 247));
        pdatosclinicos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Clínicos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText("Anotaciones del Paciente:");

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel17.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(102, 102, 102));
        jLabel17.setText("Favor mencionar si el paciente presenta enfermedades sitémicas y mencionar cuáles");

        javax.swing.GroupLayout pdatosclinicosLayout = new javax.swing.GroupLayout(pdatosclinicos);
        pdatosclinicos.setLayout(pdatosclinicosLayout);
        pdatosclinicosLayout.setHorizontalGroup(
            pdatosclinicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pdatosclinicosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pdatosclinicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(pdatosclinicosLayout.createSequentialGroup()
                        .addGroup(pdatosclinicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 128, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pdatosclinicosLayout.setVerticalGroup(
            pdatosclinicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pdatosclinicosLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel17)
                .addContainerGap())
        );

        pprincipal.add(pdatosclinicos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 650, -1));

        pguardar.setBackground(new java.awt.Color(247, 247, 247));
        pguardar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pguardar.setPreferredSize(new java.awt.Dimension(0, 83));
        pguardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pguardarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pguardarMouseExited(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/guardarpas.png"))); // NOI18N

        javax.swing.GroupLayout pguardarLayout = new javax.swing.GroupLayout(pguardar);
        pguardar.setLayout(pguardarLayout);
        pguardarLayout.setHorizontalGroup(
            pguardarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
        );
        pguardarLayout.setVerticalGroup(
            pguardarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
        );

        pprincipal.add(pguardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 300, 110, 90));

        pcancelar.setBackground(new java.awt.Color(247, 247, 247));
        pcancelar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pcancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pcancelarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pcancelarMouseExited(evt);
            }
        });

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/borrar.png"))); // NOI18N

        javax.swing.GroupLayout pcancelarLayout = new javax.swing.GroupLayout(pcancelar);
        pcancelar.setLayout(pcancelarLayout);
        pcancelarLayout.setHorizontalGroup(
            pcancelarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
        );
        pcancelarLayout.setVerticalGroup(
            pcancelarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
        );

        pprincipal.add(pcancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 410, 110, 80));

        getContentPane().add(pprincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 800, 510));

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

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void pguardarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pguardarMouseEntered
        // TODO add your handling code here:
        pguardar.setBackground(new Color(51,204,51));
    }//GEN-LAST:event_pguardarMouseEntered

    private void pguardarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pguardarMouseExited
        // TODO add your handling code here:
        pguardar.setBackground(new Color(247,247,247));
    }//GEN-LAST:event_pguardarMouseExited

    private void pcancelarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pcancelarMouseEntered
        // TODO add your handling code here:
        pcancelar.setBackground(new Color(243,106,54));
    }//GEN-LAST:event_pcancelarMouseEntered

    private void pcancelarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pcancelarMouseExited
        // TODO add your handling code here:
        pcancelar.setBackground(new Color(247,247,247));
    }//GEN-LAST:event_pcancelarMouseExited

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
            java.util.logging.Logger.getLogger(frmPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmPaciente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JPanel pcancelar;
    private javax.swing.JPanel pdatos;
    private javax.swing.JPanel pdatosclinicos;
    private javax.swing.JPanel pguardar;
    private javax.swing.JPanel pprincipal;
    private javax.swing.JPanel psalir;
    // End of variables declaration//GEN-END:variables
}