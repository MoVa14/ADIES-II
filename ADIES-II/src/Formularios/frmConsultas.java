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
import javax.swing.ImageIcon;
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
public class frmConsultas extends javax.swing.JFrame {

    /**
     * Creates new form frmMedicamentos
     */
    public frmConsultas() {
        initComponents();
        this.setLocationRelativeTo(null);
        setIconImage(new ImageIcon(getClass().getResource("/Imagenes/icono.png")).getImage());
        model = (DefaultTableModel) t_productos.getModel();
        lblfecha.setText(cFechayHora.fecha());
        lblConsulta.setText(String.valueOf(auto_increment()));
    }

    public String url="jdbc:sqlite:C://Repositorio//ADIES-II//BD//ADIES.db";
    Connection connect;
    
    ConexionDB cc = new ConexionDB();
    DefaultTableModel model;
    
    
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

    public void limpiarproducto(){
        txtidmed.setText("");
        txtaddmed.setText("");
        txtcantidad.setText("");
        txtprecio.setText("");
    }
        
    public int auto_increment() {
        String sql_sel = "select max(id_consulta) from consulta";
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
    
    public void agregarsql() {
        int idconsulta = auto_increment();
        int codigo = Integer.parseInt(txtidmed.getText());
        double cantidad = Double.valueOf(txtcantidad.getText());
        double precio = Double.valueOf(txtprecio.getText());
        double subtotal = cantidad * precio;

        if (txtidmed.getText().isEmpty() || txtaddmed.getText().isEmpty() || txtcantidad.getText().isEmpty() || txtprecio.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Faltan datos por ingresar, revisar que todos los campos se encuentren llenos en el formulario.");
        } else {
            String insert_sql = "insert into consulta_detalle (id_consulta, id, cantidad, precio, subtotal)"
                    + "values(" + idconsulta + "," + codigo + "," + cantidad + "," + precio + "," + subtotal + ")";
            cc.conectar();
            cc.insertar(insert_sql);
            cc.cerrar();
            limpiarproducto();
        }
    }
    
    public void mostarproducto(){
        model.setRowCount(0);
        int idconsulta = auto_increment();
        String sql_sel = "select m.id, m.nombre_com, cd.cantidad, cd.precio, cd.subtotal\n"
                + "from consulta_detalle as cd\n"
                + "inner join medicamentos as m on cd.id = m.id\n"
                + "where cd.id_consulta="+idconsulta+"";
        ResultSet result = null;
        cc.conectar();
        result = cc.seleccionar(sql_sel);
        try {
            while(result.next()){
                model.addRow(new Object[]{
                result.getInt("id"),
                result.getString("nombre_com"),
                result.getDouble("cantidad"),
                result.getDouble("precio"),
                result.getDouble("subtotal")
            });
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        cc.cerrar();
    }
    
    public double subtotal(){
        double st = 0;
        for(int i=0; i<t_productos.getRowCount(); i++){
            st=st+Double.parseDouble(t_productos.getValueAt(i, 4).toString());
        }
        return st;
    }
    
    public double total (){
        double t = subtotal() - Double.valueOf(txtdescuento.getText());
        return t;
    }
    
    public void limpiar(){
        lblConsulta.setText(String.valueOf(auto_increment()));
        txtidcita.setText("");
        txtidpx.setText("");
        txtpaciente.setText("");
        txtiddoc.setText("");
        txtdoctor.setText("");
        txtespecialidad.setText("");
        model.setRowCount(0);
        txtindicaciones.setText("");
        lblsubtotal.setText("0.00");
        txtdescuento.setText("0.00");
        lbltotal.setText("0.00");
    }
    
    
   public void actualizarEstado(){
       int idcita = Integer.valueOf(txtidcita.getText());
       String sql_act = "UPDATE citas SET estado='ATENDIDO' WHERE id_citas="+idcita;
       cc.conectar();
       cc.insertar(sql_act);
       cc.cerrar();
       JOptionPane.showMessageDialog(null, "El Estado se actualizo correctamente.");
   }
   
   public void imprimir_consulta(){
            int respuesta = JOptionPane.showConfirmDialog(this, "Desea Imprimir la Consulta", "Confirmación", JOptionPane.YES_OPTION, JOptionPane.NO_OPTION);
            if (respuesta == JOptionPane.YES_OPTION){
                try {
                conectar();
                JasperReport reporte = (JasperReport) JRLoader.loadObject("C:\\Repositorio\\ADIES-II\\ADIES-II\\src\\Reportes\\report_consulta.jasper");
                Map idcon = new HashMap();
                idcon.put("id_cons", Integer.valueOf(lblConsulta.getText()));
                JasperPrint imprimir = JasperFillManager.fillReport(reporte, idcon, connect);
                JasperViewer vista = new JasperViewer(imprimir,false);
                vista.setVisible(true);
                cerrar();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.toString());
            }
            }
            else if (respuesta == JOptionPane.NO_OPTION){
                JOptionPane.showMessageDialog(this, "Se guardaron los datos con éxito.");
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

        jPanel1 = new javax.swing.JPanel();
        psalir = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        pprincipal = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lblfecha = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblConsulta = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtidpx = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtiddoc = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtespecialidad = new javax.swing.JTextField();
        pproductos = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtaddmed = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtcantidad = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        pbuscarmed = new javax.swing.JPanel();
        btnbuscar = new javax.swing.JLabel();
        txtidmed = new javax.swing.JTextField();
        txtprecio = new javax.swing.JFormattedTextField();
        btnagregar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        t_productos = new javax.swing.JTable();
        presumen = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        lblsubtotal = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lbltotal = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        txtdescuento = new javax.swing.JTextField();
        pguardar = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtidcita = new javax.swing.JTextField();
        pbuscarcita = new javax.swing.JPanel();
        btnbuscar3 = new javax.swing.JLabel();
        txtpaciente = new javax.swing.JTextField();
        txtdoctor = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtindicaciones = new javax.swing.JTextArea();
        jLabel15 = new javax.swing.JLabel();

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
        psalir.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 30, 30));

        jPanel1.add(psalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 0, 30, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Consultas / Facturación");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 470, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 30));

        pprincipal.setBackground(new java.awt.Color(247, 247, 247));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Fecha:");

        lblfecha.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("No. de Consulta:");

        lblConsulta.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Paciente:");

        txtidpx.setEditable(false);
        txtidpx.setBackground(new java.awt.Color(0, 0, 0));
        txtidpx.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtidpx.setForeground(new java.awt.Color(255, 255, 255));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Doctor:");

        txtiddoc.setEditable(false);
        txtiddoc.setBackground(new java.awt.Color(0, 0, 0));
        txtiddoc.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtiddoc.setForeground(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Especialidad:");

        txtespecialidad.setEditable(false);
        txtespecialidad.setBackground(new java.awt.Color(0, 0, 0));
        txtespecialidad.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtespecialidad.setForeground(new java.awt.Color(255, 255, 255));

        pproductos.setBackground(new java.awt.Color(247, 247, 247));
        pproductos.setBorder(javax.swing.BorderFactory.createTitledBorder("Agregar Medicamentos"));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Medicamento o Servicio:");

        txtaddmed.setEditable(false);
        txtaddmed.setBackground(new java.awt.Color(0, 0, 0));
        txtaddmed.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtaddmed.setForeground(new java.awt.Color(255, 255, 255));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Cantidad:");

        txtcantidad.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Precio:");

        pbuscarmed.setBackground(new java.awt.Color(247, 247, 247));
        pbuscarmed.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pbuscarmedMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pbuscarmedMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pbuscarmedMouseExited(evt);
            }
        });

        btnbuscar.setBackground(new java.awt.Color(247, 247, 247));
        btnbuscar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnbuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lupa.png"))); // NOI18N
        btnbuscar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout pbuscarmedLayout = new javax.swing.GroupLayout(pbuscarmed);
        pbuscarmed.setLayout(pbuscarmedLayout);
        pbuscarmedLayout.setHorizontalGroup(
            pbuscarmedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pbuscarmedLayout.createSequentialGroup()
                .addComponent(btnbuscar)
                .addGap(0, 1, Short.MAX_VALUE))
        );
        pbuscarmedLayout.setVerticalGroup(
            pbuscarmedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnbuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        txtidmed.setEditable(false);
        txtidmed.setBackground(new java.awt.Color(0, 0, 0));
        txtidmed.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtidmed.setForeground(new java.awt.Color(255, 255, 255));

        txtprecio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        txtprecio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btnagregar.setBackground(new java.awt.Color(247, 247, 247));
        btnagregar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnagregar.setLabel("Agregar");
        btnagregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnagregarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnagregarMouseExited(evt);
            }
        });
        btnagregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pproductosLayout = new javax.swing.GroupLayout(pproductos);
        pproductos.setLayout(pproductosLayout);
        pproductosLayout.setHorizontalGroup(
            pproductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pproductosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pproductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pproductosLayout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtprecio, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnagregar))
                    .addGroup(pproductosLayout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtidmed, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtaddmed)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pbuscarmed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(14, 14, 14))
        );
        pproductosLayout.setVerticalGroup(
            pproductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pproductosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pproductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pproductosLayout.createSequentialGroup()
                        .addGroup(pproductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtaddmed)
                            .addComponent(txtidmed))
                        .addGap(2, 2, 2))
                    .addGroup(pproductosLayout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pproductosLayout.createSequentialGroup()
                        .addComponent(pbuscarmed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(pproductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pproductosLayout.createSequentialGroup()
                        .addGroup(pproductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtprecio, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pproductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addComponent(btnagregar, javax.swing.GroupLayout.Alignment.TRAILING)))
        );

        t_productos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Medicamento", "Cantidad", "Precio", "Subtotal"
            }
        ));
        jScrollPane1.setViewportView(t_productos);

        presumen.setBackground(new java.awt.Color(247, 247, 247));
        presumen.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Resumen Saldos", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Subtotal");

        lblsubtotal.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblsubtotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblsubtotal.setText("0.00");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Descuento");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Total a Pagar");

        lbltotal.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbltotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbltotal.setText("0.00");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("L.");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("L.");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("L.");

        txtdescuento.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtdescuento.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtdescuento.setText("0.00");
        txtdescuento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtdescuentoKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout presumenLayout = new javax.swing.GroupLayout(presumen);
        presumen.setLayout(presumenLayout);
        presumenLayout.setHorizontalGroup(
            presumenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(presumenLayout.createSequentialGroup()
                .addGroup(presumenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, presumenLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtdescuento))
                    .addGroup(presumenLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(presumenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator2)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, presumenLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(presumenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, presumenLayout.createSequentialGroup()
                                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbltotal, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, presumenLayout.createSequentialGroup()
                                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblsubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap())
        );
        presumenLayout.setVerticalGroup(
            presumenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(presumenLayout.createSequentialGroup()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(presumenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblsubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(presumenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                    .addComponent(txtdescuento))
                .addGap(4, 4, 4)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(presumenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbltotal, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pguardar.setBackground(new java.awt.Color(247, 247, 247));
        pguardar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
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

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/agregar.png"))); // NOI18N

        javax.swing.GroupLayout pguardarLayout = new javax.swing.GroupLayout(pguardar);
        pguardar.setLayout(pguardarLayout);
        pguardarLayout.setHorizontalGroup(
            pguardarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pguardarLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pguardarLayout.setVerticalGroup(
            pguardarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pguardarLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Cita:");

        txtidcita.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        pbuscarcita.setBackground(new java.awt.Color(247, 247, 247));
        pbuscarcita.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pbuscarcitaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pbuscarcitaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pbuscarcitaMouseExited(evt);
            }
        });

        btnbuscar3.setBackground(new java.awt.Color(247, 247, 247));
        btnbuscar3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnbuscar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lupa.png"))); // NOI18N
        btnbuscar3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout pbuscarcitaLayout = new javax.swing.GroupLayout(pbuscarcita);
        pbuscarcita.setLayout(pbuscarcitaLayout);
        pbuscarcitaLayout.setHorizontalGroup(
            pbuscarcitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnbuscar3)
        );
        pbuscarcitaLayout.setVerticalGroup(
            pbuscarcitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnbuscar3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        txtpaciente.setEditable(false);
        txtpaciente.setBackground(new java.awt.Color(0, 0, 0));
        txtpaciente.setForeground(new java.awt.Color(255, 255, 255));

        txtdoctor.setEditable(false);
        txtdoctor.setBackground(new java.awt.Color(0, 0, 0));
        txtdoctor.setForeground(new java.awt.Color(255, 255, 255));

        txtindicaciones.setColumns(20);
        txtindicaciones.setRows(5);
        jScrollPane2.setViewportView(txtindicaciones);

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel15.setText("Indicaciones Médicas:");

        javax.swing.GroupLayout pprincipalLayout = new javax.swing.GroupLayout(pprincipal);
        pprincipal.setLayout(pprincipalLayout);
        pprincipalLayout.setHorizontalGroup(
            pprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pprincipalLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pprincipalLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(pprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE)
                    .addComponent(pproductos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)
                    .addGroup(pprincipalLayout.createSequentialGroup()
                        .addGroup(pprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pprincipalLayout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtespecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pprincipalLayout.createSequentialGroup()
                                .addGroup(pprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(pprincipalLayout.createSequentialGroup()
                                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                                        .addGap(2, 2, 2)
                                        .addComponent(txtidcita, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(pbuscarcita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pprincipalLayout.createSequentialGroup()
                                        .addGroup(pprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pprincipalLayout.createSequentialGroup()
                                                .addComponent(jLabel6)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pprincipalLayout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addGap(2, 2, 2)))
                                        .addGroup(pprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtidpx, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                                            .addComponent(txtiddoc))
                                        .addGap(32, 32, 32)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtpaciente)
                                    .addComponent(txtdoctor, javax.swing.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)))
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pprincipalLayout.createSequentialGroup()
                        .addComponent(presumen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pprincipalLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(pprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pprincipalLayout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(140, 140, 140))
                            .addGroup(pprincipalLayout.createSequentialGroup()
                                .addComponent(pguardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(193, 193, 193))))))
        );
        pprincipalLayout.setVerticalGroup(
            pprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pprincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblfecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtidcita, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pprincipalLayout.createSequentialGroup()
                        .addComponent(pbuscarcita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pprincipalLayout.createSequentialGroup()
                        .addGroup(pprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtidpx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pprincipalLayout.createSequentialGroup()
                                .addComponent(txtpaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pprincipalLayout.createSequentialGroup()
                                .addGroup(pprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtiddoc))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pprincipalLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(txtdoctor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)))
                        .addGroup(pprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtespecialidad, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(pproductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pprincipalLayout.createSequentialGroup()
                        .addGroup(pprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(49, 49, 49)
                        .addComponent(pguardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(pprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(presumen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pprincipalLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(155, 155, 155))
        );

        getContentPane().add(pprincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 860, 610));

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

    private void pguardarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pguardarMouseEntered
        // TODO add your handling code here:
        pguardar.setBackground(new Color(51, 204, 51));
    }//GEN-LAST:event_pguardarMouseEntered

    private void pguardarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pguardarMouseExited
        // TODO add your handling code here:
        pguardar.setBackground(new Color(247, 247, 247));
    }//GEN-LAST:event_pguardarMouseExited

    private void pbuscarmedMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pbuscarmedMouseEntered
        // TODO add your handling code here:
        pbuscarmed.setBackground(Color.yellow);
    }//GEN-LAST:event_pbuscarmedMouseEntered

    private void pbuscarmedMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pbuscarmedMouseExited
        // TODO add your handling code here:
        pbuscarmed.setBackground(new Color(247, 247, 247));
    }//GEN-LAST:event_pbuscarmedMouseExited

    private void pbuscarmedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pbuscarmedMouseClicked
        // TODO add your handling code here:
        frmMedicamentos abrir = new frmMedicamentos();
        abrir.setVisible(true);
    }//GEN-LAST:event_pbuscarmedMouseClicked

    private void pbuscarcitaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pbuscarcitaMouseClicked
        // TODO add your handling code here:
        frmBuscarCita abrir = new frmBuscarCita();
        abrir.setVisible(true);
    }//GEN-LAST:event_pbuscarcitaMouseClicked

    private void pbuscarcitaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pbuscarcitaMouseEntered
        // TODO add your handling code here:
        pbuscarcita.setBackground(Color.yellow);
    }//GEN-LAST:event_pbuscarcitaMouseEntered

    private void pbuscarcitaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pbuscarcitaMouseExited
        // TODO add your handling code here:
        pbuscarcita.setBackground(new Color(247, 247, 247));
    }//GEN-LAST:event_pbuscarcitaMouseExited

    private void btnagregarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnagregarMouseEntered
        // TODO add your handling code here:
        btnagregar.setBackground(new Color(51, 204, 51));
    }//GEN-LAST:event_btnagregarMouseEntered

    private void btnagregarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnagregarMouseExited
        // TODO add your handling code here:
        btnagregar.setBackground(new Color(247, 247, 247));
    }//GEN-LAST:event_btnagregarMouseExited
    
    private void btnagregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregarActionPerformed
        // TODO add your handling code here:
        agregarsql();
        mostarproducto();
        lblsubtotal.setText(String.valueOf(subtotal()));
        lbltotal.setText(String.valueOf(total()));

    }//GEN-LAST:event_btnagregarActionPerformed

    private void pguardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pguardarMouseClicked
        // TODO add your handling code here:
        if (txtidcita.getText().isEmpty() ||
            txtindicaciones.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Faltan datos por ingresar, revisar que todos los campos se encuentren llenos en el formulario.");
        }
        else{
            int idcita = Integer.parseInt(txtidcita.getText());
            double sbt = Double.valueOf(lblsubtotal.getText());
            double descuento = Double.valueOf(txtdescuento.getText());
            double totalg = Double.valueOf(lbltotal.getText());
            String indicaciones = txtindicaciones.getText();
            String fecha = lblfecha.getText();

            String sql_insert = "insert into consulta (id_citas,subtotal,descuento,total,indicaciones,fecha)\n"
                    + "values \n"
                    + "(" + idcita + "," + sbt + "," + descuento + "," + totalg + ",upper('" + indicaciones + "'),'" + fecha + "');";
            cc.conectar();
            cc.insertar(sql_insert);
            cc.cerrar();
            actualizarEstado();
            imprimir_consulta();
            limpiar();
        }
        
    }//GEN-LAST:event_pguardarMouseClicked

    private void txtdescuentoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdescuentoKeyReleased
        // TODO add your handling code here:
        lbltotal.setText(String.valueOf(total()));
    }//GEN-LAST:event_txtdescuentoKeyReleased

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
            java.util.logging.Logger.getLogger(frmConsultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmConsultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmConsultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmConsultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmConsultas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnagregar;
    private javax.swing.JLabel btnbuscar;
    private javax.swing.JLabel btnbuscar3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblConsulta;
    private javax.swing.JLabel lblfecha;
    private javax.swing.JLabel lblsubtotal;
    private javax.swing.JLabel lbltotal;
    private javax.swing.JPanel pbuscarcita;
    private javax.swing.JPanel pbuscarmed;
    private javax.swing.JPanel pguardar;
    private javax.swing.JPanel pprincipal;
    private javax.swing.JPanel pproductos;
    private javax.swing.JPanel presumen;
    private javax.swing.JPanel psalir;
    private javax.swing.JTable t_productos;
    public static javax.swing.JTextField txtaddmed;
    private javax.swing.JTextField txtcantidad;
    private javax.swing.JTextField txtdescuento;
    public static javax.swing.JTextField txtdoctor;
    public static javax.swing.JTextField txtespecialidad;
    public static javax.swing.JTextField txtidcita;
    public static javax.swing.JTextField txtiddoc;
    public static javax.swing.JTextField txtidmed;
    public static javax.swing.JTextField txtidpx;
    private javax.swing.JTextArea txtindicaciones;
    public static javax.swing.JTextField txtpaciente;
    private javax.swing.JFormattedTextField txtprecio;
    // End of variables declaration//GEN-END:variables
}
