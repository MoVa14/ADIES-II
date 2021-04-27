/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import Clases.CentroMedico;
import Clases.ConexionDB;
import Clases.IconoForm;
import Clases.Login;
import java.awt.Color;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


/**
 *
 * @author moise
 */
public class frmLogin extends javax.swing.JFrame {

    /**
     * Creates new form frmMedicamentos
     */
    public frmLogin() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setOpacity(0.9f);
        setIconImage(new ImageIcon(getClass().getResource(IconoForm.url())).getImage());
    }
    
    ConexionDB cc = new ConexionDB();
    Login ll = new Login();
    frmPrincipal abrir = new frmPrincipal();
    
    public void obtenerUsuarioyContrasena(String usuario, String contrasena){
        ResultSet result = null;
        String sql_sel = "select user, pass, nombre, cargo\n"
                + "from usuarios\n"
                + "where user='"+usuario+"' and pass='"+contrasena+"';";
        cc.conectar();
        result = cc.seleccionar(sql_sel);
        try {
            if (result.next()){
                usuario = result.getString("user");
                contrasena = result.getString("pass");
                ll.setDbonombre(result.getString("nombre"));
                ll.setDbocargo(result.getString("cargo"));
                if (usuario != null && contrasena != null){
                    switch (ll.getDbocargo()){
                        case "ADMINISTRADOR":
                            JOptionPane.showMessageDialog(null, "Bienvenido "+ll.getDbonombre());
                            frmPrincipal.lblnombre.setText(ll.getDbonombre());
                            frmPrincipal.lblcargo.setText(ll.getDbocargo());
                            frmPrincipal.lblcentro.setText(CentroMedico.getNombre_centro());
                            abrir.setVisible(true);
                            this.setVisible(false);
                            break;
                            
                        case "SECRETARIA":
                            JOptionPane.showMessageDialog(null, "Bienvenido "+ll.getDbonombre());
                            frmPrincipal.lblnombre.setText(ll.getDbonombre());
                            frmPrincipal.lblcargo.setText(ll.getDbocargo());
                            frmPrincipal.lblcentro.setText(CentroMedico.getNombre_centro());
                            frmPrincipal.btnconsulta.setEnabled(false);
                            frmPrincipal.btnmedicos.setEnabled(false);
                            frmPrincipal.btnreportes.setEnabled(false);
                            abrir.setVisible(true);
                            this.setVisible(false);
                            break;
                    }
                }
            }
            else{
                JOptionPane.showMessageDialog(this, "Usuario ó Contraseña incorrecta.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        cc.cerrar();
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        pprincipal = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        txtuser = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        txtpass = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        cbcentromedico = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
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
        psalir.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/close_peq.png"))); // NOI18N
        psalir.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 40, 30));

        jPanel1.add(psalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 0, 40, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Bienvenidos");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 150, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 30));

        pprincipal.setBackground(new java.awt.Color(247, 247, 247));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logo_reportes.png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Usuario");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/usuario.png"))); // NOI18N

        txtuser.setBackground(new java.awt.Color(247, 247, 247));
        txtuser.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtuser.setBorder(null);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/key.png"))); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Contraseña");

        txtpass.setBackground(new java.awt.Color(247, 247, 247));
        txtpass.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtpass.setBorder(null);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("Ingresar");
        jButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Centro Médico");

        cbcentromedico.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbcentromedico.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar un Centro Médico", "CEMER SPS", "CEMER INTIBUCA" }));

        javax.swing.GroupLayout pprincipalLayout = new javax.swing.GroupLayout(pprincipal);
        pprincipal.setLayout(pprincipalLayout);
        pprincipalLayout.setHorizontalGroup(
            pprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
            .addGroup(pprincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pprincipalLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(pprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pprincipalLayout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtuser, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4)))
                    .addGroup(pprincipalLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pprincipalLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7))
                    .addGroup(pprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(pprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pprincipalLayout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtpass, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pprincipalLayout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(pprincipalLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbcentromedico, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pprincipalLayout.setVerticalGroup(
            pprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pprincipalLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pprincipalLayout.createSequentialGroup()
                        .addComponent(cbcentromedico, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                        .addGap(2, 2, 2)))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtuser, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtpass, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        getContentPane().add(pprincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 390, 400));

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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (cbcentromedico.getSelectedIndex() == 0){
            JOptionPane.showMessageDialog(this, "Debe seleccionar un centro médico.");
        }
        else{
            CentroMedico.setId_centro(cbcentromedico.getSelectedIndex());
            CentroMedico.setNombre_centro(cbcentromedico.getSelectedItem().toString());
            obtenerUsuarioyContrasena(txtuser.getText(),txtpass.getText());
        }
                
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JComboBox<String> cbcentromedico;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPanel pprincipal;
    private javax.swing.JPanel psalir;
    private javax.swing.JPasswordField txtpass;
    private javax.swing.JTextField txtuser;
    // End of variables declaration//GEN-END:variables
}
