/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import Clases.ConexionDB;
import java.awt.Color;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author moise
 */
public class frmMedicamentos extends javax.swing.JFrame {

    /**
     * Creates new form frmMedicos
     */
    public frmMedicamentos() {
        initComponents();
        this.setLocationRelativeTo(null);
        model = (DefaultTableModel) this.t_medicamentos.getModel();
    }
    DefaultTableModel model;
    ConexionDB cc = new ConexionDB();
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
        jLabel3 = new javax.swing.JLabel();
        pprincipal = new javax.swing.JPanel();
        pactualizar = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        pagregar = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtbuscar = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        t_medicamentos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(133, 156, 206));

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

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Medicamentos");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 622, Short.MAX_VALUE)
                .addComponent(psalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(psalir, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, -1));

        pprincipal.setBackground(new java.awt.Color(247, 247, 247));
        pprincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pactualizar.setBackground(new java.awt.Color(247, 247, 247));
        pactualizar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pactualizar.setToolTipText("Actualizar Tabla de Médicos");
        pactualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pactualizarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pactualizarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pactualizarMouseExited(evt);
            }
        });

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/actualizar.png"))); // NOI18N

        javax.swing.GroupLayout pactualizarLayout = new javax.swing.GroupLayout(pactualizar);
        pactualizar.setLayout(pactualizarLayout);
        pactualizarLayout.setHorizontalGroup(
            pactualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );
        pactualizarLayout.setVerticalGroup(
            pactualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        pprincipal.add(pactualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 11, -1, -1));

        pagregar.setBackground(new java.awt.Color(247, 247, 247));
        pagregar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pagregar.setToolTipText("Agregar Médico");
        pagregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pagregarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pagregarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pagregarMouseExited(evt);
            }
        });

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/agregar.png"))); // NOI18N

        javax.swing.GroupLayout pagregarLayout = new javax.swing.GroupLayout(pagregar);
        pagregar.setLayout(pagregarLayout);
        pagregarLayout.setHorizontalGroup(
            pagregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );
        pagregarLayout.setVerticalGroup(
            pagregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        pprincipal.add(pagregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Ingrese Medicamento a Buscar: ");
        pprincipal.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 31, 220, 30));

        txtbuscar.setBackground(new java.awt.Color(247, 247, 247));
        txtbuscar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtbuscar.setBorder(null);
        txtbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbuscarKeyReleased(evt);
            }
        });
        pprincipal.add(txtbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 30, 300, 30));
        pprincipal.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 62, 320, 10));

        t_medicamentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre Comercial", "Compuesto", "Laboratorio", "Estante", "Existencia", "Fecha Elaboracion", "Fecha Vencimiento"
            }
        ));
        t_medicamentos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_medicamentosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(t_medicamentos);
        if (t_medicamentos.getColumnModel().getColumnCount() > 0) {
            t_medicamentos.getColumnModel().getColumn(0).setMaxWidth(210);
            t_medicamentos.getColumnModel().getColumn(1).setMaxWidth(100);
            t_medicamentos.getColumnModel().getColumn(2).setMaxWidth(210);
            t_medicamentos.getColumnModel().getColumn(3).setMaxWidth(50);
            t_medicamentos.getColumnModel().getColumn(4).setMaxWidth(60);
            t_medicamentos.getColumnModel().getColumn(5).setMaxWidth(100);
            t_medicamentos.getColumnModel().getColumn(6).setMaxWidth(100);
        }

        pprincipal.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 830, 420));

        getContentPane().add(pprincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 850, 520));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void psalirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_psalirMouseEntered
        // TODO add your handling code here:
        psalir.setBackground(Color.red);

    }//GEN-LAST:event_psalirMouseEntered

    private void psalirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_psalirMouseExited
        // TODO add your handling code here:
        psalir.setBackground(new Color(133, 156, 206));
    }//GEN-LAST:event_psalirMouseExited

    private void psalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_psalirMouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_psalirMouseClicked

    private void pagregarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pagregarMouseEntered
        // TODO add your handling code here:
        pagregar.setBackground(new Color(51, 204, 51));
    }//GEN-LAST:event_pagregarMouseEntered

    private void pagregarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pagregarMouseExited
        // TODO add your handling code here:
        pagregar.setBackground(new Color(247, 247, 247));
    }//GEN-LAST:event_pagregarMouseExited

    private void pactualizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pactualizarMouseEntered
        // TODO add your handling code here:
        pactualizar.setBackground(new Color(243, 106, 54));
    }//GEN-LAST:event_pactualizarMouseEntered

    private void pactualizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pactualizarMouseExited
        // TODO add your handling code here:
        pactualizar.setBackground(new Color(247, 247, 247));
    }//GEN-LAST:event_pactualizarMouseExited

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        model.setRowCount(0);
        String sql_sel = "select nombre_com, compuesto, laboratorio, estante, existencias, f_elaboracion, f_vencimiento from medicamentos order by nombre_com";
        ResultSet result = null;
        cc.conectar();
        result = cc.seleccionar(sql_sel);
        try {
            while (result.next()) {
                model.addRow(new Object[]{
                    result.getString("nombre_com"),
                    result.getString("compuesto"),
                    result.getString("laboratorio"),
                    result.getInt("estante"),
                    result.getInt("existencias"),
                    result.getString("f_elaboracion"),
                    result.getString("f_vencimiento")
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "El Error es: " + e.toString());
        }
        cc.cerrar();

    }//GEN-LAST:event_formWindowOpened

    public void pasar_datosmed() {

        ResultSet result = null;
        String sql_sel = "select id \n"
                + "from medicamentos\n"
                + "where nombre_com like'%"+frmConsultas.txtaddmed.getText()+"%';";
        cc.conectar();
        result = cc.seleccionar(sql_sel);
        try {
            frmConsultas.txtidmed.setText(String.valueOf(result.getInt("id")));
            

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        cc.cerrar();
    }

    private void t_medicamentosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_medicamentosMouseClicked
        // TODO add your handling code here:
        int fila = t_medicamentos.getSelectedRow();
        frmConsultas.txtaddmed.setText(String.valueOf(t_medicamentos.getValueAt(fila, 0)));
        pasar_datosmed();
        this.dispose();
        


    }//GEN-LAST:event_t_medicamentosMouseClicked

    private void txtbuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyReleased
        // TODO add your handling code here:
        model.setRowCount(0);
        String sql_sel = "select nombre_com, compuesto, laboratorio, estante, existencias, f_elaboracion, f_vencimiento from medicamentos where nombre_com like '%" + txtbuscar.getText().toString() + "%' order by nombre_com";
        ResultSet result = null;
        cc.conectar();
        result = cc.seleccionar(sql_sel);
        try {
            while (result.next()) {
                model.addRow(new Object[]{
                    result.getString("nombre_com"),
                    result.getString("compuesto"),
                    result.getString("laboratorio"),
                    result.getInt("estante"),
                    result.getInt("existencias"),
                    result.getString("f_elaboracion"),
                    result.getString("f_vencimiento")
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "El Error es: " + e.toString());
        }
        cc.cerrar();
    }//GEN-LAST:event_txtbuscarKeyReleased

    private void pagregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pagregarMouseClicked
        // TODO add your handling code here:
        frmAgregarMedicamento abrir = new frmAgregarMedicamento();
        abrir.setVisible(true);

    }//GEN-LAST:event_pagregarMouseClicked

    private void pactualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pactualizarMouseClicked
        // TODO add your handling code here:
        model.setRowCount(0);
        String sql_sel = "select nombre_com, compuesto, laboratorio, estante, existencias, f_elaboracion, f_vencimiento from medicamentos order by nombre_com";
        ResultSet result = null;
        cc.conectar();
        result = cc.seleccionar(sql_sel);
        try {
            while (result.next()) {
                model.addRow(new Object[]{
                    result.getString("nombre_com"),
                    result.getString("compuesto"),
                    result.getString("laboratorio"),
                    result.getInt("estante"),
                    result.getInt("existencias"),
                    result.getString("f_elaboracion"),
                    result.getString("f_vencimiento")
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "El Error es: " + e.toString());
        }
        cc.cerrar();
    }//GEN-LAST:event_pactualizarMouseClicked

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
            java.util.logging.Logger.getLogger(frmMedicamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmMedicamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmMedicamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmMedicamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmMedicamentos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel pactualizar;
    private javax.swing.JPanel pagregar;
    private javax.swing.JPanel pprincipal;
    private javax.swing.JPanel psalir;
    private javax.swing.JTable t_medicamentos;
    private javax.swing.JTextField txtbuscar;
    // End of variables declaration//GEN-END:variables
}