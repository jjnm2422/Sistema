/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PFormularios;

import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import java.util.Random;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;

/**
 *
 * @author Navarro
 */
public class FVentas extends javax.swing.JFrame {

    private int x;
    private int y;
    private final ImageIcon icon1 = new javax.swing.ImageIcon(getClass().getResource("/PImagenes/oie_canvas.png"));
    private PClases.CFecha fecha = new PClases.CFecha();
    
    public FVentas() {
        this.setlook();
        initComponents();
        setLocationRelativeTo(null);
        txtFecha.setText(fecha.getFecha());
        txtCodigoV.setText(NumeroAleatorio());
    }
    public void setTitle(String title) {
        super.setTitle(title);
        lblTitulo.setText(title);
    }
    
    public void setlook() {
       try{
          UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        }catch(Exception e){
          e.printStackTrace();
        }  
    }
    
    private void restaurarVentana() {
        if(getExtendedState() == JFrame.MAXIMIZED_BOTH){//1
            setExtendedState(JFrame.NORMAL);//2
        }else{
            setExtendedState(JFrame.MAXIMIZED_BOTH);//3
        }
    }
    public void Ajustar(JLabel label, ImageIcon icon){
        //esta funcion ajusta un icono(parametro) al tamaño del label (parametro)
        Icon icono = new ImageIcon(icon.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT));
        label.setIcon(icono);
        this.repaint();
    }
    
        public String NumeroAleatorio(){
    long numero = 0;
    Random rd=new Random();
    numero = rd.nextInt(99999999)+1;
    /*try {
        String sql = "select * from ventas where cod_venta= '"+numero+"'";
        ResultSet rs= operaciones.Consultar(sql);
        while(rs.next()){
        numero = Long.parseLong(this.NumeroAleatorio());
        }
    } catch (SQLException e) {
       JOptionPane.showMessageDialog(null, e.getMessage());    
    }*/
    return String.valueOf(numero);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup = new javax.swing.ButtonGroup();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        lblTitulo11 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        txtCodigo = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        lblTitulo12 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        txtB = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        cbxFiltro = new javax.swing.JComboBox<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        jButton11 = new javax.swing.JButton();
        txtFecha = new javax.swing.JTextField();
        lblTitulo23 = new javax.swing.JLabel();
        lblTitulo24 = new javax.swing.JLabel();
        lblTitulo25 = new javax.swing.JLabel();
        jTextField18 = new javax.swing.JTextField();
        jTextField19 = new javax.swing.JTextField();
        lblTitulo26 = new javax.swing.JLabel();
        jTextField20 = new javax.swing.JTextField();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        lblTitulo21 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        lblTitulo22 = new javax.swing.JLabel();
        lblTitulo32 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        txtCodigoV = new javax.swing.JTextField();
        lblTitulo13 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jTextField21 = new javax.swing.JTextField();
        lblTitulo27 = new javax.swing.JLabel();
        jTextField22 = new javax.swing.JTextField();
        lblTitulo16 = new javax.swing.JLabel();
        lblTitulo17 = new javax.swing.JLabel();
        jTextField23 = new javax.swing.JTextField();
        lblTitulo28 = new javax.swing.JLabel();
        lblTitulo29 = new javax.swing.JLabel();
        jTextField24 = new javax.swing.JTextField();
        lblTitulo30 = new javax.swing.JLabel();
        lblTitulo33 = new javax.swing.JLabel();
        jTextField27 = new javax.swing.JTextField();
        jTextField28 = new javax.swing.JTextField();
        lblTitulo34 = new javax.swing.JLabel();
        jTextField29 = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbl1 = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        lblTitulo31 = new javax.swing.JLabel();
        jTextField25 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ventas");
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));
        jPanel3.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel3MouseDragged(evt);
            }
        });
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel3MousePressed(evt);
            }
        });
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PImagenes/cerrar.png"))); // NOI18N
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 0, 30, 30));

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PImagenes/minimizar.png"))); // NOI18N
        jButton10.setBorderPainted(false);
        jButton10.setContentAreaFilled(false);
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 0, 30, 30));

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jPanel3.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 220, 20));

        jLabel1.setBackground(new java.awt.Color(0, 255, 51));
        jLabel1.setOpaque(true);
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 30));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 51), 4));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitulo11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo11.setText("Codigo Pedido");
        jPanel2.add(lblTitulo11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 100, 20));

        jTextField6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });
        jPanel2.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 180, -1));

        txtCodigo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel2.add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 180, -1));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PImagenes/1497379748_edit-clear.png"))); // NOI18N
        jButton3.setText("Borrar");
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 300, 100, 30));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PImagenes/agt_action_fail.png"))); // NOI18N
        jButton4.setText("Salir");
        jPanel2.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 300, 100, 30));

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PImagenes/1497479141_list-add.png"))); // NOI18N
        jButton7.setText("Añadir");
        jPanel2.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 300, 100, 30));

        lblTitulo12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo12.setText("Tipo de Venta");
        jPanel2.add(lblTitulo12, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, 100, 20));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Productos Diponibles", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 0, 12))); // NOI18N
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel25.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        jLabel25.setText("FILTROS:");
        jPanel6.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, 60, 20));

        txtB.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        txtB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBActionPerformed(evt);
            }
        });
        txtB.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBKeyReleased(evt);
            }
        });
        jPanel6.add(txtB, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 160, 20));

        jLabel26.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        jLabel26.setText("BUSQUEDA");
        jPanel6.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 60, 20));

        cbxFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nombre", "Descripcion", "Codigo" }));
        cbxFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxFiltroActionPerformed(evt);
            }
        });
        jPanel6.add(cbxFiltro, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, 150, 20));

        tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMouseClicked(evt);
            }
        });
        tbl.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblKeyReleased(evt);
            }
        });
        jScrollPane4.setViewportView(tbl);

        jPanel6.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 630, 100));

        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 20, 80, 20));

        jPanel2.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 650, 160));

        txtFecha.setEditable(false);
        txtFecha.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel2.add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 270, 100, 20));

        lblTitulo23.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo23.setText("Precio");
        jPanel2.add(lblTitulo23, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 270, 70, 20));

        lblTitulo24.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo24.setText("Fecha");
        jPanel2.add(lblTitulo24, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 60, 20));

        lblTitulo25.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo25.setText("Total");
        jPanel2.add(lblTitulo25, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 270, 70, 20));

        jTextField18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField18.setEnabled(false);
        jPanel2.add(jTextField18, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 270, 90, 20));

        jTextField19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField19.setEnabled(false);
        jPanel2.add(jTextField19, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 270, 90, 20));

        lblTitulo26.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo26.setText("Cantidad");
        jPanel2.add(lblTitulo26, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 270, 70, 20));

        jTextField20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField20.setEnabled(false);
        jPanel2.add(jTextField20, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 270, 90, 20));

        jRadioButton1.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Pedido");
        jPanel2.add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 10, -1, -1));

        jRadioButton2.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setSelected(true);
        jRadioButton2.setText("Directa");
        jPanel2.add(jRadioButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, -1, -1));

        lblTitulo21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo21.setText("Cedula");
        jPanel2.add(lblTitulo21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 100, 20));

        jTextField10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField10.setEnabled(false);
        jPanel2.add(jTextField10, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 40, 180, -1));

        lblTitulo22.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo22.setText("Cliente");
        jPanel2.add(lblTitulo22, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 40, 100, 20));

        lblTitulo32.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo32.setText("Tipo de Pago");
        jPanel2.add(lblTitulo32, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 70, 100, 20));

        jTextField11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField11.setEnabled(false);
        jPanel2.add(jTextField11, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 70, 180, -1));

        txtCodigoV.setEditable(false);
        txtCodigoV.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel2.add(txtCodigoV, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 180, -1));

        lblTitulo13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo13.setText("Codigo Venta");
        jPanel2.add(lblTitulo13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 100, 20));

        jTabbedPane1.addTab("Nueva Venta", jPanel2);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 51), 4));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PImagenes/agt_action_fail.png"))); // NOI18N
        jButton12.setText("Salir");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 280, 100, 30));

        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PImagenes/1497313212_trash.png"))); // NOI18N
        jButton13.setText("Eliminar");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 280, 100, 30));

        jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PImagenes/1497479197_floppy_disk_save.png"))); // NOI18N
        jButton14.setText("Guardar");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 280, 100, 30));

        jTextField21.setEditable(false);
        jTextField21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel4.add(jTextField21, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 180, -1));

        lblTitulo27.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo27.setText("Cedula/RIF");
        jPanel4.add(lblTitulo27, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 70, 20));

        jTextField22.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField22.setEnabled(false);
        jPanel4.add(jTextField22, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, 100, -1));

        lblTitulo16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo16.setText("Nombre");
        jPanel4.add(lblTitulo16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 70, 20));

        lblTitulo17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo17.setText("Apellido");
        jPanel4.add(lblTitulo17, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 40, 70, 20));

        jTextField23.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField23.setEnabled(false);
        jPanel4.add(jTextField23, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 40, 180, -1));

        lblTitulo28.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo28.setText("Descripcion del Pedido:");
        jPanel4.add(lblTitulo28, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 150, 20));

        lblTitulo29.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo29.setText("Fecha");
        jPanel4.add(lblTitulo29, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 40, 20));

        jTextField24.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField24.setEnabled(false);
        jPanel4.add(jTextField24, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 210, 90, -1));

        lblTitulo30.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo30.setText("Cantidad Productos");
        jPanel4.add(lblTitulo30, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 210, 140, 20));

        lblTitulo33.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo33.setText("Total");
        jPanel4.add(lblTitulo33, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 240, 60, 20));

        jTextField27.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField27.setEnabled(false);
        jPanel4.add(jTextField27, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 240, 90, -1));

        jTextField28.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField28.setEnabled(false);
        jPanel4.add(jTextField28, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 180, -1));

        lblTitulo34.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo34.setText("Fecha Entrega");
        jPanel4.add(lblTitulo34, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 10, -1, 20));

        jTextField29.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField29.setEnabled(false);
        jPanel4.add(jTextField29, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 10, 100, -1));

        tbl1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Descripcion", "Cantidad", "Precio"
            }
        ));
        tbl1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl1MouseClicked(evt);
            }
        });
        tbl1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbl1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbl1KeyReleased(evt);
            }
        });
        jScrollPane5.setViewportView(tbl1);

        jPanel4.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 640, 100));

        lblTitulo31.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo31.setText("Codigo del Pedido");
        jPanel4.add(lblTitulo31, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 140, 20));

        jTextField25.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField25.setEnabled(false);
        jPanel4.add(jTextField25, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, 90, -1));

        jTabbedPane1.addTab("Consultar", jPanel4);

        jPanel3.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 680, 370));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 450));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MousePressed
    x = evt.getX();
    y = evt.getY();
    }//GEN-LAST:event_jPanel3MousePressed

    private void jPanel3MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseDragged
    Point ubicacion = MouseInfo.getPointerInfo().getLocation();//1
    System.out.println("Coordenadas: ("+ubicacion.x+","+ubicacion.y+")");//2
    setLocation(ubicacion.x - x, ubicacion.y - y);//3
    }//GEN-LAST:event_jPanel3MouseDragged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
restaurarVentana();
setExtendedState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void tbl1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbl1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl1KeyReleased

    private void tbl1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbl1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl1KeyPressed

    private void tbl1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl1MouseClicked

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed

    }//GEN-LAST:event_jButton11ActionPerformed

    private void tblKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblKeyReleased

    }//GEN-LAST:event_tblKeyReleased

    private void tblKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblKeyPressed

    }//GEN-LAST:event_tblKeyPressed

    private void tblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMouseClicked

    }//GEN-LAST:event_tblMouseClicked

    private void cbxFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxFiltroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxFiltroActionPerformed

    private void txtBKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBKeyReleased

    }//GEN-LAST:event_txtBKeyReleased

    private void txtBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FVentas().setVisible(true);
            }
        });
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbxFiltro;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField20;
    private javax.swing.JTextField jTextField21;
    private javax.swing.JTextField jTextField22;
    private javax.swing.JTextField jTextField23;
    private javax.swing.JTextField jTextField24;
    private javax.swing.JTextField jTextField25;
    private javax.swing.JTextField jTextField27;
    private javax.swing.JTextField jTextField28;
    private javax.swing.JTextField jTextField29;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTitulo11;
    private javax.swing.JLabel lblTitulo12;
    private javax.swing.JLabel lblTitulo13;
    private javax.swing.JLabel lblTitulo16;
    private javax.swing.JLabel lblTitulo17;
    private javax.swing.JLabel lblTitulo21;
    private javax.swing.JLabel lblTitulo22;
    private javax.swing.JLabel lblTitulo23;
    private javax.swing.JLabel lblTitulo24;
    private javax.swing.JLabel lblTitulo25;
    private javax.swing.JLabel lblTitulo26;
    private javax.swing.JLabel lblTitulo27;
    private javax.swing.JLabel lblTitulo28;
    private javax.swing.JLabel lblTitulo29;
    private javax.swing.JLabel lblTitulo30;
    private javax.swing.JLabel lblTitulo31;
    private javax.swing.JLabel lblTitulo32;
    private javax.swing.JLabel lblTitulo33;
    private javax.swing.JLabel lblTitulo34;
    private javax.swing.JTable tbl;
    private javax.swing.JTable tbl1;
    private javax.swing.JTextField txtB;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtCodigoV;
    private javax.swing.JTextField txtFecha;
    // End of variables declaration//GEN-END:variables
}
