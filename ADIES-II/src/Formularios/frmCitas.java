/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import Clases.ConexionDB;
import Clases.cFechayHora;
import static Formularios.frmConfirmarCita.txtccorreo;
import static Formularios.frmConfirmarCita.txtcespecialidad1;
import static Formularios.frmConfirmarCita.txtcid;
import static Formularios.frmConfirmarCita.txtcidmed;
import static Formularios.frmConfirmarCita.txtcmedico;
import static Formularios.frmConfirmarCita.txtcpaciente;
import java.awt.Color;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

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
        model = (DefaultTableModel) t_citas.getModel();
        txtidcita.setText(String.valueOf(auto_increment()));
        lblpendientes.setText(String.valueOf(citaspendientes())+" / "+String.valueOf(citas()));
        lblatendido.setText(String.valueOf(citasatendidos())+" / "+String.valueOf(citas()));
        lblcancelado.setText(String.valueOf(citascancelados())+" / "+String.valueOf(citas()));
        mostarcitas();
    }
    
    ConexionDB cc = new ConexionDB();
    cFechayHora fecha = new cFechayHora();
    DefaultTableModel model;
    
    public int auto_increment(){
        String sql_sel = "select max(id_citas) from citas";
        ResultSet result = null;
        cc.conectar();
        result = cc.seleccionar(sql_sel);
        int id_px=0;
        try {
            while (result.next()){
                id_px = result.getInt(1);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "el error: "+e.toString());
            //System.out.println(e.toString());
        }
        cc.cerrar();
        return ((id_px)+1);
    }
    
    public int citaspendientes(){
        String sql_sel="select count(estado) as Estado from citas where estado='PENDIENTE' group by estado";
        ResultSet result = null;
        cc.conectar();
        result = cc.seleccionar(sql_sel);
        int pend = 0;
        try {
            while(result.next()){
                pend = result.getInt(1);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        cc.cerrar();
        return pend;
    }
    
    public int citasatendidos(){
        String sql_sel="select count(estado) as Estado from citas where estado='ATENDIDO' group by estado";
        ResultSet result = null;
        cc.conectar();
        result = cc.seleccionar(sql_sel);
        int aten = 0;
        try {
            while(result.next()){
                aten = result.getInt(1);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        cc.cerrar();
        return aten;
    }
    
    public int citascancelados(){
        String sql_sel="select count(estado) as Estado from citas where estado='CANCELADO' group by estado";
        ResultSet result = null;
        cc.conectar();
        result = cc.seleccionar(sql_sel);
        int canc = 0;
        try {
            while(result.next()){
                canc = result.getInt(1);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        cc.cerrar();
        return canc;
    }
    
    public int citas(){
        String sql_sel="select count(estado) as Estado from citas";
        ResultSet result = null;
        cc.conectar();
        result = cc.seleccionar(sql_sel);
        int cont = 0;
        try {
            while(result.next()){
                cont = result.getInt(1);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        cc.cerrar();
        return cont;
    }
    
    
    public void mostarcitas(){
        model.setRowCount(0);
        String fecha = cFechayHora.fecha();
        String sql_sel = "select p.Nombres_PX, m.Nombre, m.Especialidad, c.fecha, c.hora, c.motivo\n"
                + "from citas as c\n"
                + "inner join Pacientes as p on c.ID_PX = p.ID_PX\n"
                + "inner join Medicos as m on c.ID_Medico = m.ID_Medico\n"
                + "where c.fecha='"+fecha+"' and c.estado='PENDIENTE';";
        ResultSet result = null;
        cc.conectar();
        result = cc.seleccionar(sql_sel);
        try {
            while(result.next()){
                model.addRow(new Object[]{
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
    }
    
    public void limpiar(){
        txtidcita.setText(String.valueOf(auto_increment()));
        txtidpx.setText("");
        txtpaciente.setText("");
        txtidmed.setText("");
        txtmedico.setText("");
        txtamcita.setText("");
        lblpendientes.setText(String.valueOf(citaspendientes())+" / "+String.valueOf(citas()));
        lblatendido.setText(String.valueOf(citasatendidos())+" / "+String.valueOf(citas()));
        lblcancelado.setText(String.valueOf(citascancelados())+" / "+String.valueOf(citas()));
    }
    
    public void pasardatoscancelar(){
        int fila = t_citas.getSelectedRow();
        String nombrepx = t_citas.getValueAt(fila, 0).toString();
        String medico = t_citas.getValueAt(fila, 1).toString();
        String especialidad = t_citas.getValueAt(fila, 2).toString();
        String fechac = t_citas.getValueAt(fila, 3).toString();
        String hora = t_citas.getValueAt(fila, 4).toString();
                
        ResultSet result = null;
        String sql_sel = "select c.id_citas, p.Nombres_PX, p.Apellidos_PX, m.Nombre, m.Especialidad, c.fecha, c.hora\n"
                + "from citas as c\n"
                + "inner join Pacientes as p on c.ID_PX = p.ID_PX\n"
                + "inner join Medicos as m on c.ID_Medico = m.ID_Medico\n"
                + "where p.Nombres_PX='"+nombrepx+"' and m.Nombre='"+medico+"' and m.Especialidad='"+especialidad+"' and c.fecha='"+fechac+"' and c.hora='"+hora+"'";
        cc.conectar();
        result = cc.seleccionar(sql_sel);
        try {
            frmCancelarCita.txtcid.setText(String.valueOf(result.getInt("id_citas")));
            frmCancelarCita.txtcpaciente.setText(result.getString("Nombres_PX")+" "+result.getString("Apellidos_PX"));
            frmCancelarCita.txtcmedico.setText(result.getString("Nombre"));
            frmCancelarCita.txtcespecialidad.setText(result.getString("Especialidad"));
            frmCancelarCita.txtcfecha.setText(result.getString("fecha"));
            frmCancelarCita.txtchora.setText(result.getString("hora"));
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        cc.cerrar();
    }
    
    public void ingresar_sql(){
        int idpaciente = Integer.parseInt(txtidpx.getText());
        int idMedico = Integer.parseInt(txtidmed.getText());
        String hora = String.valueOf(cbhora.getSelectedItem());
        String motivo = txtamcita.getText().toString();
        int idcm = 1;
        String estado = "PENDIENTE";
        String sql_insert = "insert into citas\n"
                + "(ID_PX,ID_Medico,fecha,hora,id_CentroMedico,motivo,estado) \n"
                + "values \n"
                + "("+idpaciente+","+idMedico+",'"+fecha.ffecha(jfechacita)+"','"+hora+"',"+idcm+",upper('"+motivo+"'),'"+estado+"')";
        cc.conectar();
        cc.insertar(sql_insert);
        cc.cerrar();
    }
    
    public void enviarpaciente(){
        int idpaciente = Integer.parseInt(txtidpx.getText());
                
        ResultSet result = null;
        String sql_sel = "select p.Nombres_PX, p.Apellidos_PX\n"
                + "from Pacientes as p\n"
                + "where p.ID_PX="+idpaciente+";";
        cc.conectar();
        result = cc.seleccionar(sql_sel);
        try {
            frmConfirmarCita.txtcpaciente.setText(result.getString("Nombres_PX")+" "+result.getString("Apellidos_PX"));
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        cc.cerrar();
    }
    
    public void enviardoctor(){
        int idmedico = Integer.parseInt(txtidmed.getText());
                
        ResultSet result = null;
        String sql_sel = "select m.Nombre, m.Especialidad, m.Correo\n"
                + "from Medicos as m\n"
                + "where m.ID_Medico="+idmedico+";";
        cc.conectar();
        result = cc.seleccionar(sql_sel);
        try {
            frmConfirmarCita.txtcmedico.setText(result.getString("Nombre"));
            frmConfirmarCita.txtcespecialidad1.setText(result.getString("Especialidad"));
            frmConfirmarCita.txtccorreo.setText(result.getString("Correo"));
            
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

        pbarra = new javax.swing.JPanel();
        psalir = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        pprincipal = new javax.swing.JPanel();
        presumen = new javax.swing.JPanel();
        pcpendientes = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lblpendientes = new javax.swing.JLabel();
        pcatendidas = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lblatendido = new javax.swing.JLabel();
        pccanceladas = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        lblcancelado = new javax.swing.JLabel();
        pagendar = new javax.swing.JPanel();
        txtidcita = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtpaciente = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtmedico = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cbhora = new javax.swing.JComboBox<>();
        lblbuscarpx = new javax.swing.JLabel();
        lblbuscardoc = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtamcita = new javax.swing.JTextArea();
        pconfirmar = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jfechacita = new com.toedter.calendar.JDateChooser();
        txtidpx = new javax.swing.JTextField();
        txtidmed = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        t_citas = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        btncancelar = new javax.swing.JButton();
        btnactualizar = new javax.swing.JButton();

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

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
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

        lblpendientes.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblpendientes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout pcpendientesLayout = new javax.swing.GroupLayout(pcpendientes);
        pcpendientes.setLayout(pcpendientesLayout);
        pcpendientesLayout.setHorizontalGroup(
            pcpendientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pcpendientesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(180, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pcpendientesLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblpendientes, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pcpendientesLayout.setVerticalGroup(
            pcpendientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pcpendientesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(lblpendientes, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        presumen.add(pcpendientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 270, -1));

        pcatendidas.setBackground(new java.awt.Color(51, 204, 51));
        pcatendidas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Atendidas");

        lblatendido.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblatendido.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout pcatendidasLayout = new javax.swing.GroupLayout(pcatendidas);
        pcatendidas.setLayout(pcatendidasLayout);
        pcatendidasLayout.setHorizontalGroup(
            pcatendidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pcatendidasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(197, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pcatendidasLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblatendido, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pcatendidasLayout.setVerticalGroup(
            pcatendidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pcatendidasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(lblatendido, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        presumen.add(pcatendidas, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 30, 280, -1));

        pccanceladas.setBackground(new java.awt.Color(243, 106, 54));
        pccanceladas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Canceladas");

        lblcancelado.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblcancelado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout pccanceladasLayout = new javax.swing.GroupLayout(pccanceladas);
        pccanceladas.setLayout(pccanceladasLayout);
        pccanceladasLayout.setHorizontalGroup(
            pccanceladasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pccanceladasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(149, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pccanceladasLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblcancelado, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pccanceladasLayout.setVerticalGroup(
            pccanceladasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pccanceladasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(lblcancelado, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        presumen.add(pccanceladas, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 30, 240, -1));

        pprincipal.add(presumen, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 880, 140));

        pagendar.setBackground(new java.awt.Color(247, 247, 247));
        pagendar.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Agendar Cita", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        txtidcita.setEditable(false);
        txtidcita.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtidcita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidcitaActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Paciente");

        txtpaciente.setBackground(new java.awt.Color(0, 0, 0));
        txtpaciente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtpaciente.setForeground(new java.awt.Color(255, 255, 255));
        txtpaciente.setToolTipText("Digite el Nombre del Paciente");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Médico");

        txtmedico.setBackground(new java.awt.Color(0, 0, 0));
        txtmedico.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtmedico.setForeground(new java.awt.Color(255, 255, 255));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Fecha");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Motivo de Cita:");

        cbhora.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cbhora.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00" }));

        lblbuscarpx.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblbuscarpx.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lupa.png"))); // NOI18N
        lblbuscarpx.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblbuscarpx.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblbuscarpxMouseClicked(evt);
            }
        });

        lblbuscardoc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblbuscardoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lupa.png"))); // NOI18N
        lblbuscardoc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblbuscardoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblbuscardocMouseClicked(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setText("Hora");

        txtamcita.setColumns(20);
        txtamcita.setRows(5);
        jScrollPane1.setViewportView(txtamcita);

        pconfirmar.setBackground(new java.awt.Color(247, 247, 247));
        pconfirmar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pconfirmarMouseClicked(evt);
            }
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
            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
        );

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel14.setText("No. Registro de Cita");

        jfechacita.setBackground(new java.awt.Color(247, 247, 247));
        jfechacita.setDateFormatString("dd-MM-yyyy");
        jfechacita.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txtidpx.setBackground(new java.awt.Color(0, 0, 0));
        txtidpx.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtidpx.setForeground(new java.awt.Color(255, 255, 255));
        txtidpx.setToolTipText("Digite el Nombre del Paciente");

        txtidmed.setBackground(new java.awt.Color(0, 0, 0));
        txtidmed.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtidmed.setForeground(new java.awt.Color(255, 255, 255));
        txtidmed.setToolTipText("Digite el Nombre del Paciente");

        javax.swing.GroupLayout pagendarLayout = new javax.swing.GroupLayout(pagendar);
        pagendar.setLayout(pagendarLayout);
        pagendarLayout.setHorizontalGroup(
            pagendarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pagendarLayout.createSequentialGroup()
                .addGroup(pagendarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pagendarLayout.createSequentialGroup()
                        .addGroup(pagendarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pagendarLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel14)
                                .addGap(18, 18, 18)
                                .addComponent(txtidcita, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pagendarLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addComponent(jfechacita, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pagendarLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(cbhora, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pagendarLayout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pagendarLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pagendarLayout.createSequentialGroup()
                                .addGap(134, 134, 134)
                                .addComponent(pconfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 8, Short.MAX_VALUE))
                    .addGroup(pagendarLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(pagendarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pagendarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtidpx, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtidmed, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pagendarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pagendarLayout.createSequentialGroup()
                                .addComponent(txtmedico)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblbuscardoc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pagendarLayout.createSequentialGroup()
                                .addComponent(txtpaciente)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblbuscarpx, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        pagendarLayout.setVerticalGroup(
            pagendarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pagendarLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(pagendarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pagendarLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel14))
                    .addComponent(txtidcita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(pagendarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblbuscarpx, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pagendarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(txtidpx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtpaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(2, 2, 2)
                .addGroup(pagendarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pagendarLayout.createSequentialGroup()
                        .addGroup(pagendarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pagendarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7)
                                .addComponent(txtidmed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtmedico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(pagendarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pagendarLayout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(jLabel8))
                            .addComponent(jfechacita, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pagendarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pagendarLayout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel12))
                            .addComponent(cbhora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)
                        .addComponent(jLabel9))
                    .addComponent(lblbuscardoc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pconfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pprincipal.add(pagendar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 320, 360));

        t_citas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Paciente", "Medico", "Especialidad", "Fecha", "Hora", "Motivo"
            }
        ));
        jScrollPane2.setViewportView(t_citas);

        pprincipal.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 210, 540, 310));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Resumen de Citas del Dia");
        pprincipal.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 180, 200, 20));

        btncancelar.setBackground(new java.awt.Color(247, 247, 247));
        btncancelar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btncancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cancelar_citas.png"))); // NOI18N
        btncancelar.setText("Cancelar Cita");
        btncancelar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });
        pprincipal.add(btncancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 160, 130, 40));

        btnactualizar.setBackground(new java.awt.Color(247, 247, 247));
        btnactualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/actualizar.png"))); // NOI18N
        btnactualizar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnactualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnactualizarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnactualizarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnactualizarMouseExited(evt);
            }
        });
        pprincipal.add(btnactualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(693, 160, 50, 40));

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

    private void txtidcitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidcitaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidcitaActionPerformed

    private void pconfirmarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pconfirmarMouseEntered
        // TODO add your handling code here:
        pconfirmar.setBackground(new Color(51,204,51));
    }//GEN-LAST:event_pconfirmarMouseEntered

    private void pconfirmarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pconfirmarMouseExited
        // TODO add your handling code here:
        pconfirmar.setBackground(new Color(247,247,247));
    }//GEN-LAST:event_pconfirmarMouseExited

    private void pconfirmarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pconfirmarMouseClicked
        // TODO add your handling code here:
        
        if (txtidpx.getText().isEmpty() ||
            txtidmed.getText().isEmpty() ||
            txtamcita.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Favor revisar el formulario, falta datos por llenar.");
        }
        else{
            frmConfirmarCita abrir = new frmConfirmarCita();
            frmConfirmarCita.txtcid.setText(txtidcita.getText());
            frmConfirmarCita.txtcidp.setText(txtidpx.getText());
            frmConfirmarCita.txtcidmed.setText(txtidmed.getText());
            frmConfirmarCita.txtcfecha.setText(fecha.ffecha(jfechacita));
            frmConfirmarCita.txtchora.setText(cbhora.getSelectedItem().toString());
            frmConfirmarCita.txtmotivocita.setText(txtamcita.getText());
            enviarpaciente();
            enviardoctor();
            abrir.setVisible(true);
            
        }
        
        
    }//GEN-LAST:event_pconfirmarMouseClicked

    private void lblbuscarpxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblbuscarpxMouseClicked
        // TODO add your handling code here:
        frmHPacientes abrir = new frmHPacientes();
        abrir.setVisible(true);
    }//GEN-LAST:event_lblbuscarpxMouseClicked

    private void lblbuscardocMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblbuscardocMouseClicked
        // TODO add your handling code here:
        frmMedicos abrir = new frmMedicos();
        abrir.setVisible(true);
    }//GEN-LAST:event_lblbuscardocMouseClicked

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        // TODO add your handling code here:
        frmCancelarCita abrir = new frmCancelarCita();
        abrir.setVisible(true);
        pasardatoscancelar();
        
    }//GEN-LAST:event_btncancelarActionPerformed

    private void btnactualizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnactualizarMouseEntered
        // TODO add your handling code here:
        btnactualizar.setBackground(new Color(243,106,54));
    }//GEN-LAST:event_btnactualizarMouseEntered

    private void btnactualizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnactualizarMouseExited
        // TODO add your handling code here:
        btnactualizar.setBackground(new Color(247,247,247));
    }//GEN-LAST:event_btnactualizarMouseExited

    private void btnactualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnactualizarMouseClicked
        // TODO add your handling code here:
        mostarcitas();
        lblpendientes.setText(String.valueOf(citaspendientes())+" / "+String.valueOf(citas()));
        lblatendido.setText(String.valueOf(citasatendidos())+" / "+String.valueOf(citas()));
        lblcancelado.setText(String.valueOf(citascancelados())+" / "+String.valueOf(citas()));
        limpiar();
    }//GEN-LAST:event_btnactualizarMouseClicked

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
    private javax.swing.JButton btnactualizar;
    private javax.swing.JButton btncancelar;
    private javax.swing.JComboBox<String> cbhora;
    private javax.swing.JLabel jLabel1;
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
    private com.toedter.calendar.JDateChooser jfechacita;
    private javax.swing.JLabel lblatendido;
    private javax.swing.JLabel lblbuscardoc;
    private javax.swing.JLabel lblbuscarpx;
    private javax.swing.JLabel lblcancelado;
    private javax.swing.JLabel lblpendientes;
    private javax.swing.JPanel pagendar;
    private javax.swing.JPanel pbarra;
    private javax.swing.JPanel pcatendidas;
    private javax.swing.JPanel pccanceladas;
    private javax.swing.JPanel pconfirmar;
    private javax.swing.JPanel pcpendientes;
    private javax.swing.JPanel pprincipal;
    private javax.swing.JPanel presumen;
    private javax.swing.JPanel psalir;
    private javax.swing.JTable t_citas;
    private javax.swing.JTextArea txtamcita;
    private javax.swing.JTextField txtidcita;
    public static javax.swing.JTextField txtidmed;
    public static javax.swing.JTextField txtidpx;
    public static javax.swing.JTextField txtmedico;
    public static javax.swing.JTextField txtpaciente;
    // End of variables declaration//GEN-END:variables
}
