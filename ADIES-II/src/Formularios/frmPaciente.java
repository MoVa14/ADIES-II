/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import java.awt.Color;
import Clases.cFechayHora;

import Clases.ConexionDB;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

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
        setIconImage(new ImageIcon(getClass().getResource("/Imagenes/icono.png")).getImage());
        this.lblfecha.setText(cFechayHora.fecha());
        txtidpaciente.setText(String.valueOf(auto_increment()));

    }

    ConexionDB cc = new ConexionDB();
    cFechayHora fecha = new cFechayHora();

    public int auto_increment() {
        String sql_sel = "select max(ID_PX) from Pacientes";
        ResultSet result = null;
        cc.conectar();
        result = cc.seleccionar(sql_sel);
        int id_px = 0;
        try {
            while (result.next()) {
                id_px = result.getInt(1);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "el error: " + e.toString());
            //System.out.println(e.toString());
        }
        cc.cerrar();
        return ((id_px) + 1);
    }

    public void limpiar() {
        txtidpaciente.setText(String.valueOf(auto_increment()));
        txtdnipx.setText("");
        txtnombrespx.setText("");
        txtapellidospx.setText("");
        txtdireccionpx.setText("");
        txtcelularpx.setText("");
        txtcorreopx.setText("");
        txtanotaciones.setText("");
        cboxestadocivil.setSelectedIndex(0);
        cboxpais.setSelectedIndex(0);
        cboxsexo.setSelectedIndex(0);
        cboxtsangre.setSelectedIndex(0);
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
        txtidpaciente = new javax.swing.JTextField();
        txtnombrespx = new javax.swing.JTextField();
        txtapellidospx = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtdireccionpx = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtcorreopx = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        cboxestadocivil = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        cboxsexo = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        lblfecha = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        cboxtsangre = new javax.swing.JComboBox<>();
        txtcelularpx = new javax.swing.JFormattedTextField();
        txtdnipx = new javax.swing.JFormattedTextField();
        calendariofn = new com.toedter.calendar.JDateChooser();
        cboxpais = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        pdatosclinicos = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtanotaciones = new javax.swing.JTextArea();
        jLabel17 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        pguardar = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        phpaciente = new javax.swing.JPanel();
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

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
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
        jLabel3.setText("DNI");
        pdatos.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 63, 40, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Nombres");
        pdatos.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 92, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Apellidos");
        pdatos.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(393, 92, -1, -1));

        txtidpaciente.setEditable(false);
        txtidpaciente.setBackground(new java.awt.Color(247, 247, 247));
        txtidpaciente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtidpaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidpacienteActionPerformed(evt);
            }
        });
        pdatos.add(txtidpaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(172, 30, 210, -1));

        txtnombrespx.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        pdatos.add(txtnombrespx, new org.netbeans.lib.awtextra.AbsoluteConstraints(81, 89, 300, -1));

        txtapellidospx.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        pdatos.add(txtapellidospx, new org.netbeans.lib.awtextra.AbsoluteConstraints(454, 89, 290, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Direcci??n");
        pdatos.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 126, -1, -1));

        txtdireccionpx.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtdireccionpx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdireccionpxActionPerformed(evt);
            }
        });
        pdatos.add(txtdireccionpx, new org.netbeans.lib.awtextra.AbsoluteConstraints(82, 123, 660, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Celular");
        pdatos.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 160, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Correo");
        pdatos.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 160, -1, -1));

        txtcorreopx.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        pdatos.add(txtcorreopx, new org.netbeans.lib.awtextra.AbsoluteConstraints(302, 157, 440, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Estado Civil");
        pdatos.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 194, -1, -1));

        cboxestadocivil.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cboxestadocivil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Elegir una Opci??n:", "Casado(a)", "Divorciado(a)", "Soltero(a)", "Union Libre", "Viudo(a)" }));
        pdatos.add(cboxestadocivil, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 190, 180, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Sexo");
        pdatos.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 190, -1, 30));

        cboxsexo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cboxsexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Elegir una Opci??n:", "Femenino", "Masculino" }));
        pdatos.add(cboxsexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 190, 160, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Fecha");
        pdatos.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 33, 53, -1));

        lblfecha.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblfecha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblfecha.setText("04/04/2021");
        pdatos.add(lblfecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(519, 33, 105, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Pa??s de Nacimiento");
        pdatos.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 235, -1, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("Fecha de Nacimiento");
        pdatos.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(398, 235, -1, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("Tipo de Sangre");
        pdatos.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(499, 194, 110, -1));

        cboxtsangre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cboxtsangre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Elegir una Opci??n:", "A +", "A -", "B +", "B -", "O +", "O -", "AB +", "AB -" }));
        pdatos.add(cboxtsangre, new org.netbeans.lib.awtextra.AbsoluteConstraints(603, 191, 140, -1));

        try {
            txtcelularpx.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtcelularpx.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        pdatos.add(txtcelularpx, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, 160, -1));

        try {
            txtdnipx.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-####-#####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtdnipx.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        pdatos.add(txtdnipx, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 300, -1));

        calendariofn.setBackground(new java.awt.Color(247, 247, 247));
        calendariofn.setDateFormatString("dd-MM-yyyy");
        calendariofn.setFocusable(false);
        calendariofn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        pdatos.add(calendariofn, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 230, 200, 30));

        cboxpais.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cboxpais.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Elegir una Opci??n:", "Honduras", " " }));
        pdatos.add(cboxpais, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 230, 230, 30));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("*");
        pdatos.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, -1, -1));

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel23.setText("*");
        pdatos.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, -1, -1));

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel24.setText("*");
        pdatos.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, -1, -1));

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel25.setText("*");
        pdatos.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, -1, -1));

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel26.setText("*");
        pdatos.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, -1, -1));

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel27.setText("*");
        pdatos.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 190, -1, -1));

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel28.setText("*");
        pdatos.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 190, -1, -1));

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel29.setText("*");
        pdatos.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 190, -1, -1));

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel30.setText("*");
        pdatos.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 80, -1, -1));

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel31.setText("*");
        pdatos.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 220, -1, -1));

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel32.setText("*");
        pdatos.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 220, -1, -1));

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel33.setText("*");
        pdatos.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 220, -1, -1));

        pprincipal.add(pdatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 770, 280));

        pdatosclinicos.setBackground(new java.awt.Color(247, 247, 247));
        pdatosclinicos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Cl??nicos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText("Anotaciones del Paciente:");

        txtanotaciones.setColumns(20);
        txtanotaciones.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtanotaciones.setRows(5);
        jScrollPane1.setViewportView(txtanotaciones);

        jLabel17.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(102, 102, 102));
        jLabel17.setText("Favor mencionar si el paciente presenta enfermedades sit??micas y mencionar cu??les");

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel22.setText("*");

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
                            .addGroup(pdatosclinicosLayout.createSequentialGroup()
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel22))
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 128, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pdatosclinicosLayout.setVerticalGroup(
            pdatosclinicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pdatosclinicosLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(pdatosclinicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel22))
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
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pguardarMouseClicked(evt);
            }
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

        phpaciente.setBackground(new java.awt.Color(247, 247, 247));
        phpaciente.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        phpaciente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                phpacienteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                phpacienteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                phpacienteMouseExited(evt);
            }
        });

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/borrar.png"))); // NOI18N

        javax.swing.GroupLayout phpacienteLayout = new javax.swing.GroupLayout(phpaciente);
        phpaciente.setLayout(phpacienteLayout);
        phpacienteLayout.setHorizontalGroup(
            phpacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
        );
        phpacienteLayout.setVerticalGroup(
            phpacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
        );

        pprincipal.add(phpaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 410, 110, 80));

        getContentPane().add(pprincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 800, 510));

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

    private void txtidpacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidpacienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidpacienteActionPerformed

    private void txtdireccionpxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdireccionpxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdireccionpxActionPerformed

    private void pguardarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pguardarMouseEntered
        // TODO add your handling code here:
        pguardar.setBackground(new Color(51, 204, 51));
    }//GEN-LAST:event_pguardarMouseEntered

    private void pguardarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pguardarMouseExited
        // TODO add your handling code here:
        pguardar.setBackground(new Color(247, 247, 247));
    }//GEN-LAST:event_pguardarMouseExited

    private void phpacienteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phpacienteMouseEntered
        // TODO add your handling code here:
        phpaciente.setBackground(new Color(243, 106, 54));
    }//GEN-LAST:event_phpacienteMouseEntered

    private void phpacienteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phpacienteMouseExited
        // TODO add your handling code here:
        phpaciente.setBackground(new Color(247, 247, 247));
    }//GEN-LAST:event_phpacienteMouseExited

    private void pguardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pguardarMouseClicked
        // TODO add your handling code here:
        String dni = txtdnipx.getText().trim();
        String celular = txtcelularpx.getText().trim();
        Date dato = calendariofn.getDate();
        if( dni.length() < 15){
            JOptionPane.showMessageDialog(this, "Faltan ingresar el DNI del paciente.");
        }else if (txtnombrespx.getText().isEmpty()
                || txtapellidospx.getText().isEmpty()
                || txtdireccionpx.getText().isEmpty()){

            JOptionPane.showMessageDialog(null, "Faltan Datos por Ingresar, Revisar campos de nombres, apellidos, direcci??n del paciente.");
        }else if(celular.length() < 9){
            JOptionPane.showMessageDialog(this, "Falta ingresar el celular del paciente.");
        }else if(cboxestadocivil.getSelectedIndex() == 0){
            JOptionPane.showMessageDialog(this, "Falta seleccionar el estado civil del paciente.");
        }else if(cboxsexo.getSelectedIndex() == 0){
            JOptionPane.showMessageDialog(this, "Falta seleccionar el sexo del paciente.");
        }else if(cboxtsangre.getSelectedIndex() == 0){
            JOptionPane.showMessageDialog(this, "Falta Seleccionar el tipo de sangre del paciente.");
        }else if(cboxpais.getSelectedIndex() == 0){
            JOptionPane.showMessageDialog(this, "Falta seleccionar el pa??s de nacimiento del paciente.");
        }else if(dato == null){
            JOptionPane.showMessageDialog(this, "Falta ingresar la fecha de nacimiento del paciente.");
        }else if(txtanotaciones.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Falta ingresar las anotaciones cl??nicas del paciente.");
        }else {
            cc.conectar();
            String sql_insert = "insert into Pacientes "
                    + "(No_DNIPX, Nombres_PX, Apellidos_PX, Direccion_PX, Celular_PX, Correo_PX, EstadoCivil_PX, Sexo_PX, TSangre_PX, PNacimiento_PX, FNacimiento_PX, AnotacionesC_PX, FRegistro_PX) "
                    + "values"
                    + "('" + txtdnipx.getText() + "',upper('" + txtnombrespx.getText() + "'),upper('" + txtapellidospx.getText() + "'),upper('" + txtdireccionpx.getText() + "'),'" + txtcelularpx.getText() + "',lower('" + txtcorreopx.getText() + "'),upper('" + cboxestadocivil.getSelectedItem() + "'),upper('" + cboxsexo.getSelectedItem() + "'),'" + cboxtsangre.getSelectedItem() + "',upper('" + cboxpais.getSelectedItem() + "'),'" + fecha.ffecha(calendariofn) + "',upper('" + txtanotaciones.getText() + "'),'" + lblfecha.getText() + "')";
            cc.insertar(sql_insert);
            cc.cerrar();
            limpiar();
            JOptionPane.showMessageDialog(null, "Se ha registrado el paciente con ??xito.");
        }


    }//GEN-LAST:event_pguardarMouseClicked

    private void phpacienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phpacienteMouseClicked
        // TODO add your handling code here:
        frmHPacientes abrir = new frmHPacientes();
        abrir.setVisible(true);
    }//GEN-LAST:event_phpacienteMouseClicked

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
    private com.toedter.calendar.JDateChooser calendariofn;
    private javax.swing.JComboBox<String> cboxestadocivil;
    private javax.swing.JComboBox<String> cboxpais;
    private javax.swing.JComboBox<String> cboxsexo;
    private javax.swing.JComboBox<String> cboxtsangre;
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
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblfecha;
    private javax.swing.JPanel pdatos;
    private javax.swing.JPanel pdatosclinicos;
    private javax.swing.JPanel pguardar;
    private javax.swing.JPanel phpaciente;
    private javax.swing.JPanel pprincipal;
    private javax.swing.JPanel psalir;
    private javax.swing.JTextArea txtanotaciones;
    private javax.swing.JTextField txtapellidospx;
    private javax.swing.JFormattedTextField txtcelularpx;
    private javax.swing.JTextField txtcorreopx;
    private javax.swing.JTextField txtdireccionpx;
    private javax.swing.JFormattedTextField txtdnipx;
    private javax.swing.JTextField txtidpaciente;
    private javax.swing.JTextField txtnombrespx;
    // End of variables declaration//GEN-END:variables
}
