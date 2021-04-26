/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import Clases.ConexionDB;
import Clases.cFechayHora;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;


/**
 *
 * @author moise
 */
public class frmRImprimirConsulta extends javax.swing.JFrame {

    /**
     * Creates new form frmMedicamentos
     */
    public frmRImprimirConsulta() {
        initComponents();
        this.setLocationRelativeTo(null);
        model = (DefaultTableModel) t_consulta.getModel();
        grupo.add(rnombre);
        grupo.add(rfecha);
    }
    
    public String url="jdbc:sqlite:C://Repositorio//ADIES-II//BD//ADIES.db";
    Connection connect;
    
    DefaultTableModel model;
    ButtonGroup grupo = new ButtonGroup();
    ConexionDB cc = new ConexionDB();
    cFechayHora fecha = new cFechayHora();
    
    void conectar(){
        try {
            connect = DriverManager.getConnection(url);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No Conectado el Error es: " + e.toString());
            //System.out.println(e.toString());
        }   
    }
    
    void cerrar(){
        try {
            connect.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No Conectado el Error es: " + e.toString());
           // System.out.println(e.toString());
        }
    }
    
    public void mostrarDatosFecha(){
        txtbnombre.setEditable(false);
        model.setRowCount(0);
        String sql_sel = "select c.id_consulta, c.fecha, p.Nombres_PX, c.subtotal, c.descuento, c.total\n"
                + "from consulta as c\n"
                + "inner join citas as ci on ci.id_citas = c.id_citas\n"
                + "inner join Pacientes as p on ci.ID_PX = p.ID_PX\n"
                + "where c.fecha like '%"+fecha.ffecha(jfecha)+"%';";
        ResultSet result = null;
        cc.conectar();
        result = cc.seleccionar(sql_sel);
        try {
            while(result.next()){
                model.addRow(new Object[]{
                    result.getInt("id_consulta"),
                    result.getString("fecha"),
                    result.getString("Nombres_PX"),
                    result.getDouble("subtotal"),
                    result.getDouble("descuento"),
                    result.getDouble("total")
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        cc.cerrar();       
    }
    
    public void mostrarDatosNombre(){
        model.setRowCount(0);
        String sql_sel = "select c.id_consulta, c.fecha, p.Nombres_PX, c.subtotal, c.descuento, c.total\n"
                + "from consulta as c\n"
                + "inner join citas as ci on ci.id_citas = c.id_citas\n"
                + "inner join Pacientes as p on ci.ID_PX = p.ID_PX\n"
                + "where p.Nombres_PX like '%"+txtbnombre.getText()+"%';";
        ResultSet result = null;
        cc.conectar();
        result = cc.seleccionar(sql_sel);
        try {
            while(result.next()){
                model.addRow(new Object[]{
                    result.getInt("id_consulta"),
                    result.getString("fecha"),
                    result.getString("Nombres_PX"),
                    result.getDouble("subtotal"),
                    result.getDouble("descuento"),
                    result.getDouble("total")
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        cc.cerrar();       
    }
    
    
    
        public void pasar_datos(){
            int fila = t_consulta.getSelectedRow();
            String nombre = t_consulta.getValueAt(fila, 0).toString();
            int id = Integer.parseInt(nombre);

            try {
                conectar();
                JasperReport reporte = (JasperReport) JRLoader.loadObject("C:\\Repositorio\\ADIES-II\\ADIES-II\\src\\Reportes\\report_consulta.jasper");
                Map idcon = new HashMap();
                idcon.put("id_cons", id);
                JasperPrint imprimir = JasperFillManager.fillReport(reporte, idcon, connect);
                JasperViewer vista = new JasperViewer(imprimir,false);
                vista.setVisible(true);
                cerrar();
            } catch (Exception e) {
            }
        }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        psalir = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        pprincipal = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        t_consulta = new javax.swing.JTable();
        btnregresar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtbnombre = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jfecha = new com.toedter.calendar.JDateChooser();
        rnombre = new javax.swing.JRadioButton();
        rfecha = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

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

        jPanel1.add(psalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 0, 40, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Demanda de Cupos en Centros Médicos");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 470, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 30));

        pprincipal.setBackground(new java.awt.Color(247, 247, 247));

        jLabel3.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        jLabel3.setText("Seleccione Consulta a Imprimir Factura");

        t_consulta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No. Consulta", "Fecha", "Paciente", "Subtotal", "Descuento", "Total"
            }
        ));
        t_consulta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_consultaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(t_consulta);

        btnregresar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnregresar.setText("Atrás");
        btnregresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregresarActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Buscar por Nombres del Paciente:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Buscar por Fecha:");

        txtbnombre.setBackground(new java.awt.Color(247, 247, 247));
        txtbnombre.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtbnombre.setBorder(null);
        txtbnombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbnombreKeyReleased(evt);
            }
        });

        jfecha.setBackground(new java.awt.Color(247, 247, 247));
        jfecha.setDateFormatString("dd-MM-yyyy");
        jfecha.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jfecha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jfechaKeyReleased(evt);
            }
        });

        rnombre.setBackground(new java.awt.Color(247, 247, 247));
        rnombre.setText("Nombre");
        rnombre.setToolTipText("");
        rnombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rnombreActionPerformed(evt);
            }
        });

        rfecha.setBackground(new java.awt.Color(247, 247, 247));
        rfecha.setText("Fecha");
        rfecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rfechaActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Filtrar por:");

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton1.setText("Buscar por Fecha");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pprincipalLayout = new javax.swing.GroupLayout(pprincipal);
        pprincipal.setLayout(pprincipalLayout);
        pprincipalLayout.setHorizontalGroup(
            pprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pprincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(pprincipalLayout.createSequentialGroup()
                        .addGroup(pprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(pprincipalLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                                    .addComponent(txtbnombre))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5))
                            .addGroup(pprincipalLayout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(95, 95, 95)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rnombre)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pprincipalLayout.createSequentialGroup()
                                .addComponent(rfecha)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnregresar, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pprincipalLayout.createSequentialGroup()
                                .addComponent(jfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 1, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        pprincipalLayout.setVerticalGroup(
            pprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pprincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnregresar)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rnombre)
                    .addComponent(rfecha)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pprincipalLayout.createSequentialGroup()
                        .addGroup(pprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jButton1)
                            .addComponent(txtbnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jfecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
                .addContainerGap())
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
        psalir.setBackground(new Color(133,156,206));
    }//GEN-LAST:event_psalirMouseExited

    private void psalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_psalirMouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_psalirMouseClicked

    private void btnregresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregresarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnregresarActionPerformed

    private void rnombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rnombreActionPerformed
        // TODO add your handling code here:
        txtbnombre.setEditable(true);
    }//GEN-LAST:event_rnombreActionPerformed

    private void txtbnombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbnombreKeyReleased
        // TODO add your handling code here:
            txtbnombre.setEditable(true);
            mostrarDatosNombre();

        
    }//GEN-LAST:event_txtbnombreKeyReleased

    private void rfechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rfechaActionPerformed
        // TODO add your handling code here:
            
    }//GEN-LAST:event_rfechaActionPerformed

    private void jfechaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jfechaKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jfechaKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        mostrarDatosFecha();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void t_consultaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_consultaMouseClicked
        // TODO add your handling code here:
        pasar_datos();
    }//GEN-LAST:event_t_consultaMouseClicked

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
            java.util.logging.Logger.getLogger(frmRImprimirConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmRImprimirConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmRImprimirConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmRImprimirConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmRImprimirConsulta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnregresar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private com.toedter.calendar.JDateChooser jfecha;
    private javax.swing.JPanel pprincipal;
    private javax.swing.JPanel psalir;
    private javax.swing.JRadioButton rfecha;
    private javax.swing.JRadioButton rnombre;
    private javax.swing.JTable t_consulta;
    private javax.swing.JTextField txtbnombre;
    // End of variables declaration//GEN-END:variables
}
