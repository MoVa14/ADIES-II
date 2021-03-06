/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import Clases.ConexionDB;
import Clases.cFechayHora;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.spi.DirStateFactory;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author moise
 */
public class frmBuscarCita extends javax.swing.JFrame {

    /**
     * Creates new form frmMedicamentos
     */
    public frmBuscarCita() {
        initComponents();
        this.setLocationRelativeTo(null);
        setIconImage(new ImageIcon(getClass().getResource("/Imagenes/icono.png")).getImage());
        model = (DefaultTableModel) t_citas.getModel();
    }

    ConexionDB cc = new ConexionDB();
    DefaultTableModel model;

    public void pasar_datos(){
        
        ResultSet result = null;
        String sql_sel = "select p.ID_PX, p.Nombres_PX, p.Apellidos_PX, m.ID_Medico, m.Nombre, m.Especialidad\n"
                + "from citas as c \n"
                + "inner join Pacientes as p on c.ID_PX = p.ID_PX\n"
                + "inner join medicos as m on c.ID_Medico = m.ID_Medico\n"
                + "where c.id_citas="+ frmConsultas.txtidcita.getText() +" ";
        cc.conectar();
        result = cc.seleccionar(sql_sel);
        try {
            frmConsultas.txtidpx.setText(String.valueOf(result.getInt("ID_PX")));
            frmConsultas.txtpaciente.setText(result.getString("Nombres_PX")+" "+result.getString("Apellidos_PX"));
            frmConsultas.txtiddoc.setText(String.valueOf(result.getInt("ID_Medico")));
            frmConsultas.txtdoctor.setText(result.getString("Nombre"));
            frmConsultas.txtespecialidad.setText(result.getString("Especialidad"));
            
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
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        t_citas = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
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

        jPanel1.add(psalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 0, 40, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Buscar Cita");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 470, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 30));

        pprincipal.setBackground(new java.awt.Color(247, 247, 247));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Citas Programas para Hoy");

        t_citas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No. Cita", "Nombres", "Medico", "Especialidad", "Fecha", "Hora", "Motivo"
            }
        ));
        t_citas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_citasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(t_citas);
        if (t_citas.getColumnModel().getColumnCount() > 0) {
            t_citas.getColumnModel().getColumn(0).setMaxWidth(60);
            t_citas.getColumnModel().getColumn(1).setMaxWidth(300);
            t_citas.getColumnModel().getColumn(2).setMaxWidth(300);
            t_citas.getColumnModel().getColumn(3).setMaxWidth(150);
            t_citas.getColumnModel().getColumn(4).setMaxWidth(80);
            t_citas.getColumnModel().getColumn(5).setMaxWidth(80);
            t_citas.getColumnModel().getColumn(6).setMaxWidth(100);
        }

        javax.swing.GroupLayout pprincipalLayout = new javax.swing.GroupLayout(pprincipal);
        pprincipal.setLayout(pprincipalLayout);
        pprincipalLayout.setHorizontalGroup(
            pprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pprincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 817, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        pprincipalLayout.setVerticalGroup(
            pprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pprincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(pprincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 850, 480));

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

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:

        model.setRowCount(0);
        ResultSet result = null;
        String sql_sel = "select c.id_citas, p.Nombres_PX, m.Nombre, m.Especialidad, c.fecha, c.hora, c.motivo\n"
                + "from citas as c \n"
                + "inner join Pacientes as p on c.ID_PX = p.ID_PX\n"
                + "inner join medicos as m on c.ID_Medico = m.ID_Medico\n"
                + "where c.fecha like '%" + cFechayHora.fecha() + "%' and estado='PENDIENTE'";
        cc.conectar();
        result = cc.seleccionar(sql_sel);
        try {
            while (result.next()) {
                model.addRow(new Object[]{
                    result.getInt("id_citas"),
                    result.getString("Nombres_PX"),
                    result.getString("Nombre"),
                    result.getString("Especialidad"),
                    result.getString("fecha"),
                    result.getString("hora"),
                    result.getString("motivo")
                });

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        cc.cerrar();
    }//GEN-LAST:event_formWindowOpened

    private void t_citasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_citasMouseClicked
        // TODO add your handling code here:
        int fila = t_citas.getSelectedRow();
        frmConsultas.txtidcita.setText(String.valueOf(t_citas.getValueAt(fila, 0)));
        pasar_datos();
        this.dispose();
    }//GEN-LAST:event_t_citasMouseClicked

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
            java.util.logging.Logger.getLogger(frmBuscarCita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmBuscarCita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmBuscarCita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmBuscarCita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmBuscarCita().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel pprincipal;
    private javax.swing.JPanel psalir;
    private javax.swing.JTable t_citas;
    // End of variables declaration//GEN-END:variables
}
