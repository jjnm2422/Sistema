/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PFormularios;

import com.mxrck.autocompleter.TextAutoCompleter;
import com.sun.webkit.event.WCKeyEvent;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.Random;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Navarro
 */
public class FVentas extends javax.swing.JFrame {

    private int x;
    private int y;
    private final ImageIcon icon1 = new javax.swing.ImageIcon(getClass().getResource("/PImagenes/oie_canvas.png"));
    private PBD.Acciones_BD acciones = new PBD.Acciones_BD();
    private final ImageIcon iconError = new javax.swing.ImageIcon(getClass().getResource("/PImagenes/error.png"));
    private final ImageIcon iconCorrecto = new javax.swing.ImageIcon(getClass().getResource("/PImagenes/correcto.png"));
    private final ImageIcon iconAd = new javax.swing.ImageIcon(getClass().getResource("/PImagenes/escudoA.png"));
    private PClases.CFecha cFecha = new PClases.CFecha();
    private PClases.CFecha fecha = new PClases.CFecha();
    TextAutoCompleter txtAuto;
    private DefaultTableModel model;
    private int cantidad;
    private Float total;
    private int iva = 0;
    private int codigo = 0;
    private String descripcion = "";
    private int cantidadProducto = 0;
    private long precioProducto = 0;
    private int cantidadMinimo = 0;
    private int cantidadMaximo = 0;
    private int cantidadVenta = 0;
    private String codigoProveedor = "";
    private String tipoProducto = "";
    private String[] row1 = new String[6];
    private int[][] matriz;
    //establesco la region de la simobologia y formatos
    DecimalFormatSymbols simbolos = DecimalFormatSymbols.getInstance(Locale.ENGLISH);
    private DecimalFormat format = new DecimalFormat("#0.00", simbolos);
    private DecimalFormat formato = new DecimalFormat("##########", simbolos);

    public int getIva() {
        try {
            String sql1 = "select * from variables where codvar = 1";
            ResultSet rs = acciones.Consultar(sql1);
            while (rs.next()) {
                iva = Integer.parseInt(rs.getString("iva"));
            }
            acciones.conn.close();
            return iva;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return 0;
        }
    }

    public FVentas() {
        this.setlook();
        initComponents();
        setLocationRelativeTo(null);
        txtFecha.setText(fecha.getFecha());
        txtCodigoV.setText(NumeroAleatorio());
        this.txtAuto = new TextAutoCompleter(txtB);
        this.inicializar();
    }

    public void inicializar() {
        try {
            String sql = "select count(codprod) from inventario";
            ResultSet rs = acciones.Consultar(sql);
            while (rs.next()) {
                this.matriz = new int[rs.getInt("count")][2];
            }
            acciones.conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        try {
            int j = 0;
            String sql = "select * from inventario";
            ResultSet rs = acciones.Consultar(sql);
            while (rs.next()) {
                matriz[j][0] = rs.getInt("codprod");
                matriz[j][1] = rs.getInt("canprod");
                j++;
            }
            acciones.conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void setTitle(String title) {
        super.setTitle(title);
        lblTitulo.setText(title);
    }

    public void AddLista(Object x) {
        txtAuto.addItem(x);
    }

    public void setlook() {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void restaurarVentana() {
        if (getExtendedState() == JFrame.MAXIMIZED_BOTH) {//1
            setExtendedState(JFrame.NORMAL);//2
        } else {
            setExtendedState(JFrame.MAXIMIZED_BOTH);//3
        }
    }

    public void Ajustar(JLabel label, ImageIcon icon) {
        //esta funcion ajusta un icono(parametro) al tamaño del label (parametro)
        Icon icono = new ImageIcon(icon.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT));
        label.setIcon(icono);
        this.repaint();
    }

    public String NumeroAleatorio() {
        long numero = 0;
        Random rd = new Random();
        numero = rd.nextInt(9999999) + 1;
        try {
            String sql = "select * from ventas where codven= '" + numero + "'";
            ResultSet rs = acciones.Consultar(sql);
            while (rs.next()) {
                numero = Long.parseLong(this.NumeroAleatorio());
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
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
        bntAñadir = new javax.swing.JButton();
        txtFecha = new javax.swing.JTextField();
        lblTitulo23 = new javax.swing.JLabel();
        lblTitulo24 = new javax.swing.JLabel();
        lblTitulo25 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        lblTitulo26 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        lblTitulo21 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblTitulo22 = new javax.swing.JLabel();
        txtCodigoV = new javax.swing.JTextField();
        lblTitulo13 = new javax.swing.JLabel();
        txtCedula2 = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        cbxPago = new javax.swing.JComboBox<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        lblTitulo35 = new javax.swing.JLabel();
        lblTitulo36 = new javax.swing.JLabel();
        txtTransaccion = new javax.swing.JTextField();
        btnBuscar1 = new javax.swing.JButton();
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

        txtCodigo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtCodigo.setEnabled(false);
        jPanel2.add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 150, -1));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PImagenes/1497379748_edit-clear.png"))); // NOI18N
        jButton3.setText("Cancelar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 400, 100, 30));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PImagenes/agt_action_fail.png"))); // NOI18N
        jButton4.setText("Salir");
        jPanel2.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 400, 100, 30));

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PImagenes/1497479141_list-add.png"))); // NOI18N
        jButton7.setText("Añadir");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 400, 100, 30));

        lblTitulo12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo12.setText("Tipo de Venta");
        jPanel2.add(lblTitulo12, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, 100, 20));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Productos Diponibles", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 0, 12))); // NOI18N
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel25.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        jLabel25.setText("FILTROS:");
        jPanel6.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 20, 60, 20));

        txtB.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        txtB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBActionPerformed(evt);
            }
        });
        txtB.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBKeyTyped(evt);
            }
        });
        jPanel6.add(txtB, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 290, 20));

        jLabel26.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        jLabel26.setText("BUSQUEDA");
        jPanel6.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 60, 20));

        cbxFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Codigo", "Descripcion" }));
        cbxFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxFiltroActionPerformed(evt);
            }
        });
        jPanel6.add(cbxFiltro, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 20, 90, 20));

        bntAñadir.setText("Añadir");
        bntAñadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntAñadirActionPerformed(evt);
            }
        });
        bntAñadir.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                bntAñadirKeyTyped(evt);
            }
        });
        jPanel6.add(bntAñadir, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 20, 70, 20));

        jPanel2.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 650, 50));

        txtFecha.setEditable(false);
        txtFecha.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel2.add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 370, 100, 20));

        lblTitulo23.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo23.setText("Precio");
        jPanel2.add(lblTitulo23, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 370, 70, 20));

        lblTitulo24.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo24.setText("Fecha");
        jPanel2.add(lblTitulo24, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 60, 20));

        lblTitulo25.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo25.setText("Total");
        jPanel2.add(lblTitulo25, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 370, 70, 20));

        txtTotal.setEditable(false);
        txtTotal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel2.add(txtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 370, 90, 20));

        txtPrecio.setEditable(false);
        txtPrecio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel2.add(txtPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 370, 90, 20));

        lblTitulo26.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo26.setText("Cantidad");
        jPanel2.add(lblTitulo26, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 370, 70, 20));

        txtCantidad.setEditable(false);
        txtCantidad.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel2.add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 370, 90, 20));

        jRadioButton1.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Pedido");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 10, -1, -1));

        jRadioButton2.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setSelected(true);
        jRadioButton2.setText("Directa");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jRadioButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, -1, -1));

        lblTitulo21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo21.setText("Cedula");
        jPanel2.add(lblTitulo21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 100, 20));

        txtNombre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtNombre.setEnabled(false);
        jPanel2.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 40, 180, -1));

        lblTitulo22.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo22.setText("Cliente");
        jPanel2.add(lblTitulo22, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 40, 100, 20));

        txtCodigoV.setEditable(false);
        txtCodigoV.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel2.add(txtCodigoV, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 180, -1));

        lblTitulo13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo13.setText("Codigo Venta");
        jPanel2.add(lblTitulo13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 100, 20));

        txtCedula2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtCedula2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCedula2KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCedula2KeyTyped(evt);
            }
        });
        jPanel2.add(txtCedula2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 150, -1));

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PImagenes/1497642935_search_magnifying_glass_find.png"))); // NOI18N
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        btnBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                btnBuscarKeyTyped(evt);
            }
        });
        jPanel2.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 40, 30, 20));

        cbxPago.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cbxPago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Efectivo", "Debito", "Cheque", "Credito", "Transferencia", "Otro" }));
        cbxPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxPagoActionPerformed(evt);
            }
        });
        jPanel2.add(cbxPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 70, 180, 20));

        tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Tipo", "Descripcion", "Precio", "Cantidad", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
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

        jPanel2.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 640, 170));

        lblTitulo35.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo35.setText("Tipo de Pago");
        jPanel2.add(lblTitulo35, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 70, 100, 20));

        lblTitulo36.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo36.setText("Nº Transaccion");
        jPanel2.add(lblTitulo36, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 100, 100, 20));

        txtTransaccion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtTransaccion.setEnabled(false);
        jPanel2.add(txtTransaccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 100, 180, 20));

        btnBuscar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PImagenes/1497642935_search_magnifying_glass_find.png"))); // NOI18N
        btnBuscar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscar1ActionPerformed(evt);
            }
        });
        btnBuscar1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                btnBuscar1KeyTyped(evt);
            }
        });
        jPanel2.add(btnBuscar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, 30, 20));

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

        jPanel3.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 680, 470));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 530));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_jPanel3MousePressed

    private void jPanel3MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseDragged
        Point ubicacion = MouseInfo.getPointerInfo().getLocation();//1
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
        if (cbxFiltro.getSelectedIndex() == 0) {

        }

        if (cbxFiltro.getSelectedIndex() == 3) {
            try {
                String[] titulos = {"Codigo", "Nombre", "Descripcion", "Precio",
                    "Cantidad"};
                String sql = "select * from inventario where descripcion like '" + this.txtB.getText().toLowerCase() + "%'";
                model = new DefaultTableModel(null, titulos);
                ResultSet rs = acciones.Consultar(sql);
                String[] fila = new String[5];
                while (rs.next()) {
                    fila[0] = rs.getString("cod_producto");
                    fila[1] = rs.getString("nombre_producto");
                    fila[2] = rs.getString("descripcion");
//                    fila[3] = format.format(rs.getLong("precio_venta"));
                    fila[4] = rs.getString("cantidad");
                    model.addRow(fila);
                    tbl.setModel(model);

                }
                acciones.conn.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }//GEN-LAST:event_txtBKeyReleased

    private void txtBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBActionPerformed

    private void txtCedula2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedula2KeyPressed

    }//GEN-LAST:event_txtCedula2KeyPressed

    private void txtCedula2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedula2KeyTyped
        char c = evt.getKeyChar();
        /*if (c >= 48 && c <= 57 || c == WCKeyEvent.VK_BACK) {
            //establesco limite
            int lim = txtCedula2.getText().length();
            //cambie este numero que es el limite
            if (this.EventoKeyType(lim, 9)) {
                evt.consume();
                getToolkit().beep();
            }
        } else {
            getToolkit().beep();
            evt.consume();
        }*/
    }//GEN-LAST:event_txtCedula2KeyTyped

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        //    selecciono el codigo del cliente para no tener problemas al no copiar la cedula completa
        if (txtCedula2.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Verifique que no este vacio el campo cedula", "Advertencia", JOptionPane.PLAIN_MESSAGE, iconAd);
        } else {
            this.txtCedula2.setEnabled(false);
            boolean resultado = false;
            int codigo = 0;
            String cedula = this.txtCedula2.getText();
            try {
                String sql = "select * from clientes where cedcli = '" + cedula + "'";
                ResultSet rs = acciones.Consultar(sql);
                while (rs.next()) {
                    resultado = true;
                    codigo = rs.getInt("codcli");
                    txtNombre.setText(rs.getString("nomcli") + " " + rs.getString("apecli"));
                }
                if (resultado == false) {
                    JOptionPane.showMessageDialog(null, "Sin Resultados en la Busqueda", "Advertencia",
                            JOptionPane.PLAIN_MESSAGE, iconAd);
                    this.txtCedula2.setEnabled(true);
                    resultado = false;
                }
                acciones.conn.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al consultar cliente\ncodigo error:" + e.getMessage(),
                        "Error", JOptionPane.PLAIN_MESSAGE, iconError);
            }
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnBuscarKeyTyped

    }//GEN-LAST:event_btnBuscarKeyTyped

    private void cbxPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxPagoActionPerformed
        if (cbxPago.getSelectedIndex() != 0) {
            txtTransaccion.setEnabled(true);
        } else {
            txtTransaccion.setEnabled(false);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxPagoActionPerformed

    private void txtBKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBKeyTyped
        char c = evt.getKeyChar();
        if (c == evt.VK_ENTER) {
            JOptionPane.showMessageDialog(null, "pulso enter");
        } else {
            if (cbxFiltro.getSelectedIndex() == 1) {
                this.LlenarLista(1);
            }
            if (cbxFiltro.getSelectedIndex() == 0) {
                this.LlenarLista(2);
            }
        }

    }//GEN-LAST:event_txtBKeyTyped

    private void txtBKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBKeyPressed

    private void bntAñadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntAñadirActionPerformed
        /*inicio verifcacion de la cantidad*/
        String cantidad;
        boolean entrada = true;
        int cantidadventa=0;
        //obtengo el modelo de la tabla 1 para escribir sobre el
        model = (DefaultTableModel) tbl.getModel();
        do {
            if (entrada) {
                cantidad = JOptionPane.showInputDialog(null, "Seleccione la Cantidad a vender del Producto", "", JOptionPane.QUESTION_MESSAGE);
                entrada = cantidad.matches("\\d{1,6}");
            } else {
                cantidad = JOptionPane.showInputDialog(null, "Seleccione la Cantidad a vender del producto\nEj: 1 Entre el rango de 1 y 999.999", "Validacion", JOptionPane.WARNING_MESSAGE);
                entrada = cantidad.matches("\\d{1,6}");
            }
            if (entrada) {
                if (Integer.parseInt(cantidad) <= 0) {
                    JOptionPane.showMessageDialog(null, "Ingrese una cantidad Mayor a 0", "Error", JOptionPane.PLAIN_MESSAGE, iconError);
                    entrada = false;
                } else {
                    entrada = true;
                }
            }
        } while (!entrada);
        /*fin verifcacion de la cantidad ingresada*/
        boolean productoAñadido = false;
        //compruebo la entrada y consulto para comprobar si existe
        if (entrada && verificacion()) {
                //busco la cantidad basado en el codigo en la matriz
            for (int i = 0; i < matriz.length; i++) {
                    if (matriz[i][0] == codigo) {
                        if (cantidadMinimo<=matriz[i][1]) {
                            cantidadventa  = matriz[i][1]-cantidadMinimo;
                        } else {
                            cantidadventa = matriz[i][1];
                        }
                        break;
                    }
            }
            // <editor-fold desc="CODIGO PARA CUANDO SE VENDA PRODUCTOS BAJO EL MINIMO"> 
                //compruebo si ya se vendio todo los disponible para preguntar si quiere vender bajo el minimo
                if (cantidadventa == 0) {
                     int seleccion = JOptionPane.showOptionDialog(
                            null,
                            "El Producto ha llegado al inventario minimo.\n"
                            + "¿Desea continuar? Tenga en cuenta que puede afectar ventas futuras.",
                            "Selector de opciones",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.PLAIN_MESSAGE,
                            iconAd, // null para icono por defecto.
                            new Object[]{"Si, Estoy consciente", "No."}, // null para YES, NO y CANCEL
                            "No");
                    if (seleccion == 0) {
                        //si asume el riesgo
                        if (Integer.parseInt(cantidad) <= cantidadMinimo) {
                            //ingreso si esta vacio
                            if (tbl.getRowCount() == 0) {
                                row1[0] = String.valueOf(codigo);
                                row1[1] = String.valueOf(tipoProducto);
                                row1[2] = descripcion;
                                row1[3] = String.valueOf(precioProducto);
                                row1[4] = cantidad;
                                row1[5] = String.valueOf(precioProducto * Integer.parseInt(cantidad));
                                model.addRow(row1);
                            } else {
                                //recorro la tabla en busca de registros iguales basado en el codigo
                                for (int i = 0; i < tbl.getRowCount(); i++) {
                                    if (tbl.getValueAt(i, 0).toString().equals(String.valueOf(codigo))) {
                                        tbl.setValueAt(String.valueOf(Integer.parseInt(tbl.getValueAt(i, 4).toString()) + Integer.parseInt(cantidad)), i, 4);
                                        tbl.setValueAt(Float.parseFloat(tbl.getValueAt(i, 3).toString()) * Float.parseFloat(tbl.getValueAt(i, 4).toString()), i, 5);
                                        productoAñadido = true;
                                    }
                                }
                                //añado nuevo producto a la tabla
                                if (productoAñadido == false) {
                                    row1[0] = String.valueOf(codigo);
                                    row1[1] = String.valueOf(tipoProducto);
                                    row1[2] = descripcion;
                                    row1[3] = String.valueOf(precioProducto);
                                    row1[4] = cantidad;
                                    row1[5] = String.valueOf(precioProducto * Integer.parseInt(cantidad));
                                    model.addRow(row1);
                                }
                            }
                            //reinicio la variable
                            productoAñadido = false;
                            //hacemos la resta de la cantidad
                            for (int i = 0; i < matriz.length; i++) {
                                if (matriz[i][0] == codigo) {
                                    matriz[i][1] = cantidadventa ;
                                    break;
                                }
                            }
                            this.Calculos();
                        } else {
                            JOptionPane.showMessageDialog(null, "El producto seleccionado excede la cantidad Disponible", null, JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            //fin de producto bajo inventario
         // </editor-fold>   
            //compruebo si la cantidad que ingreso en el joption es menor a la disponible para la venta
            if (Integer.parseInt(cantidad) <= cantidadventa) {
                cantidadventa=cantidadventa - Integer.parseInt(cantidad);
                //compruebo que diferencia de la cantidad existente y la ingresada en joption sea mayor al inventario minimo
                if (tbl.getRowCount() == 0) {
                        row1[0] = String.valueOf(codigo);
                        row1[1] = String.valueOf(tipoProducto);
                        row1[2] = descripcion;
                        row1[3] = String.valueOf(precioProducto);
                        row1[4] = cantidad;
                        row1[5] = String.valueOf(precioProducto * Integer.parseInt(cantidad));
                        model.addRow(row1);
                    } else {
                        //recorro la tabla en busca de registros iguales basado en el codigo
                        for (int i = 0; i < tbl.getRowCount(); i++) {
                            if (tbl.getValueAt(i, 0).toString().equals(String.valueOf(codigo))) {
                                tbl.setValueAt(String.valueOf(Integer.parseInt(tbl.getValueAt(i, 4).toString()) + Integer.parseInt(cantidad)), i, 4);
                                tbl.setValueAt(Float.parseFloat(tbl.getValueAt(i, 3).toString()) * Float.parseFloat(tbl.getValueAt(i, 4).toString()), i, 5);
                                productoAñadido = true;
                            }
                        }
                        //añado nuevo producto a la tabla si no encontro uno ya insertado
                        if (productoAñadido == false) {
                            row1[0] = String.valueOf(codigo);
                            row1[1] = String.valueOf(tipoProducto);
                            row1[2] = descripcion;
                            row1[3] = String.valueOf(precioProducto);
                            row1[4] = cantidad;
                            row1[5] = String.valueOf(precioProducto * Integer.parseInt(cantidad));
                            model.addRow(row1);
                        }
                    }
                    //reinicio la variable
                    productoAñadido = false;
                    //hacemos la resta de la cantidad
                    for (int i = 0; i < matriz.length; i++) {
                        if (matriz[i][0] == codigo) {
                            matriz[i][1] = cantidadventa ;
                            break;
                        }
                    }
                    this.Calculos();
            }else {
            JOptionPane.showMessageDialog(null, "La cantidad seleccionada excede la cantidad Disponible la cual es: "+cantidadventa, null, JOptionPane.ERROR_MESSAGE);
        }
        } 
    }//GEN-LAST:event_bntAñadirActionPerformed

    private void bntAñadirKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bntAñadirKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_bntAñadirKeyTyped

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        txtCodigo.setEnabled(true);
        txtCedula2.setEnabled(false);
        btnBuscar.setEnabled(false);
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        txtCodigo.setEnabled(false);
        txtNombre.setText("");
        txtTransaccion.setText("");
        txtCedula2.setEnabled(true);
        btnBuscar.setEnabled(true);
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void btnBuscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscar1ActionPerformed

    private void btnBuscar1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnBuscar1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscar1KeyTyped

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        txtCodigo.setEnabled(false);
        txtCedula2.setEnabled(true);
        btnBuscar.setEnabled(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    public void LlenarLista(int x) {
        txtAuto.removeAllItems();
        switch (x) {
            case 1:
                try {
                    String sql = "select * from inventario";
                    ResultSet rs = acciones.Consultar(sql);
                    String[] fila = new String[5];
                    while (rs.next()) {
                        this.AddLista(rs.getString("desprod"));
                    }
                    acciones.conn.close();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
                break;
            case 2:
                try {
                    String sql = "select * from inventario";
                    ResultSet rs = acciones.Consultar(sql);
                    String[] fila = new String[5];
                    while (rs.next()) {
                        this.AddLista(rs.getString("codprod"));
                    }
                    acciones.conn.close();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
                break;

            default:
                throw new AssertionError();
        }

    }

    public void Calculos() {
        float total = 0, cantidad = 0, iva = getIva();
        for (int i = 0; i < model.getRowCount(); i++) {
            total += Float.parseFloat(model.getValueAt(i, 5).toString());
            cantidad += Integer.parseInt(model.getValueAt(i, 4).toString());
        }
        txtCantidad.setText(String.valueOf(cantidad));
        txtTotal.setText(String.valueOf(total));
        float subtotal = (total / (1 + (iva / 100)));
        txtPrecio.setText(String.valueOf(subtotal));
    }

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
    private javax.swing.JButton bntAñadir;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnBuscar1;
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbxFiltro;
    private javax.swing.JComboBox<String> cbxPago;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
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
    private javax.swing.JTextField jTextField21;
    private javax.swing.JTextField jTextField22;
    private javax.swing.JTextField jTextField23;
    private javax.swing.JTextField jTextField24;
    private javax.swing.JTextField jTextField25;
    private javax.swing.JTextField jTextField27;
    private javax.swing.JTextField jTextField28;
    private javax.swing.JTextField jTextField29;
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
    private javax.swing.JLabel lblTitulo33;
    private javax.swing.JLabel lblTitulo34;
    private javax.swing.JLabel lblTitulo35;
    private javax.swing.JLabel lblTitulo36;
    private javax.swing.JTable tbl;
    private javax.swing.JTable tbl1;
    private javax.swing.JTextField txtB;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCedula2;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtCodigoV;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtTransaccion;
    // End of variables declaration//GEN-END:variables

    private boolean verificacion() {
        boolean resultado = false;
        //Vericacion que lo escrito en busqueda este en la bd
        if (cbxFiltro.getSelectedIndex() == 0) {
            try {
                String sql = "select * from inventario "
                        + "inner join tipoproducto on tippro=codtip "
                        + "inner join proveedores on inventario.codpro = proveedores.codpro "
                        + "where codprod = '" + txtB.getText() + "'";
                ResultSet rs = acciones.Consultar(sql);
                while (rs.next()) {
                    codigo = rs.getInt("codprod");
                    descripcion = rs.getString("desprod");
                    tipoProducto = rs.getString("tipprod");
                    cantidadProducto = rs.getInt("canprod");
                    precioProducto = rs.getLong("preprod");
                    cantidadMaximo = rs.getInt("maxprod");
                    cantidadMinimo = rs.getInt("minprod");
                    codigoProveedor = rs.getString("codpro");
                    resultado = true;
                }
                acciones.conn.close();
                if (!resultado) {
                    resultado = false;
                    JOptionPane.showInputDialog(null, "Sin Resultados en la Busqueda", "Validacion", JOptionPane.WARNING_MESSAGE);
                }
            } catch (SQLException e) {
                resultado = false;
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.PLAIN_MESSAGE, iconError);
            }
        } else if (cbxFiltro.getSelectedIndex() == 1) {
            try {
                String sql = "select * from inventario "
                        + "inner join tipoproducto on tippro=codtip "
                        + "inner join proveedores on inventario.codpro = proveedores.codpro "
                        + "where desprod = '" + txtB.getText() + "'";
                ResultSet rs = acciones.Consultar(sql);
                String[] fila = new String[6];
                while (rs.next()) {
                    codigo = rs.getInt("codprod");
                    descripcion = rs.getString("desprod");
                    tipoProducto = rs.getString("tipprod");
                    cantidadProducto = rs.getInt("canprod");
                    precioProducto = rs.getLong("preprod");
                    cantidadMaximo = rs.getInt("maxprod");
                    cantidadMinimo = rs.getInt("minprod");
                    codigoProveedor = rs.getString("codpro");
                    resultado = true;
                }
                acciones.conn.close();
                if (!resultado) {
                    JOptionPane.showInputDialog(null, "Sin Resultados en la Busqueda", "Validacion", JOptionPane.WARNING_MESSAGE);
                    resultado = false;
                }
            } catch (SQLException e) {
                resultado = false;
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.PLAIN_MESSAGE, iconError);
            }
        }
        return resultado;
    }
}
