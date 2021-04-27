/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import Clases.CentroMedico;
import Clases.Login;
import java.awt.Color;
import java.awt.Component;
import javax.swing.ImageIcon;
import net.sf.jasperreports.swing.JRViewerEvent;

/**
 *
 * @author moise
 */
public class frmPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form frmPrincipal
     */
    Login ll = new Login();
    
    public frmPrincipal() {
        initComponents();
        this.setLocationRelativeTo(null);
        setIconImage(new ImageIcon(getClass().getResource("/Imagenes/icono.png")).getImage());
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
        jLabel2 = new javax.swing.JLabel();
        psalir = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblnombre = new javax.swing.JLabel();
        lblcargo = new javax.swing.JLabel();
        pcerrars = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        lblcentro = new javax.swing.JLabel();
        pprincipal = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        btncitas = new javax.swing.JButton();
        btnpacientes = new javax.swing.JButton();
        btnmedicos = new javax.swing.JButton();
        btnconsulta = new javax.swing.JButton();
        btnmedicamentos = new javax.swing.JButton();
        btnreportes = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(133, 156, 206));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icono.png"))); // NOI18N

        psalir.setBackground(new java.awt.Color(133, 156, 206));
        psalir.setToolTipText("Salir");
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

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/close.png"))); // NOI18N

        javax.swing.GroupLayout psalirLayout = new javax.swing.GroupLayout(psalir);
        psalir.setLayout(psalirLayout);
        psalirLayout.setHorizontalGroup(
            psalirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        psalirLayout.setVerticalGroup(
            psalirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
            .addComponent(psalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 400, Short.MAX_VALUE)
                .addComponent(psalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 500));

        jPanel2.setBackground(new java.awt.Color(245, 213, 199));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/user.png"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 57));

        lblnombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblnombre.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel2.add(lblnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 0, 355, 30));

        lblcargo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel2.add(lblcargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 36, 149, 21));

        pcerrars.setBackground(new java.awt.Color(245, 213, 199));
        pcerrars.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pcerrarsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pcerrarsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pcerrarsMouseExited(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cerrar-sesion.png"))); // NOI18N
        jLabel11.setText(" Cerrar Sesión");

        javax.swing.GroupLayout pcerrarsLayout = new javax.swing.GroupLayout(pcerrars);
        pcerrars.setLayout(pcerrarsLayout);
        pcerrarsLayout.setHorizontalGroup(
            pcerrarsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
        );
        pcerrarsLayout.setVerticalGroup(
            pcerrarsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        jPanel2.add(pcerrars, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 0, 170, 60));

        lblcentro.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblcentro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel2.add(lblcentro, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 30, 110, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 800, 60));

        pprincipal.setBackground(new java.awt.Color(247, 247, 247));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logo_red.png"))); // NOI18N

        btncitas.setBackground(new java.awt.Color(247, 247, 247));
        btncitas.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btncitas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cita.png"))); // NOI18N
        btncitas.setText(" Citas");
        btncitas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btncitasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btncitasMouseExited(evt);
            }
        });
        btncitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncitasActionPerformed(evt);
            }
        });

        btnpacientes.setBackground(new java.awt.Color(247, 247, 247));
        btnpacientes.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnpacientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/patient.png"))); // NOI18N
        btnpacientes.setText(" Pacientes");
        btnpacientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnpacientesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnpacientesMouseExited(evt);
            }
        });
        btnpacientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpacientesActionPerformed(evt);
            }
        });

        btnmedicos.setBackground(new java.awt.Color(247, 247, 247));
        btnmedicos.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnmedicos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/medicos.png"))); // NOI18N
        btnmedicos.setText(" Médicos");
        btnmedicos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnmedicosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnmedicosMouseExited(evt);
            }
        });
        btnmedicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmedicosActionPerformed(evt);
            }
        });

        btnconsulta.setBackground(new java.awt.Color(247, 247, 247));
        btnconsulta.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnconsulta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/consulta.png"))); // NOI18N
        btnconsulta.setText(" Consulta");
        btnconsulta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnconsultaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnconsultaMouseExited(evt);
            }
        });
        btnconsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnconsultaActionPerformed(evt);
            }
        });

        btnmedicamentos.setBackground(new java.awt.Color(247, 247, 247));
        btnmedicamentos.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnmedicamentos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/medicamento.png"))); // NOI18N
        btnmedicamentos.setText(" Almacen");
        btnmedicamentos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnmedicamentosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnmedicamentosMouseExited(evt);
            }
        });
        btnmedicamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmedicamentosActionPerformed(evt);
            }
        });

        btnreportes.setBackground(new java.awt.Color(247, 247, 247));
        btnreportes.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnreportes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/reporte.png"))); // NOI18N
        btnreportes.setText(" Reportes");
        btnreportes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnreportesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnreportesMouseExited(evt);
            }
        });
        btnreportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnreportesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pprincipalLayout = new javax.swing.GroupLayout(pprincipal);
        pprincipal.setLayout(pprincipalLayout);
        pprincipalLayout.setHorizontalGroup(
            pprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pprincipalLayout.createSequentialGroup()
                .addContainerGap(90, Short.MAX_VALUE)
                .addGroup(pprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btncitas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnconsulta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnmedicamentos, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnpacientes, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnreportes, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnmedicos, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(95, 95, 95))
        );
        pprincipalLayout.setVerticalGroup(
            pprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pprincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(pprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btncitas, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnpacientes, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnmedicos, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnconsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnmedicamentos, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnreportes, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(77, 77, 77))
        );

        getContentPane().add(pprincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 800, 440));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void psalirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_psalirMouseEntered
        // TODO add your handling code here:
        this.psalir.setBackground(Color.red);
    }//GEN-LAST:event_psalirMouseEntered

    private void psalirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_psalirMouseExited
        // TODO add your handling code here:
        this.psalir.setBackground(new Color(133,156,206));
    }//GEN-LAST:event_psalirMouseExited

    private void psalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_psalirMouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_psalirMouseClicked

    private void pcerrarsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pcerrarsMouseEntered
        // TODO add your handling code here:
        pcerrars.setBackground(new Color(133,156,206));
    }//GEN-LAST:event_pcerrarsMouseEntered

    private void pcerrarsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pcerrarsMouseExited
        // TODO add your handling code here:
        pcerrars.setBackground(new Color(245,213,199));
    }//GEN-LAST:event_pcerrarsMouseExited

    private void pcerrarsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pcerrarsMouseClicked
        // TODO add your handling code here:
        frmLogin abrir = new frmLogin();
        abrir.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_pcerrarsMouseClicked

    private void btncitasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btncitasMouseEntered
        // TODO add your handling code here:
        btncitas.setBackground(new Color(133,156,206));
    }//GEN-LAST:event_btncitasMouseEntered

    private void btncitasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btncitasMouseExited
        // TODO add your handling code here:
        btncitas.setBackground(new Color(247,247,247));
    }//GEN-LAST:event_btncitasMouseExited

    private void btncitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncitasActionPerformed
        // TODO add your handling code here:
        frmCitas abrir = new frmCitas();
        abrir.setVisible(true);
    }//GEN-LAST:event_btncitasActionPerformed

    private void btnpacientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpacientesActionPerformed
        // TODO add your handling code here:
        frmPaciente abrir = new frmPaciente();
        abrir.setVisible(true);
    }//GEN-LAST:event_btnpacientesActionPerformed

    private void btnpacientesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnpacientesMouseEntered
        // TODO add your handling code here:
        btnpacientes.setBackground(new Color(133,156,206));
    }//GEN-LAST:event_btnpacientesMouseEntered

    private void btnmedicosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnmedicosMouseEntered
        // TODO add your handling code here:
        btnmedicos.setBackground(new Color(133,156,206));
    }//GEN-LAST:event_btnmedicosMouseEntered

    private void btnconsultaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnconsultaMouseEntered
        // TODO add your handling code here:
        btnconsulta.setBackground(new Color(133,156,206));
    }//GEN-LAST:event_btnconsultaMouseEntered

    private void btnmedicamentosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnmedicamentosMouseEntered
        // TODO add your handling code here:
        btnmedicamentos.setBackground(new Color(133,156,206));
    }//GEN-LAST:event_btnmedicamentosMouseEntered

    private void btnreportesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnreportesMouseEntered
        // TODO add your handling code here:
        btnreportes.setBackground(new Color(133,156,206));
    }//GEN-LAST:event_btnreportesMouseEntered

    private void btnpacientesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnpacientesMouseExited
        // TODO add your handling code here:
        btnpacientes.setBackground(new Color(247,247,247));
    }//GEN-LAST:event_btnpacientesMouseExited

    private void btnmedicosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnmedicosMouseExited
        // TODO add your handling code here:
        btnmedicos.setBackground(new Color(247,247,247));
    }//GEN-LAST:event_btnmedicosMouseExited

    private void btnconsultaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnconsultaMouseExited
        // TODO add your handling code here:
        btnconsulta.setBackground(new Color(247,247,247));
    }//GEN-LAST:event_btnconsultaMouseExited

    private void btnmedicamentosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnmedicamentosMouseExited
        // TODO add your handling code here:
        btnmedicamentos.setBackground(new Color(247,247,247));
    }//GEN-LAST:event_btnmedicamentosMouseExited

    private void btnreportesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnreportesMouseExited
        // TODO add your handling code here:
        btnreportes.setBackground(new Color(247,247,247));
    }//GEN-LAST:event_btnreportesMouseExited

    private void btnmedicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmedicosActionPerformed
        // TODO add your handling code here:
        frmMedicos abrir = new frmMedicos();
        abrir.setVisible(true);
    }//GEN-LAST:event_btnmedicosActionPerformed

    private void btnconsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnconsultaActionPerformed
        // TODO add your handling code here:
        frmConsultas abrir = new frmConsultas();
        abrir.setVisible(true);
    }//GEN-LAST:event_btnconsultaActionPerformed

    private void btnmedicamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmedicamentosActionPerformed
        // TODO add your handling code here:
        frmMedicamentos abrir = new frmMedicamentos();
        abrir.setVisible(true);
    }//GEN-LAST:event_btnmedicamentosActionPerformed

    private void btnreportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnreportesActionPerformed
        // TODO add your handling code here:
        frmReportes abrir = new frmReportes();
        abrir.setVisible(true);
    }//GEN-LAST:event_btnreportesActionPerformed

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
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btncitas;
    public static javax.swing.JButton btnconsulta;
    public static javax.swing.JButton btnmedicamentos;
    public static javax.swing.JButton btnmedicos;
    public static javax.swing.JButton btnpacientes;
    public static javax.swing.JButton btnreportes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public static javax.swing.JLabel lblcargo;
    public static javax.swing.JLabel lblcentro;
    public static javax.swing.JLabel lblnombre;
    private javax.swing.JPanel pcerrars;
    private javax.swing.JPanel pprincipal;
    private javax.swing.JPanel psalir;
    // End of variables declaration//GEN-END:variables
}
